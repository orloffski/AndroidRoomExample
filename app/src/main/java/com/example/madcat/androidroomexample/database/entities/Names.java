package com.example.madcat.androidroomexample.database.entities;

import android.arch.persistence.room.ColumnInfo;

public class Names {

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;
}
