package com.example.madcat.androidroomexample.database.entities;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(indices = {@Index("name")})
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String name;

    public int salary;

    @Embedded(prefix = "adress")
    public Adress adress;
}
