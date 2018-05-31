package com.example.madcat.androidroomexample.database.entities;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class EmployeesWithCars {

    @Embedded
    public Employee employee;

    @Relation(parentColumn = "id", entityColumn = "employee_id")
    public List<Car> cars;
}
