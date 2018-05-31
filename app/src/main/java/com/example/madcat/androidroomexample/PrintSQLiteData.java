package com.example.madcat.androidroomexample;

import com.example.madcat.androidroomexample.database.entities.Car;
import com.example.madcat.androidroomexample.database.entities.CarsForEmployees;
import com.example.madcat.androidroomexample.database.entities.Employee;
import com.example.madcat.androidroomexample.database.entities.EmployeesWithCars;
import com.example.madcat.androidroomexample.database.entities.Names;

import java.util.List;

public class PrintSQLiteData {

    public static void printEmployeeNames(Names names){
        System.out.println("first name: " + names.firstName + " last name: " + names.lastName);
    }

    public static void printEmployeesNames(List<Names> names){
        System.out.println("Names list");
        for(Names name : names)
            printEmployeeNames(name);
    }

    public static void printEmployee(Employee employee){
        System.out.println(
                "Employee id: " + employee.id +
                        " first_name: " + employee.firstName +
                        " last_name: " + employee.lastName +
                        " salary: " + employee.salary);
    }

    public static void printEmployee(List<Employee> employee){
        System.out.println("Employees list");
        for(Employee employeeSingle : employee)
            printEmployee(employeeSingle);
    }

    public static void printCar(Car car){
        System.out.println(
                "Car id: " + car.id +
                        " model: " + car.model +
                        " year: " + car.year +
                        " employee_id: " + car.employeeId);
    }

    public static void printCar(List<Car> cars){
        System.out.println("Cars list");
        for(Car car : cars)
            printCar(car);
    }

    public static void printCarFullData(CarsForEmployees carsForEmployees){
        System.out.println(
                "Car model: " + carsForEmployees.model +
                        " employee: " + carsForEmployees.employeeFirstName +
                        " " + carsForEmployees.employeeLastName);
    }

    public static void printCarFullData(List<CarsForEmployees> carsForEmployees){
        System.out.println("Cars list");
        for(CarsForEmployees carsForEmployeesSingle : carsForEmployees)
            printCarFullData(carsForEmployeesSingle);
    }

    public static void printEmployeeFullData(EmployeesWithCars employeesWithCars){
        System.out.println(
                "Employee : " + employeesWithCars.employee.id +
                        " " + employeesWithCars.employee.firstName +
                        " " + employeesWithCars.employee.lastName);
        if(employeesWithCars.cars != null && employeesWithCars.cars.size() != 0){
            for(Car car : employeesWithCars.cars)
                printCar(car);
        }else{
            System.out.println("employee don't have car");
        }
    }

    public static void printEmployeeFullData(List<EmployeesWithCars> employeesWithCars){
        System.out.println("Employees list");
        for(EmployeesWithCars employeesWithCarsSingle : employeesWithCars)
            printEmployeeFullData(employeesWithCarsSingle);
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
