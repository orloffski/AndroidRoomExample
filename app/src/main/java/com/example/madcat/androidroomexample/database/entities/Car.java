package com.example.madcat.androidroomexample.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Employee.class, parentColumns = "id", childColumns = "employee_id"))
public class Car {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String model;

    public int year;

    @ColumnInfo(name = "employee_id")
    public long employeeId;

}
