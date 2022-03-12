package com.example.gamerx.Model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){
        for(int i=0;i<100;i++){
            Post p = new Post("name",""+i);
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
}
