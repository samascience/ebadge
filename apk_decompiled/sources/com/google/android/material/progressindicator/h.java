package com.google.android.material.progressindicator;

import defpackage.e6;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class h {
    protected i a;
    protected final List b = new ArrayList();

    protected h(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.b.add(new g.a());
        }
    }

    abstract void a();

    protected float b(int i, int i2, int i3) {
        return (i - i2) / i3;
    }

    public abstract void c();

    public abstract void d(e6 e6Var);

    protected void e(i iVar) {
        this.a = iVar;
    }

    abstract void f();

    abstract void g();

    public abstract void h();
}
