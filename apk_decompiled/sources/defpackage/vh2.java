package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.v;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class vh2 implements v {
    private final Object a;
    private final int b;
    private final int c;
    private final Rect d;
    v.a[] e;
    private final n01 f;

    class a implements v.a {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ ByteBuffer c;

        a(int i, int i2, ByteBuffer byteBuffer) {
            this.a = i;
            this.b = i2;
            this.c = byteBuffer;
        }

        @Override // androidx.camera.core.v.a
        public int a() {
            return this.a;
        }

        @Override // androidx.camera.core.v.a
        public ByteBuffer b() {
            return this.c;
        }

        @Override // androidx.camera.core.v.a
        public int c() {
            return this.b;
        }
    }

    class b implements n01 {
        final /* synthetic */ long a;
        final /* synthetic */ int b;
        final /* synthetic */ Matrix c;

        b(long j, int i, Matrix matrix) {
            this.a = j;
            this.b = i;
            this.c = matrix;
        }

        @Override // defpackage.n01
        public vz2 a() {
            throw new UnsupportedOperationException("Custom ImageProxy does not contain TagBundle");
        }

        @Override // defpackage.n01
        public void b(ExifData.b bVar) {
            throw new UnsupportedOperationException("Custom ImageProxy does not contain Exif data.");
        }

        @Override // defpackage.n01
        public long c() {
            return this.a;
        }

        @Override // defpackage.n01
        public int d() {
            return this.b;
        }
    }

    public vh2(xy1 xy1Var) {
        this((Bitmap) xy1Var.c(), xy1Var.b(), xy1Var.f(), xy1Var.g(), xy1Var.a().c());
    }

    private void n() {
        synchronized (this.a) {
            b52.j(this.e != null, "The image is closed.");
        }
    }

    private static n01 u(long j, int i, Matrix matrix) {
        return new b(j, i, matrix);
    }

    private static v.a w(ByteBuffer byteBuffer, int i, int i2) {
        return new a(i, i2, byteBuffer);
    }

    @Override // androidx.camera.core.v, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            n();
            this.e = null;
        }
    }

    @Override // androidx.camera.core.v
    public void d0(Rect rect) {
        synchronized (this.a) {
            try {
                n();
                if (rect != null) {
                    this.d.set(rect);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.v
    public int getHeight() {
        int i;
        synchronized (this.a) {
            n();
            i = this.c;
        }
        return i;
    }

    @Override // androidx.camera.core.v
    public int getWidth() {
        int i;
        synchronized (this.a) {
            n();
            i = this.b;
        }
        return i;
    }

    @Override // androidx.camera.core.v
    public n01 h0() {
        n01 n01Var;
        synchronized (this.a) {
            n();
            n01Var = this.f;
        }
        return n01Var;
    }

    @Override // androidx.camera.core.v
    public int q() {
        synchronized (this.a) {
            n();
        }
        return 1;
    }

    @Override // androidx.camera.core.v
    public v.a[] r() {
        v.a[] aVarArr;
        synchronized (this.a) {
            n();
            v.a[] aVarArr2 = this.e;
            Objects.requireNonNull(aVarArr2);
            aVarArr = aVarArr2;
        }
        return aVarArr;
    }

    @Override // androidx.camera.core.v
    public Image s0() {
        synchronized (this.a) {
            n();
        }
        return null;
    }

    public vh2(Bitmap bitmap, Rect rect, int i, Matrix matrix, long j) {
        this(ImageUtil.e(bitmap), 4, bitmap.getWidth(), bitmap.getHeight(), rect, i, matrix, j);
    }

    public vh2(ByteBuffer byteBuffer, int i, int i2, int i3, Rect rect, int i4, Matrix matrix, long j) {
        this.a = new Object();
        this.b = i2;
        this.c = i3;
        this.d = rect;
        this.f = u(j, i4, matrix);
        byteBuffer.rewind();
        this.e = new v.a[]{w(byteBuffer, i2 * i, i)};
    }
}
