package defpackage;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class r30 {
    private static Context a = a();

    public static Context a() {
        Context context = a;
        if (context != null) {
            return context;
        }
        Context context2 = tu0.s;
        if (context2 != null) {
            return context2;
        }
        Application applicationB = b();
        if (applicationB != null) {
            a = applicationB.getApplicationContext();
        }
        return a;
    }

    private static Application b() {
        Application application;
        Exception e;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            application = (Application) cls.getMethod("currentApplication", null).invoke(null, null);
            if (application != null) {
                return application;
            }
            try {
                return (Application) cls.getMethod("getApplication", null).invoke(cls.getMethod("currentActivityThread", null).invoke(null, null), null);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return application;
            }
        } catch (Exception e3) {
            application = null;
            e = e3;
        }
    }
}
