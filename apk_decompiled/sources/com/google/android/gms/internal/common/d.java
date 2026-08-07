package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
final class d extends f {
    private final zzag c;

    d(zzag zzagVar, int i) {
        super(zzagVar.size(), i);
        this.c = zzagVar;
    }

    @Override // com.google.android.gms.internal.common.f
    protected final Object a(int i) {
        return this.c.get(i);
    }
}
