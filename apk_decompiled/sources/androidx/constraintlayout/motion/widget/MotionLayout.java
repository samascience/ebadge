package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R$styleable;
import com.tencent.connect.common.Constants;
import defpackage.bl1;
import defpackage.d70;
import defpackage.e43;
import defpackage.pu2;
import defpackage.r90;
import defpackage.rw0;
import defpackage.st2;
import defpackage.sw0;
import defpackage.vn1;
import defpackage.x81;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements vn1 {
    public static boolean h1;
    private float A0;
    private int B0;
    private float C0;
    boolean D0;
    protected boolean E0;
    Interpolator F;
    int F0;
    float G;
    int G0;
    private int H;
    int H0;
    int I;
    int I0;
    private int J;
    int J0;
    private int K;
    int K0;
    private int L;
    float L0;
    private boolean M;
    private x81 M0;
    HashMap N;
    private boolean N0;
    private long O;
    private i O0;
    private float P;
    private Runnable P0;
    float Q;
    private int[] Q0;
    float R;
    int R0;
    private long S;
    private boolean S0;
    float T;
    int T0;
    private boolean U;
    HashMap U0;
    boolean V;
    private int V0;
    boolean W;
    private int W0;
    private int X0;
    Rect Y0;
    private boolean Z0;
    private j a0;
    TransitionState a1;
    private float b0;
    f b1;
    private float c0;
    private boolean c1;
    int d0;
    private RectF d1;
    e e0;
    private View e1;
    private boolean f0;
    private Matrix f1;
    private pu2 g0;
    ArrayList g1;
    private d h0;
    private r90 i0;
    boolean j0;
    int k0;
    int l0;
    int m0;
    int n0;
    boolean o0;
    float p0;
    float q0;
    long r0;
    float s0;
    private boolean t0;
    private ArrayList u0;
    private ArrayList v0;
    private ArrayList w0;
    private CopyOnWriteArrayList x0;
    androidx.constraintlayout.motion.widget.i y;
    private int y0;
    Interpolator z;
    private long z0;

    enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    class a implements Runnable {
        final /* synthetic */ View a;

        a(MotionLayout motionLayout, View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setNestedScrollingEnabled(true);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.O0.a();
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TransitionState.values().length];
            a = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class d extends bl1 {
        float a = 0.0f;
        float b = 0.0f;
        float c;

        d() {
        }

        @Override // defpackage.bl1
        public float a() {
            return MotionLayout.this.G;
        }

        public void b(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2;
            float f3;
            float f4 = this.a;
            if (f4 > 0.0f) {
                float f5 = this.c;
                if (f4 / f5 < f) {
                    f = f4 / f5;
                }
                MotionLayout.this.G = f4 - (f5 * f);
                f2 = (f4 * f) - (((f5 * f) * f) / 2.0f);
                f3 = this.b;
            } else {
                float f6 = this.c;
                if ((-f4) / f6 < f) {
                    f = (-f4) / f6;
                }
                MotionLayout.this.G = (f6 * f) + f4;
                f2 = (f4 * f) + (((f6 * f) * f) / 2.0f);
                f3 = this.b;
            }
            return f2 + f3;
        }
    }

    private class e {
        float[] a;
        int[] b;
        float[] c;
        Path d;
        Paint e;
        Paint f;
        Paint g;
        Paint h;
        Paint i;
        private float[] j;
        DashPathEffect p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f171q;
        int t;
        final int k = -21965;
        final int l = -2067046;
        final int m = -13391360;
        final int n = 1996488704;
        final int o = 10;
        Rect r = new Rect();
        boolean s = false;

        public e() {
            this.t = 1;
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            Paint paint2 = this.e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f = paint3;
            paint3.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(style);
            Paint paint4 = new Paint();
            this.g = paint4;
            paint4.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(style);
            Paint paint5 = new Paint();
            this.h = paint5;
            paint5.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.j = new float[8];
            Paint paint6 = new Paint();
            this.i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.p = dashPathEffect;
            this.g.setPathEffect(dashPathEffect);
            this.c = new float[100];
            this.b = new int[50];
            if (this.s) {
                this.e.setStrokeWidth(8.0f);
                this.i.setStrokeWidth(8.0f);
                this.f.setStrokeWidth(8.0f);
                this.t = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.a, this.e);
        }

        private void d(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.f171q; i++) {
                int i2 = this.b[i];
                if (i2 == 1) {
                    z = true;
                }
                if (i2 == 0) {
                    z2 = true;
                }
            }
            if (z) {
                g(canvas);
            }
            if (z2) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.a;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.g);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.g);
        }

        private void f(Canvas canvas, float f, float f2) {
            float[] fArr = this.a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float fMin = Math.min(f3, f5);
            float fMax = Math.max(f4, f6);
            float fMin2 = f - Math.min(f3, f5);
            float fMax2 = Math.max(f4, f6) - f2;
            String str = Constants.STR_EMPTY + (((int) (((double) ((fMin2 * 100.0f) / Math.abs(f5 - f3))) + 0.5d)) / 100.0f);
            l(str, this.h);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.r.width() / 2)) + fMin, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.g);
            String str2 = Constants.STR_EMPTY + (((int) (((double) ((fMax2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d)) / 100.0f);
            l(str2, this.h);
            canvas.drawText(str2, f + 5.0f, fMax - ((fMax2 / 2.0f) - (this.r.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.g);
        }

        private void h(Canvas canvas, float f, float f2) {
            float[] fArr = this.a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (fHypot * fHypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float fHypot2 = (float) Math.hypot(f10 - f, f11 - f2);
            String str = Constants.STR_EMPTY + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            l(str, this.h);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.r.width() / 2), -20.0f, this.h);
            canvas.drawLine(f, f2, f10, f11, this.g);
        }

        private void i(Canvas canvas, float f, float f2, int i, int i2) {
            String str = Constants.STR_EMPTY + (((int) (((double) (((f - (i / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i))) + 0.5d)) / 100.0f);
            l(str, this.h);
            canvas.drawText(str, ((f / 2.0f) - (this.r.width() / 2)) + 0.0f, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.g);
            String str2 = Constants.STR_EMPTY + (((int) (((double) (((f2 - (i2 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i2))) + 0.5d)) / 100.0f);
            l(str2, this.h);
            canvas.drawText(str2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.r.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.g);
        }

        private void j(Canvas canvas, androidx.constraintlayout.motion.widget.g gVar) {
            this.d.reset();
            for (int i = 0; i <= 50; i++) {
                gVar.e(i / 50, this.j, 0);
                Path path = this.d;
                float[] fArr = this.j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.d;
                float[] fArr2 = this.j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.d;
                float[] fArr3 = this.j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.d;
                float[] fArr4 = this.j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.d.close();
            }
            this.e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.d, this.e);
            canvas.translate(-2.0f, -2.0f);
            this.e.setColor(Opcodes.V_PREVIEW);
            canvas.drawPath(this.d, this.e);
        }

        private void k(Canvas canvas, int i, int i2, androidx.constraintlayout.motion.widget.g gVar) {
            int width;
            int height;
            View view = gVar.b;
            if (view != null) {
                width = view.getWidth();
                height = gVar.b.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i3 = 1; i3 < i2 - 1; i3++) {
                if (i != 4 || this.b[i3 - 1] != 0) {
                    float[] fArr = this.c;
                    int i4 = i3 * 2;
                    float f = fArr[i4];
                    float f2 = fArr[i4 + 1];
                    this.d.reset();
                    this.d.moveTo(f, f2 + 10.0f);
                    this.d.lineTo(f + 10.0f, f2);
                    this.d.lineTo(f, f2 - 10.0f);
                    this.d.lineTo(f - 10.0f, f2);
                    this.d.close();
                    int i5 = i3 - 1;
                    gVar.q(i5);
                    if (i == 4) {
                        int i6 = this.b[i5];
                        if (i6 == 1) {
                            h(canvas, f - 0.0f, f2 - 0.0f);
                        } else if (i6 == 0) {
                            f(canvas, f - 0.0f, f2 - 0.0f);
                        } else {
                            if (i6 == 2) {
                                i(canvas, f - 0.0f, f2 - 0.0f, width, height);
                            }
                            canvas.drawPath(this.d, this.i);
                        }
                        canvas.drawPath(this.d, this.i);
                    } else {
                        f2 = f2;
                        f = f;
                    }
                    if (i == 2) {
                        h(canvas, f - 0.0f, f2 - 0.0f);
                    }
                    if (i == 3) {
                        f(canvas, f - 0.0f, f2 - 0.0f);
                    }
                    if (i == 6) {
                        i(canvas, f - 0.0f, f2 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.d, this.i);
                }
            }
            float[] fArr2 = this.a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f);
                float[] fArr3 = this.a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f);
            }
        }

        public void a(Canvas canvas, HashMap map, int i, int i2) {
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i2 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.J) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.e);
            }
            for (androidx.constraintlayout.motion.widget.g gVar : map.values()) {
                int iM = gVar.m();
                if (i2 > 0 && iM == 0) {
                    iM = 1;
                }
                if (iM != 0) {
                    this.f171q = gVar.c(this.c, this.b);
                    if (iM >= 1) {
                        int i3 = i / 16;
                        float[] fArr = this.a;
                        if (fArr == null || fArr.length != i3 * 2) {
                            this.a = new float[i3 * 2];
                            this.d = new Path();
                        }
                        int i4 = this.t;
                        canvas.translate(i4, i4);
                        this.e.setColor(1996488704);
                        this.i.setColor(1996488704);
                        this.f.setColor(1996488704);
                        this.g.setColor(1996488704);
                        gVar.d(this.a, i3);
                        b(canvas, iM, this.f171q, gVar);
                        this.e.setColor(-21965);
                        this.f.setColor(-2067046);
                        this.i.setColor(-2067046);
                        this.g.setColor(-13391360);
                        int i5 = this.t;
                        canvas.translate(-i5, -i5);
                        b(canvas, iM, this.f171q, gVar);
                        if (iM == 5) {
                            j(canvas, gVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int i, int i2, androidx.constraintlayout.motion.widget.g gVar) {
            if (i == 4) {
                d(canvas);
            }
            if (i == 2) {
                g(canvas);
            }
            if (i == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i, i2, gVar);
        }

        void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.r);
        }
    }

    class f {
        androidx.constraintlayout.core.widgets.d a = new androidx.constraintlayout.core.widgets.d();
        androidx.constraintlayout.core.widgets.d b = new androidx.constraintlayout.core.widgets.d();
        androidx.constraintlayout.widget.b c = null;
        androidx.constraintlayout.widget.b d = null;
        int e;
        int f;

        f() {
        }

        private void b(int i, int i2) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.I == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar = this.b;
                androidx.constraintlayout.widget.b bVar = this.d;
                motionLayout2.v(dVar, optimizationLevel, (bVar == null || bVar.d == 0) ? i : i2, (bVar == null || bVar.d == 0) ? i2 : i);
                androidx.constraintlayout.widget.b bVar2 = this.c;
                if (bVar2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    androidx.constraintlayout.core.widgets.d dVar2 = this.a;
                    int i3 = bVar2.d;
                    int i4 = i3 == 0 ? i : i2;
                    if (i3 == 0) {
                        i = i2;
                    }
                    motionLayout3.v(dVar2, optimizationLevel, i4, i);
                    return;
                }
                return;
            }
            androidx.constraintlayout.widget.b bVar3 = this.c;
            if (bVar3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar3 = this.a;
                int i5 = bVar3.d;
                motionLayout4.v(dVar3, optimizationLevel, i5 == 0 ? i : i2, i5 == 0 ? i2 : i);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            androidx.constraintlayout.core.widgets.d dVar4 = this.b;
            androidx.constraintlayout.widget.b bVar4 = this.d;
            int i6 = (bVar4 == null || bVar4.d == 0) ? i : i2;
            if (bVar4 == null || bVar4.d == 0) {
                i = i2;
            }
            motionLayout5.v(dVar4, optimizationLevel, i6, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void j(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.widget.b bVar) {
            SparseArray sparseArray = new SparseArray();
            Constraints.a aVar = new Constraints.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, dVar);
            sparseArray.put(MotionLayout.this.getId(), dVar);
            if (bVar != null && bVar.d != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.v(this.b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            for (ConstraintWidget constraintWidget : dVar.v1()) {
                constraintWidget.D0(true);
                sparseArray.put(((View) constraintWidget.u()).getId(), constraintWidget);
            }
            for (ConstraintWidget constraintWidget2 : dVar.v1()) {
                View view = (View) constraintWidget2.u();
                bVar.l(view.getId(), aVar);
                constraintWidget2.o1(bVar.B(view.getId()));
                constraintWidget2.P0(bVar.w(view.getId()));
                if (view instanceof ConstraintHelper) {
                    bVar.j((ConstraintHelper) view, constraintWidget2, aVar, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).v();
                    }
                }
                aVar.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.d(false, view, constraintWidget2, aVar, sparseArray);
                if (bVar.A(view.getId()) == 1) {
                    constraintWidget2.n1(view.getVisibility());
                } else {
                    constraintWidget2.n1(bVar.z(view.getId()));
                }
            }
            for (ConstraintWidget constraintWidget3 : dVar.v1()) {
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) constraintWidget3.u();
                    rw0 rw0Var = (rw0) constraintWidget3;
                    constraintHelper.t(dVar, rw0Var, sparseArray);
                    ((androidx.constraintlayout.core.widgets.i) rw0Var).y1();
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:26:0x00f1  */
        /* JADX WARN: Code duplicated, block: B:27:0x0109  */
        /* JADX WARN: Code duplicated, block: B:29:0x010f  */
        /* JADX WARN: Code duplicated, block: B:42:0x013d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:44:0x013d A[SYNTHETIC] */
        /* JADX WARN: Instruction removed from duplicated block: B:29:0x010f, please report this as an issue */
        public void a() {
            ConstraintWidget constraintWidgetD;
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.N.clear();
            SparseArray sparseArray = new SparseArray();
            int[] iArr = new int[childCount];
            for (int i = 0; i < childCount; i++) {
                View childAt = MotionLayout.this.getChildAt(i);
                androidx.constraintlayout.motion.widget.g gVar = new androidx.constraintlayout.motion.widget.g(childAt);
                int id = childAt.getId();
                iArr[i] = id;
                sparseArray.put(id, gVar);
                MotionLayout.this.N.put(childAt, gVar);
            }
            int i2 = 0;
            while (i2 < childCount) {
                View childAt2 = MotionLayout.this.getChildAt(i2);
                androidx.constraintlayout.motion.widget.g gVar2 = (androidx.constraintlayout.motion.widget.g) MotionLayout.this.N.get(childAt2);
                if (gVar2 == null) {
                    sparseArray = sparseArray;
                } else {
                    if (this.c != null) {
                        ConstraintWidget constraintWidgetD2 = d(this.a, childAt2);
                        if (constraintWidgetD2 != null) {
                            gVar2.G(MotionLayout.this.A0(constraintWidgetD2), this.c, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.d0 != 0) {
                            Log.e("MotionLayout", d70.b() + "no widget for  " + d70.d(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    } else {
                        if (MotionLayout.this.S0) {
                            e43.a(MotionLayout.this.U0.get(childAt2));
                            MotionLayout motionLayout = MotionLayout.this;
                            gVar2.F(null, childAt2, motionLayout.T0, motionLayout.V0, MotionLayout.this.W0);
                        }
                        if (this.d == null) {
                            constraintWidgetD = d(this.b, childAt2);
                            if (constraintWidgetD != null) {
                                gVar2.C(MotionLayout.this.A0(constraintWidgetD), this.d, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                            } else if (MotionLayout.this.d0 != 0) {
                                Log.e("MotionLayout", d70.b() + "no widget for  " + d70.d(childAt2) + " (" + childAt2.getClass().getName() + ")");
                            }
                        }
                    }
                    if (this.d == null) {
                        constraintWidgetD = d(this.b, childAt2);
                        if (constraintWidgetD != null) {
                            gVar2.C(MotionLayout.this.A0(constraintWidgetD), this.d, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.d0 != 0) {
                            Log.e("MotionLayout", d70.b() + "no widget for  " + d70.d(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
                i2++;
                sparseArray = sparseArray;
            }
            SparseArray sparseArray2 = sparseArray;
            int i3 = 0;
            while (i3 < childCount) {
                SparseArray sparseArray3 = sparseArray2;
                androidx.constraintlayout.motion.widget.g gVar3 = (androidx.constraintlayout.motion.widget.g) sparseArray3.get(iArr[i3]);
                int iH = gVar3.h();
                if (iH != -1) {
                    gVar3.J((androidx.constraintlayout.motion.widget.g) sparseArray3.get(iH));
                }
                i3++;
                sparseArray2 = sparseArray3;
            }
        }

        void c(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.core.widgets.d dVar2) {
            ConstraintWidget sw0Var;
            ArrayList<ConstraintWidget> arrayListV1 = dVar.v1();
            HashMap map = new HashMap();
            map.put(dVar, dVar2);
            dVar2.v1().clear();
            dVar2.n(dVar, map);
            for (ConstraintWidget constraintWidget : arrayListV1) {
                if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
                    sw0Var = new androidx.constraintlayout.core.widgets.a();
                } else if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                    sw0Var = new androidx.constraintlayout.core.widgets.f();
                } else if (constraintWidget instanceof androidx.constraintlayout.core.widgets.e) {
                    sw0Var = new androidx.constraintlayout.core.widgets.e();
                } else if (constraintWidget instanceof androidx.constraintlayout.core.widgets.h) {
                    sw0Var = new androidx.constraintlayout.core.widgets.h();
                } else {
                    sw0Var = constraintWidget instanceof rw0 ? new sw0() : new ConstraintWidget();
                }
                dVar2.b(sw0Var);
                map.put(constraintWidget, sw0Var);
            }
            for (ConstraintWidget constraintWidget2 : arrayListV1) {
                ((ConstraintWidget) map.get(constraintWidget2)).n(constraintWidget2, map);
            }
        }

        ConstraintWidget d(androidx.constraintlayout.core.widgets.d dVar, View view) {
            if (dVar.u() == view) {
                return dVar;
            }
            ArrayList arrayListV1 = dVar.v1();
            int size = arrayListV1.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) arrayListV1.get(i);
                if (constraintWidget.u() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        void e(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.widget.b bVar, androidx.constraintlayout.widget.b bVar2) {
            this.c = bVar;
            this.d = bVar2;
            this.a = new androidx.constraintlayout.core.widgets.d();
            this.b = new androidx.constraintlayout.core.widgets.d();
            this.a.Z1(((ConstraintLayout) MotionLayout.this).c.M1());
            this.b.Z1(((ConstraintLayout) MotionLayout.this).c.M1());
            this.a.y1();
            this.b.y1();
            c(((ConstraintLayout) MotionLayout.this).c, this.a);
            c(((ConstraintLayout) MotionLayout.this).c, this.b);
            if (MotionLayout.this.R > 0.5d) {
                if (bVar != null) {
                    j(this.a, bVar);
                }
                j(this.b, bVar2);
            } else {
                j(this.b, bVar2);
                if (bVar != null) {
                    j(this.a, bVar);
                }
            }
            this.a.c2(MotionLayout.this.r());
            this.a.e2();
            this.b.c2(MotionLayout.this.r());
            this.b.e2();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    androidx.constraintlayout.core.widgets.d dVar2 = this.a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar2.T0(dimensionBehaviour);
                    this.b.T0(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    androidx.constraintlayout.core.widgets.d dVar3 = this.a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar3.k1(dimensionBehaviour2);
                    this.b.k1(dimensionBehaviour2);
                }
            }
        }

        public boolean f(int i, int i2) {
            return (i == this.e && i2 == this.f) ? false : true;
        }

        public void g(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.J0 = mode;
            motionLayout.K0 = mode2;
            motionLayout.getOptimizationLevel();
            b(i, i2);
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                b(i, i2);
                MotionLayout.this.F0 = this.a.Y();
                MotionLayout.this.G0 = this.a.z();
                MotionLayout.this.H0 = this.b.Y();
                MotionLayout.this.I0 = this.b.z();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.E0 = (motionLayout2.F0 == motionLayout2.H0 && motionLayout2.G0 == motionLayout2.I0) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i3 = motionLayout3.F0;
            int i4 = motionLayout3.G0;
            int i5 = motionLayout3.J0;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                i3 = (int) (i3 + (motionLayout3.L0 * (motionLayout3.H0 - i3)));
            }
            int i6 = i3;
            int i7 = motionLayout3.K0;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                i4 = (int) (i4 + (motionLayout3.L0 * (motionLayout3.I0 - i4)));
            }
            MotionLayout.this.u(i, i2, i6, i4, this.a.U1() || this.b.U1(), this.a.S1() || this.b.S1());
        }

        public void h() {
            g(MotionLayout.this.K, MotionLayout.this.L);
            MotionLayout.this.z0();
        }

        public void i(int i, int i2) {
            this.e = i;
            this.f = i2;
        }
    }

    protected interface g {
        void a();

        void b(MotionEvent motionEvent);

        float c();

        float d();

        void e(int i);
    }

    private static class h implements g {
        private static h b = new h();
        VelocityTracker a;

        private h() {
        }

        public static h f() {
            b.a = VelocityTracker.obtain();
            return b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public void a() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.a = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public void b(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public float c() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public float d() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public void e(int i) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }
    }

    class i {
        float a = Float.NaN;
        float b = Float.NaN;
        int c = -1;
        int d = -1;
        final String e = "motion.progress";
        final String f = "motion.velocity";
        final String g = "motion.StartState";
        final String h = "motion.EndState";

        i() {
        }

        void a() {
            int i = this.c;
            if (i != -1 || this.d != -1) {
                if (i == -1) {
                    MotionLayout.this.F0(this.d);
                } else {
                    int i2 = this.d;
                    if (i2 == -1) {
                        MotionLayout.this.x0(i, -1, -1);
                    } else {
                        MotionLayout.this.y0(i, i2);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.b)) {
                if (Float.isNaN(this.a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.a);
            } else {
                MotionLayout.this.w0(this.a, this.b);
                this.a = Float.NaN;
                this.b = Float.NaN;
                this.c = -1;
                this.d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.a);
            bundle.putFloat("motion.velocity", this.b);
            bundle.putInt("motion.StartState", this.c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }

        public void c() {
            this.d = MotionLayout.this.J;
            this.c = MotionLayout.this.H;
            this.b = MotionLayout.this.getVelocity();
            this.a = MotionLayout.this.getProgress();
        }

        public void d(int i) {
            this.d = i;
        }

        public void e(float f) {
            this.a = f;
        }

        public void f(int i) {
            this.c = i;
        }

        public void g(Bundle bundle) {
            this.a = bundle.getFloat("motion.progress");
            this.b = bundle.getFloat("motion.velocity");
            this.c = bundle.getInt("motion.StartState");
            this.d = bundle.getInt("motion.EndState");
        }

        public void h(float f) {
            this.b = f;
        }
    }

    public interface j {
        void a(MotionLayout motionLayout, int i, int i2, float f);

        void b(MotionLayout motionLayout, int i, int i2);

        void c(MotionLayout motionLayout, int i);
    }

    public MotionLayout(Context context) {
        super(context);
        this.F = null;
        this.G = 0.0f;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.M = true;
        this.N = new HashMap();
        this.O = 0L;
        this.P = 1.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.T = 0.0f;
        this.V = false;
        this.W = false;
        this.d0 = 0;
        this.f0 = false;
        this.g0 = new pu2();
        this.h0 = new d();
        this.j0 = true;
        this.o0 = false;
        this.t0 = false;
        this.u0 = null;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = 0;
        this.z0 = -1L;
        this.A0 = 0.0f;
        this.B0 = 0;
        this.C0 = 0.0f;
        this.D0 = false;
        this.E0 = false;
        this.M0 = new x81();
        this.N0 = false;
        this.P0 = null;
        this.Q0 = null;
        this.R0 = 0;
        this.S0 = false;
        this.T0 = 0;
        this.U0 = new HashMap();
        this.Y0 = new Rect();
        this.Z0 = false;
        this.a1 = TransitionState.UNDEFINED;
        this.b1 = new f();
        this.c1 = false;
        this.d1 = new RectF();
        this.e1 = null;
        this.f1 = null;
        this.g1 = new ArrayList();
        q0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect A0(ConstraintWidget constraintWidget) {
        this.Y0.top = constraintWidget.a0();
        this.Y0.left = constraintWidget.Z();
        Rect rect = this.Y0;
        int iY = constraintWidget.Y();
        Rect rect2 = this.Y0;
        rect.right = iY + rect2.left;
        int iZ = constraintWidget.z();
        Rect rect3 = this.Y0;
        rect2.bottom = iZ + rect3.top;
        return rect3;
    }

    private static boolean K0(float f2, float f3, float f4) {
        if (f2 > 0.0f) {
            float f5 = f2 / f4;
            return f3 + ((f2 * f5) - (((f4 * f5) * f5) / 2.0f)) > 1.0f;
        }
        float f6 = (-f2) / f4;
        return f3 + ((f2 * f6) + (((f4 * f6) * f6) / 2.0f)) < 0.0f;
    }

    private boolean a0(View view, MotionEvent motionEvent, float f2, float f3) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f2, f3);
            boolean zOnTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f2, -f3);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(f2, f3);
        if (this.f1 == null) {
            this.f1 = new Matrix();
        }
        matrix.invert(this.f1);
        motionEventObtain.transform(this.f1);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    private void b0() {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int iF = iVar.F();
        androidx.constraintlayout.motion.widget.i iVar2 = this.y;
        c0(iF, iVar2.l(iVar2.F()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        for (androidx.constraintlayout.motion.widget.i.b bVar : this.y.o()) {
            if (bVar == this.y.c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            d0(bVar);
            int iA = bVar.A();
            int iY = bVar.y();
            String strC = d70.c(getContext(), iA);
            String strC2 = d70.c(getContext(), iY);
            if (sparseIntArray.get(iA) == iY) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + strC + "->" + strC2);
            }
            if (sparseIntArray2.get(iY) == iA) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + strC + "->" + strC2);
            }
            sparseIntArray.put(iA, iY);
            sparseIntArray2.put(iY, iA);
            if (this.y.l(iA) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + strC);
            }
            if (this.y.l(iY) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + strC);
            }
        }
    }

    private void c0(int i2, androidx.constraintlayout.widget.b bVar) {
        String strC = d70.c(getContext(), i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            if (id == -1) {
                Log.w("MotionLayout", "CHECK: " + strC + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (bVar.v(id) == null) {
                Log.w("MotionLayout", "CHECK: " + strC + " NO CONSTRAINTS for " + d70.d(childAt));
            }
        }
        int[] iArrX = bVar.x();
        for (int i4 = 0; i4 < iArrX.length; i4++) {
            int i5 = iArrX[i4];
            String strC2 = d70.c(getContext(), i5);
            if (findViewById(iArrX[i4]) == null) {
                Log.w("MotionLayout", "CHECK: " + strC + " NO View matches id " + strC2);
            }
            if (bVar.w(i5) == -1) {
                Log.w("MotionLayout", "CHECK: " + strC + "(" + strC2 + ") no LAYOUT_HEIGHT");
            }
            if (bVar.B(i5) == -1) {
                Log.w("MotionLayout", "CHECK: " + strC + "(" + strC2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    private void d0(androidx.constraintlayout.motion.widget.i.b bVar) {
        if (bVar.A() == bVar.y()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    private void e0() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.N.get(childAt);
            if (gVar != null) {
                gVar.E(childAt);
            }
        }
    }

    private void h0() {
        boolean z;
        float fSignum = Math.signum(this.T - this.R);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.z;
        float interpolation = this.R + (!(interpolator instanceof pu2) ? (((nanoTime - this.S) * fSignum) * 1.0E-9f) / this.P : 0.0f);
        if (this.U) {
            interpolation = this.T;
        }
        if ((fSignum <= 0.0f || interpolation < this.T) && (fSignum > 0.0f || interpolation > this.T)) {
            z = false;
        } else {
            interpolation = this.T;
            z = true;
        }
        if (interpolator != null && !z) {
            interpolation = this.f0 ? interpolator.getInterpolation((nanoTime - this.O) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.T) || (fSignum <= 0.0f && interpolation <= this.T)) {
            interpolation = this.T;
        }
        this.L0 = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.F;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.N.get(childAt);
            if (gVar != null) {
                gVar.x(childAt, interpolation, nanoTime2, this.M0);
            }
        }
        if (this.E0) {
            requestLayout();
        }
    }

    private void i0() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.a0 == null && ((copyOnWriteArrayList = this.x0) == null || copyOnWriteArrayList.isEmpty())) || this.C0 == this.Q) {
            return;
        }
        if (this.B0 != -1) {
            j jVar = this.a0;
            if (jVar != null) {
                jVar.b(this, this.H, this.J);
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.x0;
            if (copyOnWriteArrayList2 != null) {
                Iterator it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).b(this, this.H, this.J);
                }
            }
            this.D0 = true;
        }
        this.B0 = -1;
        float f2 = this.Q;
        this.C0 = f2;
        j jVar2 = this.a0;
        if (jVar2 != null) {
            jVar2.a(this, this.H, this.J, f2);
        }
        CopyOnWriteArrayList copyOnWriteArrayList3 = this.x0;
        if (copyOnWriteArrayList3 != null) {
            Iterator it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                ((j) it2.next()).a(this, this.H, this.J, this.Q);
            }
        }
        this.D0 = true;
    }

    private boolean p0(float f2, float f3, View view, MotionEvent motionEvent) {
        boolean z;
        if (!(view instanceof ViewGroup)) {
            z = false;
            break;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(childCount);
            if (p0((childAt.getLeft() + f2) - view.getScrollX(), (childAt.getTop() + f3) - view.getScrollY(), childAt, motionEvent)) {
                z = true;
                break;
            }
            childCount--;
        }
        if (!z) {
            this.d1.set(f2, f3, (view.getRight() + f2) - view.getLeft(), (view.getBottom() + f3) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.d1.contains(motionEvent.getX(), motionEvent.getY())) && a0(view, motionEvent, -f2, -f3)) {
                return true;
            }
        }
        return z;
    }

    private void q0(AttributeSet attributeSet) {
        androidx.constraintlayout.motion.widget.i iVar;
        h1 = isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.MotionLayout_layoutDescription) {
                    this.y = new androidx.constraintlayout.motion.widget.i(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R$styleable.MotionLayout_currentState) {
                    this.I = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R$styleable.MotionLayout_motionProgress) {
                    this.T = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.V = true;
                } else if (index == R$styleable.MotionLayout_applyMotionScene) {
                    z = typedArrayObtainStyledAttributes.getBoolean(index, z);
                } else if (index == R$styleable.MotionLayout_showPaths) {
                    if (this.d0 == 0) {
                        this.d0 = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R$styleable.MotionLayout_motionDebug) {
                    this.d0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.y == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.y = null;
            }
        }
        if (this.d0 != 0) {
            b0();
        }
        if (this.I != -1 || (iVar = this.y) == null) {
            return;
        }
        this.I = iVar.F();
        this.H = this.y.F();
        this.J = this.y.q();
    }

    private void u0() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.a0 == null && ((copyOnWriteArrayList = this.x0) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.D0 = false;
        for (Integer num : this.g1) {
            j jVar = this.a0;
            if (jVar != null) {
                jVar.c(this, num.intValue());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.x0;
            if (copyOnWriteArrayList2 != null) {
                Iterator it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).c(this, num.intValue());
                }
            }
        }
        this.g1.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        int childCount = getChildCount();
        this.b1.a();
        this.V = true;
        SparseArray sparseArray = new SparseArray();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            sparseArray.put(childAt.getId(), (androidx.constraintlayout.motion.widget.g) this.N.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int iJ = this.y.j();
        if (iJ != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i4));
                if (gVar != null) {
                    gVar.D(iJ);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.N.size()];
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            androidx.constraintlayout.motion.widget.g gVar2 = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i6));
            if (gVar2.h() != -1) {
                sparseBooleanArray.put(gVar2.h(), true);
                iArr[i5] = gVar2.h();
                i5++;
            }
        }
        if (this.w0 != null) {
            for (int i7 = 0; i7 < i5; i7++) {
                androidx.constraintlayout.motion.widget.g gVar3 = (androidx.constraintlayout.motion.widget.g) this.N.get(findViewById(iArr[i7]));
                if (gVar3 != null) {
                    this.y.t(gVar3);
                }
            }
            Iterator it = this.w0.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).C(this, this.N);
            }
            for (int i8 = 0; i8 < i5; i8++) {
                androidx.constraintlayout.motion.widget.g gVar4 = (androidx.constraintlayout.motion.widget.g) this.N.get(findViewById(iArr[i8]));
                if (gVar4 != null) {
                    gVar4.I(width, height, this.P, getNanoTime());
                }
            }
        } else {
            for (int i9 = 0; i9 < i5; i9++) {
                androidx.constraintlayout.motion.widget.g gVar5 = (androidx.constraintlayout.motion.widget.g) this.N.get(findViewById(iArr[i9]));
                if (gVar5 != null) {
                    this.y.t(gVar5);
                    gVar5.I(width, height, this.P, getNanoTime());
                }
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            androidx.constraintlayout.motion.widget.g gVar6 = (androidx.constraintlayout.motion.widget.g) this.N.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && gVar6 != null) {
                this.y.t(gVar6);
                gVar6.I(width, height, this.P, getNanoTime());
            }
        }
        float fE = this.y.E();
        if (fE != 0.0f) {
            boolean z = ((double) fE) < 0.0d;
            float fAbs = Math.abs(fE);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            float fMin2 = Float.MAX_VALUE;
            for (int i11 = 0; i11 < childCount; i11++) {
                androidx.constraintlayout.motion.widget.g gVar7 = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i11));
                if (!Float.isNaN(gVar7.m)) {
                    for (int i12 = 0; i12 < childCount; i12++) {
                        androidx.constraintlayout.motion.widget.g gVar8 = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i12));
                        if (!Float.isNaN(gVar8.m)) {
                            fMin = Math.min(fMin, gVar8.m);
                            fMax = Math.max(fMax, gVar8.m);
                        }
                    }
                    while (i2 < childCount) {
                        androidx.constraintlayout.motion.widget.g gVar9 = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i2));
                        if (!Float.isNaN(gVar9.m)) {
                            gVar9.o = 1.0f / (1.0f - fAbs);
                            if (z) {
                                gVar9.n = fAbs - (((fMax - gVar9.m) / (fMax - fMin)) * fAbs);
                            } else {
                                gVar9.n = fAbs - (((gVar9.m - fMin) * fAbs) / (fMax - fMin));
                            }
                        }
                        i2++;
                    }
                    return;
                }
                float fN = gVar7.n();
                float fO = gVar7.o();
                float f2 = z ? fO - fN : fO + fN;
                fMin2 = Math.min(fMin2, f2);
                fMax2 = Math.max(fMax2, f2);
            }
            while (i2 < childCount) {
                androidx.constraintlayout.motion.widget.g gVar10 = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i2));
                float fN2 = gVar10.n();
                float fO2 = gVar10.o();
                float f3 = z ? fO2 - fN2 : fO2 + fN2;
                gVar10.o = 1.0f / (1.0f - fAbs);
                gVar10.n = fAbs - (((f3 - fMin2) * fAbs) / (fMax2 - fMin2));
                i2++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0093  */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c0  */
    public void B0(int i2, float f2, float f3) {
        if (this.y == null || this.R == f2) {
            return;
        }
        this.f0 = true;
        this.O = getNanoTime();
        this.P = this.y.p() / 1000.0f;
        this.T = f2;
        this.V = true;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            if (i2 != 1 || i2 == 7) {
                f2 = 0.0f;
            } else if (i2 == 2 || i2 == 6) {
                f2 = 1.0f;
            }
            if (this.y.k() == 0) {
                this.g0.b(this.R, f2, f3, this.P, this.y.u(), this.y.v());
            } else {
                this.g0.d(this.R, f2, f3, this.y.B(), this.y.C(), this.y.A(), this.y.D(), this.y.z());
            }
            int i3 = this.I;
            this.T = f2;
            this.I = i3;
            this.z = this.g0;
        } else if (i2 == 4) {
            this.h0.b(f3, this.R, this.y.u());
            this.z = this.h0;
        } else if (i2 != 5) {
            if (i2 == 6 || i2 == 7) {
                if (i2 != 1) {
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                }
                if (this.y.k() == 0) {
                    this.g0.b(this.R, f2, f3, this.P, this.y.u(), this.y.v());
                } else {
                    this.g0.d(this.R, f2, f3, this.y.B(), this.y.C(), this.y.A(), this.y.D(), this.y.z());
                }
                int i4 = this.I;
                this.T = f2;
                this.I = i4;
                this.z = this.g0;
            }
        } else if (K0(f3, this.R, this.y.u())) {
            this.h0.b(f3, this.R, this.y.u());
            this.z = this.h0;
        } else {
            this.g0.b(this.R, f2, f3, this.P, this.y.u(), this.y.v());
            this.G = 0.0f;
            int i5 = this.I;
            this.T = f2;
            this.I = i5;
            this.z = this.g0;
        }
        this.U = false;
        this.O = getNanoTime();
        invalidate();
    }

    public void C0() {
        Y(1.0f);
        this.P0 = null;
    }

    public void D0(Runnable runnable) {
        Y(1.0f);
        this.P0 = runnable;
    }

    public void E0() {
        Y(0.0f);
    }

    public void F0(int i2) {
        if (isAttachedToWindow()) {
            G0(i2, -1, -1);
            return;
        }
        if (this.O0 == null) {
            this.O0 = new i();
        }
        this.O0.d(i2);
    }

    public void G0(int i2, int i3, int i4) {
        H0(i2, i3, i4, -1);
    }

    public void H0(int i2, int i3, int i4, int i5) {
        st2 st2Var;
        int iA;
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null && (st2Var = iVar.b) != null && (iA = st2Var.a(this.I, i2, i3, i4)) != -1) {
            i2 = iA;
        }
        int i6 = this.I;
        if (i6 == i2) {
            return;
        }
        if (this.H == i2) {
            Y(0.0f);
            if (i5 > 0) {
                this.P = i5 / 1000.0f;
                return;
            }
            return;
        }
        if (this.J == i2) {
            Y(1.0f);
            if (i5 > 0) {
                this.P = i5 / 1000.0f;
                return;
            }
            return;
        }
        this.J = i2;
        if (i6 != -1) {
            y0(i6, i2);
            Y(1.0f);
            this.R = 0.0f;
            C0();
            if (i5 > 0) {
                this.P = i5 / 1000.0f;
                return;
            }
            return;
        }
        this.f0 = false;
        this.T = 1.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.S = getNanoTime();
        this.O = getNanoTime();
        this.U = false;
        this.z = null;
        if (i5 == -1) {
            this.P = this.y.p() / 1000.0f;
        }
        this.H = -1;
        this.y.X(-1, this.J);
        SparseArray sparseArray = new SparseArray();
        if (i5 == 0) {
            this.P = this.y.p() / 1000.0f;
        } else if (i5 > 0) {
            this.P = i5 / 1000.0f;
        }
        int childCount = getChildCount();
        this.N.clear();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            this.N.put(childAt, new androidx.constraintlayout.motion.widget.g(childAt));
            sparseArray.put(childAt.getId(), (androidx.constraintlayout.motion.widget.g) this.N.get(childAt));
        }
        this.V = true;
        this.b1.e(this.c, null, this.y.l(i2));
        v0();
        this.b1.a();
        e0();
        int width = getWidth();
        int height = getHeight();
        if (this.w0 != null) {
            for (int i8 = 0; i8 < childCount; i8++) {
                androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i8));
                if (gVar != null) {
                    this.y.t(gVar);
                }
            }
            Iterator it = this.w0.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).C(this, this.N);
            }
            for (int i9 = 0; i9 < childCount; i9++) {
                androidx.constraintlayout.motion.widget.g gVar2 = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i9));
                if (gVar2 != null) {
                    gVar2.I(width, height, this.P, getNanoTime());
                }
            }
        } else {
            for (int i10 = 0; i10 < childCount; i10++) {
                androidx.constraintlayout.motion.widget.g gVar3 = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i10));
                if (gVar3 != null) {
                    this.y.t(gVar3);
                    gVar3.I(width, height, this.P, getNanoTime());
                }
            }
        }
        float fE = this.y.E();
        if (fE != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i11 = 0; i11 < childCount; i11++) {
                androidx.constraintlayout.motion.widget.g gVar4 = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i11));
                float fO = gVar4.o() + gVar4.n();
                fMin = Math.min(fMin, fO);
                fMax = Math.max(fMax, fO);
            }
            for (int i12 = 0; i12 < childCount; i12++) {
                androidx.constraintlayout.motion.widget.g gVar5 = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i12));
                float fN = gVar5.n();
                float fO2 = gVar5.o();
                gVar5.o = 1.0f / (1.0f - fE);
                gVar5.n = fE - ((((fN + fO2) - fMin) * fE) / (fMax - fMin));
            }
        }
        this.Q = 0.0f;
        this.R = 0.0f;
        this.V = true;
        invalidate();
    }

    public void I0() {
        this.b1.e(this.c, this.y.l(this.H), this.y.l(this.J));
        v0();
    }

    public void J0(int i2, androidx.constraintlayout.widget.b bVar) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            iVar.U(i2, bVar);
        }
        I0();
        if (this.I == i2) {
            bVar.i(this);
        }
    }

    void Y(float f2) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            return;
        }
        float f3 = this.R;
        float f4 = this.Q;
        if (f3 != f4 && this.U) {
            this.R = f4;
        }
        float f5 = this.R;
        if (f5 == f2) {
            return;
        }
        this.f0 = false;
        this.T = f2;
        this.P = iVar.p() / 1000.0f;
        setProgress(this.T);
        this.z = null;
        this.F = this.y.s();
        this.U = false;
        this.O = getNanoTime();
        this.V = true;
        this.Q = f5;
        this.R = f5;
        invalidate();
    }

    public boolean Z(int i2, androidx.constraintlayout.motion.widget.g gVar) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            return iVar.g(i2, gVar);
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        l lVar;
        ArrayList arrayList = this.w0;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).B(canvas);
            }
        }
        g0(false);
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null && (lVar = iVar.s) != null) {
            lVar.c();
        }
        super.dispatchDraw(canvas);
        if (this.y == null) {
            return;
        }
        if ((this.d0 & 1) == 1 && !isInEditMode()) {
            this.y0++;
            long nanoTime = getNanoTime();
            long j2 = this.z0;
            if (j2 != -1) {
                long j3 = nanoTime - j2;
                if (j3 > 200000000) {
                    this.A0 = ((int) ((this.y0 / (j3 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.y0 = 0;
                    this.z0 = nanoTime;
                }
            } else {
                this.z0 = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            float progress = ((int) (getProgress() * 1000.0f)) / 10.0f;
            String str = this.A0 + " fps " + d70.e(this, this.H) + " -> ";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(d70.e(this, this.J));
            sb.append(" (progress: ");
            sb.append(progress);
            sb.append(" ) state=");
            int i2 = this.I;
            sb.append(i2 == -1 ? "undefined" : d70.e(this, i2));
            String string = sb.toString();
            paint.setColor(-16777216);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.d0 > 1) {
            if (this.e0 == null) {
                this.e0 = new e();
            }
            this.e0.a(canvas, this.N, this.y.p(), this.d0);
        }
        ArrayList arrayList2 = this.w0;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((MotionHelper) it2.next()).A(canvas);
            }
        }
    }

    void f0(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i2));
            if (gVar != null) {
                gVar.f(z);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x01be  */
    /* JADX WARN: Code duplicated, block: B:127:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:143:0x0222  */
    /* JADX WARN: Code duplicated, block: B:180:0x0193 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00e2 A[PHI: r3
      0x00e2: PHI (r3v50 float) = (r3v49 float), (r3v51 float), (r3v51 float) binds: [B:47:0x00ab, B:58:0x00d6, B:60:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x0111  */
    /* JADX WARN: Code duplicated, block: B:74:0x0118  */
    /* JADX WARN: Code duplicated, block: B:86:0x0138  */
    /* JADX WARN: Code duplicated, block: B:89:0x014f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0151  */
    /* JADX WARN: Code duplicated, block: B:93:0x0159  */
    /* JADX WARN: Code duplicated, block: B:96:0x0170  */
    /* JADX WARN: Code duplicated, block: B:98:0x0180  */
    void g0(boolean z) {
        boolean z2;
        char c2;
        int childCount;
        long nanoTime;
        Interpolator interpolator;
        float interpolation;
        Interpolator interpolator2;
        int i2;
        int i3;
        int i4;
        int i5;
        View childAt;
        androidx.constraintlayout.motion.widget.g gVar;
        boolean z3;
        if (this.S == -1) {
            this.S = getNanoTime();
        }
        float f2 = this.R;
        if (f2 > 0.0f && f2 < 1.0f) {
            this.I = -1;
        }
        boolean z4 = false;
        if (this.t0 || (this.V && (z || this.T != f2))) {
            float fSignum = Math.signum(this.T - f2);
            long nanoTime2 = getNanoTime();
            Interpolator interpolator3 = this.z;
            float f3 = !(interpolator3 instanceof bl1) ? (((nanoTime2 - this.S) * fSignum) * 1.0E-9f) / this.P : 0.0f;
            float f4 = this.R + f3;
            if (this.U) {
                f4 = this.T;
            }
            if ((fSignum <= 0.0f || f4 < this.T) && (fSignum > 0.0f || f4 > this.T)) {
                z2 = false;
            } else {
                f4 = this.T;
                this.V = false;
                z2 = true;
            }
            this.R = f4;
            this.Q = f4;
            this.S = nanoTime2;
            if (interpolator3 == null || z2) {
                this.G = f3;
            } else {
                if (this.f0) {
                    float interpolation2 = interpolator3.getInterpolation((nanoTime2 - this.O) * 1.0E-9f);
                    Interpolator interpolator4 = this.z;
                    pu2 pu2Var = this.g0;
                    c2 = interpolator4 == pu2Var ? pu2Var.c() ? (char) 2 : (char) 1 : (char) 0;
                    this.R = interpolation2;
                    this.S = nanoTime2;
                    Interpolator interpolator5 = this.z;
                    if (interpolator5 instanceof bl1) {
                        float fA = ((bl1) interpolator5).a();
                        this.G = fA;
                        if (Math.abs(fA) * this.P <= 1.0E-5f && c2 == 2) {
                            this.V = false;
                        }
                        if (fA > 0.0f && interpolation2 >= 1.0f) {
                            this.R = 1.0f;
                            this.V = false;
                            interpolation2 = 1.0f;
                        }
                        if (fA >= 0.0f || interpolation2 > 0.0f) {
                            f4 = interpolation2;
                        } else {
                            this.R = 0.0f;
                            this.V = false;
                            f4 = 0.0f;
                        }
                    } else {
                        f4 = interpolation2;
                    }
                } else {
                    float interpolation3 = interpolator3.getInterpolation(f4);
                    Interpolator interpolator6 = this.z;
                    if (interpolator6 instanceof bl1) {
                        this.G = ((bl1) interpolator6).a();
                    } else {
                        this.G = ((interpolator6.getInterpolation(f4 + f3) - interpolation3) * fSignum) / f3;
                    }
                    f4 = interpolation3;
                }
                if (Math.abs(this.G) > 1.0E-5f) {
                    setState(TransitionState.MOVING);
                }
                if (c2 != 1) {
                    if ((fSignum <= 0.0f && f4 >= this.T) || (fSignum <= 0.0f && f4 <= this.T)) {
                        f4 = this.T;
                        this.V = false;
                    }
                    if (f4 < 1.0f || f4 <= 0.0f) {
                        this.V = false;
                        setState(TransitionState.FINISHED);
                    }
                }
                childCount = getChildCount();
                this.t0 = false;
                nanoTime = getNanoTime();
                this.L0 = f4;
                interpolator = this.F;
                if (interpolator == null) {
                    interpolation = f4;
                } else {
                    interpolation = interpolator.getInterpolation(f4);
                }
                interpolator2 = this.F;
                if (interpolator2 != null) {
                    float interpolation4 = interpolator2.getInterpolation((fSignum / this.P) + f4);
                    this.G = interpolation4;
                    this.G = interpolation4 - this.F.getInterpolation(f4);
                }
                for (i2 = 0; i2 < childCount; i2++) {
                    childAt = getChildAt(i2);
                    gVar = (androidx.constraintlayout.motion.widget.g) this.N.get(childAt);
                    if (gVar != null) {
                        this.t0 = gVar.x(childAt, interpolation, nanoTime, this.M0) | this.t0;
                    }
                }
                boolean z5 = (fSignum <= 0.0f && f4 >= this.T) || (fSignum <= 0.0f && f4 <= this.T);
                if (!this.t0 && !this.V && z5) {
                    setState(TransitionState.FINISHED);
                }
                if (this.E0) {
                    requestLayout();
                }
                this.t0 = (!z5) | this.t0;
                if (f4 <= 0.0f && (i5 = this.H) != -1 && this.I != i5) {
                    this.I = i5;
                    this.y.l(i5).g(this);
                    setState(TransitionState.FINISHED);
                    z4 = true;
                }
                if (f4 >= 1.0d) {
                    i3 = this.I;
                    i4 = this.J;
                    if (i3 != i4) {
                        this.I = i4;
                        this.y.l(i4).g(this);
                        setState(TransitionState.FINISHED);
                        z4 = true;
                    }
                }
                if (!this.t0 || this.V) {
                    invalidate();
                } else if ((fSignum > 0.0f && f4 == 1.0f) || (fSignum < 0.0f && f4 == 0.0f)) {
                    setState(TransitionState.FINISHED);
                }
                if (!this.t0 && !this.V && ((fSignum > 0.0f && f4 == 1.0f) || (fSignum < 0.0f && f4 == 0.0f))) {
                    t0();
                }
            }
            c2 = 0;
            if (Math.abs(this.G) > 1.0E-5f) {
                setState(TransitionState.MOVING);
            }
            if (c2 != 1) {
                if (fSignum <= 0.0f) {
                    f4 = this.T;
                    this.V = false;
                } else {
                    f4 = this.T;
                    this.V = false;
                }
                if (f4 < 1.0f) {
                    this.V = false;
                    setState(TransitionState.FINISHED);
                } else {
                    this.V = false;
                    setState(TransitionState.FINISHED);
                }
            }
            childCount = getChildCount();
            this.t0 = false;
            nanoTime = getNanoTime();
            this.L0 = f4;
            interpolator = this.F;
            if (interpolator == null) {
                interpolation = f4;
            } else {
                interpolation = interpolator.getInterpolation(f4);
            }
            interpolator2 = this.F;
            if (interpolator2 != null) {
                float interpolation5 = interpolator2.getInterpolation((fSignum / this.P) + f4);
                this.G = interpolation5;
                this.G = interpolation5 - this.F.getInterpolation(f4);
            }
            while (i2 < childCount) {
                childAt = getChildAt(i2);
                gVar = (androidx.constraintlayout.motion.widget.g) this.N.get(childAt);
                if (gVar != null) {
                    this.t0 = gVar.x(childAt, interpolation, nanoTime, this.M0) | this.t0;
                }
            }
            if (fSignum <= 0.0f) {
            }
            if (!this.t0) {
                setState(TransitionState.FINISHED);
            }
            if (this.E0) {
                requestLayout();
            }
            this.t0 = (!z5) | this.t0;
            if (f4 <= 0.0f) {
                this.I = i5;
                this.y.l(i5).g(this);
                setState(TransitionState.FINISHED);
                z4 = true;
            }
            if (f4 >= 1.0d) {
                i3 = this.I;
                i4 = this.J;
                if (i3 != i4) {
                    this.I = i4;
                    this.y.l(i4).g(this);
                    setState(TransitionState.FINISHED);
                    z4 = true;
                }
            }
            if (this.t0) {
                invalidate();
            } else {
                invalidate();
            }
            if (!this.t0) {
                t0();
            }
        }
        float f5 = this.R;
        if (f5 < 1.0f) {
            if (f5 <= 0.0f) {
                int i6 = this.I;
                int i7 = this.H;
                z3 = i6 == i7 ? z4 : true;
                this.I = i7;
            }
            this.c1 |= z4;
            if (z4 && !this.N0) {
                requestLayout();
            }
            this.Q = this.R;
        }
        int i8 = this.I;
        int i9 = this.J;
        z3 = i8 == i9 ? z4 : true;
        this.I = i9;
        z4 = z3;
        this.c1 |= z4;
        if (z4) {
            requestLayout();
        }
        this.Q = this.R;
    }

    public int[] getConstraintSetIds() {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            return null;
        }
        return iVar.n();
    }

    public int getCurrentState() {
        return this.I;
    }

    public ArrayList<androidx.constraintlayout.motion.widget.i.b> getDefinedTransitions() {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            return null;
        }
        return iVar.o();
    }

    public r90 getDesignTool() {
        if (this.i0 == null) {
            this.i0 = new r90(this);
        }
        return this.i0;
    }

    public int getEndState() {
        return this.J;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.R;
    }

    public androidx.constraintlayout.motion.widget.i getScene() {
        return this.y;
    }

    public int getStartState() {
        return this.H;
    }

    public float getTargetPosition() {
        return this.T;
    }

    public Bundle getTransitionState() {
        if (this.O0 == null) {
            this.O0 = new i();
        }
        this.O0.c();
        return this.O0.b();
    }

    public long getTransitionTimeMs() {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            this.P = iVar.p() / 1000.0f;
        }
        return (long) (this.P * 1000.0f);
    }

    public float getVelocity() {
        return this.G;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // defpackage.vn1
    public void j(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (this.o0 || i2 != 0 || i3 != 0) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
        this.o0 = false;
    }

    protected void j0() {
        int iIntValue;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.a0 != null || ((copyOnWriteArrayList = this.x0) != null && !copyOnWriteArrayList.isEmpty())) && this.B0 == -1) {
            this.B0 = this.I;
            if (this.g1.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList arrayList = this.g1;
                iIntValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            }
            int i2 = this.I;
            if (iIntValue != i2 && i2 != -1) {
                this.g1.add(Integer.valueOf(i2));
            }
        }
        u0();
        Runnable runnable = this.P0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.Q0;
        if (iArr == null || this.R0 <= 0) {
            return;
        }
        F0(iArr[0]);
        int[] iArr2 = this.Q0;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.R0--;
    }

    @Override // defpackage.un1
    public void k(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    void k0(int i2, float f2, float f3, float f4, float[] fArr) {
        String resourceName;
        HashMap map = this.N;
        View viewI = i(i2);
        androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) map.get(viewI);
        if (gVar != null) {
            gVar.l(f2, f3, f4, fArr);
            float y = viewI.getY();
            this.b0 = f2;
            this.c0 = y;
            return;
        }
        if (viewI == null) {
            resourceName = Constants.STR_EMPTY + i2;
        } else {
            resourceName = viewI.getContext().getResources().getResourceName(i2);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    @Override // defpackage.un1
    public boolean l(View view, View view2, int i2, int i3) {
        androidx.constraintlayout.motion.widget.i.b bVar;
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        return (iVar == null || (bVar = iVar.c) == null || bVar.B() == null || (this.y.c.B().e() & 2) != 0) ? false : true;
    }

    public androidx.constraintlayout.widget.b l0(int i2) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            return null;
        }
        return iVar.l(i2);
    }

    @Override // defpackage.un1
    public void m(View view, View view2, int i2, int i3) {
        this.r0 = getNanoTime();
        this.s0 = 0.0f;
        this.p0 = 0.0f;
        this.q0 = 0.0f;
    }

    androidx.constraintlayout.motion.widget.g m0(int i2) {
        return (androidx.constraintlayout.motion.widget.g) this.N.get(findViewById(i2));
    }

    @Override // defpackage.un1
    public void n(View view, int i2) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            float f2 = this.s0;
            if (f2 == 0.0f) {
                return;
            }
            iVar.Q(this.p0 / f2, this.q0 / f2);
        }
    }

    public androidx.constraintlayout.motion.widget.i.b n0(int i2) {
        return this.y.G(i2);
    }

    @Override // defpackage.un1
    public void o(View view, int i2, int i3, int[] iArr, int i4) {
        androidx.constraintlayout.motion.widget.i.b bVar;
        androidx.constraintlayout.motion.widget.j jVarB;
        int iQ;
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null || (bVar = iVar.c) == null || !bVar.C()) {
            return;
        }
        int i5 = -1;
        if (!bVar.C() || (jVarB = bVar.B()) == null || (iQ = jVarB.q()) == -1 || view.getId() == iQ) {
            if (iVar.w()) {
                androidx.constraintlayout.motion.widget.j jVarB2 = bVar.B();
                if (jVarB2 != null && (jVarB2.e() & 4) != 0) {
                    i5 = i3;
                }
                float f2 = this.Q;
                if ((f2 == 1.0f || f2 == 0.0f) && view.canScrollVertically(i5)) {
                    return;
                }
            }
            if (bVar.B() != null && (bVar.B().e() & 1) != 0) {
                float fX = iVar.x(i2, i3);
                float f3 = this.R;
                if ((f3 <= 0.0f && fX < 0.0f) || (f3 >= 1.0f && fX > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new a(this, view));
                    return;
                }
            }
            float f4 = this.Q;
            long nanoTime = getNanoTime();
            float f5 = i2;
            this.p0 = f5;
            float f6 = i3;
            this.q0 = f6;
            this.s0 = (float) ((nanoTime - this.r0) * 1.0E-9d);
            this.r0 = nanoTime;
            iVar.P(f5, f6);
            if (f4 != this.Q) {
                iArr[0] = i2;
                iArr[1] = i3;
            }
            g0(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.o0 = true;
        }
    }

    public void o0(View view, float f2, float f3, float[] fArr, int i2) {
        float interpolation;
        float fA = this.G;
        float f4 = this.R;
        if (this.z != null) {
            float fSignum = Math.signum(this.T - f4);
            float interpolation2 = this.z.getInterpolation(this.R + 1.0E-5f);
            interpolation = this.z.getInterpolation(this.R);
            fA = (fSignum * ((interpolation2 - interpolation) / 1.0E-5f)) / this.P;
        } else {
            interpolation = f4;
        }
        Interpolator interpolator = this.z;
        if (interpolator instanceof bl1) {
            fA = ((bl1) interpolator).a();
        }
        androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.N.get(view);
        if ((i2 & 1) == 0) {
            gVar.r(interpolation, view.getWidth(), view.getHeight(), f2, f3, fArr);
        } else {
            gVar.l(interpolation, f2, f3, fArr);
        }
        if (i2 < 2) {
            fArr[0] = fArr[0] * fA;
            fArr[1] = fArr[1] * fA;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        androidx.constraintlayout.motion.widget.i.b bVar;
        int i2;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.X0 = display.getRotation();
        }
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null && (i2 = this.I) != -1) {
            androidx.constraintlayout.widget.b bVarL = iVar.l(i2);
            this.y.T(this);
            ArrayList arrayList = this.w0;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((MotionHelper) it.next()).z(this);
                }
            }
            if (bVarL != null) {
                bVarL.i(this);
            }
            this.H = this.I;
        }
        t0();
        i iVar2 = this.O0;
        if (iVar2 != null) {
            if (this.Z0) {
                post(new b());
                return;
            } else {
                iVar2.a();
                return;
            }
        }
        androidx.constraintlayout.motion.widget.i iVar3 = this.y;
        if (iVar3 == null || (bVar = iVar3.c) == null || bVar.x() != 4) {
            return;
        }
        C0();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        androidx.constraintlayout.motion.widget.j jVarB;
        int iQ;
        RectF rectFP;
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null && this.M) {
            l lVar = iVar.s;
            if (lVar != null) {
                lVar.h(motionEvent);
            }
            androidx.constraintlayout.motion.widget.i.b bVar = this.y.c;
            if (bVar != null && bVar.C() && (jVarB = bVar.B()) != null && ((motionEvent.getAction() != 0 || (rectFP = jVarB.p(this, new RectF())) == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) && (iQ = jVarB.q()) != -1)) {
                View view = this.e1;
                if (view == null || view.getId() != iQ) {
                    this.e1 = findViewById(iQ);
                }
                View view2 = this.e1;
                if (view2 != null) {
                    this.d1.set(view2.getLeft(), this.e1.getTop(), this.e1.getRight(), this.e1.getBottom());
                    if (this.d1.contains(motionEvent.getX(), motionEvent.getY()) && !p0(this.e1.getLeft(), this.e1.getTop(), this.e1, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.N0 = true;
        try {
            if (this.y == null) {
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (this.m0 != i6 || this.n0 != i7) {
                v0();
                g0(true);
            }
            this.m0 = i6;
            this.n0 = i7;
            this.k0 = i6;
            this.l0 = i7;
        } finally {
            this.N0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.y == null) {
            super.onMeasure(i2, i3);
            return;
        }
        boolean z = false;
        boolean z2 = (this.K == i2 && this.L == i3) ? false : true;
        if (this.c1) {
            this.c1 = false;
            t0();
            u0();
            z2 = true;
        }
        if (this.h) {
            z2 = true;
        }
        this.K = i2;
        this.L = i3;
        int iF = this.y.F();
        int iQ = this.y.q();
        if ((z2 || this.b1.f(iF, iQ)) && this.H != -1) {
            super.onMeasure(i2, i3);
            this.b1.e(this.c, this.y.l(iF), this.y.l(iQ));
            this.b1.h();
            this.b1.i(iF, iQ);
        } else {
            if (z2) {
                super.onMeasure(i2, i3);
            }
            z = true;
        }
        if (this.E0 || z) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int iY = this.c.Y() + getPaddingLeft() + getPaddingRight();
            int iZ = this.c.z() + paddingTop;
            int i4 = this.J0;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                int i5 = this.F0;
                iY = (int) (i5 + (this.L0 * (this.H0 - i5)));
                requestLayout();
            }
            int i6 = this.K0;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                int i7 = this.G0;
                iZ = (int) (i7 + (this.L0 * (this.I0 - i7)));
                requestLayout();
            }
            setMeasuredDimension(iY, iZ);
        }
        h0();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            iVar.W(r());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null || !this.M || !iVar.b0()) {
            return super.onTouchEvent(motionEvent);
        }
        androidx.constraintlayout.motion.widget.i.b bVar = this.y.c;
        if (bVar != null && !bVar.C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.y.R(motionEvent, getCurrentState(), this);
        if (this.y.c.D(4)) {
            return this.y.c.B().r();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.x0 == null) {
                this.x0 = new CopyOnWriteArrayList();
            }
            this.x0.add(motionHelper);
            if (motionHelper.y()) {
                if (this.u0 == null) {
                    this.u0 = new ArrayList();
                }
                this.u0.add(motionHelper);
            }
            if (motionHelper.x()) {
                if (this.v0 == null) {
                    this.v0 = new ArrayList();
                }
                this.v0.add(motionHelper);
            }
            if (motionHelper.w()) {
                if (this.w0 == null) {
                    this.w0 = new ArrayList();
                }
                this.w0.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.u0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.v0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public boolean r0() {
        return this.M;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        androidx.constraintlayout.motion.widget.i iVar;
        androidx.constraintlayout.motion.widget.i.b bVar;
        if (!this.E0 && this.I == -1 && (iVar = this.y) != null && (bVar = iVar.c) != null) {
            int iZ = bVar.z();
            if (iZ == 0) {
                return;
            }
            if (iZ == 2) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    ((androidx.constraintlayout.motion.widget.g) this.N.get(getChildAt(i2))).z();
                }
                return;
            }
        }
        super.requestLayout();
    }

    protected g s0() {
        return h.f();
    }

    public void setDebugMode(int i2) {
        this.d0 = i2;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.Z0 = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.M = z;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.y != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolatorS = this.y.s();
            if (interpolatorS != null) {
                setProgress(interpolatorS.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList arrayList = this.v0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((MotionHelper) this.v0.get(i2)).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList arrayList = this.u0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((MotionHelper) this.u0.get(i2)).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.O0 == null) {
                this.O0 = new i();
            }
            this.O0.e(f2);
            return;
        }
        if (f2 <= 0.0f) {
            if (this.R == 1.0f && this.I == this.J) {
                setState(TransitionState.MOVING);
            }
            this.I = this.H;
            if (this.R == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            if (this.R == 0.0f && this.I == this.H) {
                setState(TransitionState.MOVING);
            }
            this.I = this.J;
            if (this.R == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.I = -1;
            setState(TransitionState.MOVING);
        }
        if (this.y == null) {
            return;
        }
        this.U = true;
        this.T = f2;
        this.Q = f2;
        this.S = -1L;
        this.O = -1L;
        this.z = null;
        this.V = true;
        invalidate();
    }

    public void setScene(androidx.constraintlayout.motion.widget.i iVar) {
        this.y = iVar;
        iVar.W(r());
        v0();
    }

    void setStartState(int i2) {
        if (isAttachedToWindow()) {
            this.I = i2;
            return;
        }
        if (this.O0 == null) {
            this.O0 = new i();
        }
        this.O0.f(i2);
        this.O0.d(i2);
    }

    void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.I == -1) {
            return;
        }
        TransitionState transitionState3 = this.a1;
        this.a1 = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            i0();
        }
        int i2 = c.a[transitionState3.ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3 && transitionState == transitionState2) {
                j0();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            i0();
        }
        if (transitionState == transitionState2) {
            j0();
        }
    }

    public void setTransition(int i2) {
        float f2;
        if (this.y != null) {
            androidx.constraintlayout.motion.widget.i.b bVarN0 = n0(i2);
            this.H = bVarN0.A();
            this.J = bVarN0.y();
            if (!isAttachedToWindow()) {
                if (this.O0 == null) {
                    this.O0 = new i();
                }
                this.O0.f(this.H);
                this.O0.d(this.J);
                return;
            }
            int i3 = this.I;
            if (i3 == this.H) {
                f2 = 0.0f;
            } else {
                f2 = i3 == this.J ? 1.0f : Float.NaN;
            }
            this.y.Y(bVarN0);
            this.b1.e(this.c, this.y.l(this.H), this.y.l(this.J));
            v0();
            if (this.R != f2) {
                if (f2 == 0.0f) {
                    f0(true);
                    this.y.l(this.H).i(this);
                } else if (f2 == 1.0f) {
                    f0(false);
                    this.y.l(this.J).i(this);
                }
            }
            this.R = Float.isNaN(f2) ? 0.0f : f2;
            if (!Float.isNaN(f2)) {
                setProgress(f2);
                return;
            }
            Log.v("MotionLayout", d70.b() + " transitionToStart ");
            E0();
        }
    }

    public void setTransitionDuration(int i2) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            iVar.V(i2);
        }
    }

    public void setTransitionListener(j jVar) {
        this.a0 = jVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.O0 == null) {
            this.O0 = new i();
        }
        this.O0.g(bundle);
        if (isAttachedToWindow()) {
            this.O0.a();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void t(int i2) {
        this.k = null;
    }

    void t0() {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            return;
        }
        if (iVar.h(this, this.I)) {
            requestLayout();
            return;
        }
        int i2 = this.I;
        if (i2 != -1) {
            this.y.f(this, i2);
        }
        if (this.y.b0()) {
            this.y.Z();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return d70.c(context, this.H) + "->" + d70.c(context, this.J) + " (pos:" + this.R + " Dpos/Dt:" + this.G;
    }

    public void v0() {
        this.b1.h();
        invalidate();
    }

    public void w0(float f2, float f3) {
        if (!isAttachedToWindow()) {
            if (this.O0 == null) {
                this.O0 = new i();
            }
            this.O0.e(f2);
            this.O0.h(f3);
            return;
        }
        setProgress(f2);
        setState(TransitionState.MOVING);
        this.G = f3;
        if (f3 != 0.0f) {
            Y(f3 > 0.0f ? 1.0f : 0.0f);
        } else {
            if (f2 == 0.0f || f2 == 1.0f) {
                return;
            }
            Y(f2 > 0.5f ? 1.0f : 0.0f);
        }
    }

    public void x0(int i2, int i3, int i4) {
        setState(TransitionState.SETUP);
        this.I = i2;
        this.H = -1;
        this.J = -1;
        androidx.constraintlayout.widget.a aVar = this.k;
        if (aVar != null) {
            aVar.d(i2, i3, i4);
            return;
        }
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            iVar.l(i2).i(this);
        }
    }

    public void y0(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.O0 == null) {
                this.O0 = new i();
            }
            this.O0.f(i2);
            this.O0.d(i3);
            return;
        }
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            this.H = i2;
            this.J = i3;
            iVar.X(i2, i3);
            this.b1.e(this.c, this.y.l(i2), this.y.l(i3));
            v0();
            this.R = 0.0f;
            E0();
        }
    }

    protected void setTransition(androidx.constraintlayout.motion.widget.i.b bVar) {
        this.y.Y(bVar);
        setState(TransitionState.SETUP);
        if (this.I == this.y.q()) {
            this.R = 1.0f;
            this.Q = 1.0f;
            this.T = 1.0f;
        } else {
            this.R = 0.0f;
            this.Q = 0.0f;
            this.T = 0.0f;
        }
        this.S = bVar.D(1) ? -1L : getNanoTime();
        int iF = this.y.F();
        int iQ = this.y.q();
        if (iF == this.H && iQ == this.J) {
            return;
        }
        this.H = iF;
        this.J = iQ;
        this.y.X(iF, iQ);
        this.b1.e(this.c, this.y.l(this.H), this.y.l(this.J));
        this.b1.i(this.H, this.J);
        this.b1.h();
        v0();
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = null;
        this.G = 0.0f;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.M = true;
        this.N = new HashMap();
        this.O = 0L;
        this.P = 1.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.T = 0.0f;
        this.V = false;
        this.W = false;
        this.d0 = 0;
        this.f0 = false;
        this.g0 = new pu2();
        this.h0 = new d();
        this.j0 = true;
        this.o0 = false;
        this.t0 = false;
        this.u0 = null;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = 0;
        this.z0 = -1L;
        this.A0 = 0.0f;
        this.B0 = 0;
        this.C0 = 0.0f;
        this.D0 = false;
        this.E0 = false;
        this.M0 = new x81();
        this.N0 = false;
        this.P0 = null;
        this.Q0 = null;
        this.R0 = 0;
        this.S0 = false;
        this.T0 = 0;
        this.U0 = new HashMap();
        this.Y0 = new Rect();
        this.Z0 = false;
        this.a1 = TransitionState.UNDEFINED;
        this.b1 = new f();
        this.c1 = false;
        this.d1 = new RectF();
        this.e1 = null;
        this.f1 = null;
        this.g1 = new ArrayList();
        q0(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.F = null;
        this.G = 0.0f;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.M = true;
        this.N = new HashMap();
        this.O = 0L;
        this.P = 1.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.T = 0.0f;
        this.V = false;
        this.W = false;
        this.d0 = 0;
        this.f0 = false;
        this.g0 = new pu2();
        this.h0 = new d();
        this.j0 = true;
        this.o0 = false;
        this.t0 = false;
        this.u0 = null;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = 0;
        this.z0 = -1L;
        this.A0 = 0.0f;
        this.B0 = 0;
        this.C0 = 0.0f;
        this.D0 = false;
        this.E0 = false;
        this.M0 = new x81();
        this.N0 = false;
        this.P0 = null;
        this.Q0 = null;
        this.R0 = 0;
        this.S0 = false;
        this.T0 = 0;
        this.U0 = new HashMap();
        this.Y0 = new Rect();
        this.Z0 = false;
        this.a1 = TransitionState.UNDEFINED;
        this.b1 = new f();
        this.c1 = false;
        this.d1 = new RectF();
        this.e1 = null;
        this.f1 = null;
        this.g1 = new ArrayList();
        q0(attributeSet);
    }
}
