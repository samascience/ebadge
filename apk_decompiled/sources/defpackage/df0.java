package defpackage;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;

/* JADX INFO: loaded from: classes3.dex */
public abstract class df0 {
    public static void a(Window window, boolean z, Integer num, Integer num2) {
        boolean z2 = num == null || num.intValue() == 0;
        boolean z3 = num2 == null || num2.intValue() == 0;
        if (z2 || z3) {
            int iB = og1.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z2) {
                num = Integer.valueOf(iB);
            }
            if (z3) {
                num2 = Integer.valueOf(iB);
            }
        }
        li3.b(window, !z);
        int iC = c(window.getContext(), z);
        int iB2 = b(window.getContext(), z);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, og1.h(num.intValue())));
        e(window, d(iB2, og1.h(num2.intValue())));
    }

    private static int b(Context context, boolean z) {
        if (z && Build.VERSION.SDK_INT < 27) {
            return pz.k(og1.b(context, R.attr.navigationBarColor, -16777216), 128);
        }
        if (z) {
            return 0;
        }
        return og1.b(context, R.attr.navigationBarColor, -16777216);
    }

    private static int c(Context context, boolean z) {
        if (z) {
            return 0;
        }
        return og1.b(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean d(int i, boolean z) {
        return og1.h(i) || (i == 0 && z);
    }

    public static void e(Window window, boolean z) {
        li3.a(window, window.getDecorView()).c(z);
    }

    public static void f(Window window, boolean z) {
        li3.a(window, window.getDecorView()).d(z);
    }
}
