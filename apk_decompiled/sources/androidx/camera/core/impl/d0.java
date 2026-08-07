package androidx.camera.core.impl;

import android.util.Range;
import defpackage.m03;
import defpackage.oj0;

/* JADX INFO: loaded from: classes.dex */
public interface d0 extends m03, q {
    public static final Config.a B;
    public static final Config.a C;
    public static final Config.a D;
    public static final Config.a E;
    public static final Config.a F;
    public static final Config.a G;
    public static final Config.a H;
    public static final Config.a x = Config.a.a("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);
    public static final Config.a y = Config.a.a("camerax.core.useCase.defaultCaptureConfig", k.class);
    public static final Config.a z = Config.a.a("camerax.core.useCase.sessionConfigUnpacker", SessionConfig.d.class);
    public static final Config.a A = Config.a.a("camerax.core.useCase.captureConfigUnpacker", k.b.class);

    public interface a extends oj0 {
        d0 b();
    }

    static {
        Class cls = Integer.TYPE;
        B = Config.a.a("camerax.core.useCase.surfaceOccupancyPriority", cls);
        C = Config.a.a("camerax.core.useCase.targetFrameRate", Range.class);
        Class cls2 = Boolean.TYPE;
        D = Config.a.a("camerax.core.useCase.zslDisabled", cls2);
        E = Config.a.a("camerax.core.useCase.highResolutionDisabled", cls2);
        F = Config.a.a("camerax.core.useCase.captureType", UseCaseConfigFactory.CaptureType.class);
        G = Config.a.a("camerax.core.useCase.previewStabilizationMode", cls);
        H = Config.a.a("camerax.core.useCase.videoStabilizationMode", cls);
    }

    default UseCaseConfigFactory.CaptureType F() {
        return (UseCaseConfigFactory.CaptureType) a(F);
    }

    default int G() {
        return ((Integer) f(H, 0)).intValue();
    }

    default Range J(Range range) {
        return (Range) f(C, range);
    }

    default int N(int i) {
        return ((Integer) f(B, Integer.valueOf(i))).intValue();
    }

    default int P() {
        return ((Integer) f(G, 0)).intValue();
    }

    default SessionConfig.d T(SessionConfig.d dVar) {
        return (SessionConfig.d) f(z, dVar);
    }

    default boolean q(boolean z2) {
        return ((Boolean) f(E, Boolean.valueOf(z2))).booleanValue();
    }

    default SessionConfig r(SessionConfig sessionConfig) {
        return (SessionConfig) f(x, sessionConfig);
    }

    default k.b t(k.b bVar) {
        return (k.b) f(A, bVar);
    }

    default boolean w(boolean z2) {
        return ((Boolean) f(D, Boolean.valueOf(z2))).booleanValue();
    }

    default k z(k kVar) {
        return (k) f(y, kVar);
    }
}
