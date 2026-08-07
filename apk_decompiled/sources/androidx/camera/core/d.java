package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import defpackage.of1;
import defpackage.x01;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class d implements x01 {
    private final ImageReader a;
    private final Object b = new Object();
    private boolean c = true;

    d(ImageReader imageReader) {
        this.a = imageReader;
    }

    private boolean j(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(x01.a aVar) {
        aVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Executor executor, final x01.a aVar, ImageReader imageReader) {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    executor.execute(new Runnable() { // from class: androidx.camera.core.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.k(aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.x01
    public Surface a() {
        Surface surface;
        synchronized (this.b) {
            surface = this.a.getSurface();
        }
        return surface;
    }

    @Override // defpackage.x01
    public v c() {
        Image imageAcquireLatestImage;
        synchronized (this.b) {
            try {
                imageAcquireLatestImage = this.a.acquireLatestImage();
            } catch (RuntimeException e) {
                if (!j(e)) {
                    throw e;
                }
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return null;
            }
            return new a(imageAcquireLatestImage);
        }
    }

    @Override // defpackage.x01
    public void close() {
        synchronized (this.b) {
            this.a.close();
        }
    }

    @Override // defpackage.x01
    public int d() {
        int imageFormat;
        synchronized (this.b) {
            imageFormat = this.a.getImageFormat();
        }
        return imageFormat;
    }

    @Override // defpackage.x01
    public void e() {
        synchronized (this.b) {
            this.c = true;
            this.a.setOnImageAvailableListener(null, null);
        }
    }

    @Override // defpackage.x01
    public void f(final x01.a aVar, final Executor executor) {
        synchronized (this.b) {
            this.c = false;
            this.a.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.camera.core.b
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    this.a.l(executor, aVar, imageReader);
                }
            }, of1.a());
        }
    }

    @Override // defpackage.x01
    public int g() {
        int maxImages;
        synchronized (this.b) {
            maxImages = this.a.getMaxImages();
        }
        return maxImages;
    }

    @Override // defpackage.x01
    public int getHeight() {
        int height;
        synchronized (this.b) {
            height = this.a.getHeight();
        }
        return height;
    }

    @Override // defpackage.x01
    public int getWidth() {
        int width;
        synchronized (this.b) {
            width = this.a.getWidth();
        }
        return width;
    }

    @Override // defpackage.x01
    public v h() {
        Image imageAcquireNextImage;
        synchronized (this.b) {
            try {
                imageAcquireNextImage = this.a.acquireNextImage();
            } catch (RuntimeException e) {
                if (!j(e)) {
                    throw e;
                }
                imageAcquireNextImage = null;
            }
            if (imageAcquireNextImage == null) {
                return null;
            }
            return new a(imageAcquireNextImage);
        }
    }
}
