package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class MotionEffect extends MotionHelper {
    private float n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f170q;
    private int r;
    private boolean s;
    private int t;
    private int u;

    public MotionEffect(Context context) {
        super(context);
        this.n = 0.1f;
        this.o = 49;
        this.p = 50;
        this.f170q = 0;
        this.r = 0;
        this.s = true;
        this.t = -1;
        this.u = -1;
    }

    private void E(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionEffect);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionEffect_motionEffect_start) {
                    int i2 = typedArrayObtainStyledAttributes.getInt(index, this.o);
                    this.o = i2;
                    this.o = Math.max(Math.min(i2, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_end) {
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, this.p);
                    this.p = i3;
                    this.p = Math.max(Math.min(i3, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationX) {
                    this.f170q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f170q);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationY) {
                    this.r = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.r);
                } else if (index == R$styleable.MotionEffect_motionEffect_alpha) {
                    this.n = typedArrayObtainStyledAttributes.getFloat(index, this.n);
                } else if (index == R$styleable.MotionEffect_motionEffect_move) {
                    this.u = typedArrayObtainStyledAttributes.getInt(index, this.u);
                } else if (index == R$styleable.MotionEffect_motionEffect_strict) {
                    this.s = typedArrayObtainStyledAttributes.getBoolean(index, this.s);
                } else if (index == R$styleable.MotionEffect_motionEffect_viewTransition) {
                    this.t = typedArrayObtainStyledAttributes.getResourceId(index, this.t);
                }
            }
            int i4 = this.o;
            int i5 = this.p;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.o = i4 - 1;
                } else {
                    this.p = i5 + 1;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0161  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:93:0x01db  */
    /* JADX WARN: Code duplicated, block: B:95:0x01e4  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0185, code lost:
    
        if (r14 == 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0199, code lost:
    
        if (r14 == 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a9, code lost:
    
        if (r15 == 0.0f) goto L58;
     */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap r24) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.C(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    public boolean w() {
        return true;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 0.1f;
        this.o = 49;
        this.p = 50;
        this.f170q = 0;
        this.r = 0;
        this.s = true;
        this.t = -1;
        this.u = -1;
        E(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 0.1f;
        this.o = 49;
        this.p = 50;
        this.f170q = 0;
        this.r = 0;
        this.s = true;
        this.t = -1;
        this.u = -1;
        E(context, attributeSet);
    }
}
