package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class xk1 {
    public static final xk1 f = new xk1(929, 3);
    private final int[] a;
    private final int[] b;
    private final yk1 c;
    private final yk1 d;
    private final int e;

    private xk1(int i, int i2) {
        this.e = i;
        this.a = new int[i];
        this.b = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.a[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.b[this.a[i5]] = i5;
        }
        this.c = new yk1(this, new int[]{0});
        this.d = new yk1(this, new int[]{1});
    }

    int a(int i, int i2) {
        return (i + i2) % this.e;
    }

    yk1 b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.c;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new yk1(this, iArr);
    }

    int c(int i) {
        return this.a[i];
    }

    yk1 d() {
        return this.d;
    }

    int e() {
        return this.e;
    }

    yk1 f() {
        return this.c;
    }

    int g(int i) {
        if (i != 0) {
            return this.a[(this.e - this.b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int h(int i) {
        if (i != 0) {
            return this.b[i];
        }
        throw new IllegalArgumentException();
    }

    int i(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.e - 1)];
    }

    int j(int i, int i2) {
        int i3 = this.e;
        return ((i + i3) - i2) % i3;
    }
}
