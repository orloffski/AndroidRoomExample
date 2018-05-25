package com.example.madcat.androidroomexample;

import com.example.madcat.androidroomexample.database.entities.Employee;

import java.util.List;

public class PrintSQLiteData {

    public static void printEmployee(Employee employee){
        System.out.println(
                "Employee id: " + employee.id +
                        " name: " + employee.name +
                        " salary: " + employee.salary);
    }

    public static void printEmployee(List<Employee> employee){
        System.out.println("Employees list");
        for(Employee employeeSingle : employee)
            printEmployee(employeeSingle);
    }

    public static void printUpdated(Employee employee){
        System.out.println("Employee updated");
        printEmployee(employee);
    }

    public static void printDeleted(Employee employee){
        System.out.println("Employee deleted");
        printEmployee(employee);
    }

    public static void printAdded(Employee employee){
        System.out.println("Employee added");
        printEmployee(employee);
    }
}
