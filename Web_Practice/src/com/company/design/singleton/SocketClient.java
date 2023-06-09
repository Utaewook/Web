package com.company.design.singleton;

public class SocketClient {  // 어떠한 프로그램이나 프로젝트에서 단 하나의 객체만 필요한 경우 사용하는 방식 - Singleton
    private static SocketClient socketClient = null;
    private SocketClient(){

    }
    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
