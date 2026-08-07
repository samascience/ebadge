package com.baji.network.api;

import defpackage.ff2;
import defpackage.fh2;
import defpackage.gm1;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes.dex */
public interface ApiService {

    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable delete$default(ApiService apiService, String str, Map map, Map map2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            if ((i & 4) != 0) {
                map2 = null;
            }
            return apiService.delete(str, map, map2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable downloadFile$default(ApiService apiService, String str, Map map, Map map2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFile");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            if ((i & 4) != 0) {
                map2 = null;
            }
            return apiService.downloadFile(str, map, map2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable get$default(ApiService apiService, String str, Map map, Map map2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            if ((i & 4) != 0) {
                map2 = null;
            }
            return apiService.get(str, map, map2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable post$default(ApiService apiService, String str, Object obj, Map map, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
            }
            if ((i & 2) != 0) {
                obj = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return apiService.post(str, obj, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable put$default(ApiService apiService, String str, Object obj, Map map, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
            }
            if ((i & 2) != 0) {
                obj = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return apiService.put(str, obj, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable uploadFile$default(ApiService apiService, String str, gm1.c cVar, Map map, Map map2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
            }
            if ((i & 4) != 0) {
                map = null;
            }
            if ((i & 8) != 0) {
                map2 = null;
            }
            return apiService.uploadFile(str, cVar, map, map2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable uploadFiles$default(ApiService apiService, String str, List list, Map map, Map map2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFiles");
            }
            if ((i & 4) != 0) {
                map = null;
            }
            if ((i & 8) != 0) {
                map2 = null;
            }
            return apiService.uploadFiles(str, list, map, map2);
        }
    }

    @DELETE
    Observable<fh2> delete(@Url String str, @QueryMap Map<String, String> map, @HeaderMap Map<String, String> map2);

    @Streaming
    @GET
    Observable<fh2> downloadFile(@Url String str, @QueryMap Map<String, String> map, @HeaderMap Map<String, String> map2);

    @GET
    Observable<fh2> get(@Url String str, @QueryMap Map<String, String> map, @HeaderMap Map<String, String> map2);

    @POST
    Observable<fh2> post(@Url String str, @Body Object obj, @HeaderMap Map<String, String> map);

    @PUT
    Observable<fh2> put(@Url String str, @Body Object obj, @HeaderMap Map<String, String> map);

    @POST
    @Multipart
    Observable<fh2> uploadFile(@Url String str, @Part gm1.c cVar, @PartMap Map<String, ? extends ff2> map, @HeaderMap Map<String, String> map2);

    @POST
    @Multipart
    Observable<fh2> uploadFiles(@Url String str, @Part List<gm1.c> list, @PartMap Map<String, ? extends ff2> map, @HeaderMap Map<String, String> map2);
}
