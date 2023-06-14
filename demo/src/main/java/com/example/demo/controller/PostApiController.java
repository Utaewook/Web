package com.example.demo.controller;

import com.example.demo.dto.PostUserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api_post")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData){
        requestData.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @PostMapping("/post01")
    public void post01(@RequestBody PostUserDTO dto){
        System.out.println(dto.toString());
    }
}
