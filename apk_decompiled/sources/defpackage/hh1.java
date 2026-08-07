package defpackage;

import android.util.Size;
import androidx.camera.core.impl.SurfaceConfig;

/* JADX INFO: loaded from: classes.dex */
public class hh1 {
    private final sj0 a;

    public hh1() {
        this((sj0) xa0.a(sj0.class));
    }

    public Size a(Size size) {
        Size sizeF;
        sj0 sj0Var = this.a;
        return (sj0Var == null || (sizeF = sj0Var.f(SurfaceConfig.ConfigType.PRIV)) == null || sizeF.getWidth() * sizeF.getHeight() <= size.getWidth() * size.getHeight()) ? size : sizeF;
    }

    hh1(sj0 sj0Var) {
        this.a = sj0Var;
    }
}
