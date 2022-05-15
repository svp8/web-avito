package com.example.webAvito.models;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int userIdFrom;
    @Column(nullable = false)
    private int userIdTo;
    private String userName;
    private int postId;
    private String date;
    @Column(length = 400)
    private String message;
    public Message() {
    }
    public Message( int userIdFrom, int userIdTo, int postId, String date, String message,String userName) {
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
        this.postId = postId;
        this.date = date;
        this.message = message;
        this.userName=userName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserIdFrom() {
        return userIdFrom;
    }
    public void setUserIdFrom(int userIdFrom) {
        this.userIdFrom = userIdFrom;
    }
    public int getUserIdTo() {
        return userIdTo;
    }
    public void setUserIdTo(int userIdTo) {
        this.userIdTo = userIdTo;
    }
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


}
