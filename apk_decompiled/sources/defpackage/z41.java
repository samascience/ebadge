package defpackage;

import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.b0;
import androidx.camera.core.v;
import androidx.camera.core.w;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class z41 implements uw1 {
    @Override // defpackage.uw1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public xy1 apply(xy1 xy1Var) {
        b0 b0Var = new b0(w.a(xy1Var.h().getWidth(), xy1Var.h().getHeight(), 256, 2));
        v vVarE = ImageProcessingUtil.e(b0Var, (byte[]) xy1Var.c());
        b0Var.m();
        Objects.requireNonNull(vVarE);
        bj0 bj0VarD = xy1Var.d();
        Objects.requireNonNull(bj0VarD);
        return xy1.k(vVarE, bj0VarD, xy1Var.b(), xy1Var.f(), xy1Var.g(), xy1Var.a());
    }
}
