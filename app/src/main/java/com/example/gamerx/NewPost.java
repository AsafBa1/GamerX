package com.example.gamerx;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;

public class NewPost extends Fragment {
    EditText titleEt;
    EditText bodyEt;
    EditText postId;
    Button saveBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_post, container, false);

        postId = view.findViewById(R.id.new_post_id);
        titleEt = view.findViewById(R.id.new_title_post);
        bodyEt = view.findViewById(R.id.new_post_body);
        saveBtn = view.findViewById(R.id.save_new_post);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { save(); }});
        //setHasOptionsMenu(true);
        return view;
    }

    private void save() {
        String id = postId.getText().toString();
        String title = titleEt.getText().toString();
        String body = bodyEt.getText().toString();
        Log.d("TAG","saved name:" + title);
        Post post = new Post(id,title,body);
        Model.instance.addPost(post,()->{
            Navigation.findNavController(titleEt).navigateUp();
        });
    }

}