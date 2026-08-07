package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.SessionConfig;

/* JADX INFO: loaded from: classes.dex */
public abstract class f62 {
    public static final Rational a = new Rational(16, 9);

    private static boolean a(Size size, Rational rational) {
        return rational.equals(new Rational(size.getWidth(), size.getHeight()));
    }

    public static void b(Size size, SessionConfig.b bVar) {
        if (((g62) xa0.a(g62.class)) == null || a(size, a)) {
            return;
        }
        yr.a aVar = new yr.a();
        aVar.f(CaptureRequest.TONEMAP_MODE, 2);
        bVar.h(aVar.c());
    }
}
