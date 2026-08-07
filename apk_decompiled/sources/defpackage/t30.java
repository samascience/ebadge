package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class t30 {

    private static class a {
        static Context a(Context context, String str) {
            return context.createAttributionContext(str);
        }

        static String b(Context context) {
            return context.getAttributionTag();
        }
    }

    private static class b {
        static Context a(Context context, int i) {
            return context.createDeviceContext(i);
        }

        static int b(Context context) {
            return context.getDeviceId();
        }
    }

    public static Context a(Context context) {
        int iB;
        Context applicationContext = context.getApplicationContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 34 && (iB = b.b(context)) != b.b(applicationContext)) {
            applicationContext = b.a(applicationContext, iB);
        }
        if (i < 30) {
            return applicationContext;
        }
        String strB = a.b(context);
        return !Objects.equals(strB, a.b(applicationContext)) ? a.a(applicationContext, strB) : applicationContext;
    }

    public static Application b(Context context) {
        for (Context contextA = a(context); contextA instanceof ContextWrapper; contextA = ((ContextWrapper) contextA).getBaseContext()) {
            if (contextA instanceof Application) {
                return (Application) contextA;
            }
        }
        return null;
    }
}
