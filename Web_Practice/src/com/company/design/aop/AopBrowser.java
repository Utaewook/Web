package com.company.design.aop;

import com.company.design.proxy.HTML;
import com.company.design.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private HTML html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after){
        this.url = url;
        this.before = before;
        this.after = after;
    }
    @Override
    public HTML show() {
        before.run();
        if(html == null){
            this.html = new HTML(url);
            System.out.println("AOP Browser html loading from : "+url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        after.run();
        System.out.println("AOP Browser html Cache : "+url);
        return html;
    }
}
