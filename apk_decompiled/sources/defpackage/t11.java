package defpackage;

import android.graphics.Matrix;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: loaded from: classes.dex */
public abstract class t11 implements n01 {
    public static n01 e(vz2 vz2Var, long j, int i, Matrix matrix) {
        return new gd(vz2Var, j, i, matrix);
    }

    @Override // defpackage.n01
    public abstract vz2 a();

    @Override // defpackage.n01
    public void b(ExifData.b bVar) {
        bVar.m(d());
    }

    @Override // defpackage.n01
    public abstract long c();

    @Override // defpackage.n01
    public abstract int d();

    public abstract Matrix f();
}
