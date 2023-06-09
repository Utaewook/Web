package com.company.design.proxy;

public class Browser {
    private String url;

    public Browser(String url){
        this.url = url;
    }

    public HTML show(){
        System.out.println("browser loading from : "+url);
        return new HTML(url);
    }
}
