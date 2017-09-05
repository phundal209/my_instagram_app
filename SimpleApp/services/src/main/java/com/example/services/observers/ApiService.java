package com.example.services.observers;

import com.example.api.ResponseModel;
import com.example.data.CustomData;
import com.example.services.rest.IRestClient;
import com.example.services.retrofit.IRetrofitProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.realm.Realm;

/**
 * Created by phundal2091 on 9/4/17.
 */

public class ApiService implements IApiService {
    private IRestClient restClient;
    private Realm realm;


    public ApiService(IRetrofitProvider retrofitProvider) {
        this.restClient = retrofitProvider.getRetrofit().create(IRestClient.class);
    }


    @Override
    public Observable<List<CustomData>> getCustomDataAsync() {
        return restClient.getCustomList().map(new Function<ResponseModel, List<CustomData>>() {
            @Override
            public List<CustomData> apply(final ResponseModel responseModel) throws Exception {
                if (responseModel != null) {
                    // cache the response
                    realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    realm.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.copyToRealmOrUpdate(responseModel.getPosts());
                        }
                    });
                    realm.commitTransaction();
                    return responseModel.getPosts();
                }
                // rxjava2 doesn't support null types, must return empty list instead
                List<CustomData> customDatas = new ArrayList<CustomData>();
                customDatas.add(new CustomData());
                return customDatas;
            }
        });

    }

}
