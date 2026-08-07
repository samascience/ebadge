package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX INFO: loaded from: classes3.dex */
class f {
    private final c a;
    private final d[] b;

    f(c cVar) {
        this.a = new c(cVar);
        this.b = new d[(cVar.f() - cVar.h()) + 1];
    }

    final c a() {
        return this.a;
    }

    final d b(int i) {
        return this.b[e(i)];
    }

    final d c(int i) {
        d dVar;
        d dVar2;
        d dVarB = b(i);
        if (dVarB != null) {
            return dVarB;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iE = e(i) - i2;
            if (iE >= 0 && (dVar2 = this.b[iE]) != null) {
                return dVar2;
            }
            int iE2 = e(i) + i2;
            d[] dVarArr = this.b;
            if (iE2 < dVarArr.length && (dVar = dVarArr[iE2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    final d[] d() {
        return this.b;
    }

    final int e(int i) {
        return i - this.a.h();
    }

    final void f(int i, d dVar) {
        this.b[e(i)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i = 0;
        for (d dVar : this.b) {
            if (dVar == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i));
                i++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                i++;
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
