package com.example.webAvito.repos;
import java.util.List;

import com.example.webAvito.models.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MessageRepo extends JpaRepository<Message,Integer> {
    public List<Message> findByPostId(int postId);
    public List<Message> findByUserIdTo(int userIdTo);
}
