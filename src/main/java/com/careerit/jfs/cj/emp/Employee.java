package com.careerit.jfs.cj.emp;

public class Employee {
    private int empno;
    private String ename;
    private String job;

    public Employee(int empno, String ename, String job) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
    }

    public int getEmpno(){
        return empno;
    }

    public String getEname(){
        return ename;
    }

    public String getJob(){
        return job;
    }

    public void showInfo(){
        System.out.println("Emp No: " + empno + " " + "Name: " + ename + " " + "Job: " + job );

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return this.empno == other.empno;
    }
    @Override
    public int hashCode(){
        return Integer.hashCode(empno);
    }

}
