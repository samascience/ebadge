package com.baji.network.api;

import com.baji.network.model.AiAccessConfigApiResponse;
import com.baji.network.model.BadgeImageResponse;
import com.baji.network.model.BaseResponse;
import com.baji.network.model.SimultaneousTranslationResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes.dex */
public interface BadgeApiService {
    @POST("/api/v1/ai/access/config")
    Observable<AiAccessConfigApiResponse> getAiAccessConfig(@Header("Authorization") String str, @Query("userLang") String str2);

    @GET("/api/v1/badge/image/list")
    Observable<BadgeImageResponse> getBadgeImageList();

    @POST("/api/v1/ai/tokens")
    Observable<BaseResponse<SimultaneousTranslationResponse>> getSimultaneousTranslationTokens(@Header("Authorization") String str);
}
