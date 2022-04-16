package com.example.webAvito.services;

import java.util.List;

import com.example.webAvito.models.Post;
import com.example.webAvito.repos.PostRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepo postRepo;
    
    public List<Post> getAll(){
        return postRepo.findAll();
    }
    public Post savePost(Post post){
        return postRepo.save(post);
    }
    public void deletePost(int postId){
         postRepo.deleteById(postId);
    }
    public List<Post> getAllByUser(int userId){
        return postRepo.findByUserId(userId);
    }
    
}
