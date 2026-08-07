package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import defpackage.if1;
import defpackage.ta3;
import defpackage.ue3;

/* JADX INFO: loaded from: classes.dex */
public class a extends ChartTouchListener {
    private Matrix f;
    private Matrix g;
    private if1 h;
    private if1 i;
    private float j;
    private float k;
    private float l;
    private VelocityTracker m;
    private long n;
    private if1 o;
    private if1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f236q;
    private float r;

    public a(BarLineChartBase barLineChartBase, Matrix matrix, float f) {
        super(barLineChartBase);
        this.f = new Matrix();
        this.g = new Matrix();
        this.h = if1.b(0.0f, 0.0f);
        this.i = if1.b(0.0f, 0.0f);
        this.j = 1.0f;
        this.k = 1.0f;
        this.l = 1.0f;
        this.n = 0L;
        this.o = if1.b(0.0f, 0.0f);
        this.p = if1.b(0.0f, 0.0f);
        this.f = matrix;
        this.f236q = ta3.c(f);
        this.r = ta3.c(3.5f);
    }

    private static float h(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float i(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    private boolean j() {
        return ((BarLineChartBase) this.e).o();
    }

    private static void k(if1 if1Var, MotionEvent motionEvent) {
        float x = motionEvent.getX(0) + motionEvent.getX(1);
        float y = motionEvent.getY(0) + motionEvent.getY(1);
        if1Var.c = x / 2.0f;
        if1Var.d = y / 2.0f;
    }

    private void l(MotionEvent motionEvent, float f, float f2) {
        this.a = ChartTouchListener.ChartGesture.DRAG;
        this.f.set(this.g);
        ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (j()) {
            if (this.e instanceof HorizontalBarChart) {
                f = -f;
            } else {
                f2 = -f2;
            }
        }
        this.f.postTranslate(f, f2);
    }

    private void m(MotionEvent motionEvent) {
        ((BarLineChartBase) this.e).c(motionEvent.getX(), motionEvent.getY());
    }

    private void n(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            ((BarLineChartBase) this.e).getOnChartGestureListener();
            float fP = p(motionEvent);
            if (fP > this.r) {
                if1 if1Var = this.i;
                if1 if1VarG = g(if1Var.c, if1Var.d);
                ue3 viewPortHandler = ((BarLineChartBase) this.e).getViewPortHandler();
                int i = this.b;
                if (i == 4) {
                    this.a = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f = fP / this.l;
                    boolean z = f < 1.0f;
                    boolean zC = z ? viewPortHandler.c() : viewPortHandler.a();
                    boolean zD = z ? viewPortHandler.d() : viewPortHandler.b();
                    float f2 = ((BarLineChartBase) this.e).w() ? f : 1.0f;
                    float f3 = ((BarLineChartBase) this.e).x() ? f : 1.0f;
                    if (zD || zC) {
                        this.f.set(this.g);
                        this.f.postScale(f2, f3, if1VarG.c, if1VarG.d);
                    }
                } else if (i == 2 && ((BarLineChartBase) this.e).w()) {
                    this.a = ChartTouchListener.ChartGesture.X_ZOOM;
                    float fH = h(motionEvent) / this.j;
                    if (fH < 1.0f ? viewPortHandler.c() : viewPortHandler.a()) {
                        this.f.set(this.g);
                        this.f.postScale(fH, 1.0f, if1VarG.c, if1VarG.d);
                    }
                } else if (this.b == 3 && ((BarLineChartBase) this.e).x()) {
                    this.a = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float fI = i(motionEvent) / this.k;
                    if (fI < 1.0f ? viewPortHandler.d() : viewPortHandler.b()) {
                        this.f.set(this.g);
                        this.f.postScale(1.0f, fI, if1VarG.c, if1VarG.d);
                    }
                }
                if1.d(if1VarG);
            }
        }
    }

    private void o(MotionEvent motionEvent) {
        this.g.set(this.f);
        this.h.c = motionEvent.getX();
        this.h.d = motionEvent.getY();
        ((BarLineChartBase) this.e).l(motionEvent.getX(), motionEvent.getY());
    }

    private static float p(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void f() {
        if1 if1Var = this.p;
        if (if1Var.c == 0.0f && if1Var.d == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.p.c *= ((BarLineChartBase) this.e).getDragDecelerationFrictionCoef();
        this.p.d *= ((BarLineChartBase) this.e).getDragDecelerationFrictionCoef();
        float f = (jCurrentAnimationTimeMillis - this.n) / 1000.0f;
        if1 if1Var2 = this.p;
        float f2 = if1Var2.c * f;
        float f3 = if1Var2.d * f;
        if1 if1Var3 = this.o;
        float f4 = if1Var3.c + f2;
        if1Var3.c = f4;
        float f5 = if1Var3.d + f3;
        if1Var3.d = f5;
        MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentAnimationTimeMillis, jCurrentAnimationTimeMillis, 2, f4, f5, 0);
        l(motionEventObtain, ((BarLineChartBase) this.e).r() ? this.o.c - this.h.c : 0.0f, ((BarLineChartBase) this.e).s() ? this.o.d - this.h.d : 0.0f);
        motionEventObtain.recycle();
        this.f = ((BarLineChartBase) this.e).getViewPortHandler().B(this.f, this.e, false);
        this.n = jCurrentAnimationTimeMillis;
        if (Math.abs(this.p.c) >= 0.01d || Math.abs(this.p.d) >= 0.01d) {
            ta3.i(this.e);
            return;
        }
        ((BarLineChartBase) this.e).k();
        ((BarLineChartBase) this.e).postInvalidate();
        q();
    }

    public if1 g(float f, float f2) {
        ue3 viewPortHandler = ((BarLineChartBase) this.e).getViewPortHandler();
        return if1.b(f - viewPortHandler.y(), j() ? -(f2 - viewPortHandler.A()) : -((((BarLineChartBase) this.e).getMeasuredHeight() - f2) - viewPortHandler.x()));
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.a = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (!((BarLineChartBase) this.e).p()) {
            return super.onDoubleTap(motionEvent);
        }
        ((BarLineChartBase) this.e).getData();
        throw null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a = ChartTouchListener.ChartGesture.FLING;
        ((BarLineChartBase) this.e).getOnChartGestureListener();
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.a = ChartTouchListener.ChartGesture.LONG_PRESS;
        ((BarLineChartBase) this.e).getOnChartGestureListener();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (!((BarLineChartBase) this.e).g()) {
            return false;
        }
        c(((BarLineChartBase) this.e).c(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.m) != null) {
            velocityTracker.recycle();
            this.m = null;
        }
        if (this.b == 0) {
            this.d.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.e).q() && !((BarLineChartBase) this.e).w() && !((BarLineChartBase) this.e).x()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            e(motionEvent);
            q();
            o(motionEvent);
        } else if (action == 1) {
            VelocityTracker velocityTracker2 = this.m;
            int pointerId = motionEvent.getPointerId(0);
            velocityTracker2.computeCurrentVelocity(1000, ta3.e());
            float yVelocity = velocityTracker2.getYVelocity(pointerId);
            float xVelocity = velocityTracker2.getXVelocity(pointerId);
            if ((Math.abs(xVelocity) > ta3.f() || Math.abs(yVelocity) > ta3.f()) && this.b == 1 && ((BarLineChartBase) this.e).f()) {
                q();
                this.n = AnimationUtils.currentAnimationTimeMillis();
                this.o.c = motionEvent.getX();
                this.o.d = motionEvent.getY();
                if1 if1Var = this.p;
                if1Var.c = xVelocity;
                if1Var.d = yVelocity;
                ta3.i(this.e);
            }
            int i = this.b;
            if (i == 2 || i == 3 || i == 4 || i == 5) {
                ((BarLineChartBase) this.e).k();
                ((BarLineChartBase) this.e).postInvalidate();
            }
            this.b = 0;
            ((BarLineChartBase) this.e).b();
            VelocityTracker velocityTracker3 = this.m;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.m = null;
            }
            b(motionEvent);
        } else if (action == 2) {
            int i2 = this.b;
            if (i2 == 1) {
                ((BarLineChartBase) this.e).a();
                l(motionEvent, ((BarLineChartBase) this.e).r() ? motionEvent.getX() - this.h.c : 0.0f, ((BarLineChartBase) this.e).s() ? motionEvent.getY() - this.h.d : 0.0f);
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                ((BarLineChartBase) this.e).a();
                if (((BarLineChartBase) this.e).w() || ((BarLineChartBase) this.e).x()) {
                    n(motionEvent);
                }
            } else if (i2 == 0 && Math.abs(ChartTouchListener.a(motionEvent.getX(), this.h.c, motionEvent.getY(), this.h.d)) > this.f236q && ((BarLineChartBase) this.e).q()) {
                if (!((BarLineChartBase) this.e).t() || !((BarLineChartBase) this.e).n()) {
                    float fAbs = Math.abs(motionEvent.getX() - this.h.c);
                    float fAbs2 = Math.abs(motionEvent.getY() - this.h.d);
                    if ((((BarLineChartBase) this.e).r() || fAbs2 >= fAbs) && (((BarLineChartBase) this.e).s() || fAbs2 <= fAbs)) {
                        this.a = ChartTouchListener.ChartGesture.DRAG;
                        this.b = 1;
                    }
                } else if (((BarLineChartBase) this.e).u()) {
                    this.a = ChartTouchListener.ChartGesture.DRAG;
                    if (((BarLineChartBase) this.e).u()) {
                        m(motionEvent);
                    }
                }
            }
        } else if (action == 3) {
            this.b = 0;
            b(motionEvent);
        } else if (action != 5) {
            if (action == 6) {
                ta3.j(motionEvent, this.m);
                this.b = 5;
            }
        } else if (motionEvent.getPointerCount() >= 2) {
            ((BarLineChartBase) this.e).a();
            o(motionEvent);
            this.j = h(motionEvent);
            this.k = i(motionEvent);
            float fP = p(motionEvent);
            this.l = fP;
            if (fP > 10.0f) {
                if (((BarLineChartBase) this.e).v()) {
                    this.b = 4;
                } else if (((BarLineChartBase) this.e).w() != ((BarLineChartBase) this.e).x()) {
                    this.b = ((BarLineChartBase) this.e).w() ? 2 : 3;
                } else {
                    this.b = this.j > this.k ? 2 : 3;
                }
            }
            k(this.i, motionEvent);
        }
        this.f = ((BarLineChartBase) this.e).getViewPortHandler().B(this.f, this.e, true);
        return true;
    }

    public void q() {
        if1 if1Var = this.p;
        if1Var.c = 0.0f;
        if1Var.d = 0.0f;
    }
}
