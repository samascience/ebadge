package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void i(ConstraintLayout constraintLayout) {
        h(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.e = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void q(ConstraintLayout constraintLayout) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.v0.o1(0);
        bVar.v0.P0(0);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        g();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        g();
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
