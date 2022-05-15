package com.example.webAvito.controllers;

import java.util.List;

import com.example.webAvito.models.Message;
import com.example.webAvito.services.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/post/{id}")
    public List<Message> getAllPostMessages(@PathVariable(name = "id") int id) {
        return messageService.getAllByPostId(id);
    }

    @GetMapping("/user/{id}")
    public List<Message> getAllMessagesByUser(@PathVariable(name = "id") int id) {
        return messageService.getAllByUser(id);
    }

    @PostMapping("/create")
    public Message createPost(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

}
