package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import defpackage.uh;

/* JADX INFO: loaded from: classes3.dex */
abstract class f extends i {
    f(uh uhVar) {
        super(uhVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws NotFoundException {
        if (c().g() != 60) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 5);
        j(sb, 45, 15);
        return sb.toString();
    }
}
