package defpackage;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public final class hi3 {
    private final wh a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public hi3(wh whVar) {
        this(whVar, 10, whVar.j() / 2, whVar.g() / 2);
    }

    private nh2[] a(nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, nh2 nh2Var4) {
        float fC = nh2Var.c();
        float fD = nh2Var.d();
        float fC2 = nh2Var2.c();
        float fD2 = nh2Var2.d();
        float fC3 = nh2Var3.c();
        float fD3 = nh2Var3.d();
        float fC4 = nh2Var4.c();
        float fD4 = nh2Var4.d();
        return fC < ((float) this.c) / 2.0f ? new nh2[]{new nh2(fC4 - 1.0f, fD4 + 1.0f), new nh2(fC2 + 1.0f, fD2 + 1.0f), new nh2(fC3 - 1.0f, fD3 - 1.0f), new nh2(fC + 1.0f, fD - 1.0f)} : new nh2[]{new nh2(fC4 + 1.0f, fD4 + 1.0f), new nh2(fC2 + 1.0f, fD2 - 1.0f), new nh2(fC3 - 1.0f, fD3 + 1.0f), new nh2(fC - 1.0f, fD - 1.0f)};
    }

    private boolean b(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.a.d(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.a.d(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private nh2 d(float f, float f2, float f3, float f4) {
        int iC = dh1.c(dh1.a(f, f2, f3, f4));
        float f5 = iC;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iC; i++) {
            float f8 = i;
            int iC2 = dh1.c((f8 * f6) + f);
            int iC3 = dh1.c((f8 * f7) + f2);
            if (this.a.d(iC2, iC3)) {
                return new nh2(iC2, iC3);
            }
        }
        return null;
    }

    public nh2[] c() throws NotFoundException {
        int i = this.d;
        int i2 = this.e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = true;
        while (z7) {
            boolean z8 = false;
            boolean zB = true;
            while (true) {
                if ((!zB && z2) || i2 >= this.c) {
                    break;
                }
                zB = b(i3, i4, i2, false);
                if (zB) {
                    i2++;
                    z2 = true;
                    z8 = true;
                } else if (!z2) {
                    i2++;
                }
            }
            if (i2 < this.c) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z3) || i4 >= this.b) {
                        break;
                    }
                    zB2 = b(i, i2, i4, true);
                    if (zB2) {
                        i4++;
                        z3 = true;
                        z8 = true;
                    } else if (!z3) {
                        i4++;
                    }
                }
                if (i4 < this.b) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z4) || i < 0) {
                            break;
                        }
                        zB3 = b(i3, i4, i, false);
                        if (zB3) {
                            i--;
                            z4 = true;
                            z8 = true;
                        } else if (!z4) {
                            i--;
                        }
                    }
                    if (i >= 0) {
                        z7 = z8;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z6) || i3 < 0) {
                                break;
                            }
                            zB4 = b(i, i2, i3, true);
                            if (zB4) {
                                i3--;
                                z7 = true;
                                z6 = true;
                            } else if (!z6) {
                                i3--;
                            }
                        }
                        if (i3 >= 0) {
                            if (z7) {
                                z5 = true;
                            }
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || !z5) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        nh2 nh2VarD = null;
        nh2 nh2VarD2 = null;
        for (int i6 = 1; nh2VarD2 == null && i6 < i5; i6++) {
            nh2VarD2 = d(i, i4 - i6, i + i6, i4);
        }
        if (nh2VarD2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        nh2 nh2VarD3 = null;
        for (int i7 = 1; nh2VarD3 == null && i7 < i5; i7++) {
            nh2VarD3 = d(i, i3 + i7, i + i7, i3);
        }
        if (nh2VarD3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        nh2 nh2VarD4 = null;
        for (int i8 = 1; nh2VarD4 == null && i8 < i5; i8++) {
            nh2VarD4 = d(i2, i3 + i8, i2 - i8, i3);
        }
        if (nh2VarD4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i9 = 1; nh2VarD == null && i9 < i5; i9++) {
            nh2VarD = d(i2, i4 - i9, i2 - i9, i4);
        }
        if (nh2VarD != null) {
            return a(nh2VarD, nh2VarD2, nh2VarD4, nh2VarD3);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public hi3(wh whVar, int i, int i2, int i3) throws NotFoundException {
        this.a = whVar;
        int iG = whVar.g();
        this.b = iG;
        int iJ = whVar.j();
        this.c = iJ;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.d = i5;
        int i6 = i2 + i4;
        this.e = i6;
        int i7 = i3 - i4;
        this.g = i7;
        int i8 = i3 + i4;
        this.f = i8;
        if (i7 < 0 || i5 < 0 || i8 >= iG || i6 >= iJ) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
