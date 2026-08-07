package defpackage;

import androidx.camera.camera2.internal.d0;

/* JADX INFO: loaded from: classes.dex */
public final class rr {
    private d0 a;

    public rr(d0 d0Var) {
        this.a = d0Var;
    }

    public static rr a(yt ytVar) {
        zt ztVarE = ((zt) ytVar).e();
        b52.b(ztVarE instanceof d0, "CameraInfo doesn't contain Camera2 implementation.");
        return ((d0) ztVarE).p();
    }

    public String b() {
        return this.a.d();
    }
}
