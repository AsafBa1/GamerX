package com.example.gamerx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamerx.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView editUser,editEmail,editPass;
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

        editEmail =(EditText) findViewById(R.id.sign_edit_email);
        editPass = (EditText) findViewById(R.id.sign_edit_password);
        editUser = (EditText) findViewById(R.id.sign_edit_user);

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

        progressbar.setVisibility((View.VISIBLE));
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           User user = new User(editUser.toString(),editEmail.toString());

                           FirebaseDatabase.getInstance().getReference("Users")
                                   .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                   .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                               @Override
                               public void onComplete(@NonNull Task<Void> task) {
                                   if(task.isSuccessful()){
                                       Toast.makeText(SignUp.this,"User Has Been Registered Successfully!",Toast.LENGTH_LONG).show();
                                       progressbar.setVisibility(View.GONE);

                                   }else{
                                       Toast.makeText(SignUp.this,"Failed To Register User!",Toast.LENGTH_LONG).show();
                                       progressbar.setVisibility(View.GONE);
                                   }
                               }
                           });
                       }
                    }
                });

    }
}