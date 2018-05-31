package com.example.madcat.androidroomexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.madcat.androidroomexample.database.LoadData;
import com.example.madcat.androidroomexample.database.dao.CarDao;
import com.example.madcat.androidroomexample.database.dao.EmployeeDao;
import com.example.madcat.androidroomexample.database.entities.Car;
import com.example.madcat.androidroomexample.database.entities.CarsForEmployees;
import com.example.madcat.androidroomexample.database.entities.Employee;
import com.example.madcat.androidroomexample.database.entities.EmployeesWithCars;
import com.idescout.sql.SqlScoutServer;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button loadData;
    Button employeesPrint;
    Button carsPrint;
    Button carsDataFullPrint;
    Button employeeDataFullPrint;

    EmployeeDao employeeDao;

    CarDao carDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SqlScoutServer.create(this, getPackageName());
        setContentView(R.layout.activity_main);

        loadData = findViewById(R.id.btn_init);
        employeesPrint = findViewById(R.id.btn_employees);
        carsPrint = findViewById(R.id.btn_cars);
        carsDataFullPrint = findViewById(R.id.btn_full_cars_data);
        employeeDataFullPrint = findViewById(R.id.btn_full_employee_data);

        loadData.setOnClickListener(this);
        employeesPrint.setOnClickListener(this);
        carsPrint.setOnClickListener(this);
        carsDataFullPrint.setOnClickListener(this);
        employeeDataFullPrint.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        employeeDao = App.getInstance().getDatabase().employeeDao();
        carDao = App.getInstance().getDatabase().carDao();

        switch (v.getId()){
            case R.id.btn_init:
                LoadData.loadDataInDB();
                break;
            case R.id.btn_employees:
                List<Employee> employeeList = employeeDao.getAll();

                PrintSQLiteData.printEmployee(employeeList);
                break;
            case R.id.btn_cars:
                List<Car> carList = carDao.getAll();

                PrintSQLiteData.printCar(carList);
                break;
            case R.id.btn_full_cars_data:
                List<CarsForEmployees> carsForEmployees = carDao.getCarsForEmployees();

                PrintSQLiteData.printCarFullData(carsForEmployees);
                break;
            case R.id.btn_full_employee_data:
                List<EmployeesWithCars> employeesWithCars = employeeDao.getEmployeesWithCars();

                PrintSQLiteData.printEmployeeFullData(employeesWithCars);
                break;
        }
    }
}
