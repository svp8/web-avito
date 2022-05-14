package com.example.webAvito.models;

import org.springframework.web.multipart.MultipartFile;

public class Photo {
    private MultipartFile photo;

    public Photo(MultipartFile photo) {
        this.photo = photo;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
