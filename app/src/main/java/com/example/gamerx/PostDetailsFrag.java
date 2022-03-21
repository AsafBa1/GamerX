package com.example.gamerx;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;

public class PostDetailsFrag extends Fragment {
String postId,posTitle;
TextView IdTv;
TextView titleTv;
TextView bodyTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_details, container, false);
        postId = PostDetailsFragArgs.fromBundle(getArguments()).getPostid();
        posTitle = PostDetailsFragArgs.fromBundle(getArguments()).getPostTitle();
        Model.instance.getPostById(postId, new Model.GetPostById() {
            @Override
            public void onComplete(Post post) {
                IdTv.setText(post.getTtitleId());
                titleTv.setText(post.getTitle());
            }
        });

        IdTv = view.findViewById(R.id.det_post_id);
        titleTv = view.findViewById(R.id.title_det_post);
        bodyTv = view.findViewById(R.id.body_det_post);



        return view;
    }
}