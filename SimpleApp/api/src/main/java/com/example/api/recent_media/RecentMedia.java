package com.example.api.recent_media;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by phundal2091 on 9/6/17.
 */

public class RecentMedia {
    @SerializedName("data")
    public List<Media> data;
}
