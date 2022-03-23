package com.example.gamerx;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;
import com.squareup.picasso.Picasso;


public class EditPost extends Fragment {
    String posTitle,postBody;
    TextView IdTv;
    TextView titleTv;
    TextView bodyTv;
    ImageView avatar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_post, container, false);


        //posTitle = EditPostArgs.fromBundle(getArguments()).getPostTitle();
        //postBody = EditPostArgs.fromBundle(getArguments()).getPostBody();
        titleTv.setText(posTitle);
        bodyTv.setText(postBody);



        IdTv = view.findViewById(R.id.edit_id);
        titleTv = view.findViewById(R.id.edit_title);
        bodyTv = view.findViewById(R.id.edit_body);
        avatar = view.findViewById(R.id.edit_image);

        return view;
    }
}