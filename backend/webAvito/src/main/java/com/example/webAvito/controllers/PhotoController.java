package com.example.webAvito.controllers;

import java.io.File;

import com.example.webAvito.models.Photo;
import com.example.webAvito.models.User;
import com.example.webAvito.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    UserService userService;

    @PostMapping("/user/{id}")
    public User loadPhoto(@RequestBody MultipartFile photo, @PathVariable(name = "id") int id) {
        String fileName = photo.getOriginalFilename();
        try {
            userService.updateUserPhoto(fileName, id);
            photo.transferTo(new File("C://Users/pwx1133753/web-avito/src/assets/"+fileName));
        } catch (Exception e) {
           System.out.println(e);
        }
        return userService.updateUserPhoto(fileName, id);
    }
}
