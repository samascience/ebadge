package androidx.camera.core.impl;

import defpackage.e43;
import defpackage.pv;
import defpackage.s31;
import defpackage.wf2;
import defpackage.y01;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class p implements d0, r, s31 {
    public static final Config.a J;
    public static final Config.a K;
    public static final Config.a L;
    public static final Config.a M;
    public static final Config.a N;
    public static final Config.a O;
    public static final Config.a P;
    public static final Config.a Q;
    public static final Config.a R;
    public static final Config.a S;
    public static final Config.a T;
    public static final Config.a U;
    public static final Config.a V;
    private final u I;

    static {
        Class cls = Integer.TYPE;
        J = Config.a.a("camerax.core.imageCapture.captureMode", cls);
        K = Config.a.a("camerax.core.imageCapture.flashMode", cls);
        L = Config.a.a("camerax.core.imageCapture.captureBundle", pv.class);
        M = Config.a.a("camerax.core.imageCapture.bufferFormat", Integer.class);
        N = Config.a.a("camerax.core.imageCapture.outputFormat", Integer.class);
        O = Config.a.a("camerax.core.imageCapture.maxCaptureStages", Integer.class);
        P = Config.a.a("camerax.core.imageCapture.imageReaderProxyProvider", y01.class);
        Q = Config.a.a("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
        R = Config.a.a("camerax.core.imageCapture.flashType", cls);
        S = Config.a.a("camerax.core.imageCapture.jpegCompressionQuality", cls);
        T = Config.a.a("camerax.core.imageCapture.screenFlash", androidx.camera.core.u.i.class);
        U = Config.a.a("camerax.core.useCase.postviewResolutionSelector", wf2.class);
        V = Config.a.a("camerax.core.useCase.isPostviewEnabled", Boolean.class);
    }

    public p(u uVar) {
        this.I = uVar;
    }

    public pv Y(pv pvVar) {
        return (pv) f(L, pvVar);
    }

    public int Z() {
        return ((Integer) a(J)).intValue();
    }

    public int a0(int i) {
        return ((Integer) f(K, Integer.valueOf(i))).intValue();
    }

    public int b0(int i) {
        return ((Integer) f(R, Integer.valueOf(i))).intValue();
    }

    public y01 c0() {
        e43.a(f(P, null));
        return null;
    }

    public Executor d0(Executor executor) {
        return (Executor) f(s31.a, executor);
    }

    public int e0() {
        return ((Integer) a(S)).intValue();
    }

    public androidx.camera.core.u.i f0() {
        return (androidx.camera.core.u.i) f(T, null);
    }

    public boolean g0() {
        return b(J);
    }

    @Override // androidx.camera.core.impl.w
    public Config n() {
        return this.I;
    }

    @Override // androidx.camera.core.impl.q
    public int p() {
        return ((Integer) a(q.l)).intValue();
    }
}
