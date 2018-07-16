package com.testssm.controller;

import com.testssm.entity.User;
import com.testssm.service.UserService;
import com.testssm.utils.ImageVerifyCode;
import com.testssm.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("username","qq");
        User user = new User();
        user.setId(StringUtil.getUUID());
        user.setUserName("qq");
        user.setPassWord("123456");
        user.setAge(24);
        user.setDescription("eqwdsdfascsafsdf");
        userService.insert(user);
        logger.info("测试日志打印{}",new Date().getTime());
        redisTemplate.opsForValue().set("chen", "陈梓平");
        logger.info("value："+redisTemplate.opsForValue().get("chen"));
        return "index";
    }

    @RequestMapping("/imageVerifyCode")
    public void generateVerifyCode(HttpServletResponse response) throws IOException {
        String verifyCode = ImageVerifyCode.getVerifyCode(4);
        ImageVerifyCode.flushVerifyCode(response, verifyCode);
        if(logger.isDebugEnabled()) {
            logger.debug("The imageVerifyCode is: " + verifyCode);
        }
    }


}
