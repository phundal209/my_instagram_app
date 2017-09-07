package com.example.api.recent_media;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phundal on 9/6/17.
 */

public class ThumbnailOfImage {
    @SerializedName("width")
    int width;
    @SerializedName("height")
    int height;
    @SerializedName("url")
    String url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
