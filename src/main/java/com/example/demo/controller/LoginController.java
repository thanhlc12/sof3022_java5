package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "/form.html";
    }

    @PostMapping("/login")
    public String login(LoginRequest loginRequest, Model model) {
        model.addAttribute("user", loginRequest.getUsername());
        model.addAttribute("pass", loginRequest.getPassword());
        return "/thong-tin.html";
    }
}
