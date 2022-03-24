package com.example.gamerx;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.Random;

public class PostDetailsFrag extends Fragment {
String postId,posTitle,postBody;
TextView IdTv;
TextView titleTv;
TextView bodyTv;
ImageView avatar;
Button editBtn;
Button deleteBtn;
Post post;
ImageButton cameraBtn;
ImageButton galleryBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_details, container, false);
        postId = PostDetailsFragArgs.fromBundle(getArguments()).getPostId();
        posTitle = PostDetailsFragArgs.fromBundle(getArguments()).getPostTitle();
        postBody = PostDetailsFragArgs.fromBundle(getArguments()).getPostbody();
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
        galleryBtn = view.findViewById(R.id.edit_gallery);
        cameraBtn = view.findViewById(R.id.edit_camera);
        avatar = view.findViewById(R.id.new_post_imagv);
        editBtn = view.findViewById(R.id.det_edit_btn);
        editBtn.setOnClickListener(v -> {
            save("edit");
            Navigation.findNavController(v).navigateUp();
        });
        deleteBtn = view.findViewById(R.id.det_delete);
        deleteBtn.setOnClickListener((v) -> {
            save("delete");
            Navigation.findNavController(v).navigateUp();
        });
        //setButtonVisibility(post);
        return view;
    }

    public void displayPost(Post post){
        titleTv.setText(post.getTitle());
        bodyTv.setText(post.getMbody());
        this.post=post;
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_PICK = 2;
    Bitmap imageBitmap;

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }


    private void openGallery() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent,REQUEST_IMAGE_PICK);
    }
    private void save(String type) {
       cameraBtn.setEnabled(false);
       galleryBtn.setEnabled(false);
        this.post.setTitle(titleTv.getText().toString());
        this.post.setMbody(bodyTv.getText().toString());
        this.post.setUpdateDate(System.currentTimeMillis());
        this.post.setDisplayPost(type.equals("edit"));
        if (imageBitmap != null) {
            Model.instance.savePostImage(imageBitmap, this.post.getTtitleId().toString() + ".jpg", url -> {
                this.post.setAvatarUrl(url);
                Model.instance.editPost(this.post);
            });
        } else
            Model.instance.editPost(this.post);
    }
}

