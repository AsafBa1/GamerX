package com.example.gamerx.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Post {
    @PrimaryKey
    @NonNull
    String Id = "";
    String Title = "";
    String Mbody = "";


    public Post(){}

    public Post(String id,String title, String mbody) {
        Id = id;
        Title = title;
        Mbody = mbody;
    }

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }

    public String getMbody() {
        return Mbody;
    }
    public void setMbody(String mbody) {
        Mbody = mbody;
    }

    public String getTtitleId() { return Id;}
    public void setId(String id) { Id = id; }
}
