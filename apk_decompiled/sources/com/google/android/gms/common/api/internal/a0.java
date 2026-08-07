package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import defpackage.au2;
import defpackage.jh2;
import defpackage.mh2;
import defpackage.su2;

/* JADX INFO: loaded from: classes.dex */
final class a0 implements mh2 {
    private final /* synthetic */ au2 a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ com.google.android.gms.common.api.c c;
    private final /* synthetic */ v d;

    a0(v vVar, au2 au2Var, boolean z, com.google.android.gms.common.api.c cVar) {
        this.d = vVar;
        this.a = au2Var;
        this.b = z;
        this.c = cVar;
    }

    @Override // defpackage.mh2
    public final /* synthetic */ void a(jh2 jh2Var) {
        Status status = (Status) jh2Var;
        su2.b(this.d.g).l();
        if (status.K0() && this.d.n()) {
            this.d.q();
        }
        this.a.j(status);
        if (this.b) {
            this.c.h();
        }
    }
}
