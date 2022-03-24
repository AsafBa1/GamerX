package Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import com.example.gamerx.R;

public class LoginActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    NavController navCtl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mAppBarConfiguration = new AppBarConfiguration.Builder().build();
        NavHost navHost = (NavHost) getSupportFragmentManager().findFragmentById(R.id.login_nav);
        navCtl = navHost.getNavController();
    }
}