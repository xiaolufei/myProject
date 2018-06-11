package com.testssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Controller
@RequestMapping("/")
public class IndexController extends BaseController {


    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("username","qq");
        logger.info("测试日志打印{}",new Date().getTime());
        return "index";
    }


}
