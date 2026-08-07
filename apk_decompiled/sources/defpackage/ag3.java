package defpackage;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ag3 extends yf3 {
    private static boolean g = true;

    static class a {
        static void a(View view, int i) {
            view.setTransitionVisibility(i);
        }
    }

    ag3() {
    }

    @Override // defpackage.sf3
    public void f(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i);
        } else if (g) {
            try {
                a.a(view, i);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
