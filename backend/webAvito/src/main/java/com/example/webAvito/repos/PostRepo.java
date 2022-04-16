package com.example.webAvito.repos;
import java.util.List;

import com.example.webAvito.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostRepo extends JpaRepository<Post,Integer>{
    public List<Post> findByUserId(int userId);
}
