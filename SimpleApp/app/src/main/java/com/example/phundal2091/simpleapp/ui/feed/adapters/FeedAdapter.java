package com.example.phundal2091.simpleapp.ui.feed.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api.recent_media.Media;
import com.example.api.recent_media.RecentMedia;
import com.example.phundal2091.simpleapp.services.IInstagramService;
import com.example.phundal2091.simpleapp.ui.feed.IFeedPresenter;
import com.example.phundal2091.simpleapp.utils.InstagramPreferences;
import com.example.phundal2091.simpleapp.R;
import com.example.phundal2091.simpleapp.services.InstagramService;
import com.example.services.observers.IApiService;
import com.example.services.retrofit.IRetrofitProvider;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by phundal2091 on 9/6/17.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private Context context;
    private InstagramPreferences instagramPreferences;
    private IInstagramService instagramService;
    private IApiService apiService;
    private List<Media> data;
    private IFeedPresenter feedPresenter;

    public FeedAdapter(Context context, InstagramPreferences instagramPreferences,
                       IInstagramService instagramService,
                       IApiService apiService, List<Media> data,
                       IFeedPresenter feedPresenter) {
        this.context = context;
        this.instagramPreferences = instagramPreferences;
        this.instagramService = instagramService;
        this.apiService = apiService;
        this.data = data;
        this.feedPresenter = feedPresenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.instagram_display_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Media media = data.get(position);
        holder.mediaPostedBy.setText(media.getUser().getUsername());
        Picasso.with(context)
                .load(media.getUser().getProfile_picture())
                .transform(new CropCircleTransformation())
                .into(holder.userAvatar);
        Picasso.with(context)
                .load(media.getMediaObject().getThumbnailOfImage().getUrl())
                .error(R.mipmap.empty_photo)
                .into(holder.instagramImageToDisplayOnFeed);
        if(media.getLikeObject().getCount() == 1) {
            holder.numberOfLikes.setVisibility(View.VISIBLE);
            holder.numberOfLikes.setText(context.getString(R.string.number_of_likes_singular));
        } else if(media.getLikeObject().getCount() > 1) {
            holder.numberOfLikes.setVisibility(View.VISIBLE);
            holder.numberOfLikes.setText(context.getString(R.string.number_of_likes, media.getLikeObject().getCount()));
        } else if(media.getLikeObject().getCount() <= 0) {
            holder.numberOfLikes.setVisibility(View.GONE);
        }

        if(media.isUser_has_liked()) { holder.likedButton.setLiked(true);  }

        holder.likedButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                feedPresenter.likeMedia(media.getId());
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                feedPresenter.unlikeMedia(media.getId());
            }
        });
    }

    public void setLiked(String id) {
        for(Media media : data) {
            if(media.getId().equals(id)) {
                final int countOfLikes = media.getLikeObject().getCount();
                media.getLikeObject().setCount(countOfLikes + 1);
                media.setUser_has_liked(true);
            }
        }
        notifyDataSetChanged();
    }

    public void setUnliked(String id) {
        for (Media media : data) {
            if(media.getId().equals(id)) {
                int countOfLikes = media.getLikeObject().getCount();
                media.getLikeObject().setCount(countOfLikes - 1);
                media.setUser_has_liked(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(data == null) { return 0; }
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.userAvatar)
        public ImageView userAvatar;
        @Bind(R.id.mediaPostedBy)
        public TextView mediaPostedBy;
        @Bind(R.id.instagramImageToDisplayOnFeed)
        public ImageView instagramImageToDisplayOnFeed;
        @Bind(R.id.numberOfLikes)
        public TextView numberOfLikes;
        @Bind(R.id.likedButton)
        public LikeButton likedButton;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
