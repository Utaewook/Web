package com.example.demo.dto;

public class UserRequest {
    private String user;
    private String email;
    private int age;

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
