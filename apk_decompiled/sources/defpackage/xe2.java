package defpackage;

import com.airbnb.lottie.model.layer.a;

/* JADX INFO: loaded from: classes.dex */
public class xe2 implements j30 {
    private final String a;
    private final g6 b;
    private final g6 c;
    private final s6 d;

    public xe2(String str, g6 g6Var, g6 g6Var2, s6 s6Var) {
        this.a = str;
        this.b = g6Var;
        this.c = g6Var2;
        this.d = s6Var;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, a aVar) {
        return new ye2(je1Var, aVar, this);
    }

    public g6 b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public g6 d() {
        return this.c;
    }

    public s6 e() {
        return this.d;
    }
}
