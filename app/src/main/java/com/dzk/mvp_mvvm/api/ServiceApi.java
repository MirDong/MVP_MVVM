package com.dzk.mvp_mvvm.api;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceApi {
    @FormUrlEncoded
    @POST("/login/")
    Observable<Response> login(@Field("username") String userName, @Field("password") String password);
}
