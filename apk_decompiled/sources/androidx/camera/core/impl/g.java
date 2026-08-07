package androidx.camera.core.impl;

import defpackage.az0;
import defpackage.e43;
import defpackage.kn2;

/* JADX INFO: loaded from: classes.dex */
public interface g extends w {
    public static final Config.a e = Config.a.a("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);
    public static final Config.a f = Config.a.a("camerax.core.camera.compatibilityId", az0.class);
    public static final Config.a g = Config.a.a("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);
    public static final Config.a h = Config.a.a("camerax.core.camera.SessionProcessor", kn2.class);
    public static final Config.a i = Config.a.a("camerax.core.camera.isZslDisabled", Boolean.class);
    public static final Config.a j = Config.a.a("camerax.core.camera.isPostviewSupported", Boolean.class);
    public static final Config.a k = Config.a.a("camerax.core.camera.isCaptureProcessProgressSupported", Boolean.class);

    default int D() {
        return ((Integer) f(g, 0)).intValue();
    }

    az0 Q();

    default boolean R() {
        return ((Boolean) f(k, Boolean.FALSE)).booleanValue();
    }

    default kn2 X(kn2 kn2Var) {
        e43.a(f(h, kn2Var));
        return null;
    }

    default UseCaseConfigFactory j() {
        return (UseCaseConfigFactory) f(e, UseCaseConfigFactory.a);
    }

    default boolean y() {
        return ((Boolean) f(j, Boolean.FALSE)).booleanValue();
    }
}
