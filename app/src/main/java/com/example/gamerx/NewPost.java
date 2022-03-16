package com.example.gamerx;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewPost extends Fragment {
    TextView titleTv;
    EditText bodyTv;
    Button nextBtn;
    private String title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_post, container, false);

        titleTv = view.findViewById(R.id.new_title_post);
        nextBtn = view.findViewById(R.id.save_new_post);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleTv.setText("_________");
            }
        });
        if(title != null){
            titleTv.setText(title);
        }
        //setHasOptionsMenu(true);
        return view;
    }

    public void setTitle(String title) {
        if(titleTv != null){
            titleTv.setText(title);
        }
        this.title = title;
    }
}