package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
abstract class t00 {
    public static void a(View view, Runnable runnable) {
        b(view, runnable);
    }

    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
