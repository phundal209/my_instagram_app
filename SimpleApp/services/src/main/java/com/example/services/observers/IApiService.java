package com.example.services.observers;

import com.example.api.recent_media.RecentMedia;
import com.example.data.repository.UserModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by phundal2091 on 9/4/17.
 */

public interface IApiService {
    Observable<UserModel> getUserAsync(String accessToken);

    Observable<RecentMedia> getRecentMediaAsync(String accessToken);

    Observable<Object> postLikeAsync(String mediaId, String accessToken);

    Observable<Object> deleteLikeAsync(String mediaId, String accessToken);
}
