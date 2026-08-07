package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.lk2;
import defpackage.mk2;
import defpackage.nk2;

/* JADX INFO: loaded from: classes.dex */
public class ScatterChart extends BarLineChartBase<mk2> implements nk2 {

    public enum ScatterShape {
        SQUARE("SQUARE"),
        CIRCLE("CIRCLE"),
        TRIANGLE("TRIANGLE"),
        CROSS("CROSS"),
        X("X"),
        CHEVRON_UP("CHEVRON_UP"),
        CHEVRON_DOWN("CHEVRON_DOWN");

        private final String shapeIdentifier;

        ScatterShape(String str) {
            this.shapeIdentifier = str;
        }

        public static ScatterShape[] getAllDefaultShapes() {
            return new ScatterShape[]{SQUARE, CIRCLE, TRIANGLE, CROSS, X, CHEVRON_UP, CHEVRON_DOWN};
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.shapeIdentifier;
        }
    }

    public ScatterChart(Context context) {
        super(context);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        this.o = new lk2(this, this.r, this.f234q);
        getXAxis().i(0.5f);
        getXAxis().h(0.5f);
    }

    public mk2 getScatterData() {
        return null;
    }

    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
