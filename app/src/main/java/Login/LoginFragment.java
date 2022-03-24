package Login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gamerx.BaseActivity;
import com.example.gamerx.Model.Model;
import com.example.gamerx.R;


public class LoginFragment extends Fragment {
    private EditText email;
    private EditText password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_login, container, false);

        email = view.findViewById(R.id.login_rmail);
        password = view.findViewById(R.id.login_password);


       // view.findViewById(R.id.loginfrag_login_btn).setOnClickListener(v -> {
           // String txt_email = username.getText().toString();
           // String txt_password = password.getText().toString();

           // if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
           //     Toast.makeText(getContext(), "please enter email and password!", Toast.LENGTH_LONG).show();
           // } else {
            //    Model.instance.loginUser(txt_email, txt_password, bool -> {
              //      if (bool) toFeedActivity();
              //      else Toast.makeText(getContext(), "The password or username is incorrect", Toast.LENGTH_LONG).show();
              //  });
          //  }
        //});

       return view;
    }

    private void toFeedActivity() {
        Intent intent = new Intent(getContext(), BaseActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}