package pl.droidsonroids.gif;

import android.content.Context;
import defpackage.uc2;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g {
    private static Context a;

    private static Context a() {
        if (a == null) {
            try {
                a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null);
            } catch (Exception e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return a;
    }

    static void b() {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            uc2.a(a(), "pl_droidsonroids_gif");
        }
    }
}
