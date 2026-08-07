package com.bumptech.glide.load.engine;

import defpackage.na3;
import defpackage.rx1;
import defpackage.v9;
import defpackage.w81;
import defpackage.z43;
import defpackage.ze1;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class r implements w81 {
    private static final ze1 j = new ze1(50);
    private final v9 b;
    private final w81 c;
    private final w81 d;
    private final int e;
    private final int f;
    private final Class g;
    private final rx1 h;
    private final z43 i;

    r(v9 v9Var, w81 w81Var, w81 w81Var2, int i, int i2, z43 z43Var, Class cls, rx1 rx1Var) {
        this.b = v9Var;
        this.c = w81Var;
        this.d = w81Var2;
        this.e = i;
        this.f = i2;
        this.i = z43Var;
        this.g = cls;
        this.h = rx1Var;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private byte[] a() {
        ze1 ze1Var = j;
        byte[] bArr = (byte[]) ze1Var.g(this.g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.g.getName().getBytes(w81.a);
        ze1Var.k(this.g, bytes);
        return bytes;
    }

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f == rVar.f && this.e == rVar.e && na3.c(this.i, rVar.i) && this.g.equals(rVar.g) && this.c.equals(rVar.c) && this.d.equals(rVar.d) && this.h.equals(rVar.h);
    }

    @Override // defpackage.w81
    public int hashCode() {
        int iHashCode = (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
        z43 z43Var = this.i;
        if (z43Var != null) {
            iHashCode = (iHashCode * 31) + z43Var.hashCode();
        }
        return (((iHashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + "', options=" + this.h + '}';
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.updateDiskCacheKey(messageDigest);
        this.c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        z43 z43Var = this.i;
        if (z43Var != null) {
            z43Var.updateDiskCacheKey(messageDigest);
        }
        this.h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.b.put(bArr);
    }
}
