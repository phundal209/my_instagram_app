package rest;

import android.support.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by GoFundMe on 1/11/17.
 */

public interface ITemplateRestClient{

    @GET("app/path")
    Call<Response> getSomePathResponse(@Nullable @Header("HEADER") String header);
}
