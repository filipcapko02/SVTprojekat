package com.example.demo.mapper;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import com.example.demo.dto.CommentsDTO;
//import com.example.demo.model.Comment;
//import com.example.demo.model.Post;
//import com.example.demo.model.User;
//
//@Mapper(componentModel = "spring")
//public interface CommentMapper {
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "text", source = "commentsDto.text")
//    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
//    @Mapping(target = "post", source = "post")
//    @Mapping(target = "user", source = "user")
//    Comment map(CommentsDTO commentsDAO, Post post, User user);
//
//    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
//    @Mapping(target = "userName", expression = "java(comment.getUser().getUsername())")
//    CommentsDTO mapToDto(Comment comment);
//}

