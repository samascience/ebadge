package defpackage;

import java.util.Vector;

/* JADX INFO: loaded from: classes4.dex */
public class r13 implements p13 {
    private String a;
    private Vector b = new Vector(10);

    public r13(String str) {
        c(str);
    }

    public void a(p13 p13Var) {
        this.b.add(p13Var);
    }

    public String b() {
        return this.a;
    }

    public void c(String str) {
        this.a = str;
    }

    public String toString() {
        return b() != null ? b() : super.toString();
    }
}
