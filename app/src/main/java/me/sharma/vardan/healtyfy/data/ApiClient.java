package me.sharma.vardan.healtyfy.data;

import android.support.annotation.NonNull;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import me.sharma.vardan.healtyfy.BuildConfig;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by vardaan sharma on 19/3/16.
 */
public class ApiClient {
    private static Retrofit sInstance;

    public static HealthyFyService getInstance() {
        if (sInstance == null) {
            sInstance = createRetrofit();
        }
        return sInstance.create(HealthyFyService.class);
    }

    @NonNull
    private static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://www.hackerearth.com/api/")
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    static OkHttpClient createOkHttpClient() {
        final OkHttpClient okHttpClient = new OkHttpClient();
        //add interceptor for the automatic logging of request and response from api
        if (BuildConfig.LOG_HTTP_REQUESTS) {
            final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.interceptors().add(interceptor);
        }
        //add the profile time interceptor
        return okHttpClient;
    }
}
