package com.testssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/index")
    public String index(Model model) {
        logger.debug("日志测试{}",new Date().getTime());
        return "login";
    }


}
