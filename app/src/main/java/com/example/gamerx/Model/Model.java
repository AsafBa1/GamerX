package com.example.gamerx.Model;

import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Model {
    ModelFireBase modelFireBase = new ModelFireBase();

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

    public interface GetPostById{
        void onComplete(Post post);
    }
    public Post getPostById(String postTitleId,GetPostById listener) {
        modelFireBase.getPostById(postTitleId,listener);
        return null;
    }
    public interface AddUserListener{
        void onComplete();
    }
    public void addUser(User user, AddUserListener listener){
        modelFireBase.addUser(user,listener);
    }
}
