package com.example.webAvito.services;

import java.util.List;
import java.util.Optional;

import com.example.webAvito.models.User;
import com.example.webAvito.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService  {
    @Autowired
    UserRepo userRepo;

    public User updateUser(User user) throws Exception{
        User user1=userRepo.findByEmail(user.getEmail());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName()); 
        user1.setPhone(user.getPhone());
        return userRepo.save(user1);
    }
    public User updateUserPhoto(String filename,int id) {
        User user1=userRepo.findById(id).get();
        user1.setPhoto(filename);
        return userRepo.save(user1);
    }

    public User registerUser(User user) throws Exception{
        if(userRepo.findByEmail(user.getEmail())==null){
            return userRepo.save(user);
        }
        throw new Exception("Already exist");
    }
    public List<User> getAll(){
        return userRepo.findAll();
    }
    public Optional<User> getById(int id){
        return userRepo.findById(id);
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
