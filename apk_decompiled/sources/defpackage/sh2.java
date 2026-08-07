package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class sh2 {
    public static int b;
    private final int a;

    public sh2(int i) {
        this.a = i;
    }

    public static boolean b(sh2 sh2Var) {
        return sh2Var != null && sh2Var.a() == b;
    }

    public int a() {
        return this.a;
    }

    public boolean c() {
        return this.a == b;
    }

    public String toString() {
        return String.valueOf(this.a);
    }
}
