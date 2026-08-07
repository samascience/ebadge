package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.InternCache;
import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class mp {
    protected final mp a;
    protected final AtomicReference b;
    protected final int c;
    protected final boolean d;
    protected final boolean e;
    protected int[] f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected String[] l;
    protected int m;
    protected int n;
    protected boolean o;

    private mp(int i, int i2) {
        this.a = null;
        this.k = 0;
        this.o = true;
        this.c = i2;
        this.d = false;
        this.e = true;
        int i3 = 16;
        if (i < 16) {
            i = i3;
        } else if (((i - 1) & i) != 0) {
            while (i3 < i) {
                i3 += i3;
            }
            i = i3;
        }
        this.b = new AtomicReference(a.a(i));
    }

    private void C(a aVar) {
        int i = aVar.b;
        a aVar2 = (a) this.b.get();
        if (i == aVar2.b) {
            return;
        }
        if (i > 6000) {
            aVar = a.a(64);
        }
        p62.a(this.b, aVar2, aVar);
    }

    private void D(boolean z) {
        this.k = 0;
        this.m = l();
        this.n = this.g << 3;
        if (z) {
            Arrays.fill(this.f, 0);
            Arrays.fill(this.l, (Object) null);
        }
    }

    private void F() {
        this.o = false;
        int[] iArr = this.f;
        String[] strArr = this.l;
        int i = this.g;
        int i2 = this.k;
        int i3 = i + i;
        int i4 = this.m;
        if (i3 > 65536) {
            D(true);
            return;
        }
        this.f = new int[iArr.length + (i << 3)];
        this.g = i3;
        int i5 = i3 << 2;
        this.h = i5;
        this.i = i5 + (i5 >> 1);
        this.j = c(i3);
        this.l = new String[strArr.length << 1];
        D(false);
        int[] iArr2 = new int[16];
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7 += 4) {
            int i8 = iArr[i7 + 3];
            if (i8 != 0) {
                i6++;
                String str = strArr[i7 >> 2];
                if (i8 == 1) {
                    iArr2[0] = iArr[i7];
                    p(str, iArr2, 1);
                } else if (i8 == 2) {
                    iArr2[0] = iArr[i7];
                    iArr2[1] = iArr[i7 + 1];
                    p(str, iArr2, 2);
                } else if (i8 != 3) {
                    if (i8 > iArr2.length) {
                        iArr2 = new int[i8];
                    }
                    System.arraycopy(iArr, iArr[i7 + 1], iArr2, 0, i8);
                    p(str, iArr2, i8);
                } else {
                    iArr2[0] = iArr[i7];
                    iArr2[1] = iArr[i7 + 1];
                    iArr2[2] = iArr[i7 + 2];
                    p(str, iArr2, 3);
                }
            }
        }
        if (i6 == i2) {
            return;
        }
        throw new IllegalStateException("Failed rehash(): old count=" + i2 + ", copyCount=" + i6);
    }

    private int a(int[] iArr, int i) {
        int i2 = this.n;
        int i3 = i2 + i;
        int[] iArr2 = this.f;
        if (i3 > iArr2.length) {
            this.f = Arrays.copyOf(this.f, this.f.length + Math.max(i3 - iArr2.length, Math.min(4096, this.g)));
        }
        System.arraycopy(iArr, 0, this.f, i2, i);
        this.n += i;
        return i2;
    }

    private final int b(int i) {
        return (i & (this.g - 1)) << 2;
    }

    static int c(int i) {
        int i2 = i >> 2;
        if (i2 < 64) {
            return 4;
        }
        if (i2 <= 256) {
            return 5;
        }
        return i2 <= 1024 ? 6 : 7;
    }

    private boolean d() {
        if (this.k <= (this.g >> 1)) {
            return false;
        }
        int iL = (this.m - l()) >> 2;
        int i = this.k;
        return iL > ((i + 1) >> 7) || ((double) i) > ((double) this.g) * 0.8d;
    }

    private int e(int i) {
        int iB = b(i);
        int[] iArr = this.f;
        if (iArr[iB + 3] == 0) {
            return iB;
        }
        if (d()) {
            return k(i);
        }
        int i2 = this.h + ((iB >> 3) << 2);
        if (iArr[i2 + 3] == 0) {
            return i2;
        }
        int i3 = this.i;
        int i4 = this.j;
        int i5 = i3 + ((iB >> (i4 + 2)) << i4);
        int i6 = (1 << i4) + i5;
        while (i5 < i6) {
            if (iArr[i5 + 3] == 0) {
                return i5;
            }
            i5 += 4;
        }
        int i7 = this.m;
        int i8 = i7 + 4;
        this.m = i8;
        if (i8 < (this.g << 3)) {
            return i7;
        }
        if (this.e) {
            j();
        }
        return k(i);
    }

    private String f(int i, int i2) {
        int i3 = this.i;
        int i4 = this.j;
        int i5 = i3 + ((i >> (i4 + 2)) << i4);
        int[] iArr = this.f;
        int i6 = (1 << i4) + i5;
        while (i5 < i6) {
            int i7 = iArr[i5 + 3];
            if (i2 == iArr[i5] && 1 == i7) {
                return this.l[i5 >> 2];
            }
            if (i7 == 0) {
                return null;
            }
            i5 += 4;
        }
        for (int iL = l(); iL < this.m; iL += 4) {
            if (i2 == iArr[iL] && 1 == iArr[iL + 3]) {
                return this.l[iL >> 2];
            }
        }
        return null;
    }

    private String g(int i, int i2, int i3) {
        int i4 = this.i;
        int i5 = this.j;
        int i6 = i4 + ((i >> (i5 + 2)) << i5);
        int[] iArr = this.f;
        int i7 = (1 << i5) + i6;
        while (i6 < i7) {
            int i8 = iArr[i6 + 3];
            if (i2 == iArr[i6] && i3 == iArr[i6 + 1] && 2 == i8) {
                return this.l[i6 >> 2];
            }
            if (i8 == 0) {
                return null;
            }
            i6 += 4;
        }
        for (int iL = l(); iL < this.m; iL += 4) {
            if (i2 == iArr[iL] && i3 == iArr[iL + 1] && 2 == iArr[iL + 3]) {
                return this.l[iL >> 2];
            }
        }
        return null;
    }

    private String h(int i, int i2, int i3, int i4) {
        int i5 = this.i;
        int i6 = this.j;
        int i7 = i5 + ((i >> (i6 + 2)) << i6);
        int[] iArr = this.f;
        int i8 = (1 << i6) + i7;
        while (i7 < i8) {
            int i9 = iArr[i7 + 3];
            if (i2 == iArr[i7] && i3 == iArr[i7 + 1] && i4 == iArr[i7 + 2] && 3 == i9) {
                return this.l[i7 >> 2];
            }
            if (i9 == 0) {
                return null;
            }
            i7 += 4;
        }
        for (int iL = l(); iL < this.m; iL += 4) {
            if (i2 == iArr[iL] && i3 == iArr[iL + 1] && i4 == iArr[iL + 2] && 3 == iArr[iL + 3]) {
                return this.l[iL >> 2];
            }
        }
        return null;
    }

    private String i(int i, int i2, int[] iArr, int i3) {
        int i4 = this.i;
        int i5 = this.j;
        int i6 = i4 + ((i >> (i5 + 2)) << i5);
        int[] iArr2 = this.f;
        int i7 = (1 << i5) + i6;
        while (i6 < i7) {
            int i8 = iArr2[i6 + 3];
            if (i2 == iArr2[i6] && i3 == i8 && m(iArr, i3, iArr2[i6 + 1])) {
                return this.l[i6 >> 2];
            }
            if (i8 == 0) {
                return null;
            }
            i6 += 4;
        }
        for (int iL = l(); iL < this.m; iL += 4) {
            if (i2 == iArr2[iL] && i3 == iArr2[iL + 3] && m(iArr, i3, iArr2[iL + 1])) {
                return this.l[iL >> 2];
            }
        }
        return null;
    }

    private int k(int i) {
        F();
        int iB = b(i);
        int[] iArr = this.f;
        if (iArr[iB + 3] == 0) {
            return iB;
        }
        int i2 = this.h + ((iB >> 3) << 2);
        if (iArr[i2 + 3] == 0) {
            return i2;
        }
        int i3 = this.i;
        int i4 = this.j;
        int i5 = i3 + ((iB >> (i4 + 2)) << i4);
        int i6 = (1 << i4) + i5;
        while (i5 < i6) {
            if (iArr[i5 + 3] == 0) {
                return i5;
            }
            i5 += 4;
        }
        int i7 = this.m;
        this.m = i7 + 4;
        return i7;
    }

    private final int l() {
        int i = this.g;
        return (i << 3) - i;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0023 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0024  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Code duplicated, block: B:23:0x003f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0040  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x004e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    private boolean m(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr2 = this.f;
        switch (i) {
            case 4:
                i3 = 0;
                i7 = i3 + 1;
                i8 = i2 + 1;
                if (iArr[i3] != iArr2[i2]) {
                    return false;
                }
                i9 = i3 + 2;
                i10 = i2 + 2;
                if (iArr[i7] != iArr2[i8]) {
                    return false;
                }
                return iArr[i9] != iArr2[i10] && iArr[i3 + 3] == iArr2[i2 + 3];
            case 5:
                i4 = 0;
                i3 = i4 + 1;
                i11 = i2 + 1;
                if (iArr[i4] != iArr2[i2]) {
                    return false;
                }
                i2 = i11;
                i7 = i3 + 1;
                i8 = i2 + 1;
                if (iArr[i3] != iArr2[i2]) {
                    return false;
                }
                i9 = i3 + 2;
                i10 = i2 + 2;
                if (iArr[i7] != iArr2[i8]) {
                    return false;
                }
                if (iArr[i9] != iArr2[i10]) {
                    return false;
                }
            case 6:
                i5 = 0;
                i4 = i5 + 1;
                i12 = i2 + 1;
                if (iArr[i5] != iArr2[i2]) {
                    return false;
                }
                i2 = i12;
                i3 = i4 + 1;
                i11 = i2 + 1;
                if (iArr[i4] != iArr2[i2]) {
                    return false;
                }
                i2 = i11;
                i7 = i3 + 1;
                i8 = i2 + 1;
                if (iArr[i3] != iArr2[i2]) {
                    return false;
                }
                i9 = i3 + 2;
                i10 = i2 + 2;
                if (iArr[i7] != iArr2[i8]) {
                    return false;
                }
                if (iArr[i9] != iArr2[i10]) {
                    return false;
                }
            case 7:
                i6 = 0;
                i5 = i6 + 1;
                i13 = i2 + 1;
                if (iArr[i6] != iArr2[i2]) {
                    return false;
                }
                i2 = i13;
                i4 = i5 + 1;
                i12 = i2 + 1;
                if (iArr[i5] != iArr2[i2]) {
                    return false;
                }
                i2 = i12;
                i3 = i4 + 1;
                i11 = i2 + 1;
                if (iArr[i4] != iArr2[i2]) {
                    return false;
                }
                i2 = i11;
                i7 = i3 + 1;
                i8 = i2 + 1;
                if (iArr[i3] != iArr2[i2]) {
                    return false;
                }
                i9 = i3 + 2;
                i10 = i2 + 2;
                if (iArr[i7] != iArr2[i8]) {
                    return false;
                }
                if (iArr[i9] != iArr2[i10]) {
                    return false;
                }
            case 8:
                int i14 = i2 + 1;
                if (iArr[0] != iArr2[i2]) {
                    return false;
                }
                i6 = 1;
                i2 = i14;
                i5 = i6 + 1;
                i13 = i2 + 1;
                if (iArr[i6] != iArr2[i2]) {
                    return false;
                }
                i2 = i13;
                i4 = i5 + 1;
                i12 = i2 + 1;
                if (iArr[i5] != iArr2[i2]) {
                    return false;
                }
                i2 = i12;
                i3 = i4 + 1;
                i11 = i2 + 1;
                if (iArr[i4] != iArr2[i2]) {
                    return false;
                }
                i2 = i11;
                i7 = i3 + 1;
                i8 = i2 + 1;
                if (iArr[i3] != iArr2[i2]) {
                    return false;
                }
                i9 = i3 + 2;
                i10 = i2 + 2;
                if (iArr[i7] != iArr2[i8]) {
                    return false;
                }
                if (iArr[i9] != iArr2[i10]) {
                    return false;
                }
            default:
                return n(iArr, i, i2);
        }
    }

    private boolean n(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            if (iArr[i3] != this.f[i2]) {
                return false;
            }
            if (i4 >= i) {
                return true;
            }
            i3 = i4;
            i2 = i5;
        }
    }

    private void o() {
        if (this.o) {
            if (this.a == null) {
                if (this.k != 0) {
                    throw new IllegalStateException("Cannot add names to Placeholder symbol table");
                }
                throw new IllegalStateException("Cannot add names to Root symbol table");
            }
            int[] iArr = this.f;
            this.f = Arrays.copyOf(iArr, iArr.length);
            String[] strArr = this.l;
            this.l = (String[]) Arrays.copyOf(strArr, strArr.length);
            this.o = false;
        }
    }

    public static mp u() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return v((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }

    protected static mp v(int i) {
        return new mp(64, i);
    }

    public mp A(int i) {
        return new mp(this, this.c, (a) this.b.get(), JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(i), JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(i));
    }

    public boolean B() {
        return !this.o;
    }

    public int E() {
        int i = this.h;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this.f[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    public void G() {
        if (this.a == null || !B()) {
            return;
        }
        this.a.C(new a(this));
        this.o = true;
    }

    public int H() {
        int i = this.i;
        int i2 = 0;
        for (int i3 = this.h + 3; i3 < i; i3 += 4) {
            if (this.f[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    public int I() {
        return (this.m - l()) >> 2;
    }

    public int J() {
        int i = this.i + 3;
        int i2 = this.g + i;
        int i3 = 0;
        while (i < i2) {
            if (this.f[i] != 0) {
                i3++;
            }
            i += 4;
        }
        return i3;
    }

    public int K() {
        int i = this.g << 3;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this.f[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    protected void j() {
        if (this.g <= 1024) {
            return;
        }
        throw new IllegalStateException("Spill-over slots in symbol table with " + this.k + " entries, hash area of " + this.g + " slots is now full (all " + (this.g >> 3) + " slots -- suspect a DoS attack based on hash collisions. You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
    }

    public String p(String str, int[] iArr, int i) {
        int iE;
        o();
        if (this.d) {
            str = InternCache.instance.intern(str);
        }
        if (i == 1) {
            iE = e(q(iArr[0]));
            int[] iArr2 = this.f;
            iArr2[iE] = iArr[0];
            iArr2[iE + 3] = 1;
        } else if (i == 2) {
            iE = e(r(iArr[0], iArr[1]));
            int[] iArr3 = this.f;
            iArr3[iE] = iArr[0];
            iArr3[iE + 1] = iArr[1];
            iArr3[iE + 3] = 2;
        } else if (i != 3) {
            int iT = t(iArr, i);
            iE = e(iT);
            this.f[iE] = iT;
            int iA = a(iArr, i);
            int[] iArr4 = this.f;
            iArr4[iE + 1] = iA;
            iArr4[iE + 3] = i;
        } else {
            int iE2 = e(s(iArr[0], iArr[1], iArr[2]));
            int[] iArr5 = this.f;
            iArr5[iE2] = iArr[0];
            iArr5[iE2 + 1] = iArr[1];
            iArr5[iE2 + 2] = iArr[2];
            iArr5[iE2 + 3] = 3;
            iE = iE2;
        }
        this.l[iE >> 2] = str;
        this.k++;
        return str;
    }

    public int q(int i) {
        int i2 = i ^ this.c;
        int i3 = i2 + (i2 >>> 16);
        int i4 = i3 ^ (i3 << 3);
        return i4 + (i4 >>> 12);
    }

    public int r(int i, int i2) {
        int i3 = i + (i >>> 15);
        int i4 = ((i3 ^ (i3 >>> 9)) + (i2 * 33)) ^ this.c;
        int i5 = i4 + (i4 >>> 16);
        int i6 = i5 ^ (i5 >>> 4);
        return i6 + (i6 << 3);
    }

    public int s(int i, int i2, int i3) {
        int i4 = i ^ this.c;
        int i5 = (((i4 + (i4 >>> 9)) * 31) + i2) * 33;
        int i6 = (i5 + (i5 >>> 15)) ^ i3;
        int i7 = i6 + (i6 >>> 4);
        int i8 = i7 + (i7 >>> 15);
        return i8 ^ (i8 << 9);
    }

    public int t(int[] iArr, int i) {
        if (i < 4) {
            throw new IllegalArgumentException();
        }
        int i2 = iArr[0] ^ this.c;
        int i3 = i2 + (i2 >>> 9) + iArr[1];
        int i4 = ((i3 + (i3 >>> 15)) * 33) ^ iArr[2];
        int i5 = i4 + (i4 >>> 4);
        for (int i6 = 3; i6 < i; i6++) {
            int i7 = iArr[i6];
            i5 += i7 ^ (i7 >> 21);
        }
        int i8 = i5 * 65599;
        int i9 = i8 + (i8 >>> 19);
        return (i9 << 5) ^ i9;
    }

    public String toString() {
        int iE = E();
        int iH = H();
        int iJ = J();
        int I = I();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", mp.class.getName(), Integer.valueOf(this.k), Integer.valueOf(this.g), Integer.valueOf(iE), Integer.valueOf(iH), Integer.valueOf(iJ), Integer.valueOf(I), Integer.valueOf(iE + iH + iJ + I), Integer.valueOf(K()));
    }

    public String w(int i) {
        int iB = b(q(i));
        int[] iArr = this.f;
        int i2 = iArr[iB + 3];
        if (i2 == 1) {
            if (iArr[iB] == i) {
                return this.l[iB >> 2];
            }
        } else if (i2 == 0) {
            return null;
        }
        int i3 = this.h + ((iB >> 3) << 2);
        int i4 = iArr[i3 + 3];
        if (i4 == 1) {
            if (iArr[i3] == i) {
                return this.l[i3 >> 2];
            }
        } else if (i4 == 0) {
            return null;
        }
        return f(iB, i);
    }

    public String x(int i, int i2) {
        int iB = b(r(i, i2));
        int[] iArr = this.f;
        int i3 = iArr[iB + 3];
        if (i3 == 2) {
            if (i == iArr[iB] && i2 == iArr[iB + 1]) {
                return this.l[iB >> 2];
            }
        } else if (i3 == 0) {
            return null;
        }
        int i4 = this.h + ((iB >> 3) << 2);
        int i5 = iArr[i4 + 3];
        if (i5 == 2) {
            if (i == iArr[i4] && i2 == iArr[i4 + 1]) {
                return this.l[i4 >> 2];
            }
        } else if (i5 == 0) {
            return null;
        }
        return g(iB, i, i2);
    }

    public String y(int i, int i2, int i3) {
        int iB = b(s(i, i2, i3));
        int[] iArr = this.f;
        int i4 = iArr[iB + 3];
        if (i4 == 3) {
            if (i == iArr[iB] && iArr[iB + 1] == i2 && iArr[iB + 2] == i3) {
                return this.l[iB >> 2];
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = this.h + ((iB >> 3) << 2);
        int i6 = iArr[i5 + 3];
        if (i6 == 3) {
            if (i == iArr[i5] && iArr[i5 + 1] == i2 && iArr[i5 + 2] == i3) {
                return this.l[i5 >> 2];
            }
        } else if (i6 == 0) {
            return null;
        }
        return h(iB, i, i2, i3);
    }

    public String z(int[] iArr, int i) {
        if (i < 4) {
            if (i == 1) {
                return w(iArr[0]);
            }
            if (i != 2) {
                return i != 3 ? Constants.STR_EMPTY : y(iArr[0], iArr[1], iArr[2]);
            }
            return x(iArr[0], iArr[1]);
        }
        int iT = t(iArr, i);
        int iB = b(iT);
        int[] iArr2 = this.f;
        int i2 = iArr2[iB + 3];
        if (iT == iArr2[iB] && i2 == i && m(iArr, i, iArr2[iB + 1])) {
            return this.l[iB >> 2];
        }
        if (i2 == 0) {
            return null;
        }
        int i3 = this.h + ((iB >> 3) << 2);
        return (iT == iArr2[i3] && iArr2[i3 + 3] == i && m(iArr, i, iArr2[i3 + 1])) ? this.l[i3 >> 2] : i(iB, iT, iArr, i);
    }

    private static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int[] d;
        public final String[] e;
        public final int f;
        public final int g;

        public a(int i, int i2, int i3, int[] iArr, String[] strArr, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = iArr;
            this.e = strArr;
            this.f = i4;
            this.g = i5;
        }

        public static a a(int i) {
            int i2 = i << 3;
            return new a(i, 0, mp.c(i), new int[i2], new String[i << 1], i2 - i, i2);
        }

        public a(mp mpVar) {
            this.a = mpVar.g;
            this.b = mpVar.k;
            this.c = mpVar.j;
            this.d = mpVar.f;
            this.e = mpVar.l;
            this.f = mpVar.m;
            this.g = mpVar.n;
        }
    }

    private mp(mp mpVar, int i, a aVar, boolean z, boolean z2) {
        this.a = mpVar;
        this.c = i;
        this.d = z;
        this.e = z2;
        this.b = null;
        this.k = aVar.b;
        int i2 = aVar.a;
        this.g = i2;
        int i3 = i2 << 2;
        this.h = i3;
        this.i = i3 + (i3 >> 1);
        this.j = aVar.c;
        this.f = aVar.d;
        this.l = aVar.e;
        this.m = aVar.f;
        this.n = aVar.g;
        this.o = true;
    }
}
