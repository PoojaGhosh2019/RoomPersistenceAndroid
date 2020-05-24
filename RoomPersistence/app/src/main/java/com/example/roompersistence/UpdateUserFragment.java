package com.example.roompersistence;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {
    EditText userId,userName,userEmail;
    Button btnUpdate;
    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);
        userId = view.findViewById(R.id.txt_user_id2);
        userName = view.findViewById(R.id.txt_user_name2);
        userEmail = view.findViewById(R.id.txt_user_email2);
        btnUpdate = view.findViewById(R.id.update);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(userId.getText().toString());
                String UserName = userName.getText().toString();
                String UserEmail = userEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(UserName);
                user.setEmail(UserEmail);

                //update user details
                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(),"User details updated",Toast.LENGTH_SHORT).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");
            }
        });
        return view;
    }
}
