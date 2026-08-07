package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static void a() {
        b(false);
    }

    public static void b(boolean z) {
        for (Activity activity : q.j()) {
            activity.finish();
            if (!z) {
                activity.overridePendingTransition(0, 0);
            }
        }
    }

    public static Activity c(Context context) {
        if (context == null) {
            return null;
        }
        Activity activityD = d(context);
        if (i(activityD)) {
            return activityD;
        }
        return null;
    }

    private static Activity d(Context context) {
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (context instanceof ContextWrapper) {
            if (!(context instanceof Activity)) {
                Activity activityE = e(context);
                if (activityE == null) {
                    arrayList.add(context);
                    context = ((ContextWrapper) context).getBaseContext();
                    if (context == null || arrayList.contains(context)) {
                        break;
                    }
                } else {
                    return activityE;
                }
            } else {
                return (Activity) context;
            }
        }
        return null;
    }

    private static Activity e(Context context) {
        if (context != null && context.getClass().getName().equals("com.android.internal.policy.DecorContext")) {
            try {
                Field declaredField = context.getClass().getDeclaredField("mActivityContext");
                declaredField.setAccessible(true);
                return (Activity) ((WeakReference) declaredField.get(context)).get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String f(String str) {
        if (q.H(str)) {
            return Constants.STR_EMPTY;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = o.a().getPackageManager().queryIntentActivities(intent, 0);
        return (listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) ? Constants.STR_EMPTY : listQueryIntentActivities.get(0).activityInfo.name;
    }

    public static Activity g() {
        return q.y();
    }

    private static Context h() {
        Activity activityG;
        return (!q.B() || (activityG = g()) == null) ? o.a() : activityG;
    }

    public static boolean i(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean j(Context context) {
        return i(c(context));
    }

    private static boolean k(Intent intent) {
        return true;
    }

    private static void l(Context context, Bundle bundle, String str, String str2, Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        o(intent, context, bundle2);
    }

    public static void m(Class cls) {
        Context contextH = h();
        l(contextH, null, contextH.getPackageName(), cls.getName(), null);
    }

    public static boolean n(Intent intent) {
        return o(intent, h(), null);
    }

    private static boolean o(Intent intent, Context context, Bundle bundle) {
        if (!k(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (bundle != null) {
            context.startActivity(intent, bundle);
            return true;
        }
        context.startActivity(intent);
        return true;
    }
}
