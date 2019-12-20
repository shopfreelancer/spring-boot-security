package com.shopfreelancer.securitydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/protected")
public class ProtectedController {
    @GetMapping
    public String index(){
        return "protected/index";
    }
}
