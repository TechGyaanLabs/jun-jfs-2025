package com.careerit.jfs.cj.optinal;

import java.util.Optional;

public class EmployeeDriverClass {

    public static void main(String[] args) {
        EmployeeService empService = new EmployeeService();
        Optional<Employee> optEmployee = empService.getEmployee("1002");
        if (optEmployee.isPresent()) {
            Employee employee = optEmployee.get();
            System.out.println(employee.empno());
            System.out.println(employee.name());
            System.out.println(employee.dname());
            System.out.println(employee.salary());
        } else {
            System.out.println("No employee found");
        }

        Optional<String> optName = empService.getEmployeeName("1102");
        if(optName.isPresent()) {
            String name = optName.get();
            System.out.println(name);
        }
    }
}
