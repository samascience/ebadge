package xfkj.fitpro.activity.ota.api;

import com.blankj.utilcode.util.c;
import defpackage.cg0;
import defpackage.eh2;
import defpackage.l31;
import defpackage.t10;
import defpackage.zt1;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import retrofit2.Retrofit;
import xfkj.fitpro.activity.ota.api.NetWorkManager;

/* JADX INFO: loaded from: classes4.dex */
public class NetWorkManager {
    private final String TAG;
    private zt1 mOkHttpClient;
    private Retrofit mRetrofit;

    private static class NetWorkManagerHolder {
        private static final NetWorkManager INSTANCE = new NetWorkManager();

        private NetWorkManagerHolder() {
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
                X509TrustManager x509TrustManager = new X509TrustManager() { // from class: xfkj.fitpro.activity.ota.api.NetWorkManager.1
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
                };
                aVar.S(new SSLSocketFactoryCompat(x509TrustManager), x509TrustManager);
                aVar.a(new l31() { // from class: yn1
                    @Override // defpackage.l31
                    public final eh2 intercept(l31.a aVar2) {
                        return NetWorkManager.lambda$getClient$0(aVar2);
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
    public static /* synthetic */ eh2 lambda$getClient$0(l31.a aVar) throws IOException {
        return aVar.a(aVar.request().h().g("accept-language", Locale.getDefault().getLanguage()).a("app-type", "1").a("app-name", cg0.a(c.d().getBytes(StandardCharsets.UTF_8))).a("app-version", c.i()).a("country", "foreign").b());
    }

    public zt1 getOkHttpClient() {
        return this.mOkHttpClient;
    }

    public Retrofit getRetrofit() {
        return this.mRetrofit;
    }

    private NetWorkManager() {
        this.TAG = NetWorkManager.class.getSimpleName();
        this.mOkHttpClient = getClient();
    }
}
