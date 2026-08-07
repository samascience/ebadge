package com.baji.network.interceptor;

import defpackage.df2;
import defpackage.eh2;
import defpackage.l31;
import defpackage.p31;
import defpackage.yq0;

/* JADX INFO: loaded from: classes.dex */
public final class AuthInterceptor implements l31 {
    private final yq0 tokenProvider;

    public AuthInterceptor(yq0 yq0Var) {
        p31.f(yq0Var, "tokenProvider");
        this.tokenProvider = yq0Var;
    }

    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) {
        p31.f(aVar, "chain");
        df2 df2VarRequest = aVar.request();
        String str = (String) this.tokenProvider.invoke();
        if (str != null) {
            df2VarRequest = df2VarRequest.h().a("Authorization", "Bearer " + str).b();
        }
        eh2 eh2VarA = aVar.a(df2VarRequest);
        p31.e(eh2VarA, "proceed(...)");
        return eh2VarA;
    }
}
