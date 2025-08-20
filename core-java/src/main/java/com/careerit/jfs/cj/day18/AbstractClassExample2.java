package com.careerit.jfs.cj.day18;

abstract class One{
    abstract void m1();
    void m2(){
        m1();
        System.out.println("One M2");
        m3();
    }
    public abstract void m3();
}
class Two extends One{

    void m1(){
        System.out.println("Two M1");
    }
    public void m3(){
        System.out.println("Two M3");
    }


}
public class AbstractClassExample2 {
    public static void main(String[] args) {
        One obj = new Two();
        obj.m2();
    }
}
