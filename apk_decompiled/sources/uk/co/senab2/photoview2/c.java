package uk.co.senab2.photoview2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import defpackage.bd1;
import defpackage.bv1;
import defpackage.nb3;
import defpackage.nl2;
import defpackage.nt0;
import defpackage.s00;
import java.lang.ref.WeakReference;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public class c implements uk.co.senab2.photoview2.b, View.OnTouchListener, bv1, ViewTreeObserver.OnGlobalLayoutListener {
    private static final boolean G = Log.isLoggable("PhotoViewAttacher", 3);
    static int H = 1;
    private ImageView.ScaleType F;
    private Interpolator a;
    int b;
    private float c;
    private float d;
    private float e;
    private boolean f;
    private boolean g;
    private WeakReference h;
    private GestureDetector i;
    private nt0 j;
    private final Matrix k;
    private final Matrix l;
    private final Matrix m;
    private final RectF n;
    private final float[] o;
    private f p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private i f392q;
    private View.OnLongClickListener r;
    private int s;
    private int t;
    private int u;
    private int v;
    private d w;
    private int x;
    private float y;
    private boolean z;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            c.e(c.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (c.this.r == null || c.this.u().getY() != 0.0f) {
                return;
            }
            c.this.r.onLongClick(c.this.u());
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
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
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: uk.co.senab2.photoview2.c$c, reason: collision with other inner class name */
    private class RunnableC0174c implements Runnable {
        private final float a;
        private final float b;
        private final long c = System.currentTimeMillis();
        private final float d;
        private final float e;

        public RunnableC0174c(float f, float f2, float f3, float f4) {
            this.a = f3;
            this.b = f4;
            this.d = f;
            this.e = f2;
        }

        private float a() {
            return c.this.a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.c) * 1.0f) / c.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageViewU = c.this.u();
            if (imageViewU == null) {
                return;
            }
            float fA = a();
            float f = this.d;
            c.this.a((f + ((this.e - f) * fA)) / c.this.C(), this.a, this.b);
            if (fA < 1.0f) {
                s00.c(imageViewU, this);
            }
        }
    }

    private class d implements Runnable {
        private final nl2 a;
        private int b;
        private int c;

        public d(Context context) {
            this.a = nl2.f(context);
        }

        public void a() {
            if (c.G) {
                bd1.a().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.a.c(true);
        }

        public void b(int i, int i2, int i3, int i4) {
            int i5;
            int iRound;
            int i6;
            int iRound2;
            RectF rectFQ = c.this.q();
            if (rectFQ == null) {
                return;
            }
            int iRound3 = Math.round(-rectFQ.left);
            float f = i;
            if (f < rectFQ.width()) {
                iRound = Math.round(rectFQ.width() - f);
                i5 = 0;
            } else {
                i5 = iRound3;
                iRound = i5;
            }
            int iRound4 = Math.round(-rectFQ.top);
            float f2 = i2;
            if (f2 < rectFQ.height()) {
                iRound2 = Math.round(rectFQ.height() - f2);
                i6 = 0;
            } else {
                i6 = iRound4;
                iRound2 = i6;
            }
            this.b = iRound3;
            this.c = iRound4;
            if (c.G) {
                bd1.a().d("PhotoViewAttacher", "fling. StartX:" + iRound3 + " StartY:" + iRound4 + " MaxX:" + iRound + " MaxY:" + iRound2);
            }
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.a.b(iRound3, iRound4, i3, i4, i5, iRound, i6, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageViewU;
            if (this.a.g() || (imageViewU = c.this.u()) == null || !this.a.a()) {
                return;
            }
            int iD = this.a.d();
            int iE = this.a.e();
            if (c.G) {
                bd1.a().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.b + " CurrentY:" + this.c + " NewX:" + iD + " NewY:" + iE);
            }
            c.this.m.postTranslate(this.b - iD, this.c - iE);
            c cVar = c.this;
            cVar.K(cVar.s());
            this.b = iD;
            this.c = iE;
            s00.c(imageViewU, this);
        }
    }

    public interface e {
    }

    public interface f {
        void a(View view, float f, float f2);

        void b();
    }

    public interface g {
    }

    public interface h {
    }

    public interface i {
        void a(View view, float f, float f2);
    }

    public c(ImageView imageView) {
        this(imageView, true);
    }

    private float E(Matrix matrix, int i2) {
        matrix.getValues(this.o);
        return this.o[i2];
    }

    private static boolean G(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean H(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (b.a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Matrix matrix) {
        ImageView imageViewU = u();
        if (imageViewU != null) {
            m();
            imageViewU.setImageMatrix(matrix);
        }
    }

    private static void L(ImageView imageView) {
        if (imageView == null || (imageView instanceof uk.co.senab2.photoview2.b)) {
            return;
        }
        ImageView.ScaleType scaleType = ImageView.ScaleType.MATRIX;
        if (scaleType.equals(imageView.getScaleType())) {
            return;
        }
        imageView.setScaleType(scaleType);
    }

    static /* synthetic */ h e(c cVar) {
        cVar.getClass();
        return null;
    }

    private void f0(Drawable drawable) {
        ImageView imageViewU = u();
        if (imageViewU == null || drawable == null) {
            return;
        }
        float fW = w(imageViewU);
        float fV = v(imageViewU);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.k.reset();
        float f2 = intrinsicWidth;
        float f3 = fW / f2;
        float f4 = intrinsicHeight;
        float f5 = fV / f4;
        ImageView.ScaleType scaleType = this.F;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.k.postTranslate((fW - f2) / 2.0f, (fV - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.k.postScale(fMax, fMax);
            this.k.postTranslate((fW - (f2 * fMax)) / 2.0f, (fV - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.k.postScale(fMin, fMin);
            this.k.postTranslate((fW - (f2 * fMin)) / 2.0f, (fV - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fW, fV);
            if (((int) this.y) % Opcodes.GETFIELD != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = b.a[this.F.ordinal()];
            if (i2 == 2) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i2 == 3) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i2 == 4) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i2 == 5) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        I();
    }

    private void k() {
        d dVar = this.w;
        if (dVar != null) {
            dVar.a();
            this.w = null;
        }
    }

    private void l() {
        if (n()) {
            K(s());
        }
    }

    private void m() {
        ImageView imageViewU = u();
        if (imageViewU != null && !(imageViewU instanceof uk.co.senab2.photoview2.b) && !ImageView.ScaleType.MATRIX.equals(imageViewU.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher. You should call setScaleType on the PhotoViewAttacher instead of on the ImageView");
        }
    }

    private boolean n() {
        RectF rectFR;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        ImageView imageViewU = u();
        if (imageViewU == null || (rectFR = r(s())) == null) {
            return false;
        }
        float fHeight = rectFR.height();
        float fWidth = rectFR.width();
        float fV = v(imageViewU);
        float f8 = 0.0f;
        if (fHeight <= fV) {
            int i2 = b.a[this.F.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    fV = (fV - fHeight) / 2.0f;
                    f3 = rectFR.top;
                } else {
                    fV -= fHeight;
                    f3 = rectFR.top;
                }
            } else {
                f2 = rectFR.top;
                f4 = -f2;
            }
        } else {
            f2 = rectFR.top;
            if (f2 > 0.0f) {
                f4 = -f2;
            } else {
                f3 = rectFR.bottom;
                f4 = f3 < fV ? fV - f3 : 0.0f;
            }
        }
        float fW = w(imageViewU);
        if (fWidth <= fW) {
            int i3 = b.a[this.F.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f6 = (fW - fWidth) / 2.0f;
                    f7 = rectFR.left;
                } else {
                    f6 = fW - fWidth;
                    f7 = rectFR.left;
                }
                f5 = f6 - f7;
            } else {
                f5 = -rectFR.left;
            }
            f8 = f5;
            this.x = 2;
        } else {
            float f9 = rectFR.left;
            if (f9 > 0.0f) {
                this.x = 0;
                f8 = -f9;
            } else {
                float f10 = rectFR.right;
                if (f10 < fW) {
                    f8 = fW - f10;
                    this.x = 1;
                } else {
                    this.x = -1;
                }
            }
        }
        this.m.postTranslate(f8, f4);
        return true;
    }

    private static void o(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    private RectF r(Matrix matrix) {
        Drawable drawable;
        ImageView imageViewU = u();
        if (imageViewU == null || (drawable = imageViewU.getDrawable()) == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Matrix s() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    private int v(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private int w(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    f A() {
        return this.p;
    }

    i B() {
        return this.f392q;
    }

    public float C() {
        return (float) Math.sqrt(((float) Math.pow(E(this.m, 0), 2.0d)) + ((float) Math.pow(E(this.m, 3), 2.0d)));
    }

    public ImageView.ScaleType D() {
        return this.F;
    }

    public Bitmap F() {
        ImageView imageViewU = u();
        if (imageViewU == null) {
            return null;
        }
        return imageViewU.getDrawingCache();
    }

    public void I() {
        this.m.reset();
        W(this.y);
        K(s());
        n();
    }

    public void J(boolean z) {
        this.f = z;
    }

    public void M(float f2) {
        o(this.c, this.d, f2);
        this.e = f2;
    }

    public void N(float f2) {
        o(this.c, f2, this.e);
        this.d = f2;
    }

    public void O(float f2) {
        o(f2, this.d, this.e);
        this.c = f2;
    }

    public void P(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.i.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.i.setOnDoubleTapListener(new uk.co.senab2.photoview2.a(this));
        }
    }

    public void Q(View.OnLongClickListener onLongClickListener) {
        this.r = onLongClickListener;
    }

    public void R(e eVar) {
    }

    public void S(f fVar) {
    }

    public void T(g gVar) {
    }

    public void U(h hVar) {
    }

    public void V(i iVar) {
        this.f392q = iVar;
    }

    public void W(float f2) {
        this.m.postRotate(f2 % 360.0f);
        l();
    }

    public void X(float f2) {
        this.m.setRotate(f2 % 360.0f);
        l();
    }

    public void Y(float f2) {
        a0(f2, false);
    }

    public void Z(float f2, float f3, float f4, boolean z) {
        ImageView imageViewU = u();
        if (imageViewU != null) {
            if (f2 < this.c || f2 > this.e) {
                bd1.a().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                imageViewU.post(new RunnableC0174c(C(), f2, f3, f4));
            } else {
                this.m.setScale(f2, f2, f3, f4);
                l();
            }
        }
    }

    @Override // defpackage.bv1
    public void a(float f2, float f3, float f4) {
        if (G) {
            bd1.a().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (C() < this.e || f2 < 1.0f) {
            if (C() > this.c || f2 > 1.0f) {
                this.m.postScale(f2, f2, f3, f4);
                l();
            }
        }
    }

    public void a0(float f2, boolean z) {
        ImageView imageViewU = u();
        if (imageViewU != null) {
            Z(f2, imageViewU.getRight() / 2, imageViewU.getBottom() / 2, z);
        }
    }

    @Override // defpackage.bv1
    public void b(float f2, float f3, float f4, float f5) {
        if (G) {
            bd1.a().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView imageViewU = u();
        d dVar = new d(imageViewU.getContext());
        this.w = dVar;
        dVar.b(w(imageViewU), v(imageViewU), (int) f4, (int) f5);
        imageViewU.post(this.w);
    }

    public void b0(ImageView.ScaleType scaleType) {
        if (!H(scaleType) || scaleType == this.F) {
            return;
        }
        this.F = scaleType;
        e0();
    }

    @Override // defpackage.bv1
    public void c(float f2, float f3) {
        if (this.j.d()) {
            return;
        }
        if (G) {
            bd1.a().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
        }
        ImageView imageViewU = u();
        this.m.postTranslate(f2, f3);
        l();
        ViewParent parent = imageViewU.getParent();
        if (!this.f || this.j.d() || this.g) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i2 = this.x;
        if ((i2 == 2 || ((i2 == 0 && f2 >= 1.0f) || (i2 == 1 && f2 <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public void c0(int i2) {
        if (i2 < 0) {
            i2 = 200;
        }
        this.b = i2;
    }

    public void d0(boolean z) {
        this.z = z;
        e0();
    }

    public void e0() {
        ImageView imageViewU = u();
        if (imageViewU != null) {
            if (!this.z) {
                I();
            } else {
                L(imageViewU);
                f0(imageViewU.getDrawable());
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView imageViewU = u();
        if (imageViewU != null) {
            if (!this.z) {
                f0(imageViewU.getDrawable());
                return;
            }
            int top = imageViewU.getTop();
            int right = imageViewU.getRight();
            int bottom = imageViewU.getBottom();
            int left = imageViewU.getLeft();
            if (top == this.s && bottom == this.u && left == this.v && right == this.t) {
                return;
            }
            f0(imageViewU.getDrawable());
            this.s = top;
            this.t = right;
            this.u = bottom;
            this.v = left;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    /* JADX WARN: Code duplicated, block: B:34:0x008b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0095  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        nt0 nt0Var;
        boolean z2;
        GestureDetector gestureDetector;
        boolean zD;
        boolean zC;
        boolean z3;
        boolean z4;
        RectF rectFQ;
        boolean z5 = false;
        if (!this.z || !G((ImageView) view)) {
            return false;
        }
        ViewParent parent = view.getParent();
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && C() < this.c && (rectFQ = q()) != null) {
                view.post(new RunnableC0174c(C(), this.c, rectFQ.centerX(), rectFQ.centerY()));
                z = true;
            }
            nt0Var = this.j;
            if (nt0Var != null) {
                zD = nt0Var.d();
                zC = this.j.c();
                boolean zB = this.j.b(motionEvent);
                if (!zD || this.j.d()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!zC || this.j.c()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z3 && z4) {
                    z5 = true;
                }
                this.g = z5;
                z2 = zB;
            } else {
                z2 = z;
            }
            gestureDetector = this.i;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else {
            bd1.a().i("PhotoViewAttacher", "onTouch getParent() returned null");
        }
        k();
        z = false;
        nt0Var = this.j;
        if (nt0Var != null) {
            zD = nt0Var.d();
            zC = this.j.c();
            boolean zB2 = this.j.b(motionEvent);
            if (zD) {
                z3 = false;
            } else {
                z3 = false;
            }
            if (zC) {
                z4 = false;
            } else {
                z4 = false;
            }
            if (z3) {
                z5 = true;
            }
            this.g = z5;
            z2 = zB2;
        } else {
            z2 = z;
        }
        gestureDetector = this.i;
        return gestureDetector == null ? z2 : z2;
    }

    public void p() {
        WeakReference weakReference = this.h;
        if (weakReference == null) {
            return;
        }
        ImageView imageView = (ImageView) weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
            imageView.setOnTouchListener(null);
            k();
        }
        GestureDetector gestureDetector = this.i;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        this.f392q = null;
        this.h = null;
    }

    public RectF q() {
        n();
        return r(s());
    }

    public Matrix t() {
        return this.l;
    }

    public ImageView u() {
        WeakReference weakReference = this.h;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        if (imageView == null) {
            p();
            bd1.a().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float x() {
        return this.e;
    }

    public float y() {
        return this.d;
    }

    public float z() {
        return this.c;
    }

    public c(ImageView imageView, boolean z) {
        this.a = new AccelerateDecelerateInterpolator();
        this.b = 200;
        this.c = 1.0f;
        this.d = 1.75f;
        this.e = 3.0f;
        this.f = true;
        this.g = false;
        this.k = new Matrix();
        this.l = new Matrix();
        this.m = new Matrix();
        this.n = new RectF();
        this.o = new float[9];
        this.x = 2;
        this.F = ImageView.ScaleType.FIT_CENTER;
        this.h = new WeakReference(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        L(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.j = nb3.a(imageView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new a());
        this.i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new uk.co.senab2.photoview2.a(this));
        this.y = 0.0f;
        d0(z);
    }
}
