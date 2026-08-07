package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
abstract class yf3 extends wf3 {
    private static boolean f = true;

    static class a {
        static void a(View view, int i, int i2, int i3, int i4) {
            view.setLeftTopRightBottom(i, i2, i3, i4);
        }
    }

    yf3() {
    }

    @Override // defpackage.sf3
    public void d(View view, int i, int i2, int i3, int i4) {
        if (f) {
            try {
                a.a(view, i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }
}
