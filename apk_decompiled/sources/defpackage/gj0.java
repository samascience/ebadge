package defpackage;

import androidx.camera.core.impl.k;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.v;

/* JADX INFO: loaded from: classes.dex */
public class gj0 {
    public boolean a() {
        xz0 xz0Var = (xz0) ua0.a(xz0.class);
        return xz0Var == null || xz0Var.j(k.i);
    }

    public boolean b(v vVar) {
        return a() && ImageUtil.i(vVar.q());
    }
}
