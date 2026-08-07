package defpackage;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class li3 {

    static class a {
        static void a(Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    static class b {
        static void a(Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-257) : systemUiVisibility | 256);
            window.setDecorFitsSystemWindows(z);
        }
    }

    static class c {
        static void a(Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    public static yj3 a(Window window, View view) {
        return new yj3(window, view);
    }

    public static void b(Window window, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            c.a(window, z);
        } else if (i >= 30) {
            b.a(window, z);
        } else {
            a.a(window, z);
        }
    }
}
