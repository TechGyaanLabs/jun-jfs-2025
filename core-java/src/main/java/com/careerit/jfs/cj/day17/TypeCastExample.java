package com.careerit.jfs.cj.day17;

class Parent {
    void m1() {
        System.out.println("Parent m1");
    }
}
class Child1 extends Parent {
    void m1() {
        System.out.println("Child1 m1");
    }
    void m2() {
        System.out.println("Child1 m2");
    }
}
class Child2 extends Parent {
    void m1() {
        System.out.println("Child2 m1");
    }
    void m2() {
        System.out.println("Child2 m2");
    }
    void m3() {
        System.out.println("Child2 m3");
    }
}
public class TypeCastExample {

    public static void main(String[] args) {
        Parent p1 = new Child2();

        if(p1 instanceof Child1 ref) {
            ref.m1();
            ref.m2();
        }else if(p1 instanceof Child2 ref) {
            ref.m1();
            ref.m2();
            ref.m3();
        }else{
            p1.m1();
        }



    }
}
