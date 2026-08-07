package defpackage;

import com.airbnb.lottie.model.layer.a;

/* JADX INFO: loaded from: classes.dex */
public class he2 implements j30 {
    private final String a;
    private final u6 b;
    private final l6 c;
    private final g6 d;

    public he2(String str, u6 u6Var, l6 l6Var, g6 g6Var) {
        this.a = str;
        this.b = u6Var;
        this.c = l6Var;
        this.d = g6Var;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, a aVar) {
        return new ge2(je1Var, aVar, this);
    }

    public g6 b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public u6 d() {
        return this.b;
    }

    public l6 e() {
        return this.c;
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + '}';
    }
}
