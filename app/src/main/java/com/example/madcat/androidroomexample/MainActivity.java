package com.example.madcat.androidroomexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.madcat.androidroomexample.database.LoadData;
import com.example.madcat.androidroomexample.database.dao.CarDao;
import com.example.madcat.androidroomexample.database.dao.EmployeeDao;
import com.example.madcat.androidroomexample.database.entities.Car;
import com.example.madcat.androidroomexample.database.entities.Employee;
import com.idescout.sql.SqlScoutServer;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button loadData;
    Button employeesPrint;
    Button carsPrint;

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

        loadData.setOnClickListener(this);
        employeesPrint.setOnClickListener(this);
        carsPrint.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_init:
                LoadData.loadDataInDB();
                break;
            case R.id.btn_employees:
                employeeDao = App.getInstance().getDatabase().employeeDao();

                List<Employee> employeeList = employeeDao.getAll();

                PrintSQLiteData.printEmployee(employeeList);
                break;
            case R.id.btn_cars:
                carDao = App.getInstance().getDatabase().carDao();

                List<Car> carList = carDao.getAll();

                PrintSQLiteData.printCar(carList);
                break;
        }
    }
}
