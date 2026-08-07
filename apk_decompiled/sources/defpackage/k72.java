package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.l;
import androidx.camera.core.u;
import androidx.camera.core.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class k72 {
    private final int a;
    private final u.g b;
    private final Rect c;
    private final int d;
    private final int e;
    private final Matrix f;
    private final wz2 g;
    private final String h;
    private final List i = new ArrayList();
    final ub1 j;

    k72(pv pvVar, u.g gVar, Rect rect, int i, int i2, Matrix matrix, wz2 wz2Var, ub1 ub1Var, int i3) {
        this.a = i3;
        this.b = gVar;
        this.e = i2;
        this.d = i;
        this.c = rect;
        this.f = matrix;
        this.g = wz2Var;
        this.h = String.valueOf(pvVar.hashCode());
        List listA = pvVar.a();
        Objects.requireNonNull(listA);
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            this.i.add(Integer.valueOf(((l) it.next()).getId()));
        }
        this.j = ub1Var;
    }

    ub1 a() {
        return this.j;
    }

    Rect b() {
        return this.c;
    }

    int c() {
        return this.e;
    }

    u.g d() {
        return this.b;
    }

    public int e() {
        return this.a;
    }

    int f() {
        return this.d;
    }

    Matrix g() {
        return this.f;
    }

    List h() {
        return this.i;
    }

    String i() {
        return this.h;
    }

    boolean j() {
        return this.g.c();
    }

    boolean k() {
        return d() == null;
    }

    void l(ImageCaptureException imageCaptureException) {
        this.g.d(imageCaptureException);
    }

    void m() {
        this.g.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(u.h hVar) {
        this.g.f(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(v vVar) {
        this.g.h(vVar);
    }

    void p() {
        this.g.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Bitmap bitmap) {
        this.g.a(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(ImageCaptureException imageCaptureException) {
        this.g.g(imageCaptureException);
    }
}
