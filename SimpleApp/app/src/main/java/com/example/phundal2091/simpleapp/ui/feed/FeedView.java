package com.example.phundal2091.simpleapp.ui.feed;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phundal2091.simpleapp.R;
import com.example.phundal2091.simpleapp.framework.ViewScreen;

import butterknife.Bind;

/**
 * Created by phundal on 9/6/17.
 */

public class FeedView extends ViewScreen {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.profile_image)
    ImageView profile_image;
    @Bind(R.id.post_count)
    TextView post_count;
    @Bind(R.id.follower_count)
    TextView follower_count;
    @Bind(R.id.following_count)
    TextView following_count;
    @Bind(R.id.username)
    TextView username;
    @Bind(R.id.description)
    TextView description;
    @Bind(R.id.recycler)
    RecyclerView recycler;
}
