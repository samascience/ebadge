package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.luck.picture.lib.R$styleable;
import defpackage.a01;
import defpackage.dj0;
import defpackage.p70;
import defpackage.u00;
import defpackage.z01;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class SubsamplingScaleImageView extends View {
    private static final List A0 = Arrays.asList(0, 90, Integer.valueOf(Opcodes.GETFIELD), 270, -1);
    private static final List B0 = Arrays.asList(1, 2, 3);
    private static final List C0 = Arrays.asList(2, 1);
    private static final List D0 = Arrays.asList(1, 2, 3);
    private static final List E0 = Arrays.asList(2, 1, 3, 4);
    private static Bitmap.Config F0 = null;
    private static final String z0 = "SubsamplingScaleImageView";
    private PointF F;
    private PointF G;
    private Float H;
    private PointF I;
    private PointF J;
    private int K;
    private int L;
    private int M;
    private Rect N;
    private Rect O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private GestureDetector T;
    private GestureDetector U;
    private z01 V;
    private final ReadWriteLock W;
    private Bitmap a;
    private p70 a0;
    private boolean b;
    private p70 b0;
    private boolean c;
    private PointF c0;
    private Uri d;
    private float d0;
    private int e;
    private final float e0;
    private Map f;
    private float f0;
    private boolean g;
    private boolean g0;
    private int h;
    private PointF h0;
    private float i;
    private PointF i0;
    private float j;
    private PointF j0;
    private int k;
    private d k0;
    private int l;
    private boolean l0;
    private int m;
    private boolean m0;
    private int n;
    private View.OnLongClickListener n0;
    private int o;
    private final Handler o0;
    private Executor p;
    private Paint p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f301q;
    private Paint q0;
    private boolean r;
    private Paint r0;
    private boolean s;
    private Paint s0;
    private boolean t;
    private j t0;
    private float u;
    private Matrix u0;
    private int v;
    private RectF v0;
    private int w;
    private final float[] w0;
    private float x;
    private final float[] x0;
    private float y;
    private final float y0;
    private PointF z;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && SubsamplingScaleImageView.this.n0 != null) {
                SubsamplingScaleImageView.this.S = 0;
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.n0);
                SubsamplingScaleImageView.this.performLongClick();
                SubsamplingScaleImageView.super.setOnLongClickListener(null);
            }
            return true;
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!SubsamplingScaleImageView.this.s || !SubsamplingScaleImageView.this.l0 || SubsamplingScaleImageView.this.z == null) {
                return super.onDoubleTapEvent(motionEvent);
            }
            SubsamplingScaleImageView.this.setGestureDetector(this.a);
            if (!SubsamplingScaleImageView.this.t) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                subsamplingScaleImageView.W(subsamplingScaleImageView.Q0(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
            SubsamplingScaleImageView.this.c0 = new PointF(motionEvent.getX(), motionEvent.getY());
            SubsamplingScaleImageView.this.F = new PointF(SubsamplingScaleImageView.this.z.x, SubsamplingScaleImageView.this.z.y);
            SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
            subsamplingScaleImageView2.y = subsamplingScaleImageView2.x;
            SubsamplingScaleImageView.this.R = true;
            SubsamplingScaleImageView.this.P = true;
            SubsamplingScaleImageView.this.f0 = -1.0f;
            SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
            subsamplingScaleImageView3.i0 = subsamplingScaleImageView3.Q0(subsamplingScaleImageView3.c0);
            SubsamplingScaleImageView.this.j0 = new PointF(motionEvent.getX(), motionEvent.getY());
            SubsamplingScaleImageView.this.h0 = new PointF(SubsamplingScaleImageView.this.i0.x, SubsamplingScaleImageView.this.i0.y);
            SubsamplingScaleImageView.this.g0 = false;
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!SubsamplingScaleImageView.this.r || !SubsamplingScaleImageView.this.l0 || SubsamplingScaleImageView.this.z == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || SubsamplingScaleImageView.this.P))) {
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            PointF pointF = new PointF(SubsamplingScaleImageView.this.z.x + (f * 0.25f), SubsamplingScaleImageView.this.z.y + (f2 * 0.25f));
            new e(SubsamplingScaleImageView.this, new PointF(((SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / SubsamplingScaleImageView.this.x, ((SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / SubsamplingScaleImageView.this.x), (a) null).e(1).h(false).g(3).c();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            SubsamplingScaleImageView.this.performClick();
            return true;
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            SubsamplingScaleImageView.this.performClick();
            return true;
        }
    }

    public final class e {
        private final float a;
        private final PointF b;
        private final PointF c;
        private long d;
        private int e;
        private int f;
        private boolean g;
        private boolean h;

        /* synthetic */ e(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2, a aVar) {
            this(f, pointF, pointF2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public e g(int i) {
            this.f = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public e h(boolean z) {
            this.h = z;
            return this;
        }

        public void c() {
            PointF pointFK0;
            if (SubsamplingScaleImageView.this.k0 != null) {
                d.c(SubsamplingScaleImageView.this.k0);
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float fL0 = SubsamplingScaleImageView.this.l0(this.a);
            if (this.h) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF = this.b;
                pointFK0 = subsamplingScaleImageView.k0(pointF.x, pointF.y, fL0, new PointF());
            } else {
                pointFK0 = this.b;
            }
            a aVar = null;
            SubsamplingScaleImageView.this.k0 = new d(aVar);
            SubsamplingScaleImageView.this.k0.a = SubsamplingScaleImageView.this.x;
            SubsamplingScaleImageView.this.k0.b = fL0;
            SubsamplingScaleImageView.this.k0.l = System.currentTimeMillis();
            SubsamplingScaleImageView.this.k0.e = pointFK0;
            SubsamplingScaleImageView.this.k0.c = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.k0.d = pointFK0;
            SubsamplingScaleImageView.this.k0.f = SubsamplingScaleImageView.this.I0(pointFK0);
            SubsamplingScaleImageView.this.k0.g = new PointF(paddingLeft, paddingTop);
            SubsamplingScaleImageView.this.k0.h = this.d;
            SubsamplingScaleImageView.this.k0.i = this.g;
            SubsamplingScaleImageView.this.k0.j = this.e;
            SubsamplingScaleImageView.this.k0.k = this.f;
            SubsamplingScaleImageView.this.k0.l = System.currentTimeMillis();
            d.d(SubsamplingScaleImageView.this.k0, null);
            PointF pointF2 = this.c;
            if (pointF2 != null) {
                float f = pointF2.x - (SubsamplingScaleImageView.this.k0.c.x * fL0);
                float f2 = this.c.y - (SubsamplingScaleImageView.this.k0.c.y * fL0);
                j jVar = new j(fL0, new PointF(f, f2), aVar);
                SubsamplingScaleImageView.this.d0(true, jVar);
                SubsamplingScaleImageView.this.k0.g = new PointF(this.c.x + (jVar.b.x - f), this.c.y + (jVar.b.y - f2));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        public e d(long j) {
            this.d = j;
            return this;
        }

        public e e(int i) {
            if (SubsamplingScaleImageView.C0.contains(Integer.valueOf(i))) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i);
        }

        public e f(boolean z) {
            this.g = z;
            return this;
        }

        /* synthetic */ e(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, a aVar) {
            this(f, pointF);
        }

        /* synthetic */ e(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, a aVar) {
            this(pointF);
        }

        private e(PointF pointF) {
            this.d = 500L;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.a = SubsamplingScaleImageView.this.x;
            this.b = pointF;
            this.c = null;
        }

        private e(float f, PointF pointF) {
            this.d = 500L;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.a = f;
            this.b = pointF;
            this.c = null;
        }

        private e(float f, PointF pointF, PointF pointF2) {
            this.d = 500L;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.a = f;
            this.b = pointF;
            this.c = pointF2;
        }
    }

    private static class f extends AsyncTask {
        private final WeakReference a;
        private final WeakReference b;
        private final WeakReference c;
        private final Uri d;
        private final boolean e;
        private Bitmap f;
        private Exception g;

        f(SubsamplingScaleImageView subsamplingScaleImageView, Context context, p70 p70Var, Uri uri, boolean z) {
            this.a = new WeakReference(subsamplingScaleImageView);
            this.b = new WeakReference(context);
            this.c = new WeakReference(p70Var);
            this.d = uri;
            this.e = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            try {
                String string = this.d.toString();
                Context context = (Context) this.b.get();
                p70 p70Var = (p70) this.c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.a.get();
                if (context == null || p70Var == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.U("BitmapLoadTask.doInBackground", new Object[0]);
                this.f = ((a01) p70Var.a()).a(context, this.d);
                return Integer.valueOf(subsamplingScaleImageView.e0(context, string));
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.z0, "Failed to load bitmap", e);
                this.g = e;
                return null;
            } catch (OutOfMemoryError e2) {
                Log.e(SubsamplingScaleImageView.z0, "Failed to load bitmap - OutOfMemoryError", e2);
                this.g = new RuntimeException(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.a.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.f;
                if (bitmap == null || num == null) {
                    if (this.g != null) {
                        SubsamplingScaleImageView.z(subsamplingScaleImageView);
                    }
                } else if (this.e) {
                    subsamplingScaleImageView.p0(bitmap);
                } else {
                    subsamplingScaleImageView.o0(bitmap, num.intValue(), false);
                }
            }
        }
    }

    public interface g {
    }

    public interface h {
    }

    public interface i {
    }

    private static class j {
        private float a;
        private final PointF b;

        /* synthetic */ j(float f, PointF pointF, a aVar) {
            this(f, pointF);
        }

        private j(float f, PointF pointF) {
            this.a = f;
            this.b = pointF;
        }
    }

    private static class k {
        private Rect a;
        private int b;
        private Bitmap c;
        private boolean d;
        private boolean e;
        private Rect f;
        private Rect g;

        private k() {
        }

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    private static class l extends AsyncTask {
        private final WeakReference a;
        private final WeakReference b;
        private final WeakReference c;
        private Exception d;

        l(SubsamplingScaleImageView subsamplingScaleImageView, z01 z01Var, k kVar) {
            this.a = new WeakReference(subsamplingScaleImageView);
            this.b = new WeakReference(z01Var);
            this.c = new WeakReference(kVar);
            kVar.d = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.a.get();
                z01 z01Var = (z01) this.b.get();
                k kVar = (k) this.c.get();
                if (z01Var == null || kVar == null || subsamplingScaleImageView == null || !z01Var.b() || !kVar.e) {
                    if (kVar == null) {
                        return null;
                    }
                    kVar.d = false;
                    return null;
                }
                subsamplingScaleImageView.U("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", kVar.a, Integer.valueOf(kVar.b));
                subsamplingScaleImageView.W.readLock().lock();
                try {
                    if (!z01Var.b()) {
                        kVar.d = false;
                        return null;
                    }
                    subsamplingScaleImageView.b0(kVar.a, kVar.g);
                    if (subsamplingScaleImageView.N != null) {
                        kVar.g.offset(subsamplingScaleImageView.N.left, subsamplingScaleImageView.N.top);
                    }
                    return z01Var.d(kVar.g, kVar.b);
                } finally {
                    subsamplingScaleImageView.W.readLock().unlock();
                }
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.z0, "Failed to decode tile", e);
                this.d = e;
                return null;
            } catch (OutOfMemoryError e2) {
                Log.e(SubsamplingScaleImageView.z0, "Failed to decode tile - OutOfMemoryError", e2);
                this.d = new RuntimeException(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.a.get();
            k kVar = (k) this.c.get();
            if (subsamplingScaleImageView == null || kVar == null) {
                return;
            }
            if (bitmap != null) {
                kVar.c = bitmap;
                kVar.d = false;
                subsamplingScaleImageView.r0();
            } else if (this.d != null) {
                SubsamplingScaleImageView.z(subsamplingScaleImageView);
            }
        }
    }

    private static class m extends AsyncTask {
        private final WeakReference a;
        private final WeakReference b;
        private final WeakReference c;
        private final Uri d;
        private z01 e;
        private Exception f;

        m(SubsamplingScaleImageView subsamplingScaleImageView, Context context, p70 p70Var, Uri uri) {
            this.a = new WeakReference(subsamplingScaleImageView);
            this.b = new WeakReference(context);
            this.c = new WeakReference(p70Var);
            this.d = uri;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int[] doInBackground(Void... voidArr) {
            try {
                String string = this.d.toString();
                Context context = (Context) this.b.get();
                p70 p70Var = (p70) this.c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.a.get();
                if (context == null || p70Var == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.U("TilesInitTask.doInBackground", new Object[0]);
                z01 z01Var = (z01) p70Var.a();
                this.e = z01Var;
                Point pointC = z01Var.c(context, this.d);
                int iWidth = pointC.x;
                int iHeight = pointC.y;
                int iE0 = subsamplingScaleImageView.e0(context, string);
                if (subsamplingScaleImageView.N != null) {
                    subsamplingScaleImageView.N.left = Math.max(0, subsamplingScaleImageView.N.left);
                    subsamplingScaleImageView.N.top = Math.max(0, subsamplingScaleImageView.N.top);
                    subsamplingScaleImageView.N.right = Math.min(iWidth, subsamplingScaleImageView.N.right);
                    subsamplingScaleImageView.N.bottom = Math.min(iHeight, subsamplingScaleImageView.N.bottom);
                    iWidth = subsamplingScaleImageView.N.width();
                    iHeight = subsamplingScaleImageView.N.height();
                }
                return new int[]{iWidth, iHeight, iE0};
            } catch (Exception e) {
                Log.e(SubsamplingScaleImageView.z0, "Failed to initialise bitmap decoder", e);
                this.f = e;
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.a.get();
            if (subsamplingScaleImageView != null) {
                z01 z01Var = this.e;
                if (z01Var != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.s0(z01Var, iArr[0], iArr[1], iArr[2]);
                } else if (this.f != null) {
                    SubsamplingScaleImageView.z(subsamplingScaleImageView);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        int resourceId;
        String string;
        super(context, attributeSet);
        this.h = 0;
        this.i = 2.0f;
        this.j = m0();
        this.k = -1;
        this.l = 1;
        this.m = 1;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
        this.p = AsyncTask.THREAD_POOL_EXECUTOR;
        this.f301q = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.u = 1.0f;
        this.v = 1;
        this.w = 500;
        this.W = new ReentrantReadWriteLock(true);
        this.a0 = new u00(SkiaImageDecoder.class);
        this.b0 = new u00(SkiaImageRegionDecoder.class);
        this.w0 = new float[8];
        this.x0 = new float[8];
        this.y0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.o0 = new Handler(new a());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.PictureLongScaleImageView);
            int i2 = R$styleable.PictureLongScaleImageView_assetName;
            if (typedArrayObtainStyledAttributes.hasValue(i2) && (string = typedArrayObtainStyledAttributes.getString(i2)) != null && string.length() > 0) {
                setImage(com.luck.picture.lib.widget.longimage.a.a(string).m());
            }
            int i3 = R$styleable.PictureLongScaleImageView_src;
            if (typedArrayObtainStyledAttributes.hasValue(i3) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i3, 0)) > 0) {
                setImage(com.luck.picture.lib.widget.longimage.a.k(resourceId).m());
            }
            int i4 = R$styleable.PictureLongScaleImageView_panEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i4)) {
                setPanEnabled(typedArrayObtainStyledAttributes.getBoolean(i4, true));
            }
            int i5 = R$styleable.PictureLongScaleImageView_zoomEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i5)) {
                setZoomEnabled(typedArrayObtainStyledAttributes.getBoolean(i5, true));
            }
            int i6 = R$styleable.PictureLongScaleImageView_quickScaleEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i6)) {
                setQuickScaleEnabled(typedArrayObtainStyledAttributes.getBoolean(i6, true));
            }
            int i7 = R$styleable.PictureLongScaleImageView_tileBackgroundColor;
            if (typedArrayObtainStyledAttributes.hasValue(i7)) {
                setTileBackgroundColor(typedArrayObtainStyledAttributes.getColor(i7, Color.argb(0, 0, 0, 0)));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.e0 = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int A0() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.K : this.L;
    }

    private int B0() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.L : this.K;
    }

    private void C0(float f2, PointF pointF, int i2) {
    }

    private void F0(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    private void J0(Rect rect, Rect rect2) {
        rect2.set((int) K0(rect.left), (int) L0(rect.top), (int) K0(rect.right), (int) L0(rect.bottom));
    }

    private float K0(float f2) {
        PointF pointF = this.z;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.x) + pointF.x;
    }

    private float L0(float f2) {
        PointF pointF = this.z;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.x) + pointF.y;
    }

    private boolean M0(k kVar) {
        return R0(0.0f) <= ((float) kVar.a.right) && ((float) kVar.a.left) <= R0((float) getWidth()) && S0(0.0f) <= ((float) kVar.a.bottom) && ((float) kVar.a.top) <= S0((float) getHeight());
    }

    private PointF N0(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.t0 == null) {
            this.t0 = new j(0.0f, new PointF(0.0f, 0.0f), null);
        }
        this.t0.a = f4;
        this.t0.b.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
        d0(true, this.t0);
        return this.t0.b;
    }

    private int Q(float f2) {
        int iRound;
        if (this.k > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.k / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int iB0 = (int) (B0() * f2);
        int iA0 = (int) (A0() * f2);
        if (iB0 == 0 || iA0 == 0) {
            return 32;
        }
        int i2 = 1;
        if (A0() > iA0 || B0() > iB0) {
            iRound = Math.round(A0() / iA0);
            int iRound2 = Math.round(B0() / iB0);
            if (iRound >= iRound2) {
                iRound = iRound2;
            }
        } else {
            iRound = 1;
        }
        while (true) {
            int i3 = i2 * 2;
            if (i3 >= iRound) {
                return i2;
            }
            i2 = i3;
        }
    }

    private boolean R() {
        boolean zI0 = i0();
        if (!this.m0 && zI0) {
            u0();
            this.m0 = true;
            n0();
        }
        return zI0;
    }

    private float R0(float f2) {
        PointF pointF = this.z;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.x;
    }

    private boolean S() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.K > 0 && this.L > 0 && (this.a != null || i0());
        if (!this.l0 && z) {
            u0();
            this.l0 = true;
            q0();
        }
        return z;
    }

    private float S0(float f2) {
        PointF pointF = this.z;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.x;
    }

    private void T() {
        if (this.p0 == null) {
            Paint paint = new Paint();
            this.p0 = paint;
            paint.setAntiAlias(true);
            this.p0.setFilterBitmap(true);
            this.p0.setDither(true);
        }
        if ((this.q0 == null || this.r0 == null) && this.g) {
            Paint paint2 = new Paint();
            this.q0 = paint2;
            paint2.setTextSize(v0(12));
            this.q0.setColor(-65281);
            this.q0.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.r0 = paint3;
            paint3.setColor(-65281);
            this.r0.setStyle(Paint.Style.STROKE);
            this.r0.setStrokeWidth(v0(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str, Object... objArr) {
        if (this.g) {
            Log.d(z0, String.format(str, objArr));
        }
    }

    private float V(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(PointF pointF, PointF pointF2) {
        if (!this.r) {
            PointF pointF3 = this.J;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = B0() / 2;
                pointF.y = A0() / 2;
            }
        }
        float fMin = Math.min(this.i, this.u);
        float f2 = this.x;
        boolean z = ((double) f2) <= ((double) fMin) * 0.9d || f2 == this.j;
        if (!z) {
            fMin = m0();
        }
        float f3 = fMin;
        int i2 = this.v;
        if (i2 == 3) {
            G0(f3, pointF);
        } else if (i2 == 2 || !z || !this.r) {
            new e(this, f3, pointF, (a) null).f(false).d(this.w).g(4).c();
        } else if (i2 == 1) {
            new e(this, f3, pointF, pointF2, null).f(false).d(this.w).g(4).c();
        }
        invalidate();
    }

    private float X(int i2, long j2, float f2, float f3, long j3) {
        if (i2 == 1) {
            return Z(j2, f2, f3, j3);
        }
        if (i2 == 2) {
            return Y(j2, f2, f3, j3);
        }
        throw new IllegalStateException("Unexpected easing type: " + i2);
    }

    private float Y(long j2, float f2, float f3, long j3) {
        float f4;
        float f5 = j2 / (j3 / 2.0f);
        if (f5 < 1.0f) {
            f4 = (f3 / 2.0f) * f5;
        } else {
            float f6 = f5 - 1.0f;
            f4 = (-f3) / 2.0f;
            f5 = (f6 * (f6 - 2.0f)) - 1.0f;
        }
        return (f4 * f5) + f2;
    }

    private float Z(long j2, float f2, float f3, long j3) {
        float f4 = j2 / j3;
        return ((-f3) * f4 * (f4 - 2.0f)) + f2;
    }

    private void a0(AsyncTask asyncTask) {
        asyncTask.executeOnExecutor(this.p, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            int i2 = rect.top;
            int i3 = this.L;
            rect2.set(i2, i3 - rect.right, rect.bottom, i3 - rect.left);
        } else if (getRequiredRotation() != 180) {
            int i4 = this.K;
            rect2.set(i4 - rect.bottom, rect.left, i4 - rect.top, rect.right);
        } else {
            int i5 = this.K;
            int i6 = i5 - rect.right;
            int i7 = this.L;
            rect2.set(i6, i7 - rect.bottom, i5 - rect.left, i7 - rect.top);
        }
    }

    private void c0(boolean z) {
        boolean z2;
        float f2 = 0.0f;
        if (this.z == null) {
            this.z = new PointF(0.0f, 0.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.t0 == null) {
            this.t0 = new j(f2, new PointF(0.0f, 0.0f), null);
        }
        this.t0.a = this.x;
        this.t0.b.set(this.z);
        d0(z, this.t0);
        this.x = this.t0.a;
        this.z.set(this.t0.b);
        if (!z2 || this.m == 4) {
            return;
        }
        this.z.set(N0(B0() / 2, A0() / 2, this.x));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(boolean z, j jVar) {
        float fMax;
        int iMax;
        float fMax2;
        if (this.l == 2 && j0()) {
            z = false;
        }
        PointF pointF = jVar.b;
        float fL0 = l0(jVar.a);
        float fB0 = B0() * fL0;
        float fA0 = A0() * fL0;
        if (this.l == 3 && j0()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - fB0);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - fA0);
        } else if (z) {
            pointF.x = Math.max(pointF.x, getWidth() - fB0);
            pointF.y = Math.max(pointF.y, getHeight() - fA0);
        } else {
            pointF.x = Math.max(pointF.x, -fB0);
            pointF.y = Math.max(pointF.y, -fA0);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        float paddingTop = (getPaddingTop() > 0 || getPaddingBottom() > 0) ? getPaddingTop() / (getPaddingTop() + getPaddingBottom()) : 0.5f;
        if (this.l != 3 || !j0()) {
            if (z) {
                fMax = Math.max(0.0f, (getWidth() - fB0) * paddingLeft);
                fMax2 = Math.max(0.0f, (getHeight() - fA0) * paddingTop);
            } else {
                fMax = Math.max(0, getWidth());
                iMax = Math.max(0, getHeight());
            }
            pointF.x = Math.min(pointF.x, fMax);
            pointF.y = Math.min(pointF.y, fMax2);
            jVar.a = fL0;
        }
        fMax = Math.max(0, getWidth() / 2);
        iMax = Math.max(0, getHeight() / 2);
        fMax2 = iMax;
        pointF.x = Math.min(pointF.x, fMax);
        pointF.y = Math.min(pointF.y, fMax2);
        jVar.a = fL0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e0(Context context, String str) {
        int i2 = 0;
        if (!str.startsWith("content")) {
            if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
                return 0;
            }
            try {
                int iO = new dj0(str.substring(7)).o("Orientation", 1);
                if (iO != 1 && iO != 0) {
                    if (iO == 6) {
                        return 90;
                    }
                    if (iO == 3) {
                        return Opcodes.GETFIELD;
                    }
                    if (iO == 8) {
                        return 270;
                    }
                    Log.w(z0, "Unsupported EXIF orientation: " + iO);
                    return 0;
                }
                return 0;
            } catch (Exception unused) {
                Log.w(z0, "Could not get EXIF orientation of image");
                return 0;
            }
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    int i3 = cursorQuery.getInt(0);
                    if (!A0.contains(Integer.valueOf(i3)) || i3 == -1) {
                        Log.w(z0, "Unsupported orientation: " + i3);
                    } else {
                        i2 = i3;
                    }
                }
                if (cursorQuery == null) {
                    return i2;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Exception unused2) {
            Log.w(z0, "Could not get orientation of image from media store");
            if (cursorQuery == null) {
                return 0;
            }
        }
        return i2;
    }

    private Point f0(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.n), Math.min(canvas.getMaximumBitmapHeight(), this.o));
    }

    private synchronized void g0(Point point) {
        try {
            U("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
            j jVar = new j(0.0f, new PointF(0.0f, 0.0f), null);
            this.t0 = jVar;
            d0(true, jVar);
            int iQ = Q(this.t0.a);
            this.e = iQ;
            if (iQ > 1) {
                this.e = iQ / 2;
            }
            if (this.e != 1 || this.N != null || B0() >= point.x || A0() >= point.y) {
                h0(point);
                Iterator it = ((List) this.f.get(Integer.valueOf(this.e))).iterator();
                while (it.hasNext()) {
                    a0(new l(this, this.V, (k) it.next()));
                }
                w0(true);
            } else {
                this.V.a();
                this.V = null;
                a0(new f(this, getContext(), this.a0, this.d, false));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return F0;
    }

    private int getRequiredRotation() {
        int i2 = this.h;
        return i2 == -1 ? this.M : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h0(Point point) {
        U("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.f = new LinkedHashMap();
        int i2 = this.e;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int iB0 = B0() / i4;
            int iA0 = A0() / i5;
            int i6 = iB0 / i2;
            int i7 = iA0 / i2;
            while (true) {
                if (i6 + i4 + i3 <= point.x && (i6 <= ((double) getWidth()) * 1.25d || i2 >= this.e)) {
                    break;
                }
                i4++;
                iB0 = B0() / i4;
                i6 = iB0 / i2;
            }
            while (true) {
                if (i7 + i5 + i3 <= point.y && (i7 <= ((double) getHeight()) * 1.25d || i2 >= this.e)) {
                    break;
                }
                i5++;
                iA0 = A0() / i5;
                i7 = iA0 / i2;
            }
            ArrayList arrayList = new ArrayList(i4 * i5);
            int i8 = 0;
            while (i8 < i4) {
                int i9 = 0;
                while (i9 < i5) {
                    k kVar = new k(null);
                    kVar.b = i2;
                    kVar.e = i2 == this.e ? i3 : 0;
                    kVar.a = new Rect(i8 * iB0, i9 * iA0, i8 == i4 + (-1) ? B0() : (i8 + 1) * iB0, i9 == i5 + (-1) ? A0() : (i9 + 1) * iA0);
                    kVar.f = new Rect(0, 0, 0, 0);
                    kVar.g = new Rect(kVar.a);
                    arrayList.add(kVar);
                    i9++;
                    i3 = 1;
                }
                i8++;
                i3 = 1;
            }
            this.f.put(Integer.valueOf(i2), arrayList);
            i3 = 1;
            if (i2 == 1) {
                return;
            } else {
                i2 /= 2;
            }
        }
    }

    private boolean i0() {
        boolean z = true;
        if (this.a != null && !this.b) {
            return true;
        }
        Map map = this.f;
        if (map == null) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getKey()).intValue() == this.e) {
                for (k kVar : (List) entry.getValue()) {
                    if (kVar.d || kVar.c == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF k0(float f2, float f3, float f4, PointF pointF) {
        PointF pointFN0 = N0(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - pointFN0.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - pointFN0.y) / f4);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float l0(float f2) {
        return Math.min(this.i, Math.max(m0(), f2));
    }

    private float m0() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i2 = this.m;
        if (i2 == 2 || i2 == 4) {
            return Math.max((getWidth() - paddingLeft) / B0(), (getHeight() - paddingBottom) / A0());
        }
        if (i2 == 3) {
            float f2 = this.j;
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return Math.min((getWidth() - paddingLeft) / B0(), (getHeight() - paddingBottom) / A0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o0(Bitmap bitmap, int i2, boolean z) {
        try {
            U("onImageLoaded", new Object[0]);
            int i3 = this.K;
            if (i3 > 0 && this.L > 0 && (i3 != bitmap.getWidth() || this.L != bitmap.getHeight())) {
                y0(false);
            }
            Bitmap bitmap2 = this.a;
            if (bitmap2 != null && !this.c) {
                bitmap2.recycle();
            }
            this.b = false;
            this.c = z;
            this.a = bitmap;
            this.K = bitmap.getWidth();
            this.L = bitmap.getHeight();
            this.M = i2;
            boolean zS = S();
            boolean zR = R();
            if (zS || zR) {
                invalidate();
                requestLayout();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p0(Bitmap bitmap) {
        try {
            U("onPreviewLoaded", new Object[0]);
            if (this.a == null && !this.m0) {
                Rect rect = this.O;
                if (rect != null) {
                    this.a = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.O.height());
                } else {
                    this.a = bitmap;
                }
                this.b = true;
                if (S()) {
                    invalidate();
                    requestLayout();
                }
                return;
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r0() {
        Bitmap bitmap;
        try {
            U("onTileLoaded", new Object[0]);
            S();
            R();
            if (i0() && (bitmap = this.a) != null) {
                if (!this.c) {
                    bitmap.recycle();
                }
                this.a = null;
                this.b = false;
                this.c = false;
            }
            invalidate();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s0(z01 z01Var, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        try {
            U("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.h));
            int i8 = this.K;
            if (i8 > 0 && (i7 = this.L) > 0 && (i8 != i2 || i7 != i3)) {
                y0(false);
                Bitmap bitmap = this.a;
                if (bitmap != null) {
                    if (!this.c) {
                        bitmap.recycle();
                    }
                    this.a = null;
                    this.b = false;
                    this.c = false;
                }
            }
            this.V = z01Var;
            this.K = i2;
            this.L = i3;
            this.M = i4;
            S();
            if (!R() && (i5 = this.n) > 0 && i5 != Integer.MAX_VALUE && (i6 = this.o) > 0 && i6 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
                g0(new Point(this.n, this.o));
            }
            invalidate();
            requestLayout();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        this.T = new GestureDetector(context, new b(context));
        this.U = new GestureDetector(context, new c());
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        F0 = config;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r1 != 262) goto L133;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean t0(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 1168
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView.t0(android.view.MotionEvent):boolean");
    }

    private void u0() {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.K <= 0 || this.L <= 0) {
            return;
        }
        if (this.I != null && (f2 = this.H) != null) {
            this.x = f2.floatValue();
            if (this.z == null) {
                this.z = new PointF();
            }
            this.z.x = (getWidth() / 2) - (this.x * this.I.x);
            this.z.y = (getHeight() / 2) - (this.x * this.I.y);
            this.I = null;
            this.H = null;
            c0(true);
            w0(true);
        }
        c0(false);
    }

    private int v0(int i2) {
        return (int) (this.y0 * i2);
    }

    private void w0(boolean z) {
        if (this.V == null || this.f == null) {
            return;
        }
        int iMin = Math.min(this.e, Q(this.x));
        Iterator it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            for (k kVar : (List) ((Map.Entry) it.next()).getValue()) {
                if (kVar.b < iMin || (kVar.b > iMin && kVar.b != this.e)) {
                    kVar.e = false;
                    if (kVar.c != null) {
                        kVar.c.recycle();
                        kVar.c = null;
                    }
                }
                if (kVar.b == iMin) {
                    if (M0(kVar)) {
                        kVar.e = true;
                        if (!kVar.d && kVar.c == null && z) {
                            a0(new l(this, this.V, kVar));
                        }
                    } else if (kVar.b != this.e) {
                        kVar.e = false;
                        if (kVar.c != null) {
                            kVar.c.recycle();
                            kVar.c = null;
                        }
                    }
                } else if (kVar.b == this.e) {
                    kVar.e = true;
                }
            }
        }
    }

    private void x0(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void y0(boolean z) {
        U("reset newImage=" + z, new Object[0]);
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.F = null;
        this.G = null;
        this.H = Float.valueOf(0.0f);
        this.I = null;
        this.J = null;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = 0;
        this.e = 0;
        this.c0 = null;
        this.d0 = 0.0f;
        this.f0 = 0.0f;
        this.g0 = false;
        this.i0 = null;
        this.h0 = null;
        this.j0 = null;
        this.k0 = null;
        this.t0 = null;
        this.u0 = null;
        this.v0 = null;
        if (z) {
            this.d = null;
            this.W.writeLock().lock();
            try {
                z01 z01Var = this.V;
                if (z01Var != null) {
                    z01Var.a();
                    this.V = null;
                }
                this.W.writeLock().unlock();
                Bitmap bitmap = this.a;
                if (bitmap != null && !this.c) {
                    bitmap.recycle();
                }
                this.K = 0;
                this.L = 0;
                this.M = 0;
                this.N = null;
                this.O = null;
                this.l0 = false;
                this.m0 = false;
                this.a = null;
                this.b = false;
                this.c = false;
            } catch (Throwable th) {
                this.W.writeLock().unlock();
                throw th;
            }
        }
        Map map = this.f;
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (k kVar : (List) ((Map.Entry) it.next()).getValue()) {
                    kVar.e = false;
                    if (kVar.c != null) {
                        kVar.c.recycle();
                        kVar.c = null;
                    }
                }
            }
            this.f = null;
        }
        setGestureDetector(getContext());
    }

    static /* synthetic */ h z(SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.getClass();
        return null;
    }

    private void z0(ImageViewState imageViewState) {
        if (imageViewState == null || !A0.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.h = imageViewState.getOrientation();
        this.H = Float.valueOf(imageViewState.getScale());
        this.I = imageViewState.getCenter();
        invalidate();
    }

    public final void D0(com.luck.picture.lib.widget.longimage.a aVar, com.luck.picture.lib.widget.longimage.a aVar2, ImageViewState imageViewState) {
        if (aVar == null) {
            throw new NullPointerException("imageSource must not be null");
        }
        y0(true);
        if (imageViewState != null) {
            z0(imageViewState);
        }
        if (aVar2 != null) {
            if (aVar.c() != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            }
            if (aVar.g() <= 0 || aVar.e() <= 0) {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            }
            this.K = aVar.g();
            this.L = aVar.e();
            this.O = aVar2.f();
            if (aVar2.c() != null) {
                this.c = aVar2.j();
                p0(aVar2.c());
            } else {
                Uri uriI = aVar2.i();
                if (uriI == null && aVar2.d() != null) {
                    uriI = Uri.parse("android.resource://" + getContext().getPackageName() + WatchConstant.FAT_FS_ROOT + aVar2.d());
                }
                a0(new f(this, getContext(), this.a0, uriI, true));
            }
        }
        if (aVar.c() != null && aVar.f() != null) {
            o0(Bitmap.createBitmap(aVar.c(), aVar.f().left, aVar.f().top, aVar.f().width(), aVar.f().height()), 0, false);
            return;
        }
        if (aVar.c() != null) {
            o0(aVar.c(), 0, aVar.j());
            return;
        }
        this.N = aVar.f();
        Uri uriI2 = aVar.i();
        this.d = uriI2;
        if (uriI2 == null && aVar.d() != null) {
            this.d = Uri.parse("android.resource://" + getContext().getPackageName() + WatchConstant.FAT_FS_ROOT + aVar.d());
        }
        if (aVar.h() || this.N != null) {
            a0(new m(this, getContext(), this.b0, this.d));
        } else {
            a0(new f(this, getContext(), this.a0, this.d, false));
        }
    }

    public final void E0(com.luck.picture.lib.widget.longimage.a aVar, ImageViewState imageViewState) {
        D0(aVar, null, imageViewState);
    }

    public final void G0(float f2, PointF pointF) {
        this.k0 = null;
        this.H = Float.valueOf(f2);
        this.I = pointF;
        this.J = pointF;
        invalidate();
    }

    public final PointF H0(float f2, float f3, PointF pointF) {
        if (this.z == null) {
            return null;
        }
        pointF.set(K0(f2), L0(f3));
        return pointF;
    }

    public final PointF I0(PointF pointF) {
        return H0(pointF.x, pointF.y, new PointF());
    }

    public final PointF O0(float f2, float f3) {
        return P0(f2, f3, new PointF());
    }

    public final PointF P0(float f2, float f3, PointF pointF) {
        if (this.z == null) {
            return null;
        }
        pointF.set(R0(f2), S0(f3));
        return pointF;
    }

    public final PointF Q0(PointF pointF) {
        return P0(pointF.x, pointF.y, new PointF());
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return O0(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.i;
    }

    public final float getMinScale() {
        return m0();
    }

    public final int getOrientation() {
        return this.h;
    }

    public final int getSHeight() {
        return this.L;
    }

    public final int getSWidth() {
        return this.K;
    }

    public final float getScale() {
        return this.x;
    }

    public final ImageViewState getState() {
        if (this.z == null || this.K <= 0 || this.L <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final boolean j0() {
        return this.l0;
    }

    protected void n0() {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        float height;
        int i3;
        int i4;
        int i5;
        int i6;
        super.onDraw(canvas);
        T();
        if (this.K == 0 || this.L == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.f == null && this.V != null) {
            g0(f0(canvas));
        }
        if (S()) {
            u0();
            d dVar = this.k0;
            if (dVar != null && dVar.f != null) {
                float f2 = this.x;
                if (this.G == null) {
                    this.G = new PointF(0.0f, 0.0f);
                }
                this.G.set(this.z);
                long jCurrentTimeMillis = System.currentTimeMillis() - this.k0.l;
                boolean z = jCurrentTimeMillis > this.k0.h;
                long jMin = Math.min(jCurrentTimeMillis, this.k0.h);
                this.x = X(this.k0.j, jMin, this.k0.a, this.k0.b - this.k0.a, this.k0.h);
                float fX = X(this.k0.j, jMin, this.k0.f.x, this.k0.g.x - this.k0.f.x, this.k0.h);
                float fX2 = X(this.k0.j, jMin, this.k0.f.y, this.k0.g.y - this.k0.f.y, this.k0.h);
                this.z.x -= K0(this.k0.d.x) - fX;
                this.z.y -= L0(this.k0.d.y) - fX2;
                c0(z || this.k0.a == this.k0.b);
                C0(f2, this.G, this.k0.k);
                w0(z);
                if (z) {
                    d.c(this.k0);
                    this.k0 = null;
                }
                invalidate();
            }
            Map map = this.f;
            int i7 = Opcodes.GETFIELD;
            int i8 = 90;
            int i9 = 5;
            if (map == null || !i0()) {
                i2 = 5;
                Bitmap bitmap = this.a;
                if (bitmap != null && !bitmap.isRecycled()) {
                    float width = this.x;
                    if (this.b) {
                        width *= this.K / this.a.getWidth();
                        height = this.x * (this.L / this.a.getHeight());
                    } else {
                        height = width;
                    }
                    if (this.u0 == null) {
                        this.u0 = new Matrix();
                    }
                    this.u0.reset();
                    this.u0.postScale(width, height);
                    this.u0.postRotate(getRequiredRotation());
                    Matrix matrix = this.u0;
                    PointF pointF = this.z;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.u0;
                        float f3 = this.x;
                        matrix2.postTranslate(this.K * f3, f3 * this.L);
                    } else if (getRequiredRotation() == 90) {
                        this.u0.postTranslate(this.x * this.L, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.u0.postTranslate(0.0f, this.x * this.K);
                    }
                    if (this.s0 != null) {
                        if (this.v0 == null) {
                            this.v0 = new RectF();
                        }
                        this.v0.set(0.0f, 0.0f, this.b ? this.a.getWidth() : this.K, this.b ? this.a.getHeight() : this.L);
                        this.u0.mapRect(this.v0);
                        canvas.drawRect(this.v0, this.s0);
                    }
                    canvas.drawBitmap(this.a, this.u0, this.p0);
                }
            } else {
                int iMin = Math.min(this.e, Q(this.x));
                boolean z2 = false;
                for (Map.Entry entry : this.f.entrySet()) {
                    if (((Integer) entry.getKey()).intValue() == iMin) {
                        for (k kVar : (List) entry.getValue()) {
                            if (kVar.e && (kVar.d || kVar.c == null)) {
                                z2 = true;
                            }
                        }
                    }
                }
                for (Map.Entry entry2 : this.f.entrySet()) {
                    if (((Integer) entry2.getKey()).intValue() == iMin || z2) {
                        for (k kVar2 : (List) entry2.getValue()) {
                            J0(kVar2.a, kVar2.f);
                            if (kVar2.d || kVar2.c == null) {
                                i3 = i8;
                                i4 = i7;
                                i5 = iMin;
                                i6 = i9;
                                if (kVar2.d && this.g) {
                                    canvas.drawText("LOADING", kVar2.f.left + v0(i6), kVar2.f.top + v0(35), this.q0);
                                }
                            } else {
                                if (this.s0 != null) {
                                    canvas.drawRect(kVar2.f, this.s0);
                                }
                                if (this.u0 == null) {
                                    this.u0 = new Matrix();
                                }
                                this.u0.reset();
                                i5 = iMin;
                                i6 = i9;
                                i3 = i8;
                                i4 = i7;
                                F0(this.w0, 0.0f, 0.0f, kVar2.c.getWidth(), 0.0f, kVar2.c.getWidth(), kVar2.c.getHeight(), 0.0f, kVar2.c.getHeight());
                                if (getRequiredRotation() == 0) {
                                    F0(this.x0, kVar2.f.left, kVar2.f.top, kVar2.f.right, kVar2.f.top, kVar2.f.right, kVar2.f.bottom, kVar2.f.left, kVar2.f.bottom);
                                } else if (getRequiredRotation() == i3) {
                                    F0(this.x0, kVar2.f.right, kVar2.f.top, kVar2.f.right, kVar2.f.bottom, kVar2.f.left, kVar2.f.bottom, kVar2.f.left, kVar2.f.top);
                                } else if (getRequiredRotation() == i4) {
                                    F0(this.x0, kVar2.f.right, kVar2.f.bottom, kVar2.f.left, kVar2.f.bottom, kVar2.f.left, kVar2.f.top, kVar2.f.right, kVar2.f.top);
                                } else if (getRequiredRotation() == 270) {
                                    F0(this.x0, kVar2.f.left, kVar2.f.bottom, kVar2.f.left, kVar2.f.top, kVar2.f.right, kVar2.f.top, kVar2.f.right, kVar2.f.bottom);
                                }
                                this.u0.setPolyToPoly(this.w0, 0, this.x0, 0, 4);
                                canvas.drawBitmap(kVar2.c, this.u0, this.p0);
                                if (this.g) {
                                    canvas.drawRect(kVar2.f, this.r0);
                                }
                            }
                            if (kVar2.e && this.g) {
                                canvas.drawText("ISS " + kVar2.b + " RECT " + kVar2.a.top + "," + kVar2.a.left + "," + kVar2.a.bottom + "," + kVar2.a.right, kVar2.f.left + v0(i6), kVar2.f.top + v0(15), this.q0);
                            }
                            i9 = i6;
                            i8 = i3;
                            i7 = i4;
                            iMin = i5;
                        }
                    }
                    i9 = i9;
                    i8 = i8;
                    i7 = i7;
                    iMin = iMin;
                }
                i2 = i9;
            }
            if (this.g) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scale: ");
                Locale locale = Locale.ENGLISH;
                sb.append(String.format(locale, "%.2f", Float.valueOf(this.x)));
                sb.append(" (");
                sb.append(String.format(locale, "%.2f", Float.valueOf(m0())));
                sb.append(" - ");
                sb.append(String.format(locale, "%.2f", Float.valueOf(this.i)));
                sb.append(")");
                canvas.drawText(sb.toString(), v0(i2), v0(15), this.q0);
                canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.z.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(this.z.y)), v0(i2), v0(30), this.q0);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(locale, "%.2f", Float.valueOf(center.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(center.y)), v0(i2), v0(45), this.q0);
                d dVar2 = this.k0;
                if (dVar2 != null) {
                    PointF pointFI0 = I0(dVar2.c);
                    PointF pointFI1 = I0(this.k0.e);
                    PointF pointFI2 = I0(this.k0.d);
                    canvas.drawCircle(pointFI0.x, pointFI0.y, v0(10), this.r0);
                    this.r0.setColor(Opcodes.V_PREVIEW);
                    canvas.drawCircle(pointFI1.x, pointFI1.y, v0(20), this.r0);
                    this.r0.setColor(-16776961);
                    canvas.drawCircle(pointFI2.x, pointFI2.y, v0(25), this.r0);
                    this.r0.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, v0(30), this.r0);
                }
                if (this.c0 != null) {
                    this.r0.setColor(Opcodes.V_PREVIEW);
                    PointF pointF2 = this.c0;
                    canvas.drawCircle(pointF2.x, pointF2.y, v0(20), this.r0);
                }
                if (this.i0 != null) {
                    this.r0.setColor(-16776961);
                    canvas.drawCircle(K0(this.i0.x), L0(this.i0.y), v0(35), this.r0);
                }
                if (this.j0 != null && this.R) {
                    this.r0.setColor(-16711681);
                    PointF pointF3 = this.j0;
                    canvas.drawCircle(pointF3.x, pointF3.y, v0(30), this.r0);
                }
                this.r0.setColor(-65281);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.K > 0 && this.L > 0) {
            if (z && z2) {
                size = B0();
                size2 = A0();
            } else if (z2) {
                size2 = (int) ((((double) A0()) / ((double) B0())) * ((double) size));
            } else if (z) {
                size = (int) ((((double) B0()) / ((double) A0())) * ((double) size2));
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        U("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3));
        PointF center = getCenter();
        if (!this.l0 || center == null) {
            return;
        }
        this.k0 = null;
        this.H = Float.valueOf(this.x);
        this.I = center;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        d dVar = this.k0;
        if (dVar != null && !dVar.i) {
            x0(true);
            return true;
        }
        d dVar2 = this.k0;
        if (dVar2 != null) {
            d.c(dVar2);
        }
        this.k0 = null;
        if (this.z == null) {
            GestureDetector gestureDetector2 = this.U;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        }
        if (!this.R && ((gestureDetector = this.T) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.P = false;
            this.Q = false;
            this.S = 0;
            return true;
        }
        if (this.F == null) {
            this.F = new PointF(0.0f, 0.0f);
        }
        if (this.G == null) {
            this.G = new PointF(0.0f, 0.0f);
        }
        if (this.c0 == null) {
            this.c0 = new PointF(0.0f, 0.0f);
        }
        float f2 = this.x;
        this.G.set(this.z);
        boolean zT0 = t0(motionEvent);
        C0(f2, this.G, 2);
        return zT0 || super.onTouchEvent(motionEvent);
    }

    protected void q0() {
    }

    public final void setBitmapDecoderClass(Class<? extends a01> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.a0 = new u00(cls);
    }

    public final void setBitmapDecoderFactory(p70 p70Var) {
        if (p70Var == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.a0 = p70Var;
    }

    public final void setDebug(boolean z) {
        this.g = z;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setDoubleTapZoomDuration(int i2) {
        this.w = Math.max(0, i2);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.u = f2;
    }

    public final void setDoubleTapZoomStyle(int i2) {
        if (B0.contains(Integer.valueOf(i2))) {
            this.v = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i2);
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.f301q = z;
    }

    public void setExecutor(Executor executor) {
        if (executor == null) {
            throw new NullPointerException("Executor must not be null");
        }
        this.p = executor;
    }

    public final void setImage(com.luck.picture.lib.widget.longimage.a aVar) {
        D0(aVar, null, null);
    }

    public final void setMaxScale(float f2) {
        this.i = f2;
    }

    public void setMaxTileSize(int i2) {
        this.n = i2;
        this.o = i2;
    }

    public final void setMaximumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinScale(float f2) {
        this.j = f2;
    }

    public final void setMinimumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinimumScaleType(int i2) {
        if (!E0.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid scale type: " + i2);
        }
        this.m = i2;
        if (j0()) {
            c0(true);
            invalidate();
        }
    }

    public void setMinimumTileDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.k = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
        if (j0()) {
            y0(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(h hVar) {
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.n0 = onLongClickListener;
    }

    public void setOnStateChangedListener(i iVar) {
    }

    public final void setOrientation(int i2) {
        if (!A0.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid orientation: " + i2);
        }
        this.h = i2;
        y0(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.r = z;
        if (z || (pointF = this.z) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.x * (B0() / 2));
        this.z.y = (getHeight() / 2) - (this.x * (A0() / 2));
        if (j0()) {
            w0(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i2) {
        if (!D0.contains(Integer.valueOf(i2))) {
            throw new IllegalArgumentException("Invalid pan limit: " + i2);
        }
        this.l = i2;
        if (j0()) {
            c0(true);
            invalidate();
        }
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.t = z;
    }

    public final void setRegionDecoderClass(Class<? extends z01> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.b0 = new u00(cls);
    }

    public final void setRegionDecoderFactory(p70 p70Var) {
        if (p70Var == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.b0 = p70Var;
    }

    public final void setTileBackgroundColor(int i2) {
        if (Color.alpha(i2) == 0) {
            this.s0 = null;
        } else {
            Paint paint = new Paint();
            this.s0 = paint;
            paint.setStyle(Paint.Style.FILL);
            this.s0.setColor(i2);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.s = z;
    }

    private static class d {
        private float a;
        private float b;
        private PointF c;
        private PointF d;
        private PointF e;
        private PointF f;
        private PointF g;
        private long h;
        private boolean i;
        private int j;
        private int k;
        private long l;

        private d() {
            this.h = 500L;
            this.i = true;
            this.j = 2;
            this.k = 1;
            this.l = System.currentTimeMillis();
        }

        static /* synthetic */ g c(d dVar) {
            dVar.getClass();
            return null;
        }

        static /* synthetic */ g d(d dVar, g gVar) {
            dVar.getClass();
            return gVar;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }
}
