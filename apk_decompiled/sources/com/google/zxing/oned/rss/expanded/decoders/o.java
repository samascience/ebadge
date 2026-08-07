package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

/* JADX INFO: loaded from: classes3.dex */
final class o extends p {
    private final int b;
    private final int c;

    o(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.b = i2;
        this.c = i3;
    }

    int b() {
        return this.b;
    }

    int c() {
        return this.c;
    }

    boolean d() {
        return this.b == 10;
    }

    boolean e() {
        return this.c == 10;
    }
}
