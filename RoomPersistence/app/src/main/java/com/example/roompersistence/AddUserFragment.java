package com.example.roompersistence;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddUserFragment extends Fragment {
    private EditText userId, userName, userEmail;
    private Button btnSave;

    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        userId = view.findViewById(R.id.txt_user_id);
        userName = view.findViewById(R.id.txt_user_name);
        userEmail = view.findViewById(R.id.txt_user_email);
        btnSave = view.findViewById(R.id.btn_save_user);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int userid = Integer.parseInt(userId.getText().toString());
               String username = userName.getText().toString();
               String useremail = userEmail.getText().toString();

               //creating an object User
                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

                //data insertion
                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(),"User added successfully",Toast.LENGTH_SHORT).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");

            }
        });
        return view;
    }
}
