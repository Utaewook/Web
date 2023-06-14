package com.example.AOP.controller;

import com.example.AOP.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable long id, @RequestParam String name){
        System.out.println("get Method");
        System.out.println("get Method : "+id);
        System.out.println("get Method : "+name);
        return id+" "+ name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        System.out.println("post method");
        System.out.println("post method : "+user);
        return user;
    }
}
