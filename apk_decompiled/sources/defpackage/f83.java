package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class f83 extends z51 {
    private static final byte[] H = ex.c(true);
    private static final byte[] I = ex.c(false);
    private static final byte[] J = {110, 117, 108, 108};
    private static final byte[] K = {116, 114, 117, 101};
    private static final byte[] L = {102, 97, 108, 115, 101};
    protected final int F;
    protected boolean G;
    protected final OutputStream t;
    protected byte u;
    protected byte[] v;
    protected int w;
    protected final int x;
    protected final int y;
    protected char[] z;

    public f83(oy0 oy0Var, int i, jt1 jt1Var, OutputStream outputStream, char c) {
        super(oy0Var, i, jt1Var);
        this.t = outputStream;
        this.u = (byte) c;
        if (c != '\"') {
            this.l = ex.f(c);
        }
        this.G = true;
        byte[] bArrJ = oy0Var.j();
        this.v = bArrJ;
        int length = bArrJ.length;
        this.x = length;
        this.y = length >> 3;
        char[] cArrE = oy0Var.e();
        this.z = cArrE;
        this.F = cArrE.length;
        if (k0(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            A0(127);
        }
    }

    private final int M1(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        int length = bArr2.length;
        if (i + length > i2) {
            this.w = i;
            L1();
            i = this.w;
            if (length > bArr.length) {
                this.t.write(bArr2, 0, length);
                return i;
            }
        }
        System.arraycopy(bArr2, 0, bArr, i, length);
        int i4 = i + length;
        if ((i3 * 6) + i4 <= i2) {
            return i4;
        }
        this.w = i4;
        L1();
        return this.w;
    }

    private final int N1(int i, int i2) {
        byte[] bArrT2 = t2();
        byte[] bArr = this.v;
        if (i < 55296 || i > 57343) {
            bArr[i2] = (byte) ((i >> 12) | 224);
            int i3 = i2 + 2;
            bArr[i2 + 1] = (byte) (((i >> 6) & 63) | 128);
            int i4 = i2 + 3;
            bArr[i3] = (byte) ((i & 63) | 128);
            return i4;
        }
        bArr[i2] = 92;
        bArr[i2 + 1] = 117;
        bArr[i2 + 2] = bArrT2[(i >> 12) & 15];
        bArr[i2 + 3] = bArrT2[(i >> 8) & 15];
        int i5 = i2 + 5;
        bArr[i2 + 4] = bArrT2[(i >> 4) & 15];
        int i6 = i2 + 6;
        bArr[i5] = bArrT2[i & 15];
        return i6;
    }

    private final int O1(int i, char[] cArr, int i2, int i3) throws IOException {
        if (i >= 55296 && i <= 57343) {
            if (i2 >= i3 || cArr == null) {
                n(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", Integer.valueOf(i)));
            } else {
                P1(i, cArr[i2]);
            }
            return i2 + 1;
        }
        byte[] bArr = this.v;
        int i4 = this.w;
        int i5 = i4 + 1;
        this.w = i5;
        bArr[i4] = (byte) ((i >> 12) | 224);
        int i6 = i4 + 2;
        this.w = i6;
        bArr[i5] = (byte) (((i >> 6) & 63) | 128);
        this.w = i4 + 3;
        bArr[i6] = (byte) ((i & 63) | 128);
        return i2;
    }

    private final int Q1(InputStream inputStream, byte[] bArr, int i, int i2, int i3) throws IOException {
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

    private final void V1(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.w + length > this.x) {
            L1();
            if (length > 512) {
                this.t.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.v, this.w, length);
        this.w += length;
    }

    private final int W1(byte[] bArr, int i, vm2 vm2Var, int i2) {
        byte[] bArrAsUnquotedUTF8 = vm2Var.asUnquotedUTF8();
        int length = bArrAsUnquotedUTF8.length;
        if (length > 6) {
            return M1(bArr, i, this.x, bArrAsUnquotedUTF8, i2);
        }
        System.arraycopy(bArrAsUnquotedUTF8, 0, bArr, i, length);
        return i + length;
    }

    private final void X1(String str, int i, int i2) throws IOException {
        if (this.w + ((i2 - i) * 6) > this.x) {
            L1();
        }
        int iN1 = this.w;
        byte[] bArr = this.v;
        int[] iArr = this.l;
        int i3 = this.m;
        if (i3 <= 0) {
            i3 = 65535;
        }
        CharacterEscapes characterEscapes = this.n;
        while (i < i2) {
            i++;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                int i4 = iArr[cCharAt];
                if (i4 == 0) {
                    bArr[iN1] = (byte) cCharAt;
                    iN1++;
                } else if (i4 > 0) {
                    int i5 = iN1 + 1;
                    bArr[iN1] = 92;
                    iN1 += 2;
                    bArr[i5] = (byte) i4;
                } else if (i4 == -2) {
                    vm2 escapeSequence = characterEscapes.getEscapeSequence(cCharAt);
                    if (escapeSequence == null) {
                        n("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(cCharAt) + ", although was supposed to have one");
                    }
                    iN1 = W1(bArr, iN1, escapeSequence, i2 - i);
                } else {
                    iN1 = Z1(cCharAt, iN1);
                }
            } else if (cCharAt > i3) {
                iN1 = Z1(cCharAt, iN1);
            } else {
                vm2 escapeSequence2 = characterEscapes.getEscapeSequence(cCharAt);
                if (escapeSequence2 != null) {
                    iN1 = W1(bArr, iN1, escapeSequence2, i2 - i);
                } else if (cCharAt <= 2047) {
                    int i6 = iN1 + 1;
                    bArr[iN1] = (byte) ((cCharAt >> 6) | 192);
                    iN1 += 2;
                    bArr[i6] = (byte) ((cCharAt & '?') | 128);
                } else {
                    iN1 = N1(cCharAt, iN1);
                }
            }
        }
        this.w = iN1;
    }

    private final void Y1(char[] cArr, int i, int i2) throws IOException {
        if (this.w + ((i2 - i) * 6) > this.x) {
            L1();
        }
        int iN1 = this.w;
        byte[] bArr = this.v;
        int[] iArr = this.l;
        int i3 = this.m;
        if (i3 <= 0) {
            i3 = 65535;
        }
        CharacterEscapes characterEscapes = this.n;
        while (i < i2) {
            i++;
            char c = cArr[i];
            if (c <= 127) {
                int i4 = iArr[c];
                if (i4 == 0) {
                    bArr[iN1] = (byte) c;
                    iN1++;
                } else if (i4 > 0) {
                    int i5 = iN1 + 1;
                    bArr[iN1] = 92;
                    iN1 += 2;
                    bArr[i5] = (byte) i4;
                } else if (i4 == -2) {
                    vm2 escapeSequence = characterEscapes.getEscapeSequence(c);
                    if (escapeSequence == null) {
                        n("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c) + ", although was supposed to have one");
                    }
                    iN1 = W1(bArr, iN1, escapeSequence, i2 - i);
                } else {
                    iN1 = Z1(c, iN1);
                }
            } else if (c > i3) {
                iN1 = Z1(c, iN1);
            } else {
                vm2 escapeSequence2 = characterEscapes.getEscapeSequence(c);
                if (escapeSequence2 != null) {
                    iN1 = W1(bArr, iN1, escapeSequence2, i2 - i);
                } else if (c <= 2047) {
                    int i6 = iN1 + 1;
                    bArr[iN1] = (byte) ((c >> 6) | 192);
                    iN1 += 2;
                    bArr[i6] = (byte) ((c & '?') | 128);
                } else {
                    iN1 = N1(c, iN1);
                }
            }
        }
        this.w = iN1;
    }

    private int Z1(int i, int i2) {
        int i3;
        byte[] bArr = this.v;
        byte[] bArrT2 = t2();
        bArr[i2] = 92;
        int i4 = i2 + 2;
        bArr[i2 + 1] = 117;
        if (i > 255) {
            int i5 = i >> 8;
            int i6 = i2 + 3;
            bArr[i4] = bArrT2[(i5 & 255) >> 4];
            i3 = i2 + 4;
            bArr[i6] = bArrT2[i5 & 15];
            i &= 255;
        } else {
            int i7 = i2 + 3;
            bArr[i4] = 48;
            i3 = i2 + 4;
            bArr[i7] = 48;
        }
        int i8 = i3 + 1;
        bArr[i3] = bArrT2[i >> 4];
        int i9 = i3 + 2;
        bArr[i8] = bArrT2[i & 15];
        return i9;
    }

    private final void a2() throws IOException {
        if (this.w + 4 >= this.x) {
            L1();
        }
        System.arraycopy(J, 0, this.v, this.w, 4);
        this.w += 4;
    }

    private final void d2(int i) throws IOException {
        if (this.w + 13 >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i2 = this.w;
        int i3 = i2 + 1;
        this.w = i3;
        bArr[i2] = this.u;
        int iQ = is1.q(i, bArr, i3);
        byte[] bArr2 = this.v;
        this.w = iQ + 1;
        bArr2[iQ] = this.u;
    }

    private final void e2(long j) throws IOException {
        if (this.w + 23 >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        int i2 = i + 1;
        this.w = i2;
        bArr[i] = this.u;
        int iS = is1.s(j, bArr, i2);
        byte[] bArr2 = this.v;
        this.w = iS + 1;
        bArr2[iS] = this.u;
    }

    private final void f2(String str) throws IOException {
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        this.w = i + 1;
        bArr[i] = this.u;
        l1(str);
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr2 = this.v;
        int i2 = this.w;
        this.w = i2 + 1;
        bArr2[i2] = this.u;
    }

    private final void g2(short s) throws IOException {
        if (this.w + 8 >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        int i2 = i + 1;
        this.w = i2;
        bArr[i] = this.u;
        int iQ = is1.q(s, bArr, i2);
        byte[] bArr2 = this.v;
        this.w = iQ + 1;
        bArr2[iQ] = this.u;
    }

    private void h2(char[] cArr, int i, int i2) throws IOException {
        while (i < i2) {
            do {
                char c = cArr[i];
                if (c > 127) {
                    i++;
                    if (c < 2048) {
                        byte[] bArr = this.v;
                        int i3 = this.w;
                        int i4 = i3 + 1;
                        this.w = i4;
                        bArr[i3] = (byte) ((c >> 6) | 192);
                        this.w = i3 + 2;
                        bArr[i4] = (byte) ((c & '?') | 128);
                    } else {
                        i = O1(c, cArr, i, i2);
                    }
                } else {
                    byte[] bArr2 = this.v;
                    int i5 = this.w;
                    this.w = i5 + 1;
                    bArr2[i5] = (byte) c;
                    i++;
                }
            } while (i < i2);
            return;
        }
    }

    private final void i2(char[] cArr, int i, int i2) throws IOException {
        int i3 = this.x;
        byte[] bArr = this.v;
        int i4 = i2 + i;
        while (i < i4) {
            do {
                char c = cArr[i];
                if (c >= 128) {
                    if (this.w + 3 >= this.x) {
                        L1();
                    }
                    int i5 = i + 1;
                    char c2 = cArr[i];
                    if (c2 < 2048) {
                        int i6 = this.w;
                        int i7 = i6 + 1;
                        this.w = i7;
                        bArr[i6] = (byte) ((c2 >> 6) | 192);
                        this.w = i6 + 2;
                        bArr[i7] = (byte) ((c2 & '?') | 128);
                        i = i5;
                    } else {
                        i = O1(c2, cArr, i5, i4);
                    }
                } else {
                    if (this.w >= i3) {
                        L1();
                    }
                    int i8 = this.w;
                    this.w = i8 + 1;
                    bArr[i8] = (byte) c;
                    i++;
                }
            } while (i < i4);
            return;
        }
    }

    private final void j2(String str, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = this.w;
        byte[] bArr = this.v;
        int[] iArr = this.l;
        while (i < i3) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 127 || iArr[cCharAt] != 0) {
                break;
            }
            bArr[i4] = (byte) cCharAt;
            i++;
            i4++;
        }
        this.w = i4;
        if (i < i3) {
            if (this.n != null) {
                X1(str, i, i3);
            } else if (this.m == 0) {
                l2(str, i, i3);
            } else {
                n2(str, i, i3);
            }
        }
    }

    private final void k2(char[] cArr, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = this.w;
        byte[] bArr = this.v;
        int[] iArr = this.l;
        while (i < i3) {
            char c = cArr[i];
            if (c > 127 || iArr[c] != 0) {
                break;
            }
            bArr[i4] = (byte) c;
            i++;
            i4++;
        }
        this.w = i4;
        if (i < i3) {
            if (this.n != null) {
                Y1(cArr, i, i3);
            } else if (this.m == 0) {
                m2(cArr, i, i3);
            } else {
                o2(cArr, i, i3);
            }
        }
    }

    private final void l2(String str, int i, int i2) throws IOException {
        if (this.w + ((i2 - i) * 6) > this.x) {
            L1();
        }
        int iN1 = this.w;
        byte[] bArr = this.v;
        int[] iArr = this.l;
        while (i < i2) {
            i++;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                int i3 = iArr[cCharAt];
                if (i3 == 0) {
                    bArr[iN1] = (byte) cCharAt;
                    iN1++;
                } else if (i3 > 0) {
                    int i4 = iN1 + 1;
                    bArr[iN1] = 92;
                    iN1 += 2;
                    bArr[i4] = (byte) i3;
                } else {
                    iN1 = Z1(cCharAt, iN1);
                }
            } else if (cCharAt <= 2047) {
                int i5 = iN1 + 1;
                bArr[iN1] = (byte) ((cCharAt >> 6) | 192);
                iN1 += 2;
                bArr[i5] = (byte) ((cCharAt & '?') | 128);
            } else {
                iN1 = N1(cCharAt, iN1);
            }
        }
        this.w = iN1;
    }

    private final void m2(char[] cArr, int i, int i2) throws IOException {
        if (this.w + ((i2 - i) * 6) > this.x) {
            L1();
        }
        int iN1 = this.w;
        byte[] bArr = this.v;
        int[] iArr = this.l;
        while (i < i2) {
            i++;
            char c = cArr[i];
            if (c <= 127) {
                int i3 = iArr[c];
                if (i3 == 0) {
                    bArr[iN1] = (byte) c;
                    iN1++;
                } else if (i3 > 0) {
                    int i4 = iN1 + 1;
                    bArr[iN1] = 92;
                    iN1 += 2;
                    bArr[i4] = (byte) i3;
                } else {
                    iN1 = Z1(c, iN1);
                }
            } else if (c <= 2047) {
                int i5 = iN1 + 1;
                bArr[iN1] = (byte) ((c >> 6) | 192);
                iN1 += 2;
                bArr[i5] = (byte) ((c & '?') | 128);
            } else {
                iN1 = N1(c, iN1);
            }
        }
        this.w = iN1;
    }

    private final void n2(String str, int i, int i2) throws IOException {
        if (this.w + ((i2 - i) * 6) > this.x) {
            L1();
        }
        int iN1 = this.w;
        byte[] bArr = this.v;
        int[] iArr = this.l;
        int i3 = this.m;
        while (i < i2) {
            i++;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                int i4 = iArr[cCharAt];
                if (i4 == 0) {
                    bArr[iN1] = (byte) cCharAt;
                    iN1++;
                } else if (i4 > 0) {
                    int i5 = iN1 + 1;
                    bArr[iN1] = 92;
                    iN1 += 2;
                    bArr[i5] = (byte) i4;
                } else {
                    iN1 = Z1(cCharAt, iN1);
                }
            } else if (cCharAt > i3) {
                iN1 = Z1(cCharAt, iN1);
            } else if (cCharAt <= 2047) {
                int i6 = iN1 + 1;
                bArr[iN1] = (byte) ((cCharAt >> 6) | 192);
                iN1 += 2;
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
            } else {
                iN1 = N1(cCharAt, iN1);
            }
        }
        this.w = iN1;
    }

    private final void o2(char[] cArr, int i, int i2) throws IOException {
        if (this.w + ((i2 - i) * 6) > this.x) {
            L1();
        }
        int iN1 = this.w;
        byte[] bArr = this.v;
        int[] iArr = this.l;
        int i3 = this.m;
        while (i < i2) {
            i++;
            char c = cArr[i];
            if (c <= 127) {
                int i4 = iArr[c];
                if (i4 == 0) {
                    bArr[iN1] = (byte) c;
                    iN1++;
                } else if (i4 > 0) {
                    int i5 = iN1 + 1;
                    bArr[iN1] = 92;
                    iN1 += 2;
                    bArr[i5] = (byte) i4;
                } else {
                    iN1 = Z1(c, iN1);
                }
            } else if (c > i3) {
                iN1 = Z1(c, iN1);
            } else if (c <= 2047) {
                int i6 = iN1 + 1;
                bArr[iN1] = (byte) ((c >> 6) | 192);
                iN1 += 2;
                bArr[i6] = (byte) ((c & '?') | 128);
            } else {
                iN1 = N1(c, iN1);
            }
        }
        this.w = iN1;
    }

    private final void p2(String str, int i, int i2) throws IOException {
        do {
            int iMin = Math.min(this.y, i2);
            if (this.w + iMin > this.x) {
                L1();
            }
            j2(str, i, iMin);
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    private final void q2(String str, boolean z) throws IOException {
        if (z) {
            if (this.w >= this.x) {
                L1();
            }
            byte[] bArr = this.v;
            int i = this.w;
            this.w = i + 1;
            bArr[i] = this.u;
        }
        int length = str.length();
        int i2 = 0;
        while (length > 0) {
            int iMin = Math.min(this.y, length);
            if (this.w + iMin > this.x) {
                L1();
            }
            j2(str, i2, iMin);
            i2 += iMin;
            length -= iMin;
        }
        if (z) {
            if (this.w >= this.x) {
                L1();
            }
            byte[] bArr2 = this.v;
            int i3 = this.w;
            this.w = i3 + 1;
            bArr2[i3] = this.u;
        }
    }

    private final void r2(char[] cArr, int i, int i2) throws IOException {
        do {
            int iMin = Math.min(this.y, i2);
            if (this.w + iMin > this.x) {
                L1();
            }
            k2(cArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    private final void s2(vm2 vm2Var) throws IOException {
        int iAppendQuotedUTF8 = vm2Var.appendQuotedUTF8(this.v, this.w);
        if (iAppendQuotedUTF8 < 0) {
            V1(vm2Var.asQuotedUTF8());
        } else {
            this.w += iAppendQuotedUTF8;
        }
    }

    private byte[] t2() {
        return this.f457q ? H : I;
    }

    @Override // defpackage.it0
    protected final void I1(String str) throws IOException {
        byte b;
        int iA = this.h.A();
        if (this.a != null) {
            K1(str, iA);
            return;
        }
        if (iA == 1) {
            b = 44;
        } else {
            if (iA != 2) {
                if (iA != 3) {
                    if (iA != 5) {
                        return;
                    }
                    J1(str);
                    return;
                }
                vm2 vm2Var = this.o;
                if (vm2Var != null) {
                    byte[] bArrAsUnquotedUTF8 = vm2Var.asUnquotedUTF8();
                    if (bArrAsUnquotedUTF8.length > 0) {
                        V1(bArrAsUnquotedUTF8);
                        return;
                    }
                    return;
                }
                return;
            }
            b = 58;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        this.w = i + 1;
        bArr[i] = b;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int K0(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        I1("write a binary value");
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i2 = this.w;
        this.w = i2 + 1;
        bArr[i2] = this.u;
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
            if (this.w >= this.x) {
                L1();
            }
            byte[] bArr2 = this.v;
            int i3 = this.w;
            this.w = i3 + 1;
            bArr2[i3] = this.u;
            return i;
        } catch (Throwable th) {
            this.k.o(bArrD);
            throw th;
        }
    }

    protected final void L1() throws IOException {
        int i = this.w;
        if (i > 0) {
            this.w = 0;
            this.t.write(this.v, 0, i);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void M0(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        D1(bArr, i, i2);
        I1("write a binary value");
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr2 = this.v;
        int i3 = this.w;
        this.w = i3 + 1;
        bArr2[i3] = this.u;
        U1(base64Variant, bArr, i, i2 + i);
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr3 = this.v;
        int i4 = this.w;
        this.w = i4 + 1;
        bArr3[i4] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void P0(boolean z) throws IOException {
        I1("write a boolean value");
        if (this.w + 5 >= this.x) {
            L1();
        }
        byte[] bArr = z ? K : L;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.v, this.w, length);
        this.w += length;
    }

    protected final void P1(int i, int i2) throws IOException {
        int iH1 = H1(i, i2);
        if (this.w + 4 > this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i3 = this.w;
        int i4 = i3 + 1;
        this.w = i4;
        bArr[i3] = (byte) ((iH1 >> 18) | 240);
        int i5 = i3 + 2;
        this.w = i5;
        bArr[i4] = (byte) (((iH1 >> 12) & 63) | 128);
        int i6 = i3 + 3;
        this.w = i6;
        bArr[i5] = (byte) (((iH1 >> 6) & 63) | 128);
        this.w = i3 + 4;
        bArr[i6] = (byte) ((iH1 & 63) | 128);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void R0() throws IOException {
        if (!this.h.i()) {
            n("Current context not Array but " + this.h.m());
        }
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeEndArray(this, this.h.d());
        } else {
            if (this.w >= this.x) {
                L1();
            }
            byte[] bArr = this.v;
            int i = this.w;
            this.w = i + 1;
            bArr[i] = 93;
        }
        this.h = this.h.o();
    }

    protected void R1() {
        byte[] bArr = this.v;
        if (bArr != null && this.G) {
            this.v = null;
            this.k.t(bArr);
        }
        char[] cArr = this.z;
        if (cArr != null) {
            this.z = null;
            this.k.p(cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void S0() throws IOException {
        if (!this.h.j()) {
            n("Current context not Object but " + this.h.m());
        }
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeEndObject(this, this.h.d());
        } else {
            if (this.w >= this.x) {
                L1();
            }
            byte[] bArr = this.v;
            int i = this.w;
            this.w = i + 1;
            bArr[i] = 125;
        }
        this.h = this.h.o();
    }

    protected final int S1(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.x - 6;
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
            if (this.w > i) {
                L1();
            }
            int i6 = i4 + 2;
            int i7 = ((bArr[i4 + 1] & 255) | (bArr[i4] << 8)) << 8;
            i4 += 3;
            i5 += 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i7 | (bArr[i6] & 255), this.v, this.w);
            this.w = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr2 = this.v;
                int i8 = iEncodeBase64Chunk + 1;
                this.w = i8;
                bArr2[iEncodeBase64Chunk] = 92;
                this.w = iEncodeBase64Chunk + 2;
                bArr2[i8] = 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        if (iQ1 <= 0) {
            return i5;
        }
        if (this.w > i) {
            L1();
        }
        int i9 = bArr[0] << AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN;
        if (1 < iQ1) {
            i9 |= (bArr[1] & 255) << 8;
        } else {
            i2 = 1;
        }
        int i10 = i5 + i2;
        this.w = base64Variant.encodeBase64Partial(i9, i2, this.v, this.w);
        return i10;
    }

    protected final int T1(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i) throws IOException {
        int iQ1;
        int i2 = this.x - 6;
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
            if (this.w > i2) {
                L1();
            }
            int i7 = i6 + 2;
            int i8 = ((bArr[i6 + 1] & 255) | (bArr[i6] << 8)) << 8;
            i6 += 3;
            i5 -= 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i8 | (bArr[i7] & 255), this.v, this.w);
            this.w = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr2 = this.v;
                int i9 = iEncodeBase64Chunk + 1;
                this.w = i9;
                bArr2[iEncodeBase64Chunk] = 92;
                this.w = iEncodeBase64Chunk + 2;
                bArr2[i9] = 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        if (i5 <= 0 || (iQ1 = Q1(inputStream, bArr, i6, iQ2, i5)) <= 0) {
            return i5;
        }
        if (this.w > i2) {
            L1();
        }
        int i10 = bArr[0] << AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN;
        if (1 < iQ1) {
            i10 |= (bArr[1] & 255) << 8;
        } else {
            i3 = 1;
        }
        this.w = base64Variant.encodeBase64Partial(i10, i3, this.v, this.w);
        return i5 - i3;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void U0(vm2 vm2Var) throws IOException {
        if (this.a != null) {
            b2(vm2Var);
            return;
        }
        int iZ = this.h.z(vm2Var.getValue());
        if (iZ == 4) {
            n("Can not write a field name, expecting a value");
        }
        if (iZ == 1) {
            if (this.w >= this.x) {
                L1();
            }
            byte[] bArr = this.v;
            int i = this.w;
            this.w = i + 1;
            bArr[i] = 44;
        }
        if (this.p) {
            s2(vm2Var);
            return;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr2 = this.v;
        int i2 = this.w;
        int i3 = i2 + 1;
        this.w = i3;
        bArr2[i2] = this.u;
        int iAppendQuotedUTF8 = vm2Var.appendQuotedUTF8(bArr2, i3);
        if (iAppendQuotedUTF8 < 0) {
            V1(vm2Var.asQuotedUTF8());
        } else {
            this.w += iAppendQuotedUTF8;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr3 = this.v;
        int i4 = this.w;
        this.w = i4 + 1;
        bArr3[i4] = this.u;
    }

    protected final void U1(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        int iEncodeBase64Chunk;
        int i3 = i2 - 3;
        int i4 = this.x - 6;
        int maxLineLength = base64Variant.getMaxLineLength();
        loop0: while (true) {
            int i5 = maxLineLength >> 2;
            do {
                if (i > i3) {
                    break loop0;
                }
                if (this.w > i4) {
                    L1();
                }
                int i6 = i + 2;
                int i7 = ((bArr[i + 1] & 255) | (bArr[i] << 8)) << 8;
                i += 3;
                iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i7 | (bArr[i6] & 255), this.v, this.w);
                this.w = iEncodeBase64Chunk;
                i5--;
            } while (i5 > 0);
            byte[] bArr2 = this.v;
            int i8 = iEncodeBase64Chunk + 1;
            this.w = i8;
            bArr2[iEncodeBase64Chunk] = 92;
            this.w = iEncodeBase64Chunk + 2;
            bArr2[i8] = 110;
            maxLineLength = base64Variant.getMaxLineLength();
        }
        int i9 = i2 - i;
        if (i9 > 0) {
            if (this.w > i4) {
                L1();
            }
            int i10 = i + 1;
            int i11 = bArr[i] << AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN;
            if (i9 == 2) {
                i11 |= (bArr[i10] & 255) << 8;
            }
            this.w = base64Variant.encodeBase64Partial(i11, i9, this.v, this.w);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void V0(String str) throws IOException {
        if (this.a != null) {
            c2(str);
            return;
        }
        int iZ = this.h.z(str);
        if (iZ == 4) {
            n("Can not write a field name, expecting a value");
        }
        if (iZ == 1) {
            if (this.w >= this.x) {
                L1();
            }
            byte[] bArr = this.v;
            int i = this.w;
            this.w = i + 1;
            bArr[i] = 44;
        }
        if (this.p) {
            q2(str, false);
            return;
        }
        int length = str.length();
        if (length > this.F) {
            q2(str, true);
            return;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr2 = this.v;
        int i2 = this.w;
        int i3 = i2 + 1;
        this.w = i3;
        bArr2[i2] = this.u;
        if (length <= this.y) {
            if (i3 + length > this.x) {
                L1();
            }
            j2(str, 0, length);
        } else {
            p2(str, 0, length);
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr3 = this.v;
        int i4 = this.w;
        this.w = i4 + 1;
        bArr3[i4] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void W0() throws IOException {
        I1("write a null");
        a2();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void X0(double d) throws IOException {
        if (this.g || (is1.o(d) && JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this.f))) {
            w1(is1.v(d, k0(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        } else {
            I1("write a number");
            l1(is1.v(d, k0(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void Y0(float f) throws IOException {
        if (this.g || (is1.p(f) && JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this.f))) {
            w1(is1.x(f, k0(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        } else {
            I1("write a number");
            l1(is1.x(f, k0(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void Z0(int i) throws IOException {
        I1("write a number");
        if (this.w + 11 >= this.x) {
            L1();
        }
        if (this.g) {
            d2(i);
        } else {
            this.w = is1.q(i, this.v, this.w);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a1(long j) throws IOException {
        I1("write a number");
        if (this.g) {
            e2(j);
            return;
        }
        if (this.w + 21 >= this.x) {
            L1();
        }
        this.w = is1.s(j, this.v, this.w);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void b1(String str) throws IOException {
        I1("write a number");
        if (str == null) {
            a2();
        } else if (this.g) {
            f2(str);
        } else {
            l1(str);
        }
    }

    protected final void b2(vm2 vm2Var) throws IOException {
        int iZ = this.h.z(vm2Var.getValue());
        if (iZ == 4) {
            n("Can not write a field name, expecting a value");
        }
        if (iZ == 1) {
            this.a.writeObjectEntrySeparator(this);
        } else {
            this.a.beforeObjectEntries(this);
        }
        boolean z = this.p;
        if (!z) {
            if (this.w >= this.x) {
                L1();
            }
            byte[] bArr = this.v;
            int i = this.w;
            this.w = i + 1;
            bArr[i] = this.u;
        }
        int iAppendQuotedUTF8 = vm2Var.appendQuotedUTF8(this.v, this.w);
        if (iAppendQuotedUTF8 < 0) {
            V1(vm2Var.asQuotedUTF8());
        } else {
            this.w += iAppendQuotedUTF8;
        }
        if (z) {
            return;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr2 = this.v;
        int i2 = this.w;
        this.w = i2 + 1;
        bArr2[i2] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void c1(BigDecimal bigDecimal) throws IOException {
        I1("write a number");
        if (bigDecimal == null) {
            a2();
        } else if (this.g) {
            f2(C1(bigDecimal));
        } else {
            l1(C1(bigDecimal));
        }
    }

    protected final void c2(String str) throws IOException {
        int iZ = this.h.z(str);
        if (iZ == 4) {
            n("Can not write a field name, expecting a value");
        }
        if (iZ == 1) {
            this.a.writeObjectEntrySeparator(this);
        } else {
            this.a.beforeObjectEntries(this);
        }
        if (this.p) {
            q2(str, false);
            return;
        }
        int length = str.length();
        if (length > this.F) {
            q2(str, true);
            return;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        this.w = i + 1;
        bArr[i] = this.u;
        str.getChars(0, length, this.z, 0);
        if (length <= this.y) {
            if (this.w + length > this.x) {
                L1();
            }
            k2(this.z, 0, length);
        } else {
            r2(this.z, 0, length);
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr2 = this.v;
        int i2 = this.w;
        this.w = i2 + 1;
        bArr2[i2] = this.u;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
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
            L1();
            e = null;
        } catch (IOException e) {
            e = e;
        }
        this.w = 0;
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
            a2();
        } else if (this.g) {
            f2(bigInteger.toString());
        } else {
            l1(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void e1(short s) throws IOException {
        I1("write a number");
        if (this.w + 6 >= this.x) {
            L1();
        }
        if (this.g) {
            g2(s);
        } else {
            this.w = is1.q(s, this.v, this.w);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        L1();
        if (this.t == null || !k0(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.t.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void j1(char c) throws IOException {
        if (this.w + 3 >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        if (c <= 127) {
            int i = this.w;
            this.w = i + 1;
            bArr[i] = (byte) c;
        } else {
            if (c >= 2048) {
                O1(c, null, 0, 0);
                return;
            }
            int i2 = this.w;
            int i3 = i2 + 1;
            this.w = i3;
            bArr[i2] = (byte) ((c >> 6) | 192);
            this.w = i2 + 2;
            bArr[i3] = (byte) ((c & '?') | 128);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void k1(vm2 vm2Var) throws IOException {
        int iAppendUnquotedUTF8 = vm2Var.appendUnquotedUTF8(this.v, this.w);
        if (iAppendUnquotedUTF8 < 0) {
            V1(vm2Var.asUnquotedUTF8());
        } else {
            this.w += iAppendUnquotedUTF8;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void l1(String str) throws IOException {
        int length = str.length();
        char[] cArr = this.z;
        if (length > cArr.length) {
            u2(str, 0, length);
        } else {
            str.getChars(0, length, cArr, 0);
            m1(cArr, 0, length);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void m1(char[] cArr, int i, int i2) throws IOException {
        E1(cArr, i, i2);
        int i3 = i2 + i2 + i2;
        int i4 = this.w + i3;
        int i5 = this.x;
        if (i4 > i5) {
            if (i5 < i3) {
                i2(cArr, i, i2);
                return;
            }
            L1();
        }
        int i6 = i2 + i;
        while (i < i6) {
            do {
                char c = cArr[i];
                if (c > 127) {
                    i++;
                    if (c < 2048) {
                        byte[] bArr = this.v;
                        int i7 = this.w;
                        int i8 = i7 + 1;
                        this.w = i8;
                        bArr[i7] = (byte) ((c >> 6) | 192);
                        this.w = i7 + 2;
                        bArr[i8] = (byte) ((c & '?') | 128);
                    } else {
                        i = O1(c, cArr, i, i6);
                    }
                } else {
                    byte[] bArr2 = this.v;
                    int i9 = this.w;
                    this.w = i9 + 1;
                    bArr2[i9] = (byte) c;
                    i++;
                }
            } while (i < i6);
            return;
        }
    }

    @Override // defpackage.it0, com.fasterxml.jackson.core.JsonGenerator
    public void n1(vm2 vm2Var) throws IOException {
        I1("write a raw (unencoded) value");
        int iAppendUnquotedUTF8 = vm2Var.appendUnquotedUTF8(this.v, this.w);
        if (iAppendUnquotedUTF8 < 0) {
            V1(vm2Var.asUnquotedUTF8());
        } else {
            this.w += iAppendUnquotedUTF8;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void p1() throws IOException {
        I1("start an array");
        this.h = this.h.p();
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeStartArray(this);
            return;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        this.w = i + 1;
        bArr[i] = 91;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void q1(Object obj) throws IOException {
        I1("start an array");
        this.h = this.h.q(obj);
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeStartArray(this);
            return;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        this.w = i + 1;
        bArr[i] = 91;
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
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i2 = this.w;
        this.w = i2 + 1;
        bArr[i2] = 91;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void s1() throws IOException {
        I1("start an object");
        this.h = this.h.r();
        k52 k52Var = this.a;
        if (k52Var != null) {
            k52Var.writeStartObject(this);
            return;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        this.w = i + 1;
        bArr[i] = 123;
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
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        this.w = i + 1;
        bArr[i] = 123;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void u1(Object obj, int i) throws IOException {
        t1(obj);
    }

    public void u2(String str, int i, int i2) throws IOException {
        char c;
        F1(str, i, i2);
        char[] cArr = this.z;
        int length = cArr.length;
        if (i2 <= length) {
            str.getChars(i, i + i2, cArr, 0);
            m1(cArr, 0, i2);
            return;
        }
        int i3 = this.x;
        int iMin = Math.min(length, (i3 >> 2) + (i3 >> 4));
        int i4 = iMin * 3;
        while (i2 > 0) {
            int iMin2 = Math.min(iMin, i2);
            str.getChars(i, i + iMin2, cArr, 0);
            if (this.w + i4 > this.x) {
                L1();
            }
            if (iMin2 > 1 && (c = cArr[iMin2 - 1]) >= 55296 && c <= 56319) {
                iMin2--;
            }
            h2(cArr, 0, iMin2);
            i += iMin2;
            i2 -= iMin2;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void v1(vm2 vm2Var) throws IOException {
        I1("write a string");
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        int i2 = i + 1;
        this.w = i2;
        bArr[i] = this.u;
        int iAppendQuotedUTF8 = vm2Var.appendQuotedUTF8(bArr, i2);
        if (iAppendQuotedUTF8 < 0) {
            V1(vm2Var.asQuotedUTF8());
        } else {
            this.w += iAppendQuotedUTF8;
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr2 = this.v;
        int i3 = this.w;
        this.w = i3 + 1;
        bArr2[i3] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void w1(String str) throws IOException {
        I1("write a string");
        if (str == null) {
            a2();
            return;
        }
        int length = str.length();
        if (length > this.y) {
            q2(str, true);
            return;
        }
        if (this.w + length >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i = this.w;
        this.w = i + 1;
        bArr[i] = this.u;
        j2(str, 0, length);
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr2 = this.v;
        int i2 = this.w;
        this.w = i2 + 1;
        bArr2[i2] = this.u;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void x1(char[] cArr, int i, int i2) throws IOException {
        I1("write a string");
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr = this.v;
        int i3 = this.w;
        int i4 = i3 + 1;
        this.w = i4;
        bArr[i3] = this.u;
        if (i2 <= this.y) {
            if (i4 + i2 > this.x) {
                L1();
            }
            k2(cArr, i, i2);
        } else {
            r2(cArr, i, i2);
        }
        if (this.w >= this.x) {
            L1();
        }
        byte[] bArr2 = this.v;
        int i5 = this.w;
        this.w = i5 + 1;
        bArr2[i5] = this.u;
    }
}
