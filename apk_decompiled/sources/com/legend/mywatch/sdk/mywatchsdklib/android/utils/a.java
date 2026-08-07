package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.app.Activity;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static Activity a() {
        return k.j();
    }

    public static boolean b(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean c(Class cls) {
        Iterator it = k.c().iterator();
        while (it.hasNext()) {
            if (((Activity) it.next()).getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }
}
