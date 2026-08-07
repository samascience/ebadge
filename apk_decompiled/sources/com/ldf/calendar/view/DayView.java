package com.ldf.calendar.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import defpackage.dy0;
import defpackage.sa3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DayView extends RelativeLayout implements dy0 {
    private void setupLayoutResource(int i) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i, this);
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sa3.b();
    }
}
