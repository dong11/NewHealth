package com.dong.huang.healthapp.component;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;


/**
 * Created by zk on 2015/12/16.
 */
public class RetrofitSingleton {

    private static ApiInterface apiService = null;

    private static Retrofit retrofit = null;

    private static OkHttpClient okHttpClient = null;

    private static final String TAG = RetrofitSingleton.class.getSimpleName();

    public static Context context;

    /**
     * 初始化
     */
    public static void init(final Context context, String host) {

        Executor executor = Executors.newCachedThreadPool();

        Gson gson = new GsonBuilder().create();

        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                                         .baseUrl(host)
                                         .callbackExecutor(executor)
                                         .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                         .build();

        apiService = retrofit.create(ApiInterface.class);
    }

    public static ApiInterface getApiService(Context context, String host) {
        if (apiService != null) return apiService;
        init(context, host);
        return getApiService(context, host);
    }


    public static Retrofit getRetrofit(Context context, String host) {
        if (retrofit != null) return retrofit;
        init(context, host);
        return getRetrofit(context, host);
    }


    public static OkHttpClient getOkHttpClient(Context context, String host) {
        if (okHttpClient != null) return okHttpClient;
        init(context, host);
        return getOkHttpClient(context, host);
    }


    public static void disposeFailureInfo(Throwable t, Context context, View view) {
        if (t.toString().contains("GaiException") || t.toString().contains("SocketTimeoutException") ||
                t.toString().contains("UnknownHostException")) {
            Snackbar.make(view, "网络不好,~( ´•︵•` )~", Snackbar.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
        }
        Log.w(TAG, t.toString());
    }
}
