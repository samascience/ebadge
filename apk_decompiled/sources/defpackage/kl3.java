package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class kl3 extends z51 {
    protected static final char[] H = ex.d(true);
    protected static final char[] I = ex.d(false);
    protected vm2 F;
    protected char[] G;
    protected final Writer t;
    protected char u;
    protected char[] v;
    protected int w;
    protected int x;
    protected int y;
    protected char[] z;

    public kl3(oy0 oy0Var, int i, jt1 jt1Var, Writer writer, char c) {
        super(oy0Var, i, jt1Var);
        this.t = writer;
        char[] cArrE = oy0Var.e();
        this.v = cArrE;
        this.y = cArrE.length;
        this.u = c;
        if (c != '\"') {
            this.l = ex.f(c);
        }
    }

    private char[] L1() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this.z = cArr;
        return cArr;
    }

    private void M1(char c, int i) throws IOException {
        String value;
        int i2;
        if (i >= 0) {
            if (this.x + 2 > this.y) {
                N1();
            }
            char[] cArr = this.v;
            int i3 = this.x;
            int i4 = i3 + 1;
            this.x = i4;
            cArr[i3] = '\\';
            this.x = i3 + 2;
            cArr[i4] = (char) i;
            return;
        }
        if (i == -2) {
            vm2 vm2Var = this.F;
            if (vm2Var == null) {
                value = this.n.getEscapeSequence(c).getValue();
            } else {
                value = vm2Var.getValue();
                this.F = null;
            }
            int length = value.length();
            if (this.x + length > this.y) {
                N1();
                if (length > this.y) {
                    this.t.write(value);
                    return;
                }
            }
            value.getChars(0, length, this.v, this.x);
            this.x += length;
            return;
        }
        if (this.x + 5 >= this.y) {
            N1();
        }
        int i5 = this.x;
        char[] cArr2 = this.v;
        char[] cArrR2 = r2();
        cArr2[i5] = '\\';
        int i6 = i5 + 2;
        cArr2[i5 + 1] = 'u';
        if (c > 255) {
            int i7 = c >> '\b';
            int i8 = i5 + 3;
            cArr2[i6] = cArrR2[(i7 & 255) >> 4];
            i2 = i5 + 4;
            cArr2[i8] = cArrR2[i7 & 15];
            c = (char) (c & 255);
        } else {
            int i9 = i5 + 3;
            cArr2[i6] = '0';
            i2 = i5 + 4;
            cArr2[i9] = '0';
        }
        cArr2[i2] = cArrR2[c >> 4];
        cArr2[i2 + 1] = cArrR2[c & 15];
        this.x = i2 + 2;
    }

    private int O1(char[] cArr, int i, int i2, char c, int i3) throws IOException {
        String value;
        int i4;
        if (i3 >= 0) {
            if (i > 1 && i < i2) {
                int i5 = i - 2;
                cArr[i5] = '\\';
                cArr[i - 1] = (char) i3;
                return i5;
            }
            char[] cArrL1 = this.z;
            if (cArrL1 == null) {
                cArrL1 = L1();
            }
            cArrL1[1] = (char) i3;
            this.t.write(cArrL1, 0, 2);
            return i;
        }
        if (i3 == -2) {
            vm2 vm2Var = this.F;
            if (vm2Var == null) {
                value = this.n.getEscapeSequence(c).getValue();
            } else {
                value = vm2Var.getValue();
                this.F = null;
            }
            int length = value.length();
            if (i < length || i >= i2) {
                this.t.write(value);
                return i;
            }
            int i6 = i - length;
            value.getChars(0, length, cArr, i6);
            return i6;
        }
        char[] cArrR2 = r2();
        if (i <= 5 || i >= i2) {
            char[] cArrL2 = this.z;
            if (cArrL2 == null) {
                cArrL2 = L1();
            }
            this.w = this.x;
            if (c <= 255) {
                cArrL2[6] = cArrR2[c >> 4];
                cArrL2[7] = cArrR2[c & 15];
                this.t.write(cArrL2, 2, 6);
                return i;
            }
            int i7 = c >> '\b';
            cArrL2[10] = cArrR2[(i7 & 255) >> 4];
            cArrL2[11] = cArrR2[i7 & 15];
            cArrL2[12] = cArrR2[(c & 255) >> 4];
            cArrL2[13] = cArrR2[c & 15];
            this.t.write(cArrL2, 8, 6);
            return i;
        }
        cArr[i - 6] = '\\';
        int i8 = i - 4;
        cArr[i - 5] = 'u';
        if (c > 255) {
            int i9 = c >> '\b';
            int i10 = i - 3;
            cArr[i8] = cArrR2[(i9 & 255) >> 4];
            i4 = i - 2;
            cArr[i10] = cArrR2[i9 & 15];
            c = (char) (c & 255);
        } else {
            int i11 = i - 3;
            cArr[i8] = '0';
            i4 = i - 2;
            cArr[i11] = '0';
        }
        cArr[i4] = cArrR2[c >> 4];
        cArr[i4 + 1] = cArrR2[c & 15];
        return i4 - 4;
    }

    private void P1(char c, int i) throws IOException {
        String value;
        int i2;
        if (i >= 0) {
            int i3 = this.x;
            if (i3 >= 2) {
                int i4 = i3 - 2;
                this.w = i4;
                char[] cArr = this.v;
                cArr[i4] = '\\';
                cArr[i3 - 1] = (char) i;
                return;
            }
            char[] cArrL1 = this.z;
            if (cArrL1 == null) {
                cArrL1 = L1();
            }
            this.w = this.x;
            cArrL1[1] = (char) i;
            this.t.write(cArrL1, 0, 2);
            return;
        }
        if (i == -2) {
            vm2 vm2Var = this.F;
            if (vm2Var == null) {
                value = this.n.getEscapeSequence(c).getValue();
            } else {
                value = vm2Var.getValue();
                this.F = null;
            }
            int length = value.length();
            int i5 = this.x;
            if (i5 < length) {
                this.w = i5;
                this.t.write(value);
                return;
            } else {
                int i6 = i5 - length;
                this.w = i6;
                value.getChars(0, length, this.v, i6);
                return;
            }
        }
        char[] cArrR2 = r2();
        int i7 = this.x;
        if (i7 < 6) {
            char[] cArrL2 = this.z;
            if (cArrL2 == null) {
                cArrL2 = L1();
            }
            this.w = this.x;
            if (c <= 255) {
                cArrL2[6] = cArrR2[c >> 4];
                cArrL2[7] = cArrR2[c & 15];
                this.t.write(cArrL2, 2, 6);
                return;
            } else {
                int i8 = c >> '\b';
                cArrL2[10] = cArrR2[(i8 & 255) >> 4];
                cArrL2[11] = cArrR2[i8 & 15];
                cArrL2[12] = cArrR2[(c & 255) >> 4];
                cArrL2[13] = cArrR2[c & 15];
                this.t.write(cArrL2, 8, 6);
                return;
            }
        }
        char[] cArr2 = this.v;
        int i9 = i7 - 6;
        this.w = i9;
        cArr2[i9] = '\\';
        cArr2[i7 - 5] = 'u';
        if (c > 255) {
            int i10 = c >> '\b';
            cArr2[i7 - 4] = cArrR2[(i10 & 255) >> 4];
            i2 = i7 - 3;
            cArr2[i2] = cArrR2[i10 & 15];
            c = (char) (c & 255);
        } else {
            cArr2[i7 - 4] = '0';
            i2 = i7 - 3;
            cArr2[i2] = '0';
        }
        cArr2[i2 + 1] = cArrR2[c >> 4];
        cArr2[i2 + 2] = cArrR2[c & 15];
    }

    private int Q1(InputStream inputStream, byte[] bArr, int i, int i2, int i3) throws IOException {
        int i4 = 0;
        while (i < i2) {
            bArr[i4] = bArr[i];
            i4++;
            i++;
        }
        int iMin = Math.min(i3, bArr.length);
        do {
            int i5 = iMin - i4;
            if (i5 == 0) {
                break;
            }
            int i6 = inputStream.read(bArr, i4, i5);
            if (i6 < 0) {
                return i4;
            }
            i4 += i6;
        } while (i4 < 3);
        return i4;
    }

    private final void X1(vm2 vm2Var) throws IOException {
        char[] cArrAsQuotedChars = vm2Var.asQuotedChars();
        m1(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = this.u;
    }

    private void Y1(String str) throws IOException {
        N1();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = this.y;
            if (i + i2 > length) {
                i2 = length - i;
            }
            int i3 = i + i2;
            str.getChars(i, i3, this.v, 0);
            if (this.n != null) {
                i2(i2);
            } else {
                int i4 = this.m;
                if (i4 != 0) {
                    h2(i2, i4);
                } else {
                    g2(i2);
                }
            }
            if (i3 >= length) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private final void Z1() throws IOException {
        if (this.x + 4 >= this.y) {
            N1();
        }
        int i = this.x;
        char[] cArr = this.v;
        cArr[i] = 'n';
        cArr[i + 1] = 'u';
        cArr[i + 2] = 'l';
        cArr[i + 3] = 'l';
        this.x = i + 4;
    }

    private void c2(int i) throws IOException {
        if (this.x + 13 >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i2 = this.x;
        int i3 = i2 + 1;
        this.x = i3;
        cArr[i2] = this.u;
        int iR = is1.r(i, cArr, i3);
        char[] cArr2 = this.v;
        this.x = iR + 1;
        cArr2[iR] = this.u;
    }

    private void d2(long j) throws IOException {
        if (this.x + 23 >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        int i2 = i + 1;
        this.x = i2;
        cArr[i] = this.u;
        int iT = is1.t(j, cArr, i2);
        char[] cArr2 = this.v;
        this.x = iT + 1;
        cArr2[iT] = this.u;
    }

    private void e2(String str) throws IOException {
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = this.u;
        l1(str);
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr2 = this.v;
        int i2 = this.x;
        this.x = i2 + 1;
        cArr2[i2] = this.u;
    }

    private void f2(short s) throws IOException {
        if (this.x + 8 >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        int i2 = i + 1;
        this.x = i2;
        cArr[i] = this.u;
        int iR = is1.r(s, cArr, i2);
        char[] cArr2 = this.v;
        this.x = iR + 1;
        cArr2[iR] = this.u;
    }

    private void g2(int i) throws IOException {
        char[] cArr;
        char c;
        int[] iArr = this.l;
        int length = iArr.length;
        int i2 = 0;
        int iO1 = 0;
        while (i2 < i) {
            do {
                cArr = this.v;
                c = cArr[i2];
                if (c < length && iArr[c] != 0) {
                    break;
                } else {
                    i2++;
                }
            } while (i2 < i);
            int i3 = i2 - iO1;
            if (i3 > 0) {
                this.t.write(cArr, iO1, i3);
                if (i2 >= i) {
                    return;
                }
            }
            i2++;
            iO1 = O1(this.v, i2, i, c, iArr[c]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d A[PHI: r4
      0x001d: PHI (r4v5 int) = (r4v2 int), (r4v6 int) binds: [B:9:0x0019, B:7:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    private void h2(int i, int i2) throws IOException {
        char[] cArr;
        char c;
        int[] iArr = this.l;
        int iMin = Math.min(iArr.length, i2 + 1);
        int i3 = 0;
        int iO1 = 0;
        int i4 = 0;
        while (i3 < i) {
            do {
                cArr = this.v;
                c = cArr[i3];
                if (c < iMin) {
                    i4 = iArr[c];
                    if (i4 != 0) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    if (c > i2) {
                        i4 = -1;
                        break;
                    }
                    i3++;
                }
            } while (i3 < i);
            int i5 = i3 - iO1;
            if (i5 > 0) {
                this.t.write(cArr, iO1, i5);
                if (i3 >= i) {
                    return;
                }
            }
            i3++;
            iO1 = O1(this.v, i3, i, c, i4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0031 A[PHI: r6
      0x0031: PHI (r6v6 int) = (r6v2 int), (r6v7 int) binds: [B:15:0x002d, B:10:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    private void i2(int i) throws IOException {
        char c;
        int[] iArr = this.l;
        int i2 = this.m;
        if (i2 < 1) {
            i2 = 65535;
        }
        int iMin = Math.min(iArr.length, i2 + 1);
        CharacterEscapes characterEscapes = this.n;
        int i3 = 0;
        int iO1 = 0;
        int i4 = 0;
        while (i3 < i) {
            do {
                c = this.v[i3];
                if (c < iMin) {
                    i4 = iArr[c];
                    if (i4 != 0) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    if (c > i2) {
                        i4 = -1;
                        break;
                    }
                    vm2 escapeSequence = characterEscapes.getEscapeSequence(c);
                    this.F = escapeSequence;
                    if (escapeSequence != null) {
                        i4 = -2;
                        break;
                    }
                    i3++;
                }
            } while (i3 < i);
            int i5 = i3 - iO1;
            if (i5 > 0) {
                this.t.write(this.v, iO1, i5);
                if (i3 >= i) {
                    return;
                }
            }
            i3++;
            iO1 = O1(this.v, i3, i, c, i4);
        }
    }

    private void j2(String str) throws IOException {
        int length = str.length();
        int i = this.y;
        if (length > i) {
            Y1(str);
            return;
        }
        if (this.x + length > i) {
            N1();
        }
        str.getChars(0, length, this.v, this.x);
        if (this.n != null) {
            p2(length);
            return;
        }
        int i2 = this.m;
        if (i2 != 0) {
            n2(length, i2);
        } else {
            l2(length);
        }
    }

    private void k2(char[] cArr, int i, int i2) throws IOException {
        if (this.n != null) {
            q2(cArr, i, i2);
            return;
        }
        int i3 = this.m;
        if (i3 != 0) {
            o2(cArr, i, i2, i3);
            return;
        }
        int i4 = i2 + i;
        int[] iArr = this.l;
        int length = iArr.length;
        while (i < i4) {
            int i5 = i;
            do {
                char c = cArr[i5];
                if (c < length && iArr[c] != 0) {
                    break;
                } else {
                    i5++;
                }
            } while (i5 < i4);
            int i6 = i5 - i;
            if (i6 < 32) {
                if (this.x + i6 > this.y) {
                    N1();
                }
                if (i6 > 0) {
                    System.arraycopy(cArr, i, this.v, this.x, i6);
                    this.x += i6;
                }
            } else {
                N1();
                this.t.write(cArr, i, i6);
            }
            if (i5 >= i4) {
                return;
            }
            i = i5 + 1;
            char c2 = cArr[i5];
            M1(c2, iArr[c2]);
        }
    }

    private void l2(int i) throws IOException {
        int i2;
        int i3 = this.x + i;
        int[] iArr = this.l;
        int length = iArr.length;
        while (this.x < i3) {
            do {
                char[] cArr = this.v;
                int i4 = this.x;
                char c = cArr[i4];
                if (c >= length || iArr[c] == 0) {
                    i2 = i4 + 1;
                    this.x = i2;
                } else {
                    int i5 = this.w;
                    int i6 = i4 - i5;
                    if (i6 > 0) {
                        this.t.write(cArr, i5, i6);
                    }
                    char[] cArr2 = this.v;
                    int i7 = this.x;
                    this.x = i7 + 1;
                    char c2 = cArr2[i7];
                    P1(c2, iArr[c2]);
                }
            } while (i2 < i3);
            return;
        }
    }

    private void m2(vm2 vm2Var) throws IOException {
        char[] cArrAsQuotedChars = vm2Var.asQuotedChars();
        int length = cArrAsQuotedChars.length;
        if (length < 32) {
            if (length > this.y - this.x) {
                N1();
            }
            System.arraycopy(cArrAsQuotedChars, 0, this.v, this.x, length);
            this.x += length;
        } else {
            N1();
            this.t.write(cArrAsQuotedChars, 0, length);
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = this.u;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    /* JADX WARN: Code duplicated, block: B:22:0x002a A[SYNTHETIC] */
    private void n2(int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.x + i;
        int[] iArr = this.l;
        int iMin = Math.min(iArr.length, i2 + 1);
        while (this.x < i7) {
            do {
                char[] cArr = this.v;
                int i8 = this.x;
                char c = cArr[i8];
                if (c < iMin) {
                    i3 = iArr[c];
                    if (i3 != 0) {
                        i4 = this.w;
                        i5 = i8 - i4;
                        if (i5 > 0) {
                            this.t.write(cArr, i4, i5);
                        }
                        this.x++;
                        P1(c, i3);
                    }
                    i6 = i8 + 1;
                    this.x = i6;
                } else {
                    if (c > i2) {
                        i3 = -1;
                        i4 = this.w;
                        i5 = i8 - i4;
                        if (i5 > 0) {
                            this.t.write(cArr, i4, i5);
                        }
                        this.x++;
                        P1(c, i3);
                    }
                    i6 = i8 + 1;
                    this.x = i6;
                }
            } while (i6 < i7);
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001b A[PHI: r2
      0x001b: PHI (r2v6 int) = (r2v3 int), (r2v7 int) binds: [B:10:0x0017, B:8:0x0014] A[DONT_GENERATE, DONT_INLINE]] */
    private void o2(char[] cArr, int i, int i2, int i3) throws IOException {
        char c;
        int i4 = i2 + i;
        int[] iArr = this.l;
        int iMin = Math.min(iArr.length, i3 + 1);
        int i5 = 0;
        while (i < i4) {
            int i6 = i;
            do {
                c = cArr[i6];
                if (c < iMin) {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    } else {
                        i6++;
                    }
                } else {
                    if (c > i3) {
                        i5 = -1;
                        break;
                    }
                    i6++;
                }
            } while (i6 < i4);
            int i7 = i6 - i;
            if (i7 < 32) {
                if (this.x + i7 > this.y) {
                    N1();
                }
                if (i7 > 0) {
                    System.arraycopy(cArr, i, this.v, this.x, i7);
                    this.x += i7;
                }
            } else {
                N1();
                this.t.write(cArr, i, i7);
            }
            if (i6 >= i4) {
                return;
            }
            i = i6 + 1;
            M1(c, i5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0042 A[SYNTHETIC] */
    private void p2(int i) throws IOException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.x + i;
        int[] iArr = this.l;
        int i7 = this.m;
        if (i7 < 1) {
            i7 = 65535;
        }
        int iMin = Math.min(iArr.length, i7 + 1);
        CharacterEscapes characterEscapes = this.n;
        while (this.x < i6) {
            do {
                char c = this.v[this.x];
                if (c < iMin) {
                    i2 = iArr[c];
                    if (i2 != 0) {
                        int i8 = this.x;
                        i3 = this.w;
                        i4 = i8 - i3;
                        if (i4 > 0) {
                            this.t.write(this.v, i3, i4);
                        }
                        this.x++;
                        P1(c, i2);
                    }
                    i5 = this.x + 1;
                    this.x = i5;
                } else {
                    if (c > i7) {
                        i2 = -1;
                    } else {
                        vm2 escapeSequence = characterEscapes.getEscapeSequence(c);
                        this.F = escapeSequence;
                        if (escapeSequence != null) {
                            i2 = -2;
                        }
                        i5 = this.x + 1;
                        this.x = i5;
                    }
                    int i9 = this.x;
                    i3 = this.w;
                    i4 = i9 - i3;
                    if (i4 > 0) {
                        this.t.write(this.v, i3, i4);
                    }
                    this.x++;
                    P1(c, i2);
                }
            } while (i5 < i6);
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002f A[PHI: r4
      0x002f: PHI (r4v6 int) = (r4v2 int), (r4v7 int) binds: [B:16:0x002b, B:11:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    private void q2(char[] cArr, int i, int i2) throws IOException {
        char c;
        int i3 = i2 + i;
        int[] iArr = this.l;
        int i4 = this.m;
        if (i4 < 1) {
            i4 = 65535;
        }
        int iMin = Math.min(iArr.length, i4 + 1);
        CharacterEscapes characterEscapes = this.n;
        int i5 = 0;
        while (i < i3) {
            int i6 = i;
            do {
                c = cArr[i6];
                if (c < iMin) {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    } else {
                        i6++;
                    }
                } else {
                    if (c > i4) {
                        i5 = -1;
                        break;
                    }
                    vm2 escapeSequence = characterEscapes.getEscapeSequence(c);
                    this.F = escapeSequence;
                    if (escapeSequence != null) {
                        i5 = -2;
                        break;
                    }
                    i6++;
                }
            } while (i6 < i3);
            int i7 = i6 - i;
            if (i7 < 32) {
                if (this.x + i7 > this.y) {
                    N1();
                }
                if (i7 > 0) {
                    System.arraycopy(cArr, i, this.v, this.x, i7);
                    this.x += i7;
                }
            } else {
                N1();
                this.t.write(cArr, i, i7);
            }
            if (i6 >= i3) {
                return;
            }
            i = i6 + 1;
            M1(c, i5);
        }
    }

    private char[] r2() {
        return this.f457q ? H : I;
    }

    private void s2(String str) throws IOException {
        int i = this.y;
        int i2 = this.x;
        int i3 = i - i2;
        str.getChars(0, i3, this.v, i2);
        this.x += i3;
        N1();
        int length = str.length() - i3;
        while (true) {
            int i4 = this.y;
            if (length <= i4) {
                str.getChars(i3, i3 + length, this.v, 0);
                this.w = 0;
                this.x = length;
                return;
            } else {
                int i5 = i3 + i4;
                str.getChars(i3, i5, this.v, 0);
                this.w = 0;
                this.x = i4;
                N1();
                length -= i4;
                i3 = i5;
            }
        }
    }

    @Override // defpackage.it0
    protected final void I1(String str) throws IOException {
        char c;
        int iA = this.h.A();
        if (this.a != null) {
            K1(str, iA);
            return;
        }
        if (iA == 1) {
            c = ',';
        } else {
            if (iA != 2) {
                if (iA != 3) {
                    if (iA != 5) {
                        return;
                    }
                    J1(str);
                    return;
                } else {
                    vm2 vm2Var = this.o;
                    if (vm2Var != null) {
                        l1(vm2Var.getValue());
                        return;
                    }
                    return;
                }
            }
            c = ':';
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = c;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int K0(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        I1("write a binary value");
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i2 = this.x;
        this.x = i2 + 1;
        cArr[i2] = this.u;
        byte[] bArrD = this.k.d();
        try {
            if (i < 0) {
                i = S1(base64Variant, inputStream, bArrD);
            } else {
                int iT1 = T1(base64Variant, inputStream, bArrD, i);
                if (iT1 > 0) {
                    n("Too few bytes available: missing " + iT1 + " bytes (out of " + i + ")");
                }
            }
            this.k.o(bArrD);
            if (this.x >= this.y) {
                N1();
            }
            char[] cArr2 = this.v;
            int i3 = this.x;
            this.x = i3 + 1;
            cArr2[i3] = this.u;
            return i;
        } catch (Throwable th) {
            this.k.o(bArrD);
            throw th;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void M0(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        D1(bArr, i, i2);
        I1("write a binary value");
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i3 = this.x;
        this.x = i3 + 1;
        cArr[i3] = this.u;
        U1(base64Variant, bArr, i, i2 + i);
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr2 = this.v;
        int i4 = this.x;
        this.x = i4 + 1;
        cArr2[i4] = this.u;
    }

    protected void N1() throws IOException {
        int i = this.x;
        int i2 = this.w;
        int i3 = i - i2;
        if (i3 > 0) {
            this.w = 0;
            this.x = 0;
            this.t.write(this.v, i2, i3);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void P0(boolean z) throws IOException {
        int i;
        I1("write a boolean value");
        if (this.x + 5 >= this.y) {
            N1();
        }
        int i2 = this.x;
        char[] cArr = this.v;
        if (z) {
            cArr[i2] = 't';
            cArr[i2 + 1] = 'r';
            cArr[i2 + 2] = 'u';
            i = i2 + 3;
            cArr[i] = 'e';
        } else {
            cArr[i2] = 'f';
            cArr[i2 + 1] = 'a';
            cArr[i2 + 2] = 'l';
            cArr[i2 + 3] = 's';
            i = i2 + 4;
            cArr[i] = 'e';
        }
        this.x = i + 1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void R0() throws IOException {
        if (!this.h.i()) {
            n("Current context not Array but " + this.h.m());
        }
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeEndArray(this, this.h.d());
        } else {
            if (this.x >= this.y) {
                N1();
            }
            char[] cArr = this.v;
            int i = this.x;
            this.x = i + 1;
            cArr[i] = ']';
        }
        this.h = this.h.o();
    }

    protected void R1() {
        char[] cArr = this.v;
        if (cArr != null) {
            this.v = null;
            this.k.p(cArr);
        }
        char[] cArr2 = this.G;
        if (cArr2 != null) {
            this.G = null;
            this.k.q(cArr2);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void S0() throws IOException {
        if (!this.h.j()) {
            n("Current context not Object but " + this.h.m());
        }
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeEndObject(this, this.h.d());
        } else {
            if (this.x >= this.y) {
                N1();
            }
            char[] cArr = this.v;
            int i = this.x;
            this.x = i + 1;
            cArr[i] = '}';
        }
        this.h = this.h.o();
    }

    protected final int S1(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.y - 6;
        int i2 = 2;
        int i3 = -3;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i4 = 0;
        int iQ1 = 0;
        int i5 = 0;
        while (true) {
            if (i4 > i3) {
                iQ1 = Q1(inputStream, bArr, i4, iQ1, bArr.length);
                if (iQ1 < 3) {
                    break;
                }
                i3 = iQ1 - 3;
                i4 = 0;
            }
            if (this.x > i) {
                N1();
            }
            int i6 = i4 + 2;
            int i7 = ((bArr[i4 + 1] & 255) | (bArr[i4] << 8)) << 8;
            i4 += 3;
            i5 += 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i7 | (bArr[i6] & 255), this.v, this.x);
            this.x = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                char[] cArr = this.v;
                int i8 = iEncodeBase64Chunk + 1;
                this.x = i8;
                cArr[iEncodeBase64Chunk] = '\\';
                this.x = iEncodeBase64Chunk + 2;
                cArr[i8] = 'n';
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        if (iQ1 <= 0) {
            return i5;
        }
        if (this.x > i) {
            N1();
        }
        int i9 = bArr[0] << AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN;
        if (1 < iQ1) {
            i9 |= (bArr[1] & 255) << 8;
        } else {
            i2 = 1;
        }
        int i10 = i5 + i2;
        this.x = base64Variant.encodeBase64Partial(i9, i2, this.v, this.x);
        return i10;
    }

    protected final int T1(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i) throws IOException {
        int iQ1;
        int i2 = this.y - 6;
        int i3 = 2;
        int i4 = -3;
        int i5 = i;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i6 = 0;
        int iQ2 = 0;
        while (i5 > 2) {
            if (i6 > i4) {
                iQ2 = Q1(inputStream, bArr, i6, iQ2, i5);
                if (iQ2 < 3) {
                    i6 = 0;
                    break;
                }
                i4 = iQ2 - 3;
                i6 = 0;
            }
            if (this.x > i2) {
                N1();
            }
            int i7 = i6 + 2;
            int i8 = ((bArr[i6 + 1] & 255) | (bArr[i6] << 8)) << 8;
            i6 += 3;
            i5 -= 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i8 | (bArr[i7] & 255), this.v, this.x);
            this.x = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                char[] cArr = this.v;
                int i9 = iEncodeBase64Chunk + 1;
                this.x = i9;
                cArr[iEncodeBase64Chunk] = '\\';
                this.x = iEncodeBase64Chunk + 2;
                cArr[i9] = 'n';
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        if (i5 <= 0 || (iQ1 = Q1(inputStream, bArr, i6, iQ2, i5)) <= 0) {
            return i5;
        }
        if (this.x > i2) {
            N1();
        }
        int i10 = bArr[0] << AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN;
        if (1 < iQ1) {
            i10 |= (bArr[1] & 255) << 8;
        } else {
            i3 = 1;
        }
        this.x = base64Variant.encodeBase64Partial(i10, i3, this.v, this.x);
        return i5 - i3;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void U0(vm2 vm2Var) throws IOException {
        int iZ = this.h.z(vm2Var.getValue());
        if (iZ == 4) {
            n("Can not write a field name, expecting a value");
        }
        V1(vm2Var, iZ == 1);
    }

    protected final void U1(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        int iEncodeBase64Chunk;
        int i3 = i2 - 3;
        int i4 = this.y - 6;
        int maxLineLength = base64Variant.getMaxLineLength();
        loop0: while (true) {
            int i5 = maxLineLength >> 2;
            do {
                if (i > i3) {
                    break loop0;
                }
                if (this.x > i4) {
                    N1();
                }
                int i6 = i + 2;
                int i7 = ((bArr[i + 1] & 255) | (bArr[i] << 8)) << 8;
                i += 3;
                iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i7 | (bArr[i6] & 255), this.v, this.x);
                this.x = iEncodeBase64Chunk;
                i5--;
            } while (i5 > 0);
            char[] cArr = this.v;
            int i8 = iEncodeBase64Chunk + 1;
            this.x = i8;
            cArr[iEncodeBase64Chunk] = '\\';
            this.x = iEncodeBase64Chunk + 2;
            cArr[i8] = 'n';
            maxLineLength = base64Variant.getMaxLineLength();
        }
        int i9 = i2 - i;
        if (i9 > 0) {
            if (this.x > i4) {
                N1();
            }
            int i10 = i + 1;
            int i11 = bArr[i] << AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN;
            if (i9 == 2) {
                i11 |= (bArr[i10] & 255) << 8;
            }
            this.x = base64Variant.encodeBase64Partial(i11, i9, this.v, this.x);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void V0(String str) throws IOException {
        int iZ = this.h.z(str);
        if (iZ == 4) {
            n("Can not write a field name, expecting a value");
        }
        W1(str, iZ == 1);
    }

    protected final void V1(vm2 vm2Var, boolean z) throws IOException {
        if (this.a != null) {
            a2(vm2Var, z);
            return;
        }
        if (this.x + 1 >= this.y) {
            N1();
        }
        if (z) {
            char[] cArr = this.v;
            int i = this.x;
            this.x = i + 1;
            cArr[i] = ',';
        }
        if (this.p) {
            char[] cArrAsQuotedChars = vm2Var.asQuotedChars();
            m1(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
            return;
        }
        char[] cArr2 = this.v;
        int i2 = this.x;
        int i3 = i2 + 1;
        this.x = i3;
        cArr2[i2] = this.u;
        int iAppendQuoted = vm2Var.appendQuoted(cArr2, i3);
        if (iAppendQuoted < 0) {
            X1(vm2Var);
            return;
        }
        int i4 = this.x + iAppendQuoted;
        this.x = i4;
        if (i4 >= this.y) {
            N1();
        }
        char[] cArr3 = this.v;
        int i5 = this.x;
        this.x = i5 + 1;
        cArr3[i5] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void W0() throws IOException {
        I1("write a null");
        Z1();
    }

    protected final void W1(String str, boolean z) throws IOException {
        if (this.a != null) {
            b2(str, z);
            return;
        }
        if (this.x + 1 >= this.y) {
            N1();
        }
        if (z) {
            char[] cArr = this.v;
            int i = this.x;
            this.x = i + 1;
            cArr[i] = ',';
        }
        if (this.p) {
            j2(str);
            return;
        }
        char[] cArr2 = this.v;
        int i2 = this.x;
        this.x = i2 + 1;
        cArr2[i2] = this.u;
        j2(str);
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr3 = this.v;
        int i3 = this.x;
        this.x = i3 + 1;
        cArr3[i3] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void X0(double d) throws IOException {
        if (this.g || (is1.o(d) && k0(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            w1(is1.v(d, k0(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        } else {
            I1("write a number");
            l1(is1.v(d, k0(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void Y0(float f) throws IOException {
        if (this.g || (is1.p(f) && k0(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            w1(is1.x(f, k0(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        } else {
            I1("write a number");
            l1(is1.x(f, k0(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void Z0(int i) throws IOException {
        I1("write a number");
        if (this.g) {
            c2(i);
            return;
        }
        if (this.x + 11 >= this.y) {
            N1();
        }
        this.x = is1.r(i, this.v, this.x);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a1(long j) throws IOException {
        I1("write a number");
        if (this.g) {
            d2(j);
            return;
        }
        if (this.x + 21 >= this.y) {
            N1();
        }
        this.x = is1.t(j, this.v, this.x);
    }

    protected final void a2(vm2 vm2Var, boolean z) throws IOException {
        if (z) {
            this.a.writeObjectEntrySeparator(this);
        } else {
            this.a.beforeObjectEntries(this);
        }
        char[] cArrAsQuotedChars = vm2Var.asQuotedChars();
        if (this.p) {
            m1(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
            return;
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = this.u;
        m1(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr2 = this.v;
        int i2 = this.x;
        this.x = i2 + 1;
        cArr2[i2] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void b1(String str) throws IOException {
        I1("write a number");
        if (str == null) {
            Z1();
        } else if (this.g) {
            e2(str);
        } else {
            l1(str);
        }
    }

    protected final void b2(String str, boolean z) throws IOException {
        if (z) {
            this.a.writeObjectEntrySeparator(this);
        } else {
            this.a.beforeObjectEntries(this);
        }
        if (this.p) {
            j2(str);
            return;
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = this.u;
        j2(str);
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr2 = this.v;
        int i2 = this.x;
        this.x = i2 + 1;
        cArr2[i2] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void c1(BigDecimal bigDecimal) throws IOException {
        I1("write a number");
        if (bigDecimal == null) {
            Z1();
        } else if (this.g) {
            e2(C1(bigDecimal));
        } else {
            l1(C1(bigDecimal));
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    @Override // defpackage.it0, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        super.close();
        try {
            if (this.v != null && k0(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
                while (true) {
                    h71 h71VarG0 = g0();
                    if (!h71VarG0.i()) {
                        if (!h71VarG0.j()) {
                            break;
                        } else {
                            S0();
                        }
                    } else {
                        R0();
                    }
                }
            }
            N1();
            e = null;
        } catch (IOException e) {
            e = e;
        }
        this.w = 0;
        this.x = 0;
        if (this.t != null) {
            try {
                if (this.k.n() || k0(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                    this.t.close();
                } else if (k0(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                    this.t.flush();
                }
            } catch (IOException e2) {
                e = e2;
                if (e != null) {
                    e.addSuppressed(e);
                }
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                if (e != null) {
                    e.addSuppressed(e);
                }
                throw e;
            }
        }
        R1();
        if (e != null) {
            throw e;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void d1(BigInteger bigInteger) throws IOException {
        I1("write a number");
        if (bigInteger == null) {
            Z1();
        } else if (this.g) {
            e2(bigInteger.toString());
        } else {
            l1(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void e1(short s) throws IOException {
        I1("write a number");
        if (this.g) {
            f2(s);
            return;
        }
        if (this.x + 6 >= this.y) {
            N1();
        }
        this.x = is1.r(s, this.v, this.x);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        N1();
        if (this.t == null || !k0(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.t.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void j1(char c) throws IOException {
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = c;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void k1(vm2 vm2Var) throws IOException {
        int iAppendUnquoted = vm2Var.appendUnquoted(this.v, this.x);
        if (iAppendUnquoted < 0) {
            l1(vm2Var.getValue());
        } else {
            this.x += iAppendUnquoted;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void l1(String str) throws IOException {
        int length = str.length();
        int i = this.y - this.x;
        if (i == 0) {
            N1();
            i = this.y - this.x;
        }
        if (i < length) {
            s2(str);
        } else {
            str.getChars(0, length, this.v, this.x);
            this.x += length;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void m1(char[] cArr, int i, int i2) throws IOException {
        E1(cArr, i, i2);
        if (i2 >= 32) {
            N1();
            this.t.write(cArr, i, i2);
        } else {
            if (i2 > this.y - this.x) {
                N1();
            }
            System.arraycopy(cArr, i, this.v, this.x, i2);
            this.x += i2;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void p1() throws IOException {
        I1("start an array");
        this.h = this.h.p();
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeStartArray(this);
            return;
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void q1(Object obj) throws IOException {
        I1("start an array");
        this.h = this.h.q(obj);
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeStartArray(this);
            return;
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void r1(Object obj, int i) throws IOException {
        I1("start an array");
        this.h = this.h.q(obj);
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeStartArray(this);
            return;
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i2 = this.x;
        this.x = i2 + 1;
        cArr[i2] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void s1() throws IOException {
        I1("start an object");
        this.h = this.h.r();
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeStartObject(this);
            return;
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = '{';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void t1(Object obj) throws IOException {
        I1("start an object");
        this.h = this.h.s(obj);
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeStartObject(this);
            return;
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = '{';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void u1(Object obj, int i) throws IOException {
        t1(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void v1(vm2 vm2Var) throws IOException {
        I1("write a string");
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        int i2 = i + 1;
        this.x = i2;
        cArr[i] = this.u;
        int iAppendQuoted = vm2Var.appendQuoted(cArr, i2);
        if (iAppendQuoted < 0) {
            m2(vm2Var);
            return;
        }
        int i3 = this.x + iAppendQuoted;
        this.x = i3;
        if (i3 >= this.y) {
            N1();
        }
        char[] cArr2 = this.v;
        int i4 = this.x;
        this.x = i4 + 1;
        cArr2[i4] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void w1(String str) throws IOException {
        I1("write a string");
        if (str == null) {
            Z1();
            return;
        }
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr = this.v;
        int i = this.x;
        this.x = i + 1;
        cArr[i] = this.u;
        j2(str);
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr2 = this.v;
        int i2 = this.x;
        this.x = i2 + 1;
        cArr2[i2] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void x1(char[] cArr, int i, int i2) throws IOException {
        I1("write a string");
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr2 = this.v;
        int i3 = this.x;
        this.x = i3 + 1;
        cArr2[i3] = this.u;
        k2(cArr, i, i2);
        if (this.x >= this.y) {
            N1();
        }
        char[] cArr3 = this.v;
        int i4 = this.x;
        this.x = i4 + 1;
        cArr3[i4] = this.u;
    }
}
