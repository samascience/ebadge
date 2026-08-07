package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ReactiveGuide extends View implements c.a {
    private int a;
    private boolean b;
    private int c;
    private boolean d;

    public ReactiveGuide(Context context) {
        super(context);
        this.a = -1;
        this.b = false;
        this.c = 0;
        this.d = true;
        super.setVisibility(8);
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.a = typedArrayObtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.b = typedArrayObtainStyledAttributes.getBoolean(index, this.b);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.c = typedArrayObtainStyledAttributes.getResourceId(index, this.c);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.d = typedArrayObtainStyledAttributes.getBoolean(index, this.d);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.a != -1) {
            ConstraintLayout.getSharedValues().a(this.a, this);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.c;
    }

    public int getAttributeId() {
        return this.a;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z) {
        this.b = z;
    }

    public void setApplyToConstraintSetId(int i) {
        this.c = i;
    }

    public void setAttributeId(int i) {
        c sharedValues = ConstraintLayout.getSharedValues();
        int i2 = this.a;
        if (i2 != -1) {
            sharedValues.b(i2, this);
        }
        this.a = i;
        if (i != -1) {
            sharedValues.a(i, this);
        }
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.a = i;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.b = i;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.c = f;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = false;
        this.c = 0;
        this.d = true;
        super.setVisibility(8);
        a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -1;
        this.b = false;
        this.c = 0;
        this.d = true;
        super.setVisibility(8);
        a(attributeSet);
    }
}
