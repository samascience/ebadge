package defpackage;

import androidx.camera.core.impl.g;

/* JADX INFO: loaded from: classes.dex */
public class ih2 extends kp0 {
    private final zt b;
    private boolean c;
    private boolean d;
    private final g e;

    public ih2(zt ztVar, g gVar) {
        super(ztVar);
        this.c = false;
        this.d = false;
        this.b = ztVar;
        this.e = gVar;
        gVar.X(null);
        r(gVar.y());
        q(gVar.R());
    }

    @Override // defpackage.kp0, defpackage.zt
    public zt e() {
        return this.b;
    }

    public g p() {
        return this.e;
    }

    public void q(boolean z) {
        this.d = z;
    }

    public void r(boolean z) {
        this.c = z;
    }
}
