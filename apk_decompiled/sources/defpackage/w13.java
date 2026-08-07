package defpackage;

import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class w13 {
    static final char[] l = new char[0];
    private final io a;
    private char[] b;
    private int c;
    private int d;
    private ArrayList e;
    private boolean f;
    private int g;
    private char[] h;
    private int i;
    private String j;
    private char[] k;

    public w13(io ioVar) {
        this.a = ioVar;
    }

    private char[] C() {
        int i;
        String str = this.j;
        if (str != null) {
            return str.toCharArray();
        }
        int i2 = this.c;
        if (i2 >= 0) {
            int i3 = this.d;
            if (i3 < 1) {
                return l;
            }
            return i2 == 0 ? Arrays.copyOf(this.b, i3) : Arrays.copyOfRange(this.b, i2, i3 + i2);
        }
        int iF = F();
        if (iF < 1) {
            return l;
        }
        char[] cArrE = e(iF);
        ArrayList arrayList = this.e;
        if (arrayList != null) {
            int size = arrayList.size();
            i = 0;
            for (int i4 = 0; i4 < size; i4++) {
                char[] cArr = (char[]) this.e.get(i4);
                int length = cArr.length;
                System.arraycopy(cArr, 0, cArrE, i, length);
                i += length;
            }
        } else {
            i = 0;
        }
        System.arraycopy(this.h, 0, cArrE, i, this.i);
        return cArrE;
    }

    private void G(int i) {
        int i2 = this.d;
        this.d = 0;
        char[] cArr = this.b;
        this.b = null;
        int i3 = this.c;
        this.c = -1;
        int i4 = i + i2;
        char[] cArr2 = this.h;
        if (cArr2 == null || i4 > cArr2.length) {
            this.h = d(i4);
        }
        if (i2 > 0) {
            System.arraycopy(cArr, i3, this.h, 0, i2);
        }
        this.g = 0;
        this.i = i2;
    }

    private char[] d(int i) {
        io ioVar = this.a;
        return ioVar != null ? ioVar.d(2, i) : new char[Math.max(i, 500)];
    }

    private char[] e(int i) {
        return new char[i];
    }

    private void f() {
        this.f = false;
        this.e.clear();
        this.g = 0;
        this.i = 0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0026 A[PHI: r0
      0x0026: PHI (r0v8 int) = (r0v6 int), (r0v7 int) binds: [B:6:0x0024, B:9:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    private void n(int i) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        char[] cArr = this.h;
        this.f = true;
        this.e.add(cArr);
        this.g += cArr.length;
        this.i = 0;
        int length = cArr.length;
        int i2 = length + (length >> 1);
        int i3 = 500;
        if (i2 < 500) {
            i2 = i3;
        } else {
            i3 = 65536;
            if (i2 > 65536) {
                i2 = i3;
            }
        }
        this.h = e(i2);
    }

    public static w13 q(char[] cArr) {
        return new w13(null, cArr);
    }

    public void A(char[] cArr, int i, int i2) {
        this.j = null;
        this.k = null;
        this.b = cArr;
        this.c = i;
        this.d = i2;
        if (this.f) {
            f();
        }
    }

    public void B(String str) {
        this.b = null;
        this.c = -1;
        this.d = 0;
        this.j = str;
        this.k = null;
        if (this.f) {
            f();
        }
        this.i = 0;
    }

    public String D(int i) {
        this.i = i;
        if (this.g > 0) {
            return l();
        }
        String str = i == 0 ? Constants.STR_EMPTY : new String(this.h, 0, i);
        this.j = str;
        return str;
    }

    public void E(int i) {
        this.i = i;
    }

    public int F() {
        if (this.c >= 0) {
            return this.d;
        }
        char[] cArr = this.k;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.j;
        return str != null ? str.length() : this.g + this.i;
    }

    public void a(char c) {
        if (this.c >= 0) {
            G(16);
        }
        this.j = null;
        this.k = null;
        char[] cArr = this.h;
        if (this.i >= cArr.length) {
            n(1);
            cArr = this.h;
        }
        int i = this.i;
        this.i = i + 1;
        cArr[i] = c;
    }

    public void b(String str, int i, int i2) {
        if (this.c >= 0) {
            G(i2);
        }
        this.j = null;
        this.k = null;
        char[] cArr = this.h;
        int length = cArr.length;
        int i3 = this.i;
        int i4 = length - i3;
        if (i4 >= i2) {
            str.getChars(i, i + i2, cArr, i3);
            this.i += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = i + i4;
            str.getChars(i, i5, cArr, i3);
            i2 -= i4;
            i = i5;
        }
        while (true) {
            n(i2);
            int iMin = Math.min(this.h.length, i2);
            int i6 = i + iMin;
            str.getChars(i, i6, this.h, 0);
            this.i += iMin;
            i2 -= iMin;
            if (i2 <= 0) {
                return;
            } else {
                i = i6;
            }
        }
    }

    public void c(char[] cArr, int i, int i2) {
        if (this.c >= 0) {
            G(i2);
        }
        this.j = null;
        this.k = null;
        char[] cArr2 = this.h;
        int length = cArr2.length;
        int i3 = this.i;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this.i += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        do {
            n(i2);
            int iMin = Math.min(this.h.length, i2);
            System.arraycopy(cArr, i, this.h, 0, iMin);
            this.i += iMin;
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    public char[] g() {
        char[] cArr = this.k;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrC = C();
        this.k = cArrC;
        return cArrC;
    }

    public double h(boolean z) {
        return hs1.j(l(), z);
    }

    public float i(boolean z) {
        return hs1.l(l(), z);
    }

    public int j(boolean z) {
        char[] cArr;
        int i = this.c;
        if (i < 0 || (cArr = this.b) == null) {
            return z ? -hs1.n(this.h, 1, this.i - 1) : hs1.n(this.h, 0, this.i);
        }
        return z ? -hs1.n(cArr, i + 1, this.d - 1) : hs1.n(cArr, i, this.d);
    }

    public long k(boolean z) {
        char[] cArr;
        int i = this.c;
        if (i < 0 || (cArr = this.b) == null) {
            return z ? -hs1.p(this.h, 1, this.i - 1) : hs1.p(this.h, 0, this.i);
        }
        return z ? -hs1.p(cArr, i + 1, this.d - 1) : hs1.p(cArr, i, this.d);
    }

    public String l() {
        if (this.j == null) {
            char[] cArr = this.k;
            if (cArr != null) {
                this.j = new String(cArr);
            } else {
                int i = this.c;
                String str = Constants.STR_EMPTY;
                if (i >= 0) {
                    int i2 = this.d;
                    if (i2 < 1) {
                        this.j = Constants.STR_EMPTY;
                        return Constants.STR_EMPTY;
                    }
                    this.j = new String(this.b, i, i2);
                } else {
                    int i3 = this.g;
                    int i4 = this.i;
                    if (i3 == 0) {
                        if (i4 != 0) {
                            str = new String(this.h, 0, i4);
                        }
                        this.j = str;
                    } else {
                        StringBuilder sb = new StringBuilder(i3 + i4);
                        ArrayList arrayList = this.e;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                char[] cArr2 = (char[]) this.e.get(i5);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this.h, 0, this.i);
                        this.j = sb.toString();
                    }
                }
            }
        }
        return this.j;
    }

    public char[] m() {
        this.c = -1;
        this.i = 0;
        this.d = 0;
        this.b = null;
        this.j = null;
        this.k = null;
        if (this.f) {
            f();
        }
        char[] cArr = this.h;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrD = d(0);
        this.h = cArrD;
        return cArrD;
    }

    public char[] o() {
        char[] cArr = this.h;
        int length = cArr.length;
        int i = (length >> 1) + length;
        if (i > 65536) {
            i = (length >> 2) + length;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, i);
        this.h = cArrCopyOf;
        return cArrCopyOf;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0027 A[PHI: r1
      0x0027: PHI (r1v7 int) = (r1v5 int), (r1v6 int) binds: [B:6:0x0025, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    public char[] p() {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.f = true;
        this.e.add(this.h);
        int length = this.h.length;
        this.g += length;
        this.i = 0;
        int i = length + (length >> 1);
        int i2 = 500;
        if (i < 500) {
            i = i2;
        } else {
            i2 = 65536;
            if (i > 65536) {
                i = i2;
            }
        }
        char[] cArrE = e(i);
        this.h = cArrE;
        return cArrE;
    }

    public char[] r() {
        return this.h;
    }

    public char[] s() {
        if (this.c >= 0) {
            G(1);
        } else {
            char[] cArr = this.h;
            if (cArr == null) {
                this.h = d(0);
            } else if (this.i >= cArr.length) {
                n(1);
            }
        }
        return this.h;
    }

    public int t() {
        return this.i;
    }

    public String toString() {
        return l();
    }

    public char[] u() {
        if (this.c >= 0) {
            return this.b;
        }
        char[] cArr = this.k;
        if (cArr != null) {
            return cArr;
        }
        String str = this.j;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.k = charArray;
            return charArray;
        }
        if (this.f) {
            return g();
        }
        char[] cArr2 = this.h;
        return cArr2 == null ? l : cArr2;
    }

    public int v() {
        int i = this.c;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public boolean w() {
        return this.c >= 0 || this.k != null || this.j == null;
    }

    public void x() {
        char[] cArr;
        this.c = -1;
        this.i = 0;
        this.d = 0;
        this.b = null;
        this.k = null;
        if (this.f) {
            f();
        }
        io ioVar = this.a;
        if (ioVar == null || (cArr = this.h) == null) {
            return;
        }
        this.h = null;
        ioVar.j(2, cArr);
    }

    public void y(String str, int i, int i2) {
        this.b = null;
        this.c = -1;
        this.d = 0;
        this.j = null;
        this.k = null;
        if (this.f) {
            f();
        } else if (this.h == null) {
            this.h = d(i2);
        }
        this.g = 0;
        this.i = 0;
        b(str, i, i2);
    }

    public void z(char[] cArr, int i, int i2) {
        this.b = null;
        this.c = -1;
        this.d = 0;
        this.j = null;
        this.k = null;
        if (this.f) {
            f();
        } else if (this.h == null) {
            this.h = d(i2);
        }
        this.g = 0;
        this.i = 0;
        c(cArr, i, i2);
    }

    protected w13(io ioVar, char[] cArr) {
        this.a = ioVar;
        this.h = cArr;
        this.i = cArr.length;
        this.c = -1;
    }
}
