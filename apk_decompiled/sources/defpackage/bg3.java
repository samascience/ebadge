package defpackage;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class bg3 extends ag3 {
    bg3() {
    }

    @Override // defpackage.sf3
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // defpackage.yf3, defpackage.sf3
    public void d(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // defpackage.sf3
    public void e(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // defpackage.ag3, defpackage.sf3
    public void f(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // defpackage.wf3, defpackage.sf3
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // defpackage.wf3, defpackage.sf3
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
