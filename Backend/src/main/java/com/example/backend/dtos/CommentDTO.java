package com.example.backend.dtos;

import com.example.backend.entities.Comment;
import com.example.backend.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentDTO extends Comment {
    private String user_name;
}
