package defpackage;

import com.airbnb.lottie.model.layer.a;

/* JADX INFO: loaded from: classes.dex */
public class qx implements j30 {
    private final String a;
    private final u6 b;
    private final l6 c;
    private final boolean d;

    public qx(String str, u6 u6Var, l6 l6Var, boolean z) {
        this.a = str;
        this.b = u6Var;
        this.c = l6Var;
        this.d = z;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, a aVar) {
        return new pf0(je1Var, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public u6 c() {
        return this.b;
    }

    public l6 d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }
}
