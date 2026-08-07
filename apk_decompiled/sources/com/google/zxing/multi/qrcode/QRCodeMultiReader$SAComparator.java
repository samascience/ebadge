package com.google.zxing.multi.qrcode;

import com.google.zxing.ResultMetadataType;
import defpackage.kh2;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class QRCodeMultiReader$SAComparator implements Serializable, Comparator<kh2> {
    private QRCodeMultiReader$SAComparator() {
    }

    @Override // java.util.Comparator
    public int compare(kh2 kh2Var, kh2 kh2Var2) {
        Map mapD = kh2Var.d();
        ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
        int iIntValue = ((Integer) mapD.get(resultMetadataType)).intValue();
        int iIntValue2 = ((Integer) kh2Var2.d().get(resultMetadataType)).intValue();
        if (iIntValue < iIntValue2) {
            return -1;
        }
        return iIntValue > iIntValue2 ? 1 : 0;
    }
}
