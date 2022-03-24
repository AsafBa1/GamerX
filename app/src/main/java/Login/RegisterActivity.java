package Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class RegisterActivity extends AppCompatActivity {
EditText emailEd,usernameEd,passwordEd;
Button registerBtn;
FirebaseAuth mAuth;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();


        emailEd = findViewById(R.id.reg_email);
        usernameEd =findViewById(R.id.reg_username);
        passwordEd = findViewById(R.id.reg_password);
        progressBar =findViewById(R.id.registr_pb);

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), BaseActivity.class));
            finish();
        }
        registerBtn = findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEd.getText().toString().trim();
                String password = passwordEd.getText().toString().trim();
                String username = usernameEd.getText().toString().trim();

                if(TextUtils.isEmpty(username)){
                    usernameEd.setError("User Name is Required");
                }
                if(TextUtils.isEmpty(email)){
                    emailEd.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    passwordEd.setError("Password is Required");
                    return;
                }
                if(password.length() < 6){
                    passwordEd.setError("Password should be bigger then 6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(), BaseActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this,"Error !" + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

}