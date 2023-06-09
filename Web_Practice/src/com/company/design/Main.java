package com.company.design;

import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.decorator.*;
import com.company.design.facade.FTP;
import com.company.design.facade.Reader;
import com.company.design.facade.SFTP;
import com.company.design.facade.Writer;
import com.company.design.observer.Button;
import com.company.design.observer.IButtonListener;
import com.company.design.proxy.*;
import com.company.design.singleton.*;
import com.company.design.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        // sinlgeton_func();
        // adapter_func();
        // proxy_func();
        // decorator_func();
        // observer_func();
        // facade_func();
        strategy_func();
    }

    private static void sinlgeton_func(){
        A a = new A();
        B b = new B();

        SocketClient aClient = a.getSocketClient();
        SocketClient bClient = b.getSocketClient();

        System.out.println("두 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
    }


    private static void connect(Electronic_110 electronic110){
        electronic110.powerOn();
    }
    private static void adapter_func(){
        Fan fan = new Fan();
        connect(fan);

        HairDryer hairDryer = new HairDryer();
        Electronic_110 adapter = new SocketAdapter(hairDryer);
        connect(adapter);

        Refreezer refreezer = new Refreezer();
        Electronic_110 adapter2 = new SocketAdapter(refreezer);
        connect(adapter2);
    }


    private static void proxy_func(){
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        IBrowser ibrowser = new BrowserProxy("www.naver.com");
        ibrowser.show();
        ibrowser.show();
        ibrowser.show();
        ibrowser.show();


        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    end.set(System.currentTimeMillis()-start.get());
                });

        aopBrowser.show();
        System.out.println("loading time = "+end.get());

        aopBrowser.show();
        System.out.println("loading time = "+end.get());

    }

    private static void decorator_func(){
        ICar audi = new Audi(4500);
        audi.showPrice();

        // a3
        ICar audi3 = new A3(audi,"a3");
        audi3.showPrice();

        // a4
        ICar audi4 = new A4(audi,"a4");
        audi4.showPrice();

        // a5
        ICar audi5 = new A5(audi,"a5");
        audi5.showPrice();

    }

    private static void observer_func(){
        Button button = new Button("");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("message-click1");
        button.click("message-click2");
        button.click("message-click3");
        button.click("message-click4");
        button.click("message-click5");
    }

    private static void facade_func(){
        FTP ftpClient = new FTP("www.foo.co.kr",22,"/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.fileWrite();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.dicConeect();


        SFTP sftp = new SFTP("www.foo.co.kr", 22,"/home/etc","text.tmp");
        sftp.connect();
        sftp.write();
        sftp.read();
        sftp.disConnect();
    }

    private static void strategy_func(){
        Encoder encoder = new Encoder();
        // base 64
        EncodingStrategy base64 = new Base64Strategy();

        // normal
        EncodingStrategy normal = new NormalStrategy();

        // append
        EncodingStrategy append = new AppendStrategy();

        String message = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64_result = encoder.getMessage(message);
        System.out.println(base64_result);

        encoder.setEncodingStrategy(normal);
        String normal_result = encoder.getMessage(message);
        System.out.println(normal_result);

        encoder.setEncodingStrategy(append);
        String append_result = encoder.getMessage(message);
        System.out.println(append_result);
    }
}