package com.careerit.jfs.cj.day16;

class A{
    int a = 10;
    A(){
        System.out.println("A constructor");
    }
    public void show(){
        System.out.println("A show");
    }
}
class B extends  A{
    int a  = 20;
    B(){
        System.out.println("B constructor");
    }
    public void show(){
        System.out.println("B show");
    }

}
class C extends B{
    int a = 30;
    C(){
        System.out.println("C constructor");
    }
    public void show(){
        System.out.println("C show");
        System.out.println(a);
        System.out.println(super.a);
    }

}

public class InheritanceExample3 {

    public static void main(String[] args) {
            A obj = new C();
            obj.show();
            System.out.println(obj.a);
    }
}
