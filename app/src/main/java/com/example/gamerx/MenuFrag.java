package com.example.gamerx;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        setHasOptionsMenu(true);
        return view;
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.first_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(!super.onOptionsItemSelected(item)){
            switch ((item.getItemId())){
                case R.id.menu_logout:
                    Log.d("TAG","add");
                    //navController.navigate(R.id.action_global_profileFrag2);
                    break;
                case R.id.profile_menu:

            }
        }
        return true;
    }

}