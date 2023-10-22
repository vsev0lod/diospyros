package com.diospyros.uplift.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String redirectLogin() {
        return "redirect:/auth/login";
    }
}
