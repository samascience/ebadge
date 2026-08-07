package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import defpackage.sw0;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    private int j;
    private int k;
    private androidx.constraintlayout.core.widgets.a l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void w(ConstraintWidget constraintWidget, int i, boolean z) {
        this.k = i;
        if (z) {
            int i2 = this.j;
            if (i2 == 5) {
                this.k = 1;
            } else if (i2 == 6) {
                this.k = 0;
            }
        } else {
            int i3 = this.j;
            if (i3 == 5) {
                this.k = 0;
            } else if (i3 == 6) {
                this.k = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            ((androidx.constraintlayout.core.widgets.a) constraintWidget).E1(this.k);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.l.y1();
    }

    public int getMargin() {
        return this.l.A1();
    }

    public int getType() {
        return this.j;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.l = new androidx.constraintlayout.core.widgets.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.l.D1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.l.F1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.d = this.l;
        v();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void o(b.a aVar, sw0 sw0Var, ConstraintLayout.b bVar, SparseArray sparseArray) {
        super.o(aVar, sw0Var, bVar, sparseArray);
        if (sw0Var instanceof androidx.constraintlayout.core.widgets.a) {
            androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) sw0Var;
            w(aVar2, aVar.e.h0, ((d) sw0Var.M()).T1());
            aVar2.D1(aVar.e.p0);
            aVar2.F1(aVar.e.i0);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(ConstraintWidget constraintWidget, boolean z) {
        w(constraintWidget, this.j, z);
    }

    public void setAllowsGoneWidget(boolean z) {
        this.l.D1(z);
    }

    public void setDpMargin(int i) {
        this.l.F1((int) ((i * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i) {
        this.l.F1(i);
    }

    public void setType(int i) {
        this.j = i;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }
}
