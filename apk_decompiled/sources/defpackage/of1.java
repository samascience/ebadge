package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class of1 {
    private static volatile Handler a;

    public static Handler a() {
        if (a != null) {
            return a;
        }
        synchronized (of1.class) {
            try {
                if (a == null) {
                    a = zv0.a(Looper.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }
}
