package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class m extends l {
    private final byte[] d;

    m(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.d = bArr;
    }

    @Override // com.google.android.gms.common.l
    final byte[] d() {
        return this.d;
    }
}
