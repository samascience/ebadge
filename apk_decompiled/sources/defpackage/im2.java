package defpackage;

import java.util.Arrays;
import kotlin.collections.d;

/* JADX INFO: loaded from: classes4.dex */
public final class im2 {
    public static final a h = new a(null);
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public im2 f;
    public im2 g;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public im2() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final void a() {
        int i;
        im2 im2Var = this.g;
        if (im2Var == this) {
            throw new IllegalStateException("cannot compact");
        }
        p31.c(im2Var);
        if (im2Var.e) {
            int i2 = this.c - this.b;
            im2 im2Var2 = this.g;
            p31.c(im2Var2);
            int i3 = 8192 - im2Var2.c;
            im2 im2Var3 = this.g;
            p31.c(im2Var3);
            if (im2Var3.d) {
                i = 0;
            } else {
                im2 im2Var4 = this.g;
                p31.c(im2Var4);
                i = im2Var4.b;
            }
            if (i2 > i3 + i) {
                return;
            }
            im2 im2Var5 = this.g;
            p31.c(im2Var5);
            g(im2Var5, i2);
            b();
            jm2.b(this);
        }
    }

    public final im2 b() {
        im2 im2Var = this.f;
        if (im2Var == this) {
            im2Var = null;
        }
        im2 im2Var2 = this.g;
        p31.c(im2Var2);
        im2Var2.f = this.f;
        im2 im2Var3 = this.f;
        p31.c(im2Var3);
        im2Var3.g = this.g;
        this.f = null;
        this.g = null;
        return im2Var;
    }

    public final im2 c(im2 im2Var) {
        p31.f(im2Var, "segment");
        im2Var.g = this;
        im2Var.f = this.f;
        im2 im2Var2 = this.f;
        p31.c(im2Var2);
        im2Var2.g = im2Var;
        this.f = im2Var;
        return im2Var;
    }

    public final im2 d() {
        this.d = true;
        return new im2(this.a, this.b, this.c, true, false);
    }

    public final im2 e(int i) {
        im2 im2VarC;
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i >= 1024) {
            im2VarC = d();
        } else {
            im2VarC = jm2.c();
            byte[] bArr = this.a;
            byte[] bArr2 = im2VarC.a;
            int i2 = this.b;
            d.h(bArr, bArr2, 0, i2, i2 + i, 2, null);
        }
        im2VarC.c = im2VarC.b + i;
        this.b += i;
        im2 im2Var = this.g;
        p31.c(im2Var);
        im2Var.c(im2VarC);
        return im2VarC;
    }

    public final im2 f() {
        byte[] bArr = this.a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        p31.e(bArrCopyOf, "copyOf(this, size)");
        return new im2(bArrCopyOf, this.b, this.c, false, true);
    }

    public final void g(im2 im2Var, int i) {
        p31.f(im2Var, "sink");
        if (!im2Var.e) {
            throw new IllegalStateException("only owner can write");
        }
        int i2 = im2Var.c;
        if (i2 + i > 8192) {
            if (im2Var.d) {
                throw new IllegalArgumentException();
            }
            int i3 = im2Var.b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = im2Var.a;
            d.h(bArr, bArr, 0, i3, i2, 2, null);
            im2Var.c -= im2Var.b;
            im2Var.b = 0;
        }
        byte[] bArr2 = this.a;
        byte[] bArr3 = im2Var.a;
        int i4 = im2Var.c;
        int i5 = this.b;
        d.d(bArr2, bArr3, i4, i5, i5 + i);
        im2Var.c += i;
        this.b += i;
    }

    public im2(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        p31.f(bArr, "data");
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }
}
