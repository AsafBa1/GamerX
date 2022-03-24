package com.example.gamerx.Model;

import android.widget.EditText;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;

import java.util.HashMap;
import java.util.Map;

public class User {
    public static final String COLLECTION_NAME = "users";
    public String userId;
    public String Username, email;
    private String avatarUserUrl;

    public String getAvatarUserUrl() {
        return avatarUserUrl;
    }

    public void setAvatarUserUrl(String avatarUserUrl) {
        this.avatarUserUrl = avatarUserUrl;
    }

    public User() {

    }

    public User(String id, String username, String email,String avatarUserUrl) {
        this.userId = id;
        this.Username = username;
        this.email = email;
        this.avatarUserUrl =avatarUserUrl;
    }

    public User(String username, String email) {
        this.Username = username;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public Map<String, Object> toJson() {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("id", userId);
        json.put("username", Username);
        json.put("email", email);
        json.put("avatarUrl", avatarUserUrl);
        return json;

    }

}

