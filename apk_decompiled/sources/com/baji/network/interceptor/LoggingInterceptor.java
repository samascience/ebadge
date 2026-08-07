package com.baji.network.interceptor;

import android.util.Log;
import defpackage.eh2;
import defpackage.l31;
import defpackage.p31;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: classes.dex */
public final class LoggingInterceptor implements l31 {
    private final HttpLoggingInterceptor httpLoggingInterceptor;
    private final HttpLoggingInterceptor.a logger;

    public LoggingInterceptor() {
        HttpLoggingInterceptor.a aVar = new HttpLoggingInterceptor.a() { // from class: od1
            @Override // okhttp3.logging.HttpLoggingInterceptor.a
            public final void a(String str) {
                Log.d("NetworkModule", str);
            }
        };
        this.logger = aVar;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(aVar);
        httpLoggingInterceptor.c(HttpLoggingInterceptor.Level.HEADERS);
        this.httpLoggingInterceptor = httpLoggingInterceptor;
    }

    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) throws Exception {
        p31.f(aVar, "chain");
        eh2 eh2VarIntercept = this.httpLoggingInterceptor.intercept(aVar);
        p31.e(eh2VarIntercept, "intercept(...)");
        return eh2VarIntercept;
    }
}
