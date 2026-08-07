package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.tencent.connect.common.Constants;
import defpackage.be3;
import defpackage.ca1;
import defpackage.dd0;
import defpackage.e43;
import defpackage.eh1;
import defpackage.el1;
import defpackage.h43;
import defpackage.m2;
import defpackage.m90;
import defpackage.mj0;
import defpackage.nf3;
import defpackage.o23;
import defpackage.qd0;
import defpackage.qe3;
import defpackage.sg1;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.v8;
import defpackage.y6;
import defpackage.yg1;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
abstract class BaseSlider extends View {
    private static final String A0 = "BaseSlider";
    static final int B0 = R$style.Widget_MaterialComponents_Slider;
    private static final int C0 = R$attr.motionDurationMedium4;
    private static final int D0 = R$attr.motionDurationShort3;
    private static final int E0 = R$attr.motionEasingEmphasizedInterpolator;
    private static final int F0 = R$attr.motionEasingEmphasizedAccelerateInterpolator;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private float S;
    private MotionEvent T;
    private boolean U;
    private float V;
    private float W;
    private final Paint a;
    private ArrayList a0;
    private final Paint b;
    private int b0;
    private final Paint c;
    private int c0;
    private final Paint d;
    private float d0;
    private final Paint e;
    private float[] e0;
    private final Paint f;
    private boolean f0;
    private final Paint g;
    private int g0;
    private final e h;
    private int h0;
    private final AccessibilityManager i;
    private int i0;
    private d j;
    private boolean j0;
    private int k;
    private boolean k0;
    private final List l;
    private boolean l0;
    private final List m;
    private ColorStateList m0;
    private final List n;
    private ColorStateList n0;
    private boolean o;
    private ColorStateList o0;
    private ValueAnimator p;
    private ColorStateList p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator f269q;
    private ColorStateList q0;
    private final int r;
    private final Path r0;
    private int s;
    private final RectF s0;
    private int t;
    private final RectF t0;
    private int u;
    private final tg1 u0;
    private int v;
    private Drawable v0;
    private int w;
    private List w0;
    private int x;
    private float x0;
    private int y;
    private int y0;
    private int z;
    private final ViewTreeObserver.OnScrollChangedListener z0;

    private enum FullCornerDirection {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();
        float a;
        float b;
        ArrayList c;
        float d;
        boolean e;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i) {
                return new SliderState[i];
            }
        }

        /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeList(this.c);
            parcel.writeFloat(this.d);
            parcel.writeBooleanArray(new boolean[]{this.e});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.d = parcel.readFloat();
            this.e = parcel.createBooleanArray()[0];
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.l.iterator();
            while (it.hasNext()) {
                ((h43) it.next()).B0(fFloatValue);
            }
            be3.g0(BaseSlider.this);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            qe3 qe3VarJ = nf3.j(BaseSlider.this);
            Iterator it = BaseSlider.this.l.iterator();
            while (it.hasNext()) {
                qe3VarJ.b((h43) it.next());
            }
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FullCornerDirection.values().length];
            a = iArr;
            try {
                iArr[FullCornerDirection.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FullCornerDirection.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FullCornerDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FullCornerDirection.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static class e extends mj0 {
        private final BaseSlider n;
        final Rect o;

        e(BaseSlider baseSlider) {
            super(baseSlider);
            this.o = new Rect();
            this.n = baseSlider;
        }

        private String N(int i) {
            if (i == this.n.getValues().size() - 1) {
                return this.n.getContext().getString(R$string.material_slider_range_end);
            }
            return i == 0 ? this.n.getContext().getString(R$string.material_slider_range_start) : Constants.STR_EMPTY;
        }

        @Override // defpackage.mj0
        protected boolean A(int i, int i2, Bundle bundle) {
            if (!this.n.isEnabled()) {
                return false;
            }
            if (i2 != 4096 && i2 != 8192) {
                if (i2 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                    if (this.n.p0(i, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                        this.n.s0();
                        this.n.postInvalidate();
                        t(i);
                        return true;
                    }
                }
                return false;
            }
            float fL = this.n.l(20);
            if (i2 == 8192) {
                fL = -fL;
            }
            if (this.n.Q()) {
                fL = -fL;
            }
            if (!this.n.p0(i, eh1.a(this.n.getValues().get(i).floatValue() + fL, this.n.getValueFrom(), this.n.getValueTo()))) {
                return false;
            }
            this.n.s0();
            this.n.postInvalidate();
            t(i);
            return true;
        }

        @Override // defpackage.mj0
        protected void E(int i, m2 m2Var) {
            m2Var.b(m2.a.L);
            List<Float> values = this.n.getValues();
            float fFloatValue = values.get(i).floatValue();
            float valueFrom = this.n.getValueFrom();
            float valueTo = this.n.getValueTo();
            if (this.n.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    m2Var.a(8192);
                }
                if (fFloatValue < valueTo) {
                    m2Var.a(4096);
                }
            }
            m2Var.D0(m2.g.a(1, valueFrom, valueTo, fFloatValue));
            m2Var.j0(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.n.getContentDescription() != null) {
                sb.append(this.n.getContentDescription());
                sb.append(",");
            }
            String strA = this.n.A(fFloatValue);
            String string = this.n.getContext().getString(R$string.material_slider_value);
            if (values.size() > 1) {
                string = N(i);
            }
            sb.append(String.format(Locale.US, "%s, %s", string, strA));
            m2Var.n0(sb.toString());
            this.n.r0(i, this.o);
            m2Var.e0(this.o);
        }

        @Override // defpackage.mj0
        protected int q(float f, float f2) {
            for (int i = 0; i < this.n.getValues().size(); i++) {
                this.n.r0(i, this.o);
                if (this.o.contains((int) f, (int) f2)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // defpackage.mj0
        protected void r(List list) {
            for (int i = 0; i < this.n.getValues().size(); i++) {
                list.add(Integer.valueOf(i));
            }
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i) {
        super(yg1.c(context, attributeSet, i, B0), attributeSet, i);
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = false;
        this.N = -1;
        this.O = -1;
        this.U = false;
        this.a0 = new ArrayList();
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = 0.0f;
        this.f0 = true;
        this.k0 = false;
        this.r0 = new Path();
        this.s0 = new RectF();
        this.t0 = new RectF();
        tg1 tg1Var = new tg1();
        this.u0 = tg1Var;
        this.w0 = Collections.emptyList();
        this.y0 = 0;
        this.z0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.slider.a
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.a.t0();
            }
        };
        Context context2 = getContext();
        this.a = new Paint();
        this.b = new Paint();
        Paint paint = new Paint(1);
        this.c = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.d = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.e = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.f = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.g = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        S(context2.getResources());
        h0(context2, attributeSet, i);
        setFocusable(true);
        setClickable(true);
        tg1Var.i0(2);
        this.r = ViewConfiguration.get(context2).getScaledTouchSlop();
        e eVar = new e(this);
        this.h = eVar;
        be3.p0(this, eVar);
        this.i = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A(float f) {
        if (J()) {
            throw null;
        }
        return String.format(((float) ((int) f)) == f ? "%.0f" : "%.2f", Float.valueOf(f));
    }

    private void A0() {
        if (this.V >= this.W) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.V), Float.valueOf(this.W)));
        }
    }

    private float[] B() {
        float fFloatValue = ((Float) this.a0.get(0)).floatValue();
        ArrayList arrayList = this.a0;
        float fFloatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (this.a0.size() == 1) {
            fFloatValue = this.V;
        }
        float fB0 = b0(fFloatValue);
        float fB1 = b0(fFloatValue2);
        return Q() ? new float[]{fB1, fB0} : new float[]{fB0, fB1};
    }

    private void B0() {
        if (this.W <= this.V) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.W), Float.valueOf(this.V)));
        }
    }

    private static float C(ValueAnimator valueAnimator, float f) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    private void C0() {
        for (Float f : this.a0) {
            if (f.floatValue() < this.V || f.floatValue() > this.W) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", f, Float.valueOf(this.V), Float.valueOf(this.W)));
            }
            if (this.d0 > 0.0f && !D0(f.floatValue())) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", f, Float.valueOf(this.V), Float.valueOf(this.d0), Float.valueOf(this.d0)));
            }
        }
    }

    private float D(int i, float f) {
        float minSeparation = getMinSeparation();
        if (this.y0 == 0) {
            minSeparation = q(minSeparation);
        }
        if (Q()) {
            minSeparation = -minSeparation;
        }
        int i2 = i + 1;
        int i3 = i - 1;
        return eh1.a(f, i3 < 0 ? this.V : ((Float) this.a0.get(i3)).floatValue() + minSeparation, i2 >= this.a0.size() ? this.W : ((Float) this.a0.get(i2)).floatValue() - minSeparation);
    }

    private boolean D0(float f) {
        return O(new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.V)), MathContext.DECIMAL64).doubleValue());
    }

    private int E(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float E0(float f) {
        return (b0(f) * this.i0) + this.I;
    }

    private float[] F(float f, float f2) {
        return new float[]{f, f, f2, f2, f2, f2, f, f};
    }

    private void F0() {
        float f = this.d0;
        if (f == 0.0f) {
            return;
        }
        if (((int) f) != f) {
            Log.w(A0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f)));
        }
        float f2 = this.V;
        if (((int) f2) != f2) {
            Log.w(A0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f2)));
        }
        float f3 = this.W;
        if (((int) f3) != f3) {
            Log.w(A0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f3)));
        }
    }

    private float G() {
        double dO0 = o0(this.x0);
        if (Q()) {
            dO0 = 1.0d - dO0;
        }
        float f = this.W;
        float f2 = this.V;
        return (float) ((dO0 * ((double) (f - f2))) + ((double) f2));
    }

    private float H() {
        float f = this.x0;
        if (Q()) {
            f = 1.0f - f;
        }
        float f2 = this.W;
        float f3 = this.V;
        return (f * (f2 - f3)) + f3;
    }

    private boolean I() {
        return this.M > 0;
    }

    private Drawable K(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        h(drawableNewDrawable);
        return drawableNewDrawable;
    }

    private void L() {
        this.a.setStrokeWidth(this.H);
        this.b.setStrokeWidth(this.H);
    }

    private boolean M() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private static boolean N(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private boolean O(double d2) {
        double dDoubleValue = new BigDecimal(Double.toString(d2)).divide(new BigDecimal(Float.toString(this.d0)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    private boolean P(MotionEvent motionEvent) {
        return !N(motionEvent) && M();
    }

    private boolean R() {
        Rect rect = new Rect();
        nf3.i(this).getHitRect(rect);
        return getLocalVisibleRect(rect);
    }

    private void S(Resources resources) {
        this.z = resources.getDimensionPixelSize(R$dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_side_padding);
        this.s = dimensionPixelOffset;
        this.I = dimensionPixelOffset;
        this.t = resources.getDimensionPixelSize(R$dimen.mtrl_slider_thumb_radius);
        this.u = resources.getDimensionPixelSize(R$dimen.mtrl_slider_track_height);
        int i = R$dimen.mtrl_slider_tick_radius;
        this.v = resources.getDimensionPixelSize(i);
        this.w = resources.getDimensionPixelSize(i);
        this.x = resources.getDimensionPixelSize(R$dimen.mtrl_slider_tick_min_spacing);
        this.R = resources.getDimensionPixelSize(R$dimen.mtrl_slider_label_padding);
    }

    private void T() {
        if (this.d0 <= 0.0f) {
            return;
        }
        x0();
        int iMin = Math.min((int) (((this.W - this.V) / this.d0) + 1.0f), (this.i0 / this.x) + 1);
        float[] fArr = this.e0;
        if (fArr == null || fArr.length != iMin * 2) {
            this.e0 = new float[iMin * 2];
        }
        float f = this.i0 / (iMin - 1);
        for (int i = 0; i < iMin * 2; i += 2) {
            float[] fArr2 = this.e0;
            fArr2[i] = this.I + ((i / 2.0f) * f);
            fArr2[i + 1] = m();
        }
    }

    private void U(Canvas canvas, int i, int i2) {
        if (m0()) {
            int iB0 = (int) (this.I + (b0(((Float) this.a0.get(this.c0)).floatValue()) * i));
            if (Build.VERSION.SDK_INT < 28) {
                int i3 = this.L;
                canvas.clipRect(iB0 - i3, i2 - i3, iB0 + i3, i3 + i2, Region.Op.UNION);
            }
            canvas.drawCircle(iB0, i2, this.L, this.d);
        }
    }

    private void V(Canvas canvas, int i) {
        if (this.P <= 0) {
            return;
        }
        if (this.a0.size() >= 1) {
            ArrayList arrayList = this.a0;
            float fFloatValue = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
            float f = this.W;
            if (fFloatValue < f) {
                canvas.drawPoint(E0(f), i, this.g);
            }
        }
        if (this.a0.size() > 1) {
            float fFloatValue2 = ((Float) this.a0.get(0)).floatValue();
            float f2 = this.V;
            if (fFloatValue2 > f2) {
                canvas.drawPoint(E0(f2), i, this.g);
            }
        }
    }

    private void W(Canvas canvas) {
        if (!this.f0 || this.d0 <= 0.0f) {
            return;
        }
        float[] fArrB = B();
        int iCeil = (int) Math.ceil(fArrB[0] * ((this.e0.length / 2.0f) - 1.0f));
        int iFloor = (int) Math.floor(fArrB[1] * ((this.e0.length / 2.0f) - 1.0f));
        if (iCeil > 0) {
            canvas.drawPoints(this.e0, 0, iCeil * 2, this.e);
        }
        if (iCeil <= iFloor) {
            canvas.drawPoints(this.e0, iCeil * 2, ((iFloor - iCeil) + 1) * 2, this.f);
        }
        int i = (iFloor + 1) * 2;
        float[] fArr = this.e0;
        if (i < fArr.length) {
            canvas.drawPoints(fArr, i, fArr.length - i, this.e);
        }
    }

    private boolean X() {
        int iMax = this.s + Math.max(Math.max(Math.max((this.J / 2) - this.t, 0), Math.max((this.H - this.u) / 2, 0)), Math.max(Math.max(this.g0 - this.v, 0), Math.max(this.h0 - this.w, 0)));
        if (this.I == iMax) {
            return false;
        }
        this.I = iMax;
        if (!be3.T(this)) {
            return true;
        }
        v0(getWidth());
        return true;
    }

    private boolean Y() {
        int iMax = Math.max(this.z, Math.max(this.H + getPaddingTop() + getPaddingBottom(), this.K + getPaddingTop() + getPaddingBottom()));
        if (iMax == this.F) {
            return false;
        }
        this.F = iMax;
        return true;
    }

    private boolean Z(int i) {
        int i2 = this.c0;
        int iC = (int) eh1.c(((long) i2) + ((long) i), 0L, this.a0.size() - 1);
        this.c0 = iC;
        if (iC == i2) {
            return false;
        }
        if (this.b0 != -1) {
            this.b0 = iC;
        }
        s0();
        postInvalidate();
        return true;
    }

    private boolean a0(int i) {
        if (Q()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        return Z(i);
    }

    private float b0(float f) {
        float f2 = this.V;
        float f3 = (f - f2) / (this.W - f2);
        return Q() ? 1.0f - f3 : f3;
    }

    private Boolean c0(int i, KeyEvent keyEvent) {
        if (i == 61) {
            if (keyEvent.hasNoModifiers()) {
                return Boolean.valueOf(Z(1));
            }
            return keyEvent.isShiftPressed() ? Boolean.valueOf(Z(-1)) : Boolean.FALSE;
        }
        if (i != 66) {
            if (i != 81) {
                if (i == 69) {
                    Z(-1);
                    return Boolean.TRUE;
                }
                if (i != 70) {
                    switch (i) {
                        case 21:
                            a0(-1);
                            return Boolean.TRUE;
                        case 22:
                            a0(1);
                            return Boolean.TRUE;
                        case 23:
                            break;
                        default:
                            return null;
                    }
                }
            }
            Z(1);
            return Boolean.TRUE;
        }
        this.b0 = this.c0;
        postInvalidate();
        return Boolean.TRUE;
    }

    private void d0() {
        Iterator it = this.n.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    private void e0() {
        Iterator it = this.n.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    private void g0(h43 h43Var, float f) {
        int iB0 = (this.I + ((int) (b0(f) * this.i0))) - (h43Var.getIntrinsicWidth() / 2);
        int iM = m() - (this.R + (this.K / 2));
        h43Var.setBounds(iB0, iM - h43Var.getIntrinsicHeight(), h43Var.getIntrinsicWidth() + iB0, iM);
        Rect rect = new Rect(h43Var.getBounds());
        m90.c(nf3.i(this), this, rect);
        h43Var.setBounds(rect);
    }

    private void h(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.J, this.K);
        } else {
            float fMax = Math.max(this.J, this.K) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    private void h0(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayI = o23.i(context, attributeSet, R$styleable.Slider, i, B0, new int[0]);
        this.k = typedArrayI.getResourceId(R$styleable.Slider_labelStyle, R$style.Widget_MaterialComponents_Tooltip);
        this.V = typedArrayI.getFloat(R$styleable.Slider_android_valueFrom, 0.0f);
        this.W = typedArrayI.getFloat(R$styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.V));
        this.d0 = typedArrayI.getFloat(R$styleable.Slider_android_stepSize, 0.0f);
        this.y = (int) Math.ceil(typedArrayI.getDimension(R$styleable.Slider_minTouchTargetSize, (float) Math.ceil(nf3.g(getContext(), 48))));
        int i2 = R$styleable.Slider_trackColor;
        boolean zHasValue = typedArrayI.hasValue(i2);
        int i3 = zHasValue ? i2 : R$styleable.Slider_trackColorInactive;
        if (!zHasValue) {
            i2 = R$styleable.Slider_trackColorActive;
        }
        ColorStateList colorStateListA = sg1.a(context, typedArrayI, i3);
        if (colorStateListA == null) {
            colorStateListA = v8.a(context, R$color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateListA);
        ColorStateList colorStateListA2 = sg1.a(context, typedArrayI, i2);
        if (colorStateListA2 == null) {
            colorStateListA2 = v8.a(context, R$color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateListA2);
        this.u0.b0(sg1.a(context, typedArrayI, R$styleable.Slider_thumbColor));
        int i4 = R$styleable.Slider_thumbStrokeColor;
        if (typedArrayI.hasValue(i4)) {
            setThumbStrokeColor(sg1.a(context, typedArrayI, i4));
        }
        setThumbStrokeWidth(typedArrayI.getDimension(R$styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateListA3 = sg1.a(context, typedArrayI, R$styleable.Slider_haloColor);
        if (colorStateListA3 == null) {
            colorStateListA3 = v8.a(context, R$color.material_slider_halo_color);
        }
        setHaloTintList(colorStateListA3);
        this.f0 = typedArrayI.getBoolean(R$styleable.Slider_tickVisible, true);
        int i5 = R$styleable.Slider_tickColor;
        boolean zHasValue2 = typedArrayI.hasValue(i5);
        int i6 = zHasValue2 ? i5 : R$styleable.Slider_tickColorInactive;
        if (!zHasValue2) {
            i5 = R$styleable.Slider_tickColorActive;
        }
        ColorStateList colorStateListA4 = sg1.a(context, typedArrayI, i6);
        if (colorStateListA4 == null) {
            colorStateListA4 = v8.a(context, R$color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateListA4);
        ColorStateList colorStateListA5 = sg1.a(context, typedArrayI, i5);
        if (colorStateListA5 == null) {
            colorStateListA5 = v8.a(context, R$color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateListA5);
        setThumbTrackGapSize(typedArrayI.getDimensionPixelSize(R$styleable.Slider_thumbTrackGapSize, 0));
        setTrackStopIndicatorSize(typedArrayI.getDimensionPixelSize(R$styleable.Slider_trackStopIndicatorSize, 0));
        setTrackInsideCornerSize(typedArrayI.getDimensionPixelSize(R$styleable.Slider_trackInsideCornerSize, 0));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R$styleable.Slider_thumbRadius, 0) * 2;
        int dimensionPixelSize2 = typedArrayI.getDimensionPixelSize(R$styleable.Slider_thumbWidth, dimensionPixelSize);
        int dimensionPixelSize3 = typedArrayI.getDimensionPixelSize(R$styleable.Slider_thumbHeight, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(typedArrayI.getDimensionPixelSize(R$styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayI.getDimension(R$styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayI.getDimensionPixelSize(R$styleable.Slider_trackHeight, 0));
        setTickActiveRadius(typedArrayI.getDimensionPixelSize(R$styleable.Slider_tickRadiusActive, this.P / 2));
        setTickInactiveRadius(typedArrayI.getDimensionPixelSize(R$styleable.Slider_tickRadiusInactive, this.P / 2));
        setLabelBehavior(typedArrayI.getInt(R$styleable.Slider_labelBehavior, 0));
        if (!typedArrayI.getBoolean(R$styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayI.recycle();
    }

    private void i(h43 h43Var) {
        h43Var.A0(nf3.i(this));
    }

    private void i0(int i) {
        d dVar = this.j;
        if (dVar == null) {
            this.j = new d(this, null);
        } else {
            removeCallbacks(dVar);
        }
        this.j.a(i);
        postDelayed(this.j, 200L);
    }

    private Float j(int i) {
        float fL = this.k0 ? l(20) : k();
        if (i == 21) {
            if (!Q()) {
                fL = -fL;
            }
            return Float.valueOf(fL);
        }
        if (i == 22) {
            if (Q()) {
                fL = -fL;
            }
            return Float.valueOf(fL);
        }
        if (i == 69) {
            return Float.valueOf(-fL);
        }
        if (i == 70 || i == 81) {
            return Float.valueOf(fL);
        }
        return null;
    }

    private void j0(h43 h43Var, float f) {
        h43Var.C0(A(f));
        g0(h43Var, f);
        nf3.j(this).a(h43Var);
    }

    private float k() {
        float f = this.d0;
        if (f == 0.0f) {
            return 1.0f;
        }
        return f;
    }

    private void k0(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.a0.size() == arrayList.size() && this.a0.equals(arrayList)) {
            return;
        }
        this.a0 = arrayList;
        this.l0 = true;
        this.c0 = 0;
        s0();
        o();
        s();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float l(int i) {
        float fK = k();
        float f = (this.W - this.V) / fK;
        float f2 = i;
        return f <= f2 ? fK : Math.round(f / f2) * fK;
    }

    private boolean l0() {
        return this.G == 3;
    }

    private int m() {
        return (this.F / 2) + ((this.G == 1 || l0()) ? ((h43) this.l.get(0)).getIntrinsicHeight() : 0);
    }

    private boolean m0() {
        return this.j0 || !(getBackground() instanceof RippleDrawable);
    }

    private ValueAnimator n(boolean z) {
        int iF;
        TimeInterpolator timeInterpolatorG;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(C(z ? this.f269q : this.p, z ? 0.0f : 1.0f), z ? 1.0f : 0.0f);
        if (z) {
            iF = el1.f(getContext(), C0, 83);
            timeInterpolatorG = el1.g(getContext(), E0, y6.e);
        } else {
            iF = el1.f(getContext(), D0, 117);
            timeInterpolatorG = el1.g(getContext(), F0, y6.c);
        }
        valueAnimatorOfFloat.setDuration(iF);
        valueAnimatorOfFloat.setInterpolator(timeInterpolatorG);
        valueAnimatorOfFloat.addUpdateListener(new a());
        return valueAnimatorOfFloat;
    }

    private boolean n0(float f) {
        return p0(this.b0, f);
    }

    private void o() {
        if (this.l.size() > this.a0.size()) {
            List<h43> listSubList = this.l.subList(this.a0.size(), this.l.size());
            for (h43 h43Var : listSubList) {
                if (be3.S(this)) {
                    p(h43Var);
                }
            }
            listSubList.clear();
        }
        while (true) {
            if (this.l.size() >= this.a0.size()) {
                break;
            }
            h43 h43VarU0 = h43.u0(getContext(), null, 0, this.k);
            this.l.add(h43VarU0);
            if (be3.S(this)) {
                i(h43VarU0);
            }
        }
        int i = this.l.size() != 1 ? 1 : 0;
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((h43) it.next()).m0(i);
        }
    }

    private double o0(float f) {
        float f2 = this.d0;
        if (f2 <= 0.0f) {
            return f;
        }
        int i = (int) ((this.W - this.V) / f2);
        return ((double) Math.round(f * i)) / ((double) i);
    }

    private void p(h43 h43Var) {
        qe3 qe3VarJ = nf3.j(this);
        if (qe3VarJ != null) {
            qe3VarJ.b(h43Var);
            h43Var.w0(nf3.i(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p0(int i, float f) {
        this.c0 = i;
        if (Math.abs(f - ((Float) this.a0.get(i)).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.a0.set(i, Float.valueOf(D(i, f)));
        r(i);
        return true;
    }

    private float q(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        float f2 = (f - this.I) / this.i0;
        float f3 = this.V;
        return (f2 * (f3 - this.W)) + f3;
    }

    private boolean q0() {
        return n0(G());
    }

    private void r(int i) {
        Iterator it = this.m.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            ((Float) this.a0.get(i)).floatValue();
            throw null;
        }
        AccessibilityManager accessibilityManager = this.i;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        i0(i);
    }

    private void s() {
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            e43.a(it.next());
            Iterator it2 = this.a0.iterator();
            if (it2.hasNext()) {
                ((Float) it2.next()).floatValue();
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        if (m0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iB0 = (int) ((b0(((Float) this.a0.get(this.c0)).floatValue()) * this.i0) + this.I);
            int iM = m();
            int i = this.L;
            dd0.l(background, iB0 - i, iM - i, iB0 + i, iM + i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009f  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b5 A[SYNTHETIC] */
    private void t(Canvas canvas, int i, int i2) {
        int i3;
        float[] fArrB = B();
        int i4 = this.I;
        float f = i;
        float f2 = i4 + (fArrB[1] * f);
        float fE0 = i4 + (fArrB[0] * f);
        if (!I()) {
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setStrokeCap(Paint.Cap.ROUND);
            float f3 = i2;
            canvas.drawLine(fE0, f3, f2, f3, this.b);
            return;
        }
        FullCornerDirection fullCornerDirection = FullCornerDirection.NONE;
        if (this.a0.size() == 1) {
            fullCornerDirection = Q() ? FullCornerDirection.RIGHT : FullCornerDirection.LEFT;
        }
        for (int i5 = 0; i5 < this.a0.size(); i5++) {
            if (this.a0.size() > 1) {
                if (i5 > 0) {
                    fE0 = E0(((Float) this.a0.get(i5 - 1)).floatValue());
                }
                float fE1 = E0(((Float) this.a0.get(i5)).floatValue());
                if (Q()) {
                    f2 = fE0;
                    fE0 = fE1;
                } else {
                    f2 = fE1;
                }
            }
            int i6 = c.a[fullCornerDirection.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    fE0 -= this.H / 2.0f;
                    i3 = this.M;
                } else if (i6 == 3) {
                    fE0 += this.M;
                    f2 += this.H / 2.0f;
                }
                if (fE0 >= f2) {
                    RectF rectF = this.s0;
                    float f4 = i2;
                    int i7 = this.H;
                    rectF.set(fE0, f4 - (i7 / 2.0f), f2, f4 + (i7 / 2.0f));
                    u0(canvas, this.b, this.s0, fullCornerDirection);
                }
            } else {
                i3 = this.M;
                fE0 += i3;
            }
            f2 -= i3;
            if (fE0 >= f2) {
                RectF rectF2 = this.s0;
                float f5 = i2;
                int i8 = this.H;
                rectF2.set(fE0, f5 - (i8 / 2.0f), f2, f5 + (i8 / 2.0f));
                u0(canvas, this.b, this.s0, fullCornerDirection);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        int i = this.G;
        if (i == 0 || i == 1) {
            if (this.b0 == -1 || !isEnabled()) {
                y();
                return;
            } else {
                x();
                return;
            }
        }
        if (i == 2) {
            y();
            return;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unexpected labelBehavior: " + this.G);
        }
        if (isEnabled() && R()) {
            x();
        } else {
            y();
        }
    }

    private void u(Canvas canvas, int i, int i2) {
        float[] fArrB = B();
        int i3 = this.I;
        float f = i;
        float f2 = i3 + (fArrB[1] * f);
        if (f2 < i3 + i) {
            if (I()) {
                RectF rectF = this.s0;
                float f3 = f2 + this.M;
                float f4 = i2;
                int i4 = this.H;
                rectF.set(f3, f4 - (i4 / 2.0f), this.I + i + (i4 / 2.0f), f4 + (i4 / 2.0f));
                u0(canvas, this.a, this.s0, FullCornerDirection.RIGHT);
            } else {
                this.a.setStyle(Paint.Style.STROKE);
                this.a.setStrokeCap(Paint.Cap.ROUND);
                float f5 = i2;
                canvas.drawLine(f2, f5, this.I + i, f5, this.a);
            }
        }
        int i5 = this.I;
        float f6 = i5 + (fArrB[0] * f);
        if (f6 > i5) {
            if (!I()) {
                this.a.setStyle(Paint.Style.STROKE);
                this.a.setStrokeCap(Paint.Cap.ROUND);
                float f7 = i2;
                canvas.drawLine(this.I, f7, f6, f7, this.a);
                return;
            }
            RectF rectF2 = this.s0;
            float f8 = this.I;
            int i6 = this.H;
            float f9 = i2;
            rectF2.set(f8 - (i6 / 2.0f), f9 - (i6 / 2.0f), f6 - this.M, f9 + (i6 / 2.0f));
            u0(canvas, this.a, this.s0, FullCornerDirection.LEFT);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0042  */
    /* JADX WARN: Code duplicated, block: B:14:0x0053  */
    /* JADX WARN: Code duplicated, block: B:16:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0074  */
    /* JADX WARN: Code duplicated, block: B:18:0x0088  */
    /* JADX WARN: Code duplicated, block: B:19:0x0097  */
    private void u0(Canvas canvas, Paint paint, RectF rectF, FullCornerDirection fullCornerDirection) {
        int i;
        float fMax;
        int i2;
        int i3 = this.H;
        float f = i3 / 2.0f;
        float f2 = i3 / 2.0f;
        int[] iArr = c.a;
        int i4 = iArr[fullCornerDirection.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                i = this.Q;
            } else if (i4 == 3) {
                f = this.Q;
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            this.r0.reset();
            if (rectF.width() >= f + f2) {
                this.r0.addRoundRect(rectF, F(f, f2), Path.Direction.CW);
                canvas.drawPath(this.r0, paint);
                return;
            }
            float fMin = Math.min(f, f2);
            fMax = Math.max(f, f2);
            canvas.save();
            this.r0.addRoundRect(rectF, fMin, fMin, Path.Direction.CW);
            canvas.clipPath(this.r0);
            i2 = iArr[fullCornerDirection.ordinal()];
            if (i2 != 2) {
                RectF rectF2 = this.t0;
                float f3 = rectF.left;
                rectF2.set(f3, rectF.top, (2.0f * fMax) + f3, rectF.bottom);
            } else if (i2 != 3) {
                this.t0.set(rectF.centerX() - fMax, rectF.top, rectF.centerX() + fMax, rectF.bottom);
            } else {
                RectF rectF3 = this.t0;
                float f4 = rectF.right;
                rectF3.set(f4 - (2.0f * fMax), rectF.top, f4, rectF.bottom);
            }
            canvas.drawRoundRect(this.t0, fMax, fMax, paint);
            canvas.restore();
        }
        i = this.Q;
        f = i;
        f2 = i;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        this.r0.reset();
        if (rectF.width() >= f + f2) {
            this.r0.addRoundRect(rectF, F(f, f2), Path.Direction.CW);
            canvas.drawPath(this.r0, paint);
            return;
        }
        float fMin2 = Math.min(f, f2);
        fMax = Math.max(f, f2);
        canvas.save();
        this.r0.addRoundRect(rectF, fMin2, fMin2, Path.Direction.CW);
        canvas.clipPath(this.r0);
        i2 = iArr[fullCornerDirection.ordinal()];
        if (i2 != 2) {
            RectF rectF4 = this.t0;
            float f5 = rectF.left;
            rectF4.set(f5, rectF.top, (2.0f * fMax) + f5, rectF.bottom);
        } else if (i2 != 3) {
            this.t0.set(rectF.centerX() - fMax, rectF.top, rectF.centerX() + fMax, rectF.bottom);
        } else {
            RectF rectF5 = this.t0;
            float f6 = rectF.right;
            rectF5.set(f6 - (2.0f * fMax), rectF.top, f6, rectF.bottom);
        }
        canvas.drawRoundRect(this.t0, fMax, fMax, paint);
        canvas.restore();
    }

    private void v(Canvas canvas, int i, int i2, float f, Drawable drawable) {
        canvas.save();
        canvas.translate((this.I + ((int) (b0(f) * i))) - (drawable.getBounds().width() / 2.0f), i2 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private void v0(int i) {
        this.i0 = Math.max(i - (this.I * 2), 0);
        T();
    }

    private void w(Canvas canvas, int i, int i2) {
        for (int i3 = 0; i3 < this.a0.size(); i3++) {
            float fFloatValue = ((Float) this.a0.get(i3)).floatValue();
            Drawable drawable = this.v0;
            if (drawable != null) {
                v(canvas, i, i2, fFloatValue, drawable);
            } else if (i3 < this.w0.size()) {
                v(canvas, i, i2, fFloatValue, (Drawable) this.w0.get(i3));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(this.I + (b0(fFloatValue) * i), i2, getThumbRadius(), this.c);
                }
                v(canvas, i, i2, fFloatValue, this.u0);
            }
        }
    }

    private void w0() {
        boolean zY = Y();
        boolean zX = X();
        if (zY) {
            requestLayout();
        } else if (zX) {
            postInvalidate();
        }
    }

    private void x() {
        if (!this.o) {
            this.o = true;
            ValueAnimator valueAnimatorN = n(true);
            this.p = valueAnimatorN;
            this.f269q = null;
            valueAnimatorN.start();
        }
        Iterator it = this.l.iterator();
        for (int i = 0; i < this.a0.size() && it.hasNext(); i++) {
            if (i != this.c0) {
                j0((h43) it.next(), ((Float) this.a0.get(i)).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.l.size()), Integer.valueOf(this.a0.size())));
        }
        j0((h43) it.next(), ((Float) this.a0.get(this.c0)).floatValue());
    }

    private void x0() {
        if (this.l0) {
            A0();
            B0();
            z0();
            C0();
            y0();
            F0();
            this.l0 = false;
        }
    }

    private void y() {
        if (this.o) {
            this.o = false;
            ValueAnimator valueAnimatorN = n(false);
            this.f269q = valueAnimatorN;
            this.p = null;
            valueAnimatorN.addListener(new b());
            this.f269q.start();
        }
    }

    private void y0() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(minSeparation)));
        }
        float f = this.d0;
        if (f <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.y0 != 1) {
            throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.d0)));
        }
        if (minSeparation < f || !O(minSeparation)) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.d0), Float.valueOf(this.d0)));
        }
    }

    private void z(int i) {
        if (i == 1) {
            Z(Integer.MAX_VALUE);
            return;
        }
        if (i == 2) {
            Z(Integer.MIN_VALUE);
        } else if (i == 17) {
            a0(Integer.MAX_VALUE);
        } else {
            if (i != 66) {
                return;
            }
            a0(Integer.MIN_VALUE);
        }
    }

    private void z0() {
        if (this.d0 > 0.0f && !D0(this.W)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.d0), Float.valueOf(this.V), Float.valueOf(this.W)));
        }
    }

    public boolean J() {
        return false;
    }

    final boolean Q() {
        return be3.A(this) == 1;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.h.k(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.setColor(E(this.q0));
        this.b.setColor(E(this.p0));
        this.e.setColor(E(this.o0));
        this.f.setColor(E(this.n0));
        this.g.setColor(E(this.p0));
        for (h43 h43Var : this.l) {
            if (h43Var.isStateful()) {
                h43Var.setState(getDrawableState());
            }
        }
        if (this.u0.isStateful()) {
            this.u0.setState(getDrawableState());
        }
        this.d.setColor(E(this.m0));
        this.d.setAlpha(63);
    }

    protected boolean f0() {
        if (this.b0 != -1) {
            return true;
        }
        float fH = H();
        float fE0 = E0(fH);
        this.b0 = 0;
        float fAbs = Math.abs(((Float) this.a0.get(0)).floatValue() - fH);
        for (int i = 1; i < this.a0.size(); i++) {
            float fAbs2 = Math.abs(((Float) this.a0.get(i)).floatValue() - fH);
            float fE1 = E0(((Float) this.a0.get(i)).floatValue());
            if (Float.compare(fAbs2, fAbs) > 0) {
                break;
            }
            boolean z = !Q() ? fE1 - fE0 >= 0.0f : fE1 - fE0 <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.b0 = i;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fE1 - fE0) < this.r) {
                        this.b0 = -1;
                        return false;
                    }
                    if (z) {
                        this.b0 = i;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.b0 != -1;
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    final int getAccessibilityFocusedVirtualViewId() {
        return this.h.m();
    }

    public int getActiveThumbIndex() {
        return this.b0;
    }

    public int getFocusedThumbIndex() {
        return this.c0;
    }

    public int getHaloRadius() {
        return this.L;
    }

    public ColorStateList getHaloTintList() {
        return this.m0;
    }

    public int getLabelBehavior() {
        return this.G;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.d0;
    }

    public float getThumbElevation() {
        return this.u0.w();
    }

    public int getThumbHeight() {
        return this.K;
    }

    public int getThumbRadius() {
        return this.J / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.u0.F();
    }

    public float getThumbStrokeWidth() {
        return this.u0.H();
    }

    public ColorStateList getThumbTintList() {
        return this.u0.x();
    }

    public int getThumbTrackGapSize() {
        return this.M;
    }

    public int getThumbWidth() {
        return this.J;
    }

    public int getTickActiveRadius() {
        return this.g0;
    }

    public ColorStateList getTickActiveTintList() {
        return this.n0;
    }

    public int getTickInactiveRadius() {
        return this.h0;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.o0;
    }

    public ColorStateList getTickTintList() {
        if (this.o0.equals(this.n0)) {
            return this.n0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.p0;
    }

    public int getTrackHeight() {
        return this.H;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.q0;
    }

    public int getTrackInsideCornerSize() {
        return this.Q;
    }

    public int getTrackSidePadding() {
        return this.I;
    }

    public int getTrackStopIndicatorSize() {
        return this.P;
    }

    public ColorStateList getTrackTintList() {
        if (this.q0.equals(this.p0)) {
            return this.p0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.i0;
    }

    public float getValueFrom() {
        return this.V;
    }

    public float getValueTo() {
        return this.W;
    }

    List<Float> getValues() {
        return new ArrayList(this.a0);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.z0);
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            i((h43) it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        d dVar = this.j;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.o = false;
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            p((h43) it.next());
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.z0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.l0) {
            x0();
            T();
        }
        super.onDraw(canvas);
        int iM = m();
        float fFloatValue = ((Float) this.a0.get(0)).floatValue();
        ArrayList arrayList = this.a0;
        float fFloatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (fFloatValue2 < this.W || (this.a0.size() > 1 && fFloatValue > this.V)) {
            u(canvas, this.i0, iM);
        }
        if (fFloatValue2 > this.V) {
            t(canvas, this.i0, iM);
        }
        W(canvas);
        V(canvas, iM);
        if ((this.U || isFocused()) && isEnabled()) {
            U(canvas, this.i0, iM);
        }
        t0();
        w(canvas, this.i0, iM);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            z(i);
            this.h.K(this.c0);
        } else {
            this.b0 = -1;
            this.h.d(this.c0);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.a0.size() == 1) {
            this.b0 = 0;
        }
        if (this.b0 == -1) {
            Boolean boolC0 = c0(i, keyEvent);
            return boolC0 != null ? boolC0.booleanValue() : super.onKeyDown(i, keyEvent);
        }
        this.k0 |= keyEvent.isLongPress();
        Float fJ = j(i);
        if (fJ != null) {
            if (n0(((Float) this.a0.get(this.b0)).floatValue() + fJ.floatValue())) {
                s0();
                postInvalidate();
            }
            return true;
        }
        if (i != 23) {
            if (i == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return Z(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return Z(-1);
                }
                return false;
            }
            if (i != 66) {
                return super.onKeyDown(i, keyEvent);
            }
        }
        this.b0 = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.k0 = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.F + ((this.G == 1 || l0()) ? ((h43) this.l.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.V = sliderState.a;
        this.W = sliderState.b;
        k0(sliderState.c);
        this.d0 = sliderState.d;
        if (sliderState.e) {
            requestFocus();
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.a = this.V;
        sliderState.b = this.W;
        sliderState.c = new ArrayList(this.a0);
        sliderState.d = this.d0;
        sliderState.e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        v0(i);
        s0();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b5  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int i;
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float f = (x - this.I) / this.i0;
        this.x0 = f;
        float fMax = Math.max(0.0f, f);
        this.x0 = fMax;
        this.x0 = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.S = x;
            if (!P(motionEvent)) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (f0()) {
                    requestFocus();
                    this.U = true;
                    q0();
                    s0();
                    if (I()) {
                        int i2 = this.J;
                        this.N = i2;
                        this.O = this.M;
                        int iRound = Math.round(i2 * 0.5f);
                        int i3 = this.J - iRound;
                        setThumbWidth(iRound);
                        setThumbTrackGapSize(this.M - (i3 / 2));
                    }
                    invalidate();
                    d0();
                }
            }
        } else if (actionMasked == 1) {
            this.U = false;
            motionEvent2 = this.T;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.T.getX() - motionEvent.getX()) <= this.r && Math.abs(this.T.getY() - motionEvent.getY()) <= this.r && f0()) {
                d0();
            }
            if (this.b0 != -1) {
                q0();
                s0();
                if (I() && (i = this.N) != -1 && this.O != -1) {
                    setThumbWidth(i);
                    setThumbTrackGapSize(this.O);
                }
                this.b0 = -1;
                e0();
            }
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.U) {
                if (P(motionEvent) && Math.abs(x - this.S) < this.r) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                d0();
            }
            if (f0()) {
                this.U = true;
                q0();
                s0();
                invalidate();
            }
        } else if (actionMasked == 3) {
            this.U = false;
            motionEvent2 = this.T;
            if (motionEvent2 != null) {
                d0();
            }
            if (this.b0 != -1) {
                q0();
                s0();
                if (I()) {
                    setThumbWidth(i);
                    setThumbTrackGapSize(this.O);
                }
                this.b0 = -1;
                e0();
            }
            invalidate();
        }
        setPressed(this.U);
        this.T = MotionEvent.obtain(motionEvent);
        return true;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        qe3 qe3VarJ;
        super.onVisibilityChanged(view, i);
        if (i == 0 || (qe3VarJ = nf3.j(this)) == null) {
            return;
        }
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            qe3VarJ.b((h43) it.next());
        }
    }

    void r0(int i, Rect rect) {
        int iB0 = this.I + ((int) (b0(getValues().get(i).floatValue()) * this.i0));
        int iM = m();
        int iMax = Math.max(this.J / 2, this.y / 2);
        int iMax2 = Math.max(this.K / 2, this.y / 2);
        rect.set(iB0 - iMax, iM - iMax2, iB0 + iMax, iM + iMax2);
    }

    protected void setActiveThumbIndex(int i) {
        this.b0 = i;
    }

    void setCustomThumbDrawable(int i) {
        setCustomThumbDrawable(getResources().getDrawable(i));
    }

    void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            drawableArr[i] = getResources().getDrawable(iArr[i]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.a0.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.c0 = i;
        this.h.K(i);
        postInvalidate();
    }

    public void setHaloRadius(int i) {
        if (i == this.L) {
            return;
        }
        this.L = i;
        Drawable background = getBackground();
        if (m0() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            qd0.m((RippleDrawable) background, this.L);
        }
    }

    public void setHaloRadiusResource(int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.m0)) {
            return;
        }
        this.m0 = colorStateList;
        Drawable background = getBackground();
        if (!m0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.d.setColor(E(colorStateList));
        this.d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i) {
        if (this.G != i) {
            this.G = i;
            requestLayout();
        }
    }

    public void setLabelFormatter(ca1 ca1Var) {
    }

    protected void setSeparationUnit(int i) {
        this.y0 = i;
        this.l0 = true;
        postInvalidate();
    }

    public void setStepSize(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f), Float.valueOf(this.V), Float.valueOf(this.W)));
        }
        if (this.d0 != f) {
            this.d0 = f;
            this.l0 = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f) {
        this.u0.a0(f);
    }

    public void setThumbElevationResource(int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    public void setThumbHeight(int i) {
        if (i == this.K) {
            return;
        }
        this.K = i;
        this.u0.setBounds(0, 0, this.J, i);
        Drawable drawable = this.v0;
        if (drawable != null) {
            h(drawable);
        }
        Iterator it = this.w0.iterator();
        while (it.hasNext()) {
            h((Drawable) it.next());
        }
        w0();
    }

    public void setThumbHeightResource(int i) {
        setThumbHeight(getResources().getDimensionPixelSize(i));
    }

    public void setThumbRadius(int i) {
        int i2 = i * 2;
        setThumbWidth(i2);
        setThumbHeight(i2);
    }

    public void setThumbRadiusResource(int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.u0.l0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i) {
        if (i != 0) {
            setThumbStrokeColor(v8.a(getContext(), i));
        }
    }

    public void setThumbStrokeWidth(float f) {
        this.u0.m0(f);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.u0.x())) {
            return;
        }
        this.u0.b0(colorStateList);
        invalidate();
    }

    public void setThumbTrackGapSize(int i) {
        if (this.M == i) {
            return;
        }
        this.M = i;
        invalidate();
    }

    public void setThumbWidth(int i) {
        if (i == this.J) {
            return;
        }
        this.J = i;
        this.u0.setShapeAppearanceModel(sn2.a().q(0, this.J / 2.0f).m());
        this.u0.setBounds(0, 0, this.J, this.K);
        Drawable drawable = this.v0;
        if (drawable != null) {
            h(drawable);
        }
        Iterator it = this.w0.iterator();
        while (it.hasNext()) {
            h((Drawable) it.next());
        }
        w0();
    }

    public void setThumbWidthResource(int i) {
        setThumbWidth(getResources().getDimensionPixelSize(i));
    }

    public void setTickActiveRadius(int i) {
        if (this.g0 != i) {
            this.g0 = i;
            this.f.setStrokeWidth(i * 2);
            w0();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.n0)) {
            return;
        }
        this.n0 = colorStateList;
        this.f.setColor(E(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(int i) {
        if (this.h0 != i) {
            this.h0 = i;
            this.e.setStrokeWidth(i * 2);
            w0();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.o0)) {
            return;
        }
        this.o0 = colorStateList;
        this.e.setColor(E(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.f0 != z) {
            this.f0 = z;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.p0)) {
            return;
        }
        this.p0 = colorStateList;
        this.b.setColor(E(colorStateList));
        this.g.setColor(E(this.p0));
        invalidate();
    }

    public void setTrackHeight(int i) {
        if (this.H != i) {
            this.H = i;
            L();
            w0();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.q0)) {
            return;
        }
        this.q0 = colorStateList;
        this.a.setColor(E(colorStateList));
        invalidate();
    }

    public void setTrackInsideCornerSize(int i) {
        if (this.Q == i) {
            return;
        }
        this.Q = i;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i) {
        if (this.P == i) {
            return;
        }
        this.P = i;
        this.g.setStrokeWidth(i);
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f) {
        this.V = f;
        this.l0 = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.W = f;
        this.l0 = true;
        postInvalidate();
    }

    void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        k0(arrayList);
    }

    private class d implements Runnable {
        int a;

        private d() {
            this.a = -1;
        }

        void a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.h.L(this.a, 4);
        }

        /* synthetic */ d(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    void setCustomThumbDrawable(Drawable drawable) {
        this.v0 = K(drawable);
        this.w0.clear();
        postInvalidate();
    }

    void setValues(List<Float> list) {
        k0(new ArrayList(list));
    }

    void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.v0 = null;
        this.w0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.w0.add(K(drawable));
        }
        postInvalidate();
    }
}
