package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import defpackage.nh2;
import defpackage.wh;

/* JADX INFO: loaded from: classes3.dex */
final class c {
    private wh a;
    private nh2 b;
    private nh2 c;
    private nh2 d;
    private nh2 e;
    private int f;
    private int g;
    private int h;
    private int i;

    c(wh whVar, nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, nh2 nh2Var4) throws NotFoundException {
        if ((nh2Var == null && nh2Var3 == null) || ((nh2Var2 == null && nh2Var4 == null) || ((nh2Var != null && nh2Var2 == null) || (nh2Var3 != null && nh2Var4 == null)))) {
            throw NotFoundException.getNotFoundInstance();
        }
        k(whVar, nh2Var, nh2Var2, nh2Var3, nh2Var4);
    }

    private void b() {
        if (this.b == null) {
            this.b = new nh2(0.0f, this.d.d());
            this.c = new nh2(0.0f, this.e.d());
        } else if (this.d == null) {
            this.d = new nh2(this.a.j() - 1, this.b.d());
            this.e = new nh2(this.a.j() - 1, this.c.d());
        }
        this.f = (int) Math.min(this.b.c(), this.c.c());
        this.g = (int) Math.max(this.d.c(), this.e.c());
        this.h = (int) Math.min(this.b.d(), this.d.d());
        this.i = (int) Math.max(this.c.d(), this.e.d());
    }

    private void k(wh whVar, nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, nh2 nh2Var4) {
        this.a = whVar;
        this.b = nh2Var;
        this.c = nh2Var2;
        this.d = nh2Var3;
        this.e = nh2Var4;
        b();
    }

    static c l(c cVar, c cVar2) {
        if (cVar == null) {
            return cVar2;
        }
        return cVar2 == null ? cVar : new c(cVar.a, cVar.b, cVar.c, cVar2.d, cVar2.e);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x0043  */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    c a(int i, int i2, boolean z) {
        nh2 nh2Var;
        nh2 nh2Var2;
        nh2 nh2Var3;
        nh2 nh2Var4;
        nh2 nh2Var5;
        int iD;
        nh2 nh2Var6;
        nh2 nh2Var7 = this.b;
        nh2 nh2Var8 = this.c;
        nh2 nh2Var9 = this.d;
        nh2 nh2Var10 = this.e;
        if (i > 0) {
            nh2 nh2Var11 = z ? nh2Var7 : nh2Var9;
            int iD2 = ((int) nh2Var11.d()) - i;
            if (iD2 < 0) {
                iD2 = 0;
            }
            nh2 nh2Var12 = new nh2(nh2Var11.c(), iD2);
            if (z) {
                nh2Var = nh2Var12;
            } else {
                nh2Var2 = nh2Var12;
                nh2Var = nh2Var7;
            }
            if (i2 > 0) {
                if (z) {
                    nh2Var5 = this.c;
                } else {
                    nh2Var5 = this.e;
                }
                iD = ((int) nh2Var5.d()) + i2;
                if (iD >= this.a.g()) {
                    iD = this.a.g() - 1;
                }
                nh2Var6 = new nh2(nh2Var5.c(), iD);
                if (z) {
                    nh2Var3 = nh2Var6;
                } else {
                    nh2Var4 = nh2Var6;
                    nh2Var3 = nh2Var8;
                }
                b();
                return new c(this.a, nh2Var, nh2Var3, nh2Var2, nh2Var4);
            }
            nh2Var3 = nh2Var8;
            nh2Var4 = nh2Var10;
            b();
            return new c(this.a, nh2Var, nh2Var3, nh2Var2, nh2Var4);
        }
        nh2Var = nh2Var7;
        nh2Var2 = nh2Var9;
        if (i2 > 0) {
            if (z) {
                nh2Var5 = this.c;
            } else {
                nh2Var5 = this.e;
            }
            iD = ((int) nh2Var5.d()) + i2;
            if (iD >= this.a.g()) {
                iD = this.a.g() - 1;
            }
            nh2Var6 = new nh2(nh2Var5.c(), iD);
            if (z) {
                nh2Var3 = nh2Var6;
            } else {
                nh2Var4 = nh2Var6;
                nh2Var3 = nh2Var8;
            }
            b();
            return new c(this.a, nh2Var, nh2Var3, nh2Var2, nh2Var4);
        }
        nh2Var3 = nh2Var8;
        nh2Var4 = nh2Var10;
        b();
        return new c(this.a, nh2Var, nh2Var3, nh2Var2, nh2Var4);
    }

    nh2 c() {
        return this.c;
    }

    nh2 d() {
        return this.e;
    }

    int e() {
        return this.g;
    }

    int f() {
        return this.i;
    }

    int g() {
        return this.f;
    }

    int h() {
        return this.h;
    }

    nh2 i() {
        return this.b;
    }

    nh2 j() {
        return this.d;
    }

    c(c cVar) {
        k(cVar.a, cVar.b, cVar.c, cVar.d, cVar.e);
    }
}
