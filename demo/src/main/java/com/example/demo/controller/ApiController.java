package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 클래스는 rest api를 처리하는 Controller
@RequestMapping("/api")  // RequestMapping URI를 지정해주는 annotation
public class ApiController {
    @GetMapping("/hello")  // http://localhost:8080/api/hello
    public String hello(){
        return "hello spring boot!";
    }
}
