package com.careerit.jfs.cj.day27;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
class Employee {
    private String name;
    private double salary;
    private String department;
}
public class EmployeeManager {


    public static void main(String[] args) {
        List<Employee> employees = getEmployees();
        employees.forEach(System.out::println);
        Set<String> uniqueDepartments = new HashSet<>();
        for(Employee employee : employees){
            uniqueDepartments.add(employee.getDepartment());
        }
        uniqueDepartments.forEach(System.out::println);
    }


    public static List<Employee> getEmployees() {
        InputStream inputStream = EmployeeManager.class.getClassLoader()
                .getResourceAsStream("emp_data.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(inputStream, new TypeReference<List<Employee>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
