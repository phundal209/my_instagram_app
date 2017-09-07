package com.example.phundal2091.simpleapp.ui.feed;

import com.example.data.repository.UserModel;
import com.example.phundal2091.simpleapp.framework.IPresenter;

/**
 * Created by phundal on 9/6/17.
 */

public interface IFeedPresenter extends IPresenter<FeedView, UserModel> {
    void likeMedia(String mediaId);

    void unlikeMedia(String mediaId);

    void logout();
}
