package com.bumptech.glide.load.engine;

import defpackage.rx1;
import defpackage.w81;
import defpackage.z42;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class k implements w81 {
    private final Object b;
    private final int c;
    private final int d;
    private final Class e;
    private final Class f;
    private final w81 g;
    private final Map h;
    private final rx1 i;
    private int j;

    k(Object obj, w81 w81Var, int i, int i2, Map map, Class cls, Class cls2, rx1 rx1Var) {
        this.b = z42.d(obj);
        this.g = (w81) z42.e(w81Var, "Signature must not be null");
        this.c = i;
        this.d = i2;
        this.h = (Map) z42.d(map);
        this.e = (Class) z42.e(cls, "Resource class must not be null");
        this.f = (Class) z42.e(cls2, "Transcode class must not be null");
        this.i = (rx1) z42.d(rx1Var);
    }

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.b.equals(kVar.b) && this.g.equals(kVar.g) && this.d == kVar.d && this.c == kVar.c && this.h.equals(kVar.h) && this.e.equals(kVar.e) && this.f.equals(kVar.f) && this.i.equals(kVar.i);
    }

    @Override // defpackage.w81
    public int hashCode() {
        if (this.j == 0) {
            int iHashCode = this.b.hashCode();
            this.j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.g.hashCode()) * 31) + this.c) * 31) + this.d;
            this.j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.h.hashCode();
            this.j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.e.hashCode();
            this.j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f.hashCode();
            this.j = iHashCode5;
            this.j = (iHashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
