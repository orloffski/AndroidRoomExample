package com.example.madcat.androidroomexample.database.entities;

import android.arch.persistence.room.ColumnInfo;

public class CarsForEmployees {

    public String model;

    @ColumnInfo(name = "employee_first_name")
    public String employeeFirstName;

    @ColumnInfo(name = "employee_last_name")
    public String employeeLastName;
}
