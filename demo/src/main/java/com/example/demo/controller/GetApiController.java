package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path="/hello")
    public String hello(){
        return "get Hello";
    }

    @RequestMapping(value = "/hi",method = RequestMethod.GET) // get, post, put, delete 동작
    public String hi(){
        return "get hi";
    }


    // path variable
    // http://localhost:8080/api/get/path-variable{name}  annotation과 변수의 이름을 똑같이 맞추어 줘야함
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable = "+pathName);
        return pathName;
    }


    // Query Parameter
    // format은 다음과 같음
    // [query] ? key1 = value1 & key2 = value2 & key3 = value3 ...
    // http://localhost:8080/api/get/query-param?user=steve&email=steve@naver.com&age=39
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" - "+entry.getValue()+"\n");
        });
        return sb.toString();
    }


    // http://localhost:8080/api/get/query-param02?user=marie&email=marie@google.com&age=34
    @GetMapping(path = "/query-param02")
    public String queryParam2(
            @RequestParam String user,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(user);
        System.out.println(email);
        System.out.println(age);

        return user+" "+email+" "+age;
    }

    // http://localhost:808/api/get/query-param03?user=marie&email=marie@google.com&age=34
    @GetMapping(path = "/query-param03")
    public String queryParam3(UserRequest userRequest){
        System.out.println(userRequest.getUser());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
