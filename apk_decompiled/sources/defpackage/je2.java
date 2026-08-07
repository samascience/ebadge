package defpackage;

import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* JADX INFO: loaded from: classes3.dex */
public final class je2 {
    private final jt0 a;

    public je2(jt0 jt0Var) {
        this.a = jt0Var;
    }

    private int[] b(kt0 kt0Var) throws ReedSolomonException {
        int iD = kt0Var.d();
        if (iD == 1) {
            return new int[]{kt0Var.c(1)};
        }
        int[] iArr = new int[iD];
        int i = 0;
        for (int i2 = 1; i2 < this.a.f() && i < iD; i2++) {
            if (kt0Var.b(i2) == 0) {
                iArr[i] = this.a.h(i2);
                i++;
            }
        }
        if (i == iD) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] c(kt0 kt0Var, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iH = this.a.h(iArr[i]);
            int iJ = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iJ2 = this.a.j(iArr[i2], iH);
                    iJ = this.a.j(iJ, (iJ2 & 1) == 0 ? iJ2 | 1 : iJ2 & (-2));
                }
            }
            iArr2[i] = this.a.j(kt0Var.b(iH), this.a.h(iJ));
            if (this.a.d() != 0) {
                iArr2[i] = this.a.j(iArr2[i], iH);
            }
        }
        return iArr2;
    }

    private kt0[] d(kt0 kt0Var, kt0 kt0Var2, int i) throws ReedSolomonException {
        if (kt0Var.d() < kt0Var2.d()) {
            kt0Var2 = kt0Var;
            kt0Var = kt0Var2;
        }
        kt0 kt0VarG = this.a.g();
        kt0 kt0VarE = this.a.e();
        do {
            kt0 kt0Var3 = kt0Var2;
            kt0Var2 = kt0Var;
            kt0Var = kt0Var3;
            kt0 kt0Var4 = kt0VarE;
            kt0 kt0Var5 = kt0VarG;
            kt0VarG = kt0Var4;
            if (kt0Var.d() < i / 2) {
                int iC = kt0VarG.c(0);
                if (iC == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iH = this.a.h(iC);
                return new kt0[]{kt0VarG.f(iH), kt0Var.f(iH)};
            }
            if (kt0Var.e()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            kt0 kt0VarG2 = this.a.g();
            int iH2 = this.a.h(kt0Var.c(kt0Var.d()));
            while (kt0Var2.d() >= kt0Var.d() && !kt0Var2.e()) {
                int iD = kt0Var2.d() - kt0Var.d();
                int iJ = this.a.j(kt0Var2.c(kt0Var2.d()), iH2);
                kt0VarG2 = kt0VarG2.a(this.a.b(iD, iJ));
                kt0Var2 = kt0Var2.a(kt0Var.h(iD, iJ));
            }
            kt0VarE = kt0VarG2.g(kt0VarG).a(kt0Var5);
        } while (kt0Var2.d() < kt0Var.d());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void a(int[] iArr, int i) throws ReedSolomonException {
        kt0 kt0Var = new kt0(this.a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            jt0 jt0Var = this.a;
            int iB = kt0Var.b(jt0Var.c(jt0Var.d() + i2));
            iArr2[(i - 1) - i2] = iB;
            if (iB != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        kt0[] kt0VarArrD = d(this.a.b(i, 1), new kt0(this.a, iArr2), i);
        kt0 kt0Var2 = kt0VarArrD[0];
        kt0 kt0Var3 = kt0VarArrD[1];
        int[] iArrB = b(kt0Var2);
        int[] iArrC = c(kt0Var3, iArrB);
        for (int i3 = 0; i3 < iArrB.length; i3++) {
            int length = (iArr.length - 1) - this.a.i(iArrB[i3]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = jt0.a(iArr[length], iArrC[i3]);
        }
    }
}
