package com.google.zxing.pdf417.decoder;

/* JADX INFO: loaded from: classes3.dex */
final class d {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private int e = -1;

    d(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    int a() {
        return this.c;
    }

    int b() {
        return this.b;
    }

    int c() {
        return this.e;
    }

    int d() {
        return this.a;
    }

    int e() {
        return this.d;
    }

    int f() {
        return this.b - this.a;
    }

    boolean g() {
        return h(this.e);
    }

    boolean h(int i) {
        return i != -1 && this.c == (i % 3) * 3;
    }

    void i(int i) {
        this.e = i;
    }

    void j() {
        this.e = ((this.d / 30) * 3) + (this.c / 3);
    }

    public String toString() {
        return this.e + "|" + this.d;
    }
}
