package com.google.zxing.oned.rss.expanded.decoders;

import defpackage.uh;

/* JADX INFO: loaded from: classes3.dex */
final class b extends f {
    b(uh uhVar) {
        super(uhVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void h(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int i(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
