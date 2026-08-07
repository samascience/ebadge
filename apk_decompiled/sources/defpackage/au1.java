package defpackage;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: classes.dex */
public abstract class au1 {
    private static final hd1 a = ld1.k(au1.class);

    private static class a {
        private static final zt1 a = b();

        private static zt1 b() {
            q10 q10VarL = i20.l;
            if (q10VarL == null) {
                q10VarL = q10.a().l();
            }
            iy iyVarD = iy.a().d();
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.c(HttpLoggingInterceptor.Level.valueOf(iyVarD.c()));
            Integer numD = q10VarL.d();
            int iIntValue = numD.intValue();
            au1.a.debug("[connectionPool Config] connectionPoolSize: {}", numD);
            hc0 hc0Var = new hc0();
            hc0Var.l(q10VarL.f().intValue());
            au1.a.debug("[connectionPool Config] maxRequests: {}", Integer.valueOf(hc0Var.h()));
            hc0Var.m(q10VarL.g().intValue());
            au1.a.debug("[connectionPool Config] maxRequestsPerHost: {}", Integer.valueOf(hc0Var.i()));
            zt1.a aVar = new zt1.a();
            aVar.e(q10VarL.b()).R(q10VarL.l()).U(q10VarL.n()).a(httpLoggingInterceptor).h(hc0Var).N(Collections.singletonList(Protocol.HTTP_1_1)).f(new t10(iIntValue, q10VarL.c().getSeconds(), TimeUnit.SECONDS));
            if (q10VarL.h() != null) {
                aVar.O(q10VarL.h());
            }
            if (q10VarL.i() != null) {
                aVar.P(q10VarL.i());
            }
            return aVar.b();
        }
    }

    public static zt1 b() {
        return a.a;
    }
}
