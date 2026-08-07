package androidx.fragment.app;

import android.view.View;
import defpackage.mq0;
import defpackage.u9;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
abstract class n {
    static final p a = new o();
    static final p b = b();

    static void a(Fragment fragment, Fragment fragment2, boolean z, u9 u9Var, boolean z2) {
        if (z) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static p b() {
        try {
            return (p) mq0.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static void c(u9 u9Var, u9 u9Var2) {
        for (int size = u9Var.size() - 1; size >= 0; size--) {
            if (!u9Var2.containsKey((String) u9Var.l(size))) {
                u9Var.j(size);
            }
        }
    }

    static void d(ArrayList arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i);
        }
    }
}
