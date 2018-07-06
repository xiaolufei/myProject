package com.testssm.controller;

import com.testssm.utils.ImageVerifyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("username","qq");
        logger.info("测试日志打印{}",new Date().getTime());
        return "login";
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
