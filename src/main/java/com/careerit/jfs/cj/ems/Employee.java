package com.careerit.jfs.cj.ems;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@AllArgsConstructor
@EqualsAndHashCode
@Getter
class Employee {

    private int empno;
    private String ename;
    private String job;


    public void showInfo() {
        System.out.println("EmpNo  : " + empno);
        System.out.println("EmpName: " + ename);
        System.out.println("Job    : " + job);
    }

}





