package com.example.api.recent_media;

import com.example.data.repository.UserModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by phundal on 9/6/17.
 */

public class Media {
    @SerializedName("id")
    String id;
    @SerializedName("user")
    UserModel user;
    @SerializedName("images")
    MediaObject mediaObject;
    @SerializedName("created_time")
    long created_time;
    @SerializedName("caption")
    CaptionObject captionObject;
    @SerializedName("user_has_liked")
    boolean user_has_liked;
    @SerializedName("likes")
    LikeObject likeObject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public MediaObject getMediaObject() {
        return mediaObject;
    }

    public void setMediaObject(MediaObject mediaObject) {
        this.mediaObject = mediaObject;
    }

    public long getCreated_time() {
        return created_time;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public CaptionObject getCaptionObject() {
        return captionObject;
    }

    public void setCaptionObject(CaptionObject captionObject) {
        this.captionObject = captionObject;
    }

    public boolean isUser_has_liked() {
        return user_has_liked;
    }

    public void setUser_has_liked(boolean user_has_liked) {
        this.user_has_liked = user_has_liked;
    }

    public LikeObject getLikeObject() {
        return likeObject;
    }

    public void setLikeObject(LikeObject likeObject) {
        this.likeObject = likeObject;
    }
}
