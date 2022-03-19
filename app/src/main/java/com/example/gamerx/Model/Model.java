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
    public static final Model instance = new Model();
    Executor executor =Executors.newFixedThreadPool(1);
    Handler mainThread = HandlerCompat.createAsync(Looper.getMainLooper());


    private Model(){ }


   public interface GetAllPostsListener{
        void onComplete(List<Post> list);
   }

    public void getAllPosts(GetAllPostsListener listener){
        executor.execute(()->{
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
           List<Post> list = AppLocalDb.db.postDao().getAll();
           mainThread.post(()->{
               listener.onComplete(list);
           });
        });
    }

    public interface AddPostListener{
        void onComplete();
    }
    public void addPost(Post post,AddPostListener listener){
        executor.execute(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AppLocalDb.db.postDao().insertAll(post);
            mainThread.post(()->{
                listener.onComplete();
            });
        });
    }

    public Post getPostById(String postTitleId) {

        return null;
    }
}
