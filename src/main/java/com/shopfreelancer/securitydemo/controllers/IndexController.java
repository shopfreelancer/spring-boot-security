package com.shopfreelancer.securitydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", ""})
    public String index(){
        return "index";
    }

    @GetMapping("/access_denied")
    public String notAuth(){
        return "no-access";
    }

    @GetMapping("login")
    public String loginForm(){
        return "login";
    }
}
