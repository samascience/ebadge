package com.bumptech.glide.manager;

import defpackage.bb1;
import defpackage.na3;
import defpackage.va1;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class a implements va1 {
    private final Set a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;
    private boolean c;

    a() {
    }

    @Override // defpackage.va1
    public void a(bb1 bb1Var) {
        this.a.remove(bb1Var);
    }

    @Override // defpackage.va1
    public void b(bb1 bb1Var) {
        this.a.add(bb1Var);
        if (this.c) {
            bb1Var.onDestroy();
        } else if (this.b) {
            bb1Var.onStart();
        } else {
            bb1Var.onStop();
        }
    }

    void c() {
        this.c = true;
        Iterator it = na3.i(this.a).iterator();
        while (it.hasNext()) {
            ((bb1) it.next()).onDestroy();
        }
    }

    void d() {
        this.b = true;
        Iterator it = na3.i(this.a).iterator();
        while (it.hasNext()) {
            ((bb1) it.next()).onStart();
        }
    }

    void e() {
        this.b = false;
        Iterator it = na3.i(this.a).iterator();
        while (it.hasNext()) {
            ((bb1) it.next()).onStop();
        }
    }
}
