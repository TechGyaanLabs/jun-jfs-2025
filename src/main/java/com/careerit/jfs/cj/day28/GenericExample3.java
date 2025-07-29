package com.careerit.jfs.cj.day28;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.util.List;

public class GenericExample3 {

    public static void main(String[] args) {

        // Read Employee data
        InputStream employeeInputStream = GenericExample3.class.getClassLoader()
                .getResourceAsStream("employee.json");
        Employee employee = JsonReaderUtil.loadJson(employeeInputStream, Employee.class);
        System.out.println(employee);

        // Read Employees data
        InputStream employeesInputStream = GenericExample3.class.getClassLoader()
                .getResourceAsStream("employees.json");

        List<Employee> employees = JsonReaderUtil.loadJson(employeesInputStream, new TypeReference<List<Employee>>() {});
        employees.forEach(System.out::println);



        // Read Player data


        // Read Players data


    }
}
