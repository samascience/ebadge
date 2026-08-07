package com.skydoves.colorpickerview.flag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import defpackage.fk0;
import defpackage.gz;

/* JADX INFO: loaded from: classes.dex */
public abstract class FlagView extends RelativeLayout {
    private FlagMode a;
    private boolean b;

    public FlagView(Context context, int i) {
        super(context);
        this.a = FlagMode.ALWAYS;
        this.b = true;
        b(i);
    }

    private void b(int i) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i, this);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, viewInflate.getMeasuredWidth(), viewInflate.getMeasuredHeight());
    }

    public void a() {
        setVisibility(8);
    }

    public boolean c() {
        return this.b;
    }

    public abstract void d(gz gzVar);

    public void e(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (getFlagMode() == FlagMode.LAST) {
                a();
                return;
            } else {
                if (getFlagMode() == FlagMode.FADE) {
                    fk0.a(this);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (getFlagMode() == FlagMode.LAST) {
                    a();
                    return;
                }
                return;
            }
        } else if (getFlagMode() == FlagMode.LAST) {
            f();
        } else if (getFlagMode() == FlagMode.FADE) {
            fk0.b(this);
        }
        f();
    }

    public void f() {
        setVisibility(0);
    }

    public FlagMode getFlagMode() {
        return this.a;
    }

    public void setFlagMode(FlagMode flagMode) {
        this.a = flagMode;
    }

    public void setFlipAble(boolean z) {
        this.b = z;
    }
}
