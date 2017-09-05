package rest;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;
import java.util.concurrent.Callable;

import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeFromCallable;

/**
 * Created by GoFundMe on 1/11/17.
 */

public class TemplateApiService implements ITemplateApiService {

    private ITemplateRestClient templateRestClient;
    private Context context;
    private IAsyncFactory asyncFactory;
    private IErrorHandlingService errorHandlingService;
    private SharedPreferences sharedPreferences;

    public TemplateApiService(ITemplateRestClient templateRestClient, Context context, IAsyncFactory asyncFactory, IErrorHandlingService errorHandlingService, SharedPreferences sharedPreferences) {
        this.templateRestClient = templateRestClient;
        this.context = context;
        this.asyncFactory = asyncFactory;
        this.errorHandlingService = errorHandlingService;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Observable<Object> getSomePathAsync(final String token) {
        asyncFactory.createObservable(new OnSubscribeFromCallable<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Object somePathObject = getSomePath(token);
                return somePathObject;
            }
        })) .map(new Func1<Object, Object>() {
            @Override
            public Object call(Object o) {
                // do something with mapping
                return o;
            }
        });
        return null;
    }

    private Object getSomePath(String token) throws IOException{
        Response response = templateRestClient.getSomePathResponse(token).execute();
        return errorHandlingService.filterResponseForErrors(response);
    }
}
