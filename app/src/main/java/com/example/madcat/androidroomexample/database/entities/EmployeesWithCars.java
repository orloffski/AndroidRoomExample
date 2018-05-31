package com.example.madcat.androidroomexample.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Relation;

import java.util.List;

public class EmployeesWithCars {
    public long id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @Relation(parentColumn = "id", entityColumn = "employee_id")
    public List<Car> cars;
}
