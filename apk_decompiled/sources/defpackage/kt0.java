package defpackage;

/* JADX INFO: loaded from: classes3.dex */
final class kt0 {
    private final jt0 a;
    private final int[] b;

    kt0(jt0 jt0Var, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = jt0Var;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    kt0 a(kt0 kt0Var) {
        if (!this.a.equals(kt0Var.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e()) {
            return kt0Var;
        }
        if (kt0Var.e()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = kt0Var.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = jt0.a(iArr2[i - length], iArr[i]);
        }
        return new kt0(this.a, iArr3);
    }

    int b(int i) {
        if (i == 0) {
            return c(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : this.b) {
                iA = jt0.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iA2 = jt0.a(this.a.j(i, iA2), this.b[i3]);
        }
        return iA2;
    }

    int c(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    int d() {
        return this.b.length - 1;
    }

    boolean e() {
        return this.b[0] == 0;
    }

    kt0 f(int i) {
        if (i == 0) {
            return this.a.g();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.j(this.b[i2], i);
        }
        return new kt0(this.a, iArr);
    }

    kt0 g(kt0 kt0Var) {
        if (!this.a.equals(kt0Var.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e() || kt0Var.e()) {
            return this.a.g();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = kt0Var.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = jt0.a(iArr3[i4], this.a.j(i2, iArr2[i3]));
            }
        }
        return new kt0(this.a, iArr3);
    }

    kt0 h(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.a.g();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.j(this.b[i3], i2);
        }
        return new kt0(this.a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    int i = this.a.i(iC);
                    if (i == 0) {
                        sb.append('1');
                    } else if (i == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i);
                    }
                }
                if (iD != 0) {
                    if (iD == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iD);
                    }
                }
            }
        }
        return sb.toString();
    }
}
