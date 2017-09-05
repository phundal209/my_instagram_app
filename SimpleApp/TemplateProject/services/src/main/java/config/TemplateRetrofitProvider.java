package config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.JacksonConverterFactory;
import retrofit2.Retrofit;
import rx.android.BuildConfig;

/**
 * Created by GoFundMe on 1/11/17.
 */

public class TemplateRetrofitProvider implements IRetrofitProvider{
    private String baseUrl = "http://localhost:1337";
    public static final String VERSION_ROUTE ="v1/";
    public static final String FUNNEL_UUID = "funnel_UUID";
    public static final String DEVICE_UUID = "device_UUID";

    private Context context;
    private SharedPreferences sharedPreferences;

    public TemplateRetrofitProvider(Context context, SharedPreferences sharedPreferences){
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }

    public TemplateRetrofitProvider setBaseUrl(String url) {
        baseUrl = url;
        return this;
    }


    @Override
    public Retrofit get() {
        Retrofit retrofit = getRetrofit(baseUrl + VERSION_ROUTE);
        return retrofit;
    }

    private String getFunnelIDToken() {
        return sharedPreferences.getString(FUNNEL_UUID, null);
    }

    private String getDeviceUuidID() {
        return sharedPreferences.getString(DEVICE_UUID, null);
    }

    @NonNull
    public Retrofit getRetrofit(String baseUrlToUse) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        if(BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        }


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder builder = original.newBuilder()
                                .method(original.method(), original.body());

                        builder.header("GFM-Mobile-App-Platform", "Android");
                        builder.header("Accept-Language", Locale.getDefault().toString());
                        if (getDeviceUuidID() != null) {
                            builder.header("GFM-Device-Uuid", getDeviceUuidID());
                        }
                        if (getFunnelIDToken() != null) {
                            builder.header("GFM-Funnel-Uuid", getFunnelIDToken());
                        }

                        try {
                            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                            String version = pInfo.versionName;
                            builder.header("X-Mobile-App-Version", version);
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        builder.header("User-Agent", "okhttp/3.2.0/mobile_app");
                        Request request = builder.build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrlToUse)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
