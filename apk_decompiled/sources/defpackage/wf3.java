package defpackage;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
abstract class wf3 extends sf3 {
    private static boolean d = true;
    private static boolean e = true;

    static class a {
        static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    wf3() {
    }

    @Override // defpackage.sf3
    public void g(View view, Matrix matrix) {
        if (d) {
            try {
                a.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                d = false;
            }
        }
    }

    @Override // defpackage.sf3
    public void h(View view, Matrix matrix) {
        if (e) {
            try {
                a.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
    }
}
