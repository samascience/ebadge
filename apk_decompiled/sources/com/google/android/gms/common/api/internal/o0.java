package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import defpackage.yr3;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {
    public static final Status d = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult[] e = new BasePendingResult[0];
    final Set a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final r0 b = new p0(this);
    private final Map c;

    public o0(Map map) {
        this.c = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.a.toArray(e)) {
            yr3 yr3Var = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            basePendingResult.l(null);
            if (basePendingResult.f() != null) {
                basePendingResult.e(null);
                IBinder iBinderP = ((com.google.android.gms.common.api.a.f) this.c.get(((b) basePendingResult).s())).p();
                if (basePendingResult.i()) {
                    basePendingResult.l(new q0(basePendingResult, yr3Var, iBinderP, objArr3 == true ? 1 : 0));
                } else {
                    if (iBinderP == null || !iBinderP.isBinderAlive()) {
                        basePendingResult.l(null);
                        basePendingResult.c();
                        basePendingResult.f().intValue();
                        throw null;
                    }
                    q0 q0Var = new q0(basePendingResult, objArr2 == true ? 1 : 0, iBinderP, objArr == true ? 1 : 0);
                    basePendingResult.l(q0Var);
                    try {
                        iBinderP.linkToDeath(q0Var, 0);
                    } catch (RemoteException unused) {
                        basePendingResult.c();
                        basePendingResult.f().intValue();
                        throw null;
                    }
                }
                this.a.remove(basePendingResult);
            } else if (basePendingResult.o()) {
                this.a.remove(basePendingResult);
            }
        }
    }

    final void b(BasePendingResult basePendingResult) {
        this.a.add(basePendingResult);
        basePendingResult.l(this.b);
    }

    public final void c() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.a.toArray(e)) {
            basePendingResult.n(d);
        }
    }
}
