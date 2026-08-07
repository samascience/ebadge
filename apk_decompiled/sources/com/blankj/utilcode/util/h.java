package com.blankj.utilcode.util;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    private static Intent a(Intent intent, boolean z) {
        return z ? intent.addFlags(268435456) : intent;
    }

    public static Intent b(String str) {
        return c(str, false);
    }

    public static Intent c(String str, boolean z) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return a(intent, z);
    }

    public static Intent d(String str) {
        String strS = q.s(str);
        if (q.H(strS)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(str, strS);
        return intent.addFlags(268435456);
    }

    public static boolean e(Intent intent) {
        return o.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
