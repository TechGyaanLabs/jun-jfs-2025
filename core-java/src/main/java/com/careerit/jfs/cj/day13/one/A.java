package com.careerit.jfs.cj.day13.one;

public class A {

    private int pri_num = 10;
    protected int pro_num = 20;
    public int pub_num = 30;
    int def_num = 40;

    public void display(){
        System.out.println("private number : "+pri_num);
        System.out.println("protected number : "+pro_num);
        System.out.println("public number : "+pub_num);
        System.out.println("default number : "+def_num);
    }
}
