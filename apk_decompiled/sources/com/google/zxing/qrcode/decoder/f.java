package com.google.zxing.qrcode.decoder;

import defpackage.nh2;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private final boolean a;

    f(boolean z) {
        this.a = z;
    }

    public void a(nh2[] nh2VarArr) {
        if (!this.a || nh2VarArr == null || nh2VarArr.length < 3) {
            return;
        }
        nh2 nh2Var = nh2VarArr[0];
        nh2VarArr[0] = nh2VarArr[2];
        nh2VarArr[2] = nh2Var;
    }
}
