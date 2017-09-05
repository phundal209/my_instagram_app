package com.example.phundal2091.simpleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.data.CustomData;
import com.example.data.repository.RealmRepository;
import com.example.services.observers.ApiService;
import com.example.services.observers.IApiService;
import com.example.services.retrofit.IRetrofitProvider;
import com.example.services.retrofit.RetrofitProvider;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Retrofit;

/**
 * Sample app to show a network request, binding to UI, and optimizations
 * on showing UI.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    private IRetrofitProvider retrofitProvider;
    private IApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.retrofitProvider = new RetrofitProvider();
        this.apiService = new ApiService(retrofitProvider);

        apiService.getCustomDataAsync().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<List<CustomData>>() {
                        @Override
                        public void accept(List<CustomData> customDatas) throws Exception {
                            if(customDatas != null) {
                                recyclerView.setAdapter(new CustomDataAdapter(MainActivity.this, customDatas));
                                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            }
                        }
                    });

    }
}
