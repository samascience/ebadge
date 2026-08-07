package com.luck.picture.lib.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import defpackage.cw;
import defpackage.kx;
import defpackage.wc0;

/* JADX INFO: loaded from: classes3.dex */
public class CaptureButton extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private float f;
    private Paint g;
    private float h;
    private int i;
    private int j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f296q;
    private int r;
    private int s;
    private int t;
    private RectF u;
    private c v;
    private cw w;
    private d x;
    private boolean y;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (CaptureButton.this.w != null) {
                CaptureButton.this.w.f();
            }
            CaptureButton.this.a = 5;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (wc0.a()) {
                return;
            }
            if (CaptureButton.this.a != 3) {
                CaptureButton.this.a = 1;
                return;
            }
            if (CaptureButton.this.w != null) {
                CaptureButton.this.w.d();
            }
            CaptureButton.this.a = 4;
            CaptureButton.this.x.start();
        }
    }

    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CaptureButton.this.a = 3;
            if (kx.a() != 1) {
                CaptureButton.this.a = 1;
                if (CaptureButton.this.w != null) {
                    CaptureButton.this.w.b();
                    return;
                }
            }
            CaptureButton captureButton = CaptureButton.this;
            captureButton.v(captureButton.n, CaptureButton.this.n + CaptureButton.this.i, CaptureButton.this.o, CaptureButton.this.o - CaptureButton.this.j);
        }

        /* synthetic */ c(CaptureButton captureButton, a aVar) {
            this();
        }
    }

    private class d extends CountDownTimer {
        d(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CaptureButton.this.r();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            CaptureButton.this.w(j);
        }
    }

    public CaptureButton(Context context) {
        super(context);
        this.c = -300503530;
        this.d = -287515428;
        this.e = -1;
        this.y = true;
    }

    private void n() {
        int i;
        removeCallbacks(this.v);
        int i2 = this.a;
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                this.x.cancel();
                r();
            }
        } else if (this.w == null || !((i = this.b) == 257 || i == 259)) {
            this.a = 1;
        } else {
            u(this.o);
        }
        this.a = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        this.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(ValueAnimator valueAnimator) {
        this.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(ValueAnimator valueAnimator) {
        this.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private void s() {
        this.a = 5;
        this.f296q = 0.0f;
        invalidate();
        float f = this.n;
        float f2 = this.m;
        v(f, f2, this.o, 0.75f * f2);
    }

    private void u(float f) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.75f * f, f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.o(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        valueAnimatorOfFloat.setDuration(50L);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2, float f3, float f4) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f3, f4);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: rv
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.p(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sv
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.q(valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new b());
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.setDuration(100L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j) {
        int i = this.r;
        this.t = (int) (((long) i) - j);
        this.f296q = 360.0f - ((j / i) * 360.0f);
        invalidate();
    }

    public int getButtonFeatures() {
        return this.b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setColor(this.d);
        canvas.drawCircle(this.k, this.l, this.n, this.g);
        this.g.setColor(this.e);
        canvas.drawCircle(this.k, this.l, this.o, this.g);
        if (this.a == 4) {
            this.g.setColor(this.c);
            this.g.setStyle(Paint.Style.STROKE);
            this.g.setStrokeWidth(this.h);
            canvas.drawArc(this.u, -90.0f, this.f296q, false, this.g);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.p;
        int i4 = this.i;
        setMeasuredDimension((i4 * 2) + i3, i3 + (i4 * 2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        cw cwVar;
        int i;
        if (this.y) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    n();
                } else if (action == 2 && (cwVar = this.w) != null && this.a == 4 && ((i = this.b) == 258 || i == 259)) {
                    cwVar.a(this.f - motionEvent.getY());
                }
            } else if (motionEvent.getPointerCount() <= 1 && this.a == 1) {
                this.f = motionEvent.getY();
                this.a = 2;
                int i2 = this.b;
                if (i2 == 258 || i2 == 259) {
                    postDelayed(this.v, 500L);
                }
            }
        }
        return true;
    }

    public void r() {
        cw cwVar = this.w;
        if (cwVar != null) {
            int i = this.t;
            if (i < this.s) {
                cwVar.c(i);
            } else {
                cwVar.e(i);
            }
        }
        s();
    }

    public void setButtonCaptureEnabled(boolean z) {
        this.y = z;
    }

    public void setButtonFeatures(int i) {
        this.b = i;
    }

    public void setCaptureListener(cw cwVar) {
        this.w = cwVar;
    }

    public void setDuration(int i) {
        this.r = i;
        this.x = new d(i, i / 360);
    }

    public void setMinDuration(int i) {
        this.s = i;
    }

    public void t() {
        this.a = 1;
    }

    public CaptureButton(Context context, int i) {
        super(context);
        this.c = -300503530;
        this.d = -287515428;
        this.e = -1;
        this.y = true;
        this.p = i;
        float f = i / 2.0f;
        this.m = f;
        this.n = f;
        this.o = f * 0.75f;
        this.h = i / 15;
        int i2 = i / 8;
        this.i = i2;
        this.j = i2;
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.f296q = 0.0f;
        this.v = new c(this, null);
        this.a = 1;
        this.b = 259;
        this.r = 10000;
        this.s = 1500;
        int i3 = this.p;
        int i4 = this.i;
        this.k = ((i4 * 2) + i3) / 2;
        this.l = (i3 + (i4 * 2)) / 2;
        float f2 = this.k;
        float f3 = this.m;
        int i5 = this.i;
        float f4 = this.h;
        float f5 = this.l;
        this.u = new RectF(f2 - ((i5 + f3) - (f4 / 2.0f)), f5 - ((i5 + f3) - (f4 / 2.0f)), f2 + ((i5 + f3) - (f4 / 2.0f)), f5 + ((f3 + i5) - (f4 / 2.0f)));
        int i6 = this.r;
        this.x = new d(i6, i6 / 360);
    }
}
