package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.tencent.connect.common.Constants;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class e83 extends dz1 {
    private static final int f0 = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int g0 = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int h0 = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.getMask();
    private static final int i0 = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int j0 = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int k0 = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int l0 = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int m0 = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    private static final int[] n0 = ex.j();
    protected static final int[] o0 = ex.h();
    protected jt1 Y;
    protected final mp Z;
    protected int[] a0;
    protected boolean b0;
    private int c0;
    protected DataInput d0;
    protected int e0;

    public e83(oy0 oy0Var, int i, DataInput dataInput, jt1 jt1Var, mp mpVar, int i2) {
        super(oy0Var, i);
        this.a0 = new int[16];
        this.Y = jt1Var;
        this.Z = mpVar;
        this.d0 = dataInput;
        this.e0 = i2;
    }

    private final void B3() throws IOException {
        int unsignedByte = this.d0.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            s3(unsignedByte & 255);
        }
    }

    private final void C3() throws IOException {
        int unsignedByte = this.d0.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            s3(unsignedByte & 255);
        }
        int unsignedByte2 = this.d0.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            s3(unsignedByte2 & 255);
        }
    }

    private final void D3() throws IOException {
        int unsignedByte = this.d0.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            s3(unsignedByte & 255);
        }
        int unsignedByte2 = this.d0.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            s3(unsignedByte2 & 255);
        }
        int unsignedByte3 = this.d0.readUnsignedByte();
        if ((unsignedByte3 & 192) != 128) {
            s3(unsignedByte3 & 255);
        }
    }

    private final int E3() throws IOException {
        int unsignedByte = this.e0;
        if (unsignedByte < 0) {
            unsignedByte = this.d0.readUnsignedByte();
        } else {
            this.e0 = -1;
        }
        while (unsignedByte <= 32) {
            if (unsignedByte == 13 || unsignedByte == 10) {
                this.u++;
            }
            unsignedByte = this.d0.readUnsignedByte();
        }
        return (unsignedByte == 47 || unsignedByte == 35) ? F3(unsignedByte) : unsignedByte;
    }

    private final int F3(int i) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    y3();
                } else if (i != 35 || !H3()) {
                    break;
                }
            } else if (i == 13 || i == 10) {
                this.u++;
            }
            i = this.d0.readUnsignedByte();
        }
        return i;
    }

    private final int G3() throws IOException {
        int unsignedByte = this.e0;
        if (unsignedByte < 0) {
            try {
                unsignedByte = this.d0.readUnsignedByte();
            } catch (EOFException unused) {
                return g2();
            }
        } else {
            this.e0 = -1;
        }
        while (unsignedByte <= 32) {
            if (unsignedByte == 13 || unsignedByte == 10) {
                this.u++;
            }
            try {
                unsignedByte = this.d0.readUnsignedByte();
            } catch (EOFException unused2) {
                return g2();
            }
        }
        return (unsignedByte == 47 || unsignedByte == 35) ? F3(unsignedByte) : unsignedByte;
    }

    private final boolean H3() throws IOException {
        if ((this.a & m0) == 0) {
            return false;
        }
        z3();
        return true;
    }

    private final void I3() {
        int i = this.e0;
        if (i > 32) {
            K1(i);
            return;
        }
        this.e0 = -1;
        if (i == 13 || i == 10) {
            this.u++;
        }
    }

    private final void J2(String str, int i, int i2) throws IOException {
        char cM2 = (char) M2(i2);
        if (Character.isJavaIdentifierPart(cM2)) {
            t3(cM2, str.substring(0, i));
        }
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
    private final String J3(int[] iArr, int i, int i2) {
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
                        r3(i17);
                        i4 = 1;
                    }
                    if (i18 + i5 > i12) {
                        I1(" in field name", JsonToken.FIELD_NAME);
                    }
                    i6 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                    i18 = i14 + 2;
                    if ((i6 & 192) != 128) {
                        s3(i6);
                    }
                    i7 = (i4 << 6) | (i6 & 63);
                    if (i5 > 1) {
                        i9 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                        i18 = i14 + 3;
                        if ((i9 & 192) != 128) {
                            s3(i9);
                        }
                        i10 = (i7 << 6) | (i9 & 63);
                        if (i5 > 2) {
                            i11 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                            i18 = i14 + 4;
                            if ((i11 & 192) != 128) {
                                s3(i11 & 255);
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
                    s3(i6);
                }
                i7 = (i4 << 6) | (i6 & 63);
                if (i5 > 1) {
                    i9 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                    i18 = i14 + 3;
                    if ((i9 & 192) != 128) {
                        s3(i9);
                    }
                    i10 = (i7 << 6) | (i9 & 63);
                    if (i5 > 2) {
                        i11 = iArr[i18 >> 2] >> ((3 - (i18 & 3)) << 3);
                        i18 = i14 + 4;
                        if ((i11 & 192) != 128) {
                            s3(i11 & 255);
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

    private void K2(int i) {
        if (i == 93) {
            if (!this.z.i()) {
                r2(i, '}');
            }
            this.z = this.z.o();
            this.d = JsonToken.END_ARRAY;
        }
        if (i == 125) {
            if (!this.z.j()) {
                r2(i, ']');
            }
            this.z = this.z.o();
            this.d = JsonToken.END_OBJECT;
        }
    }

    private final String K3(int i, int i2) {
        int iO3 = O3(i, i2);
        String strW = this.Z.w(iO3);
        if (strW != null) {
            return strW;
        }
        int[] iArr = this.a0;
        iArr[0] = iO3;
        return J3(iArr, 1, i2);
    }

    private final String L3(int i, int i2, int i3) {
        int iO3 = O3(i2, i3);
        String strX = this.Z.x(i, iO3);
        if (strX != null) {
            return strX;
        }
        int[] iArr = this.a0;
        iArr[0] = i;
        iArr[1] = iO3;
        return J3(iArr, 2, i3);
    }

    private final String M3(int i, int i2, int i3, int i4) {
        int iO3 = O3(i3, i4);
        String strY = this.Z.y(i, i2, iO3);
        if (strY != null) {
            return strY;
        }
        int[] iArr = this.a0;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = O3(iO3, i4);
        return J3(iArr, 3, i4);
    }

    private final int N2(int i) throws IOException {
        int unsignedByte = this.d0.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            s3(unsignedByte & 255);
        }
        return ((i & 31) << 6) | (unsignedByte & 63);
    }

    private final String N3(int[] iArr, int i, int i2, int i3) {
        if (i >= iArr.length) {
            iArr = U2(iArr, iArr.length);
            this.a0 = iArr;
        }
        int i4 = i + 1;
        iArr[i] = O3(i2, i3);
        String strZ = this.Z.z(iArr, i4);
        return strZ == null ? J3(iArr, i4, i3) : strZ;
    }

    private final int O2(int i) throws IOException {
        int i2 = i & 15;
        int unsignedByte = this.d0.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            s3(unsignedByte & 255);
        }
        int i3 = (i2 << 6) | (unsignedByte & 63);
        int unsignedByte2 = this.d0.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            s3(unsignedByte2 & 255);
        }
        return (i3 << 6) | (unsignedByte2 & 63);
    }

    private static final int O3(int i, int i2) {
        return i2 == 4 ? i : i | ((-1) << (i2 << 3));
    }

    private final int P2(int i) throws IOException {
        int unsignedByte = this.d0.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            s3(unsignedByte & 255);
        }
        int i2 = ((i & 7) << 6) | (unsignedByte & 63);
        int unsignedByte2 = this.d0.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            s3(unsignedByte2 & 255);
        }
        int i3 = (i2 << 6) | (unsignedByte2 & 63);
        int unsignedByte3 = this.d0.readUnsignedByte();
        if ((unsignedByte3 & 192) != 128) {
            s3(unsignedByte3 & 255);
        }
        return ((i3 << 6) | (unsignedByte3 & 63)) - 65536;
    }

    private String Q2() throws IOException {
        char[] cArrM = this.G.m();
        int[] iArr = n0;
        int length = cArrM.length;
        int i = 0;
        while (true) {
            int unsignedByte = this.d0.readUnsignedByte();
            if (iArr[unsignedByte] != 0) {
                if (unsignedByte == 34) {
                    return this.G.D(i);
                }
                S2(cArrM, i, unsignedByte);
                return this.G.l();
            }
            int i2 = i + 1;
            cArrM[i] = (char) unsignedByte;
            if (i2 >= length) {
                S2(cArrM, i2, this.d0.readUnsignedByte());
                return this.G.l();
            }
            i = i2;
        }
    }

    private final String Q3(int i, int i2, int i3) {
        return P3(this.a0, 0, i, i2, i3);
    }

    private final String R3(int i, int i2, int i3, int i4) {
        int[] iArr = this.a0;
        iArr[0] = i;
        return P3(iArr, 1, i2, i3, i4);
    }

    private final void S2(char[] cArr, int i, int i2) throws IOException {
        int[] iArr = n0;
        int length = cArr.length;
        while (true) {
            int i3 = iArr[i2];
            int i4 = 0;
            if (i3 == 0) {
                if (i >= length) {
                    cArr = this.G.p();
                    length = cArr.length;
                    i = 0;
                }
                cArr[i] = (char) i2;
                i2 = this.d0.readUnsignedByte();
                i++;
            } else {
                if (i2 == 34) {
                    this.G.E(i);
                    return;
                }
                if (i3 == 1) {
                    i2 = f2();
                } else if (i3 == 2) {
                    i2 = N2(i2);
                } else if (i3 == 3) {
                    i2 = O2(i2);
                } else if (i3 == 4) {
                    int iP2 = P2(i2);
                    if (i >= cArr.length) {
                        cArr = this.G.p();
                        length = cArr.length;
                        i = 0;
                    }
                    cArr[i] = (char) ((iP2 >> 10) | 55296);
                    i2 = 56320 | (iP2 & 1023);
                    i++;
                } else if (i2 < 32) {
                    t2(i2, "string value");
                } else {
                    q3(i2);
                }
                if (i >= cArr.length) {
                    cArr = this.G.p();
                    length = cArr.length;
                } else {
                    i4 = i;
                }
                i = i4 + 1;
                cArr[i4] = (char) i2;
                i2 = this.d0.readUnsignedByte();
            }
        }
    }

    private final String S3(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.a0;
        iArr[0] = i;
        iArr[1] = i2;
        return P3(iArr, 2, i3, i4, i5);
    }

    private static int[] U2(int[] iArr, int i) {
        return iArr == null ? new int[i] : Arrays.copyOf(iArr, iArr.length + i);
    }

    private final int Y2() throws IOException {
        int unsignedByte = this.d0.readUnsignedByte();
        if (unsignedByte >= 48 && unsignedByte <= 57) {
            if ((this.a & g0) == 0) {
                T1("Leading zeroes not allowed");
            }
            while (unsignedByte == 48) {
                unsignedByte = this.d0.readUnsignedByte();
            }
        }
        return unsignedByte;
    }

    private final JsonToken c3() {
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

    private final JsonToken d3(int i) throws IOException {
        if (i == 34) {
            this.b0 = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.d = jsonToken;
            return jsonToken;
        }
        if (i == 43) {
            if (f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                JsonToken jsonTokenM3 = m3();
                this.d = jsonTokenM3;
                return jsonTokenM3;
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
            b3("false", 1);
            JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
            this.d = jsonToken3;
            return jsonToken3;
        }
        if (i == 110) {
            b3("null", 1);
            JsonToken jsonToken4 = JsonToken.VALUE_NULL;
            this.d = jsonToken4;
            return jsonToken4;
        }
        if (i == 116) {
            b3("true", 1);
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
            JsonToken jsonTokenL3 = l3();
            this.d = jsonTokenL3;
            return jsonTokenL3;
        }
        if (i == 46) {
            JsonToken jsonTokenG3 = g3(false, false);
            this.d = jsonTokenG3;
            return jsonTokenG3;
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
                JsonToken jsonTokenO3 = o3(i);
                this.d = jsonTokenO3;
                return jsonTokenO3;
            default:
                JsonToken jsonTokenA4 = a3(i);
                this.d = jsonTokenA4;
                return jsonTokenA4;
        }
    }

    private final JsonToken f3(char[] cArr, int i, int i2, boolean z, int i3) throws IOException {
        int i4;
        int unsignedByte;
        int i5 = 0;
        if (i2 == 46) {
            if (i >= cArr.length) {
                cArr = this.G.p();
                i = 0;
            }
            cArr[i] = (char) i2;
            i++;
            int i6 = 0;
            while (true) {
                unsignedByte = this.d0.readUnsignedByte();
                if (unsignedByte < 48 || unsignedByte > 57) {
                    break;
                }
                i6++;
                if (i >= cArr.length) {
                    cArr = this.G.p();
                    i = 0;
                }
                cArr[i] = (char) unsignedByte;
                i++;
            }
            if (i6 == 0 && !f1(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                M1(unsignedByte, "Decimal point not followed by a digit");
            }
            i4 = i6;
            i2 = unsignedByte;
        } else {
            i4 = 0;
        }
        if (i2 == 101 || i2 == 69) {
            if (i >= cArr.length) {
                cArr = this.G.p();
                i = 0;
            }
            int i7 = i + 1;
            cArr[i] = (char) i2;
            int unsignedByte2 = this.d0.readUnsignedByte();
            if (unsignedByte2 == 45 || unsignedByte2 == 43) {
                if (i7 >= cArr.length) {
                    cArr = this.G.p();
                    i7 = 0;
                }
                cArr[i7] = (char) unsignedByte2;
                i2 = this.d0.readUnsignedByte();
                i = i7 + 1;
            } else {
                i2 = unsignedByte2;
                i = i7;
            }
            while (i2 <= 57 && i2 >= 48) {
                i5++;
                if (i >= cArr.length) {
                    cArr = this.G.p();
                    i = 0;
                }
                cArr[i] = (char) i2;
                i2 = this.d0.readUnsignedByte();
                i++;
            }
            if (i5 == 0) {
                M1(i2, "Exponent indicator not followed by a digit");
            }
            i5 = i5;
        }
        this.e0 = i2;
        if (this.z.k()) {
            I3();
        }
        this.G.E(i);
        return H2(z, i3, i4, i5);
    }

    private final String h3(int i, int i2, int i3) throws IOException {
        int[] iArr = this.a0;
        iArr[0] = this.c0;
        iArr[1] = i2;
        iArr[2] = i3;
        int[] iArr2 = o0;
        int i4 = i;
        int i5 = 3;
        while (true) {
            int unsignedByte = this.d0.readUnsignedByte();
            if (iArr2[unsignedByte] != 0) {
                return unsignedByte == 34 ? N3(this.a0, i5, i4, 1) : P3(this.a0, i5, i4, unsignedByte, 1);
            }
            int i6 = (i4 << 8) | unsignedByte;
            int unsignedByte2 = this.d0.readUnsignedByte();
            if (iArr2[unsignedByte2] != 0) {
                return unsignedByte2 == 34 ? N3(this.a0, i5, i6, 2) : P3(this.a0, i5, i6, unsignedByte2, 2);
            }
            int i7 = (i6 << 8) | unsignedByte2;
            int unsignedByte3 = this.d0.readUnsignedByte();
            if (iArr2[unsignedByte3] != 0) {
                return unsignedByte3 == 34 ? N3(this.a0, i5, i7, 3) : P3(this.a0, i5, i7, unsignedByte3, 3);
            }
            int i8 = (i7 << 8) | unsignedByte3;
            int unsignedByte4 = this.d0.readUnsignedByte();
            if (iArr2[unsignedByte4] != 0) {
                return unsignedByte4 == 34 ? N3(this.a0, i5, i8, 4) : P3(this.a0, i5, i8, unsignedByte4, 4);
            }
            int[] iArr3 = this.a0;
            if (i5 >= iArr3.length) {
                this.a0 = U2(iArr3, i5);
            }
            this.a0[i5] = i8;
            i5++;
            i4 = unsignedByte4;
        }
    }

    private final String i3(int i) throws IOException {
        int[] iArr = o0;
        int unsignedByte = this.d0.readUnsignedByte();
        if (iArr[unsignedByte] != 0) {
            return unsignedByte == 34 ? L3(this.c0, i, 1) : R3(this.c0, i, unsignedByte, 1);
        }
        int i2 = (i << 8) | unsignedByte;
        int unsignedByte2 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte2] != 0) {
            return unsignedByte2 == 34 ? L3(this.c0, i2, 2) : R3(this.c0, i2, unsignedByte2, 2);
        }
        int i3 = (i2 << 8) | unsignedByte2;
        int unsignedByte3 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte3] != 0) {
            return unsignedByte3 == 34 ? L3(this.c0, i3, 3) : R3(this.c0, i3, unsignedByte3, 3);
        }
        int i4 = (i3 << 8) | unsignedByte3;
        int unsignedByte4 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte4] != 0) {
            return unsignedByte4 == 34 ? L3(this.c0, i4, 4) : R3(this.c0, i4, unsignedByte4, 4);
        }
        return j3(unsignedByte4, i4);
    }

    private final String j3(int i, int i2) throws IOException {
        int[] iArr = o0;
        int unsignedByte = this.d0.readUnsignedByte();
        if (iArr[unsignedByte] != 0) {
            return unsignedByte == 34 ? M3(this.c0, i2, i, 1) : S3(this.c0, i2, i, unsignedByte, 1);
        }
        int i3 = (i << 8) | unsignedByte;
        int unsignedByte2 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte2] != 0) {
            return unsignedByte2 == 34 ? M3(this.c0, i2, i3, 2) : S3(this.c0, i2, i3, unsignedByte2, 2);
        }
        int i4 = (i3 << 8) | unsignedByte2;
        int unsignedByte3 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte3] != 0) {
            return unsignedByte3 == 34 ? M3(this.c0, i2, i4, 3) : S3(this.c0, i2, i4, unsignedByte3, 3);
        }
        int i5 = (i4 << 8) | unsignedByte3;
        int unsignedByte4 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte4] != 0) {
            return unsignedByte4 == 34 ? M3(this.c0, i2, i5, 4) : S3(this.c0, i2, i5, unsignedByte4, 4);
        }
        return h3(unsignedByte4, i2, i5);
    }

    private final JsonToken n3(boolean z) throws IOException {
        int i;
        int unsignedByte;
        char[] cArrM = this.G.m();
        if (z) {
            cArrM[0] = '-';
            i = 1;
        } else {
            i = 0;
        }
        int unsignedByte2 = this.d0.readUnsignedByte();
        int i2 = i + 1;
        cArrM[i] = (char) unsignedByte2;
        if (unsignedByte2 <= 48) {
            if (unsignedByte2 != 48) {
                return unsignedByte2 == 46 ? g3(z, true) : X2(unsignedByte2, z, true);
            }
            unsignedByte = Y2();
        } else {
            if (unsignedByte2 > 57) {
                return X2(unsignedByte2, z, true);
            }
            unsignedByte = this.d0.readUnsignedByte();
        }
        char[] cArrP = cArrM;
        int i3 = 1;
        int unsignedByte3 = unsignedByte;
        int i4 = i2;
        while (unsignedByte3 <= 57 && unsignedByte3 >= 48) {
            i3++;
            if (i4 >= cArrP.length) {
                cArrP = this.G.p();
                i4 = 0;
            }
            cArrP[i4] = (char) unsignedByte3;
            unsignedByte3 = this.d0.readUnsignedByte();
            i4++;
        }
        if (unsignedByte3 == 46 || unsignedByte3 == 101 || unsignedByte3 == 69) {
            return f3(cArrP, i4, unsignedByte3, z, i3);
        }
        this.G.E(i4);
        this.e0 = unsignedByte3;
        if (this.z.k()) {
            I3();
        }
        return I2(z, i3);
    }

    private void s3(int i) {
        D1("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    private final void v3() throws IOException {
        int[] iArrG = ex.g();
        int unsignedByte = this.d0.readUnsignedByte();
        while (true) {
            int i = iArrG[unsignedByte];
            if (i != 0) {
                if (i == 2) {
                    B3();
                } else if (i == 3) {
                    C3();
                } else if (i == 4) {
                    D3();
                } else if (i == 10 || i == 13) {
                    this.u++;
                } else if (i != 42) {
                    q3(unsignedByte);
                } else {
                    unsignedByte = this.d0.readUnsignedByte();
                    if (unsignedByte == 47) {
                        return;
                    }
                }
            }
            unsignedByte = this.d0.readUnsignedByte();
        }
    }

    private final int w3() throws IOException {
        int unsignedByte = this.e0;
        if (unsignedByte < 0) {
            unsignedByte = this.d0.readUnsignedByte();
        } else {
            this.e0 = -1;
        }
        if (unsignedByte == 58) {
            int unsignedByte2 = this.d0.readUnsignedByte();
            if (unsignedByte2 > 32) {
                return (unsignedByte2 == 47 || unsignedByte2 == 35) ? x3(unsignedByte2, true) : unsignedByte2;
            }
            if ((unsignedByte2 == 32 || unsignedByte2 == 9) && (unsignedByte2 = this.d0.readUnsignedByte()) > 32) {
                return (unsignedByte2 == 47 || unsignedByte2 == 35) ? x3(unsignedByte2, true) : unsignedByte2;
            }
            return x3(unsignedByte2, true);
        }
        if (unsignedByte == 32 || unsignedByte == 9) {
            unsignedByte = this.d0.readUnsignedByte();
        }
        if (unsignedByte != 58) {
            return x3(unsignedByte, false);
        }
        int unsignedByte3 = this.d0.readUnsignedByte();
        if (unsignedByte3 > 32) {
            return (unsignedByte3 == 47 || unsignedByte3 == 35) ? x3(unsignedByte3, true) : unsignedByte3;
        }
        if ((unsignedByte3 == 32 || unsignedByte3 == 9) && (unsignedByte3 = this.d0.readUnsignedByte()) > 32) {
            return (unsignedByte3 == 47 || unsignedByte3 == 35) ? x3(unsignedByte3, true) : unsignedByte3;
        }
        return x3(unsignedByte3, true);
    }

    private final int x3(int i, boolean z) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    y3();
                } else if (i != 35 || !H3()) {
                    if (z) {
                        return i;
                    }
                    if (i != 58) {
                        L1(i, "was expecting a colon to separate field name and value");
                    }
                    z = true;
                }
            } else if (i == 13 || i == 10) {
                this.u++;
            }
            i = this.d0.readUnsignedByte();
        }
    }

    private final void y3() throws IOException {
        if ((this.a & l0) == 0) {
            L1(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        int unsignedByte = this.d0.readUnsignedByte();
        if (unsignedByte == 47) {
            z3();
        } else if (unsignedByte == 42) {
            v3();
        } else {
            L1(unsignedByte, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void z3() throws IOException {
        int[] iArrG = ex.g();
        while (true) {
            int unsignedByte = this.d0.readUnsignedByte();
            int i = iArrG[unsignedByte];
            if (i != 0) {
                if (i == 2) {
                    B3();
                } else if (i == 3) {
                    C3();
                } else if (i == 4) {
                    D3();
                } else if (i == 10 || i == 13) {
                    break;
                } else if (i != 42 && i < 0) {
                    q3(unsignedByte);
                }
            }
        }
        this.u++;
    }

    protected void A3() throws IOException {
        this.b0 = false;
        int[] iArr = n0;
        while (true) {
            int unsignedByte = this.d0.readUnsignedByte();
            int i = iArr[unsignedByte];
            if (i != 0) {
                if (unsignedByte == 34) {
                    return;
                }
                if (i == 1) {
                    f2();
                } else if (i == 2) {
                    B3();
                } else if (i == 3) {
                    C3();
                } else if (i == 4) {
                    D3();
                } else if (unsignedByte < 32) {
                    t2(unsignedByte, "string value");
                } else {
                    q3(unsignedByte);
                }
            }
        }
    }

    protected final byte[] L2(Base64Variant base64Variant) throws IOException {
        zo zoVarJ2 = j2();
        while (true) {
            int unsignedByte = this.d0.readUnsignedByte();
            if (unsignedByte > 32) {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(unsignedByte);
                if (iDecodeBase64Char < 0) {
                    if (unsignedByte == 34) {
                        return zoVarJ2.t0();
                    }
                    iDecodeBase64Char = e2(base64Variant, unsignedByte, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                int unsignedByte2 = this.d0.readUnsignedByte();
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(unsignedByte2);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = e2(base64Variant, unsignedByte2, 1);
                }
                int i = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                int unsignedByte3 = this.d0.readUnsignedByte();
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(unsignedByte3);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (unsignedByte3 == 34) {
                            zoVarJ2.u(i >> 4);
                            if (base64Variant.usesPadding()) {
                                k2(base64Variant);
                            }
                            return zoVarJ2.t0();
                        }
                        iDecodeBase64Char3 = e2(base64Variant, unsignedByte3, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        int unsignedByte4 = this.d0.readUnsignedByte();
                        if (!base64Variant.usesPaddingChar(unsignedByte4) && (unsignedByte4 != 92 || e2(base64Variant, unsignedByte4, 3) != -2)) {
                            throw F2(base64Variant, unsignedByte4, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        zoVarJ2.u(i >> 4);
                    }
                }
                int i2 = (i << 6) | iDecodeBase64Char3;
                int unsignedByte5 = this.d0.readUnsignedByte();
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(unsignedByte5);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (unsignedByte5 == 34) {
                            zoVarJ2.y(i2 >> 2);
                            if (base64Variant.usesPadding()) {
                                k2(base64Variant);
                            }
                            return zoVarJ2.t0();
                        }
                        iDecodeBase64Char4 = e2(base64Variant, unsignedByte5, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        zoVarJ2.y(i2 >> 2);
                    }
                }
                zoVarJ2.w((i2 << 6) | iDecodeBase64Char4);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    /* JADX WARN: Code duplicated, block: B:22:0x004e  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0064  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    protected int M2(int i) throws IOException {
        char c;
        int unsignedByte;
        int i2;
        int unsignedByte2;
        int i3;
        int unsignedByte3;
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
                r3(i & 255);
            }
            unsignedByte = this.d0.readUnsignedByte();
            if ((unsignedByte & 192) != 128) {
                s3(unsignedByte & 255);
            }
            i2 = (i4 << 6) | (unsignedByte & 63);
            if (c > 1) {
                return i2;
            }
            unsignedByte2 = this.d0.readUnsignedByte();
            if ((unsignedByte2 & 192) != 128) {
                s3(unsignedByte2 & 255);
            }
            i3 = (i2 << 6) | (unsignedByte2 & 63);
            if (c > 2) {
                return i3;
            }
            unsignedByte3 = this.d0.readUnsignedByte();
            if ((unsignedByte3 & 192) != 128) {
                s3(unsignedByte3 & 255);
            }
            return (i3 << 6) | (unsignedByte3 & 63);
        }
        i4 = i & 31;
        c = 1;
        unsignedByte = this.d0.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            s3(unsignedByte & 255);
        }
        i2 = (i4 << 6) | (unsignedByte & 63);
        if (c > 1) {
            return i2;
        }
        unsignedByte2 = this.d0.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            s3(unsignedByte2 & 255);
        }
        i3 = (i2 << 6) | (unsignedByte2 & 63);
        if (c > 2) {
            return i3;
        }
        unsignedByte3 = this.d0.readUnsignedByte();
        if ((unsignedByte3 & 192) != 128) {
            s3(unsignedByte3 & 255);
        }
        return (i3 << 6) | (unsignedByte3 & 63);
    }

    protected final String P3(int[] iArr, int i, int i2, int i3, int i4) throws IOException {
        int[] iArr2 = o0;
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
                            iArr = U2(iArr, iArr.length);
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
                                iArr = U2(iArr, iArr.length);
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
                    iArr = U2(iArr, iArr.length);
                    this.a0 = iArr;
                }
                iArr[i] = i2;
                i2 = i3;
                i++;
                i4 = 1;
            }
            i3 = this.d0.readUnsignedByte();
        }
        if (i4 > 0) {
            if (i >= iArr.length) {
                iArr = U2(iArr, iArr.length);
                this.a0 = iArr;
            }
            iArr[i] = O3(i2, i4);
            i++;
        }
        String strZ = this.Z.z(iArr, i);
        return strZ == null ? J3(iArr, i, i4) : strZ;
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

    protected void R2() throws IOException {
        char[] cArrM = this.G.m();
        int[] iArr = n0;
        int length = cArrM.length;
        int i = 0;
        while (true) {
            int unsignedByte = this.d0.readUnsignedByte();
            if (iArr[unsignedByte] != 0) {
                if (unsignedByte == 34) {
                    this.G.E(i);
                    return;
                } else {
                    S2(cArrM, i, unsignedByte);
                    return;
                }
            }
            int i2 = i + 1;
            cArrM[i] = (char) unsignedByte;
            if (i2 >= length) {
                S2(cArrM, i2, this.d0.readUnsignedByte());
                return;
            }
            i = i2;
        }
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public String S0() {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return T2(jsonToken);
        }
        if (!this.b0) {
            return this.G.l();
        }
        this.b0 = false;
        return Q2();
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
        return Q2();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public char[] T0() throws IOException {
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
                R2();
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

    protected final String T2(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        if (iId != 5) {
            return (iId == 6 || iId == 7 || iId == 8) ? this.G.l() : jsonToken.asString();
        }
        return this.z.b();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int U0() throws IOException {
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this.b0) {
                this.b0 = false;
                R2();
            }
            return this.G.F();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this.z.b().length();
        }
        if (jsonToken != null) {
            return jsonToken.isNumeric() ? this.G.F() : this.d.asCharArray().length;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (r0 != 8) goto L16;
     */
    @Override // com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int V0() throws java.io.IOException {
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
            r3.R2()
        L1d:
            w13 r0 = r3.G
            int r0 = r0.v()
            return r0
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e83.V0():int");
    }

    protected JsonToken V2() throws IOException {
        int i;
        char[] cArrM = this.G.m();
        int[] iArr = n0;
        int i2 = 0;
        while (true) {
            int length = cArrM.length;
            if (i2 >= cArrM.length) {
                cArrM = this.G.p();
                length = cArrM.length;
                i2 = 0;
            }
            do {
                int unsignedByte = this.d0.readUnsignedByte();
                if (unsignedByte != 39) {
                    int i3 = iArr[unsignedByte];
                    if (i3 != 0 && unsignedByte != 34) {
                        if (i3 == 1) {
                            unsignedByte = f2();
                        } else if (i3 == 2) {
                            unsignedByte = N2(unsignedByte);
                        } else if (i3 == 3) {
                            unsignedByte = O2(unsignedByte);
                        } else if (i3 != 4) {
                            if (unsignedByte < 32) {
                                t2(unsignedByte, "string value");
                            }
                            q3(unsignedByte);
                        } else {
                            int iP2 = P2(unsignedByte);
                            int i4 = i2 + 1;
                            cArrM[i2] = (char) ((iP2 >> 10) | 55296);
                            if (i4 >= cArrM.length) {
                                cArrM = this.G.p();
                                i2 = 0;
                            } else {
                                i2 = i4;
                            }
                            unsignedByte = 56320 | (iP2 & 1023);
                        }
                        if (i2 >= cArrM.length) {
                            cArrM = this.G.p();
                            i2 = 0;
                        }
                        cArrM[i2] = (char) unsignedByte;
                        i2++;
                        break;
                    }
                    i = i2 + 1;
                    cArrM[i2] = (char) unsignedByte;
                    i2 = i;
                } else {
                    this.G.E(i2);
                    return JsonToken.VALUE_STRING;
                }
            } while (i < length);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation W0() {
        return new JsonLocation(c2(), -1L, -1L, this.x, -1);
    }

    protected JsonToken W2(int i, boolean z) {
        return X2(i, z, false);
    }

    protected JsonToken X2(int i, boolean z, boolean z2) throws IOException {
        String str;
        while (i == 73) {
            i = this.d0.readUnsignedByte();
            if (i != 78) {
                if (i != 110) {
                    break;
                }
                str = z ? "-Infinity" : "+Infinity";
            } else {
                str = z ? "-INF" : "+INF";
            }
            b3(str, 3);
            if ((this.a & h0) != 0) {
                return G2(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            D1("Non-standard token '" + str + "': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
        }
        if (!f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) && z2 && !z) {
            M1(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        }
        M1(i, z ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
        return null;
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

    protected String Z2(int i) throws IOException {
        if (i == 39 && (this.a & j0) != 0) {
            return e3();
        }
        if ((this.a & k0) == 0) {
            L1((char) M2(i), "was expecting double-quote to start field name");
        }
        int[] iArrK = ex.k();
        if (iArrK[i] != 0) {
            L1(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] iArrU2 = this.a0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        do {
            if (i2 < 4) {
                i2++;
                i4 = i | (i4 << 8);
            } else {
                if (i3 >= iArrU2.length) {
                    iArrU2 = U2(iArrU2, iArrU2.length);
                    this.a0 = iArrU2;
                }
                iArrU2[i3] = i4;
                i4 = i;
                i3++;
                i2 = 1;
            }
            i = this.d0.readUnsignedByte();
        } while (iArrK[i] == 0);
        this.e0 = i;
        if (i2 > 0) {
            if (i3 >= iArrU2.length) {
                iArrU2 = U2(iArrU2, iArrU2.length);
                this.a0 = iArrU2;
            }
            iArrU2[i3] = i4;
            i3++;
        }
        String strZ = this.Z.z(iArrU2, i3);
        return strZ == null ? J3(iArrU2, i3, i2) : strZ;
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
        return Q2();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0086  */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if (r4 != 44) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (r3.z.i() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        if (r3.z.k() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        if ((r3.a & defpackage.e83.i0) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        r3.e0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        return com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.fasterxml.jackson.core.JsonToken a3(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 39
            if (r4 == r0) goto L7f
            r0 = 73
            r1 = 1
            if (r4 == r0) goto L66
            r0 = 78
            if (r4 == r0) goto L4d
            r0 = 93
            if (r4 == r0) goto L2a
            r0 = 125(0x7d, float:1.75E-43)
            if (r4 == r0) goto L47
            r0 = 43
            if (r4 == r0) goto L1e
            r0 = 44
            if (r4 == r0) goto L33
            goto L8b
        L1e:
            java.io.DataInput r4 = r3.d0
            int r4 = r4.readUnsignedByte()
            r0 = 0
            com.fasterxml.jackson.core.JsonToken r4 = r3.X2(r4, r0, r1)
            return r4
        L2a:
            z61 r0 = r3.z
            boolean r0 = r0.i()
            if (r0 != 0) goto L33
            goto L8b
        L33:
            z61 r0 = r3.z
            boolean r0 = r0.k()
            if (r0 != 0) goto L47
            int r0 = r3.a
            int r1 = defpackage.e83.i0
            r0 = r0 & r1
            if (r0 == 0) goto L47
            r3.e0 = r4
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r4
        L47:
            java.lang.String r0 = "expected a value"
            r3.L1(r4, r0)
            goto L7f
        L4d:
            java.lang.String r0 = "NaN"
            r3.b3(r0, r1)
            int r1 = r3.a
            int r2 = defpackage.e83.h0
            r1 = r1 & r2
            if (r1 == 0) goto L60
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r4 = r3.G2(r0, r1)
            return r4
        L60:
            java.lang.String r0 = "Non-standard token 'NaN': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3.D1(r0)
            goto L8b
        L66:
            java.lang.String r0 = "Infinity"
            r3.b3(r0, r1)
            int r1 = r3.a
            int r2 = defpackage.e83.h0
            r1 = r1 & r2
            if (r1 == 0) goto L79
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r4 = r3.G2(r0, r1)
            return r4
        L79:
            java.lang.String r0 = "Non-standard token 'Infinity': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3.D1(r0)
            goto L8b
        L7f:
            int r0 = r3.a
            int r1 = defpackage.e83.j0
            r0 = r0 & r1
            if (r0 == 0) goto L8b
            com.fasterxml.jackson.core.JsonToken r4 = r3.V2()
            return r4
        L8b:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto Laa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            r0.append(r1)
            char r1 = (char) r4
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r3.u2()
            r3.u3(r4, r0, r1)
        Laa:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "expected a valid value "
            r0.append(r1)
            java.lang.String r1 = r3.v2()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.L1(r4, r0)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e83.a3(int):com.fasterxml.jackson.core.JsonToken");
    }

    @Override // defpackage.dz1
    protected void b2() {
    }

    protected final void b3(String str, int i) throws IOException {
        int length = str.length();
        do {
            int unsignedByte = this.d0.readUnsignedByte();
            if (unsignedByte != str.charAt(i)) {
                t3(unsignedByte, str.substring(0, i));
            }
            i++;
        } while (i < length);
        int unsignedByte2 = this.d0.readUnsignedByte();
        if (unsignedByte2 >= 48 && unsignedByte2 != 93 && unsignedByte2 != 125) {
            J2(str, i, unsignedByte2);
        }
        this.e0 = unsignedByte2;
    }

    protected String e3() throws IOException {
        int unsignedByte = this.d0.readUnsignedByte();
        if (unsignedByte == 39) {
            return Constants.STR_EMPTY;
        }
        int[] iArrU2 = this.a0;
        int[] iArr = o0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (unsignedByte != 39) {
            if (unsignedByte != 34 && iArr[unsignedByte] != 0) {
                if (unsignedByte != 92) {
                    t2(unsignedByte, "name");
                } else {
                    unsignedByte = f2();
                }
                if (unsignedByte > 127) {
                    if (i >= 4) {
                        if (i2 >= iArrU2.length) {
                            iArrU2 = U2(iArrU2, iArrU2.length);
                            this.a0 = iArrU2;
                        }
                        iArrU2[i2] = i3;
                        i3 = 0;
                        i2++;
                        i = 0;
                    }
                    if (unsignedByte < 2048) {
                        i3 = (i3 << 8) | (unsignedByte >> 6) | 192;
                        i++;
                    } else {
                        int i4 = (i3 << 8) | (unsignedByte >> 12) | 224;
                        int i5 = i + 1;
                        if (i5 >= 4) {
                            if (i2 >= iArrU2.length) {
                                iArrU2 = U2(iArrU2, iArrU2.length);
                                this.a0 = iArrU2;
                            }
                            iArrU2[i2] = i4;
                            i4 = 0;
                            i2++;
                            i5 = 0;
                        }
                        i3 = (i4 << 8) | ((unsignedByte >> 6) & 63) | 128;
                        i = i5 + 1;
                    }
                    unsignedByte = (unsignedByte & 63) | 128;
                }
            }
            if (i < 4) {
                i++;
                i3 = unsignedByte | (i3 << 8);
            } else {
                if (i2 >= iArrU2.length) {
                    iArrU2 = U2(iArrU2, iArrU2.length);
                    this.a0 = iArrU2;
                }
                iArrU2[i2] = i3;
                i3 = unsignedByte;
                i2++;
                i = 1;
            }
            unsignedByte = this.d0.readUnsignedByte();
        }
        if (i > 0) {
            if (i2 >= iArrU2.length) {
                iArrU2 = U2(iArrU2, iArrU2.length);
                this.a0 = iArrU2;
            }
            iArrU2[i2] = O3(i3, i);
            i2++;
        }
        String strZ = this.Z.z(iArrU2, i2);
        return strZ == null ? J3(iArrU2, i2, i) : strZ;
    }

    @Override // defpackage.dz1
    protected char f2() throws IOException {
        int unsignedByte = this.d0.readUnsignedByte();
        if (unsignedByte == 34 || unsignedByte == 47 || unsignedByte == 92) {
            return (char) unsignedByte;
        }
        if (unsignedByte == 98) {
            return '\b';
        }
        if (unsignedByte == 102) {
            return '\f';
        }
        if (unsignedByte == 110) {
            return '\n';
        }
        if (unsignedByte == 114) {
            return '\r';
        }
        if (unsignedByte == 116) {
            return '\t';
        }
        if (unsignedByte != 117) {
            return l2((char) M2(unsignedByte));
        }
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int unsignedByte2 = this.d0.readUnsignedByte();
            int iB = ex.b(unsignedByte2);
            if (iB < 0) {
                L1(unsignedByte2, "expected a hex-digit for character escape sequence");
            }
            i = (i << 4) | iB;
        }
        return (char) i;
    }

    protected final JsonToken g3(boolean z, boolean z2) {
        if (!f1(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return a3(46);
        }
        char[] cArrM = this.G.m();
        int i = 0;
        if (z) {
            cArrM[0] = '-';
            i = 1;
        }
        return f3(cArrM, i, 46, z, 0);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte[] j0(Base64Variant base64Variant) throws JsonParseException {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING && (jsonToken != JsonToken.VALUE_EMBEDDED_OBJECT || this.K == null)) {
            D1("Current token (" + this.d + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.b0) {
            try {
                this.K = L2(base64Variant);
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

    protected final String k3(int i) throws IOException {
        if (i != 34) {
            return Z2(i);
        }
        int[] iArr = o0;
        int unsignedByte = this.d0.readUnsignedByte();
        if (iArr[unsignedByte] != 0) {
            return unsignedByte == 34 ? Constants.STR_EMPTY : Q3(0, unsignedByte, 0);
        }
        int unsignedByte2 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte2] != 0) {
            return unsignedByte2 == 34 ? K3(unsignedByte, 1) : Q3(unsignedByte, unsignedByte2, 1);
        }
        int i2 = (unsignedByte << 8) | unsignedByte2;
        int unsignedByte3 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte3] != 0) {
            return unsignedByte3 == 34 ? K3(i2, 2) : Q3(i2, unsignedByte3, 2);
        }
        int i3 = (i2 << 8) | unsignedByte3;
        int unsignedByte4 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte4] != 0) {
            return unsignedByte4 == 34 ? K3(i3, 3) : Q3(i3, unsignedByte4, 3);
        }
        int i4 = (i3 << 8) | unsignedByte4;
        int unsignedByte5 = this.d0.readUnsignedByte();
        if (iArr[unsignedByte5] != 0) {
            return unsignedByte5 == 34 ? K3(i4, 4) : Q3(i4, unsignedByte5, 4);
        }
        this.c0 = i4;
        return i3(unsignedByte5);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String l1() throws IOException {
        JsonToken jsonTokenM3;
        this.L = 0;
        JsonToken jsonToken = this.d;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            c3();
            return null;
        }
        if (this.b0) {
            A3();
        }
        int iE3 = E3();
        this.K = null;
        this.x = this.u;
        if (iE3 == 93 || iE3 == 125) {
            K2(iE3);
            return null;
        }
        if (this.z.s()) {
            if (iE3 != 44) {
                L1(iE3, "was expecting comma to separate " + this.z.m() + " entries");
            }
            iE3 = E3();
            if ((this.a & f0) != 0 && (iE3 == 93 || iE3 == 125)) {
                K2(iE3);
                return null;
            }
        }
        if (!this.z.j()) {
            d3(iE3);
            return null;
        }
        String strK3 = k3(iE3);
        this.z.w(strK3);
        this.d = jsonToken2;
        int iW3 = w3();
        if (iW3 == 34) {
            this.b0 = true;
            this.F = JsonToken.VALUE_STRING;
            return strK3;
        }
        if (iW3 == 43) {
            jsonTokenM3 = f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? m3() : a3(iW3);
        } else if (iW3 == 91) {
            jsonTokenM3 = JsonToken.START_ARRAY;
        } else if (iW3 == 102) {
            b3("false", 1);
            jsonTokenM3 = JsonToken.VALUE_FALSE;
        } else if (iW3 == 110) {
            b3("null", 1);
            jsonTokenM3 = JsonToken.VALUE_NULL;
        } else if (iW3 == 116) {
            b3("true", 1);
            jsonTokenM3 = JsonToken.VALUE_TRUE;
        } else if (iW3 == 123) {
            jsonTokenM3 = JsonToken.START_OBJECT;
        } else if (iW3 != 45) {
            if (iW3 != 46) {
                switch (iW3) {
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
                        break;
                    default:
                        jsonTokenM3 = a3(iW3);
                        break;
                }
            } else {
                g3(false, false);
            }
            jsonTokenM3 = o3(iW3);
        } else {
            jsonTokenM3 = l3();
        }
        this.F = jsonTokenM3;
        return strK3;
    }

    protected final JsonToken l3() {
        return n3(true);
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
            return Q2();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this.z = this.z.p(this.x, this.y);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.z = this.z.q(this.x, this.y);
        }
        return null;
    }

    protected final JsonToken m3() {
        return n3(false);
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public JsonToken n1() throws IOException {
        JsonToken jsonTokenM3;
        if (this.f326q) {
            return null;
        }
        JsonToken jsonToken = this.d;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            return c3();
        }
        this.L = 0;
        if (this.b0) {
            A3();
        }
        int iG3 = G3();
        if (iG3 < 0) {
            close();
            this.d = null;
            return null;
        }
        this.K = null;
        this.x = this.u;
        if (iG3 == 93 || iG3 == 125) {
            K2(iG3);
            return this.d;
        }
        if (this.z.s()) {
            if (iG3 != 44) {
                L1(iG3, "was expecting comma to separate " + this.z.m() + " entries");
            }
            iG3 = E3();
            if ((this.a & f0) != 0 && (iG3 == 93 || iG3 == 125)) {
                K2(iG3);
                return this.d;
            }
        }
        if (!this.z.j()) {
            return d3(iG3);
        }
        this.z.w(k3(iG3));
        this.d = jsonToken2;
        int iW3 = w3();
        if (iW3 == 34) {
            this.b0 = true;
            this.F = JsonToken.VALUE_STRING;
            return this.d;
        }
        if (iW3 == 43) {
            jsonTokenM3 = f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? m3() : a3(iW3);
        } else if (iW3 == 91) {
            jsonTokenM3 = JsonToken.START_ARRAY;
        } else if (iW3 == 102) {
            b3("false", 1);
            jsonTokenM3 = JsonToken.VALUE_FALSE;
        } else if (iW3 == 110) {
            b3("null", 1);
            jsonTokenM3 = JsonToken.VALUE_NULL;
        } else if (iW3 == 116) {
            b3("true", 1);
            jsonTokenM3 = JsonToken.VALUE_TRUE;
        } else if (iW3 == 123) {
            jsonTokenM3 = JsonToken.START_OBJECT;
        } else if (iW3 == 45) {
            jsonTokenM3 = l3();
        } else if (iW3 != 46) {
            switch (iW3) {
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
                    jsonTokenM3 = o3(iW3);
                    break;
                default:
                    jsonTokenM3 = a3(iW3);
                    break;
            }
        } else {
            jsonTokenM3 = g3(false, false);
        }
        this.F = jsonTokenM3;
        return this.d;
    }

    protected JsonToken o3(int i) throws IOException {
        int unsignedByte;
        char[] cArrM = this.G.m();
        int i2 = 1;
        if (i == 48) {
            unsignedByte = Y2();
            if (unsignedByte <= 57 && unsignedByte >= 48) {
                i2 = 0;
            } else {
                if (unsignedByte == 120 || unsignedByte == 88) {
                    return W2(unsignedByte, false);
                }
                cArrM[0] = '0';
            }
        } else {
            cArrM[0] = (char) i;
            unsignedByte = this.d0.readUnsignedByte();
        }
        int unsignedByte2 = unsignedByte;
        char[] cArrP = cArrM;
        int i3 = i2;
        int i4 = i3;
        while (unsignedByte2 <= 57 && unsignedByte2 >= 48) {
            i4++;
            if (i3 >= cArrP.length) {
                cArrP = this.G.p();
                i3 = 0;
            }
            cArrP[i3] = (char) unsignedByte2;
            unsignedByte2 = this.d0.readUnsignedByte();
            i3++;
        }
        if (unsignedByte2 == 46 || unsignedByte2 == 101 || unsignedByte2 == 69) {
            return f3(cArrP, i3, unsignedByte2, false, i4);
        }
        this.G.E(i3);
        if (this.z.k()) {
            I3();
        } else {
            this.e0 = unsignedByte2;
        }
        return I2(false, i4);
    }

    protected int p3(Base64Variant base64Variant, OutputStream outputStream, byte[] bArr) throws IOException {
        int length = bArr.length - 3;
        int i = 0;
        int i2 = 0;
        while (true) {
            int unsignedByte = this.d0.readUnsignedByte();
            if (unsignedByte > 32) {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(unsignedByte);
                if (iDecodeBase64Char < 0) {
                    if (unsignedByte == 34) {
                        break;
                    }
                    iDecodeBase64Char = e2(base64Variant, unsignedByte, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (i > length) {
                    i2 += i;
                    outputStream.write(bArr, 0, i);
                    i = 0;
                }
                int unsignedByte2 = this.d0.readUnsignedByte();
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(unsignedByte2);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = e2(base64Variant, unsignedByte2, 1);
                }
                int i3 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                int unsignedByte3 = this.d0.readUnsignedByte();
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(unsignedByte3);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (unsignedByte3 == 34) {
                            int i4 = i + 1;
                            bArr[i] = (byte) (i3 >> 4);
                            if (base64Variant.usesPadding()) {
                                k2(base64Variant);
                            }
                            i = i4;
                            break;
                        }
                        iDecodeBase64Char3 = e2(base64Variant, unsignedByte3, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        int unsignedByte4 = this.d0.readUnsignedByte();
                        if (!base64Variant.usesPaddingChar(unsignedByte4) && (unsignedByte4 != 92 || e2(base64Variant, unsignedByte4, 3) != -2)) {
                            throw F2(base64Variant, unsignedByte4, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        bArr[i] = (byte) (i3 >> 4);
                        i++;
                    }
                }
                int i5 = (i3 << 6) | iDecodeBase64Char3;
                int unsignedByte5 = this.d0.readUnsignedByte();
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(unsignedByte5);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (unsignedByte5 == 34) {
                            int i6 = i + 1;
                            bArr[i] = (byte) (i5 >> 10);
                            i += 2;
                            bArr[i6] = (byte) (i5 >> 2);
                            if (!base64Variant.usesPadding()) {
                                break;
                            }
                            k2(base64Variant);
                            break;
                        }
                        iDecodeBase64Char4 = e2(base64Variant, unsignedByte5, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        int i7 = i + 1;
                        bArr[i] = (byte) (i5 >> 10);
                        i += 2;
                        bArr[i7] = (byte) (i5 >> 2);
                    }
                }
                int i8 = (i5 << 6) | iDecodeBase64Char4;
                bArr[i] = (byte) (i8 >> 16);
                int i9 = i + 2;
                bArr[i + 1] = (byte) (i8 >> 8);
                i += 3;
                bArr[i9] = (byte) i8;
            }
        }
        this.b0 = false;
        if (i <= 0) {
            return i2;
        }
        int i10 = i2 + i;
        outputStream.write(bArr, 0, i);
        return i10;
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
            return p3(base64Variant, outputStream, bArrD);
        } finally {
            this.p.o(bArrD);
        }
    }

    @Override // defpackage.dz1
    protected void q2() {
        super.q2();
        this.Z.G();
    }

    protected void q3(int i) {
        if (i < 32) {
            O1(i);
        }
        r3(i);
    }

    protected void r3(int i) {
        D1("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public jt1 t0() {
        return this.Y;
    }

    protected void t3(int i, String str) throws IOException {
        u3(i, str, u2());
    }

    protected void u3(int i, String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            char cM2 = (char) M2(i);
            if (!Character.isJavaIdentifierPart(cM2)) {
                D1("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
                return;
            }
            sb.append(cM2);
            i = this.d0.readUnsignedByte();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation w0() {
        return new JsonLocation(c2(), -1L, -1L, this.u, -1);
    }
}
