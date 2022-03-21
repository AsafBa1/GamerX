package com.example.gamerx;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.gamerx.Model.Model;
import com.example.gamerx.Model.Post;

import java.util.List;

public class PostsListFragViewModel extends ViewModel {
    LiveData<List<Post>> data;

    public PostsListFragViewModel(){
        data = Model.instance.getAll();
    }

    public LiveData<List<Post>> getData() {
        return data;
    }

}
