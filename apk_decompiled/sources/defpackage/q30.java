package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class q30 {
    private static final Object a = new Object();

    static class a {
        static Drawable a(Context context, int i) {
            return context.getDrawable(i);
        }
    }

    static class b {
        static int a(Context context, int i) {
            return context.getColor(i);
        }

        static Object b(Context context, Class cls) {
            return context.getSystemService(cls);
        }
    }

    static class c {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    static class d {
        static ComponentName a(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    static class e {
        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    public static int a(Context context, String str) {
        tt1.d(str, "permission must be non-null");
        if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return as1.d(context).a() ? 0 : -1;
    }

    public static Context b(Context context) {
        return c.a(context);
    }

    public static int c(Context context, int i) {
        return b.a(context, i);
    }

    public static ColorStateList d(Context context, int i) {
        return bh2.d(context.getResources(), i, context.getTheme());
    }

    public static Drawable e(Context context, int i) {
        return a.a(context, i);
    }

    public static File[] f(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] g(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static Executor h(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? e.a(context) : zi0.a(new Handler(context.getMainLooper()));
    }

    public static Object i(Context context, Class cls) {
        return b.b(context, cls);
    }

    public static boolean j(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void k(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void l(Context context, Intent intent) {
        d.a(context, intent);
    }
}
