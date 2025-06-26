package com.careerit.jfs.cj.day13.one;

public class C {

        A a = new A();

        public void show_details(){
            //System.out.println("private number : "+a.pri_num);
            System.out.println("protected number : "+a.pro_num);
            System.out.println("public number : "+a.pub_num);
            System.out.println("default number : "+a.def_num);
        }
}
