package com.example.gamerx.Model;

import android.widget.EditText;

import java.util.Map;

public class User {
    public static final String COLLECTION_NAME = "users";
    public String Username, email;
    private String avatarUrl;

    public User() {

    }

    public User(String username, String email) {
        this.Username = username;
        this.email = email;
    }

    public static String getUserId() {
        return null;
    }

    public Map<String, Object> toJson() {
        return null;
    }

   public void setUserAvatarUrl(String url) {
       this.avatarUrl = url;
    }
}

