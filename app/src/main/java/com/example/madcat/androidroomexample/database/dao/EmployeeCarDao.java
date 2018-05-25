package com.example.madcat.androidroomexample.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Transaction;

import com.example.madcat.androidroomexample.database.entities.Car;
import com.example.madcat.androidroomexample.database.entities.Employee;

@Dao
public abstract class EmployeeCarDao {

    @Insert
    public abstract void insertEmployee(Employee employee);

    @Insert
    public abstract void insertCar(Car car);


    @Transaction
    public void insertCarAndEmployee(Car car, Employee employee) {
        insertCar(car);
        insertEmployee(employee);
    }
}
