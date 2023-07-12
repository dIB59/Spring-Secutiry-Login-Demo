package com.security.authlogin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Home";
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal OAuth2User user) {
        String userName = user.getAttributes().get("name").toString();
        System.out.println(user.getAuthorities());
        return "Welcome " + userName;
    }
}
