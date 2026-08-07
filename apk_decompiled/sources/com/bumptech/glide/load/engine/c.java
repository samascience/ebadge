package com.bumptech.glide.load.engine;

import defpackage.w81;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class c implements w81 {
    private final w81 b;
    private final w81 c;

    c(w81 w81Var, w81 w81Var2) {
        this.b = w81Var;
        this.c = w81Var2;
    }

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.b.equals(cVar.b) && this.c.equals(cVar.c);
    }

    @Override // defpackage.w81
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
        this.c.updateDiskCacheKey(messageDigest);
    }
}
