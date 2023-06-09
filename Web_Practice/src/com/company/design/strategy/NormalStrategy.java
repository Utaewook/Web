package com.company.design.strategy;

public class NormalStrategy implements EncodingStrategy{
    @Override
    public String encodeing(String text) {
        return text;
    }
}
