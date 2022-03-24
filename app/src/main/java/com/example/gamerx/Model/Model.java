package com.example.gamerx.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.core.os.HandlerCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gamerx.MyApplication;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Model {
    User user = null;
    ModelFireBase modelFireBase = new ModelFireBase();
    public static final Model instance = new Model();
    public Executor executor =Executors.newFixedThreadPool(1);
     public Handler mainThread = HandlerCompat.createAsync(Looper.getMainLooper());
    MutableLiveData<PostListLoadingState> postListLoadingState = new MutableLiveData<PostListLoadingState>();

    public boolean isSignedIn() {return modelFireBase.isSignedIn(); }

    public void editPost(Post post) {
        modelFireBase.addPost(post, this::refreshPostList);
    }



    public interface SaveImageListener{
void onComplete(String url);
}
    public void savePostImage(Bitmap imageBitmap, String imageName,SaveImageListener listener) {
    modelFireBase.savePostImage(imageBitmap,imageName,listener);
    }

    public void saveUserImage(Bitmap imageBitmap, String imageName,SaveImageListener listener) {
        modelFireBase.saveUserImage(imageBitmap,imageName,listener);
    }

    public enum PostListLoadingState{
        loading,
        loaded
    }



    public MutableLiveData<PostListLoadingState> getPostListLoadingState() {
        return postListLoadingState;
    }





    private Model(){
        postListLoadingState.setValue(PostListLoadingState.loaded);
    }


    MutableLiveData<List<Post>> postsList = new MutableLiveData<List<Post>>();
    public LiveData<List<Post>> getAll(){
        if(postsList.getValue() == null){ refreshPostList();}
        return postsList;
    }

    public void refreshPostList(){

        //get last local update date
        Long lastUpdateDate = MyApplication.getContext().getSharedPreferences("TAG", Context.MODE_PRIVATE).getLong("PostsLastUpdateDate",0);

        //firebase get all updates since lastLocalUpdate
        modelFireBase.getAllPosts(lastUpdateDate,new ModelFireBase.GetAllPostsListener() {
            @Override
            public void onComplete(List<Post> list) {
               //add all record to local db
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        Long lud = new Long(0);
                        Log.d("TAG","fb returned " + list.size());
                        for(Post post:list){
                            AppLocalDb.db.postDao().insertAll(post);
                            if(lud < post.getUpdateDate()){
                                lud = post.getUpdateDate();
                            }
                        }

                        MyApplication.getContext().getSharedPreferences("TAG",Context.MODE_PRIVATE)
                                .edit().putLong("PostsLastUpdateDate",lud).commit();

                        List<Post> pstList = AppLocalDb.db.postDao().getAll();
                        postsList.postValue(pstList);
                        postListLoadingState.postValue(PostListLoadingState.loaded);
                    }
                });
            }
        });
    }

    public interface AddPostListener{
        void onComplete();
    }
    public void addPost(Post post,AddPostListener listener){
        modelFireBase.addPost(post, new AddPostListener() {
            @Override
            public void onComplete() {
                refreshPostList();
                listener.onComplete();
            }
        });
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
    public interface EditPostListener{
        void onComplete();
    }

    public void editPost(Post post,EditPostListener listener){
        modelFireBase.editPost(post, new EditPostListener() {
            @Override
            public void onComplete() {
                refreshPostList();
                listener.onComplete();
            }
        });
    }
    public void registerUser(String Email, String name,ModelFireBase.RegisterListener listener) {
    }

}
