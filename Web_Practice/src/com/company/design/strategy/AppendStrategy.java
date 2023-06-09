package com.company.design.strategy;

public class AppendStrategy implements EncodingStrategy{
    @Override
    public String encodeing(String text) {
        return text+"appended_string";
    }
}
