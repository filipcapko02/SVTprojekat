//package com.example.demo.mapper;
//
//import com.example.demo.dto.PostRequest;
//import com.example.demo.dto.PostResponse;
//import com.example.demo.model.*;
//import com.example.demo.repository.CommentInterface;
//import com.example.demo.repository.LikeInterface;
//import com.github.marlonlom.utilities.timeago.TimeAgo;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import static com.example.demo.model.LikeType.DISLIKE;
//import static com.example.demo.model.LikeType.LIKE;
//
//import java.util.Optional;
//@Mapper(componentModel = "spring")
//public abstract class PostMapper {
//
//    @Autowired
//    private CommentInterface commentInterface;
//    @Autowired
//    private LikeInterface likeInterface;
//    @Autowired
//    private AuthService authService;
//
//
//    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
//    @Mapping(target = "description", source = "postRequest.description")
//    @Mapping(target = "group", source = "group")
//    @Mapping(target = "likeCount", constant = "0")
//    @Mapping(target = "user", source = "user")
//    public abstract Post map(PostRequest postRequest, Groupp groupp, User user);
//
//    @Mapping(target = "id", source = "postId")
//    @Mapping(target = "groupName", source = "group.name")
//    @Mapping(target = "userName", source = "user.username")
//    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
//    @Mapping(target = "duration", expression = "java(getDuration(post))")
//    @Mapping(target = "upLike", expression = "java(isPostUpLiked(post))")
//    @Mapping(target = "downLike", expression = "java(isPostDownLiked(post))")
//    public abstract PostResponse mapToDto(Post post);
//
//    Integer commentCount(Post post) {
//        return commentInterface.findByPost(post).size();
//    }
//
//    String getDuration(Post post) {
//        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
//    }
//
//    boolean isPostUpLiked(Post post) {
//        return checkLikeType(post, LIKE);
//    }
//
//    boolean isPostDownLiked(Post post) {
//        return checkLikeType(post, DISLIKE);
//    }
//
//    private boolean checkLikeType(Post post, LikeType likeType) {
//        if (authService.isLoggedIn()) {
//            Optional<Likee> voteForPostByUser =
//                    likeInterface.findTopByPostAndUserOrderByLikeIdDesc(post,
//                            authService.getCurrentUser());
//            return voteForPostByUser.filter(vote -> vote.getLikeType().equals(likeType))
//                    .isPresent();
//        }
//        return false;
//    }
//
//}
