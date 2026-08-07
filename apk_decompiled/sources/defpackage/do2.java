package defpackage;

import com.airbnb.lottie.model.layer.a;

/* JADX INFO: loaded from: classes.dex */
public class do2 implements j30 {
    private final String a;
    private final int b;
    private final n6 c;

    public do2(String str, int i, n6 n6Var) {
        this.a = str;
        this.b = i;
        this.c = n6Var;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, a aVar) {
        return new un2(je1Var, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public n6 c() {
        return this.c;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}
