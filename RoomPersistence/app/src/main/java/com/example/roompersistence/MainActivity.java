package com.example.roompersistence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        //initialize database variable
        //using allowMainThreadQueries for this demo purpose otherwise databse cannot be access
        //on the main thread as it may lock the UI , need to use other API such as async task
        //to allow databse operation on separate thread
        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userDb").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container)!= null){
            if(savedInstanceState!=null){
                return;
            }
            //add the fragment to the main activity
            fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        }
    }
}
