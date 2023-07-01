package com.example.demo.service.serviceImpl;

import com.example.demo.model.Likee;
import com.example.demo.repository.LikeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

@Primary
public class LikeService {
    @Autowired
    private LikeInterface likeInterface;

    public Optional<Likee> GetOneById(Long id) {

        return  this.likeInterface.findById(id);


    }
    public void save(Likee dt) {
        this.likeInterface.save(dt);
    }
}

