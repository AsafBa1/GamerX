package com.example.gamerx;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFrag extends Fragment {
    Button toList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);


        toList = view.findViewById(R.id.menu_post_btn);
        toList.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFrag2_to_postsListFrag2));
        return view;
    }
}