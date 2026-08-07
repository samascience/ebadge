package androidx.camera.core.impl;

import android.util.Size;
import defpackage.oa;
import defpackage.wf2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface r extends w {
    public static final Config.a n = Config.a.a("camerax.core.imageOutput.targetAspectRatio", oa.class);
    public static final Config.a o;
    public static final Config.a p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Config.a f153q;
    public static final Config.a r;
    public static final Config.a s;
    public static final Config.a t;
    public static final Config.a u;
    public static final Config.a v;
    public static final Config.a w;

    static {
        Class cls = Integer.TYPE;
        o = Config.a.a("camerax.core.imageOutput.targetRotation", cls);
        p = Config.a.a("camerax.core.imageOutput.appTargetRotation", cls);
        f153q = Config.a.a("camerax.core.imageOutput.mirrorMode", cls);
        r = Config.a.a("camerax.core.imageOutput.targetResolution", Size.class);
        s = Config.a.a("camerax.core.imageOutput.defaultResolution", Size.class);
        t = Config.a.a("camerax.core.imageOutput.maxResolution", Size.class);
        u = Config.a.a("camerax.core.imageOutput.supportedResolutions", List.class);
        v = Config.a.a("camerax.core.imageOutput.resolutionSelector", wf2.class);
        w = Config.a.a("camerax.core.imageOutput.customOrderedResolutions", List.class);
    }

    static void E(r rVar) {
        boolean zL = rVar.L();
        boolean z = rVar.A(null) != null;
        if (zL && z) {
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }
        if (rVar.H(null) != null) {
            if (zL || z) {
                throw new IllegalArgumentException("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
            }
        }
    }

    default Size A(Size size) {
        return (Size) f(r, size);
    }

    default int B(int i) {
        return ((Integer) f(p, Integer.valueOf(i))).intValue();
    }

    default wf2 H(wf2 wf2Var) {
        return (wf2) f(v, wf2Var);
    }

    default boolean L() {
        return b(n);
    }

    default int O() {
        return ((Integer) a(n)).intValue();
    }

    default int U(int i) {
        return ((Integer) f(o, Integer.valueOf(i))).intValue();
    }

    default int V(int i) {
        return ((Integer) f(f153q, Integer.valueOf(i))).intValue();
    }

    default Size i(Size size) {
        return (Size) f(t, size);
    }

    default List l(List list) {
        return (List) f(u, list);
    }

    default wf2 m() {
        return (wf2) a(v);
    }

    default List o(List list) {
        List list2 = (List) f(w, list);
        if (list2 != null) {
            return new ArrayList(list2);
        }
        return null;
    }

    default Size v(Size size) {
        return (Size) f(s, size);
    }
}
