package com.google.zxing.oned.rss.expanded.decoders;

import com.tencent.connect.common.Constants;
import defpackage.uh;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    private final uh a;
    private final r b;

    j(uh uhVar) {
        this.a = uhVar;
        this.b = new r(uhVar);
    }

    public static j a(uh uhVar) {
        if (uhVar.c(1)) {
            return new g(uhVar);
        }
        if (!uhVar.c(2)) {
            return new k(uhVar);
        }
        int iG = r.g(uhVar, 1, 4);
        if (iG == 4) {
            return new a(uhVar);
        }
        if (iG == 5) {
            return new b(uhVar);
        }
        int iG2 = r.g(uhVar, 1, 5);
        if (iG2 == 12) {
            return new c(uhVar);
        }
        if (iG2 == 13) {
            return new d(uhVar);
        }
        switch (r.g(uhVar, 1, 7)) {
            case 56:
                return new e(uhVar, "310", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            case 57:
                return new e(uhVar, "320", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            case 58:
                return new e(uhVar, "310", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            case 59:
                return new e(uhVar, "320", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            case 60:
                return new e(uhVar, "310", Constants.VIA_REPORT_TYPE_WPA_STATE);
            case 61:
                return new e(uhVar, "320", Constants.VIA_REPORT_TYPE_WPA_STATE);
            case 62:
                return new e(uhVar, "310", Constants.VIA_REPORT_TYPE_START_GROUP);
            case 63:
                return new e(uhVar, "320", Constants.VIA_REPORT_TYPE_START_GROUP);
            default:
                throw new IllegalStateException("unknown decoder: " + uhVar);
        }
    }

    protected final r b() {
        return this.b;
    }

    protected final uh c() {
        return this.a;
    }

    public abstract String d();
}
