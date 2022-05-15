package com.example.webAvito.services;

import java.util.List;

import com.example.webAvito.models.Message;
import com.example.webAvito.repos.MessageRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MessageRepo messageRepo;
    
    public List<Message> getAllByUser(int userIdTo){
        return messageRepo.findByUserIdTo(userIdTo);
    }
    public Message saveMessage(Message message){
        return messageRepo.save(message);
    }
    public void deletePost(int messageId){
        messageRepo.deleteById(messageId);
    }
    public List<Message> getAllByPostId(int postId){
        return messageRepo.findByPostId(postId);
    }
}
