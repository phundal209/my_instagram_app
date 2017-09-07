package com.example.api.recent_media;

import com.example.data.repository.UserModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by phundal on 9/6/17.
 */

public class CaptionObject {
    @SerializedName("id")
    long id;
    @SerializedName("text")
    String text;
    @SerializedName("created_time")
    long created_time;
    @SerializedName("from")
    UserModel from;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCreated_time() {
        return created_time;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public UserModel getFrom() {
        return from;
    }

    public void setFrom(UserModel from) {
        this.from = from;
    }
}
