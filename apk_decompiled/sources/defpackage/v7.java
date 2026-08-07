package defpackage;

import java.util.concurrent.TimeUnit;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes3.dex */
public class v7 {
    private v7() {
        zt1.a aVar = new zt1.a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        e43.a(new Retrofit.Builder().client(aVar.Q(7676L, timeUnit).d(7676L, timeUnit).b()).baseUrl("http://www.onmicroapp.com.cn/Onmicro/public/index.php/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(g8.class));
    }

    public static synchronized g8 a() {
        synchronized (v7.class) {
            new v7();
        }
        return null;
        return null;
    }
}
