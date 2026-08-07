package com.bumptech.glide.load.engine;

import defpackage.w81;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class n {
    private final Map a = new HashMap();
    private final Map b = new HashMap();

    n() {
    }

    private Map b(boolean z) {
        return z ? this.b : this.a;
    }

    i a(w81 w81Var, boolean z) {
        return (i) b(z).get(w81Var);
    }

    void c(w81 w81Var, i iVar) {
        b(iVar.p()).put(w81Var, iVar);
    }

    void d(w81 w81Var, i iVar) {
        Map mapB = b(iVar.p());
        if (iVar.equals(mapB.get(w81Var))) {
            mapB.remove(w81Var);
        }
    }
}
