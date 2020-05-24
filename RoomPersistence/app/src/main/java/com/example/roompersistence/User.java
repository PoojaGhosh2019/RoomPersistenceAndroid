package com.example.roompersistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


//creating a table of User in room database, if tableName not provided by default the
//tablename will be the class name
@Entity(tableName = "users")
public class User {
    //Defining a primary key for a table is required, id is the primary key
    @PrimaryKey
    private int id;

    //customizing the column name
    @ColumnInfo(name="user_name")
    private String name;

    @ColumnInfo(name="user_email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
