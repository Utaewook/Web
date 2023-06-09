package com.company.design.facade;

public class Reader {
    private String filename;

    public Reader(String filename){
        this.filename = filename;
    }
    public void fileConnect(){
        String msg = String.format("Reader %s to connect",filename);
        System.out.println(msg);
    }

    public void fileRead(){
        String msg = String.format("Reading %s",filename);
        System.out.println(msg);
    }

    public void fileDisconnect(){
        String msg = String.format("File %s disconnect",filename);
        System.out.println(msg);
    }
}
