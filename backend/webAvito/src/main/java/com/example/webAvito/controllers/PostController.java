package com.example.webAvito.controllers;

import java.util.List;

import com.example.webAvito.models.Post;
import com.example.webAvito.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAll();
    }
    @GetMapping("/all/{id}")
    public List<Post> getAllUserPosts(@PathVariable(name = "id") int id) {
        return postService.getAllByUser(id);
    }
    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable(name = "id") int post) {
        postService.deletePost(post);
    }
}
