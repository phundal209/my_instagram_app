package com.example.phundal2091.simpleapp.ui.feed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.data.repository.UserModel;
import com.example.phundal2091.simpleapp.InstagramApplication;
import com.example.phundal2091.simpleapp.injection.DataModule;
import com.example.phundal2091.simpleapp.utils.InstagramPreferences;
import com.example.phundal2091.simpleapp.R;
import com.example.phundal2091.simpleapp.services.IInstagramService;
import com.example.phundal2091.simpleapp.services.InstagramService;
import com.example.services.observers.ApiService;
import com.example.services.observers.IApiService;
import com.example.services.retrofit.IRetrofitProvider;
import com.example.services.retrofit.RetrofitProvider;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class FeedActivity extends AppCompatActivity {

    @Inject
    IFeedPresenter feedPresenter;

    private IFeedComponent component;
    IFeedComponent component() {
        if(component == null) {
            component = DaggerIFeedComponent.builder()
                    .applicationComponent(((InstagramApplication) getApplication()).getComponent())
                    .feedModule(new FeedModule(this))
                    .dataModule(new DataModule(this))
                    .build();
        }
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        component().inject(this);
        feedPresenter
                .getView()
                .withRootView(this.findViewById(android.R.id.content).getRootView());
        feedPresenter.bindControls();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.feed_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                feedPresenter.logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
