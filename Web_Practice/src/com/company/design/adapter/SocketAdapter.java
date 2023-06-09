package com.company.design.adapter;

public class SocketAdapter implements Electronic_110{
    private Electronic_220 electronic220;

    public SocketAdapter(Electronic_220 electronic220){
        this.electronic220 = electronic220;
    }
    @Override
    public void powerOn() {
        electronic220.connect();
    }
}
