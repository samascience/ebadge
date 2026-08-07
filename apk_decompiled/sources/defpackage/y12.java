package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y12 {
    private static void a(Context context, Locale locale) {
        b(context, locale, false);
    }

    private static void b(Context context, Locale locale, boolean z) {
        if (z) {
            gj2.d().f("KEY_LOCALE", "VALUE_FOLLOW_SYSTEM");
        } else {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            gj2.d().f("KEY_LOCALE", language + "$" + country);
        }
        f(context, locale);
    }

    private static boolean c(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void d(Context context, int i) {
        WeakReference weakReference = new WeakReference(context);
        if (i >= 0) {
            a((Context) weakReference.get(), wc1.a(i));
        } else {
            e((Context) weakReference.get());
        }
    }

    private static void e(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(Locale.getDefault());
        context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    private static void f(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale2 = configuration.locale;
        if (c(locale2.getLanguage(), locale.getLanguage()) && c(locale2.getCountry(), locale.getCountry())) {
            return;
        }
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(locale);
        context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
    }
}
