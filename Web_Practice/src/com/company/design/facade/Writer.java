package com.company.design.facade;

public class Writer {
    private String filename;

    public Writer(String filename){
        this.filename = filename;
    }

    public void fileConnect(){
        String msg = String.format("File %s connect",filename);
        System.out.println(msg);
    }

    public void fileWrite(){
        String msg = String.format("File %s write",filename);
        System.out.println(msg);
    }

    public void fileDisconnect(){
        String msg = String.format("File %s Disconnect",filename);
        System.out.println(msg);
    }
}
