package com.shopfreelancer.securitydemo.controllers;

import com.shopfreelancer.securitydemo.domain.Role;
import com.shopfreelancer.securitydemo.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
