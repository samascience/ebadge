package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class ta1 extends nc1 {
    private final Paint h;
    private final RectF i;
    private final Animator.AnimatorListener j;
    private int[] k;
    private float[] l;
    private float m;
    private float n;
    private float o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f387q;
    private float r;
    private float s;
    private float t;
    private float u;
    private static final Interpolator v = new LinearInterpolator();
    private static final Interpolator w = new pk0();
    private static final Interpolator x = new AccelerateInterpolator();
    private static final Interpolator y = new DecelerateInterpolator();
    private static final float[] z = {1.0f, 0.875f, 0.625f};
    private static final int[] A = {Color.parseColor("#55ffffff"), Color.parseColor("#b1ffffff"), Color.parseColor("#ffffffff")};

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            ta1.this.y();
            ta1 ta1Var = ta1.this;
            ta1Var.f387q = ta1Var.p;
            ta1 ta1Var2 = ta1.this;
            ta1Var2.n = (ta1Var2.n + 1.0f) % 5.0f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ta1.this.n = 0.0f;
        }
    }

    public ta1(Context context) {
        super(context);
        this.h = new Paint();
        this.i = new RectF();
        a aVar = new a();
        this.j = aVar;
        t(context);
        x();
        b(aVar);
    }

    private void t(Context context) {
        this.t = va3.a(context, 2.5f);
        this.u = va3.a(context, 12.5f);
        this.l = new float[3];
        this.k = A;
    }

    private void u(float f, float f2) {
        float fMin = (Math.min(f, f2) / 2.0f) - this.u;
        float fCeil = (float) Math.ceil(this.t / 2.0f);
        if (fMin < fCeil) {
            fMin = fCeil;
        }
        this.m = fMin;
    }

    private void v() {
        this.r = 0.0f;
        this.s = 0.0f;
        this.p = 0.0f;
        this.f387q = 0.0f;
        float[] fArr = this.l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    private void x() {
        this.h.setAntiAlias(true);
        this.h.setStrokeWidth(this.t);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setStrokeCap(Paint.Cap.ROUND);
        u((int) this.f, (int) this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        float f = this.p;
        this.r = f;
        this.s = f;
    }

    @Override // defpackage.nc1
    protected void c(float f) {
        if (f <= 0.5f) {
            float interpolation = this.s + (w.getInterpolation(f / 0.5f) * 288.0f);
            this.f387q = interpolation;
            float f2 = this.p - interpolation;
            float fAbs = Math.abs(f2) / 288.0f;
            float interpolation2 = y.getInterpolation(fAbs);
            Interpolator interpolator = v;
            float interpolation3 = interpolation2 - interpolator.getInterpolation(fAbs);
            float interpolation4 = x.getInterpolation(fAbs) - interpolator.getInterpolation(fAbs);
            float[] fArr = this.l;
            float f3 = -f2;
            float[] fArr2 = z;
            fArr[0] = fArr2[0] * f3 * (interpolation3 + 1.0f);
            fArr[1] = fArr2[1] * f3 * 1.0f;
            fArr[2] = f3 * fArr2[2] * (interpolation4 + 1.0f);
        }
        if (f > 0.5f) {
            float interpolation5 = this.r + (w.getInterpolation((f - 0.5f) / 0.5f) * 288.0f);
            this.p = interpolation5;
            float f4 = interpolation5 - this.f387q;
            float fAbs2 = Math.abs(f4) / 288.0f;
            float[] fArr3 = z;
            float f5 = fArr3[1];
            if (fAbs2 > f5) {
                float[] fArr4 = this.l;
                fArr4[0] = -f4;
                fArr4[1] = f5 * 288.0f;
                fArr4[2] = fArr3[2] * 288.0f;
            } else {
                float f6 = fArr3[2];
                if (fAbs2 > f6) {
                    float[] fArr5 = this.l;
                    fArr5[0] = 0.0f;
                    fArr5[1] = -f4;
                    fArr5[2] = f6 * 288.0f;
                } else {
                    float[] fArr6 = this.l;
                    fArr6[0] = 0.0f;
                    fArr6[1] = 0.0f;
                    fArr6[2] = -f4;
                }
            }
        }
        this.o = (f * 216.0f) + ((this.n / 5.0f) * 1080.0f);
    }

    @Override // defpackage.nc1
    protected void d(Canvas canvas) {
        int iSave = canvas.save();
        this.i.set(this.b);
        RectF rectF = this.i;
        float f = this.m;
        rectF.inset(f, f);
        canvas.rotate(this.o, this.i.centerX(), this.i.centerY());
        for (int i = 0; i < 3; i++) {
            if (this.l[i] != 0.0f) {
                this.h.setColor(this.k[i]);
                canvas.drawArc(this.i, this.p, this.l[i], false, this.h);
            }
        }
        canvas.restoreToCount(iSave);
    }

    @Override // defpackage.nc1
    protected void g() {
        v();
    }

    @Override // defpackage.nc1
    protected void h(int i) {
        this.h.setAlpha(i);
    }

    @Override // defpackage.nc1
    protected void k(ColorFilter colorFilter) {
        this.h.setColorFilter(colorFilter);
    }

    public void w(int i, int i2, int i3) {
        this.k = new int[]{i, i2, i3};
    }
}
