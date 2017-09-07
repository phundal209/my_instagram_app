package com.example.phundal2091.simpleapp.services;

import android.content.Context;

import com.example.api.recent_media.RecentMedia;
import com.example.data.repository.UserModel;
import com.example.phundal2091.simpleapp.utils.InstagramPreferences;
import com.example.services.observers.IApiService;
import com.example.services.retrofit.IRetrofitProvider;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by phundal2091 on 9/6/17.
 */

public class InstagramService implements IInstagramService {
    private Context context;
    private IRetrofitProvider retrofitProvider;
    private IApiService apiService;
    private InstagramPreferences preferences;

    public InstagramService(Context context, IRetrofitProvider retrofitProvider,
                            IApiService apiService, InstagramPreferences preferences) {
        this.context = context;
        this.retrofitProvider = retrofitProvider;
        this.apiService = apiService;
        this.preferences = preferences;
    }

    @Override
    public void getUser(final OnUserRetrieved onUserRetrieved) {
        if(preferences.getAuthToken() != null) {
            apiService.getUserAsync(preferences.getAuthToken())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer<UserModel>() {
                @Override
                public void accept(UserModel userModel) throws Exception {
                    onUserRetrieved.onRetrieved(userModel);
                }
            });
        }
    }

    @Override
    public void getRecentMedia(final OnRecentMediaRetrieved onRecentMediaRetrieved) {
        if(preferences.getAuthToken() != null) {
            apiService.getRecentMediaAsync(preferences.getAuthToken())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer<RecentMedia>() {
                        @Override
                        public void accept(RecentMedia recentMedias) throws Exception {
                            if(recentMedias != null) {
                                onRecentMediaRetrieved.onRecentMediaRetrieved(recentMedias);
                            }
                        }
                    });
        }
    }

    @Override
    public void likePost(String mediaId, final OnLikeHandler onLikeHandler) {
        if(preferences.getAuthToken() != null) {
            apiService.postLikeAsync(mediaId, preferences.getAuthToken())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {
                            onLikeHandler.onClickedLike();
                        }
                    });
        }
    }

    @Override
    public void unlikePost(String mediaId, final OnLikeHandler onLikeHandler) {
        if(preferences.getAuthToken() != null) {
            apiService.deleteLikeAsync(mediaId, preferences.getAuthToken())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {
                            onLikeHandler.onClickedUnlike();
                        }
                    });
        }
    }

    public interface OnUserRetrieved {
        void onRetrieved(UserModel model);
    }

    public interface OnRecentMediaRetrieved {
        void onRecentMediaRetrieved(RecentMedia recentMedia);
    }

    public interface OnLikeHandler {
        void onClickedLike();
        void onClickedUnlike();
    }
}
