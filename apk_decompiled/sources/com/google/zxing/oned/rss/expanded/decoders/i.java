package com.google.zxing.oned.rss.expanded.decoders;

import defpackage.uh;

/* JADX INFO: loaded from: classes3.dex */
abstract class i extends h {
    i(uh uhVar) {
        super(uhVar);
    }

    protected abstract void h(StringBuilder sb, int i);

    protected abstract int i(int i);

    final void j(StringBuilder sb, int i, int i2) {
        int iF = b().f(i, i2);
        h(sb, iF);
        int i3 = i(iF);
        int i4 = 100000;
        for (int i5 = 0; i5 < 5; i5++) {
            if (i3 / i4 == 0) {
                sb.append('0');
            }
            i4 /= 10;
        }
        sb.append(i3);
    }
}
