package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import defpackage.m2;
import defpackage.t1;

/* JADX INFO: loaded from: classes3.dex */
abstract class a extends t1 {
    private final m2.a a;

    public a(Context context, int i) {
        this.a = new m2.a(16, context.getString(i));
    }

    @Override // defpackage.t1
    public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
        super.onInitializeAccessibilityNodeInfo(view, m2Var);
        m2Var.b(this.a);
    }
}
