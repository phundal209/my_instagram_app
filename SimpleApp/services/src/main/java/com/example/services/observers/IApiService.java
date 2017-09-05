package com.example.services.observers;

import com.example.data.CustomData;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by phundal2091 on 9/4/17.
 */

public interface IApiService {
    Observable<List<CustomData>> getCustomDataAsync();
}
