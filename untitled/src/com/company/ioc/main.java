package com.company.ioc;

// DI 주입 객체를 바꾸며 재사용성을 높임
public class main {
    public static void main (String[] args){
        String url = "www.naver.com/books/it?page=102&size=20&name=spring";

        // Base 64 encoding
        Encoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.encode(url);
        System.out.println(result);

        // url encoding
        Encoder urlEncoder = new Encoder(new UrlEncoder());
        String urlResult = urlEncoder.encode(url);
        System.out.println(urlResult);
    }
}
