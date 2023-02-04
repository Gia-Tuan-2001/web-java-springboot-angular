package com.example.backend.services.comment;

import com.example.backend.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment findById(int id);
    Comment insertOne(Comment cmt);
    boolean deleteOne(int id);
}
