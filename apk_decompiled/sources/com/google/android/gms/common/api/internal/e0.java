package com.google.android.gms.common.api.internal;

import defpackage.mr3;

/* JADX INFO: loaded from: classes.dex */
abstract class e0 {
    private final mr3 a;

    protected e0(mr3 mr3Var) {
        this.a = mr3Var;
    }

    protected abstract void a();

    public final void b(d0 d0Var) {
        d0Var.c.lock();
        try {
            if (d0Var.m != this.a) {
                return;
            }
            a();
        } finally {
            d0Var.c.unlock();
        }
    }
}
