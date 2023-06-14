package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 해당 클래스는 rest api를 처리하는 Controller
@RequestMapping("/api")  // RequestMapping URI를 지정해주는 annotation
public class ApiController {
    @GetMapping("/hello")  // http://localhost:8080/api/hello
    public String hello(){
        return "hello spring boot!";
    }

    // Text
    @GetMapping("/text")
    public String text(@RequestParam String account){
        System.out.println(account);
        return account;
    }

    //Json
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public UserDTO json(@RequestBody UserDTO dto){
        return dto; // 200 OK
    }

    //ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<UserDTO> put(@RequestBody UserDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
