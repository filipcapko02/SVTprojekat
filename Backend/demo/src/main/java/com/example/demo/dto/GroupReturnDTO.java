package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupReturnDTO {

    private Long id;
    private String name;
    private String description;
    private String date;
}
