package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class uc0 extends e1 {
    @Override // defpackage.e1
    long b() {
        return Double.doubleToRawLongBits(Double.NaN);
    }

    @Override // defpackage.e1
    long c() {
        return Double.doubleToRawLongBits(Double.NEGATIVE_INFINITY);
    }

    @Override // defpackage.e1
    long i() {
        return Double.doubleToRawLongBits(Double.POSITIVE_INFINITY);
    }

    @Override // defpackage.e1
    long l(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        double dC = jk0.c(z, j, i3, z2, i4);
        if (Double.isNaN(dC)) {
            dC = Double.parseDouble(charSequence.subSequence(i, i2).toString());
        }
        return Double.doubleToRawLongBits(dC);
    }

    @Override // defpackage.e1
    long m(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        double dE = jk0.e(z, j, i3, z2, i4);
        if (Double.isNaN(dE)) {
            dE = Double.parseDouble(charSequence.subSequence(i, i2).toString());
        }
        return Double.doubleToRawLongBits(dE);
    }
}
