package com.example.gamerx.Model;

import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){
        for(int i=0;i<20;i++){
            Post p = new Post(""+i,"name","Post body");
            data.add(p);
        }
    }

    List<Post> data = new LinkedList<Post>();

    public List<Post> getAllPosts(){
        return data;
    }
    public void addPost(Post post){
        data.add(post);
    }

    public Post getPostById(String postTitleId) {
        for(Post p:data){
            if(p.getTtitleId().equals(postTitleId)){
                return p;
            }
        }
        return null;
    }
}
