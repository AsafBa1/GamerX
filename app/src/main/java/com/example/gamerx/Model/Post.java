package com.example.gamerx.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Entity
public class Post {


    final public static String COLLECTION_NAME = "Posts";
    @PrimaryKey
    @NonNull
    String Id = "";
    String Title = "";
    String Body = "";


    public Post(){}

    public Post(String id,String title, String body){
        Id = id;
        Title = title;
        Body = body;
    }

    public Post(String title, String body) {
        Title = title;
        Body = body;
    }

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }

    public String getMbody() {
        return Body;
    }
    public void setMbody(String body) {
        Body = body;
    }

    public String getTtitleId() { return Id;}
    public void setId(String id) { Id = id; }

    public Map<String,Object> toJson(){
        Map<String,Object> json = new HashMap<String,Object>();
        json.put("id",Id);
        json.put("title",Title);
        json.put("body",Body);
        return json;
    }

    public static Post create(Map<String, Object> json) {
        String id = (String) json.get("id");
        String title = (String) json.get("title");
        String body = (String) json.get("body");

        Post post = new Post(id,title,body);
        return post;
    }
}
