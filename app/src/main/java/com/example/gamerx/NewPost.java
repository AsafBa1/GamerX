package com.example.gamerx;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;

import java.util.Random;

import javax.annotation.Nullable;

public class NewPost extends Fragment {

    EditText titleEt;
    EditText bodyEt;
    EditText postId;
    Button saveBtn;
    ImageButton cameraBtn;
    ImageButton galleryBtn;
    ImageView avatar;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_post, container, false);

        progressBar = view.findViewById(R.id.new_post_pb);
        postId = view.findViewById(R.id.new_post_id);
        titleEt = view.findViewById(R.id.new_title_post);
        bodyEt = view.findViewById(R.id.new_post_body);
        saveBtn = view.findViewById(R.id.save_new_post);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        cameraBtn = view.findViewById(R.id.new_camera);
        cameraBtn.setOnClickListener(v -> {
            openCamera();
        });
        galleryBtn = view.findViewById(R.id.new_gallery);
        galleryBtn.setOnClickListener(v -> {
            openGallery();
        });
        avatar = view.findViewById(R.id.det_post_imagv);

        //setHasOptionsMenu(true);
        return view;
    }


    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap imageBitmap;

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }


    private void openGallery() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                imageBitmap = (Bitmap) extras.get("data");
                avatar.setImageBitmap(imageBitmap);
            }
        }
    }

    private void save() {
        progressBar.setVisibility(View.VISIBLE);
        saveBtn.setEnabled(false);
        Random r = new Random();
        String sp = r.toString();
        String[] separated = sp.split("@");
        String id = separated[1];
        String title = titleEt.getText().toString();
        String body = bodyEt.getText().toString();
        Log.d("TAG", "saved name:" + title);
        Post post = new Post(id, title, body);
        if (imageBitmap != null) {
            Model.instance.savePostImage(imageBitmap, id + ".jpg", url -> {
                post.setAvatarUrl(url);
                Model.instance.addPost(post, () -> {
                    Navigation.findNavController(titleEt).navigateUp();
                });
            });
        } else {
            Model.instance.addPost(post, () -> {
                Navigation.findNavController(titleEt).navigateUp();
            });
        }

    }
}