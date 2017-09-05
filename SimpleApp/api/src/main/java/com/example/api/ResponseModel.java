package com.example.api;

import com.example.data.CustomData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by phundal2091 on 9/4/17.
 */
public class ResponseModel {
    @SerializedName("posts")
    List<CustomData> posts;

    public List<CustomData> getPosts() {
        return posts;
    }

    public void setPosts(List<CustomData> posts) {
        this.posts = posts;
    }
}
