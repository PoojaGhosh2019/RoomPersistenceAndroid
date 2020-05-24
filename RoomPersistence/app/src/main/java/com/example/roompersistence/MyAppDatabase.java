package com.example.roompersistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//this abstract class contains an abstract method that returns
//an object of the data access object

//This class represents database, entities represent all the tables inside this database
@Database(entities = {User.class},version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();
}
