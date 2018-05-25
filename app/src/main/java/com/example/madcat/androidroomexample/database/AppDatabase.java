package com.example.madcat.androidroomexample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.madcat.androidroomexample.database.dao.CarDao;
import com.example.madcat.androidroomexample.database.dao.EmployeeCarDao;
import com.example.madcat.androidroomexample.database.dao.EmployeeDao;
import com.example.madcat.androidroomexample.database.entities.Car;
import com.example.madcat.androidroomexample.database.entities.Employee;

@Database(entities = {Employee.class, Car.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract EmployeeDao employeeDao();
    public abstract CarDao carDao();
    public abstract EmployeeCarDao employeeCarDao();

}
