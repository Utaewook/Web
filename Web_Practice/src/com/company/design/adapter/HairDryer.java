package com.company.design.adapter;

public class HairDryer implements Electronic_220{
    @Override
    public void connect() {
        System.out.println("HairDryer ON");
    }
}
