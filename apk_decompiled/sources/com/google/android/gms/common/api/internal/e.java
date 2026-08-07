package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import defpackage.v03;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private final Map a = Collections.synchronizedMap(new WeakHashMap());
    private final Map b = Collections.synchronizedMap(new WeakHashMap());

    private final void c(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.a) {
            map = new HashMap(this.a);
        }
        synchronized (this.b) {
            map2 = new HashMap(this.b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).n(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((v03) entry2.getKey()).d(new ApiException(status));
            }
        }
    }

    final void b(BasePendingResult basePendingResult, boolean z) {
        this.a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.b(new f(this, basePendingResult));
    }

    final boolean d() {
        return (this.a.isEmpty() && this.b.isEmpty()) ? false : true;
    }

    public final void e() {
        c(false, c.m);
    }

    public final void f() {
        c(true, o0.d);
    }
}
