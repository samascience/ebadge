package com.baji.network.interceptor;

import defpackage.eh2;
import defpackage.l31;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class CacheInterceptor implements l31 {
    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) {
        p31.f(aVar, "chain");
        eh2 eh2VarC = aVar.a(aVar.request()).w0().a("Cache-Control", "public, max-age=604800").c();
        p31.e(eh2VarC, "build(...)");
        return eh2VarC;
    }
}
