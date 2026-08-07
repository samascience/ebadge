package com.baji.network;

import com.baji.network.NetworkManager;
import com.baji.network.api.ApiService;
import com.baji.network.api.BadgeApiService;
import com.baji.network.api.FileApiService;
import com.baji.network.api.UserApiService;
import com.baji.network.api.WeatherApiService;
import com.baji.network.config.NetworkConfig;
import com.baji.network.interceptor.AuthInterceptor;
import com.baji.network.interceptor.CacheInterceptor;
import com.baji.network.interceptor.HeaderInterceptor;
import com.baji.network.interceptor.LoggingInterceptor;
import com.baji.network.interceptor.RetryInterceptor;
import com.baji.network.model.ErrorType;
import com.baji.network.model.NetworkError;
import com.tencent.open.SocialConstants;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import defpackage.ar0;
import defpackage.df2;
import defpackage.dn0;
import defpackage.eh2;
import defpackage.ff2;
import defpackage.fh2;
import defpackage.fi1;
import defpackage.gm1;
import defpackage.k83;
import defpackage.l31;
import defpackage.p31;
import defpackage.qv0;
import defpackage.rv0;
import defpackage.y70;
import defpackage.yq0;
import defpackage.zt1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.u;
import no.nordicsemi.android.dfu.DfuBaseService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkManager {
    public static final Companion Companion = new Companion(null);
    private static volatile NetworkManager INSTANCE;
    private ApiService apiService;
    private BadgeApiService badgeApiService;
    private String baseUrl;
    private boolean enableLogging;
    private FileApiService fileApiService;
    private qv0 gson;
    private String logLevel;
    private zt1 okHttpClient;
    private Retrofit retrofit;
    private yq0 tokenProvider;
    private UserApiService userApiService;
    private WeatherApiService weatherApiService;
    private Retrofit weatherRetrofit;

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        public final NetworkManager getInstance() {
            NetworkManager networkManager = NetworkManager.INSTANCE;
            if (networkManager == null) {
                synchronized (this) {
                    networkManager = NetworkManager.INSTANCE;
                    if (networkManager == null) {
                        networkManager = new NetworkManager(null);
                        NetworkManager.INSTANCE = networkManager;
                    }
                }
            }
            return networkManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ NetworkManager(y70 y70Var) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 downloadFile$lambda$14(File file, ar0 ar0Var, ar0 ar0Var2, fh2 fh2Var) {
        try {
            byte[] bArrBytes = fh2Var.bytes();
            p31.e(bArrBytes, "bytes(...)");
            dn0.a(file, bArrBytes);
            ar0Var.invoke(file);
        } catch (Exception e) {
            ar0Var2.invoke(new NetworkError(-1, "Download failed: " + e.getMessage(), ErrorType.NETWORK_ERROR, 0L, 8, null));
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 downloadFile$lambda$16(ar0 ar0Var, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "Download failed";
        }
        ar0Var.invoke(new NetworkError(-1, message, ErrorType.NETWORK_ERROR, 0L, 8, null));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 executeRequest$lambda$6(NetworkManager networkManager, Class cls, ar0 ar0Var, ar0 ar0Var2, fh2 fh2Var) {
        try {
            String strString = fh2Var.string();
            qv0 qv0Var = networkManager.gson;
            Object objFromJson = qv0Var != null ? qv0Var.fromJson(strString, cls) : null;
            if (objFromJson != null) {
                ar0Var2.invoke(objFromJson);
            }
        } catch (Exception e) {
            ar0Var.invoke(new NetworkError(-1, "Parse error: " + e.getMessage(), ErrorType.PARSE_ERROR, 0L, 8, null));
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 executeRequest$lambda$8(ar0 ar0Var, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        ar0Var.invoke(new NetworkError(-1, message, ErrorType.NETWORK_ERROR, 0L, 8, null));
        return k83.a;
    }

    private final void initApiServices() {
        Retrofit retrofit = this.retrofit;
        this.apiService = retrofit != null ? (ApiService) retrofit.create(ApiService.class) : null;
        Retrofit retrofit3 = this.retrofit;
        this.userApiService = retrofit3 != null ? (UserApiService) retrofit3.create(UserApiService.class) : null;
        Retrofit retrofit4 = this.retrofit;
        this.fileApiService = retrofit4 != null ? (FileApiService) retrofit4.create(FileApiService.class) : null;
        Retrofit retrofit5 = this.retrofit;
        this.badgeApiService = retrofit5 != null ? (BadgeApiService) retrofit5.create(BadgeApiService.class) : null;
    }

    private final void initGson() {
        this.gson = new rv0().h().g(DateFormatUtils.YYYY_MM_DD_HH_MM_SS).c();
    }

    private final void initOkHttpClient(final Map<String, String> map) {
        zt1.a aVar = new zt1.a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zt1.a aVarA = aVar.d(30000L, timeUnit).Q(30000L, timeUnit).T(30000L, timeUnit).a(new HeaderInterceptor()).a(new RetryInterceptor(0, 0L, 3, null)).a(new CacheInterceptor());
        yq0 yq0Var = this.tokenProvider;
        if (yq0Var != null) {
            aVarA.a(new AuthInterceptor(yq0Var));
        }
        if (this.enableLogging) {
            aVarA.a(new LoggingInterceptor());
        }
        if (!map.isEmpty()) {
            aVarA.a(new l31() { // from class: cq1
                @Override // defpackage.l31
                public final eh2 intercept(l31.a aVar2) {
                    return NetworkManager.initOkHttpClient$lambda$4(map, aVar2);
                }
            });
        }
        this.okHttpClient = aVarA.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eh2 initOkHttpClient$lambda$4(Map map, l31.a aVar) {
        df2.a aVarH = aVar.request().h();
        for (Map.Entry entry : map.entrySet()) {
            aVarH.a((String) entry.getKey(), (String) entry.getValue());
        }
        return aVar.a(aVarH.b());
    }

    private final void initRetrofit() {
        Retrofit.Builder builderBaseUrl = new Retrofit.Builder().baseUrl(this.baseUrl);
        zt1 zt1Var = this.okHttpClient;
        p31.c(zt1Var);
        Retrofit.Builder builderClient = builderBaseUrl.client(zt1Var);
        qv0 qv0Var = this.gson;
        p31.c(qv0Var);
        this.retrofit = builderClient.addConverterFactory(GsonConverterFactory.create(qv0Var)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initialize$default(NetworkManager networkManager, String str, yq0 yq0Var, boolean z, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = NetworkConfig.DEFAULT_BASE_URL;
        }
        if ((i & 2) != 0) {
            yq0Var = new yq0() { // from class: xp1
                @Override // defpackage.yq0
                public final Object invoke() {
                    return NetworkManager.initialize$lambda$0();
                }
            };
        }
        yq0 yq0Var2 = yq0Var;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str2 = NetworkConfig.DEFAULT_LOG_LEVEL;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            map = u.f();
        }
        networkManager.initialize(str, yq0Var2, z2, str3, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String initialize$lambda$0() {
        return "6fcb7f58475b4e5aad8f0f1cadce235e";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 uploadFile$lambda$10(ar0 ar0Var, fh2 fh2Var) throws IOException {
        String strString = fh2Var.string();
        p31.e(strString, "string(...)");
        ar0Var.invoke(strString);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 uploadFile$lambda$12(ar0 ar0Var, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "Upload failed";
        }
        ar0Var.invoke(new NetworkError(-1, message, ErrorType.NETWORK_ERROR, 0L, 8, null));
        return k83.a;
    }

    public final void downloadFile(String str, final File file, ar0 ar0Var, final ar0 ar0Var2, final ar0 ar0Var3) {
        p31.f(str, SocialConstants.PARAM_URL);
        p31.f(file, "destination");
        p31.f(ar0Var, "onProgress");
        p31.f(ar0Var2, "onSuccess");
        p31.f(ar0Var3, "onError");
        Observable observableObserveOn = ApiService.DefaultImpls.downloadFile$default(getApiService(), str, null, null, 6, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final ar0 ar0Var4 = new ar0() { // from class: hq1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkManager.downloadFile$lambda$14(file, ar0Var2, ar0Var3, (fh2) obj);
            }
        };
        Consumer consumer = new Consumer() { // from class: iq1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var4.invoke(obj);
            }
        };
        final ar0 ar0Var5 = new ar0() { // from class: jq1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkManager.downloadFile$lambda$16(ar0Var3, (Throwable) obj);
            }
        };
        observableObserveOn.subscribe(consumer, new Consumer() { // from class: kq1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var5.invoke(obj);
            }
        });
    }

    public final <T> void executeRequest(Observable<fh2> observable, final Class<T> cls, final ar0 ar0Var, final ar0 ar0Var2) {
        p31.f(observable, "observable");
        p31.f(cls, "responseType");
        p31.f(ar0Var, "onSuccess");
        p31.f(ar0Var2, "onError");
        Observable<fh2> observableObserveOn = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final ar0 ar0Var3 = new ar0() { // from class: yp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkManager.executeRequest$lambda$6(this.a, cls, ar0Var2, ar0Var, (fh2) obj);
            }
        };
        Consumer<? super fh2> consumer = new Consumer() { // from class: zp1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var3.invoke(obj);
            }
        };
        final ar0 ar0Var4 = new ar0() { // from class: aq1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkManager.executeRequest$lambda$8(ar0Var2, (Throwable) obj);
            }
        };
        observableObserveOn.subscribe(consumer, new Consumer() { // from class: bq1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var4.invoke(obj);
            }
        });
    }

    public final ApiService getApiService() {
        ApiService apiService = this.apiService;
        if (apiService != null) {
            return apiService;
        }
        throw new IllegalStateException("NetworkManager not initialized");
    }

    public final BadgeApiService getAuthApiService() {
        BadgeApiService badgeApiService = this.badgeApiService;
        if (badgeApiService != null) {
            return badgeApiService;
        }
        throw new IllegalStateException("NetworkManager not initialized");
    }

    public final BadgeApiService getBadgeApiService() {
        BadgeApiService badgeApiService = this.badgeApiService;
        if (badgeApiService != null) {
            return badgeApiService;
        }
        throw new IllegalStateException("NetworkManager not initialized");
    }

    public final FileApiService getFileApiService() {
        FileApiService fileApiService = this.fileApiService;
        if (fileApiService != null) {
            return fileApiService;
        }
        throw new IllegalStateException("NetworkManager not initialized");
    }

    public final UserApiService getUserApiService() {
        UserApiService userApiService = this.userApiService;
        if (userApiService != null) {
            return userApiService;
        }
        throw new IllegalStateException("NetworkManager not initialized");
    }

    public final WeatherApiService getWeatherApiService() {
        WeatherApiService weatherApiService;
        if (this.weatherApiService == null) {
            Retrofit retrofit = this.retrofit;
            if (retrofit == null || (weatherApiService = (WeatherApiService) retrofit.create(WeatherApiService.class)) == null) {
                throw new IllegalStateException("NetworkManager not initialized");
            }
            this.weatherApiService = weatherApiService;
        }
        WeatherApiService weatherApiService2 = this.weatherApiService;
        p31.c(weatherApiService2);
        return weatherApiService2;
    }

    public final void initialize(String str, yq0 yq0Var, boolean z, String str2, Map<String, String> map) {
        p31.f(str, "baseUrl");
        p31.f(str2, "logLevel");
        p31.f(map, "customHeaders");
        this.baseUrl = str;
        this.tokenProvider = yq0Var;
        this.enableLogging = z;
        this.logLevel = str2;
        initGson();
        initOkHttpClient(map);
        initRetrofit();
        initApiServices();
    }

    public final void uploadFile(File file, String str, ar0 ar0Var, final ar0 ar0Var2, final ar0 ar0Var3) {
        p31.f(file, "file");
        p31.f(str, SocialConstants.PARAM_URL);
        p31.f(ar0Var, "onProgress");
        p31.f(ar0Var2, "onSuccess");
        p31.f(ar0Var3, "onError");
        gm1.c cVarB = gm1.c.b("file", file.getName(), ff2.create(fi1.g(DfuBaseService.MIME_TYPE_OCTET_STREAM), file));
        ApiService apiService = getApiService();
        p31.c(cVarB);
        Observable observableObserveOn = ApiService.DefaultImpls.uploadFile$default(apiService, str, cVarB, null, null, 12, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final ar0 ar0Var4 = new ar0() { // from class: dq1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkManager.uploadFile$lambda$10(ar0Var2, (fh2) obj);
            }
        };
        Consumer consumer = new Consumer() { // from class: eq1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var4.invoke(obj);
            }
        };
        final ar0 ar0Var5 = new ar0() { // from class: fq1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkManager.uploadFile$lambda$12(ar0Var3, (Throwable) obj);
            }
        };
        observableObserveOn.subscribe(consumer, new Consumer() { // from class: gq1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var5.invoke(obj);
            }
        });
    }

    private NetworkManager() {
        this.baseUrl = NetworkConfig.DEFAULT_BASE_URL;
        this.enableLogging = true;
        this.logLevel = NetworkConfig.DEFAULT_LOG_LEVEL;
    }

    public final WeatherApiService getWeatherApiService(String str) {
        WeatherApiService weatherApiService;
        p31.f(str, "baseUrl");
        if (p31.a(str, this.baseUrl) && (weatherApiService = this.weatherApiService) != null) {
            p31.c(weatherApiService);
            return weatherApiService;
        }
        Retrofit.Builder builderBaseUrl = new Retrofit.Builder().baseUrl(str);
        zt1 zt1Var = this.okHttpClient;
        p31.c(zt1Var);
        Retrofit.Builder builderClient = builderBaseUrl.client(zt1Var);
        qv0 qv0Var = this.gson;
        p31.c(qv0Var);
        Retrofit retrofitBuild = builderClient.addConverterFactory(GsonConverterFactory.create(qv0Var)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        this.weatherRetrofit = retrofitBuild;
        Object objCreate = retrofitBuild.create(WeatherApiService.class);
        p31.e(objCreate, "create(...)");
        return (WeatherApiService) objCreate;
    }
}
