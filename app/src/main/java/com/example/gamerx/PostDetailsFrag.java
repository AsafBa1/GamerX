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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String POST_TITLE_ID = "POST_TITLE_ID";

    // TODO: Rename and change types of parameters
    private String postTitleId;

    public PostDetailsFrag() {
        // Required empty public constructor
    }

    public static PostDetailsFrag newInstance(String PostId) {
        PostDetailsFrag fragment = new PostDetailsFrag();
        Bundle args = new Bundle();
        args.putString(POST_TITLE_ID, PostId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            postTitleId = getArguments().getString(POST_TITLE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_details, container, false);
        Post post = Model.instance.getPostById(postTitleId);

        TextView titleTv = view.findViewById(R.id.title_det_post);
        TextView bodyTv = view.findViewById(R.id.body_det_post);

        titleTv.setText(post.getTitle());
        bodyTv.setText(post.getTitle());
        return view;
    }
}