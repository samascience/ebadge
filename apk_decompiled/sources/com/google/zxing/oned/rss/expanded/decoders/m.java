package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes3.dex */
final class m extends p {
    private final char b;

    m(int i, char c) {
        super(i);
        this.b = c;
    }

    char b() {
        return this.b;
    }

    boolean c() {
        return this.b == '$';
    }
}
