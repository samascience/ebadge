package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* JADX INFO: loaded from: classes3.dex */
public class CircularProgressIndicator extends BaseProgressIndicator<d> {
    public static final int p = R$style.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(Context context) {
        this(context, null);
    }

    private void s() {
        b bVar = new b((d) this.a);
        setIndeterminateDrawable(i.t(getContext(), (d) this.a, bVar));
        setProgressDrawable(e.v(getContext(), (d) this.a, bVar));
    }

    public int getIndicatorDirection() {
        return ((d) this.a).j;
    }

    public int getIndicatorInset() {
        return ((d) this.a).i;
    }

    public int getIndicatorSize() {
        return ((d) this.a).h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public d i(Context context, AttributeSet attributeSet) {
        return new d(context, attributeSet);
    }

    public void setIndicatorDirection(int i) {
        ((d) this.a).j = i;
        invalidate();
    }

    public void setIndicatorInset(int i) {
        a aVar = this.a;
        if (((d) aVar).i != i) {
            ((d) aVar).i = i;
            invalidate();
        }
    }

    public void setIndicatorSize(int i) {
        int iMax = Math.max(i, getTrackThickness() * 2);
        a aVar = this.a;
        if (((d) aVar).h != iMax) {
            ((d) aVar).h = iMax;
            ((d) aVar).e();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i) {
        super.setTrackThickness(i);
        ((d) this.a).e();
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, p);
        s();
    }
}
