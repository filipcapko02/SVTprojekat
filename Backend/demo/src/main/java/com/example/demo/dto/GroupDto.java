package com.example.demo.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDto {
    private Long id;
    @NotBlank(message = "Group name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    private Integer numberOfPosts;
}
