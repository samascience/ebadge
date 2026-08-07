package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class g83 extends dz1 {
    private static final int j0 = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int k0 = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int l0 = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.getMask();
    private static final int m0 = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int n0 = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int o0 = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int p0 = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int q0 = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    private static final int[] r0 = ex.j();
    protected static final int[] s0 = ex.h();
    protected jt1 Y;
    protected final mp Z;
    protected int[] a0;
    protected boolean b0;
    private int c0;
    protected int d0;
    protected int e0;
    protected int f0;
    protected InputStream g0;
    protected byte[] h0;
    protected boolean i0;

    public g83(oy0 oy0Var, int i, InputStream inputStream, jt1 jt1Var, mp mpVar, byte[] bArr, int i2, int i3, int i4, boolean z) {
        super(oy0Var, i);
        this.a0 = new int[16];
        this.g0 = inputStream;
        this.Y = jt1Var;
        this.Z = mpVar;
        this.h0 = bArr;
        this.r = i2;
        this.s = i3;
        this.v = i2 - i4;
        this.t = (-i2) + i4;
        this.i0 = z;
    }

    private final int B3() {
        int i = this.r;
        if (i + 4 >= this.s) {
            return C3(false);
        }
        byte[] bArr = this.h0;
        byte b = bArr[i];
        if (b == 58) {
            int i2 = i + 1;
            this.r = i2;
            byte b2 = bArr[i2];
            if (b2 > 32) {
                if (b2 == 47 || b2 == 35) {
                    return C3(true);
                }
                this.r = i + 2;
                return b2;
            }
            if (b2 == 32 || b2 == 9) {
                int i3 = i + 2;
                this.r = i3;
                byte b3 = bArr[i3];
                if (b3 > 32) {
                    if (b3 == 47 || b3 == 35) {
                        return C3(true);
                    }
                    this.r = i + 3;
                    return b3;
                }
            }
            return C3(true);
        }
        if (b == 32 || b == 9) {
            int i4 = i + 1;
            this.r = i4;
            b = bArr[i4];
        }
        if (b != 58) {
            return C3(false);
        }
        int i5 = this.r;
        int i6 = i5 + 1;
        this.r = i6;
        byte b4 = bArr[i6];
        if (b4 > 32) {
            if (b4 == 47 || b4 == 35) {
                return C3(true);
            }
            this.r = i5 + 2;
            return b4;
        }
        if (b4 == 32 || b4 == 9) {
            int i7 = i5 + 2;
            this.r = i7;
            byte b5 = bArr[i7];
            if (b5 > 32) {
                if (b5 == 47 || b5 == 35) {
                    return C3(true);
                }
                this.r = i5 + 3;
                return b5;
            }
        }
        return C3(true);
    }

    private final int C3(boolean z) {
        while (true) {
            if (this.r >= this.s && !b3()) {
                I1(" within/between " + this.z.m() + " entries", null);
                return -1;
            }
            byte[] bArr = this.h0;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            int i3 = bArr[i] & 255;
            if (i3 > 32) {
                if (i3 == 47) {
                    D3();
                } else if (i3 != 35 || !N3()) {
                    if (z) {
                        return i3;
                    }
                    if (i3 != 58) {
                        L1(i3, "was expecting a colon to separate field name and value");
                    }
                    z = true;
                }
            } else if (i3 != 32) {
                if (i3 == 10) {
                    this.u++;
                    this.v = i2;
                } else if (i3 == 13) {
                    A3();
                } else if (i3 != 9) {
                    O1(i3);
                }
            }
        }
    }

    private final void D3() {
        if ((this.a & p0) == 0) {
            L1(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.r >= this.s && !b3()) {
            I1(" in a comment", null);
        }
        byte[] bArr = this.h0;
        int i = this.r;
        this.r = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 47) {
            E3();
        } else if (i2 == 42) {
            z3();
        } else {
            L1(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void E3() {
        int[] iArrG = ex.g();
        while (true) {
            if (this.r >= this.s && !b3()) {
                return;
            }
            byte[] bArr = this.h0;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            int i3 = bArr[i] & 255;
            int i4 = iArrG[i3];
            if (i4 != 0) {
                if (i4 == 2) {
                    G3();
                } else if (i4 == 3) {
                    H3();
                } else if (i4 == 4) {
                    I3(i3);
                } else if (i4 == 10) {
                    this.u++;
                    this.v = i2;
                    return;
                } else if (i4 == 13) {
                    A3();
                    return;
                } else if (i4 != 42 && i4 < 0) {
                    t3(i3);
                }
            }
        }
    }

    private final void G3() {
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr = this.h0;
        int i = this.r;
        int i2 = i + 1;
        this.r = i2;
        byte b = bArr[i];
        if ((b & 192) != 128) {
            w3(b & 255, i2);
        }
    }

    private final void H3() {
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr = this.h0;
        int i = this.r;
        int i2 = i + 1;
        this.r = i2;
        byte b = bArr[i];
        if ((b & 192) != 128) {
            w3(b & 255, i2);
        }
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr2 = this.h0;
        int i3 = this.r;
        int i4 = i3 + 1;
        this.r = i4;
        byte b2 = bArr2[i3];
        if ((b2 & 192) != 128) {
            w3(b2 & 255, i4);
        }
    }

    private final void I3(int i) {
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr = this.h0;
        int i2 = this.r;
        int i3 = i2 + 1;
        this.r = i3;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            w3(b & 255, i3);
        }
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr2 = this.h0;
        int i4 = this.r;
        int i5 = i4 + 1;
        this.r = i5;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            w3(b2 & 255, i5);
        }
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr3 = this.h0;
        int i6 = this.r;
        int i7 = i6 + 1;
        this.r = i7;
        byte b3 = bArr3[i6];
        if ((b3 & 192) != 128) {
            w3(b3 & 255, i7);
        }
    }

    private final void J2(String str, int i, int i2) {
        if (Character.isJavaIdentifierPart((char) O2(i2))) {
            x3(str.substring(0, i));
        }
    }

    private final int J3() {
        while (true) {
            int i = this.r;
            if (i >= this.s) {
                return K3();
            }
            byte[] bArr = this.h0;
            int i2 = i + 1;
            this.r = i2;
            int i3 = bArr[i] & 255;
            if (i3 > 32) {
                if (i3 != 47 && i3 != 35) {
                    return i3;
                }
                this.r = i;
                return K3();
            }
            if (i3 != 32) {
                if (i3 == 10) {
                    this.u++;
                    this.v = i2;
                } else if (i3 == 13) {
                    A3();
                } else if (i3 != 9) {
                    O1(i3);
                }
            }
        }
    }

    private final void K2() {
        O3();
        if (!this.z.i()) {
            r2(93, '}');
        }
        this.z = this.z.o();
    }

    private final int K3() throws JsonParseException {
        while (true) {
            if (this.r >= this.s && !b3()) {
                throw n("Unexpected end-of-input within/between " + this.z.m() + " entries");
            }
            byte[] bArr = this.h0;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            int i3 = bArr[i] & 255;
            if (i3 > 32) {
                if (i3 == 47) {
                    D3();
                } else if (i3 != 35 || !N3()) {
                    return i3;
                }
            } else if (i3 != 32) {
                if (i3 == 10) {
                    this.u++;
                    this.v = i2;
                } else if (i3 == 13) {
                    A3();
                } else if (i3 != 9) {
                    O1(i3);
                }
            }
        }
    }

    private final void L2() {
        O3();
        if (!this.z.j()) {
            r2(125, ']');
        }
        this.z = this.z.o();
    }

    private final int L3() {
        if (this.r >= this.s && !b3()) {
            return g2();
        }
        byte[] bArr = this.h0;
        int i = this.r;
        int i2 = i + 1;
        this.r = i2;
        int i3 = bArr[i] & 255;
        if (i3 > 32) {
            if (i3 != 47 && i3 != 35) {
                return i3;
            }
            this.r = i;
            return M3();
        }
        if (i3 != 32) {
            if (i3 == 10) {
                this.u++;
                this.v = i2;
            } else if (i3 == 13) {
                A3();
            } else if (i3 != 9) {
                O1(i3);
            }
        }
        while (true) {
            int i4 = this.r;
            if (i4 >= this.s) {
                return M3();
            }
            byte[] bArr2 = this.h0;
            int i5 = i4 + 1;
            this.r = i5;
            int i6 = bArr2[i4] & 255;
            if (i6 > 32) {
                if (i6 != 47 && i6 != 35) {
                    return i6;
                }
                this.r = i4;
                return M3();
            }
            if (i6 != 32) {
                if (i6 == 10) {
                    this.u++;
                    this.v = i5;
                } else if (i6 == 13) {
                    A3();
                } else if (i6 != 9) {
                    O1(i6);
                }
            }
        }
    }

    private final JsonToken M2(int i) {
        if (i == 125) {
            L2();
            JsonToken jsonToken = JsonToken.END_OBJECT;
            this.d = jsonToken;
            return jsonToken;
        }
        K2();
        JsonToken jsonToken2 = JsonToken.END_ARRAY;
        this.d = jsonToken2;
        return jsonToken2;
    }

    private final int M3() {
        while (true) {
            if (this.r >= this.s && !b3()) {
                return g2();
            }
            byte[] bArr = this.h0;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            int i3 = bArr[i] & 255;
            if (i3 > 32) {
                if (i3 == 47) {
                    D3();
                } else if (i3 != 35 || !N3()) {
                    return i3;
                }
            } else if (i3 != 32) {
                if (i3 == 10) {
                    this.u++;
                    this.v = i2;
                } else if (i3 == 13) {
                    A3();
                } else if (i3 != 9) {
                    O1(i3);
                }
            }
        }
    }

    private final boolean N3() {
        if ((this.a & q0) == 0) {
            return false;
        }
        E3();
        return true;
    }

    private final void O3() {
        this.x = this.u;
        int i = this.r;
        this.w = this.t + ((long) i);
        this.y = i - this.v;
    }

    private final int P2(int i) {
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr = this.h0;
        int i2 = this.r;
        int i3 = i2 + 1;
        this.r = i3;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            w3(b & 255, i3);
        }
        return ((i & 31) << 6) | (b & 63);
    }

    private final void P3() {
        this.e0 = this.u;
        int i = this.r;
        this.d0 = i;
        this.f0 = i - this.v;
    }

    private final int Q2(int i) {
        if (this.r >= this.s) {
            c3();
        }
        int i2 = i & 15;
        byte[] bArr = this.h0;
        int i3 = this.r;
        int i4 = i3 + 1;
        this.r = i4;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            w3(b & 255, i4);
        }
        int i5 = (i2 << 6) | (b & 63);
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr2 = this.h0;
        int i6 = this.r;
        int i7 = i6 + 1;
        this.r = i7;
        byte b2 = bArr2[i6];
        if ((b2 & 192) != 128) {
            w3(b2 & 255, i7);
        }
        return (i5 << 6) | (b2 & 63);
    }

    private final int Q3() {
        int i;
        if ((this.r >= this.s && !b3()) || (i = this.h0[this.r] & 255) < 48 || i > 57) {
            return 48;
        }
        if ((this.a & k0) == 0) {
            T1("Leading zeroes not allowed");
        }
        this.r++;
        if (i == 48) {
            do {
                if (this.r >= this.s && !b3()) {
                    break;
                }
                byte[] bArr = this.h0;
                int i2 = this.r;
                i = bArr[i2] & 255;
                if (i < 48 || i > 57) {
                    return 48;
                }
                this.r = i2 + 1;
            } while (i == 48);
        }
        return i;
    }

    private final int R2(int i) {
        int i2 = i & 15;
        byte[] bArr = this.h0;
        int i3 = this.r;
        int i4 = i3 + 1;
        this.r = i4;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            w3(b & 255, i4);
        }
        int i5 = (i2 << 6) | (b & 63);
        byte[] bArr2 = this.h0;
        int i6 = this.r;
        int i7 = i6 + 1;
        this.r = i7;
        byte b2 = bArr2[i6];
        if ((b2 & 192) != 128) {
            w3(b2 & 255, i7);
        }
        return (i5 << 6) | (b2 & 63);
    }

    private final void R3(int i) {
        int i2 = this.r;
        int i3 = i2 + 1;
        this.r = i3;
        if (i != 9) {
            if (i == 10) {
                this.u++;
                this.v = i3;
            } else if (i == 13) {
                this.r = i2;
            } else if (i != 32) {
                K1(i);
            }
        }
    }

    private final int S2(int i) {
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr = this.h0;
        int i2 = this.r;
        int i3 = i2 + 1;
        this.r = i3;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            w3(b & 255, i3);
        }
        int i4 = ((i & 7) << 6) | (b & 63);
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr2 = this.h0;
        int i5 = this.r;
        int i6 = i5 + 1;
        this.r = i6;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            w3(b2 & 255, i6);
        }
        int i7 = (i4 << 6) | (b2 & 63);
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr3 = this.h0;
        int i8 = this.r;
        int i9 = i8 + 1;
        this.r = i9;
        byte b3 = bArr3[i8];
        if ((b3 & 192) != 128) {
            w3(b3 & 255, i9);
        }
        return ((i7 << 6) | (b3 & 63)) - 65536;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x0079  */
    /* JADX WARN: Code duplicated, block: B:29:0x0084  */
    /* JADX WARN: Code duplicated, block: B:31:0x0094  */
    /* JADX WARN: Code duplicated, block: B:34:0x009f  */
    /* JADX WARN: Code duplicated, block: B:36:0x00af  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b9 A[PHI: r5 r14
      0x00b9: PHI (r5v17 int) = (r5v16 int), (r5v28 int) binds: [B:28:0x0082, B:37:0x00b4] A[DONT_GENERATE, DONT_INLINE]
      0x00b9: PHI (r14v6 int) = (r14v5 int), (r14v15 int) binds: [B:28:0x0082, B:37:0x00b4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c9  */
    private final String S3(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = ((i << 2) - 4) + i2;
        if (i2 < 4) {
            int i13 = i - 1;
            i3 = iArr[i13];
            iArr[i13] = i3 << ((4 - i2) << 3);
        } else {
            i3 = 0;
        }
        char[] cArrM = this.G.m();
        int i14 = 0;
        int i15 = 0;
        while (i14 < i12) {
            int i16 = iArr[i14 >> 2] >> ((3 - (i14 & 3)) << 3);
            int i17 = i16 & 255;
            int i18 = i14 + 1;
            if (i17 > 127) {
                if ((i16 & 224) == 192) {
                    i4 = i16 & 31;
                } else {
                    if ((i16 & 240) == 224) {
                        i4 = i16 & 15;
                        i5 = 2;
                    } else if ((i16 & 248) == 240) {
                        i4 = i16 & 7;
                        i5 = 3;
                    } else {
                        u3(i17);
                        i4 = 1;
                    }
                    if (i18 + i5 > i12) {
                        I1(" in field name", JsonToken.FIELD_NAME);
                    }
                    i6 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                    i18 = i14 + 2;
                    if ((i6 & 192) != 128) {
                        v3(i6);
                    }
                    i7 = (i4 << 6) | (i6 & 63);
                    if (i5 > 1) {
                        i9 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                        i18 = i14 + 3;
                        if ((i9 & 192) != 128) {
                            v3(i9);
                        }
                        i10 = (i7 << 6) | (i9 & 63);
                        if (i5 > 2) {
                            i11 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                            i18 = i14 + 4;
                            if ((i11 & 192) != 128) {
                                v3(i11 & 255);
                            }
                            i7 = (i10 << 6) | (i11 & 63);
                            i17 = i7;
                            i8 = 2;
                        } else {
                            i17 = i10;
                            i8 = 2;
                        }
                    } else {
                        i17 = i7;
                        i8 = 2;
                    }
                    if (i5 > i8) {
                        int i19 = i17 - 65536;
                        if (i15 >= cArrM.length) {
                            cArrM = this.G.o();
                        }
                        cArrM[i15] = (char) ((i19 >> 10) + 55296);
                        i17 = (i19 & 1023) | 56320;
                        i15++;
                    }
                }
                i5 = 1;
                if (i18 + i5 > i12) {
                    I1(" in field name", JsonToken.FIELD_NAME);
                }
                i6 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                i18 = i14 + 2;
                if ((i6 & 192) != 128) {
                    v3(i6);
                }
                i7 = (i4 << 6) | (i6 & 63);
                if (i5 > 1) {
                    i9 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                    i18 = i14 + 3;
                    if ((i9 & 192) != 128) {
                        v3(i9);
                    }
                    i10 = (i7 << 6) | (i9 & 63);
                    if (i5 > 2) {
                        i11 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                        i18 = i14 + 4;
                        if ((i11 & 192) != 128) {
                            v3(i11 & 255);
                        }
                        i7 = (i10 << 6) | (i11 & 63);
                        i17 = i7;
                        i8 = 2;
                    } else {
                        i17 = i10;
                        i8 = 2;
                    }
                } else {
                    i17 = i7;
                    i8 = 2;
                }
                if (i5 > i8) {
                    int i110 = i17 - 65536;
                    if (i15 >= cArrM.length) {
                        cArrM = this.G.o();
                    }
                    cArrM[i15] = (char) ((i110 >> 10) + 55296);
                    i17 = (i110 & 1023) | 56320;
                    i15++;
                }
            }
            i14 = i18;
            if (i15 >= cArrM.length) {
                cArrM = this.G.o();
            }
            cArrM[i15] = (char) i17;
            i15++;
        }
        String str = new String(cArrM, 0, i15);
        if (i2 < 4) {
            iArr[i - 1] = i3;
        }
        return this.Z.p(str, iArr, i);
    }

    private final String T3(int i, int i2) {
        int iK3 = k3(i, i2);
        String strW = this.Z.w(iK3);
        if (strW != null) {
            return strW;
        }
        int[] iArr = this.a0;
        iArr[0] = iK3;
        return S3(iArr, 1, i2);
    }

    private final String U3(int i, int i2, int i3) {
        int iK3 = k3(i2, i3);
        String strX = this.Z.x(i, iK3);
        if (strX != null) {
            return strX;
        }
        int[] iArr = this.a0;
        iArr[0] = i;
        iArr[1] = iK3;
        return S3(iArr, 2, i3);
    }

    private final void V2(char[] cArr, int i) {
        int[] iArr = r0;
        byte[] bArr = this.h0;
        while (true) {
            int i2 = this.r;
            if (i2 >= this.s) {
                c3();
                i2 = this.r;
            }
            int i3 = 0;
            if (i >= cArr.length) {
                cArr = this.G.p();
                i = 0;
            }
            int iMin = Math.min(this.s, (cArr.length - i) + i2);
            while (true) {
                if (i2 >= iMin) {
                    this.r = i2;
                    break;
                }
                int i4 = i2 + 1;
                int iF2 = bArr[i2] & 255;
                int i5 = iArr[iF2];
                if (i5 != 0) {
                    this.r = i4;
                    if (iF2 != 34) {
                        if (i5 == 1) {
                            iF2 = f2();
                        } else if (i5 == 2) {
                            iF2 = P2(iF2);
                        } else if (i5 == 3) {
                            iF2 = this.s - i4 >= 2 ? R2(iF2) : Q2(iF2);
                        } else if (i5 == 4) {
                            int iS2 = S2(iF2);
                            int i6 = i + 1;
                            cArr[i] = (char) ((iS2 >> 10) | 55296);
                            if (i6 >= cArr.length) {
                                cArr = this.G.p();
                                i = 0;
                            } else {
                                i = i6;
                            }
                            iF2 = (iS2 & 1023) | 56320;
                        } else if (iF2 < 32) {
                            t2(iF2, "string value");
                        } else {
                            t3(iF2);
                        }
                        if (i >= cArr.length) {
                            cArr = this.G.p();
                        } else {
                            i3 = i;
                        }
                        i = i3 + 1;
                        cArr[i3] = (char) iF2;
                        break;
                    }
                    this.G.E(i);
                    return;
                }
                cArr[i] = (char) iF2;
                i2 = i4;
                i++;
            }
        }
    }

    private final String V3(int i, int i2, int i3, int i4) {
        int iK3 = k3(i3, i4);
        String strY = this.Z.y(i, i2, iK3);
        if (strY != null) {
            return strY;
        }
        int[] iArr = this.a0;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = k3(iK3, i4);
        return S3(iArr, 3, i4);
    }

    private final String W3(int[] iArr, int i, int i2, int i3) {
        if (i >= iArr.length) {
            iArr = dz1.D2(iArr, iArr.length);
            this.a0 = iArr;
        }
        int i4 = i + 1;
        iArr[i] = k3(i2, i3);
        String strZ = this.Z.z(iArr, i4);
        return strZ == null ? S3(iArr, i4, i3) : strZ;
    }

    private int X3() {
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr = this.h0;
        int i = this.r;
        this.r = i + 1;
        return bArr[i] & 255;
    }

    private final String c4(int i, int i2, int i3) {
        return Y3(this.a0, 0, i, i2, i3);
    }

    private final String d4(int i, int i2, int i3, int i4) {
        int[] iArr = this.a0;
        iArr[0] = i;
        return Y3(iArr, 1, i2, i3, i4);
    }

    private final String e4(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.a0;
        iArr[0] = i;
        iArr[1] = i2;
        return Y3(iArr, 2, i3, i4, i5);
    }

    private final void g3(String str, int i) {
        int i2;
        int i3;
        int length = str.length();
        do {
            if ((this.r >= this.s && !b3()) || this.h0[this.r] != str.charAt(i)) {
                x3(str.substring(0, i));
            }
            i2 = this.r + 1;
            this.r = i2;
            i++;
        } while (i < length);
        if ((i2 < this.s || b3()) && (i3 = this.h0[this.r] & 255) >= 48 && i3 != 93 && i3 != 125) {
            J2(str, i, i3);
        }
    }

    private final JsonToken i3() {
        this.I = false;
        JsonToken jsonToken = this.F;
        this.F = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.z = this.z.p(this.x, this.y);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.z = this.z.q(this.x, this.y);
        }
        this.d = jsonToken;
        return jsonToken;
    }

    private final JsonToken j3(int i) {
        if (i == 34) {
            this.b0 = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.d = jsonToken;
            return jsonToken;
        }
        if (i == 43) {
            if (f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                JsonToken jsonTokenQ3 = q3(false);
                this.d = jsonTokenQ3;
                return jsonTokenQ3;
            }
            JsonToken jsonTokenA3 = a3(i);
            this.d = jsonTokenA3;
            return jsonTokenA3;
        }
        if (i == 91) {
            this.z = this.z.p(this.x, this.y);
            JsonToken jsonToken2 = JsonToken.START_ARRAY;
            this.d = jsonToken2;
            return jsonToken2;
        }
        if (i == 102) {
            d3();
            JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
            this.d = jsonToken3;
            return jsonToken3;
        }
        if (i == 110) {
            e3();
            JsonToken jsonToken4 = JsonToken.VALUE_NULL;
            this.d = jsonToken4;
            return jsonToken4;
        }
        if (i == 116) {
            h3();
            JsonToken jsonToken5 = JsonToken.VALUE_TRUE;
            this.d = jsonToken5;
            return jsonToken5;
        }
        if (i == 123) {
            this.z = this.z.q(this.x, this.y);
            JsonToken jsonToken6 = JsonToken.START_OBJECT;
            this.d = jsonToken6;
            return jsonToken6;
        }
        if (i == 45) {
            JsonToken jsonTokenQ4 = q3(true);
            this.d = jsonTokenQ4;
            return jsonTokenQ4;
        }
        if (i == 46) {
            JsonToken jsonTokenN3 = n3(false, false);
            this.d = jsonTokenN3;
            return jsonTokenN3;
        }
        switch (i) {
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                JsonToken jsonTokenR3 = r3(i);
                this.d = jsonTokenR3;
                return jsonTokenR3;
            default:
                JsonToken jsonTokenA4 = a3(i);
                this.d = jsonTokenA4;
                return jsonTokenA4;
        }
    }

    private static final int k3(int i, int i2) {
        return i2 == 4 ? i : i | ((-1) << (i2 << 3));
    }

    private final JsonToken m3(char[] cArr, int i, int i2, boolean z, int i3) {
        int i4;
        boolean z2;
        int i5 = 0;
        if (i2 == 46) {
            if (i >= cArr.length) {
                cArr = this.G.p();
                i = 0;
            }
            cArr[i] = (char) i2;
            i++;
            i4 = 0;
            while (true) {
                if (this.r >= this.s && !b3()) {
                    z2 = true;
                    break;
                }
                byte[] bArr = this.h0;
                int i6 = this.r;
                this.r = i6 + 1;
                i2 = bArr[i6] & 255;
                if (i2 < 48 || i2 > 57) {
                    z2 = false;
                    break;
                }
                i4++;
                if (i >= cArr.length) {
                    cArr = this.G.p();
                    i = 0;
                }
                cArr[i] = (char) i2;
                i++;
            }
            if (i4 == 0 && !f1(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                M1(i2, "Decimal point not followed by a digit");
            }
        } else {
            i4 = 0;
            z2 = false;
        }
        if (i2 == 101 || i2 == 69) {
            if (i >= cArr.length) {
                cArr = this.G.p();
                i = 0;
            }
            int i7 = i + 1;
            cArr[i] = (char) i2;
            if (this.r >= this.s) {
                c3();
            }
            byte[] bArr2 = this.h0;
            int i8 = this.r;
            this.r = i8 + 1;
            int i9 = bArr2[i8] & 255;
            if (i9 == 45 || i9 == 43) {
                if (i7 >= cArr.length) {
                    cArr = this.G.p();
                    i7 = 0;
                }
                int i10 = i7 + 1;
                cArr[i7] = (char) i9;
                if (this.r >= this.s) {
                    c3();
                }
                byte[] bArr3 = this.h0;
                int i11 = this.r;
                this.r = i11 + 1;
                i9 = bArr3[i11] & 255;
                i7 = i10;
            }
            i2 = i9;
            int i12 = 0;
            while (true) {
                if (i2 >= 48 && i2 <= 57) {
                    i12++;
                    if (i7 >= cArr.length) {
                        cArr = this.G.p();
                        i7 = 0;
                    }
                    int i13 = i7 + 1;
                    cArr[i7] = (char) i2;
                    if (this.r >= this.s && !b3()) {
                        i5 = i12;
                        z2 = true;
                        i = i13;
                        break;
                    }
                    byte[] bArr4 = this.h0;
                    int i14 = this.r;
                    this.r = i14 + 1;
                    i2 = bArr4[i14] & 255;
                    i7 = i13;
                } else {
                    i5 = i12;
                    i = i7;
                    break;
                }
            }
            if (i5 == 0) {
                M1(i2, "Exponent indicator not followed by a digit");
            }
        }
        if (!z2) {
            this.r--;
            if (this.z.k()) {
                R3(i2);
            }
        }
        this.G.E(i);
        return H2(z, i3, i4, i5);
    }

    private final JsonToken p3(char[] cArr, int i, boolean z, int i2) {
        char[] cArrP = cArr;
        int i3 = i;
        int i4 = i2;
        while (true) {
            if (this.r >= this.s && !b3()) {
                this.G.E(i3);
                return I2(z, i4);
            }
            byte[] bArr = this.h0;
            int i5 = this.r;
            this.r = i5 + 1;
            int i6 = bArr[i5] & 255;
            if (i6 > 57 || i6 < 48) {
                if (i6 == 46 || i6 == 101 || i6 == 69) {
                    return m3(cArrP, i3, i6, z, i4);
                }
                this.r = i5;
                this.G.E(i3);
                if (this.z.k()) {
                    R3(this.h0[this.r] & 255);
                }
                return I2(z, i4);
            }
            if (i3 >= cArrP.length) {
                i3 = 0;
                cArrP = this.G.p();
            }
            cArrP[i3] = (char) i6;
            i4++;
            i3++;
        }
    }

    private final JsonToken q3(boolean z) {
        char[] cArrM = this.G.m();
        int i = 1;
        int i2 = 0;
        if (z) {
            cArrM[0] = '-';
            i2 = 1;
        }
        if (this.r >= this.s) {
            c3();
        }
        byte[] bArr = this.h0;
        int i3 = this.r;
        this.r = i3 + 1;
        int iQ3 = bArr[i3] & 255;
        if (iQ3 <= 48) {
            if (iQ3 != 48) {
                return iQ3 == 46 ? n3(z, true) : Y2(iQ3, z, true);
            }
            iQ3 = Q3();
        } else if (iQ3 > 57) {
            return Y2(iQ3, z, true);
        }
        int i4 = i2 + 1;
        cArrM[i2] = (char) iQ3;
        int iMin = Math.min(this.s, (this.r + cArrM.length) - i4);
        while (true) {
            int i5 = i4;
            int i6 = this.r;
            if (i6 >= iMin) {
                return p3(cArrM, i5, z, i);
            }
            byte[] bArr2 = this.h0;
            this.r = i6 + 1;
            int i7 = bArr2[i6] & 255;
            if (i7 < 48 || i7 > 57) {
                if (i7 == 46 || i7 == 101 || i7 == 69) {
                    return m3(cArrM, i5, i7, z, i);
                }
                this.r = i6;
                this.G.E(i5);
                if (this.z.k()) {
                    R3(i7);
                }
                return I2(z, i);
            }
            i++;
            i4 = i5 + 1;
            cArrM[i5] = (char) i7;
        }
    }

    private final void z3() {
        int[] iArrG = ex.g();
        while (true) {
            if (this.r >= this.s && !b3()) {
                break;
            }
            byte[] bArr = this.h0;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            int i3 = bArr[i] & 255;
            int i4 = iArrG[i3];
            if (i4 != 0) {
                if (i4 == 2) {
                    G3();
                } else if (i4 == 3) {
                    H3();
                } else if (i4 == 4) {
                    I3(i3);
                } else if (i4 == 10) {
                    this.u++;
                    this.v = i2;
                } else if (i4 == 13) {
                    A3();
                } else if (i4 == 42) {
                    if (i2 >= this.s && !b3()) {
                        break;
                    }
                    byte[] bArr2 = this.h0;
                    int i5 = this.r;
                    if (bArr2[i5] == 47) {
                        this.r = i5 + 1;
                        return;
                    }
                } else {
                    t3(i3);
                }
            }
        }
        I1(" in a comment", null);
    }

    protected final void A3() {
        if (this.r < this.s || b3()) {
            byte[] bArr = this.h0;
            int i = this.r;
            if (bArr[i] == 10) {
                this.r = i + 1;
            }
        }
        this.u++;
        this.v = this.r;
    }

    protected void F3() {
        this.b0 = false;
        int[] iArr = r0;
        byte[] bArr = this.h0;
        while (true) {
            int i = this.r;
            int i2 = this.s;
            if (i >= i2) {
                c3();
                i = this.r;
                i2 = this.s;
            }
            while (true) {
                if (i >= i2) {
                    this.r = i;
                    break;
                }
                int i3 = i + 1;
                int i4 = bArr[i] & 255;
                int i5 = iArr[i4];
                if (i5 != 0) {
                    this.r = i3;
                    if (i4 != 34) {
                        if (i5 == 1) {
                            f2();
                            break;
                        }
                        if (i5 == 2) {
                            G3();
                            break;
                        }
                        if (i5 == 3) {
                            H3();
                            break;
                        }
                        if (i5 == 4) {
                            I3(i4);
                            break;
                        } else if (i4 >= 32) {
                            t3(i4);
                            break;
                        } else {
                            t2(i4, "string value");
                            break;
                        }
                    }
                    return;
                }
                i = i3;
            }
        }
    }

    protected final byte[] N2(Base64Variant base64Variant) {
        zo zoVarJ2 = j2();
        while (true) {
            if (this.r >= this.s) {
                c3();
            }
            byte[] bArr = this.h0;
            int i = this.r;
            this.r = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 > 32) {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(i2);
                if (iDecodeBase64Char < 0) {
                    if (i2 == 34) {
                        return zoVarJ2.t0();
                    }
                    iDecodeBase64Char = e2(base64Variant, i2, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this.r >= this.s) {
                    c3();
                }
                byte[] bArr2 = this.h0;
                int i3 = this.r;
                this.r = i3 + 1;
                int i4 = bArr2[i3] & 255;
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(i4);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = e2(base64Variant, i4, 1);
                }
                int i5 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (this.r >= this.s) {
                    c3();
                }
                byte[] bArr3 = this.h0;
                int i6 = this.r;
                this.r = i6 + 1;
                int i7 = bArr3[i6] & 255;
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(i7);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (i7 == 34) {
                            zoVarJ2.u(i5 >> 4);
                            if (base64Variant.usesPadding()) {
                                this.r--;
                                k2(base64Variant);
                            }
                            return zoVarJ2.t0();
                        }
                        iDecodeBase64Char3 = e2(base64Variant, i7, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        if (this.r >= this.s) {
                            c3();
                        }
                        byte[] bArr4 = this.h0;
                        int i8 = this.r;
                        this.r = i8 + 1;
                        int i9 = bArr4[i8] & 255;
                        if (!base64Variant.usesPaddingChar(i9) && e2(base64Variant, i9, 3) != -2) {
                            throw F2(base64Variant, i9, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        zoVarJ2.u(i5 >> 4);
                    }
                }
                int i10 = (i5 << 6) | iDecodeBase64Char3;
                if (this.r >= this.s) {
                    c3();
                }
                byte[] bArr5 = this.h0;
                int i11 = this.r;
                this.r = i11 + 1;
                int i12 = bArr5[i11] & 255;
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(i12);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (i12 == 34) {
                            zoVarJ2.y(i10 >> 2);
                            if (base64Variant.usesPadding()) {
                                this.r--;
                                k2(base64Variant);
                            }
                            return zoVarJ2.t0();
                        }
                        iDecodeBase64Char4 = e2(base64Variant, i12, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        zoVarJ2.y(i10 >> 2);
                    }
                }
                zoVarJ2.w((i10 << 6) | iDecodeBase64Char4);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    /* JADX WARN: Code duplicated, block: B:22:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:27:0x005e  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    protected int O2(int i) {
        char c;
        int iX3;
        int i2;
        int iX4;
        int i3;
        int iX5;
        int i4 = i & 255;
        if (i4 <= 127) {
            return i4;
        }
        if ((i & 224) != 192) {
            if ((i & 240) == 224) {
                i4 = i & 15;
                c = 2;
            } else if ((i & 248) == 240) {
                i4 = i & 7;
                c = 3;
            } else {
                u3(i & 255);
            }
            iX3 = X3();
            if ((iX3 & 192) != 128) {
                v3(iX3 & 255);
            }
            i2 = (i4 << 6) | (iX3 & 63);
            if (c > 1) {
                return i2;
            }
            iX4 = X3();
            if ((iX4 & 192) != 128) {
                v3(iX4 & 255);
            }
            i3 = (i2 << 6) | (iX4 & 63);
            if (c > 2) {
                return i3;
            }
            iX5 = X3();
            if ((iX5 & 192) != 128) {
                v3(iX5 & 255);
            }
            return (i3 << 6) | (iX5 & 63);
        }
        i4 = i & 31;
        c = 1;
        iX3 = X3();
        if ((iX3 & 192) != 128) {
            v3(iX3 & 255);
        }
        i2 = (i4 << 6) | (iX3 & 63);
        if (c > 1) {
            return i2;
        }
        iX4 = X3();
        if ((iX4 & 192) != 128) {
            v3(iX4 & 255);
        }
        i3 = (i2 << 6) | (iX4 & 63);
        if (c > 2) {
            return i3;
        }
        iX5 = X3();
        if ((iX5 & 192) != 128) {
            v3(iX5 & 255);
        }
        return (i3 << 6) | (iX5 & 63);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public d41 Q0() {
        return dz1.X;
    }

    @Override // defpackage.ez1
    public int Q1(int i) {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.Q1(i);
        }
        int i2 = this.L;
        if ((i2 & 1) == 0) {
            if (i2 == 0) {
                return m2();
            }
            if ((i2 & 1) == 0) {
                A2();
            }
        }
        return this.M;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public String S0() {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return W2(jsonToken);
        }
        if (!this.b0) {
            return this.G.l();
        }
        this.b0 = false;
        return T2();
    }

    @Override // defpackage.ez1
    public String S1(String str) {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? y0() : super.S1(str);
        }
        if (!this.b0) {
            return this.G.l();
        }
        this.b0 = false;
        return T2();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public char[] T0() {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        if (iId != 5) {
            if (iId != 6) {
                if (iId != 7 && iId != 8) {
                    return this.d.asCharArray();
                }
            } else if (this.b0) {
                this.b0 = false;
                U2();
            }
            return this.G.u();
        }
        if (!this.I) {
            String strB = this.z.b();
            int length = strB.length();
            char[] cArr = this.H;
            if (cArr == null) {
                this.H = this.p.f(length);
            } else if (cArr.length < length) {
                this.H = new char[length];
            }
            strB.getChars(0, length, this.H, 0);
            this.I = true;
        }
        return this.H;
    }

    protected String T2() {
        int i = this.r;
        if (i >= this.s) {
            c3();
            i = this.r;
        }
        char[] cArrM = this.G.m();
        int[] iArr = r0;
        int iMin = Math.min(this.s, cArrM.length + i);
        byte[] bArr = this.h0;
        int i2 = 0;
        while (i < iMin) {
            int i3 = bArr[i] & 255;
            if (iArr[i3] != 0) {
                if (i3 != 34) {
                    break;
                }
                this.r = i + 1;
                return this.G.D(i2);
            }
            i++;
            cArrM[i2] = (char) i3;
            i2++;
        }
        this.r = i;
        V2(cArrM, i2);
        return this.G.l();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int U0() {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return 0;
        }
        int iId = jsonToken.id();
        if (iId == 5) {
            return this.z.b().length();
        }
        if (iId != 6) {
            if (iId != 7 && iId != 8) {
                return this.d.asCharArray().length;
            }
        } else if (this.b0) {
            this.b0 = false;
            U2();
        }
        return this.G.F();
    }

    protected void U2() {
        int i = this.r;
        if (i >= this.s) {
            c3();
            i = this.r;
        }
        char[] cArrM = this.G.m();
        int[] iArr = r0;
        int iMin = Math.min(this.s, cArrM.length + i);
        byte[] bArr = this.h0;
        int i2 = 0;
        while (i < iMin) {
            int i3 = bArr[i] & 255;
            if (iArr[i3] != 0) {
                if (i3 != 34) {
                    break;
                }
                this.r = i + 1;
                this.G.E(i2);
                return;
            }
            i++;
            cArrM[i2] = (char) i3;
            i2++;
        }
        this.r = i;
        V2(cArrM, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (r0 != 8) goto L16;
     */
    @Override // com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int V0() {
        /*
            r3 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r3.d
            r1 = 0
            if (r0 == 0) goto L24
            int r0 = r0.id()
            r2 = 6
            if (r0 == r2) goto L14
            r2 = 7
            if (r0 == r2) goto L1d
            r2 = 8
            if (r0 == r2) goto L1d
            goto L24
        L14:
            boolean r0 = r3.b0
            if (r0 == 0) goto L1d
            r3.b0 = r1
            r3.U2()
        L1d:
            w13 r0 = r3.G
            int r0 = r0.v()
            return r0
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g83.V0():int");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation W0() {
        if (this.d != JsonToken.FIELD_NAME) {
            return new JsonLocation(c2(), this.w - 1, -1L, this.x, this.y);
        }
        return new JsonLocation(c2(), this.t + ((long) (this.d0 - 1)), -1L, this.e0, this.f0);
    }

    protected final String W2(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        if (iId != 5) {
            return (iId == 6 || iId == 7 || iId == 8) ? this.G.l() : jsonToken.asString();
        }
        return this.z.b();
    }

    protected JsonToken X2() {
        char[] cArrM = this.G.m();
        int[] iArr = r0;
        byte[] bArr = this.h0;
        int i = 0;
        while (true) {
            if (this.r >= this.s) {
                c3();
            }
            if (i >= cArrM.length) {
                cArrM = this.G.p();
                i = 0;
            }
            int i2 = this.s;
            int length = this.r + (cArrM.length - i);
            if (length < i2) {
                i2 = length;
            }
            while (true) {
                int i3 = this.r;
                if (i3 >= i2) {
                    break;
                }
                int i4 = i3 + 1;
                this.r = i4;
                int iF2 = bArr[i3] & 255;
                if (iF2 != 39) {
                    int i5 = iArr[iF2];
                    if (i5 != 0 && iF2 != 34) {
                        if (i5 == 1) {
                            iF2 = f2();
                        } else if (i5 == 2) {
                            iF2 = P2(iF2);
                        } else if (i5 == 3) {
                            iF2 = this.s - i4 >= 2 ? R2(iF2) : Q2(iF2);
                        } else if (i5 != 4) {
                            if (iF2 < 32) {
                                t2(iF2, "string value");
                            }
                            t3(iF2);
                        } else {
                            int iS2 = S2(iF2);
                            int i6 = i + 1;
                            cArrM[i] = (char) ((iS2 >> 10) | 55296);
                            if (i6 >= cArrM.length) {
                                cArrM = this.G.p();
                                i = 0;
                            } else {
                                i = i6;
                            }
                            iF2 = 56320 | (iS2 & 1023);
                        }
                        if (i >= cArrM.length) {
                            cArrM = this.G.p();
                            i = 0;
                        }
                        cArrM[i] = (char) iF2;
                        i++;
                        break;
                    }
                    cArrM[i] = (char) iF2;
                    i++;
                } else {
                    this.G.E(i);
                    return JsonToken.VALUE_STRING;
                }
            }
        }
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public int Y0() {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.Q1(0);
        }
        int i = this.L;
        if ((i & 1) == 0) {
            if (i == 0) {
                return m2();
            }
            if ((i & 1) == 0) {
                A2();
            }
        }
        return this.M;
    }

    protected JsonToken Y2(int i, boolean z, boolean z2) throws JsonParseException {
        String str;
        while (i == 73) {
            if (this.r >= this.s && !b3()) {
                J1(JsonToken.VALUE_NUMBER_FLOAT);
            }
            byte[] bArr = this.h0;
            int i2 = this.r;
            this.r = i2 + 1;
            i = bArr[i2];
            if (i != 78) {
                if (i != 110) {
                    break;
                }
                str = z ? "-Infinity" : "+Infinity";
            } else {
                str = z ? "-INF" : "+INF";
            }
            f3(str, 3);
            if ((this.a & l0) != 0) {
                return G2(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            E1("Non-standard token '%s': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow", str);
        }
        if (!f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) && z2 && !z) {
            M1(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        }
        M1(i, z ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
        return null;
    }

    protected final String Y3(int[] iArr, int i, int i2, int i3, int i4) {
        int[] iArr2 = s0;
        while (true) {
            if (iArr2[i3] != 0) {
                if (i3 == 34) {
                    break;
                }
                if (i3 != 92) {
                    t2(i3, "name");
                } else {
                    i3 = f2();
                }
                if (i3 > 127) {
                    int i5 = 0;
                    if (i4 >= 4) {
                        if (i >= iArr.length) {
                            iArr = dz1.D2(iArr, iArr.length);
                            this.a0 = iArr;
                        }
                        iArr[i] = i2;
                        i++;
                        i2 = 0;
                        i4 = 0;
                    }
                    if (i3 < 2048) {
                        i2 = (i2 << 8) | (i3 >> 6) | 192;
                        i4++;
                    } else {
                        int i6 = (i2 << 8) | (i3 >> 12) | 224;
                        int i7 = i4 + 1;
                        if (i7 >= 4) {
                            if (i >= iArr.length) {
                                iArr = dz1.D2(iArr, iArr.length);
                                this.a0 = iArr;
                            }
                            iArr[i] = i6;
                            i++;
                            i7 = 0;
                        } else {
                            i5 = i6;
                        }
                        i2 = (i5 << 8) | ((i3 >> 6) & 63) | 128;
                        i4 = i7 + 1;
                    }
                    i3 = (i3 & 63) | 128;
                }
            }
            if (i4 < 4) {
                i4++;
                i2 = (i2 << 8) | i3;
            } else {
                if (i >= iArr.length) {
                    iArr = dz1.D2(iArr, iArr.length);
                    this.a0 = iArr;
                }
                iArr[i] = i2;
                i2 = i3;
                i++;
                i4 = 1;
            }
            if (this.r >= this.s && !b3()) {
                I1(" in field name", JsonToken.FIELD_NAME);
            }
            byte[] bArr = this.h0;
            int i8 = this.r;
            this.r = i8 + 1;
            i3 = bArr[i8] & 255;
        }
        if (i4 > 0) {
            if (i >= iArr.length) {
                iArr = dz1.D2(iArr, iArr.length);
                this.a0 = iArr;
            }
            iArr[i] = k3(i2, i4);
            i++;
        }
        String strZ = this.Z.z(iArr, i);
        return strZ == null ? S3(iArr, i, i4) : strZ;
    }

    protected String Z2(int i) {
        if (i == 39 && (this.a & n0) != 0) {
            return l3();
        }
        if ((this.a & o0) == 0) {
            L1((char) O2(i), "was expecting double-quote to start field name");
        }
        int[] iArrK = ex.k();
        if (iArrK[i] != 0) {
            L1(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] iArrD2 = this.a0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 < 4) {
                i2++;
                i4 = i | (i4 << 8);
            } else {
                if (i3 >= iArrD2.length) {
                    iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                    this.a0 = iArrD2;
                }
                iArrD2[i3] = i4;
                i4 = i;
                i3++;
                i2 = 1;
            }
            if (this.r >= this.s && !b3()) {
                I1(" in field name", JsonToken.FIELD_NAME);
            }
            byte[] bArr = this.h0;
            int i5 = this.r;
            i = bArr[i5] & 255;
            if (iArrK[i] != 0) {
                break;
            }
            this.r = i5 + 1;
        }
        if (i2 > 0) {
            if (i3 >= iArrD2.length) {
                iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                this.a0 = iArrD2;
            }
            iArrD2[i3] = i4;
            i3++;
        }
        String strZ = this.Z.z(iArrD2, i3);
        return strZ == null ? S3(iArrD2, i3, i2) : strZ;
    }

    protected final String Z3(int i, int i2, int i3) {
        int[] iArr = this.a0;
        iArr[0] = this.c0;
        iArr[1] = i2;
        iArr[2] = i3;
        byte[] bArr = this.h0;
        int[] iArr2 = s0;
        int i4 = i;
        int i5 = 3;
        while (true) {
            int i6 = this.r;
            if (i6 + 4 > this.s) {
                return Y3(this.a0, i5, 0, i4, 0);
            }
            int i7 = i6 + 1;
            this.r = i7;
            int i8 = bArr[i6] & 255;
            if (iArr2[i8] != 0) {
                return i8 == 34 ? W3(this.a0, i5, i4, 1) : Y3(this.a0, i5, i4, i8, 1);
            }
            int i9 = (i4 << 8) | i8;
            int i10 = i6 + 2;
            this.r = i10;
            int i11 = bArr[i7] & 255;
            if (iArr2[i11] != 0) {
                return i11 == 34 ? W3(this.a0, i5, i9, 2) : Y3(this.a0, i5, i9, i11, 2);
            }
            int i12 = (i9 << 8) | i11;
            int i13 = i6 + 3;
            this.r = i13;
            int i14 = bArr[i10] & 255;
            if (iArr2[i14] != 0) {
                return i14 == 34 ? W3(this.a0, i5, i12, 3) : Y3(this.a0, i5, i12, i14, 3);
            }
            int i15 = (i12 << 8) | i14;
            this.r = i6 + 4;
            int i16 = bArr[i13] & 255;
            if (iArr2[i16] != 0) {
                return i16 == 34 ? W3(this.a0, i5, i15, 4) : Y3(this.a0, i5, i15, i16, 4);
            }
            int[] iArr3 = this.a0;
            if (i5 >= iArr3.length) {
                this.a0 = dz1.D2(iArr3, i5);
            }
            this.a0[i5] = i15;
            i4 = i16;
            i5++;
        }
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public String a1() {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? y0() : super.S1(null);
        }
        if (!this.b0) {
            return this.G.l();
        }
        this.b0 = false;
        return T2();
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00a1  */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if (r4 != 44) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        if (r3.z.i() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r3.z.k() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        if ((r3.a & defpackage.g83.m0) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r3.r--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        return com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.fasterxml.jackson.core.JsonToken a3(int r4) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g83.a3(int):com.fasterxml.jackson.core.JsonToken");
    }

    protected final String a4(int i) {
        byte[] bArr = this.h0;
        int[] iArr = s0;
        int i2 = this.r;
        int i3 = i2 + 1;
        this.r = i3;
        int i4 = bArr[i2] & 255;
        if (iArr[i4] != 0) {
            return i4 == 34 ? U3(this.c0, i, 1) : d4(this.c0, i, i4, 1);
        }
        int i5 = (i << 8) | i4;
        int i6 = i2 + 2;
        this.r = i6;
        int i7 = bArr[i3] & 255;
        if (iArr[i7] != 0) {
            return i7 == 34 ? U3(this.c0, i5, 2) : d4(this.c0, i5, i7, 2);
        }
        int i8 = (i5 << 8) | i7;
        int i9 = i2 + 3;
        this.r = i9;
        int i10 = bArr[i6] & 255;
        if (iArr[i10] != 0) {
            return i10 == 34 ? U3(this.c0, i8, 3) : d4(this.c0, i8, i10, 3);
        }
        int i11 = (i8 << 8) | i10;
        this.r = i2 + 4;
        int i12 = bArr[i9] & 255;
        if (iArr[i12] != 0) {
            return i12 == 34 ? U3(this.c0, i11, 4) : d4(this.c0, i11, i12, 4);
        }
        return b4(i12, i11);
    }

    @Override // defpackage.dz1
    protected void b2() throws IOException {
        if (this.g0 != null) {
            if (this.p.n() || f1(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.g0.close();
            }
            this.g0 = null;
        }
    }

    protected final boolean b3() throws IOException {
        byte[] bArr;
        int length;
        InputStream inputStream = this.g0;
        if (inputStream == null || (length = (bArr = this.h0).length) == 0) {
            return false;
        }
        int i = inputStream.read(bArr, 0, length);
        if (i > 0) {
            int i2 = this.s;
            this.t += (long) i2;
            this.v -= i2;
            this.d0 -= i2;
            this.r = 0;
            this.s = i;
            return true;
        }
        b2();
        if (i == 0) {
            throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.h0.length + " bytes");
        }
        return false;
    }

    protected final String b4(int i, int i2) {
        byte[] bArr = this.h0;
        int[] iArr = s0;
        int i3 = this.r;
        int i4 = i3 + 1;
        this.r = i4;
        int i5 = bArr[i3] & 255;
        if (iArr[i5] != 0) {
            return i5 == 34 ? V3(this.c0, i2, i, 1) : e4(this.c0, i2, i, i5, 1);
        }
        int i6 = (i << 8) | i5;
        int i7 = i3 + 2;
        this.r = i7;
        int i8 = bArr[i4] & 255;
        if (iArr[i8] != 0) {
            return i8 == 34 ? V3(this.c0, i2, i6, 2) : e4(this.c0, i2, i6, i8, 2);
        }
        int i9 = (i6 << 8) | i8;
        int i10 = i3 + 3;
        this.r = i10;
        int i11 = bArr[i7] & 255;
        if (iArr[i11] != 0) {
            return i11 == 34 ? V3(this.c0, i2, i9, 3) : e4(this.c0, i2, i9, i11, 3);
        }
        int i12 = (i9 << 8) | i11;
        this.r = i3 + 4;
        int i13 = bArr[i10] & 255;
        if (iArr[i13] != 0) {
            return i13 == 34 ? V3(this.c0, i2, i12, 4) : e4(this.c0, i2, i12, i13, 4);
        }
        return Z3(i13, i2, i12);
    }

    protected void c3() {
        if (b3()) {
            return;
        }
        H1();
    }

    protected final void d3() {
        int i;
        int i2 = this.r;
        if (i2 + 4 < this.s) {
            byte[] bArr = this.h0;
            int i3 = i2 + 1;
            if (bArr[i2] == 97) {
                int i4 = i2 + 2;
                if (bArr[i3] == 108) {
                    int i5 = i2 + 3;
                    if (bArr[i4] == 115) {
                        int i6 = i2 + 4;
                        if (bArr[i5] == 101 && ((i = bArr[i6] & 255) < 48 || i == 93 || i == 125)) {
                            this.r = i6;
                            return;
                        }
                    }
                }
            }
        }
        g3("false", 1);
    }

    protected final void e3() {
        int i;
        int i2 = this.r;
        if (i2 + 3 < this.s) {
            byte[] bArr = this.h0;
            int i3 = i2 + 1;
            if (bArr[i2] == 117) {
                int i4 = i2 + 2;
                if (bArr[i3] == 108) {
                    int i5 = i2 + 3;
                    if (bArr[i4] == 108 && ((i = bArr[i5] & 255) < 48 || i == 93 || i == 125)) {
                        this.r = i5;
                        return;
                    }
                }
            }
        }
        g3("null", 1);
    }

    @Override // defpackage.dz1
    protected char f2() {
        if (this.r >= this.s && !b3()) {
            I1(" in character escape sequence", JsonToken.VALUE_STRING);
        }
        byte[] bArr = this.h0;
        int i = this.r;
        this.r = i + 1;
        byte b = bArr[i];
        if (b == 34 || b == 47 || b == 92) {
            return (char) b;
        }
        if (b == 98) {
            return '\b';
        }
        if (b == 102) {
            return '\f';
        }
        if (b == 110) {
            return '\n';
        }
        if (b == 114) {
            return '\r';
        }
        if (b == 116) {
            return '\t';
        }
        if (b != 117) {
            return l2((char) O2(b));
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.r >= this.s && !b3()) {
                I1(" in character escape sequence", JsonToken.VALUE_STRING);
            }
            byte[] bArr2 = this.h0;
            int i4 = this.r;
            this.r = i4 + 1;
            byte b2 = bArr2[i4];
            int iB = ex.b(b2);
            if (iB < 0) {
                L1(b2 & 255, "expected a hex-digit for character escape sequence");
            }
            i2 = (i2 << 4) | iB;
        }
        return (char) i2;
    }

    protected final void f3(String str, int i) {
        int i2;
        int length = str.length();
        if (this.r + length >= this.s) {
            g3(str, i);
            return;
        }
        do {
            if (this.h0[this.r] != str.charAt(i)) {
                x3(str.substring(0, i));
            }
            i2 = this.r + 1;
            this.r = i2;
            i++;
        } while (i < length);
        int i3 = this.h0[i2] & 255;
        if (i3 < 48 || i3 == 93 || i3 == 125) {
            return;
        }
        J2(str, i, i3);
    }

    protected String f4() {
        if (this.r >= this.s && !b3()) {
            I1(": was expecting closing '\"' for name", JsonToken.FIELD_NAME);
        }
        byte[] bArr = this.h0;
        int i = this.r;
        this.r = i + 1;
        int i2 = bArr[i] & 255;
        return i2 == 34 ? Constants.STR_EMPTY : Y3(this.a0, 0, 0, i2, 0);
    }

    protected final void h3() {
        int i;
        int i2 = this.r;
        if (i2 + 3 < this.s) {
            byte[] bArr = this.h0;
            int i3 = i2 + 1;
            if (bArr[i2] == 114) {
                int i4 = i2 + 2;
                if (bArr[i3] == 117) {
                    int i5 = i2 + 3;
                    if (bArr[i4] == 101 && ((i = bArr[i5] & 255) < 48 || i == 93 || i == 125)) {
                        this.r = i5;
                        return;
                    }
                }
            }
        }
        g3("true", 1);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte[] j0(Base64Variant base64Variant) throws JsonParseException {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING && (jsonToken != JsonToken.VALUE_EMBEDDED_OBJECT || this.K == null)) {
            D1("Current token (" + this.d + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.b0) {
            try {
                this.K = N2(base64Variant);
                this.b0 = false;
            } catch (IllegalArgumentException e) {
                throw n("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e.getMessage());
            }
        } else if (this.K == null) {
            zo zoVarJ2 = j2();
            x1(S0(), zoVarJ2, base64Variant);
            this.K = zoVarJ2.t0();
        }
        return this.K;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String l1() throws JsonParseException {
        JsonToken jsonTokenQ3;
        this.L = 0;
        JsonToken jsonToken = this.d;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            i3();
            return null;
        }
        if (this.b0) {
            F3();
        }
        int iL3 = L3();
        if (iL3 < 0) {
            close();
            this.d = null;
            return null;
        }
        this.K = null;
        if (iL3 == 93) {
            K2();
            this.d = JsonToken.END_ARRAY;
            return null;
        }
        if (iL3 == 125) {
            L2();
            this.d = JsonToken.END_OBJECT;
            return null;
        }
        if (this.z.s()) {
            if (iL3 != 44) {
                L1(iL3, "was expecting comma to separate " + this.z.m() + " entries");
            }
            iL3 = J3();
            if ((this.a & j0) != 0 && (iL3 == 93 || iL3 == 125)) {
                M2(iL3);
                return null;
            }
        }
        if (!this.z.j()) {
            O3();
            j3(iL3);
            return null;
        }
        P3();
        String strO3 = o3(iL3);
        this.z.w(strO3);
        this.d = jsonToken2;
        int iB3 = B3();
        O3();
        if (iB3 == 34) {
            this.b0 = true;
            this.F = JsonToken.VALUE_STRING;
            return strO3;
        }
        if (iB3 == 43) {
            jsonTokenQ3 = f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? q3(false) : a3(iB3);
        } else if (iB3 == 91) {
            jsonTokenQ3 = JsonToken.START_ARRAY;
        } else if (iB3 == 102) {
            d3();
            jsonTokenQ3 = JsonToken.VALUE_FALSE;
        } else if (iB3 == 110) {
            e3();
            jsonTokenQ3 = JsonToken.VALUE_NULL;
        } else if (iB3 == 116) {
            h3();
            jsonTokenQ3 = JsonToken.VALUE_TRUE;
        } else if (iB3 == 123) {
            jsonTokenQ3 = JsonToken.START_OBJECT;
        } else if (iB3 == 45) {
            jsonTokenQ3 = q3(true);
        } else if (iB3 != 46) {
            switch (iB3) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonTokenQ3 = r3(iB3);
                    break;
                default:
                    jsonTokenQ3 = a3(iB3);
                    break;
            }
        } else {
            jsonTokenQ3 = n3(false, false);
        }
        this.F = jsonTokenQ3;
        return strO3;
    }

    protected String l3() {
        if (this.r >= this.s && !b3()) {
            I1(": was expecting closing ''' for field name", JsonToken.FIELD_NAME);
        }
        byte[] bArr = this.h0;
        int i = this.r;
        this.r = i + 1;
        int iF2 = bArr[i] & 255;
        if (iF2 == 39) {
            return Constants.STR_EMPTY;
        }
        int[] iArrD2 = this.a0;
        int[] iArr = s0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (iF2 != 39) {
            if (iArr[iF2] != 0 && iF2 != 34) {
                if (iF2 != 92) {
                    t2(iF2, "name");
                } else {
                    iF2 = f2();
                }
                if (iF2 > 127) {
                    if (i2 >= 4) {
                        if (i3 >= iArrD2.length) {
                            iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                            this.a0 = iArrD2;
                        }
                        iArrD2[i3] = i4;
                        i4 = 0;
                        i3++;
                        i2 = 0;
                    }
                    if (iF2 < 2048) {
                        i4 = (i4 << 8) | (iF2 >> 6) | 192;
                        i2++;
                    } else {
                        int i5 = (i4 << 8) | (iF2 >> 12) | 224;
                        int i6 = i2 + 1;
                        if (i6 >= 4) {
                            if (i3 >= iArrD2.length) {
                                iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                                this.a0 = iArrD2;
                            }
                            iArrD2[i3] = i5;
                            i5 = 0;
                            i3++;
                            i6 = 0;
                        }
                        i4 = (i5 << 8) | ((iF2 >> 6) & 63) | 128;
                        i2 = i6 + 1;
                    }
                    iF2 = (iF2 & 63) | 128;
                }
            }
            if (i2 < 4) {
                i2++;
                i4 = iF2 | (i4 << 8);
            } else {
                if (i3 >= iArrD2.length) {
                    iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                    this.a0 = iArrD2;
                }
                iArrD2[i3] = i4;
                i4 = iF2;
                i3++;
                i2 = 1;
            }
            if (this.r >= this.s && !b3()) {
                I1(" in field name", JsonToken.FIELD_NAME);
            }
            byte[] bArr2 = this.h0;
            int i7 = this.r;
            this.r = i7 + 1;
            iF2 = bArr2[i7] & 255;
        }
        if (i2 > 0) {
            if (i3 >= iArrD2.length) {
                iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                this.a0 = iArrD2;
            }
            iArrD2[i3] = k3(i4, i2);
            i3++;
        }
        String strZ = this.Z.z(iArrD2, i3);
        return strZ == null ? S3(iArrD2, i3, i2) : strZ;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String m1() {
        if (this.d != JsonToken.FIELD_NAME) {
            if (n1() == JsonToken.VALUE_STRING) {
                return S0();
            }
            return null;
        }
        this.I = false;
        JsonToken jsonToken = this.F;
        this.F = null;
        this.d = jsonToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (!this.b0) {
                return this.G.l();
            }
            this.b0 = false;
            return T2();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this.z = this.z.p(this.x, this.y);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.z = this.z.q(this.x, this.y);
        }
        return null;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public JsonToken n1() throws JsonParseException {
        JsonToken jsonTokenQ3;
        JsonToken jsonToken = this.d;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            return i3();
        }
        this.L = 0;
        if (this.b0) {
            F3();
        }
        int iL3 = L3();
        if (iL3 < 0) {
            close();
            this.d = null;
            return null;
        }
        this.K = null;
        if (iL3 == 93) {
            K2();
            JsonToken jsonToken3 = JsonToken.END_ARRAY;
            this.d = jsonToken3;
            return jsonToken3;
        }
        if (iL3 == 125) {
            L2();
            JsonToken jsonToken4 = JsonToken.END_OBJECT;
            this.d = jsonToken4;
            return jsonToken4;
        }
        if (this.z.s()) {
            if (iL3 != 44) {
                L1(iL3, "was expecting comma to separate " + this.z.m() + " entries");
            }
            iL3 = J3();
            if ((this.a & j0) != 0 && (iL3 == 93 || iL3 == 125)) {
                return M2(iL3);
            }
        }
        if (!this.z.j()) {
            O3();
            return j3(iL3);
        }
        P3();
        this.z.w(o3(iL3));
        this.d = jsonToken2;
        int iB3 = B3();
        O3();
        if (iB3 == 34) {
            this.b0 = true;
            this.F = JsonToken.VALUE_STRING;
            return this.d;
        }
        if (iB3 == 43) {
            jsonTokenQ3 = f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? q3(false) : a3(iB3);
        } else if (iB3 == 91) {
            jsonTokenQ3 = JsonToken.START_ARRAY;
        } else if (iB3 == 102) {
            d3();
            jsonTokenQ3 = JsonToken.VALUE_FALSE;
        } else if (iB3 == 110) {
            e3();
            jsonTokenQ3 = JsonToken.VALUE_NULL;
        } else if (iB3 == 116) {
            h3();
            jsonTokenQ3 = JsonToken.VALUE_TRUE;
        } else if (iB3 == 123) {
            jsonTokenQ3 = JsonToken.START_OBJECT;
        } else if (iB3 == 45) {
            jsonTokenQ3 = q3(true);
        } else if (iB3 != 46) {
            switch (iB3) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonTokenQ3 = r3(iB3);
                    break;
                default:
                    jsonTokenQ3 = a3(iB3);
                    break;
            }
        } else {
            jsonTokenQ3 = n3(false, false);
        }
        this.F = jsonTokenQ3;
        return this.d;
    }

    protected final JsonToken n3(boolean z, boolean z2) {
        if (!f1(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return a3(46);
        }
        char[] cArrM = this.G.m();
        int i = 0;
        if (z) {
            cArrM[0] = '-';
            i = 1;
        }
        return m3(cArrM, i, 46, z, 0);
    }

    protected final String o3(int i) {
        if (i != 34) {
            return Z2(i);
        }
        int i2 = this.r;
        if (i2 + 13 > this.s) {
            return f4();
        }
        byte[] bArr = this.h0;
        int[] iArr = s0;
        int i3 = i2 + 1;
        this.r = i3;
        int i4 = bArr[i2] & 255;
        if (iArr[i4] != 0) {
            return i4 == 34 ? Constants.STR_EMPTY : c4(0, i4, 0);
        }
        int i5 = i2 + 2;
        this.r = i5;
        int i6 = bArr[i3] & 255;
        if (iArr[i6] != 0) {
            return i6 == 34 ? T3(i4, 1) : c4(i4, i6, 1);
        }
        int i7 = i6 | (i4 << 8);
        int i8 = i2 + 3;
        this.r = i8;
        int i9 = bArr[i5] & 255;
        if (iArr[i9] != 0) {
            return i9 == 34 ? T3(i7, 2) : c4(i7, i9, 2);
        }
        int i10 = (i7 << 8) | i9;
        int i11 = i2 + 4;
        this.r = i11;
        int i12 = bArr[i8] & 255;
        if (iArr[i12] != 0) {
            return i12 == 34 ? T3(i10, 3) : c4(i10, i12, 3);
        }
        int i13 = (i10 << 8) | i12;
        this.r = i2 + 5;
        int i14 = bArr[i11] & 255;
        if (iArr[i14] != 0) {
            return i14 == 34 ? T3(i13, 4) : c4(i13, i14, 4);
        }
        this.c0 = i13;
        return a4(i14);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int q1(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        if (!this.b0 || this.d != JsonToken.VALUE_STRING) {
            byte[] bArrJ0 = j0(base64Variant);
            outputStream.write(bArrJ0);
            return bArrJ0.length;
        }
        byte[] bArrD = this.p.d();
        try {
            return s3(base64Variant, outputStream, bArrD);
        } finally {
            this.p.o(bArrD);
        }
    }

    @Override // defpackage.dz1
    protected void q2() {
        byte[] bArr;
        byte[] bArr2;
        super.q2();
        this.Z.G();
        if (!this.i0 || (bArr = this.h0) == null || bArr == (bArr2 = ez1.f)) {
            return;
        }
        this.h0 = bArr2;
        this.p.r(bArr);
    }

    protected JsonToken r3(int i) {
        char[] cArrM = this.G.m();
        if (i == 48) {
            i = Q3();
        }
        cArrM[0] = (char) i;
        int iMin = Math.min(this.s, (this.r + cArrM.length) - 1);
        int i2 = 1;
        int i3 = 1;
        while (true) {
            int i4 = this.r;
            if (i4 >= iMin) {
                return p3(cArrM, i2, false, i3);
            }
            byte[] bArr = this.h0;
            this.r = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (i5 < 48 || i5 > 57) {
                if (i5 == 46 || i5 == 101 || i5 == 69) {
                    return m3(cArrM, i2, i5, false, i3);
                }
                this.r = i4;
                this.G.E(i2);
                if (this.z.k()) {
                    R3(i5);
                }
                return I2(false, i3);
            }
            i3++;
            cArrM[i2] = (char) i5;
            i2++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c A[DONT_INVERT, PHI: r10
      0x003c: PHI (r10v4 int) = (r10v3 int), (r10v24 int) binds: [B:9:0x002d, B:13:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0083  */
    /* JADX WARN: Code duplicated, block: B:29:0x0085 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0094  */
    /* JADX WARN: Code duplicated, block: B:34:0x009f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:52:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0110 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x0125 A[EDGE_INSN: B:56:0x0125->B:57:0x012d BREAK  A[LOOP:0: B:3:0x000e->B:77:0x000e]] */
    /* JADX WARN: Code duplicated, block: B:61:0x0136  */
    /* JADX WARN: Code duplicated, block: B:62:0x013c  */
    /* JADX WARN: Code duplicated, block: B:64:0x013f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0150  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0112 A[SYNTHETIC] */
    protected int s3(Base64Variant base64Variant, OutputStream outputStream, byte[] bArr) throws IOException {
        int i;
        int i2;
        int iDecodeBase64Char;
        int i3;
        int i4;
        int iDecodeBase64Char2;
        int i5;
        int i6;
        int iDecodeBase64Char3;
        int i7;
        int i8 = 3;
        int length = bArr.length - 3;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (this.r >= this.s) {
                c3();
            }
            byte[] bArr2 = this.h0;
            int i11 = this.r;
            this.r = i11 + 1;
            int i12 = bArr2[i11] & 255;
            if (i12 > 32) {
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(i12);
                if (iDecodeBase64Char4 < 0) {
                    if (i12 == 34) {
                        break;
                    }
                    iDecodeBase64Char4 = e2(base64Variant, i12, 0);
                    if (iDecodeBase64Char4 >= 0) {
                        if (i9 > length) {
                            i10 += i9;
                            outputStream.write(bArr, 0, i9);
                            i9 = 0;
                        }
                        if (this.r >= this.s) {
                            c3();
                        }
                        byte[] bArr3 = this.h0;
                        int i13 = this.r;
                        this.r = i13 + 1;
                        i2 = bArr3[i13] & 255;
                        iDecodeBase64Char = base64Variant.decodeBase64Char(i2);
                        if (iDecodeBase64Char < 0) {
                            iDecodeBase64Char = e2(base64Variant, i2, 1);
                        }
                        i3 = (iDecodeBase64Char4 << 6) | iDecodeBase64Char;
                        if (this.r >= this.s) {
                            c3();
                        }
                        byte[] bArr4 = this.h0;
                        int i14 = this.r;
                        this.r = i14 + 1;
                        i4 = bArr4[i14] & 255;
                        iDecodeBase64Char2 = base64Variant.decodeBase64Char(i4);
                        if (iDecodeBase64Char2 >= 0) {
                            if (iDecodeBase64Char2 != -2) {
                                if (i4 == 34) {
                                    int i15 = i9 + 1;
                                    bArr[i9] = (byte) (i3 >> 4);
                                    if (base64Variant.usesPadding()) {
                                        this.r--;
                                        k2(base64Variant);
                                    }
                                    i9 = i15;
                                    break;
                                }
                                iDecodeBase64Char2 = e2(base64Variant, i4, 2);
                            }
                            if (iDecodeBase64Char2 == -2) {
                                if (this.r >= this.s) {
                                    c3();
                                }
                                byte[] bArr5 = this.h0;
                                int i16 = this.r;
                                this.r = i16 + 1;
                                i7 = bArr5[i16] & 255;
                                if (base64Variant.usesPaddingChar(i7)) {
                                }
                                bArr[i9] = (byte) (i3 >> 4);
                                i9++;
                            }
                        }
                        i5 = (i3 << 6) | iDecodeBase64Char2;
                        if (this.r >= this.s) {
                            c3();
                        }
                        byte[] bArr6 = this.h0;
                        int i17 = this.r;
                        this.r = i17 + 1;
                        i6 = bArr6[i17] & 255;
                        iDecodeBase64Char3 = base64Variant.decodeBase64Char(i6);
                        if (iDecodeBase64Char3 < 0) {
                            if (iDecodeBase64Char3 != -2) {
                                i = 3;
                            } else {
                                if (i6 == 34) {
                                    int i18 = i9 + 1;
                                    bArr[i9] = (byte) (i5 >> 10);
                                    i9 += 2;
                                    bArr[i18] = (byte) (i5 >> 2);
                                    if (base64Variant.usesPadding()) {
                                        break;
                                    }
                                    this.r--;
                                    k2(base64Variant);
                                    break;
                                }
                                i = 3;
                                iDecodeBase64Char3 = e2(base64Variant, i6, 3);
                            }
                            if (iDecodeBase64Char3 == -2) {
                                int i19 = i9 + 1;
                                bArr[i9] = (byte) (i5 >> 10);
                                i9 += 2;
                                bArr[i19] = (byte) (i5 >> 2);
                            }
                            i8 = i;
                        } else {
                            i = 3;
                        }
                        int i20 = (i5 << 6) | iDecodeBase64Char3;
                        bArr[i9] = (byte) (i20 >> 16);
                        int i21 = i9 + 2;
                        bArr[i9 + 1] = (byte) (i20 >> 8);
                        i9 += 3;
                        bArr[i21] = (byte) i20;
                        i8 = i;
                    }
                } else {
                    if (i9 > length) {
                        i10 += i9;
                        outputStream.write(bArr, 0, i9);
                        i9 = 0;
                    }
                    if (this.r >= this.s) {
                        c3();
                    }
                    byte[] bArr7 = this.h0;
                    int i110 = this.r;
                    this.r = i110 + 1;
                    i2 = bArr7[i110] & 255;
                    iDecodeBase64Char = base64Variant.decodeBase64Char(i2);
                    if (iDecodeBase64Char < 0) {
                        iDecodeBase64Char = e2(base64Variant, i2, 1);
                    }
                    i3 = (iDecodeBase64Char4 << 6) | iDecodeBase64Char;
                    if (this.r >= this.s) {
                        c3();
                    }
                    byte[] bArr8 = this.h0;
                    int i111 = this.r;
                    this.r = i111 + 1;
                    i4 = bArr8[i111] & 255;
                    iDecodeBase64Char2 = base64Variant.decodeBase64Char(i4);
                    if (iDecodeBase64Char2 >= 0) {
                        if (iDecodeBase64Char2 != -2) {
                            if (i4 == 34) {
                                int i112 = i9 + 1;
                                bArr[i9] = (byte) (i3 >> 4);
                                if (base64Variant.usesPadding()) {
                                    this.r--;
                                    k2(base64Variant);
                                }
                                i9 = i112;
                                break;
                            }
                            iDecodeBase64Char2 = e2(base64Variant, i4, 2);
                        }
                        if (iDecodeBase64Char2 == -2) {
                            if (this.r >= this.s) {
                                c3();
                            }
                            byte[] bArr9 = this.h0;
                            int i113 = this.r;
                            this.r = i113 + 1;
                            i7 = bArr9[i113] & 255;
                            if (base64Variant.usesPaddingChar(i7) && e2(base64Variant, i7, i8) != -2) {
                                throw F2(base64Variant, i7, i8, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                            }
                            bArr[i9] = (byte) (i3 >> 4);
                            i9++;
                        }
                    }
                    i5 = (i3 << 6) | iDecodeBase64Char2;
                    if (this.r >= this.s) {
                        c3();
                    }
                    byte[] bArr10 = this.h0;
                    int i114 = this.r;
                    this.r = i114 + 1;
                    i6 = bArr10[i114] & 255;
                    iDecodeBase64Char3 = base64Variant.decodeBase64Char(i6);
                    if (iDecodeBase64Char3 < 0) {
                        if (iDecodeBase64Char3 != -2) {
                            i = 3;
                        } else {
                            if (i6 == 34) {
                                int i115 = i9 + 1;
                                bArr[i9] = (byte) (i5 >> 10);
                                i9 += 2;
                                bArr[i115] = (byte) (i5 >> 2);
                                if (base64Variant.usesPadding()) {
                                    break;
                                }
                                this.r--;
                                k2(base64Variant);
                                break;
                            }
                            i = 3;
                            iDecodeBase64Char3 = e2(base64Variant, i6, 3);
                        }
                        if (iDecodeBase64Char3 == -2) {
                            int i116 = i9 + 1;
                            bArr[i9] = (byte) (i5 >> 10);
                            i9 += 2;
                            bArr[i116] = (byte) (i5 >> 2);
                        }
                        i8 = i;
                    } else {
                        i = 3;
                    }
                    int i22 = (i5 << 6) | iDecodeBase64Char3;
                    bArr[i9] = (byte) (i22 >> 16);
                    int i23 = i9 + 2;
                    bArr[i9 + 1] = (byte) (i22 >> 8);
                    i9 += 3;
                    bArr[i23] = (byte) i22;
                    i8 = i;
                }
            }
            i = i8;
            i8 = i;
        }
        this.b0 = false;
        if (i9 <= 0) {
            return i10;
        }
        int i24 = i10 + i9;
        outputStream.write(bArr, 0, i9);
        return i24;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public jt1 t0() {
        return this.Y;
    }

    protected void t3(int i) {
        if (i < 32) {
            O1(i);
        }
        u3(i);
    }

    protected void u3(int i) {
        D1("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    protected void v3(int i) {
        D1("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation w0() {
        return new JsonLocation(c2(), this.t + ((long) this.r), -1L, this.u, (this.r - this.v) + 1);
    }

    protected void w3(int i, int i2) {
        this.r = i2;
        v3(i);
    }

    protected void x3(String str) {
        y3(str, u2());
    }

    protected void y3(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        do {
            if (this.r < this.s || b3()) {
                byte[] bArr = this.h0;
                int i = this.r;
                this.r = i + 1;
                char cO2 = (char) O2(bArr[i]);
                if (Character.isJavaIdentifierPart(cO2)) {
                    sb.append(cO2);
                }
            }
            F1("Unrecognized token '%s': was expecting %s", sb, str2);
        } while (sb.length() < 256);
        sb.append("...");
        F1("Unrecognized token '%s': was expecting %s", sb, str2);
    }
}
