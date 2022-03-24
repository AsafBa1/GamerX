package com.example.gamerx.Model;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gamerx.BaseActivity;
import com.example.gamerx.R;


public class RegisterFragment extends Fragment {
    private EditText email;
    private EditText username;
    private EditText password;

    Button registerBtn;
    Button loginBtn;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {}

    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        email = view.findViewById(R.id.register_email);
        username = view.findViewById(R.id.register_username);
        password = view.findViewById(R.id.register_password);
        Button registerBtn = view.findViewById(R.id.register_register_btn);
        registerBtn.setOnClickListener(v -> {
            if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(username.getText().toString())|| TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(getContext(), "please fill all fields!", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 6){
                Toast.makeText(getContext(), "Password too short!", Toast.LENGTH_SHORT).show();
            } else {
               // Model.instance.registerUser(email.getText().toString(), username.getText().toString(), password.getText().toString());
                toFeedActivity();
                }
        });


        return view;
    }
    private void toFeedActivity() {
        Intent intent = new Intent(getContext(), BaseActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}