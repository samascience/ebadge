package androidx.camera.core.impl;

import defpackage.b52;
import defpackage.ie0;

/* JADX INFO: loaded from: classes.dex */
public interface q extends w {
    public static final Config.a l = Config.a.a("camerax.core.imageInput.inputFormat", Integer.TYPE);
    public static final Config.a m = Config.a.a("camerax.core.imageInput.inputDynamicRange", ie0.class);

    default ie0 k() {
        return (ie0) b52.g((ie0) f(m, ie0.c));
    }

    default int p() {
        return ((Integer) a(l)).intValue();
    }

    default boolean u() {
        return b(m);
    }
}
