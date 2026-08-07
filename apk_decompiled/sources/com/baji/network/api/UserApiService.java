package com.baji.network.api;

import defpackage.fh2;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/* JADX INFO: loaded from: classes.dex */
public interface UserApiService {
    @GET("user/profile")
    Observable<fh2> getUserProfile();

    @POST("user/login")
    Observable<fh2> login(@Body Object obj);

    @POST("user/logout")
    Observable<fh2> logout();

    @PUT("user/profile")
    Observable<fh2> updateProfile(@Body Object obj);
}
