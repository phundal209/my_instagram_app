package com.example.api.recent_media;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phundal on 9/6/17.
 */

public class MediaObject {
    @SerializedName("low_resolution")
    ThumbnailOfImage thumbnailOfImage;

    public ThumbnailOfImage getThumbnailOfImage() {
        return thumbnailOfImage;
    }

    public void setThumbnailOfImage(ThumbnailOfImage thumbnailOfImage) {
        this.thumbnailOfImage = thumbnailOfImage;
    }
}
