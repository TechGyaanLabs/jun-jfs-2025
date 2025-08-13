package com.careerit.jfs.cj.optinal;

import org.apache.commons.lang3.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
        this.employees.add(new Employee(null, "John", "Sales", 50000));
        this.employees.add(new Employee("1002", "Jane", "IT", 60000));
        this.employees.add(new Employee("1003", "Ramesh", "HR", 70000));
        this.employees.add(new Employee("1004", "Charan", "Sales", 80000));
        this.employees.add(new Employee("1005", "Manoj", "IT", 90000));
        this.employees.add(new Employee("1006", "Krishna", "HR", 100000));
        this.employees.add(new Employee("1007", "Suresh", "Sales", 110000));
    }

    public Optional<Employee> getEmployee(String empno) {
       return employees
               .stream()
               .filter(e -> Strings.CI.equals(e.empno(), empno))
               .findFirst();
    }

    public Optional<String> getEmployeeName(String empno) {
        String name = null;
        for (Employee employee : employees) {
            if (Strings.CI.equals(employee.empno(), empno)) {
                name = employee.name();
                break;
            }
        }
        return Optional.ofNullable(name);
    }

}
