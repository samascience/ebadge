package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import defpackage.ie0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    a() {
    }

    public static a a(SurfaceConfig surfaceConfig, int i, Size size, ie0 ie0Var, List list, Config config, Range range) {
        return new b(surfaceConfig, i, size, ie0Var, list, config, range);
    }

    public abstract List b();

    public abstract ie0 c();

    public abstract int d();

    public abstract Config e();

    public abstract Size f();

    public abstract SurfaceConfig g();

    public abstract Range h();

    public x i(Config config) {
        x.a aVarD = x.a(f()).b(c()).d(config);
        if (h() != null) {
            aVarD.c(h());
        }
        return aVarD.a();
    }
}
