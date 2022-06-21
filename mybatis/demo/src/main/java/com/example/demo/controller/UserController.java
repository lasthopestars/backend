package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.TestMapper;

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

    @GetMapping("/users/{id}") //users/2
    public User findUser(@PathVariable Long id){
        return mapper.findById(id);
    }
    
    @PostMapping("/users")
    public String saveUser(@RequestBody User user){
        mapper.saveUser(user);
        return "ok";
    }

}
