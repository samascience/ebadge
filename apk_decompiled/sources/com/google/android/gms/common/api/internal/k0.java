package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class k0 implements com.google.android.gms.common.internal.b.e {
    final /* synthetic */ c.a a;

    k0(c.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.gms.common.internal.b.e
    public final void a() {
        c.this.l.post(new l0(this));
    }
}
