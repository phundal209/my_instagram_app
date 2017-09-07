package com.example.services.rest;

import com.example.api.LikeResponse;
import com.example.api.UserResponse;
import com.example.api.recent_media.RecentMedia;
import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by phundal2091 on 9/4/17.
 */

public interface IRestClient {
    @GET("/v1/users/self/")
    Observable<UserResponse> getUser(@Query("access_token") String accessToken);

    @GET("/v1/users/self/media/recent/")
    Observable<RecentMedia> getRecentMedia(@Query("access_token") String accessToken);

    @GET("/v1/media/{media-id}/likes")
    Observable<LikeResponse> getLikes(@Path("media-id") int mediaId, @Query("access_token") String accessToken);

    @POST("/v1/media/{media-id}/likes")
    Observable<Object> postLike(@Path("media-id") String mediaId, @Query("access_token") String accessToken);

    @DELETE("/v1/media/{media-id}/likes")
    Observable<Object> deleteLike(@Path("media-id") String mediaId, @Query("access_token") String accessToken);

}
