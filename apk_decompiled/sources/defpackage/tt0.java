package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class tt0 implements zt0.a {
    private final oi a;
    private final v9 b;

    public tt0(oi oiVar, v9 v9Var) {
        this.a = oiVar;
        this.b = v9Var;
    }

    @Override // zt0.a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.a.e(i, i2, config);
    }

    @Override // zt0.a
    public int[] b(int i) {
        v9 v9Var = this.b;
        return v9Var == null ? new int[i] : (int[]) v9Var.d(i, int[].class);
    }

    @Override // zt0.a
    public void c(Bitmap bitmap) {
        this.a.c(bitmap);
    }

    @Override // zt0.a
    public void d(byte[] bArr) {
        v9 v9Var = this.b;
        if (v9Var == null) {
            return;
        }
        v9Var.put(bArr);
    }

    @Override // zt0.a
    public byte[] e(int i) {
        v9 v9Var = this.b;
        return v9Var == null ? new byte[i] : (byte[]) v9Var.d(i, byte[].class);
    }

    @Override // zt0.a
    public void f(int[] iArr) {
        v9 v9Var = this.b;
        if (v9Var == null) {
            return;
        }
        v9Var.put(iArr);
    }
}
