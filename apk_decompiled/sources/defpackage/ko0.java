package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ko0 {
    private final List a;
    private final char b;
    private final double c;
    private final double d;
    private final String e;
    private final String f;

    public ko0(List list, char c, double d, double d2, String str, String str2) {
        this.a = list;
        this.b = c;
        this.c = d;
        this.d = d2;
        this.e = str;
        this.f = str2;
    }

    public static int c(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List a() {
        return this.a;
    }

    public double b() {
        return this.d;
    }

    public int hashCode() {
        return c(this.b, this.f, this.e);
    }
}
