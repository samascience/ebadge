package androidx.camera.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.u;
import androidx.camera.core.x;
import androidx.lifecycle.LiveData;
import defpackage.be3;
import defpackage.ft;
import defpackage.gy2;
import defpackage.hy2;
import defpackage.im1;
import defpackage.iy1;
import defpackage.n52;
import defpackage.p62;
import defpackage.q30;
import defpackage.t23;
import defpackage.te3;
import defpackage.uj1;
import defpackage.wa0;
import defpackage.y43;
import defpackage.zt;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class PreviewView extends FrameLayout {
    private static final ImplementationMode o = ImplementationMode.PERFORMANCE;
    ImplementationMode a;
    i b;
    final ScreenFlashView c;
    final e d;
    boolean e;
    final im1 f;
    final AtomicReference g;
    j h;
    private final ScaleGestureDetector i;
    zt j;
    private MotionEvent k;
    private final b l;
    private final View.OnLayoutChangeListener m;
    final n52.c n;

    public enum ImplementationMode {
        PERFORMANCE(0),
        COMPATIBLE(1);

        private final int mId;

        ImplementationMode(int i) {
            this.mId = i;
        }

        static ImplementationMode fromId(int i) {
            for (ImplementationMode implementationMode : values()) {
                if (implementationMode.mId == i) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException("Unknown implementation mode id " + i);
        }

        int getId() {
            return this.mId;
        }
    }

    public enum ScaleType {
        FILL_START(0),
        FILL_CENTER(1),
        FILL_END(2),
        FIT_START(3),
        FIT_CENTER(4),
        FIT_END(5);

        private final int mId;

        ScaleType(int i) {
            this.mId = i;
        }

        static ScaleType fromId(int i) {
            for (ScaleType scaleType : values()) {
                if (scaleType.mId == i) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + i);
        }

        int getId() {
            return this.mId;
        }
    }

    public enum StreamState {
        IDLE,
        STREAMING
    }

    class a implements n52.c {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(SurfaceRequest surfaceRequest) {
            PreviewView.this.n.a(surfaceRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(CameraInternal cameraInternal, SurfaceRequest surfaceRequest, SurfaceRequest.g gVar) {
            PreviewView previewView;
            i iVar;
            x.a("PreviewView", "Preview transformation info updated. " + gVar);
            PreviewView.this.d.r(gVar, surfaceRequest.o(), cameraInternal.n().f() == 0);
            if (gVar.d() == -1 || ((iVar = (previewView = PreviewView.this).b) != null && (iVar instanceof n))) {
                PreviewView.this.e = true;
            } else {
                previewView.e = false;
            }
            PreviewView.this.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(d dVar, CameraInternal cameraInternal) {
            if (p62.a(PreviewView.this.g, dVar, null)) {
                dVar.l(StreamState.IDLE);
            }
            dVar.f();
            cameraInternal.g().e(dVar);
        }

        @Override // n52.c
        public void a(final SurfaceRequest surfaceRequest) {
            i nVar;
            if (!t23.c()) {
                q30.h(PreviewView.this.getContext()).execute(new Runnable() { // from class: androidx.camera.view.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e(surfaceRequest);
                    }
                });
                return;
            }
            x.a("PreviewView", "Surface requested by Preview.");
            final CameraInternal cameraInternalK = surfaceRequest.k();
            PreviewView.this.j = cameraInternalK.n();
            surfaceRequest.C(q30.h(PreviewView.this.getContext()), new SurfaceRequest.h() { // from class: androidx.camera.view.g
                @Override // androidx.camera.core.SurfaceRequest.h
                public final void a(SurfaceRequest.g gVar) {
                    this.a.f(cameraInternalK, surfaceRequest, gVar);
                }
            });
            PreviewView previewView = PreviewView.this;
            if (!PreviewView.f(previewView.b, surfaceRequest, previewView.a)) {
                PreviewView previewView2 = PreviewView.this;
                if (PreviewView.g(surfaceRequest, previewView2.a)) {
                    PreviewView previewView3 = PreviewView.this;
                    nVar = new t(previewView3, previewView3.d);
                } else {
                    PreviewView previewView4 = PreviewView.this;
                    nVar = new n(previewView4, previewView4.d);
                }
                previewView2.b = nVar;
            }
            zt ztVarN = cameraInternalK.n();
            PreviewView previewView5 = PreviewView.this;
            final d dVar = new d(ztVarN, previewView5.f, previewView5.b);
            PreviewView.this.g.set(dVar);
            cameraInternalK.g().a(q30.h(PreviewView.this.getContext()), dVar);
            PreviewView.this.b.g(surfaceRequest, new i.a() { // from class: androidx.camera.view.h
                @Override // androidx.camera.view.i.a
                public final void a() {
                    this.a.g(dVar, cameraInternalK);
                }
            });
            PreviewView previewView6 = PreviewView.this;
            if (previewView6.indexOfChild(previewView6.c) == -1) {
                PreviewView previewView7 = PreviewView.this;
                previewView7.addView(previewView7.c);
            }
            PreviewView.this.getClass();
        }
    }

    class b implements DisplayManager.DisplayListener {
        b() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            Display display = PreviewView.this.getDisplay();
            if (display == null || display.getDisplayId() != i) {
                return;
            }
            PreviewView.this.e();
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            PreviewView.this.getClass();
            return true;
        }
    }

    public PreviewView(Context context) {
        this(context, null);
    }

    private void b(boolean z) {
        t23.a();
        getViewPort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
            return;
        }
        e();
        b(true);
    }

    static boolean f(i iVar, SurfaceRequest surfaceRequest, ImplementationMode implementationMode) {
        return (iVar instanceof n) && !g(surfaceRequest, implementationMode);
    }

    static boolean g(SurfaceRequest surfaceRequest, ImplementationMode implementationMode) {
        boolean zEquals = surfaceRequest.k().n().i().equals("androidx.camera.camera2.legacy");
        boolean z = (wa0.a(hy2.class) == null && wa0.a(gy2.class) == null) ? false : true;
        if (zEquals || z) {
            return true;
        }
        int iOrdinal = implementationMode.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal == 1) {
            return true;
        }
        throw new IllegalArgumentException("Invalid implementation mode: " + implementationMode);
    }

    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    private int getViewPortScaleType() {
        int iOrdinal = getScaleType().ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3 && iOrdinal != 4 && iOrdinal != 5) {
                    throw new IllegalStateException("Unexpected scale type: " + getScaleType());
                }
            }
        }
        return i;
    }

    private void h() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.registerDisplayListener(this.l, new Handler(Looper.getMainLooper()));
    }

    private void i() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.unregisterDisplayListener(this.l);
    }

    private void setScreenFlashUiInfo(u.i iVar) {
        x.a("PreviewView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public te3 c(int i) {
        t23.a();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return new te3.a(new Rational(getWidth(), getHeight()), i).c(getViewPortScaleType()).b(getLayoutDirection()).a();
    }

    void e() {
        t23.a();
        if (this.b != null) {
            j();
            this.b.h();
        }
        this.h.a(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public Bitmap getBitmap() {
        t23.a();
        i iVar = this.b;
        if (iVar == null) {
            return null;
        }
        return iVar.a();
    }

    public ft getController() {
        t23.a();
        return null;
    }

    public ImplementationMode getImplementationMode() {
        t23.a();
        return this.a;
    }

    public uj1 getMeteringPointFactory() {
        t23.a();
        return this.h;
    }

    public iy1 getOutputTransform() {
        Matrix matrixJ;
        t23.a();
        try {
            matrixJ = this.d.j(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrixJ = null;
        }
        Rect rectI = this.d.i();
        if (matrixJ == null || rectI == null) {
            x.a("PreviewView", "Transform info is not ready");
            return null;
        }
        matrixJ.preConcat(y43.b(rectI));
        if (this.b instanceof t) {
            matrixJ.postConcat(getMatrix());
        } else if (!getMatrix().isIdentity()) {
            x.k("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        }
        return new iy1(matrixJ, new Size(rectI.width(), rectI.height()));
    }

    public LiveData getPreviewStreamState() {
        return this.f;
    }

    public ScaleType getScaleType() {
        t23.a();
        return this.d.g();
    }

    public u.i getScreenFlash() {
        return this.c.getScreenFlash();
    }

    public Matrix getSensorToViewTransform() {
        t23.a();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return this.d.h(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public n52.c getSurfaceProvider() {
        t23.a();
        return this.n;
    }

    public te3 getViewPort() {
        t23.a();
        if (getDisplay() == null) {
            return null;
        }
        return c(getDisplay().getRotation());
    }

    void j() {
        Display display;
        zt ztVar;
        if (!this.e || (display = getDisplay()) == null || (ztVar = this.j) == null) {
            return;
        }
        this.d.o(ztVar.k(display.getRotation()), display.getRotation());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        addOnLayoutChangeListener(this.m);
        i iVar = this.b;
        if (iVar != null) {
            iVar.d();
        }
        b(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.m);
        i iVar = this.b;
        if (iVar != null) {
            iVar.e();
        }
        i();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        this.k = null;
        return super.performClick();
    }

    public void setController(ft ftVar) {
        t23.a();
        b(false);
        setScreenFlashUiInfo(getScreenFlash());
    }

    public void setImplementationMode(ImplementationMode implementationMode) {
        t23.a();
        this.a = implementationMode;
        ImplementationMode implementationMode2 = ImplementationMode.PERFORMANCE;
    }

    public void setScaleType(ScaleType scaleType) {
        t23.a();
        this.d.q(scaleType);
        e();
        b(false);
    }

    public void setScreenFlashOverlayColor(int i) {
        this.c.setBackgroundColor(i);
    }

    public void setScreenFlashWindow(Window window) {
        t23.a();
        this.c.setScreenFlashWindow(window);
        setScreenFlashUiInfo(getScreenFlash());
    }

    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        ImplementationMode implementationMode = o;
        this.a = implementationMode;
        e eVar = new e();
        this.d = eVar;
        this.e = true;
        this.f = new im1(StreamState.IDLE);
        this.g = new AtomicReference();
        this.h = new j(eVar);
        this.l = new b();
        this.m = new View.OnLayoutChangeListener() { // from class: o62
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                this.a.d(view, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        };
        this.n = new a();
        t23.a();
        Resources.Theme theme = context.getTheme();
        int[] iArr = R$styleable.PreviewView;
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i, i2);
        be3.n0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i, i2);
        try {
            setScaleType(ScaleType.fromId(typedArrayObtainStyledAttributes.getInteger(R$styleable.PreviewView_scaleType, eVar.g().getId())));
            setImplementationMode(ImplementationMode.fromId(typedArrayObtainStyledAttributes.getInteger(R$styleable.PreviewView_implementationMode, implementationMode.getId())));
            typedArrayObtainStyledAttributes.recycle();
            this.i = new ScaleGestureDetector(context, new c());
            if (getBackground() == null) {
                setBackgroundColor(q30.c(getContext(), R.color.black));
            }
            ScreenFlashView screenFlashView = new ScreenFlashView(context);
            this.c = screenFlashView;
            screenFlashView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
