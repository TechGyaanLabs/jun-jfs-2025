package HomeWork;

import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;

import java.util.Set;

@Getter
class Employee {
    @Getter
    private int empno;
    private String ename;
    private String job;

    public Employee(int empno, String ename, String job) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
    }

    public void showInfo() {
        System.out.println("EmpNo  : " + empno);
        System.out.println("EmpName: " + ename);
        System.out.println("Job    : " + job);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee employee = (Employee) obj;
        return empno == employee.empno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno);
    }
}


class EmployeeContainer {
    private Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee emp) {
        if (employees.contains(emp)) {
            System.out.println("Employee already exists");
        } else {
            employees.add(emp);
            System.out.println("Employee added successfully.");
        }
    }

    public void deleteEmployee(int empno) {
        Employee toRemove = findEmployee(empno);
        if (toRemove != null) {
            employees.remove(toRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Sorry! Employee is not found");
        }
    }

    public void viewEmployee(int empno) {
        Employee emp = findEmployee(empno);
        if (emp != null) {
            emp.showInfo();
        } else {
            System.out.println("Sorry! Employee is not found");
        }
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No elements are added to the Set");
        } else {
            for (Employee emp : employees) {
                emp.showInfo();
                System.out.println("-----");
            }
        }
    }

    private Employee findEmployee(int empno) {
        for (Employee emp : employees) {
            if (emp.getEmpno() == empno) {
                return emp;
            }
        }
        return null;
    }
}


