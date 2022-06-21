package com.example.demo.mapper;

import com.example.demo.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestMapper {


    void saveUser(User user);
    
    User findById(@Param("id") Long id);
    
}
