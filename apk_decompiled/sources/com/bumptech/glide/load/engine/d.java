package com.bumptech.glide.load.engine;

import defpackage.fg0;
import defpackage.rx1;
import defpackage.yb0;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class d implements yb0.b {
    private final fg0 a;
    private final Object b;
    private final rx1 c;

    d(fg0 fg0Var, Object obj, rx1 rx1Var) {
        this.a = fg0Var;
        this.b = obj;
        this.c = rx1Var;
    }

    @Override // yb0.b
    public boolean a(File file) {
        return this.a.a(this.b, file, this.c);
    }
}
