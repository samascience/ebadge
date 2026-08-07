package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    private static Application a;

    public interface a {
        void accept(Object obj);
    }

    public interface b {
        void a(Activity activity);

        void b(Activity activity);
    }

    public static Application a() {
        Application application = a;
        if (application != null) {
            return application;
        }
        b(k.d());
        if (a == null) {
            throw new NullPointerException("reflect failed.");
        }
        Log.i("Utils", k.e() + " reflect app success.");
        return a;
    }

    public static void b(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = a;
        if (application2 == null) {
            a = application;
            k.k(application);
            k.q();
        } else {
            if (application2.equals(application)) {
                return;
            }
            k.u(a);
            a = application;
            k.k(application);
        }
    }
}
