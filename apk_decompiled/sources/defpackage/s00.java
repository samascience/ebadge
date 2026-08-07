package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public abstract class s00 {
    public static int a(int i) {
        return b(i);
    }

    private static int b(int i) {
        return (i & 65280) >> 8;
    }

    public static void c(View view, Runnable runnable) {
        d(view, runnable);
    }

    private static void d(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
