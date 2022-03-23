package com.example.gamerx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private TextView register;
    private ProgressBar progressBar;
    private EditText logEmail,logPassword;
    private Button logIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logEmail = findViewById(R.id.log_mail);
        logPassword = findViewById(R.id.log_pass);

        progressBar = findViewById(R.id.log_progress);

        register = findViewById(R.id.log_reg_txt);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });

        logIn = findViewById(R.id.log_btn);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });


    }

    private void userLogin() {
        String email = logEmail.getText().toString().trim();
        String password = logPassword.getText().toString().trim();

        if(email.isEmpty()){
            logEmail.setError("Email is Required");
            logEmail.requestFocus();
            return;
        }
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            logEmail.setError("A Valid Email is Required");
            logEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            logPassword.setError("Password is Required");
            logPassword.requestFocus();
            return;
        }
        if(password.length() < 6){
            logEmail.setError("Password needs to be Longer then 6 characters");
            logEmail.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Login.this,BaseActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this,"Failed to login! Check your Credentials",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}