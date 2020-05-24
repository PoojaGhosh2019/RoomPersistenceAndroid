package com.example.roompersistence;


//specify the possible methods need to access database table in this interface

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    //Database insertion
    @Insert
    public void addUser(User user);

    //read from db
    @Query("select * from users")
    public List<User> getUsers();

    //delete record from db , performed with primary key
    @Delete
    public void deleteUser(User user);

    //update user information , performed with primary key
    @Update
    public void updateUser(User user);
}
