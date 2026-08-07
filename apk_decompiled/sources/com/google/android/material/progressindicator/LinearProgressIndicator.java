package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import defpackage.be3;

/* JADX INFO: loaded from: classes3.dex */
public class LinearProgressIndicator extends BaseProgressIndicator<m> {
    public static final int p = R$style.Widget_MaterialComponents_LinearProgressIndicator;

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }

    private void s() {
        j jVar = new j((m) this.a);
        setIndeterminateDrawable(i.u(getContext(), (m) this.a, jVar));
        setProgressDrawable(e.w(getContext(), (m) this.a, jVar));
    }

    public int getIndeterminateAnimationType() {
        return ((m) this.a).h;
    }

    public int getIndicatorDirection() {
        return ((m) this.a).i;
    }

    public int getTrackStopIndicatorSize() {
        return ((m) this.a).k;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void o(int i, boolean z) {
        a aVar = this.a;
        if (aVar != null && ((m) aVar).h == 0 && isIndeterminate()) {
            return;
        }
        super.o(i, z);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a aVar = this.a;
        m mVar = (m) aVar;
        boolean z2 = true;
        if (((m) aVar).i != 1 && ((be3.A(this) != 1 || ((m) this.a).i != 2) && (be3.A(this) != 0 || ((m) this.a).i != 3))) {
            z2 = false;
        }
        mVar.j = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingLeft = i - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        i indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        e progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public m i(Context context, AttributeSet attributeSet) {
        return new m(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i) {
        if (((m) this.a).h == i) {
            return;
        }
        if (q() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        a aVar = this.a;
        ((m) aVar).h = i;
        ((m) aVar).e();
        if (i == 0) {
            getIndeterminateDrawable().y(new k((m) this.a));
        } else {
            getIndeterminateDrawable().y(new l(getContext(), (m) this.a));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((m) this.a).e();
    }

    public void setIndicatorDirection(int i) {
        a aVar = this.a;
        ((m) aVar).i = i;
        m mVar = (m) aVar;
        boolean z = true;
        if (i != 1 && ((be3.A(this) != 1 || ((m) this.a).i != 2) && (be3.A(this) != 0 || i != 3))) {
            z = false;
        }
        mVar.j = z;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        ((m) this.a).e();
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i) {
        a aVar = this.a;
        if (((m) aVar).k != i) {
            ((m) aVar).k = Math.min(i, ((m) aVar).a);
            ((m) this.a).e();
            invalidate();
        }
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, p);
        s();
    }
}
