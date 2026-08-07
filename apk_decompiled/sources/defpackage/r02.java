package defpackage;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class r02 {
    public static Context a;
    private static ss1 b;

    public static p3 a() {
        return p3.c();
    }

    public static ss1 b() {
        return b;
    }

    public static void c(Application application) {
        a = application;
        ze0.a(application, "data_config");
        b = ss1.C(a);
    }
}
