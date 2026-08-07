package defpackage;

import java.util.ConcurrentModificationException;

/* JADX INFO: loaded from: classes.dex */
public abstract class aa {
    public static final void a(y9 y9Var, int i) {
        p31.f(y9Var, "<this>");
        y9Var.h(new int[i]);
        y9Var.g(new Object[i]);
    }

    public static final int b(y9 y9Var, int i) {
        p31.f(y9Var, "<this>");
        try {
            return r20.a(y9Var.c(), y9Var.e(), i);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(y9 y9Var, Object obj, int i) {
        p31.f(y9Var, "<this>");
        int iE = y9Var.e();
        if (iE == 0) {
            return -1;
        }
        int iB = b(y9Var, i);
        if (iB < 0 || p31.a(obj, y9Var.b()[iB])) {
            return iB;
        }
        int i2 = iB + 1;
        while (i2 < iE && y9Var.c()[i2] == i) {
            if (p31.a(obj, y9Var.b()[i2])) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iB - 1; i3 >= 0 && y9Var.c()[i3] == i; i3--) {
            if (p31.a(obj, y9Var.b()[i3])) {
                return i3;
            }
        }
        return ~i2;
    }

    public static final int d(y9 y9Var) {
        p31.f(y9Var, "<this>");
        return c(y9Var, null, 0);
    }
}
