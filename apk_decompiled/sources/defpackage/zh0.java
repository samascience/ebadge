package defpackage;

import com.google.zxing.ChecksumException;

/* JADX INFO: loaded from: classes3.dex */
public final class zh0 {
    private final xk1 a = xk1.f;

    private int[] b(yk1 yk1Var) throws ChecksumException {
        int iD = yk1Var.d();
        int[] iArr = new int[iD];
        int i = 0;
        for (int i2 = 1; i2 < this.a.e() && i < iD; i2++) {
            if (yk1Var.b(i2) == 0) {
                iArr[i] = this.a.g(i2);
                i++;
            }
        }
        if (i == iD) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] c(yk1 yk1Var, yk1 yk1Var2, int[] iArr) {
        int iD = yk1Var2.d();
        int[] iArr2 = new int[iD];
        for (int i = 1; i <= iD; i++) {
            iArr2[iD - i] = this.a.i(i, yk1Var2.c(i));
        }
        yk1 yk1Var3 = new yk1(this.a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iG = this.a.g(iArr[i2]);
            iArr3[i2] = this.a.i(this.a.j(0, yk1Var.b(iG)), this.a.g(yk1Var3.b(iG)));
        }
        return iArr3;
    }

    private yk1[] d(yk1 yk1Var, yk1 yk1Var2, int i) throws ChecksumException {
        if (yk1Var.d() < yk1Var2.d()) {
            yk1Var2 = yk1Var;
            yk1Var = yk1Var2;
        }
        yk1 yk1VarF = this.a.f();
        yk1 yk1VarD = this.a.d();
        while (true) {
            yk1 yk1Var3 = yk1Var2;
            yk1Var2 = yk1Var;
            yk1Var = yk1Var3;
            yk1 yk1Var4 = yk1VarD;
            yk1 yk1Var5 = yk1VarF;
            yk1VarF = yk1Var4;
            if (yk1Var.d() < i / 2) {
                int iC = yk1VarF.c(0);
                if (iC == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int iG = this.a.g(iC);
                return new yk1[]{yk1VarF.f(iG), yk1Var.f(iG)};
            }
            if (yk1Var.e()) {
                throw ChecksumException.getChecksumInstance();
            }
            yk1 yk1VarF2 = this.a.f();
            int iG2 = this.a.g(yk1Var.c(yk1Var.d()));
            while (yk1Var2.d() >= yk1Var.d() && !yk1Var2.e()) {
                int iD = yk1Var2.d() - yk1Var.d();
                int i2 = this.a.i(yk1Var2.c(yk1Var2.d()), iG2);
                yk1VarF2 = yk1VarF2.a(this.a.b(iD, i2));
                yk1Var2 = yk1Var2.j(yk1Var.h(iD, i2));
            }
            yk1VarD = yk1VarF2.g(yk1VarF).j(yk1Var5).i();
        }
    }

    public int a(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        yk1 yk1Var = new yk1(this.a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iB = yk1Var.b(this.a.c(i2));
            iArr3[i - i2] = iB;
            if (iB != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        yk1 yk1VarD = this.a.d();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iC = this.a.c((iArr.length - 1) - i3);
                xk1 xk1Var = this.a;
                yk1VarD = yk1VarD.g(new yk1(xk1Var, new int[]{xk1Var.j(0, iC), 1}));
            }
        }
        yk1[] yk1VarArrD = d(this.a.b(i, 1), new yk1(this.a, iArr3), i);
        yk1 yk1Var2 = yk1VarArrD[0];
        yk1 yk1Var3 = yk1VarArrD[1];
        int[] iArrB = b(yk1Var2);
        int[] iArrC = c(yk1Var3, yk1Var2, iArrB);
        for (int i4 = 0; i4 < iArrB.length; i4++) {
            int length = (iArr.length - 1) - this.a.h(iArrB[i4]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.a.j(iArr[length], iArrC[i4]);
        }
        return iArrB.length;
    }
}
