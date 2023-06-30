package com.example.demo.serviceImpl;

import com.example.demo.dto.GroupDTO;
import com.example.demo.model.Groupp;
import com.example.demo.repository.GroupInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

@Primary
public class GroupServiceImpl {
    @Autowired
    private GroupInterface groupInterface;
    public List<Groupp> findAll() {

        return  this.groupInterface.findAllByDeleted(false);


    }
    public void save(Groupp dt) {
        this.groupInterface.save(dt);
    }
    public void delete( Long Id) {
        Groupp grupa =  this.groupInterface.findFirstById(Id);
        grupa.setDeleted(true);
        this.groupInterface.save(grupa);

    }
    public Groupp getOne(Long Id) {
        return this.groupInterface.findFirstById(Id);


    }
    public Groupp createGroup(GroupDTO dto, long a) {

        Optional<Groupp> group = groupInterface.findFirstByNameAndDeleted(dto.getName(),false);

        if(group.isPresent()){
            return null;
        }

        Groupp groupa = new Groupp();
        groupa.setName(dto.getName());
        groupa.setDate(LocalDateTime.now());
        groupa.setDescription(dto.getDescription());
        groupa.setGroupAdmin(a);
        groupa.setDeleted(false);
        groupa = groupInterface.save(groupa);


        return groupa;
    }
}
