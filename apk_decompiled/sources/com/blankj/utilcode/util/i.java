package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    static void a(Activity activity) {
        String strG = q.v().g("KEY_LOCALE");
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        Locale localeB = "VALUE_FOLLOW_SYSTEM".equals(strG) ? b(Resources.getSystem().getConfiguration()) : e(strG);
        if (localeB == null) {
            return;
        }
        g(activity, localeB);
        g(o.a(), localeB);
    }

    private static Locale b(Configuration configuration) {
        return configuration.getLocales().get(0);
    }

    private static boolean c(String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == '$') {
                if (i >= 1) {
                    return false;
                }
                i++;
            }
        }
        return i == 1;
    }

    private static void d(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }

    private static Locale e(String str) {
        Locale localeF = f(str);
        if (localeF == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            q.v().r("KEY_LOCALE");
        }
        return localeF;
    }

    private static Locale f(String str) {
        if (!c(str)) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf("$");
            return new Locale(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    private static void g(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        d(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
