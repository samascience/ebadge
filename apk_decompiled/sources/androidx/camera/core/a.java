package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import defpackage.n01;
import defpackage.t11;
import defpackage.vz2;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class a implements v {
    private final Image a;
    private final C0006a[] b;
    private final n01 c;

    /* JADX INFO: renamed from: androidx.camera.core.a$a, reason: collision with other inner class name */
    private static final class C0006a implements v.a {
        private final Image.Plane a;

        C0006a(Image.Plane plane) {
            this.a = plane;
        }

        @Override // androidx.camera.core.v.a
        public int a() {
            return this.a.getRowStride();
        }

        @Override // androidx.camera.core.v.a
        public ByteBuffer b() {
            return this.a.getBuffer();
        }

        @Override // androidx.camera.core.v.a
        public int c() {
            return this.a.getPixelStride();
        }
    }

    a(Image image) {
        this.a = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.b = new C0006a[planes.length];
            for (int i = 0; i < planes.length; i++) {
                this.b[i] = new C0006a(planes[i]);
            }
        } else {
            this.b = new C0006a[0];
        }
        this.c = t11.e(vz2.b(), image.getTimestamp(), 0, new Matrix());
    }

    @Override // androidx.camera.core.v, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // androidx.camera.core.v
    public void d0(Rect rect) {
        this.a.setCropRect(rect);
    }

    @Override // androidx.camera.core.v
    public int getHeight() {
        return this.a.getHeight();
    }

    @Override // androidx.camera.core.v
    public int getWidth() {
        return this.a.getWidth();
    }

    @Override // androidx.camera.core.v
    public n01 h0() {
        return this.c;
    }

    @Override // androidx.camera.core.v
    public int q() {
        return this.a.getFormat();
    }

    @Override // androidx.camera.core.v
    public v.a[] r() {
        return this.b;
    }

    @Override // androidx.camera.core.v
    public Image s0() {
        return this.a;
    }
}
