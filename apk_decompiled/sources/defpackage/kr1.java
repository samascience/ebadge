package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class kr1 extends dz1 {
    protected static final String[] o0 = {"NaN", "Infinity", "+Infinity", "-Infinity"};
    protected static final double[] p0 = {Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
    protected final mp Y;
    protected int[] Z;
    protected int a0;
    protected int b0;
    protected int c0;
    protected int d0;
    protected int e0;
    protected int f0;
    protected int g0;
    protected int h0;
    protected int i0;
    protected int j0;
    protected boolean k0;
    protected int l0;
    protected int m0;
    protected int n0;

    public kr1(oy0 oy0Var, int i, mp mpVar) {
        super(oy0Var, i);
        this.Z = new int[8];
        this.k0 = false;
        this.m0 = 0;
        this.n0 = 1;
        this.Y = mpVar;
        this.d = null;
        this.g0 = 0;
        this.h0 = 1;
    }

    protected static final int T2(int i, int i2) {
        return i2 == 4 ? i : i | ((-1) << (i2 << 3));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object H0() {
        if (this.d == JsonToken.VALUE_EMBEDDED_OBJECT) {
            return this.K;
        }
        return null;
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
    protected final String J2(int[] iArr, int i, int i2) {
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
                        V2(i17);
                        i4 = 1;
                    }
                    if (i18 + i5 > i12) {
                        I1(" in field name", JsonToken.FIELD_NAME);
                    }
                    i6 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                    i18 = i14 + 2;
                    if ((i6 & 192) != 128) {
                        W2(i6);
                    }
                    i7 = (i4 << 6) | (i6 & 63);
                    if (i5 > 1) {
                        i9 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                        i18 = i14 + 3;
                        if ((i9 & 192) != 128) {
                            W2(i9);
                        }
                        i10 = (i7 << 6) | (i9 & 63);
                        if (i5 > 2) {
                            i11 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                            i18 = i14 + 4;
                            if ((i11 & 192) != 128) {
                                W2(i11 & 255);
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
                    W2(i6);
                }
                i7 = (i4 << 6) | (i6 & 63);
                if (i5 > 1) {
                    i9 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                    i18 = i14 + 3;
                    if ((i9 & 192) != 128) {
                        W2(i9);
                    }
                    i10 = (i7 << 6) | (i9 & 63);
                    if (i5 > 2) {
                        i11 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                        i18 = i14 + 4;
                        if ((i11 & 192) != 128) {
                            W2(i11 & 255);
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
        return this.Y.p(str, iArr, i);
    }

    protected final JsonToken K2() {
        int i;
        if (!this.z.i()) {
            r2(93, '}');
        }
        z61 z61VarE = this.z.e();
        this.z = z61VarE;
        if (z61VarE.j()) {
            i = 3;
        } else {
            i = z61VarE.i() ? 6 : 1;
        }
        this.g0 = i;
        this.h0 = i;
        JsonToken jsonToken = JsonToken.END_ARRAY;
        this.d = jsonToken;
        return jsonToken;
    }

    protected final JsonToken L2() {
        int i;
        if (!this.z.j()) {
            r2(125, ']');
        }
        z61 z61VarE = this.z.e();
        this.z = z61VarE;
        if (z61VarE.j()) {
            i = 3;
        } else {
            i = z61VarE.i() ? 6 : 1;
        }
        this.g0 = i;
        this.h0 = i;
        JsonToken jsonToken = JsonToken.END_OBJECT;
        this.d = jsonToken;
        return jsonToken;
    }

    protected final JsonToken M2() {
        this.g0 = 7;
        if (!this.z.k()) {
            z1();
        }
        close();
        this.d = null;
        return null;
    }

    protected final JsonToken N2(String str) throws JsonParseException {
        this.g0 = 4;
        this.z.w(str);
        JsonToken jsonToken = JsonToken.FIELD_NAME;
        this.d = jsonToken;
        return jsonToken;
    }

    protected final String O2(int i, int i2) {
        int iT2 = T2(i, i2);
        String strW = this.Y.w(iT2);
        if (strW != null) {
            return strW;
        }
        int[] iArr = this.Z;
        iArr[0] = iT2;
        return J2(iArr, 1, i2);
    }

    protected final String P2(int i, int i2, int i3) {
        int iT2 = T2(i2, i3);
        String strX = this.Y.x(i, iT2);
        if (strX != null) {
            return strX;
        }
        int[] iArr = this.Z;
        iArr[0] = i;
        iArr[1] = iT2;
        return J2(iArr, 2, i3);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public d41 Q0() {
        return dz1.X;
    }

    protected final String Q2(int i, int i2, int i3, int i4) {
        int iT2 = T2(i3, i4);
        String strY = this.Y.y(i, i2, iT2);
        if (strY != null) {
            return strY;
        }
        int[] iArr = this.Z;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = T2(iT2, i4);
        return J2(iArr, 3, i4);
    }

    protected final String R2(JsonToken jsonToken) {
        int iId;
        if (jsonToken == null || (iId = jsonToken.id()) == -1) {
            return null;
        }
        if (iId != 5) {
            return (iId == 6 || iId == 7 || iId == 8) ? this.G.l() : jsonToken.asString();
        }
        return this.z.b();
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public String S0() {
        JsonToken jsonToken = this.d;
        return jsonToken == JsonToken.VALUE_STRING ? this.G.l() : R2(jsonToken);
    }

    @Override // defpackage.ez1
    public String S1(String str) {
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this.G.l();
        }
        return jsonToken == JsonToken.FIELD_NAME ? y0() : super.S1(str);
    }

    protected final String S2(int i) {
        return o0[i];
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public char[] T0() {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        if (iId != 5) {
            return (iId == 6 || iId == 7 || iId == 8) ? this.G.u() : this.d.asCharArray();
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

    @Override // com.fasterxml.jackson.core.JsonParser
    public int U0() {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return 0;
        }
        int iId = jsonToken.id();
        if (iId != 5) {
            return (iId == 6 || iId == 7 || iId == 8) ? this.G.F() : this.d.asCharArray().length;
        }
        return this.z.b().length();
    }

    protected void U2(int i) {
        if (i < 32) {
            O1(i);
        }
        V2(i);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int V0() {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return 0;
        }
        int iId = jsonToken.id();
        if (iId == 6 || iId == 7 || iId == 8) {
            return this.G.v();
        }
        return 0;
    }

    protected void V2(int i) {
        D1("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation W0() {
        return new JsonLocation(c2(), this.w, -1L, this.x, this.y);
    }

    protected void W2(int i) {
        D1("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    protected void X2(int i, int i2) {
        this.r = i2;
        W2(i);
    }

    protected final JsonToken Y2() {
        this.z = this.z.p(-1, -1);
        this.g0 = 5;
        this.h0 = 6;
        JsonToken jsonToken = JsonToken.START_ARRAY;
        this.d = jsonToken;
        return jsonToken;
    }

    protected final JsonToken Z2() {
        this.z = this.z.q(-1, -1);
        this.g0 = 2;
        this.h0 = 3;
        JsonToken jsonToken = JsonToken.START_OBJECT;
        this.d = jsonToken;
        return jsonToken;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public String a1() {
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this.G.l();
        }
        return jsonToken == JsonToken.FIELD_NAME ? y0() : super.S1(null);
    }

    protected final void a3() {
        this.x = Math.max(this.u, this.n0);
        int i = this.r;
        this.y = i - this.v;
        this.w = this.t + ((long) (i - this.m0));
    }

    @Override // defpackage.dz1
    protected void b2() {
        this.m0 = 0;
        this.s = 0;
    }

    protected final JsonToken b3(JsonToken jsonToken) {
        this.g0 = this.h0;
        this.d = jsonToken;
        return jsonToken;
    }

    @Override // defpackage.dz1, com.fasterxml.jackson.core.JsonParser
    public boolean c1() {
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this.G.w();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this.I;
        }
        return false;
    }

    protected final JsonToken c3(int i, String str) {
        this.G.B(str);
        this.U = str.length();
        this.L = 1;
        this.M = i;
        this.g0 = this.h0;
        JsonToken jsonToken = JsonToken.VALUE_NUMBER_INT;
        this.d = jsonToken;
        return jsonToken;
    }

    protected final JsonToken d3(int i) throws JsonParseException {
        String str = o0[i];
        this.G.B(str);
        if (!f1(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            E1("Non-standard token '%s': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow", str);
        }
        this.U = 0;
        this.L = 8;
        this.P = p0[i];
        this.g0 = this.h0;
        JsonToken jsonToken = JsonToken.VALUE_NUMBER_FLOAT;
        this.d = jsonToken;
        return jsonToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte[] j0(Base64Variant base64Variant) throws JsonParseException {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING) {
            E1("Current token (%s) not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary", jsonToken);
        }
        if (this.K == null) {
            zo zoVarJ2 = j2();
            x1(S0(), zoVarJ2, base64Variant);
            this.K = zoVarJ2.t0();
        }
        return this.K;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int q1(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        byte[] bArrJ0 = j0(base64Variant);
        outputStream.write(bArrJ0);
        return bArrJ0.length;
    }

    @Override // defpackage.dz1
    protected void q2() {
        super.q2();
        this.Y.G();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public jt1 t0() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation w0() {
        int i = (this.r - this.v) + 1;
        return new JsonLocation(c2(), this.t + ((long) (this.r - this.m0)), -1L, Math.max(this.u, this.n0), i);
    }
}
