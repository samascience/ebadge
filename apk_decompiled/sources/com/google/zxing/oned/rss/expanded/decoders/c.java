package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import defpackage.uh;

/* JADX INFO: loaded from: classes3.dex */
final class c extends h {
    c(uh uhVar) {
        super(uhVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws NotFoundException {
        if (c().g() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        int iF = b().f(48, 2);
        sb.append("(392");
        sb.append(iF);
        sb.append(')');
        sb.append(b().c(50, null).b());
        return sb.toString();
    }
}
