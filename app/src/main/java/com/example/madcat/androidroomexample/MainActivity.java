package com.example.madcat.androidroomexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.madcat.androidroomexample.database.AppDatabase;
import com.example.madcat.androidroomexample.database.dao.EmployeeDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
    }
}
