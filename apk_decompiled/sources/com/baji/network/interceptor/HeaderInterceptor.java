package com.baji.network.interceptor;

import com.baji.network.config.NetworkConfig;
import defpackage.d63;
import defpackage.df2;
import defpackage.eh2;
import defpackage.l31;
import defpackage.p31;
import java.util.Map;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes.dex */
public final class HeaderInterceptor implements l31 {
    private final Map<String, String> defaultHeaders = u.g(d63.a("User-Agent", NetworkConfig.DEFAULT_USER_AGENT), d63.a("Content-Type", "application/json"), d63.a("Accept", "application/json"));

    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) {
        p31.f(aVar, "chain");
        df2 df2VarRequest = aVar.request();
        df2.a aVarH = df2VarRequest.h();
        for (Map.Entry<String, String> entry : this.defaultHeaders.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (df2VarRequest.d(key) == null) {
                aVarH.a(key, value);
            }
        }
        eh2 eh2VarA = aVar.a(aVarH.b());
        p31.e(eh2VarA, "proceed(...)");
        return eh2VarA;
    }
}
