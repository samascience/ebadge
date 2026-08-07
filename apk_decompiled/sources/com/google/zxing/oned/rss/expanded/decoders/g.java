package com.google.zxing.oned.rss.expanded.decoders;

import defpackage.uh;

/* JADX INFO: loaded from: classes3.dex */
final class g extends h {
    g(uh uhVar) {
        super(uhVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(b().f(4, 4));
        g(sb, 8, length);
        return b().a(sb, 48);
    }
}
