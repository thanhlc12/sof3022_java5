package com.example.demo.controller;

import com.example.demo.model.HocSinh;
import com.example.demo.repository.HocSinhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HocSinhController {
    @Autowired
    HocSinhRepo hocSinhRepo;

    @GetMapping("/hoc-sinh/hien-thi")
    public String home(Model model) {
        List<HocSinh> list = hocSinhRepo.findAll();
        model.addAttribute("list", list);
        for (HocSinh hocSinh : list) {
            System.out.println(hocSinh.toString());
        }
        return "/home.html";
    }
}
