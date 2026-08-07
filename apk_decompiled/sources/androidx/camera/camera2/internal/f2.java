package androidx.camera.camera2.internal;

import defpackage.zs;

/* JADX INFO: loaded from: classes.dex */
class f2 {
    private final Object a = new Object();
    private final zs b;
    private int c;

    f2(zs zsVar, int i) {
        this.b = zsVar;
        this.c = i;
    }

    public int a() {
        int i;
        synchronized (this.a) {
            i = this.c;
        }
        return i;
    }

    void b(int i) {
        synchronized (this.a) {
            this.c = i;
        }
    }
}
