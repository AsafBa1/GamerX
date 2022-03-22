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

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;

import java.util.Random;

import javax.annotation.Nullable;


public class ProfileFrag extends Fragment {
    Button saveBtn;
    ImageButton cameraBtn;
    ImageButton galleryBtn;
    ImageView avatar;
    EditText userName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        saveBtn = view.findViewById(R.id.profile_save_btn);
        saveBtn.setOnClickListener(v -> {
            save();
        });
        cameraBtn = view.findViewById(R.id.profile_camera);
        cameraBtn.setOnClickListener(v -> {
            openCamera();
        });
        galleryBtn = view.findViewById(R.id.profile_gallery);
        galleryBtn.setOnClickListener(v -> {
            openGallery();
        });
        avatar = view.findViewById(R.id.profile_avatar);

        return view;
    }

    private void save() {
        //progressBar.setVisibility(View.VISIBLE);
       // saveBtn.setEnabled(false);
       // Random r = new Random();
        //String sp = r.toString();
        //String[] separated = sp.split("@");
        //String id = separated[1];
       // String username = titleEt.getText().toString();
       // Log.d("TAG", "saved name:" + title);
        //if (imageBitmap != null) {
           // Model.instance.saveUserImage(imageBitmap, id, url -> {

           // })
       // } else {
          //  Model.instance.addPost(post, () -> {
             //   Navigation.findNavController(titleEt).navigateUp();
            //});
       // }
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap imageBitmap;

    private void openGallery() {
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if(resultCode == RESULT_OK){
                Bundle extras = data.getExtras();
                imageBitmap = (Bitmap) extras.get("data");
                avatar.setImageBitmap(imageBitmap);
            }
        }
    }
}