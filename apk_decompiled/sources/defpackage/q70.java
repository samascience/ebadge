package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class q70 {
    private final byte[] a;
    private int b;
    private final String c;
    private final List d;
    private final String e;
    private Integer f;
    private Integer g;
    private Object h;
    private final int i;
    private final int j;

    public q70(byte[] bArr, String str, List list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public int c() {
        return this.b;
    }

    public Object d() {
        return this.h;
    }

    public byte[] e() {
        return this.a;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.j;
    }

    public String h() {
        return this.c;
    }

    public boolean i() {
        return this.i >= 0 && this.j >= 0;
    }

    public void j(Integer num) {
        this.g = num;
    }

    public void k(Integer num) {
        this.f = num;
    }

    public void l(int i) {
        this.b = i;
    }

    public void m(Object obj) {
        this.h = obj;
    }

    public q70(byte[] bArr, String str, List list, String str2, int i, int i2) {
        this.a = bArr;
        this.b = bArr == null ? 0 : bArr.length * 8;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.i = i2;
        this.j = i;
    }
}
