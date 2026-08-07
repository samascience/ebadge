package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class g0 implements a.InterfaceC0079a {
    private final /* synthetic */ c a;

    g0(c cVar) {
        this.a = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.a.InterfaceC0079a
    public final void a(boolean z) {
        this.a.l.sendMessage(this.a.l.obtainMessage(1, Boolean.valueOf(z)));
    }
}
