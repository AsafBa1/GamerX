package com.example.gamerx.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.firebase.Timestamp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FieldValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Entity
public class Post {


    //String key = "PostsLastUpdateDate";
    final public static String COLLECTION_NAME = "Posts";
    @PrimaryKey
    @NonNull
    String Id = "";
    String Title = "";
    String Body = "";

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    Long updateDate = new Long(0);


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
        json.put("updateDate",FieldValue.serverTimestamp());
        return json;
    }

    public static Post create(Map<String, Object> json) {
        String id = (String) json.get("id");
        String title = (String) json.get("title");
        String body = (String) json.get("body");
        Timestamp ts = (Timestamp)json.get("updateDate");
        Long updateDate = null;
        updateDate = ts.getSeconds();

        Post post = new Post(id,title,body);
        post.setUpdateDate(updateDate);
        return post;
    }
    // Todo...
    public Long getUpdateDate() {
        return updateDate;
    }
}
