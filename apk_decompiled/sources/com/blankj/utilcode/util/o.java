package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    private static Application a;

    public static class a {
        public abstract void a(Activity activity);

        public void b(Activity activity) {
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public void e(Activity activity) {
        }

        public void f(Activity activity) {
        }

        public void g(Activity activity, Lifecycle.Event event) {
        }
    }

    public interface b {
        void accept(Object obj);
    }

    public interface c {
        void a(Activity activity);

        void b(Activity activity);
    }

    public static Application a() {
        Application application = a;
        if (application != null) {
            return application;
        }
        b(q.l());
        if (a == null) {
            throw new NullPointerException("reflect failed.");
        }
        Log.i("Utils", q.m() + " reflect app success.");
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
            q.z(application);
            q.J();
        } else {
            if (application2.equals(application)) {
                return;
            }
            q.Q(a);
            a = application;
            q.z(application);
        }
    }
}
