package com.example.phundal2091.simpleapp.ui.feed;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ProgressBar;

import com.example.api.recent_media.RecentMedia;
import com.example.data.repository.RealmRepository;
import com.example.data.repository.UserModel;
import com.example.phundal2091.simpleapp.framework.IPresenter;
import com.example.phundal2091.simpleapp.framework.Presenter;
import com.example.phundal2091.simpleapp.services.IInstagramService;
import com.example.phundal2091.simpleapp.services.InstagramService;
import com.example.phundal2091.simpleapp.ui.feed.adapters.FeedAdapter;
import com.example.phundal2091.simpleapp.utils.InstagramPreferences;
import com.example.services.observers.IApiService;
import com.example.services.retrofit.IRetrofitProvider;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by phundal on 9/6/17.
 */

public class FeedPresenter extends Presenter<FeedView, UserModel> implements IFeedPresenter {
    private RealmRepository realmRepository;
    private IApiService apiService;
    private IInstagramService instagramService;
    private InstagramPreferences instagramPreferences;
    private FeedAdapter feedAdapter;
    ProgressDialog progressDialog;


    public FeedPresenter(Context context, FeedView view,
                         RealmRepository realmRepository,
                         IApiService apiService,
                         IInstagramService instagramService) {
        super(context, view, false);
        this.realmRepository = realmRepository;
        this.apiService = apiService;
        this.instagramService = instagramService;
        this.instagramPreferences = new InstagramPreferences(context);
    }

    @Override
    public void bindControls() {
        showProgressDialog();
        getUser();
    }

    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

    public void getUser() {
        instagramService.getUser(new InstagramService.OnUserRetrieved() {
            @Override
            public void onRetrieved(UserModel model) {
                if(!model.getUsername().isEmpty()) {
                    view.toolbar.setTitle(model.getUsername());
                    bindUserProfile(model);
                    getRecentMedia();
                }
            }
        });
    }

    public void getRecentMedia() {
        instagramService.getRecentMedia(new InstagramService.OnRecentMediaRetrieved() {
            @Override
            public void onRecentMediaRetrieved(RecentMedia recentMedia) {
                view.recycler.setLayoutManager(new LinearLayoutManager(context));
                feedAdapter = new FeedAdapter(context, instagramPreferences, instagramService, apiService, recentMedia.data, FeedPresenter.this);
                view.recycler.setAdapter(feedAdapter);
                dismissProgressDialog();
            }
        });
    }

    private void bindUserProfile(UserModel model) {
        view.post_count.setText(String.valueOf(model.getCounts().getMedia()));
        view.follower_count.setText(String.valueOf(model.getCounts().getFollows()));
        view.following_count.setText(String.valueOf(model.getCounts().getFollowed_by()));
        view.username.setText(model.getFull_name());
        view.description.setText(model.getBio());
        Picasso.with(context)
                .load(model.getProfile_picture())
                .transform(new CropCircleTransformation())
                .into(view.profile_image);
    }

    @Override
    public void likeMedia(final String mediaId) {
        instagramService.likePost(mediaId, new InstagramService.OnLikeHandler() {
            @Override
            public void onClickedLike() {
                feedAdapter.setLiked(mediaId);
            }

            @Override
            public void onClickedUnlike() {
                // no need to override this here
            }
        });
    }

    @Override
    public void unlikeMedia(final String mediaId) {
        instagramService.unlikePost(mediaId, new InstagramService.OnLikeHandler() {
            @Override
            public void onClickedLike() {
                // no need to override this here
            }

            @Override
            public void onClickedUnlike() {
                feedAdapter.setUnliked(mediaId);
            }
        });
    }

    @Override
    public void logout() {
        instagramPreferences.logout();
    }
}
