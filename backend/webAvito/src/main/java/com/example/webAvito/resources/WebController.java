package com.example.webAvito.resources;


import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WebController {
    @RequestMapping("/test")
    public String home(Model model) {
        model.addAttribute("greeting", "hello world");
        return "home";
    }
}
