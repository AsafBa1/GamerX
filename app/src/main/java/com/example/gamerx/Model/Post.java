package com.example.gamerx.Model;

public class Post {
    String Title = "";
    String Mbody = "";

    public Post(){}

    public Post(String title, String mbody) {
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

}
