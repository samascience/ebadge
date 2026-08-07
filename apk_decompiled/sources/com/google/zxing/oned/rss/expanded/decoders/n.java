package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes3.dex */
final class n extends p {
    private final String b;
    private final int c;
    private final boolean d;

    n(int i, String str) {
        super(i);
        this.b = str;
        this.d = false;
        this.c = 0;
    }

    String b() {
        return this.b;
    }

    int c() {
        return this.c;
    }

    boolean d() {
        return this.d;
    }

    n(int i, String str, int i2) {
        super(i);
        this.d = true;
        this.c = i2;
        this.b = str;
    }
}
