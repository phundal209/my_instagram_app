package com.example.services.rest;

import com.example.api.ResponseModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by phundal2091 on 9/4/17.
 */

public interface IRestClient {
    @GET("/db/")
    Observable<ResponseModel> getCustomList();
}
