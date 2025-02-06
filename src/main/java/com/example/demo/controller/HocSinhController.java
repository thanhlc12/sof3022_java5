package com.example.demo.controller;

import com.example.demo.model.HocSinh;
import com.example.demo.repository.HocSinhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/hoc-sinh/add")
    public String add(HocSinh hocSinh) {
        hocSinhRepo.save(hocSinh);
        return "redirect:/hoc-sinh/hien-thi";
    }

    @GetMapping("/hoc-sinh/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        hocSinhRepo.deleteById(id);
        return "redirect:/hoc-sinh/hien-thi";
    }

    @GetMapping("/hoc-sinh/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        HocSinh hocSinh = hocSinhRepo.findById(id).get();
        model.addAttribute("hocSinh", hocSinh);
        return "/detail.html";
    }
}
