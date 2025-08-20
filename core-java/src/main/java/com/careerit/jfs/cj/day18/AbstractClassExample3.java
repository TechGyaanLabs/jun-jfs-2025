package com.careerit.jfs.cj.day18;
abstract class AbsOne {
    AbsOne() {
        System.out.println("AbsOne Constructor");
    }
}
class AbsTwo extends AbsOne{
    AbsTwo(){
        System.out.println("AbsTwo Constructor");
    }
}

public class AbstractClassExample3 {

    public static void main(String[] args) {
            AbsOne ref = new AbsTwo();
    }
}
