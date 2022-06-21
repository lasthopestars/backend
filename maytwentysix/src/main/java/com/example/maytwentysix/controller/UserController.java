package com.example.maytwentysix.controller;

import com.example.maytwentysix.entity.User;
import com.example.maytwentysix.mapper.TestMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class UserController {
    private final TestMapper mapper;

    @GetMapping("/users/{id}")//조회
    public User findUser(@PathVariable Long id){
        return mapper.findById(id);
    }

    @PostMapping("/users")//삽입
    public String saveUser(@RequestBody User user){
        mapper.saveUser((user));
        return "ok";
    }

    @PostMapping("/users/update/{id}/{name}")//삽입
    public String updateUser(@PathVariable Long id,@PathVariable String name){
        int result=mapper.update(id,name);
        return result==1 ? "ok" : "false";  
        //1개가 바뀌면 제대로 업뎃이 된 거니까, 아니면 false.
    }
    

}
