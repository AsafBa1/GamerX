package com.example.gamerx.Model;

import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Model {
    ModelFireBase modelFireBase = new ModelFireBase();

    public static final Model instance = new Model();
    Executor executor =Executors.newFixedThreadPool(1);
    Handler mainThread = HandlerCompat.createAsync(Looper.getMainLooper());

    public enum PostListLoadingState{
        loading,
        loaded
    }


    MutableLiveData<PostListLoadingState> postListLoadingState = new MutableLiveData<PostListLoadingState>();
    public MutableLiveData<PostListLoadingState> getPostListLoadingState() {
        return postListLoadingState;
    }





    private Model(){
        postListLoadingState.setValue(PostListLoadingState.loaded);
    }


    MutableLiveData<List<Post>> postsList = new MutableLiveData<List<Post>>();
    public LiveData<List<Post>> getAll(){
        if(postsList.getValue() == null){
            refreshPostList();}
        return postsList;
    }

    public void refreshPostList(){
        postListLoadingState.setValue(PostListLoadingState.loading);
        modelFireBase.getAllPosts(new ModelFireBase.GetAllPostsListener() {
            @Override
            public void onComplete(List<Post> list) {
                postsList.setValue(list);
                postListLoadingState.setValue(PostListLoadingState.loaded);
            }
        });
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
