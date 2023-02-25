package com.tms.springboot.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String commentText;

    public Comment(String title, String commentText) {
        this.title = title;
        this.commentText = commentText;
    }
}
