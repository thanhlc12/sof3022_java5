package com.example.demo.controller;

import com.example.demo.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/user/hien-thi")
    public String hienThi(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("message","Enter");
        return "/user.html";
    }

    @PostMapping("/user/save")
    public String save(Model model, @ModelAttribute("user") @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Validation failed");
            return "/user.html";
        }
        model.addAttribute("message", "User saved successfully");
        System.out.println(user.toString());
        return "/form-user.html";
    }
}
