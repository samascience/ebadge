package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import defpackage.wu0;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class m extends t {
    private final Map b;
    final /* synthetic */ j c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, Map map) {
        super(jVar, null);
        this.c = jVar;
        this.b = map;
    }

    @Override // com.google.android.gms.common.api.internal.t
    public final void a() {
        wu0 wu0Var = new wu0(this.c.d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.google.android.gms.common.api.a.f fVar : this.b.keySet()) {
            if (!fVar.k() || ((l) this.b.get(fVar)).c) {
                arrayList2.add(fVar);
            } else {
                arrayList.add(fVar);
            }
        }
        int i = 0;
        int iB = -1;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                iB = wu0Var.b(this.c.c, (com.google.android.gms.common.api.a.f) obj);
                if (iB != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                iB = wu0Var.b(this.c.c, (com.google.android.gms.common.api.a.f) obj2);
                if (iB == 0) {
                    break;
                }
            }
        }
        if (iB != 0) {
            this.c.a.k(new n(this, this.c, new ConnectionResult(iB, null)));
            return;
        }
        if (this.c.m) {
            this.c.k.connect();
        }
        for (com.google.android.gms.common.api.a.f fVar2 : this.b.keySet()) {
            com.google.android.gms.common.internal.b.c cVar = (com.google.android.gms.common.internal.b.c) this.b.get(fVar2);
            if (!fVar2.k() || wu0Var.b(this.c.c, fVar2) == 0) {
                fVar2.i(cVar);
            } else {
                this.c.a.k(new o(this, this.c, cVar));
            }
        }
    }
}
