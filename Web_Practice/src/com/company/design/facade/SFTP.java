package com.company.design.facade;

public class SFTP {
    private FTP ftp;
    private Reader reader;
    private Writer writer;

    public SFTP(FTP ftp, Reader reader, Writer writer){
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    public SFTP(String host,int port, String path, String filename){
        this.ftp = new FTP(host,port,path);
        this.reader = new Reader(filename);
        this.writer = new Writer(filename);
    }

    public void connect(){
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disConnect(){
        writer.fileDisconnect();
        reader.fileDisconnect();
        ftp.dicConeect();
    }

    public void read(){
        reader.fileRead();
    }

    public void write(){
        writer.fileWrite();
    }
}
