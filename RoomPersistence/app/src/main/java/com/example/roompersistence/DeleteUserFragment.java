package com.example.roompersistence;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.PrimaryKey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {
    private EditText userId;
    private Button deleteBtn;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        userId = view.findViewById(R.id.txt_user_id1);
        deleteBtn = view.findViewById(R.id.delete);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(userId.getText().toString());
                User user = new User();
                //setting the user id as this is the primary key defined for this table
                user.setId(id);

                //deleting the particular user
                MainActivity.myAppDatabase.myDao().deleteUser(user);

                Toast.makeText(getActivity(),"User successfully removed:",Toast.LENGTH_SHORT).show();
                userId.setText("");
            }
        });
        return view;
    }
}
