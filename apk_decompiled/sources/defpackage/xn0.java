package defpackage;

/* JADX INFO: loaded from: classes.dex */
class xn0 extends e1 {
    @Override // defpackage.e1
    long b() {
        return Float.floatToRawIntBits(Float.NaN);
    }

    @Override // defpackage.e1
    long c() {
        return Float.floatToRawIntBits(Float.NEGATIVE_INFINITY);
    }

    @Override // defpackage.e1
    long i() {
        return Float.floatToRawIntBits(Float.POSITIVE_INFINITY);
    }

    @Override // defpackage.e1
    long l(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        float fA = mk0.a(z, j, i3, z2, i4);
        if (Float.isNaN(fA)) {
            fA = Float.parseFloat(charSequence.subSequence(i, i2).toString());
        }
        return Float.floatToRawIntBits(fA);
    }

    @Override // defpackage.e1
    long m(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        float fB = mk0.b(z, j, i3, z2, i4);
        if (Float.isNaN(fB)) {
            fB = Float.parseFloat(charSequence.subSequence(i, i2).toString());
        }
        return Float.floatToRawIntBits(fB);
    }
}
