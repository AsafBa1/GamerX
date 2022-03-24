package Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;

import com.example.gamerx.BaseActivity;
import com.example.gamerx.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    private AppBarConfiguration mAppBarConfiguration;
    NavController navCtl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), BaseActivity.class));
            finish();
        }


    }
}