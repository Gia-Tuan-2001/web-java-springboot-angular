package com.example.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "comment")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int comment_id;

    @Column(name = "account_id")
    private int account_id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "product_id")
    private int product_id;

    @Column(name = "star")
    private int star;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;
}
