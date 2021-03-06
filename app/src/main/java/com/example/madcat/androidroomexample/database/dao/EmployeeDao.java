package com.example.madcat.androidroomexample.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.example.madcat.androidroomexample.database.entities.Employee;
import com.example.madcat.androidroomexample.database.entities.EmployeesWithCars;
import com.example.madcat.androidroomexample.database.entities.Names;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    @Query("SELECT * FROM employee")
    Employee[] getAllInArray();

    @Query("SELECT * FROM employee")
    Cursor getAllInCursor();

    @Query("SELECT * FROM employee")
    LiveData<List<Employee>> getAllLveData();

    @Query("SELECT * FROM employee WHERE id = :id")
    Employee getById(long id);

    @Query("SELECT * FROM employee WHERE salary > :minSalary")
    Employee getAllWithSalaryMoreThan(int minSalary);

    @Query("SELECT * FROM employee WHERE salary BETWEEN :minSalary AND :maxSalary")
    Employee getAllWithSalaryBetween(int minSalary, int maxSalary);

    @Query("SELECT * FROM employee WHERE first_name LIKE :search OR last_name LIKE :search")
    Employee getAllWithNameLike(String search);

    @Query("SELECT * FROM employee WHERE id IN (:idList)")
    Employee getByIdList(List<Long> idList);

    @Query("SELECT first_name, last_name FROM employee")
    List<Names> getNames();

    @Transaction
    @Query("SELECT * from employee")
    List<EmployeesWithCars> getEmployeesWithCars();

    @Insert
    void insert(Employee employee);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);
}
