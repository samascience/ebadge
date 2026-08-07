package defpackage;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class hg3 extends kp0 {
    private final String b;
    private int c;

    hg3(zt ztVar) {
        super(ztVar);
        this.b = "virtual-" + ztVar.d() + "-" + UUID.randomUUID().toString();
    }

    @Override // defpackage.kp0, defpackage.yt
    public int a() {
        return k(0);
    }

    @Override // defpackage.kp0, defpackage.zt
    public String d() {
        return this.b;
    }

    @Override // defpackage.kp0, defpackage.yt
    public int k(int i) {
        return y43.v(super.k(i) - this.c);
    }

    void p(int i) {
        this.c = i;
    }
}
