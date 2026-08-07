package xfkj.fitpro.api;

import android.util.Log;
import com.blankj.utilcode.util.c;
import com.google.gson.JsonParseException;
import defpackage.bn1;
import defpackage.cg0;
import defpackage.df2;
import defpackage.e33;
import defpackage.eh2;
import defpackage.k00;
import defpackage.l31;
import defpackage.pv2;
import defpackage.q51;
import defpackage.qv0;
import defpackage.rv0;
import defpackage.t10;
import defpackage.t51;
import defpackage.u51;
import defpackage.zm1;
import defpackage.zt1;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import xfkj.fitpro.db.DBHelper;

/* JADX INFO: loaded from: classes4.dex */
public class NetWorkManager {
    private final String TAG;
    private final CommonService mCommonService;
    private zt1 mOkHttpClient;
    private Retrofit mRetrofit;

    private static class NetWorkManagerHolder {
        private static final NetWorkManager INSTANCE = new NetWorkManager();

        private NetWorkManagerHolder() {
        }
    }

    class a implements X509TrustManager {
        a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private synchronized zt1 getClient() {
        try {
            if (this.mOkHttpClient == null) {
                zt1.a aVar = new zt1.a();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                aVar.d(15L, timeUnit);
                aVar.Q(15L, timeUnit);
                aVar.T(15L, timeUnit);
                aVar.f(new t10(1, 1L, TimeUnit.MINUTES));
                a aVar2 = new a();
                aVar.S(new SSLSocketFactoryCompat(aVar2), aVar2);
                aVar.a(new l31() { // from class: xn1
                    @Override // defpackage.l31
                    public final eh2 intercept(l31.a aVar3) {
                        return this.a.lambda$getClient$1(aVar3);
                    }
                });
                this.mOkHttpClient = aVar.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mOkHttpClient;
    }

    public static final NetWorkManager getInstance() {
        return NetWorkManagerHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ eh2 lambda$getClient$1(l31.a aVar) throws IOException {
        df2 df2VarRequest = aVar.request();
        String strD = df2VarRequest.d("Authorization");
        if (pv2.h(strD)) {
            strD = DBHelper.getUserToken();
        }
        return aVar.a(df2VarRequest.h().g("accept-language", Locale.getDefault().getLanguage()).a("app-type", "1").a("app-name", cg0.a(c.d().getBytes(StandardCharsets.UTF_8))).a("app-version", c.i()).a("country", "foreign").a("dev-version", k00.h(zm1.g())).a("Authorization", strD).b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Date lambda$new$0(u51 u51Var, Type type, q51 q51Var) throws JsonParseException {
        String strE = u51Var.d().e();
        Log.i(this.TAG, "date AsString:" + strE);
        return strE.length() == 8 ? e33.q(strE, bn1.m()) : e33.q(strE, bn1.n());
    }

    public CommonService getCommonService() {
        return this.mCommonService;
    }

    public zt1 getOkHttpClient() {
        return this.mOkHttpClient;
    }

    public Retrofit getRetrofit() {
        return this.mRetrofit;
    }

    private NetWorkManager() {
        String str;
        String simpleName = NetWorkManager.class.getSimpleName();
        this.TAG = simpleName;
        rv0 rv0Var = new rv0();
        rv0Var.g("yyyyMMddHHmmss");
        rv0Var.e(Date.class, new t51() { // from class: zn1
            @Override // defpackage.t51
            public final Object a(u51 u51Var, Type type, q51 q51Var) {
                return this.a.lambda$new$0(u51Var, type, q51Var);
            }
        });
        qv0 qv0VarC = rv0Var.c();
        this.mOkHttpClient = getClient();
        if (k00.e()) {
            Log.i(simpleName, "国外服务器");
            str = "https://mywatchi.jusonsmart.com:16443";
        } else {
            Log.i(simpleName, "国内服务器");
            str = "https://mywatchc.jusonsmart.com/";
        }
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(str).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(qv0VarC)).client(this.mOkHttpClient).build();
        this.mRetrofit = retrofitBuild;
        this.mCommonService = (CommonService) retrofitBuild.create(CommonService.class);
    }
}
