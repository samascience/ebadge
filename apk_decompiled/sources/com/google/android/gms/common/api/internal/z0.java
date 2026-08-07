package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import defpackage.pr3;

/* JADX INFO: loaded from: classes.dex */
final class z0 extends pr3 {
    private final /* synthetic */ Dialog a;
    private final /* synthetic */ y0 b;

    z0(y0 y0Var, Dialog dialog) {
        this.b = y0Var;
        this.a = dialog;
    }

    @Override // defpackage.pr3
    public final void a() {
        this.b.b.o();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
