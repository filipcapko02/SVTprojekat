package com.example.demo.dto;

import com.example.demo.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private String user;
    private String text;
    private String dat;
    private Long id;
    private int like;
    private int dislike;
    private Set<Comment> comments;
}
