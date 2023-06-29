package com.example.demo.dto;

import com.example.demo.model.LikeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto {
    private LikeType voteType;
    private Long postId;
}

