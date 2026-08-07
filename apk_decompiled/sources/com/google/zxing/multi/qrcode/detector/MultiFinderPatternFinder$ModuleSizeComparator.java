package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.qrcode.detector.d;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
final class MultiFinderPatternFinder$ModuleSizeComparator implements Serializable, Comparator<d> {
    private MultiFinderPatternFinder$ModuleSizeComparator() {
    }

    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        double dI = dVar2.i() - dVar.i();
        if (dI < 0.0d) {
            return -1;
        }
        return dI > 0.0d ? 1 : 0;
    }
}
