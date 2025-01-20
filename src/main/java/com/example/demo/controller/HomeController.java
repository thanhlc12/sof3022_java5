package com.example.demo.controller;

import com.example.demo.model.SinhVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("hoTen", "Nguyen Van A");
        model.addAttribute("tuoi", "19");
        model.addAttribute("gioiTinh", "Nam");
        System.out.println("da chay vao get");
        return "home.html";
    }

//    @PostMapping("/login")
//    public void login() {
//        System.out.println("da chay vao post");
//    }

    @GetMapping("/click")
    public String click(Model model) {
        model.addAttribute("message", "forward");
        return "forward:/forward";
    }

    @GetMapping("/forward")
    public String forward () {
        return "/forward.html";
    }

    @GetMapping("/click/redirect")
    public String clickRedirect(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("message", "redirect");
        return "redirect:/redirect";
    }

    @GetMapping("/redirect")
    public String redirect(Model model,
                           @RequestParam("message") String message) {
        model.addAttribute("message", message);
        return "/redirect.html";
    }

    @GetMapping("/sinh-vien")
    public String sinhVien(Model model) {
        SinhVien sinhVien = SinhVien.builder().fullname("Nguyen Van A")
                .age(20)
                .address("Ha Noi").build();
        model.addAttribute("sinhVien", sinhVien);
        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(new SinhVien("Nguyen Van B", 20, "Nam Dinh"));
        listSinhVien.add(new SinhVien("Nguyen Van C", 20, "Nam Dinh"));
        listSinhVien.add(new SinhVien("Nguyen Van D", 20, "Nam Dinh"));
        listSinhVien.add(new SinhVien("Nguyen Van E", 20, "Nam Dinh"));
        model.addAttribute("list", listSinhVien);
        return "/sinh-vien.html";
    }
}

