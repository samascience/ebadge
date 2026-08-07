package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import defpackage.uh;

/* JADX INFO: loaded from: classes3.dex */
final class e extends i {
    private final String c;
    private final String d;

    e(uh uhVar, String str, String str2) {
        super(uhVar);
        this.c = str2;
        this.d = str;
    }

    private void k(StringBuilder sb, int i) {
        int iF = b().f(i, 16);
        if (iF == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.c);
        sb.append(')');
        int i2 = iF % 32;
        int i3 = iF / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws NotFoundException {
        if (c().g() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        j(sb, 48, 20);
        k(sb, 68);
        return sb.toString();
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void h(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.d);
        sb.append(i / 100000);
        sb.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int i(int i) {
        return i % 100000;
    }
}
