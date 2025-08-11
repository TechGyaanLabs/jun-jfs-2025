package com.careerit.jfs.cj.emp;

public class Empmain {
    public static void main(String[] args){
        EmployeeContainer container = new EmployeeContainer();

        Employee e1 = new Employee(101, "Amrutha", "Manager");
        Employee e2 = new Employee(102, "Anjana", "Developer");
        Employee e3 = new Employee(103, "Anusha", "Tester");

        container.addEmployee(e1);
        container.addEmployee(e2);
        container.addEmployee(e3);
        container.viewEmployees();
        container.deleteEmployee(101);
        container.deleteEmployee(106);
        container.viewEmployees();





    }
}
