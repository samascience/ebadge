package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import defpackage.a52;
import defpackage.ky;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends b implements com.google.android.gms.common.api.a.f, d.a {
    private final ky F;
    private final Set G;
    private final Account H;

    protected c(Context context, Looper looper, int i, ky kyVar, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        this(context, looper, e.b(context), com.google.android.gms.common.a.n(), i, kyVar, (com.google.android.gms.common.api.c.b) a52.g(bVar), (com.google.android.gms.common.api.c.InterfaceC0078c) a52.g(interfaceC0078c));
    }

    private static b.a e0(com.google.android.gms.common.api.c.b bVar) {
        if (bVar == null) {
            return null;
        }
        return new h(bVar);
    }

    private static b.InterfaceC0081b f0(com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        if (interfaceC0078c == null) {
            return null;
        }
        return new i(interfaceC0078c);
    }

    private final Set g0(Set set) {
        Set setD0 = d0(set);
        Iterator it = setD0.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setD0;
    }

    protected final ky c0() {
        return this.F;
    }

    protected Set d0(Set set) {
        return set;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public int l() {
        return super.l();
    }

    @Override // com.google.android.gms.common.internal.b
    public final Account t() {
        return this.H;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Set z() {
        return this.G;
    }

    protected c(Context context, Looper looper, e eVar, com.google.android.gms.common.a aVar, int i, ky kyVar, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        super(context, looper, eVar, aVar, i, e0(bVar), f0(interfaceC0078c), kyVar.h());
        this.F = kyVar;
        this.H = kyVar.a();
        this.G = g0(kyVar.d());
    }
}
