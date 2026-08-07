package cn.bertsir.zbar;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.Toast;
import defpackage.eu;
import defpackage.fk2;

/* JADX INFO: loaded from: classes.dex */
public class CameraPreview extends FrameLayout implements SurfaceHolder.Callback {
    private eu a;
    private cn.bertsir.zbar.a b;
    private SurfaceView c;
    private boolean d;
    private Camera.AutoFocusCallback e;
    private Runnable f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraPreview.this.a.a(CameraPreview.this.e);
        }
    }

    class b implements Camera.AutoFocusCallback {
        b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            CameraPreview cameraPreview = CameraPreview.this;
            cameraPreview.postDelayed(cameraPreview.f, 500L);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraPreview.this.a.a(CameraPreview.this.e);
        }
    }

    public CameraPreview(Context context) {
        this(context, null);
    }

    private void h(SurfaceHolder surfaceHolder) {
        try {
            this.a.h(surfaceHolder, this.b);
            this.a.a(this.e);
            this.d = true;
        } catch (Exception e) {
            e.printStackTrace();
            new Handler().postDelayed(new a(), 200L);
        }
    }

    public void d(boolean z) {
        this.a.c(z);
    }

    public boolean e() {
        return this.d;
    }

    public void f() {
        this.a.f();
    }

    public boolean g() {
        try {
            this.a.d();
            this.b.p();
            if (this.c == null) {
                SurfaceView surfaceView = new SurfaceView(getContext());
                this.c = surfaceView;
                addView(surfaceView, new FrameLayout.LayoutParams(-1, -1));
                SurfaceHolder holder = this.c.getHolder();
                holder.addCallback(this);
                holder.setType(3);
            }
            h(this.c.getHolder());
            return true;
        } catch (Exception unused) {
            Toast.makeText(getContext(), "摄像头权限被拒绝！", 0).show();
            return false;
        }
    }

    public void i() {
        removeCallbacks(this.f);
        this.b.q();
        this.a.i();
        this.a.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        i();
        super.onDetachedFromWindow();
    }

    public void setFlash(boolean z) {
        this.a.g(z);
    }

    public void setScanCallback(fk2 fk2Var) {
        this.b.r(fk2Var);
    }

    public void setZoom(float f) {
        this.a.e(f);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        this.a.i();
        h(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.e = new b();
        this.f = new c();
        this.a = new eu(context);
        this.b = new cn.bertsir.zbar.a(context);
    }
}
