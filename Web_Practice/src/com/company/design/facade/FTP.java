package com.company.design.facade;

public class FTP {
    private String host;
    private int port;
    private String path;

    public FTP(String host, int port, String path){
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect(){
        System.out.println("FTP host : "+host+"   Port : "+port+" connect");
    }

    public void moveDirectory(){
        System.out.println("path : "+path);
    }

    public void dicConeect(){
        System.out.println("Connect Finish");
    }
}
