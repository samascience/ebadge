package com.google.android.material.bottomsheet;

import android.view.View;
import defpackage.mi3;
import defpackage.y6;
import defpackage.zi3;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class b extends mi3.b {
    private final View c;
    private int d;
    private int e;
    private final int[] f;

    public b(View view) {
        super(0);
        this.f = new int[2];
        this.c = view;
    }

    @Override // mi3.b
    public void b(mi3 mi3Var) {
        this.c.setTranslationY(0.0f);
    }

    @Override // mi3.b
    public void c(mi3 mi3Var) {
        this.c.getLocationOnScreen(this.f);
        this.d = this.f[1];
    }

    @Override // mi3.b
    public zi3 d(zi3 zi3Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            mi3 mi3Var = (mi3) it.next();
            if ((mi3Var.c() & zi3.l.a()) != 0) {
                this.c.setTranslationY(y6.c(this.e, 0, mi3Var.b()));
                break;
            }
        }
        return zi3Var;
    }

    @Override // mi3.b
    public mi3.a e(mi3 mi3Var, mi3.a aVar) {
        this.c.getLocationOnScreen(this.f);
        int i = this.d - this.f[1];
        this.e = i;
        this.c.setTranslationY(i);
        return aVar;
    }
}
