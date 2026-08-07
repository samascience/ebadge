package com.github.mikephil.charting.components;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import defpackage.if1;
import defpackage.ky0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class MarkerView extends RelativeLayout implements ky0 {
    private if1 a;
    private WeakReference b;

    private void setupLayoutResource(int i) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i, this);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, viewInflate.getMeasuredWidth(), viewInflate.getMeasuredHeight());
    }

    public Chart getChartView() {
        WeakReference weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    public if1 getOffset() {
        return this.a;
    }

    public void setChartView(Chart chart) {
        this.b = new WeakReference(chart);
    }

    public void setOffset(if1 if1Var) {
        this.a = if1Var;
        if (if1Var == null) {
            this.a = new if1();
        }
    }
}
