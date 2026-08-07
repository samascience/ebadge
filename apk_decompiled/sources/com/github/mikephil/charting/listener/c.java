package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import defpackage.if1;
import defpackage.ta3;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c extends ChartTouchListener {
    private if1 f;
    private float g;
    private ArrayList h;
    private long i;
    private float j;

    private class a {
        public long a;
        public float b;

        public a(long j, float f) {
            this.a = j;
            this.b = f;
        }
    }

    public c(PieRadarChartBase pieRadarChartBase) {
        super(pieRadarChartBase);
        this.f = if1.b(0.0f, 0.0f);
        this.g = 0.0f;
        this.h = new ArrayList();
        this.i = 0L;
        this.j = 0.0f;
    }

    private float f() {
        if (this.h.isEmpty()) {
            return 0.0f;
        }
        a aVar = (a) this.h.get(0);
        ArrayList arrayList = this.h;
        a aVar2 = (a) arrayList.get(arrayList.size() - 1);
        a aVar3 = aVar;
        for (int size = this.h.size() - 1; size >= 0; size--) {
            aVar3 = (a) this.h.get(size);
            if (aVar3.b != aVar2.b) {
                break;
            }
        }
        float f = (aVar2.a - aVar.a) / 1000.0f;
        if (f == 0.0f) {
            f = 0.1f;
        }
        float f2 = aVar2.b;
        float f3 = aVar3.b;
        boolean z = f2 >= f3;
        if (Math.abs(f2 - f3) > 270.0d) {
            z = !z;
        }
        float f4 = aVar2.b;
        float f5 = aVar.b;
        if (f4 - f5 > 180.0d) {
            aVar.b = (float) (((double) f5) + 360.0d);
        } else if (f5 - f4 > 180.0d) {
            aVar2.b = (float) (((double) f4) + 360.0d);
        }
        float fAbs = Math.abs((aVar2.b - aVar.b) / f);
        return !z ? -fAbs : fAbs;
    }

    private void h() {
        this.h.clear();
    }

    private void i(float f, float f2) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.h.add(new a(jCurrentAnimationTimeMillis, ((PieRadarChartBase) this.e).j(f, f2)));
        for (int size = this.h.size(); size - 2 > 0 && jCurrentAnimationTimeMillis - ((a) this.h.get(0)).a > 1000; size--) {
            this.h.remove(0);
        }
    }

    public void g() {
        if (this.j == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.j *= ((PieRadarChartBase) this.e).getDragDecelerationFrictionCoef();
        float f = (jCurrentAnimationTimeMillis - this.i) / 1000.0f;
        Chart chart = this.e;
        ((PieRadarChartBase) chart).setRotationAngle(((PieRadarChartBase) chart).getRotationAngle() + (this.j * f));
        this.i = jCurrentAnimationTimeMillis;
        if (Math.abs(this.j) >= 0.001d) {
            ta3.i(this.e);
        } else {
            k();
        }
    }

    public void j(float f, float f2) {
        this.g = ((PieRadarChartBase) this.e).j(f, f2) - ((PieRadarChartBase) this.e).getRawRotationAngle();
    }

    public void k() {
        this.j = 0.0f;
    }

    public void l(float f, float f2) {
        Chart chart = this.e;
        ((PieRadarChartBase) chart).setRotationAngle(((PieRadarChartBase) chart).j(f, f2) - this.g);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.a = ChartTouchListener.ChartGesture.LONG_PRESS;
        ((PieRadarChartBase) this.e).getOnChartGestureListener();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        ((PieRadarChartBase) this.e).getOnChartGestureListener();
        if (!((PieRadarChartBase) this.e).g()) {
            return false;
        }
        c(((PieRadarChartBase) this.e).c(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0061  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.d.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.e).k()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                e(motionEvent);
                k();
                h();
                if (((PieRadarChartBase) this.e).f()) {
                    i(x, y);
                }
                j(x, y);
                if1 if1Var = this.f;
                if1Var.c = x;
                if1Var.d = y;
            } else if (action == 1) {
                if (((PieRadarChartBase) this.e).f()) {
                    k();
                    i(x, y);
                    float f = f();
                    this.j = f;
                    if (f != 0.0f) {
                        this.i = AnimationUtils.currentAnimationTimeMillis();
                        ta3.i(this.e);
                    }
                }
                ((PieRadarChartBase) this.e).b();
                this.b = 0;
                b(motionEvent);
            } else if (action == 2) {
                if (((PieRadarChartBase) this.e).f()) {
                    i(x, y);
                }
                if (this.b == 0) {
                    if1 if1Var2 = this.f;
                    if (ChartTouchListener.a(x, if1Var2.c, y, if1Var2.d) > ta3.c(8.0f)) {
                        this.a = ChartTouchListener.ChartGesture.ROTATE;
                        this.b = 6;
                        ((PieRadarChartBase) this.e).a();
                    } else if (this.b == 6) {
                        l(x, y);
                        ((PieRadarChartBase) this.e).invalidate();
                    }
                } else if (this.b == 6) {
                    l(x, y);
                    ((PieRadarChartBase) this.e).invalidate();
                }
                b(motionEvent);
            }
        }
        return true;
    }
}
