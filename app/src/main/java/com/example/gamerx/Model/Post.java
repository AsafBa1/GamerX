package com.example.gamerx.Model;

public class Post {
    String Title = "";
    String Mbody = "";
    String Id = "";

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
