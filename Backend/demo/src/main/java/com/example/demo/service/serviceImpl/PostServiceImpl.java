package com.example.demo.service.serviceImpl;
import com.example.demo.dto.PostDTO;
import com.example.demo.model.LikeType;
import com.example.demo.model.Likee;
import com.example.demo.model.Post;
import com.example.demo.repository.PostInterface;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service

@Primary
public class PostServiceImpl {
    @Autowired
    private UserService userService;
    @Autowired
    private PostInterface postInterface;
    public Post createGroup(String  dto, long a) {


        Post post1 = new Post();
        post1.setText(dto);
        post1.setDate(LocalDateTime.now());
        post1.setUser(a);
        post1.setDeleted(false);
        post1 = postInterface.save(post1);
        return post1;
    }
    public void delete( Long Id) {
        Post grupa =  this.postInterface.findFirstById(Id);
        grupa.setDeleted(true);
        this.postInterface.save(grupa);

    }
    public Post getOne(Long Id) {
        return this.postInterface.findFirstById(Id);


    }
    public Post save(Post pp) {
        return this.postInterface.save(pp);


    }
    public List<PostDTO> getAll(long a) {

        List<PostDTO> dtos= new ArrayList<PostDTO>();
        List<Post> posts = postInterface.findAllByUserAndDeleted(a,false);
        for ( Post aa: posts
        ) {
            PostDTO nesto = new PostDTO();

            if (userService.findOne(aa.getUser()).getDisplayName() == null || userService.findOne(aa.getUser()).getDisplayName().length() == 0)
                nesto.setUser(userService.findOne(aa.getUser()).getFirstname());
            else
                nesto.setUser(userService.findOne(aa.getUser()).getDisplayName());
            nesto.setText(aa.getText());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            String formatDateTime = aa.getDate().format(formatter);
            nesto.setDat(formatDateTime);
            nesto.setId(aa.getId());
            dtos.add(nesto);
        }
        return dtos;
    }
    public List<PostDTO> getAllAll() {

        List<PostDTO> dtos= new ArrayList<PostDTO>();
        List<Post> posts = postInterface.findAllByDeleted(false);
        for ( Post aa: posts
        ) {
            PostDTO nesto = new PostDTO();

            if (userService.findOne(aa.getUser()).getDisplayName() == null || userService.findOne(aa.getUser()).getDisplayName().length() == 0)
                nesto.setUser(userService.findOne(aa.getUser()).getFirstname());
            else
                nesto.setUser(userService.findOne(aa.getUser()).getDisplayName());
            nesto.setText(aa.getText());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            String formatDateTime = aa.getDate().format(formatter);
            nesto.setDat(formatDateTime);
            nesto.setId(aa.getId());
            for (Likee b: aa.getLikes())
            {
                if(b.getType()== LikeType.LIKE) nesto.setLike(nesto.getLike()+1);
                if(b.getType()== LikeType.DISLIKE) nesto.setDislike(nesto.getDislike()+1);

            }
            nesto.setComments( aa.getComments());
            dtos.add(nesto);
        }
        return dtos;
    }
}