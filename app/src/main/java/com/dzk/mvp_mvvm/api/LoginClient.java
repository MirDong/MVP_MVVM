package com.dzk.mvp_mvvm.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClient {
    private static Retrofit retrofit;
    public static ServiceApi getService(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://wanandroid.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ServiceApi.class);
    }

}
