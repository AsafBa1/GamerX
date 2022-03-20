package com.example.gamerx.Model;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.core.os.HandlerCompat;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Model {
    ModelFireBase modelFireBase;

    public static final Model instance = new Model();
    Executor executor =Executors.newFixedThreadPool(1);
    Handler mainThread = HandlerCompat.createAsync(Looper.getMainLooper());


    private Model(){ }


   public interface GetAllPostsListener{
        void onComplete(List<Post> list);
   }

    public void getAllPosts(GetAllPostsListener listener){
        modelFireBase.getAllPosts(listener);
    }

    public interface AddPostListener{
        void onComplete();
    }
    public void addPost(Post post,AddPostListener listener){
        modelFireBase.addPost(post,listener);
    }

    public Post getPostById(String postTitleId) {
        modelFireBase.getPostById(postTitleId);
        return null;
    }
}
