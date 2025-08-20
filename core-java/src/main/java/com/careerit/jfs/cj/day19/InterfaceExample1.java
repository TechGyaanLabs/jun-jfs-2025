package com.careerit.jfs.cj.day19;
interface One{
    void m1();
}
interface Two{
   void m2();
}
interface Three{
   void m3();
}
interface Four extends One,Two,Three{
    void m4();
}
class Sample implements Four {
    @Override
    public void m1() {
        System.out.println("One M1");
    }

    @Override
    public void m3() {
        System.out.println("Three M3");
    }

    @Override
    public void m2() {
        System.out.println("Two M2");
    }
    @Override
    public void m4(){
        System.out.println("Four M4");
    }
}
public class InterfaceExample1 {

    public static void main(String[] args) {
            One ref = new Sample();

    }
}
