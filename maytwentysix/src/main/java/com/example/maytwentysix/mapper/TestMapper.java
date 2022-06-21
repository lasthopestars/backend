package com.example.maytwentysix.mapper;


import com.example.maytwentysix.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestMapper {
    void saveUser(User user);
    User findById(@Param("id") Long id);
    int update(@Param("id")Long id,@Param("name")String name);
}
