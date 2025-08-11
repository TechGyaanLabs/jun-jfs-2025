package com.careerit.jfs.cj.exception;

public class CustomResource implements AutoCloseable{

    public void init(){
        System.out.println("init method of custom resource");
    }
    @Override
    public void close() throws Exception {
        System.out.println("close method of custom resource");
    }
}
