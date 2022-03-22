package com.example.gamerx;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;
import com.squareup.picasso.Picasso;

public class PostDetailsFrag extends Fragment {
String postId,posTitle,postBody;
TextView IdTv;
TextView titleTv;
TextView bodyTv;
ImageView avatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_details, container, false);
        postId = PostDetailsFragArgs.fromBundle(getArguments()).getPostid();
        posTitle = PostDetailsFragArgs.fromBundle(getArguments()).getPostTitle();
        postBody = PostDetailsFragArgs.fromBundle(getArguments()).getPostBody();
        Model.instance.getPostById(postId, new Model.GetPostById() {
            @Override
            public void onComplete(Post post) {
                IdTv.setText(post.getTtitleId());
                titleTv.setText(post.getTitle());
                bodyTv.setText(post.getMbody());
                if (post.getAvatarUrl() != null) {
                    Picasso.get().load(post.getAvatarUrl()).into(avatar);
                }
            }
        });

        IdTv = view.findViewById(R.id.det_post_id);
        titleTv = view.findViewById(R.id.title_det_post);
        bodyTv = view.findViewById(R.id.body_det_post);
        avatar = view.findViewById(R.id.det_post_imagv);



        return view;
    }
}