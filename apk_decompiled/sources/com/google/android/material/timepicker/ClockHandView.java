package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.be3;
import defpackage.ch1;
import defpackage.el1;
import defpackage.nf3;
import defpackage.y6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class ClockHandView extends View {
    private final int a;
    private final TimeInterpolator b;
    private final ValueAnimator c;
    private boolean d;
    private float e;
    private float f;
    private boolean g;
    private final int h;
    private boolean i;
    private final List j;
    private final int k;
    private final float l;
    private final Paint m;
    private final RectF n;
    private final int o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f275q;
    private b r;
    private double s;
    private int t;
    private int u;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface b {
        void d(float f, boolean z);
    }

    public interface c {
        void a(float f, boolean z);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    private void c(float f, float f2) {
        this.u = ch1.a((float) (getWidth() / 2), (float) (getHeight() / 2), f, f2) > ((float) i(2)) + nf3.g(getContext(), 12) ? 1 : 2;
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int i = i(this.u);
        float f = width;
        float f2 = i;
        float fCos = (((float) Math.cos(this.s)) * f2) + f;
        float f3 = height;
        float fSin = (f2 * ((float) Math.sin(this.s))) + f3;
        this.m.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.k, this.m);
        double dSin = Math.sin(this.s);
        double dCos = Math.cos(this.s);
        double d = i - this.k;
        this.m.setStrokeWidth(this.o);
        canvas.drawLine(f, f3, width + ((int) (dCos * d)), height + ((int) (d * dSin)), this.m);
        canvas.drawCircle(f, f3, this.l, this.m);
    }

    private int g(float f, float f2) {
        int degrees = (int) Math.toDegrees(Math.atan2(f2 - (getHeight() / 2), f - (getWidth() / 2)));
        int i = degrees + 90;
        return i < 0 ? degrees + 450 : i;
    }

    private int i(int i) {
        return i == 2 ? Math.round(this.t * 0.66f) : this.t;
    }

    private Pair k(float f) {
        float fH = h();
        if (Math.abs(fH - f) > 180.0f) {
            if (fH > 180.0f && f < 180.0f) {
                f += 360.0f;
            }
            if (fH < 180.0f && f > 180.0f) {
                fH += 360.0f;
            }
        }
        return new Pair(Float.valueOf(fH), Float.valueOf(f));
    }

    private boolean l(float f, float f2, boolean z, boolean z2, boolean z3) {
        float fG = g(f, f2);
        boolean z4 = false;
        boolean z5 = h() != fG;
        if (z2 && z5) {
            return true;
        }
        if (!z5 && !z) {
            return false;
        }
        if (z3 && this.d) {
            z4 = true;
        }
        r(fG, z4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        s(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void s(float f, boolean z) {
        float f2 = f % 360.0f;
        this.p = f2;
        this.s = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fI = i(this.u);
        float fCos = width + (((float) Math.cos(this.s)) * fI);
        float fSin = height + (fI * ((float) Math.sin(this.s)));
        RectF rectF = this.n;
        int i = this.k;
        rectF.set(fCos - i, fSin - i, fCos + i, fSin + i);
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(f2, z);
        }
        invalidate();
    }

    public void b(c cVar) {
        this.j.add(cVar);
    }

    int e() {
        return this.u;
    }

    public RectF f() {
        return this.n;
    }

    public float h() {
        return this.p;
    }

    public int j() {
        return this.k;
    }

    public void n(boolean z) {
        this.d = z;
    }

    public void o(int i) {
        this.t = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c.isRunning()) {
            return;
        }
        q(h());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        b bVar;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.e = x;
            this.f = y;
            this.g = true;
            this.f275q = false;
            z = false;
            z2 = false;
            z3 = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i = (int) (x - this.e);
            int i2 = (int) (y - this.f);
            this.g = (i * i) + (i2 * i2) > this.h;
            boolean z4 = this.f275q;
            z = actionMasked == 1;
            if (this.i) {
                c(x, y);
            }
            z3 = false;
            z2 = z4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        boolean zL = l(x, y, z2, z3, z) | this.f275q;
        this.f275q = zL;
        if (zL && z && (bVar = this.r) != null) {
            bVar.d(g(x, y), this.g);
        }
        return true;
    }

    void p(int i) {
        this.u = i;
        invalidate();
    }

    public void q(float f) {
        r(f, false);
    }

    public void r(float f, boolean z) {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            s(f, false);
            return;
        }
        Pair pairK = k(f);
        this.c.setFloatValues(((Float) pairK.first).floatValue(), ((Float) pairK.second).floatValue());
        this.c.setDuration(this.a);
        this.c.setInterpolator(this.b);
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.m(valueAnimator2);
            }
        });
        this.c.addListener(new a());
        this.c.start();
    }

    void t(boolean z) {
        if (this.i && !z) {
            this.u = 1;
        }
        this.i = z;
        invalidate();
    }

    public void u(b bVar) {
        this.r = bVar;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new ValueAnimator();
        this.j = new ArrayList();
        Paint paint = new Paint();
        this.m = paint;
        this.n = new RectF();
        this.u = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.a = el1.f(context, R$attr.motionDurationLong2, 200);
        this.b = el1.g(context, R$attr.motionEasingEmphasizedInterpolator, y6.b);
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.o = resources.getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.l = resources.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        q(0.0f);
        this.h = ViewConfiguration.get(context).getScaledTouchSlop();
        be3.z0(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
