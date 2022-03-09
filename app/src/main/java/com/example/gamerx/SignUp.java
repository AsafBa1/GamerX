package com.example.gamerx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText editUser,editEmail,editPass;
    private ProgressBar progressbar;
    private Button signBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        signBtn = findViewById(R.id.sign_up_btn);
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        editEmail = findViewById(R.id.sign_edit_email);
        editPass = findViewById(R.id.sign_edit_password);
        editUser = findViewById(R.id.sign_edit_user);

        progressbar = findViewById(R.id.sign_pbar);
    }

    private void registerUser() {
        String email = editEmail.getText().toString().trim();
        String user = editUser.getText().toString().trim();
        String password = editPass.getText().toString().trim();

        if(user.isEmpty()){
            editUser.setError("User Name Is Required!");
            editUser.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editEmail.setError("Email Is Required!");
            editEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Please Provide a Valid Email");
            editEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editPass.setError("Password Is Required!");
            editPass.requestFocus();
            return;
        }
        if(password.length() < 6 ){
            editPass.setError("Password Needs To Be  6 Characters Or Longer");
            editPass.requestFocus();
            return;
        }

    }
}