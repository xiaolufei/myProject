package com.testssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController extends BaseController {


    @RequestMapping("/index")
    public String index(Model model) {

        return "login";
    }


}
