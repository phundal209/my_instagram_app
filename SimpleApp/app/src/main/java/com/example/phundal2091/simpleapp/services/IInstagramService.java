package com.example.phundal2091.simpleapp.services;

/**
 * Created by phundal2091 on 9/6/17.
 */

public interface IInstagramService {
    void getUser(InstagramService.OnUserRetrieved onUserRetrieved);

    void getRecentMedia(InstagramService.OnRecentMediaRetrieved onRecentMediaRetrieved);

    void likePost(String mediaId, InstagramService.OnLikeHandler onLikeHandler);

    void unlikePost(String mediaId, InstagramService.OnLikeHandler onLikeHandler);
}
