package com.yanzhenjie.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import defpackage.mc1;
import defpackage.ta1;

/* JADX INFO: loaded from: classes3.dex */
public class LoadingView extends ImageView {
    private mc1 a;
    private ta1 b;

    public LoadingView(Context context) {
        super(context);
    }

    private void b() {
        mc1 mc1Var = this.a;
        if (mc1Var != null) {
            mc1Var.start();
        }
    }

    private void c() {
        mc1 mc1Var = this.a;
        if (mc1Var != null) {
            mc1Var.stop();
        }
    }

    public void a(int i, int i2, int i3) {
        this.b.w(i, i2, i3);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            b();
        } else {
            c();
        }
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ta1(context);
        mc1 mc1Var = new mc1(this.b);
        this.a = mc1Var;
        setImageDrawable(mc1Var);
    }
}
