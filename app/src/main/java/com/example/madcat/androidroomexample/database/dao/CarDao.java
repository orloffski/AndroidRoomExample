package com.example.madcat.androidroomexample.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.madcat.androidroomexample.database.entities.Car;

import java.util.List;

@Dao
public interface CarDao {

    @Query("SELECT * FROM car")
    List<Car> getAll();

    @Query("SELECT * FROM car WHERE id = :id")
    Car getById(long id);

    @Query("SELECT * FROM car WHERE employee_id = :id")
    List<Car> getByEmployeeId(long id);

    @Insert
    void insert(Car car);

    @Update
    void update(Car car);

    @Delete
    void delete(Car car);

}
