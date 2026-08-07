package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class GifTextureView extends TextureView {
    private static final ImageView.ScaleType[] g = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private ImageView.ScaleType a;
    private final Matrix b;
    private e c;
    private c d;
    private float e;
    private d.b f;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public interface b {
    }

    private static class c extends Thread implements TextureView.SurfaceTextureListener {
        final pl.droidsonroids.gif.a a;
        private GifInfoHandle b;
        private IOException c;
        long[] d;
        private final WeakReference e;

        class a implements Runnable {
            final /* synthetic */ GifTextureView a;

            a(GifTextureView gifTextureView) {
                this.a = gifTextureView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.i(c.this.b);
            }
        }

        c(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.a = new pl.droidsonroids.gif.a();
            this.b = new GifInfoHandle();
            this.e = new WeakReference(gifTextureView);
        }

        void c(GifTextureView gifTextureView, b bVar) {
            this.a.b();
            gifTextureView.setSuperSurfaceTextureListener(bVar != null ? new h(bVar) : null);
            this.b.s();
            interrupt();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            GifTextureView gifTextureView = (GifTextureView) this.e.get();
            if (gifTextureView != null) {
                gifTextureView.i(this.b);
            }
            this.a.c();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.a.b();
            this.b.s();
            interrupt();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                GifTextureView gifTextureView = (GifTextureView) this.e.get();
                if (gifTextureView == null) {
                    return;
                }
                GifInfoHandle gifInfoHandleA = gifTextureView.c.a();
                this.b = gifInfoHandleA;
                gifInfoHandleA.B((char) 1, gifTextureView.isOpaque());
                if (gifTextureView.f.b >= 0) {
                    this.b.A(gifTextureView.f.b);
                }
                GifTextureView gifTextureView2 = (GifTextureView) this.e.get();
                if (gifTextureView2 == null) {
                    this.b.t();
                    return;
                }
                gifTextureView2.setSuperSurfaceTextureListener(this);
                boolean zIsAvailable = gifTextureView2.isAvailable();
                this.a.d(zIsAvailable);
                if (zIsAvailable) {
                    gifTextureView2.post(new a(gifTextureView2));
                }
                this.b.C(gifTextureView2.e);
                while (!isInterrupted()) {
                    try {
                        this.a.a();
                        GifTextureView gifTextureView3 = (GifTextureView) this.e.get();
                        if (gifTextureView3 == null) {
                            break;
                        }
                        SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                        if (surfaceTexture != null) {
                            Surface surface = new Surface(surfaceTexture);
                            try {
                                this.b.a(surface, this.d);
                                surface.release();
                            } catch (Throwable th) {
                                surface.release();
                                throw th;
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.b.t();
                this.b = new GifInfoHandle();
            } catch (IOException e) {
                this.c = e;
            }
        }
    }

    public GifTextureView(Context context) {
        super(context);
        this.a = ImageView.ScaleType.FIT_CENTER;
        this.b = new Matrix();
        this.e = 1.0f;
        g(null, 0, 0);
    }

    private static e f(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(R$styleable.GifTextureView_gifSource, typedValue)) {
            return null;
        }
        if (typedValue.resourceId != 0) {
            String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
            if (d.a.contains(resourceTypeName)) {
                return new e.c(typedArray.getResources(), typedValue.resourceId);
            }
            if (!"string".equals(resourceTypeName)) {
                throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
            }
        }
        return new e.b(typedArray.getResources().getAssets(), typedValue.string.toString());
    }

    private void g(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = g;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.a = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.GifTextureView, i, i2);
            this.c = f(typedArrayObtainStyledAttributes);
            super.setOpaque(typedArrayObtainStyledAttributes.getBoolean(R$styleable.GifTextureView_isOpaque, false));
            typedArrayObtainStyledAttributes.recycle();
            this.f = new d.b(this, attributeSet, i, i2);
        } else {
            super.setOpaque(false);
            this.f = new d.b();
        }
        if (isInEditMode()) {
            return;
        }
        c cVar = new c(this);
        this.d = cVar;
        if (this.c != null) {
            cVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float fN = gifInfoHandle.n() / width;
        float fG = gifInfoHandle.g() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.n(), gifInfoHandle.g());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        switch (a.a[this.a.ordinal()]) {
            case 1:
                matrix.setScale(fN, fG, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float fMin = 1.0f / Math.min(fN, fG);
                matrix.setScale(fN * fMin, fMin * fG, width / 2.0f, height / 2.0f);
                break;
            case 3:
                float fMin2 = (((float) gifInfoHandle.n()) > width || ((float) gifInfoHandle.g()) > height) ? Math.min(1.0f / fN, 1.0f / fG) : 1.0f;
                matrix.setScale(fN * fMin2, fMin2 * fG, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(fN, fG);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(fN, fG);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(fN, fG);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.b);
                matrix.preScale(fN, fG);
                break;
        }
        super.setTransform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    public IOException getIOException() {
        return this.d.c != null ? this.d.c : GifIOException.fromCode(this.d.b.j());
    }

    public ImageView.ScaleType getScaleType() {
        return this.a;
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.b);
        return matrix;
    }

    public synchronized void h(e eVar, b bVar) {
        this.d.c(this, bVar);
        try {
            this.d.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.c = eVar;
        c cVar = new c(this);
        this.d = cVar;
        if (eVar != null) {
            cVar.start();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.d.c(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.d.d = gifViewSavedState.a[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = this.d;
        cVar.d = cVar.b.m();
        return new GifViewSavedState(super.onSaveInstanceState(), this.f.a ? this.d.d : null);
    }

    public void setFreezesAnimation(boolean z) {
        this.f.a = z;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(e eVar) {
        h(eVar, null);
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z) {
        if (z != isOpaque()) {
            super.setOpaque(z);
            setInputSource(this.c);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.a = scaleType;
        i(this.d.b);
    }

    public void setSpeed(float f) {
        this.e = f;
        this.d.b.C(f);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.b.set(matrix);
        i(this.d.b);
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = ImageView.ScaleType.FIT_CENTER;
        this.b = new Matrix();
        this.e = 1.0f;
        g(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = ImageView.ScaleType.FIT_CENTER;
        this.b = new Matrix();
        this.e = 1.0f;
        g(attributeSet, i, 0);
    }
}
