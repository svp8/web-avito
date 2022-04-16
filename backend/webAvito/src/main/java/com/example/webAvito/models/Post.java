package com.example.webAvito.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name= "user_id",nullable = false)
    private int userId;
    @Column(nullable = false)
    private String title;
    private String description;
    private int price;
    private String photo;
    private String date;
    private String category;
    public Post(){
        
    }
    public Post(int id, int user_id, String title, String description, int price, String photo, String date,
            String category) {
        this.id = id;
        this.userId = user_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.date = date;
        this.category = category;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUser_id() {
        return userId;
    }
    public void setUser_id(int user_id) {
        this.userId = user_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
