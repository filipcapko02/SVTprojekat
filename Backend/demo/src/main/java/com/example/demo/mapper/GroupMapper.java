package com.example.demo.mapper;
//
//import com.example.demo.dto.GroupDTO;
//import com.example.demo.model.Groupp;
//import com.example.demo.model.Post;
//import org.mapstruct.InheritInverseConfiguration;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface GroupMapper {
//    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(group.getPosts()))")
//    GroupDTO mapGroupToDto(Groupp groupp);
//
//    default Integer mapPosts(List<Post> numberOfPosts) {
//        return numberOfPosts.size();
//    }
//
//    @InheritInverseConfiguration
//    @Mapping(target = "posts", ignore = true)
//    Groupp mapDtoToGroup(GroupDTO groupDto);
//}
