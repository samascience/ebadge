package defpackage;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class l02 implements View.OnTouchListener, View.OnLayoutChangeListener {
    private final ImageView h;
    private GestureDetector i;
    private l50 j;
    private mw1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View.OnClickListener f350q;
    private View.OnLongClickListener r;
    private f s;
    private float v;
    private final cv1 y;
    private Interpolator a = new AccelerateDecelerateInterpolator();
    private int b = 200;
    private float c = 1.0f;
    private float d = 1.75f;
    private float e = 3.0f;
    private boolean f = true;
    private boolean g = false;
    private final Matrix k = new Matrix();
    private final Matrix l = new Matrix();
    private final Matrix m = new Matrix();
    private final RectF n = new RectF();
    private final float[] o = new float[9];
    private int t = 2;
    private int u = 2;
    private boolean w = true;
    private ImageView.ScaleType x = ImageView.ScaleType.FIT_CENTER;

    class a implements cv1 {
        a() {
        }

        @Override // defpackage.cv1
        public void a(float f, float f2, float f3) {
            d(f, f2, f3, 0.0f, 0.0f);
        }

        @Override // defpackage.cv1
        public void b(float f, float f2, float f3, float f4) {
            l02 l02Var = l02.this;
            l02Var.s = l02Var.new f(l02Var.h.getContext());
            f fVar = l02.this.s;
            l02 l02Var2 = l02.this;
            int iG = l02Var2.G(l02Var2.h);
            l02 l02Var3 = l02.this;
            fVar.b(iG, l02Var3.F(l02Var3.h), (int) f3, (int) f4);
            l02.this.h.post(l02.this.s);
        }

        @Override // defpackage.cv1
        public void c(float f, float f2) {
            if (l02.this.j.e()) {
                return;
            }
            l02.b(l02.this);
            l02.this.m.postTranslate(f, f2);
            l02.this.z();
            ViewParent parent = l02.this.h.getParent();
            if (!l02.this.f || l02.this.j.e() || l02.this.g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((l02.this.t == 2 || ((l02.this.t == 0 && f >= 1.0f) || ((l02.this.t == 1 && f <= -1.0f) || ((l02.this.u == 0 && f2 >= 1.0f) || (l02.this.u == 1 && f2 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // defpackage.cv1
        public void d(float f, float f2, float f3, float f4, float f5) {
            if (l02.this.K() < l02.this.e || f < 1.0f) {
                l02.f(l02.this);
                l02.this.m.postScale(f, f, f2, f3);
                l02.this.m.postTranslate(f4, f5);
                l02.this.z();
            }
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l02.h(l02.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (l02.this.r != null) {
                l02.this.r.onLongClick(l02.this.h);
            }
        }
    }

    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fK = l02.this.K();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (fK < l02.this.I()) {
                    l02 l02Var = l02.this;
                    l02Var.g0(l02Var.I(), x, y, true);
                } else if (fK < l02.this.I() || fK >= l02.this.H()) {
                    l02 l02Var2 = l02.this;
                    l02Var2.g0(l02Var2.J(), x, y, true);
                } else {
                    l02 l02Var3 = l02.this;
                    l02Var3.g0(l02Var3.H(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (l02.this.f350q != null) {
                l02.this.f350q.onClick(l02.this.h);
            }
            RectF rectFB = l02.this.B();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (l02.this.p != null) {
                l02.this.p.a(l02.this.h, x, y);
            }
            if (rectFB == null) {
                return false;
            }
            if (!rectFB.contains(x, y)) {
                l02.l(l02.this);
                return false;
            }
            rectFB.width();
            rectFB.height();
            l02.k(l02.this);
            return true;
        }
    }

    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private class e implements Runnable {
        private final float a;
        private final float b;
        private final long c = System.currentTimeMillis();
        private final float d;
        private final float e;

        public e(float f, float f2, float f3, float f4) {
            this.a = f3;
            this.b = f4;
            this.d = f;
            this.e = f2;
        }

        private float a() {
            return l02.this.a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.c) * 1.0f) / l02.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f = this.d;
            l02.this.y.a((f + ((this.e - f) * fA)) / l02.this.K(), this.a, this.b);
            if (fA < 1.0f) {
                t00.a(l02.this.h, this);
            }
        }
    }

    private class f implements Runnable {
        private final OverScroller a;
        private int b;
        private int c;

        public f(Context context) {
            this.a = new OverScroller(context);
        }

        public void a() {
            this.a.forceFinished(true);
        }

        public void b(int i, int i2, int i3, int i4) {
            int i5;
            int iRound;
            int i6;
            int iRound2;
            RectF rectFB = l02.this.B();
            if (rectFB == null) {
                return;
            }
            int iRound3 = Math.round(-rectFB.left);
            float f = i;
            if (f < rectFB.width()) {
                iRound = Math.round(rectFB.width() - f);
                i5 = 0;
            } else {
                i5 = iRound3;
                iRound = i5;
            }
            int iRound4 = Math.round(-rectFB.top);
            float f2 = i2;
            if (f2 < rectFB.height()) {
                iRound2 = Math.round(rectFB.height() - f2);
                i6 = 0;
            } else {
                i6 = iRound4;
                iRound2 = i6;
            }
            this.b = iRound3;
            this.c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.a.fling(iRound3, iRound4, i3, i4, i5, iRound, i6, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isFinished() && this.a.computeScrollOffset()) {
                int currX = this.a.getCurrX();
                int currY = this.a.getCurrY();
                l02.this.m.postTranslate(this.b - currX, this.c - currY);
                l02.this.z();
                this.b = currX;
                this.c = currY;
                t00.a(l02.this.h, this);
            }
        }
    }

    public l02(ImageView imageView) {
        a aVar = new a();
        this.y = aVar;
        this.h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.v = 0.0f;
        this.j = new l50(imageView.getContext(), aVar);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private boolean A() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF rectFC = C(D());
        if (rectFC == null) {
            return false;
        }
        float fHeight = rectFC.height();
        float fWidth = rectFC.width();
        float F = F(this.h);
        float f7 = 0.0f;
        if (fHeight <= F) {
            int i = d.a[this.x.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f5 = (F - fHeight) / 2.0f;
                    f6 = rectFC.top;
                } else {
                    f5 = F - fHeight;
                    f6 = rectFC.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -rectFC.top;
            }
            this.u = 2;
        } else {
            float f8 = rectFC.top;
            if (f8 > 0.0f) {
                this.u = 0;
                f2 = -f8;
            } else {
                float f9 = rectFC.bottom;
                if (f9 < F) {
                    this.u = 1;
                    f2 = F - f9;
                } else {
                    this.u = -1;
                    f2 = 0.0f;
                }
            }
        }
        float fG = G(this.h);
        if (fWidth <= fG) {
            int i2 = d.a[this.x.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f3 = (fG - fWidth) / 2.0f;
                    f4 = rectFC.left;
                } else {
                    f3 = fG - fWidth;
                    f4 = rectFC.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -rectFC.left;
            }
            this.t = 2;
        } else {
            float f10 = rectFC.left;
            if (f10 > 0.0f) {
                this.t = 0;
                f7 = -f10;
            } else {
                float f11 = rectFC.right;
                if (f11 < fG) {
                    f7 = fG - f11;
                    this.t = 1;
                } else {
                    this.t = -1;
                }
            }
        }
        this.m.postTranslate(f7, f2);
        return true;
    }

    private RectF C(Matrix matrix) {
        Drawable drawable = this.h.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    private Matrix D() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float M(Matrix matrix, int i) {
        matrix.getValues(this.o);
        return this.o[i];
    }

    private void N() {
        this.m.reset();
        d0(this.v);
        P(D());
        A();
    }

    private void P(Matrix matrix) {
        this.h.setImageMatrix(matrix);
    }

    static /* synthetic */ lw1 b(l02 l02Var) {
        l02Var.getClass();
        return null;
    }

    static /* synthetic */ fw1 f(l02 l02Var) {
        l02Var.getClass();
        return null;
    }

    static /* synthetic */ iw1 h(l02 l02Var) {
        l02Var.getClass();
        return null;
    }

    static /* synthetic */ tv1 k(l02 l02Var) {
        l02Var.getClass();
        return null;
    }

    static /* synthetic */ qv1 l(l02 l02Var) {
        l02Var.getClass();
        return null;
    }

    private void m0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fG = G(this.h);
        float F = F(this.h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.k.reset();
        float f2 = intrinsicWidth;
        float f3 = fG / f2;
        float f4 = intrinsicHeight;
        float f5 = F / f4;
        ImageView.ScaleType scaleType = this.x;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.k.postTranslate((fG - f2) / 2.0f, (F - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.k.postScale(fMax, fMax);
            this.k.postTranslate((fG - (f2 * fMax)) / 2.0f, (F - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.k.postScale(fMin, fMin);
            this.k.postTranslate((fG - (f2 * fMin)) / 2.0f, (F - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fG, F);
            if (((int) this.v) % Opcodes.GETFIELD != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i = d.a[this.x.ordinal()];
            if (i == 1) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        N();
    }

    private void y() {
        f fVar = this.s;
        if (fVar != null) {
            fVar.a();
            this.s = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (A()) {
            P(D());
        }
    }

    public RectF B() {
        A();
        return C(D());
    }

    public Matrix E() {
        return this.l;
    }

    public float H() {
        return this.e;
    }

    public float I() {
        return this.d;
    }

    public float J() {
        return this.c;
    }

    public float K() {
        return (float) Math.sqrt(((float) Math.pow(M(this.m, 0), 2.0d)) + ((float) Math.pow(M(this.m, 3), 2.0d)));
    }

    public ImageView.ScaleType L() {
        return this.x;
    }

    public void O(boolean z) {
        this.f = z;
    }

    public void Q(float f2) {
        oa3.a(this.c, this.d, f2);
        this.e = f2;
    }

    public void R(float f2) {
        oa3.a(this.c, f2, this.e);
        this.d = f2;
    }

    public void S(float f2) {
        oa3.a(f2, this.d, this.e);
        this.c = f2;
    }

    public void T(View.OnClickListener onClickListener) {
        this.f350q = onClickListener;
    }

    public void U(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void V(View.OnLongClickListener onLongClickListener) {
        this.r = onLongClickListener;
    }

    public void W(nv1 nv1Var) {
    }

    public void X(qv1 qv1Var) {
    }

    public void Y(tv1 tv1Var) {
    }

    public void Z(fw1 fw1Var) {
    }

    public void a0(iw1 iw1Var) {
    }

    public void b0(lw1 lw1Var) {
    }

    public void c0(mw1 mw1Var) {
        this.p = mw1Var;
    }

    public void d0(float f2) {
        this.m.postRotate(f2 % 360.0f);
        z();
    }

    public void e0(float f2) {
        this.m.setRotate(f2 % 360.0f);
        z();
    }

    public void f0(float f2) {
        h0(f2, false);
    }

    public void g0(float f2, float f3, float f4, boolean z) {
        if (f2 < this.c || f2 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.h.post(new e(K(), f2, f3, f4));
        } else {
            this.m.setScale(f2, f2, f3, f4);
            z();
        }
    }

    public void h0(float f2, boolean z) {
        g0(f2, this.h.getRight() / 2, this.h.getBottom() / 2, z);
    }

    public void i0(ImageView.ScaleType scaleType) {
        if (!oa3.d(scaleType) || scaleType == this.x) {
            return;
        }
        this.x = scaleType;
        l0();
    }

    public void j0(int i) {
        this.b = i;
    }

    public void k0(boolean z) {
        this.w = z;
        l0();
    }

    public void l0() {
        if (this.w) {
            m0(this.h.getDrawable());
        } else {
            N();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        m0(this.h.getDrawable());
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:35:0x009b  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        l50 l50Var;
        boolean z2;
        GestureDetector gestureDetector;
        boolean zE;
        boolean zD;
        boolean z3;
        boolean z4;
        RectF rectFB;
        boolean z5 = false;
        if (!this.w || !oa3.c((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (K() < this.c) {
                    RectF rectFB2 = B();
                    if (rectFB2 != null) {
                        view.post(new e(K(), this.c, rectFB2.centerX(), rectFB2.centerY()));
                        z = true;
                    }
                } else if (K() > this.e && (rectFB = B()) != null) {
                    view.post(new e(K(), this.e, rectFB.centerX(), rectFB.centerY()));
                    z = true;
                }
            }
            l50Var = this.j;
            if (l50Var != null) {
                zE = l50Var.e();
                zD = this.j.d();
                boolean zF = this.j.f(motionEvent);
                if (!zE || this.j.e()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!zD || this.j.d()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z3 && z4) {
                    z5 = true;
                }
                this.g = z5;
                z2 = zF;
            } else {
                z2 = z;
            }
            gestureDetector = this.i;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        y();
        z = false;
        l50Var = this.j;
        if (l50Var != null) {
            zE = l50Var.e();
            zD = this.j.d();
            boolean zF2 = this.j.f(motionEvent);
            if (zE) {
                z3 = false;
            } else {
                z3 = false;
            }
            if (zD) {
                z4 = false;
            } else {
                z4 = false;
            }
            if (z3) {
                z5 = true;
            }
            this.g = z5;
            z2 = zF2;
        } else {
            z2 = z;
        }
        gestureDetector = this.i;
        return gestureDetector == null ? z2 : z2;
    }
}
