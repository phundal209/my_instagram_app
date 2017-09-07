package com.example.api.recent_media;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phundal on 9/6/17.
 */

public class LikeObject {
    @SerializedName("count")
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
