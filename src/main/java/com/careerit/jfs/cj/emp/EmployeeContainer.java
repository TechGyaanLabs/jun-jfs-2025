package com.careerit.jfs.cj.emp;

import java.util.*;

public class EmployeeContainer {
    private Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee emp){
        if (!employees.add(emp)){
            System.out.println("Employee already exists");
        } else {
            System.out.println("Employee added successfully");
        }
    }

    public void deleteEmployee(int empno){
        Employee toRemove = findEmployee(empno);
        if (toRemove != null) {
            employees.remove(toRemove);
            System.out.println("Employee removed successfully");
        } else {
            System.out.println("Sorry! Employee is not found");
        }
    }

    public void viewEmployees(){
        if (employees.isEmpty()){
            System.out.println("No elements are added to the set");
        } else {
            for(Employee emp: employees){
                emp.showInfo();
            }
        }
    }

    private Employee findEmployee(int empno){
        for (Employee emp : employees){
            if (emp.getEmpno() == empno){
                return emp;
            }
        }
        return null;
    }
}
