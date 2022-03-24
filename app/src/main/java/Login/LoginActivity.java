package Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gamerx.BaseActivity;
import com.example.gamerx.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button loginBtn;
    Button registerBtn;
    EditText emailEt,passwordEt;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        emailEt = findViewById(R.id.login_email);
        passwordEt = findViewById(R.id.login_pass);
        progressBar = findViewById(R.id.login_pb);
        registerBtn = findViewById(R.id.login_register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginBtn = findViewById(R.id.login_login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEt.getText().toString().trim();
                String password = passwordEt.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    emailEt.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    passwordEt.setError("Password is Required");
                    return;
                }
                if(password.length() < 6){
                    passwordEt.setError("Password should be bigger then 6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(), BaseActivity.class));

                        }else{
                            Toast.makeText(LoginActivity.this,"Wrong Password or email" + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });


    }
}