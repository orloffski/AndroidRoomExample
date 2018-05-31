package com.example.madcat.androidroomexample.database;

import com.example.madcat.androidroomexample.App;
import com.example.madcat.androidroomexample.database.dao.CarDao;
import com.example.madcat.androidroomexample.database.dao.EmployeeDao;
import com.example.madcat.androidroomexample.database.entities.Car;
import com.example.madcat.androidroomexample.database.entities.Employee;

public class LoadData {

    public static void loadDataInDB(){

        EmployeeDao employeeDao = App.getInstance().getDatabase().employeeDao();
        CarDao carDao = App.getInstance().getDatabase().carDao();

        Employee employee = new Employee();
        Car car = new Car();

        for(int i = 1; i <= 10; i++) {
            employee.firstName = "firstName_" + i;
            employee.lastName = "lastName_" + i;
            employee.salary = 1000 * i;

            employeeDao.insert(employee);
        }

        for(int i = 1; i <=5; i++){
            car.model = "Nissan Terrano 199" + i;
            car.year = 1990 + i;
            car.employeeId = (long) (Math.random() * (10 - 1));

            carDao.insert(car);
        }

        System.out.println("Data loaded in DB");
    }
}
