package com.example.backend.controller;

import com.example.backend.entities.Comment;
import com.example.backend.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/comment") // router
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> getList() {
        try {
            List<Comment> list = commentService.findAll();
            return list;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Comment save(@RequestBody Comment cmt) {
        try {
            cmt.setComment_id(0);
            cmt.setCreated_at(new Date());
            commentService.insertOne(cmt);
            return cmt;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        try {
            Boolean rs = false;
            if (commentService.deleteOne(id)) {
                rs = true;
            }
            return rs;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
