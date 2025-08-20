package com.careerit.jfs.cj.day17;

import java.util.concurrent.ThreadLocalRandom;

class One{
    void m1(){
        System.out.println("One M1");
    }
}
class Two extends One {
    void m1(){
        System.out.println("Two M1");
    }
    void m2(){
        System.out.println("Two M2");
    }
}
class Three extends One{
    void m1(){
        System.out.println("Three M1");
    }
    void m2(){
        System.out.println("Three M2");
    }
    void m3(){
        System.out.println("Three M3");
    }

}
public class TypeCastingWithReferenceVariables {

    public static void main(String[] args) {

            One one = getObject();
            Two two = (Two)one;
            two.m1();
            two.m2();


            One obj = getObject();

            if(obj instanceof Two ref) {
                ref.m1();
                ref.m2();
            }
            else if(obj instanceof Three ref){
                ref.m1();
                ref.m2();
                ref.m3();
            }else{
                obj.m1();
            }

    }

    public static One getObject(){
        int num = ThreadLocalRandom.current().nextInt(1,4);
        if(num == 1){
            return new One();
        }
        else if (num == 2){
            return new Two();
        }else if(num == 3){
            return new Three();
        }
        throw new RuntimeException("Invalid Number");
    }

}
