package defpackage;

import android.util.Size;
import android.view.Surface;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface kx2 extends Closeable {

    public static abstract class a {
        a() {
        }

        public static a c(int i, kx2 kx2Var) {
            return new qd(i, kx2Var);
        }

        public abstract int a();

        public abstract kx2 b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Surface i0(Executor executor, q20 q20Var);

    Size o();

    int q();

    void z(float[] fArr, float[] fArr2);
}
