package com.example.madcat.androidroomexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.madcat.androidroomexample.database.dao.EmployeeDao;
import com.example.madcat.androidroomexample.database.entities.Employee;
import com.idescout.sql.SqlScoutServer;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EmployeeDao employeeDao;
    Employee employee;

    LiveData<List<Employee>> employeesLiveData;

    Button listButton;
    Button addButton;
    Button saveButton;
    Button cancelButton;
    Button deleteButton;
    Button getButton;

    TextView idEditText;
    TextView nameEditText;
    TextView salaryEditText;
    TextView getEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SqlScoutServer.create(this, getPackageName());
        setContentView(R.layout.activity_main);

        listButton = findViewById(R.id.btn_list);
        addButton = findViewById(R.id.btn_add);
        saveButton = findViewById(R.id.btn_save);
        cancelButton = findViewById(R.id.btn_cancel);
        deleteButton = findViewById(R.id.btn_delete);
        getButton = findViewById(R.id.btn_get);

        idEditText = findViewById(R.id.idEditText);
        nameEditText = findViewById(R.id.nameEditText);
        salaryEditText = findViewById(R.id.salaryEditText);
        getEditText = findViewById(R.id.getEditText);

        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        listButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        getButton.setOnClickListener(this);

        employeesLiveData = App.getInstance().getDatabase().employeeDao().getAllLveData();

        employeesLiveData.observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable List<Employee> employees) {
                PrintSQLiteData.printEmployee(employees);
            }
        });
    }

    @Override
    public void onClick(View v) {

        employeeDao = App.getInstance().getDatabase().employeeDao();

        switch (v.getId()){
            case R.id.btn_list:
                List<Employee> employeeList = employeeDao.getAll();

                PrintSQLiteData.printEmployee(employeeList);
                break;
            case R.id.btn_add:
                employee = new Employee();
                employee.name = nameEditText.getText().toString();
                employee.salary = Integer.parseInt(salaryEditText.getText().toString());
                employeeDao.insert(employee);

                PrintSQLiteData.printAdded(employee);
                break;
            case R.id.btn_get:
                employee = employeeDao.getById(Long.parseLong(getEditText.getText().toString()));

                if(employee != null) {
                    idEditText.setText(String.valueOf(employee.id));
                    nameEditText.setText(employee.name);
                    salaryEditText.setText(String.valueOf(employee.salary));
                }
                break;
            case R.id.btn_save:
                employee = new Employee();
                employee.name = nameEditText.getText().toString();
                employee.salary = Integer.parseInt(salaryEditText.getText().toString());
                employeeDao.update(employee);

                PrintSQLiteData.printUpdated(employee);
                break;
            case R.id.btn_cancel:
                nameEditText.setText("");
                salaryEditText.setText("");
                break;
            case R.id.btn_delete:
                employee = new Employee();
                employee.name = nameEditText.getText().toString();
                employee.salary = Integer.parseInt(salaryEditText.getText().toString());
                employeeDao.delete(employee);

                PrintSQLiteData.printDeleted(employee);
                break;
        }
    }
}
