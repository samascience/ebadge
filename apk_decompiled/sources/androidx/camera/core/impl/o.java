package androidx.camera.core.impl;

import defpackage.e43;
import defpackage.p23;
import defpackage.y01;

/* JADX INFO: loaded from: classes.dex */
public final class o implements d0, r, p23 {
    public static final Config.a J = Config.a.a("camerax.core.imageAnalysis.backpressureStrategy", androidx.camera.core.m.b.class);
    public static final Config.a K = Config.a.a("camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE);
    public static final Config.a L = Config.a.a("camerax.core.imageAnalysis.imageReaderProxyProvider", y01.class);
    public static final Config.a M = Config.a.a("camerax.core.imageAnalysis.outputImageFormat", androidx.camera.core.m.e.class);
    public static final Config.a N = Config.a.a("camerax.core.imageAnalysis.onePixelShiftEnabled", Boolean.class);
    public static final Config.a O = Config.a.a("camerax.core.imageAnalysis.outputImageRotationEnabled", Boolean.class);
    private final u I;

    public o(u uVar) {
        this.I = uVar;
    }

    public int Y(int i) {
        return ((Integer) f(J, Integer.valueOf(i))).intValue();
    }

    public int Z(int i) {
        return ((Integer) f(K, Integer.valueOf(i))).intValue();
    }

    public y01 a0() {
        e43.a(f(L, null));
        return null;
    }

    public Boolean b0(Boolean bool) {
        return (Boolean) f(N, bool);
    }

    public int c0(int i) {
        return ((Integer) f(M, Integer.valueOf(i))).intValue();
    }

    public Boolean d0(Boolean bool) {
        return (Boolean) f(O, bool);
    }

    @Override // androidx.camera.core.impl.w
    public Config n() {
        return this.I;
    }

    @Override // androidx.camera.core.impl.q
    public int p() {
        return 35;
    }
}
