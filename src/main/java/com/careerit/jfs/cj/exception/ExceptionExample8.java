package com.careerit.jfs.cj.exception;


class One{
    void m1(){
        try {
            System.out.println(1/0);
        } catch (Exception e) {
           throw e;
        }
    }
}
class Two extends One{
    void m2(){
        try {
            m1();
        } catch (Exception e) {
            throw e;
        }
    }
}
public class ExceptionExample8 {

    public static void main(String[] args) {

        Two obj = new Two();
        try {
            obj.m2();
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
    }
}
