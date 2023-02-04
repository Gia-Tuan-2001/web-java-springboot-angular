package com.example.backend.services.comment;

import com.example.backend.entities.Comment;
import com.example.backend.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements  CommentService{
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment insertOne(Comment cmt) {
        return commentRepository.save(cmt);
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).get();
    }


    @Override
    public boolean deleteOne(int id) {
        Comment cmt = findById(id);
        if (cmt != null) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
