package androidx.camera.video;

import android.util.Size;
import defpackage.b52;
import defpackage.dh0;
import defpackage.eh0;
import defpackage.ir2;
import defpackage.m00;
import defpackage.vd3;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class n {
    private final Map a = new LinkedHashMap();
    private final TreeMap b = new TreeMap(new m00());
    private final vd3 c;
    private final vd3 d;

    public n(dh0 dh0Var) {
        for (s sVar : s.b()) {
            eh0 eh0VarD = d(sVar, dh0Var);
            if (eh0VarD != null) {
                androidx.camera.core.x.a("CapabilitiesByQuality", "profiles = " + eh0VarD);
                vd3 vd3VarG = g(eh0VarD);
                if (vd3VarG == null) {
                    androidx.camera.core.x.k("CapabilitiesByQuality", "EncoderProfiles of quality " + sVar + " has no video validated profiles.");
                } else {
                    eh0.c cVarK = vd3VarG.k();
                    this.b.put(new Size(cVarK.k(), cVarK.h()), sVar);
                    this.a.put(sVar, vd3VarG);
                }
            }
        }
        if (this.a.isEmpty()) {
            androidx.camera.core.x.c("CapabilitiesByQuality", "No supported EncoderProfiles");
            this.d = null;
            this.c = null;
        } else {
            ArrayDeque arrayDeque = new ArrayDeque(this.a.values());
            this.c = (vd3) arrayDeque.peekFirst();
            this.d = (vd3) arrayDeque.peekLast();
        }
    }

    private static void a(s sVar) {
        b52.b(s.a(sVar), "Unknown quality: " + sVar);
    }

    private eh0 d(s sVar, dh0 dh0Var) {
        b52.j(sVar instanceof s.b, "Currently only support ConstantQuality");
        return dh0Var.b(((s.b) sVar).e());
    }

    private vd3 g(eh0 eh0Var) {
        if (eh0Var.d().isEmpty()) {
            return null;
        }
        return vd3.i(eh0Var);
    }

    public vd3 b(Size size) {
        s sVarC = c(size);
        androidx.camera.core.x.a("CapabilitiesByQuality", "Using supported quality of " + sVarC + " for size " + size);
        if (sVarC == s.g) {
            return null;
        }
        vd3 vd3VarE = e(sVarC);
        if (vd3VarE != null) {
            return vd3VarE;
        }
        throw new AssertionError("Camera advertised available quality but did not produce EncoderProfiles for advertised quality.");
    }

    public s c(Size size) {
        s sVar = (s) ir2.a(size, this.b);
        return sVar != null ? sVar : s.g;
    }

    public vd3 e(s sVar) {
        a(sVar);
        if (sVar == s.f) {
            return this.c;
        }
        return sVar == s.e ? this.d : (vd3) this.a.get(sVar);
    }

    public List f() {
        return new ArrayList(this.a.keySet());
    }
}
