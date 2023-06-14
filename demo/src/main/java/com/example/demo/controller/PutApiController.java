package com.example.demo.controller;

import com.example.demo.dto.PutRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put/{userId}")
    public PutRequestDTO put(@RequestBody PutRequestDTO dto, @PathVariable(name = "userId") Long id){
        System.out.println(dto.toString());
        System.out.println(id);
        return dto;
    }
}
