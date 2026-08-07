package com.google.android.gms.common.api.internal;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class p extends t {
    private final ArrayList b;
    private final /* synthetic */ j c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(j jVar, ArrayList arrayList) {
        super(jVar, null);
        this.c = jVar;
        this.b = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.t
    public final void a() {
        this.c.a.p.f243q = this.c.q();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((com.google.android.gms.common.api.a.f) obj).g(this.c.o, this.c.a.p.f243q);
        }
    }
}
