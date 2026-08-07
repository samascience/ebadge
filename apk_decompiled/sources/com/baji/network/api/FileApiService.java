package com.baji.network.api;

import com.tencent.open.SocialConstants;
import defpackage.ff2;
import defpackage.fh2;
import defpackage.gm1;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/* JADX INFO: loaded from: classes.dex */
public interface FileApiService {

    public static final class DefaultImpls {
        public static /* synthetic */ Observable getFileList$default(FileApiService fileApiService, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFileList");
            }
            if ((i3 & 1) != 0) {
                i = 1;
            }
            if ((i3 & 2) != 0) {
                i2 = 20;
            }
            return fileApiService.getFileList(i, i2);
        }
    }

    @DELETE("files/{id}")
    Observable<fh2> deleteFile(@Path("id") String str);

    @Streaming
    @GET("files/{id}/download")
    Observable<fh2> downloadFile(@Path("id") String str);

    @GET("files/{id}")
    Observable<fh2> getFileInfo(@Path("id") String str);

    @GET("files")
    Observable<fh2> getFileList(@Query("page") int i, @Query("size") int i2);

    @POST("files/upload")
    @Multipart
    Observable<fh2> uploadFile(@Part gm1.c cVar, @Part(SocialConstants.PARAM_COMMENT) ff2 ff2Var);
}
