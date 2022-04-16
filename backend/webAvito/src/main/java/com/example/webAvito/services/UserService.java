package com.example.webAvito.services;

import java.util.List;

import com.example.webAvito.models.User;
import com.example.webAvito.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService  {
    @Autowired
    UserRepo userRepo;

    public User registerUser(User user) throws Exception{
        if(userRepo.findByEmail(user.getEmail())==null){
            return userRepo.save(user);
        }
        throw new Exception("Already exist");
    }
    public List<User> getAll(){
        return userRepo.findAll();
    }
    public User checkLogin(User user) throws Exception{
        User userTemp=userRepo.findByEmail(user.getEmail());
        if(userTemp!=null&&userTemp.getPassword().equals(user.getPassword())){
            return userTemp;
        }
        else{
            throw new Exception();
        }
        
    }
}
