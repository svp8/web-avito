package com.example.webAvito.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WebController {
    @GetMapping("/test")
    public String home(Model model) {
        model.addAttribute("greeting", "hello world");
        return "home";
    }
}
