package com.example.roompersistence;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private Button btnAddUser,btnReadUser,btnDeleteUser,btnUpdateUser;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnAddUser = view.findViewById(R.id.btn_addUser);
        btnReadUser = view.findViewById(R.id.btn_viewUser);
        btnDeleteUser = view.findViewById(R.id.btn_deleteUser);
        btnUpdateUser = view.findViewById(R.id.btn_updateUser);
        btnAddUser.setOnClickListener(this);
        btnReadUser.setOnClickListener(this);
        btnDeleteUser.setOnClickListener(this);
        btnUpdateUser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_addUser:
               MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment())
                       .addToBackStack(null).commit();
               break;

            case R.id.btn_viewUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_deleteUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_updateUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateUserFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
