package com.baji.network.api;

import defpackage.fh2;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes.dex */
public interface WeatherApiService {
    @GET("/api/v1/weather/forecast/3day")
    Observable<fh2> getWeather2(@Header("Authorization") String str, @Query("lat") double d, @Query("lon") double d2);
}
