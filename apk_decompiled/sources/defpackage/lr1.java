package defpackage;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class lr1 extends kr1 {
    private static final int q0 = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int r0 = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int s0 = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int t0 = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int u0 = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int v0 = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int w0 = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    private static final int[] x0 = ex.j();
    protected static final int[] y0 = ex.h();

    protected lr1(oy0 oy0Var, int i, mp mpVar) {
        super(oy0Var, i, mpVar);
    }

    private final JsonToken L3() {
        int[] iArr = x0;
        char[] cArrR = this.G.r();
        int iT = this.G.t();
        int i = this.r;
        int i2 = this.s - 5;
        while (i < this.s) {
            int i3 = 0;
            if (iT >= cArrR.length) {
                cArrR = this.G.p();
                iT = 0;
            }
            int iMin = Math.min(this.s, (cArrR.length - iT) + i);
            while (i < iMin) {
                int i4 = i + 1;
                int iQ4 = q4(i) & 255;
                int i5 = iArr[iQ4];
                if (i5 != 0) {
                    if (iQ4 != 34) {
                        if (i4 < i2) {
                            if (i5 == 1) {
                                this.r = i4;
                                iQ4 = f3();
                                i = this.r;
                            } else if (i5 == 2) {
                                i += 2;
                                iQ4 = k3(iQ4, q4(i4));
                            } else if (i5 == 3) {
                                int i6 = i + 2;
                                i += 3;
                                iQ4 = l3(iQ4, q4(i4), q4(i6));
                            } else if (i5 != 4) {
                                if (iQ4 < 32) {
                                    t2(iQ4, "string value");
                                } else {
                                    U2(iQ4);
                                }
                                i = i4;
                            } else {
                                byte bQ4 = q4(i4);
                                int i7 = i + 3;
                                byte bQ5 = q4(i + 2);
                                i += 4;
                                int iM3 = m3(iQ4, bQ4, bQ5, q4(i7));
                                int i8 = iT + 1;
                                cArrR[iT] = (char) ((iM3 >> 10) | 55296);
                                if (i8 >= cArrR.length) {
                                    cArrR = this.G.p();
                                    iT = 0;
                                } else {
                                    iT = i8;
                                }
                                iQ4 = (iM3 & 1023) | 56320;
                            }
                            if (iT >= cArrR.length) {
                                cArrR = this.G.p();
                            } else {
                                i3 = iT;
                            }
                            iT = i3 + 1;
                            cArrR[i3] = (char) iQ4;
                            break;
                        }
                        this.r = i4;
                        this.G.E(iT);
                        if (h3(iQ4, iArr[iQ4], i4 < this.s)) {
                            cArrR = this.G.r();
                            iT = this.G.t();
                            i = this.r;
                            break;
                        }
                        this.j0 = 40;
                        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                        this.d = jsonToken;
                        return jsonToken;
                    }
                    this.r = i4;
                    this.G.E(iT);
                    return b3(JsonToken.VALUE_STRING);
                }
                cArrR[iT] = (char) iQ4;
                iT++;
                i = i4;
            }
        }
        this.r = i;
        this.i0 = 40;
        this.G.E(iT);
        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken2;
        return jsonToken2;
    }

    private JsonToken O3(int i, int i2, int i3) {
        int[] iArrD2 = this.Z;
        int[] iArrK = ex.k();
        while (true) {
            int i4 = this.r;
            if (i4 >= this.s) {
                this.a0 = i;
                this.c0 = i2;
                this.d0 = i3;
                this.i0 = 10;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.d = jsonToken;
                return jsonToken;
            }
            int iQ4 = q4(i4) & 255;
            if (iArrK[iQ4] != 0) {
                if (i3 > 0) {
                    if (i >= iArrD2.length) {
                        iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                        this.Z = iArrD2;
                    }
                    iArrD2[i] = i2;
                    i++;
                }
                String strZ = this.Y.z(iArrD2, i);
                if (strZ == null) {
                    strZ = J2(iArrD2, i, i3);
                }
                return N2(strZ);
            }
            this.r++;
            if (i3 < 4) {
                i3++;
                i2 = (i2 << 8) | iQ4;
            } else {
                if (i >= iArrD2.length) {
                    iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                    this.Z = iArrD2;
                }
                iArrD2[i] = i2;
                i++;
                i2 = iQ4;
                i3 = 1;
            }
        }
    }

    private JsonToken P3(int i) {
        if (i != 35) {
            if (i != 39) {
                if (i == 47) {
                    return i4(4);
                }
                if (i == 93) {
                    return K2();
                }
            } else if ((this.a & t0) != 0) {
                return o3(0, 0, 0);
            }
        } else if ((this.a & w0) != 0) {
            return y3(4);
        }
        if ((this.a & u0) == 0) {
            L1((char) i, "was expecting double-quote to start field name");
        }
        if (ex.k()[i] != 0) {
            L1(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        return O3(0, i, 1);
    }

    private final JsonToken Q3(int i, int i2, int i3) {
        int i4;
        int[] iArrD2 = this.Z;
        int[] iArr = y0;
        while (this.r < this.s) {
            int iS4 = s4();
            if (iArr[iS4] == 0) {
                if (i3 < 4) {
                    i3++;
                    i2 = (i2 << 8) | iS4;
                } else {
                    if (i >= iArrD2.length) {
                        int[] iArrD3 = dz1.D2(iArrD2, iArrD2.length);
                        this.Z = iArrD3;
                        iArrD2 = iArrD3;
                    }
                    i4 = i + 1;
                    iArrD2[i] = i2;
                    i = i4;
                    i2 = iS4;
                    i3 = 1;
                }
            } else {
                if (iS4 == 34) {
                    if (i3 > 0) {
                        if (i >= iArrD2.length) {
                            iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                            this.Z = iArrD2;
                        }
                        iArrD2[i] = kr1.T2(i2, i3);
                        i++;
                    } else if (i == 0) {
                        return N2(Constants.STR_EMPTY);
                    }
                    String strZ = this.Y.z(iArrD2, i);
                    if (strZ == null) {
                        strZ = J2(iArrD2, i, i3);
                    }
                    return N2(strZ);
                }
                if (iS4 != 92) {
                    t2(iS4, "name");
                } else {
                    iS4 = e3();
                    if (iS4 < 0) {
                        this.i0 = 8;
                        this.j0 = 7;
                        this.a0 = i;
                        this.c0 = i2;
                        this.d0 = i3;
                        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                        this.d = jsonToken;
                        return jsonToken;
                    }
                }
                if (i >= iArrD2.length) {
                    iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                    this.Z = iArrD2;
                }
                if (iS4 > 127) {
                    int i5 = 0;
                    if (i3 >= 4) {
                        iArrD2[i] = i2;
                        i++;
                        i2 = 0;
                        i3 = 0;
                    }
                    if (iS4 < 2048) {
                        i2 = (i2 << 8) | (iS4 >> 6) | 192;
                        i3++;
                    } else {
                        int i6 = (i2 << 8) | (iS4 >> 12) | 224;
                        int i7 = i3 + 1;
                        if (i7 >= 4) {
                            iArrD2[i] = i6;
                            i++;
                            i7 = 0;
                        } else {
                            i5 = i6;
                        }
                        i2 = (i5 << 8) | ((iS4 >> 6) & 63) | 128;
                        i3 = i7 + 1;
                    }
                    iS4 = (iS4 & 63) | 128;
                }
                if (i3 < 4) {
                    i3++;
                    i2 = (i2 << 8) | iS4;
                } else {
                    i4 = i + 1;
                    iArrD2[i] = i2;
                    i = i4;
                    i2 = iS4;
                    i3 = 1;
                }
            }
        }
        this.a0 = i;
        this.c0 = i2;
        this.d0 = i3;
        this.i0 = 7;
        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken2;
        return jsonToken2;
    }

    private final String R3(int i, int i2) {
        int[] iArr = y0;
        int i3 = i + 1;
        int iQ4 = q4(i) & 255;
        if (iArr[iQ4] != 0) {
            if (iQ4 != 34) {
                return null;
            }
            this.r = i3;
            return P2(this.b0, i2, 1);
        }
        int i4 = (i2 << 8) | iQ4;
        int i5 = i + 2;
        int iQ5 = q4(i3) & 255;
        if (iArr[iQ5] != 0) {
            if (iQ5 != 34) {
                return null;
            }
            this.r = i5;
            return P2(this.b0, i4, 2);
        }
        int i6 = (i4 << 8) | iQ5;
        int i7 = i + 3;
        int iQ6 = q4(i5) & 255;
        if (iArr[iQ6] != 0) {
            if (iQ6 != 34) {
                return null;
            }
            this.r = i7;
            return P2(this.b0, i6, 3);
        }
        int i8 = (i6 << 8) | iQ6;
        int i9 = i + 4;
        int iQ7 = q4(i7) & 255;
        if (iArr[iQ7] == 0) {
            return S3(i9, iQ7, i8);
        }
        if (iQ7 != 34) {
            return null;
        }
        this.r = i9;
        return P2(this.b0, i8, 4);
    }

    private final String S3(int i, int i2, int i3) {
        int[] iArr = y0;
        int i4 = i + 1;
        int iQ4 = q4(i) & 255;
        if (iArr[iQ4] != 0) {
            if (iQ4 != 34) {
                return null;
            }
            this.r = i4;
            return Q2(this.b0, i3, i2, 1);
        }
        int i5 = (i2 << 8) | iQ4;
        int i6 = i + 2;
        int iQ5 = q4(i4) & 255;
        if (iArr[iQ5] != 0) {
            if (iQ5 != 34) {
                return null;
            }
            this.r = i6;
            return Q2(this.b0, i3, i5, 2);
        }
        int i7 = (i5 << 8) | iQ5;
        int i8 = i + 3;
        int iQ6 = q4(i6) & 255;
        if (iArr[iQ6] != 0) {
            if (iQ6 != 34) {
                return null;
            }
            this.r = i8;
            return Q2(this.b0, i3, i7, 3);
        }
        int i9 = (i7 << 8) | iQ6;
        int i10 = i + 4;
        if ((q4(i8) & 255) != 34) {
            return null;
        }
        this.r = i10;
        return Q2(this.b0, i3, i9, 4);
    }

    private final int U3(int i) {
        do {
            if (i != 32) {
                if (i == 10) {
                    this.u++;
                    this.v = this.r;
                } else if (i == 13) {
                    this.n0++;
                    this.v = this.r;
                } else if (i != 9) {
                    O1(i);
                }
            }
            if (this.r >= this.s) {
                this.d = JsonToken.NOT_AVAILABLE;
                return 0;
            }
            i = s4();
        } while (i <= 32);
        return i;
    }

    private final JsonToken V3(int i) {
        if (this.r >= this.s) {
            this.i0 = i;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken;
            return jsonToken;
        }
        int iS4 = s4();
        if (i == 4) {
            return Z3(iS4);
        }
        if (i == 5) {
            return a4(iS4);
        }
        switch (i) {
            case 12:
                return m4(iS4);
            case 13:
                return p4(iS4);
            case 14:
                return o4(iS4);
            case 15:
                return n4(iS4);
            default:
                lb3.c();
                return null;
        }
    }

    private final JsonToken X3(int i) {
        int iS4 = i & 255;
        if (iS4 == 239 && this.i0 != 1) {
            return q3(1);
        }
        while (iS4 <= 32) {
            if (iS4 != 32) {
                if (iS4 == 10) {
                    this.u++;
                    this.v = this.r;
                } else if (iS4 == 13) {
                    this.n0++;
                    this.v = this.r;
                } else if (iS4 != 9) {
                    O1(iS4);
                }
            }
            if (this.r >= this.s) {
                this.i0 = 3;
                if (this.f326q) {
                    return null;
                }
                return this.k0 ? M2() : JsonToken.NOT_AVAILABLE;
            }
            iS4 = s4();
        }
        return m4(iS4);
    }

    private final JsonToken Z3(int i) {
        String strN3;
        if (i <= 32 && (i = U3(i)) <= 0) {
            this.i0 = 4;
            return this.d;
        }
        a3();
        if (i != 34) {
            return i == 125 ? L2() : P3(i);
        }
        return (this.r + 13 > this.s || (strN3 = n3()) == null) ? Q3(0, 0, 0) : N2(strN3);
    }

    private final JsonToken a4(int i) {
        String strN3;
        if (i <= 32 && (i = U3(i)) <= 0) {
            this.i0 = 5;
            return this.d;
        }
        if (i != 44) {
            if (i == 125) {
                return L2();
            }
            if (i == 35) {
                return y3(5);
            }
            if (i == 47) {
                return i4(5);
            }
            L1(i, "was expecting comma to separate " + this.z.m() + " entries");
        }
        int i2 = this.r;
        if (i2 >= this.s) {
            this.i0 = 4;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken;
            return jsonToken;
        }
        int iQ4 = q4(i2);
        this.r = i2 + 1;
        if (iQ4 <= 32 && (iQ4 = U3(iQ4)) <= 0) {
            this.i0 = 4;
            return this.d;
        }
        a3();
        if (iQ4 != 34) {
            return (iQ4 != 125 || (this.a & q0) == 0) ? P3(iQ4) : L2();
        }
        return (this.r + 13 > this.s || (strN3 = n3()) == null) ? Q3(0, 0, 0) : N2(strN3);
    }

    private final int e3() {
        return this.s - this.r < 5 ? g3(0, -1) : f3();
    }

    private final int f3() {
        int iB;
        byte bR4 = r4();
        if (bR4 == 34 || bR4 == 47 || bR4 == 92) {
            return (char) bR4;
        }
        if (bR4 == 98) {
            return 8;
        }
        if (bR4 == 102) {
            return 12;
        }
        if (bR4 == 110) {
            return 10;
        }
        if (bR4 == 114) {
            return 13;
        }
        if (bR4 == 116) {
            return 9;
        }
        if (bR4 != 117) {
            return l2((char) bR4);
        }
        byte bR5 = r4();
        int iB2 = ex.b(bR5);
        if (iB2 >= 0 && (iB = ex.b((bR5 = r4()))) >= 0) {
            int i = (iB2 << 4) | iB;
            byte bR6 = r4();
            int iB3 = ex.b(bR6);
            if (iB3 >= 0) {
                int i2 = (i << 4) | iB3;
                bR6 = r4();
                int iB4 = ex.b(bR6);
                if (iB4 >= 0) {
                    return (i2 << 4) | iB4;
                }
            }
            bR5 = bR6;
        }
        L1(bR5 & 255, "expected a hex-digit for character escape sequence");
        return -1;
    }

    private int g3(int i, int i2) {
        if (this.r >= this.s) {
            this.e0 = i;
            this.f0 = i2;
            return -1;
        }
        byte bR4 = r4();
        if (i2 == -1) {
            if (bR4 == 34 || bR4 == 47 || bR4 == 92) {
                return bR4;
            }
            if (bR4 == 98) {
                return 8;
            }
            if (bR4 == 102) {
                return 12;
            }
            if (bR4 == 110) {
                return 10;
            }
            if (bR4 == 114) {
                return 13;
            }
            if (bR4 == 116) {
                return 9;
            }
            if (bR4 != 117) {
                return l2((char) bR4);
            }
            if (this.r >= this.s) {
                this.f0 = 0;
                this.e0 = 0;
                return -1;
            }
            bR4 = r4();
            i2 = 0;
        }
        int iS4 = bR4 & 255;
        while (true) {
            int iB = ex.b(iS4);
            if (iB < 0) {
                L1(iS4 & 255, "expected a hex-digit for character escape sequence");
            }
            i = (i << 4) | iB;
            i2++;
            if (i2 == 4) {
                return i;
            }
            if (this.r >= this.s) {
                this.f0 = i2;
                this.e0 = i;
                return -1;
            }
            iS4 = s4();
        }
    }

    private final boolean h3(int i, int i2, boolean z) {
        if (i2 == 1) {
            int iG3 = g3(0, -1);
            if (iG3 < 0) {
                this.i0 = 41;
                return false;
            }
            this.G.a((char) iG3);
            return true;
        }
        if (i2 == 2) {
            if (z) {
                this.G.a((char) k3(i, r4()));
                return true;
            }
            this.i0 = 42;
            this.c0 = i;
            return false;
        }
        if (i2 == 3) {
            int i3 = i & 15;
            if (z) {
                return i3(i3, 1, r4());
            }
            this.i0 = 43;
            this.c0 = i3;
            this.d0 = 1;
            return false;
        }
        if (i2 != 4) {
            if (i < 32) {
                t2(i, "string value");
            } else {
                U2(i);
            }
            this.G.a((char) i);
            return true;
        }
        int i4 = i & 7;
        if (z) {
            return j3(i4, 1, r4());
        }
        this.c0 = i4;
        this.d0 = 1;
        this.i0 = 44;
        return false;
    }

    private final boolean i3(int i, int i2, int i3) {
        if (i2 == 1) {
            if ((i3 & 192) != 128) {
                X2(i3 & 255, this.r);
            }
            i = (i << 6) | (i3 & 63);
            if (this.r >= this.s) {
                this.i0 = 43;
                this.c0 = i;
                this.d0 = 2;
                return false;
            }
            i3 = r4();
        }
        if ((i3 & 192) != 128) {
            X2(i3 & 255, this.r);
        }
        this.G.a((char) ((i << 6) | (i3 & 63)));
        return true;
    }

    private final JsonToken i4(int i) {
        if ((this.a & v0) == 0) {
            L1(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.r >= this.s) {
            this.c0 = i;
            this.i0 = 51;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken;
            return jsonToken;
        }
        byte bR4 = r4();
        if (bR4 == 42) {
            return r3(i, false);
        }
        if (bR4 == 47) {
            return s3(i);
        }
        L1(bR4 & 255, "was expecting either '*' or '/' for a comment");
        return null;
    }

    private final boolean j3(int i, int i2, int i3) {
        if (i2 == 1) {
            if ((i3 & 192) != 128) {
                X2(i3 & 255, this.r);
            }
            i = (i << 6) | (i3 & 63);
            if (this.r >= this.s) {
                this.i0 = 44;
                this.c0 = i;
                this.d0 = 2;
                return false;
            }
            i3 = r4();
            i2 = 2;
        }
        if (i2 == 2) {
            if ((i3 & 192) != 128) {
                X2(i3 & 255, this.r);
            }
            i = (i << 6) | (i3 & 63);
            if (this.r >= this.s) {
                this.i0 = 44;
                this.c0 = i;
                this.d0 = 3;
                return false;
            }
            i3 = r4();
        }
        if ((i3 & 192) != 128) {
            X2(i3 & 255, this.r);
        }
        int i4 = ((i << 6) | (i3 & 63)) - 65536;
        this.G.a((char) ((i4 >> 10) | 55296));
        this.G.a((char) ((i4 & 1023) | 56320));
        return true;
    }

    private final int k3(int i, int i2) {
        if ((i2 & 192) != 128) {
            X2(i2 & 255, this.r);
        }
        return ((i & 31) << 6) | (i2 & 63);
    }

    private final int l3(int i, int i2, int i3) {
        int i4 = i & 15;
        if ((i2 & 192) != 128) {
            X2(i2 & 255, this.r);
        }
        int i5 = (i4 << 6) | (i2 & 63);
        if ((i3 & 192) != 128) {
            X2(i3 & 255, this.r);
        }
        return (i5 << 6) | (i3 & 63);
    }

    private final int m3(int i, int i2, int i3, int i4) {
        if ((i2 & 192) != 128) {
            X2(i2 & 255, this.r);
        }
        int i5 = ((i & 7) << 6) | (i2 & 63);
        if ((i3 & 192) != 128) {
            X2(i3 & 255, this.r);
        }
        int i6 = (i5 << 6) | (i3 & 63);
        if ((i4 & 192) != 128) {
            X2(i4 & 255, this.r);
        }
        return ((i6 << 6) | (i4 & 63)) - 65536;
    }

    private final JsonToken m4(int i) {
        if (i <= 32 && (i = U3(i)) <= 0) {
            this.i0 = 12;
            return this.d;
        }
        a3();
        this.z.s();
        if (i == 34) {
            return j4();
        }
        if (i == 35) {
            return y3(12);
        }
        if (i == 43) {
            return g4();
        }
        if (i == 91) {
            return Y2();
        }
        if (i == 93) {
            return K2();
        }
        if (i == 102) {
            return Y3();
        }
        if (i == 110) {
            return e4();
        }
        if (i == 116) {
            return k4();
        }
        if (i == 123) {
            return Z2();
        }
        if (i == 125) {
            return L2();
        }
        switch (i) {
            case 45:
                return d4();
            case 46:
                if (f1(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                    return c4();
                }
                break;
            case 47:
                return i4(12);
            case 48:
                return f4();
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                return h4(i);
        }
        return l4(false, i);
    }

    private final String n3() {
        int[] iArr = y0;
        int i = this.r;
        int i2 = i + 1;
        int iQ4 = q4(i) & 255;
        if (iArr[iQ4] != 0) {
            if (iQ4 != 34) {
                return null;
            }
            this.r = i2;
            return Constants.STR_EMPTY;
        }
        int i3 = i + 2;
        int iQ5 = q4(i2) & 255;
        if (iArr[iQ5] != 0) {
            if (iQ5 != 34) {
                return null;
            }
            this.r = i3;
            return O2(iQ4, 1);
        }
        int i4 = iQ5 | (iQ4 << 8);
        int i5 = i + 3;
        int iQ6 = q4(i3) & 255;
        if (iArr[iQ6] != 0) {
            if (iQ6 != 34) {
                return null;
            }
            this.r = i5;
            return O2(i4, 2);
        }
        int i6 = (i4 << 8) | iQ6;
        int i7 = i + 4;
        int iQ7 = q4(i5) & 255;
        if (iArr[iQ7] != 0) {
            if (iQ7 != 34) {
                return null;
            }
            this.r = i7;
            return O2(i6, 3);
        }
        int i8 = (i6 << 8) | iQ7;
        int i9 = i + 5;
        int iQ8 = q4(i7) & 255;
        if (iArr[iQ8] == 0) {
            this.b0 = i8;
            return R3(i9, iQ8);
        }
        if (iQ8 != 34) {
            return null;
        }
        this.r = i9;
        return O2(i8, 4);
    }

    private final JsonToken n4(int i) {
        if (i <= 32 && (i = U3(i)) <= 0) {
            this.i0 = 15;
            return this.d;
        }
        a3();
        if (i == 34) {
            return j4();
        }
        if (i == 35) {
            return y3(15);
        }
        if (i == 43) {
            return g4();
        }
        if (i == 45) {
            return d4();
        }
        if (i == 91) {
            return Y2();
        }
        if (i != 93) {
            if (i == 102) {
                return Y3();
            }
            if (i == 110) {
                return e4();
            }
            if (i == 116) {
                return k4();
            }
            if (i == 123) {
                return Z2();
            }
            if (i != 125) {
                switch (i) {
                    case 47:
                        return i4(15);
                    case 48:
                        return f4();
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        return h4(i);
                }
            }
            if ((this.a & q0) != 0) {
                return L2();
            }
        } else if ((this.a & q0) != 0) {
            return K2();
        }
        return l4(true, i);
    }

    private JsonToken o3(int i, int i2, int i3) {
        int[] iArrD2 = this.Z;
        int[] iArr = y0;
        while (this.r < this.s) {
            int iS4 = s4();
            if (iS4 == 39) {
                if (i3 > 0) {
                    if (i >= iArrD2.length) {
                        iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                        this.Z = iArrD2;
                    }
                    iArrD2[i] = kr1.T2(i2, i3);
                    i++;
                } else if (i == 0) {
                    return N2(Constants.STR_EMPTY);
                }
                String strZ = this.Y.z(iArrD2, i);
                if (strZ == null) {
                    strZ = J2(iArrD2, i, i3);
                }
                return N2(strZ);
            }
            if (iS4 != 34 && iArr[iS4] != 0) {
                if (iS4 != 92) {
                    t2(iS4, "name");
                } else {
                    iS4 = e3();
                    if (iS4 < 0) {
                        this.i0 = 8;
                        this.j0 = 9;
                        this.a0 = i;
                        this.c0 = i2;
                        this.d0 = i3;
                        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                        this.d = jsonToken;
                        return jsonToken;
                    }
                }
                if (iS4 > 127) {
                    int i4 = 0;
                    if (i3 >= 4) {
                        if (i >= iArrD2.length) {
                            iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                            this.Z = iArrD2;
                        }
                        iArrD2[i] = i2;
                        i++;
                        i2 = 0;
                        i3 = 0;
                    }
                    if (iS4 < 2048) {
                        i2 = (i2 << 8) | (iS4 >> 6) | 192;
                        i3++;
                    } else {
                        int i5 = (i2 << 8) | (iS4 >> 12) | 224;
                        int i6 = i3 + 1;
                        if (i6 >= 4) {
                            if (i >= iArrD2.length) {
                                iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                                this.Z = iArrD2;
                            }
                            iArrD2[i] = i5;
                            i++;
                            i6 = 0;
                        } else {
                            i4 = i5;
                        }
                        i2 = (i4 << 8) | ((iS4 >> 6) & 63) | 128;
                        i3 = i6 + 1;
                    }
                    iS4 = (iS4 & 63) | 128;
                }
            }
            if (i3 < 4) {
                i3++;
                i2 = (i2 << 8) | iS4;
            } else {
                if (i >= iArrD2.length) {
                    iArrD2 = dz1.D2(iArrD2, iArrD2.length);
                    this.Z = iArrD2;
                }
                iArrD2[i] = i2;
                i++;
                i2 = iS4;
                i3 = 1;
            }
        }
        this.a0 = i;
        this.c0 = i2;
        this.d0 = i3;
        this.i0 = 9;
        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken2;
        return jsonToken2;
    }

    private final JsonToken o4(int i) {
        if (i <= 32 && (i = U3(i)) <= 0) {
            this.i0 = 14;
            return this.d;
        }
        if (i != 58) {
            if (i == 47) {
                return i4(14);
            }
            if (i == 35) {
                return y3(14);
            }
            L1(i, "was expecting a colon to separate field name and value");
        }
        int i2 = this.r;
        if (i2 >= this.s) {
            this.i0 = 12;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken;
            return jsonToken;
        }
        int iQ4 = q4(i2);
        this.r = i2 + 1;
        if (iQ4 <= 32 && (iQ4 = U3(iQ4)) <= 0) {
            this.i0 = 12;
            return this.d;
        }
        a3();
        if (iQ4 == 34) {
            return j4();
        }
        if (iQ4 == 35) {
            return y3(12);
        }
        if (iQ4 == 43) {
            return g4();
        }
        if (iQ4 == 45) {
            return d4();
        }
        if (iQ4 == 91) {
            return Y2();
        }
        if (iQ4 == 102) {
            return Y3();
        }
        if (iQ4 == 110) {
            return e4();
        }
        if (iQ4 == 116) {
            return k4();
        }
        if (iQ4 == 123) {
            return Z2();
        }
        switch (iQ4) {
            case 47:
                return i4(12);
            case 48:
                return f4();
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                return h4(iQ4);
            default:
                return l4(false, iQ4);
        }
    }

    private final JsonToken p3() {
        int[] iArr = x0;
        char[] cArrR = this.G.r();
        int iT = this.G.t();
        int i = this.r;
        int i2 = this.s - 5;
        while (i < this.s) {
            int i3 = 0;
            if (iT >= cArrR.length) {
                cArrR = this.G.p();
                iT = 0;
            }
            int iMin = Math.min(this.s, (cArrR.length - iT) + i);
            while (i < iMin) {
                int i4 = i + 1;
                int iQ4 = q4(i) & 255;
                int i5 = iArr[iQ4];
                if (i5 != 0 && iQ4 != 34) {
                    if (i4 < i2) {
                        if (i5 == 1) {
                            this.r = i4;
                            iQ4 = f3();
                            i = this.r;
                        } else if (i5 == 2) {
                            i += 2;
                            iQ4 = k3(iQ4, q4(i4));
                        } else if (i5 == 3) {
                            int i6 = i + 2;
                            i += 3;
                            iQ4 = l3(iQ4, q4(i4), q4(i6));
                        } else if (i5 != 4) {
                            if (iQ4 < 32) {
                                t2(iQ4, "string value");
                            } else {
                                U2(iQ4);
                            }
                            i = i4;
                        } else {
                            byte bQ4 = q4(i4);
                            int i7 = i + 3;
                            byte bQ5 = q4(i + 2);
                            i += 4;
                            int iM3 = m3(iQ4, bQ4, bQ5, q4(i7));
                            int i8 = iT + 1;
                            cArrR[iT] = (char) ((iM3 >> 10) | 55296);
                            if (i8 >= cArrR.length) {
                                cArrR = this.G.p();
                                iT = 0;
                            } else {
                                iT = i8;
                            }
                            iQ4 = (iM3 & 1023) | 56320;
                        }
                        if (iT >= cArrR.length) {
                            cArrR = this.G.p();
                        } else {
                            i3 = iT;
                        }
                        iT = i3 + 1;
                        cArrR[i3] = (char) iQ4;
                        break;
                    }
                    this.r = i4;
                    this.G.E(iT);
                    if (h3(iQ4, iArr[iQ4], i4 < this.s)) {
                        cArrR = this.G.r();
                        iT = this.G.t();
                        i = this.r;
                        break;
                    }
                    this.j0 = 45;
                    JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                    this.d = jsonToken;
                    return jsonToken;
                }
                if (iQ4 == 39) {
                    this.r = i4;
                    this.G.E(iT);
                    return b3(JsonToken.VALUE_STRING);
                }
                cArrR[iT] = (char) iQ4;
                iT++;
                i = i4;
            }
        }
        this.r = i;
        this.i0 = 45;
        this.G.E(iT);
        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken2;
        return jsonToken2;
    }

    private final JsonToken p4(int i) {
        if (i <= 32 && (i = U3(i)) <= 0) {
            this.i0 = 13;
            return this.d;
        }
        if (i != 44) {
            if (i == 93) {
                return K2();
            }
            if (i == 125) {
                return L2();
            }
            if (i == 47) {
                return i4(13);
            }
            if (i == 35) {
                return y3(13);
            }
            L1(i, "was expecting comma to separate " + this.z.m() + " entries");
        }
        this.z.s();
        int i2 = this.r;
        if (i2 >= this.s) {
            this.i0 = 15;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken;
            return jsonToken;
        }
        int iQ4 = q4(i2);
        this.r = i2 + 1;
        if (iQ4 <= 32 && (iQ4 = U3(iQ4)) <= 0) {
            this.i0 = 15;
            return this.d;
        }
        a3();
        if (iQ4 == 34) {
            return j4();
        }
        if (iQ4 == 35) {
            return y3(15);
        }
        if (iQ4 == 43) {
            return g4();
        }
        if (iQ4 == 45) {
            return d4();
        }
        if (iQ4 == 91) {
            return Y2();
        }
        if (iQ4 != 93) {
            if (iQ4 == 102) {
                return Y3();
            }
            if (iQ4 == 110) {
                return e4();
            }
            if (iQ4 == 116) {
                return k4();
            }
            if (iQ4 == 123) {
                return Z2();
            }
            if (iQ4 != 125) {
                switch (iQ4) {
                    case 47:
                        return i4(15);
                    case 48:
                        return f4();
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        return h4(iQ4);
                }
            }
            if ((this.a & q0) != 0) {
                return L2();
            }
        } else if ((this.a & q0) != 0) {
            return K2();
        }
        return l4(true, iQ4);
    }

    private final JsonToken q3(int i) throws JsonParseException {
        while (this.r < this.s) {
            int iS4 = s4();
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.t -= 3;
                        return X3(iS4);
                    }
                } else if (iS4 != 191) {
                    E1("Unexpected byte 0x%02x following 0xEF 0xBB; should get 0xBF as third byte of UTF-8 BOM", Integer.valueOf(iS4));
                }
            } else if (iS4 != 187) {
                E1("Unexpected byte 0x%02x following 0xEF; should get 0xBB as second byte UTF-8 BOM", Integer.valueOf(iS4));
            }
            i++;
        }
        this.c0 = i;
        this.i0 = 1;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken;
        return jsonToken;
    }

    private final JsonToken r3(int i, boolean z) {
        while (this.r < this.s) {
            int iS4 = s4();
            if (iS4 < 32) {
                if (iS4 == 10) {
                    this.u++;
                    this.v = this.r;
                } else if (iS4 == 13) {
                    this.n0++;
                    this.v = this.r;
                } else if (iS4 != 9) {
                    O1(iS4);
                }
            } else if (iS4 == 42) {
                z = true;
            } else if (iS4 == 47 && z) {
                return V3(i);
            }
            z = false;
        }
        this.i0 = z ? 52 : 53;
        this.c0 = i;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken;
        return jsonToken;
    }

    private final JsonToken s3(int i) {
        while (this.r < this.s) {
            int iS4 = s4();
            if (iS4 < 32) {
                if (iS4 == 10) {
                    this.u++;
                    this.v = this.r;
                } else if (iS4 == 13) {
                    this.n0++;
                    this.v = this.r;
                } else if (iS4 != 9) {
                    O1(iS4);
                }
                return V3(i);
            }
        }
        this.i0 = 54;
        this.c0 = i;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken;
        return jsonToken;
    }

    private final JsonToken y3(int i) {
        if ((this.a & w0) == 0) {
            L1(35, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_YAML_COMMENTS' not enabled for parser)");
        }
        while (this.r < this.s) {
            int iS4 = s4();
            if (iS4 < 32) {
                if (iS4 == 10) {
                    this.u++;
                    this.v = this.r;
                } else if (iS4 == 13) {
                    this.n0++;
                    this.v = this.r;
                } else if (iS4 != 9) {
                    O1(iS4);
                }
                return V3(i);
            }
        }
        this.i0 = 55;
        this.c0 = i;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken;
        return jsonToken;
    }

    protected JsonToken A3(String str, int i, JsonToken jsonToken) {
        if (i == str.length()) {
            this.d = jsonToken;
            return jsonToken;
        }
        this.G.y(str, 0, i);
        return u3();
    }

    protected JsonToken B3(int i, int i2) {
        String strS2 = S2(i);
        int length = strS2.length();
        while (true) {
            int i3 = this.r;
            if (i3 >= this.s) {
                this.l0 = i;
                this.c0 = i2;
                this.i0 = 19;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.d = jsonToken;
                return jsonToken;
            }
            char cQ4 = q4(i3);
            if (i2 == length) {
                if (cQ4 >= '0' && cQ4 != ']' && cQ4 != '}') {
                    break;
                }
                return d3(i);
            }
            if (cQ4 != strS2.charAt(i2)) {
                break;
            }
            i2++;
            this.r++;
        }
        this.i0 = 50;
        this.G.y(strS2, 0, i2);
        return t3();
    }

    protected JsonToken C3(int i, int i2) {
        String strS2 = S2(i);
        if (i2 == strS2.length()) {
            return d3(i);
        }
        this.G.y(strS2, 0, i2);
        return u3();
    }

    protected JsonToken D3(char[] cArr, int i) {
        int i2 = this.T ? -1 : 0;
        while (true) {
            int i3 = this.r;
            if (i3 >= this.s) {
                this.i0 = 26;
                this.G.E(i);
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.d = jsonToken;
                return jsonToken;
            }
            int iQ4 = q4(i3) & 255;
            if (iQ4 < 48) {
                if (iQ4 != 46) {
                    break;
                }
                this.U = i2 + i;
                this.r++;
                return b4(cArr, i, iQ4);
            }
            if (iQ4 > 57) {
                if (iQ4 != 101 && iQ4 != 69) {
                    break;
                }
                this.U = i2 + i;
                this.r++;
                return b4(cArr, i, iQ4);
            }
            this.r++;
            if (i >= cArr.length) {
                cArr = this.G.o();
            }
            cArr[i] = (char) iQ4;
            i++;
        }
        this.U = i2 + i;
        this.G.E(i);
        return b3(JsonToken.VALUE_NUMBER_INT);
    }

    protected JsonToken E3() {
        return F3(true);
    }

    protected JsonToken F3(boolean z) {
        while (this.r < this.s) {
            int iS4 = s4();
            if (iS4 < 48) {
                if (iS4 == 46) {
                    char[] cArrM = this.G.m();
                    cArrM[0] = z ? '-' : '+';
                    cArrM[1] = '0';
                    this.U = 1;
                    return b4(cArrM, 2, iS4);
                }
            } else if (iS4 <= 57) {
                if ((this.a & r0) == 0) {
                    T1("Leading zeroes not allowed");
                }
                if (iS4 != 48) {
                    char[] cArrM2 = this.G.m();
                    cArrM2[0] = z ? '-' : '+';
                    cArrM2[1] = (char) iS4;
                    this.U = 1;
                    return D3(cArrM2, 2);
                }
            } else {
                if (iS4 == 101 || iS4 == 69) {
                    char[] cArrM3 = this.G.m();
                    cArrM3[0] = z ? '-' : '+';
                    cArrM3[1] = '0';
                    this.U = 1;
                    return b4(cArrM3, 2, iS4);
                }
                if (iS4 != 93 && iS4 != 125) {
                    M1(iS4, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
                }
            }
            this.r--;
            return c3(0, "0");
        }
        this.i0 = z ? 25 : 24;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken;
        return jsonToken;
    }

    protected JsonToken G3() {
        return F3(false);
    }

    protected JsonToken H3() {
        while (this.r < this.s) {
            int iS4 = s4();
            if (iS4 < 48) {
                if (iS4 == 46) {
                    char[] cArrM = this.G.m();
                    cArrM[0] = '0';
                    this.U = 1;
                    return b4(cArrM, 1, iS4);
                }
            } else if (iS4 <= 57) {
                if ((this.a & r0) == 0) {
                    T1("Leading zeroes not allowed");
                }
                if (iS4 != 48) {
                    char[] cArrM2 = this.G.m();
                    cArrM2[0] = (char) iS4;
                    this.U = 1;
                    return D3(cArrM2, 1);
                }
            } else {
                if (iS4 == 101 || iS4 == 69) {
                    char[] cArrM3 = this.G.m();
                    cArrM3[0] = '0';
                    this.U = 1;
                    return b4(cArrM3, 1, iS4);
                }
                if (iS4 != 93 && iS4 != 125) {
                    M1(iS4, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
                }
            }
            this.r--;
            return c3(0, "0");
        }
        this.i0 = 24;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken;
        return jsonToken;
    }

    protected JsonToken I3(int i) {
        return K3(i, true);
    }

    protected JsonToken J3(int i) {
        return K3(i, false);
    }

    protected JsonToken K3(int i, boolean z) {
        if (i <= 48) {
            if (i == 48) {
                if (z) {
                    return E3();
                }
                if (!f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                    M1(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
                }
                return G3();
            }
            if (i == 46 && f1(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                if (z) {
                    this.r--;
                    return E3();
                }
                if (!f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                    M1(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
                }
                this.r--;
                return G3();
            }
            M1(i, z ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
        } else if (i > 57) {
            if (i == 73) {
                return B3(z ? 3 : 2, 2);
            }
            M1(i, z ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
        }
        if (!z && !f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
            M1(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        }
        char[] cArrM = this.G.m();
        cArrM[0] = z ? '-' : '+';
        cArrM[1] = (char) i;
        this.U = 1;
        return D3(cArrM, 2);
    }

    protected final JsonToken M3() {
        int i = this.i0;
        if (i == 1) {
            return q3(this.c0);
        }
        if (i == 4) {
            return Z3(s4());
        }
        if (i == 5) {
            return a4(s4());
        }
        switch (i) {
            case 7:
                return Q3(this.a0, this.c0, this.d0);
            case 8:
                return v3();
            case 9:
                return o3(this.a0, this.c0, this.d0);
            case 10:
                return O3(this.a0, this.c0, this.d0);
            default:
                switch (i) {
                    case 12:
                        return m4(s4());
                    case 13:
                        return p4(s4());
                    case 14:
                        return o4(s4());
                    case 15:
                        return n4(s4());
                    case 16:
                        return z3("null", this.c0, JsonToken.VALUE_NULL);
                    case 17:
                        return z3("true", this.c0, JsonToken.VALUE_TRUE);
                    case 18:
                        return z3("false", this.c0, JsonToken.VALUE_FALSE);
                    case 19:
                        return B3(this.l0, this.c0);
                    default:
                        switch (i) {
                            case 22:
                                return J3(s4());
                            case 23:
                                return I3(s4());
                            case 24:
                                return H3();
                            case 25:
                                return E3();
                            case 26:
                                return D3(this.G.r(), this.G.t());
                            default:
                                switch (i) {
                                    case 30:
                                        return x3();
                                    case 31:
                                        return w3(true, s4());
                                    case 32:
                                        return w3(false, s4());
                                    default:
                                        switch (i) {
                                            case 40:
                                                return L3();
                                            case 41:
                                                int iG3 = g3(this.e0, this.f0);
                                                if (iG3 < 0) {
                                                    return JsonToken.NOT_AVAILABLE;
                                                }
                                                this.G.a((char) iG3);
                                                return this.j0 == 45 ? p3() : L3();
                                            case 42:
                                                this.G.a((char) k3(this.c0, r4()));
                                                return this.j0 == 45 ? p3() : L3();
                                            case 43:
                                                if (i3(this.c0, this.d0, r4())) {
                                                    return this.j0 == 45 ? p3() : L3();
                                                }
                                                return JsonToken.NOT_AVAILABLE;
                                            case 44:
                                                if (j3(this.c0, this.d0, r4())) {
                                                    return this.j0 == 45 ? p3() : L3();
                                                }
                                                return JsonToken.NOT_AVAILABLE;
                                            case 45:
                                                return p3();
                                            default:
                                                switch (i) {
                                                    case 50:
                                                        return t3();
                                                    case 51:
                                                        return i4(this.c0);
                                                    case 52:
                                                        return r3(this.c0, true);
                                                    case 53:
                                                        return r3(this.c0, false);
                                                    case 54:
                                                        return s3(this.c0);
                                                    case 55:
                                                        return y3(this.c0);
                                                    default:
                                                        lb3.c();
                                                        return null;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected final JsonToken N3() {
        JsonToken jsonToken = this.d;
        int i = this.i0;
        if (i != 3 && i != 12) {
            if (i == 50) {
                return u3();
            }
            switch (i) {
                case 16:
                    return A3("null", this.c0, JsonToken.VALUE_NULL);
                case 17:
                    return A3("true", this.c0, JsonToken.VALUE_TRUE);
                case 18:
                    return A3("false", this.c0, JsonToken.VALUE_FALSE);
                case 19:
                    return C3(this.l0, this.c0);
                default:
                    switch (i) {
                        case 24:
                        case 25:
                            return c3(0, "0");
                        case 26:
                            int iT = this.G.t();
                            if (this.T) {
                                iT--;
                            }
                            this.U = iT;
                            return b3(JsonToken.VALUE_NUMBER_INT);
                        default:
                            switch (i) {
                                case 30:
                                    this.W = 0;
                                    return b3(JsonToken.VALUE_NUMBER_FLOAT);
                                case 31:
                                    I1(": was expecting fraction after exponent marker", JsonToken.VALUE_NUMBER_FLOAT);
                                    I1(": was expecting closing '*/' for comment", JsonToken.NOT_AVAILABLE);
                                    return M2();
                                case 32:
                                    return b3(JsonToken.VALUE_NUMBER_FLOAT);
                                default:
                                    switch (i) {
                                        case 52:
                                        case 53:
                                            I1(": was expecting closing '*/' for comment", JsonToken.NOT_AVAILABLE);
                                            break;
                                        case 54:
                                        case 55:
                                            break;
                                        default:
                                            I1(": was expecting rest of token (internal state: " + this.i0 + ")", this.d);
                                            return jsonToken;
                                    }
                                    return M2();
                            }
                    }
            }
        }
        return M2();
    }

    protected JsonToken T3(String str) {
        F1("Unrecognized token '%s': was expecting %s", this.G.l(), u2());
        return JsonToken.NOT_AVAILABLE;
    }

    protected JsonToken W3() {
        int i = this.r;
        char[] cArrM = this.G.m();
        int[] iArr = x0;
        int iMin = Math.min(this.s, cArrM.length + i);
        int i2 = 0;
        while (i < iMin) {
            int iQ4 = q4(i) & 255;
            if (iQ4 == 39) {
                this.r = i + 1;
                this.G.E(i2);
                return b3(JsonToken.VALUE_STRING);
            }
            if (iArr[iQ4] != 0) {
                break;
            }
            i++;
            cArrM[i2] = (char) iQ4;
            i2++;
        }
        this.G.E(i2);
        this.r = i;
        return p3();
    }

    protected JsonToken Y3() {
        int iQ4;
        int i = this.r;
        if (i + 4 < this.s) {
            int i2 = i + 1;
            if (q4(i) == 97) {
                int i3 = i + 2;
                if (q4(i2) == 108) {
                    int i4 = i + 3;
                    if (q4(i3) == 115) {
                        int i5 = i + 4;
                        if (q4(i4) == 101 && ((iQ4 = q4(i5) & 255) < 48 || iQ4 == 93 || iQ4 == 125)) {
                            this.r = i5;
                            return b3(JsonToken.VALUE_FALSE);
                        }
                    }
                }
            }
        }
        this.i0 = 18;
        return z3("false", 1, JsonToken.VALUE_FALSE);
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00f7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x00ee -> B:42:0x009e). Please report as a decompilation issue!!! */
    protected JsonToken b4(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        byte bR4;
        int i6 = 0;
        if (i2 == 46) {
            if (i >= cArr.length) {
                cArr = this.G.o();
            }
            cArr[i] = '.';
            i++;
            i4 = 0;
            while (true) {
                if (this.r >= this.s) {
                    this.G.E(i);
                    this.i0 = 30;
                    this.V = i4;
                    JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                    this.d = jsonToken;
                    return jsonToken;
                }
                bR4 = r4();
                if (bR4 < 48 || bR4 > 57) {
                    break;
                }
                if (i >= cArr.length) {
                    cArr = this.G.o();
                }
                cArr[i] = (char) bR4;
                i4++;
                i++;
            }
            i3 = bR4 & 255;
            if (i4 == 0 && !f1(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                M1(i3, "Decimal point not followed by a digit");
            }
        } else {
            i3 = i2;
            i4 = 0;
        }
        this.V = i4;
        if (i3 == 101 || i3 == 69) {
            if (i >= cArr.length) {
                cArr = this.G.o();
            }
            int i7 = i + 1;
            cArr[i] = (char) i3;
            if (this.r >= this.s) {
                this.G.E(i7);
                this.i0 = 31;
                this.W = 0;
                JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                this.d = jsonToken2;
                return jsonToken2;
            }
            byte bR5 = r4();
            if (bR5 == 45 || bR5 == 43) {
                if (i7 >= cArr.length) {
                    cArr = this.G.o();
                }
                i += 2;
                cArr[i7] = (char) bR5;
                if (this.r >= this.s) {
                    this.G.E(i);
                    this.i0 = 32;
                    this.W = 0;
                    JsonToken jsonToken3 = JsonToken.NOT_AVAILABLE;
                    this.d = jsonToken3;
                    return jsonToken3;
                }
                bR5 = r4();
            } else {
                i = i7;
            }
            if (bR5 >= 48 || bR5 > 57) {
                i5 = bR5 & 255;
                if (i6 == 0) {
                    M1(i5, "Exponent indicator not followed by a digit");
                }
            } else {
                i6++;
                if (i >= cArr.length) {
                    cArr = this.G.o();
                }
                i7 = i + 1;
                cArr[i] = (char) bR5;
                if (this.r >= this.s) {
                    this.G.E(i7);
                    this.i0 = 32;
                    this.W = i6;
                    JsonToken jsonToken4 = JsonToken.NOT_AVAILABLE;
                    this.d = jsonToken4;
                    return jsonToken4;
                }
                bR5 = r4();
                i = i7;
                if (bR5 >= 48) {
                }
                i5 = bR5 & 255;
                if (i6 == 0) {
                    M1(i5, "Exponent indicator not followed by a digit");
                }
            }
        }
        this.r--;
        this.G.E(i);
        this.W = i6;
        return b3(JsonToken.VALUE_NUMBER_FLOAT);
    }

    protected JsonToken c4() {
        this.T = false;
        this.U = 0;
        return b4(this.G.m(), 0, 46);
    }

    protected JsonToken d4() {
        this.T = true;
        if (this.r >= this.s) {
            this.i0 = 23;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken;
            return jsonToken;
        }
        int iS4 = s4();
        int i = 2;
        if (iS4 <= 48) {
            if (iS4 == 48) {
                return E3();
            }
            M1(iS4, "expected digit (0-9) to follow minus sign, for valid numeric value");
        } else if (iS4 > 57) {
            if (iS4 == 73) {
                return B3(3, 2);
            }
            M1(iS4, "expected digit (0-9) to follow minus sign, for valid numeric value");
        }
        char[] cArrM = this.G.m();
        cArrM[0] = '-';
        cArrM[1] = (char) iS4;
        int i2 = this.r;
        if (i2 >= this.s) {
            this.i0 = 26;
            this.G.E(2);
            this.U = 1;
            JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken2;
            return jsonToken2;
        }
        int iQ4 = q4(i2);
        while (iQ4 >= 48) {
            if (iQ4 > 57) {
                if (iQ4 == 101 || iQ4 == 69) {
                    this.U = i - 1;
                    this.r++;
                    return b4(cArrM, i, iQ4);
                }
                this.U = i - 1;
                this.G.E(i);
                return b3(JsonToken.VALUE_NUMBER_INT);
            }
            if (i >= cArrM.length) {
                cArrM = this.G.o();
            }
            int i3 = i + 1;
            cArrM[i] = (char) iQ4;
            int i4 = this.r + 1;
            this.r = i4;
            if (i4 >= this.s) {
                this.i0 = 26;
                this.G.E(i3);
                JsonToken jsonToken3 = JsonToken.NOT_AVAILABLE;
                this.d = jsonToken3;
                return jsonToken3;
            }
            iQ4 = q4(i4) & 255;
            i = i3;
        }
        if (iQ4 == 46) {
            this.U = i - 1;
            this.r++;
            return b4(cArrM, i, iQ4);
        }
        this.U = i - 1;
        this.G.E(i);
        return b3(JsonToken.VALUE_NUMBER_INT);
    }

    protected JsonToken e4() {
        int iQ4;
        int i = this.r;
        if (i + 3 < this.s) {
            int i2 = i + 1;
            if (q4(i) == 117) {
                int i3 = i + 2;
                if (q4(i2) == 108) {
                    int i4 = i + 3;
                    if (q4(i3) == 108 && ((iQ4 = q4(i4) & 255) < 48 || iQ4 == 93 || iQ4 == 125)) {
                        this.r = i4;
                        return b3(JsonToken.VALUE_NULL);
                    }
                }
            }
        }
        this.i0 = 16;
        return z3("null", 1, JsonToken.VALUE_NULL);
    }

    @Override // defpackage.dz1
    protected char f2() {
        lb3.c();
        return ' ';
    }

    protected JsonToken f4() {
        int i = this.r;
        if (i >= this.s) {
            this.i0 = 24;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken;
            return jsonToken;
        }
        int i2 = i + 1;
        int iQ4 = q4(i) & 255;
        if (iQ4 < 48) {
            if (iQ4 == 46) {
                this.r = i2;
                this.U = 1;
                char[] cArrM = this.G.m();
                cArrM[0] = '0';
                return b4(cArrM, 1, iQ4);
            }
        } else {
            if (iQ4 <= 57) {
                return H3();
            }
            if (iQ4 == 101 || iQ4 == 69) {
                this.r = i2;
                this.U = 1;
                char[] cArrM2 = this.G.m();
                cArrM2[0] = '0';
                return b4(cArrM2, 1, iQ4);
            }
            if (iQ4 != 93 && iQ4 != 125) {
                M1(iQ4, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
            }
        }
        return c3(0, "0");
    }

    protected JsonToken g4() {
        this.T = false;
        if (this.r >= this.s) {
            this.i0 = 22;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken;
            return jsonToken;
        }
        int iS4 = s4();
        int i = 2;
        if (iS4 <= 48) {
            if (iS4 == 48) {
                if (!f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                    M1(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
                }
                return G3();
            }
            M1(iS4, "expected digit (0-9) to follow plus sign, for valid numeric value");
        } else if (iS4 > 57) {
            if (iS4 == 73) {
                return B3(2, 2);
            }
            M1(iS4, "expected digit (0-9) to follow plus sign, for valid numeric value");
        }
        if (!f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
            M1(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        }
        char[] cArrM = this.G.m();
        cArrM[0] = '+';
        cArrM[1] = (char) iS4;
        int i2 = this.r;
        if (i2 >= this.s) {
            this.i0 = 26;
            this.G.E(2);
            this.U = 1;
            JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken2;
            return jsonToken2;
        }
        int iQ4 = q4(i2);
        while (iQ4 >= 48) {
            if (iQ4 > 57) {
                if (iQ4 == 101 || iQ4 == 69) {
                    this.U = i - 1;
                    this.r++;
                    return b4(cArrM, i, iQ4);
                }
                this.U = i - 1;
                this.G.E(i);
                return b3(JsonToken.VALUE_NUMBER_INT);
            }
            if (i >= cArrM.length) {
                cArrM = this.G.o();
            }
            int i3 = i + 1;
            cArrM[i] = (char) iQ4;
            int i4 = this.r + 1;
            this.r = i4;
            if (i4 >= this.s) {
                this.i0 = 26;
                this.G.E(i3);
                JsonToken jsonToken3 = JsonToken.NOT_AVAILABLE;
                this.d = jsonToken3;
                return jsonToken3;
            }
            iQ4 = q4(i4) & 255;
            i = i3;
        }
        if (iQ4 == 46) {
            this.U = i - 1;
            this.r++;
            return b4(cArrM, i, iQ4);
        }
        this.U = i - 1;
        this.G.E(i);
        return b3(JsonToken.VALUE_NUMBER_INT);
    }

    protected JsonToken h4(int i) {
        this.T = false;
        char[] cArrM = this.G.m();
        cArrM[0] = (char) i;
        int i2 = this.r;
        if (i2 >= this.s) {
            this.i0 = 26;
            this.G.E(1);
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.d = jsonToken;
            return jsonToken;
        }
        int iQ4 = q4(i2) & 255;
        int i3 = 1;
        while (iQ4 >= 48) {
            if (iQ4 > 57) {
                if (iQ4 == 101 || iQ4 == 69) {
                    this.U = i3;
                    this.r++;
                    return b4(cArrM, i3, iQ4);
                }
                this.U = i3;
                this.G.E(i3);
                return b3(JsonToken.VALUE_NUMBER_INT);
            }
            if (i3 >= cArrM.length) {
                cArrM = this.G.o();
            }
            int i4 = i3 + 1;
            cArrM[i3] = (char) iQ4;
            int i5 = this.r + 1;
            this.r = i5;
            if (i5 >= this.s) {
                this.i0 = 26;
                this.G.E(i4);
                JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                this.d = jsonToken2;
                return jsonToken2;
            }
            iQ4 = q4(i5) & 255;
            i3 = i4;
        }
        if (iQ4 == 46) {
            this.U = i3;
            this.r++;
            return b4(cArrM, i3, iQ4);
        }
        this.U = i3;
        this.G.E(i3);
        return b3(JsonToken.VALUE_NUMBER_INT);
    }

    protected JsonToken j4() {
        int i = this.r;
        char[] cArrM = this.G.m();
        int[] iArr = x0;
        int iMin = Math.min(this.s, cArrM.length + i);
        int i2 = 0;
        while (i < iMin) {
            int iQ4 = q4(i) & 255;
            if (iArr[iQ4] != 0) {
                if (iQ4 != 34) {
                    break;
                }
                this.r = i + 1;
                this.G.E(i2);
                return b3(JsonToken.VALUE_STRING);
            }
            i++;
            cArrM[i2] = (char) iQ4;
            i2++;
        }
        this.G.E(i2);
        this.r = i;
        return L3();
    }

    protected JsonToken k4() {
        int iQ4;
        int i = this.r;
        if (i + 3 < this.s) {
            int i2 = i + 1;
            if (q4(i) == 114) {
                int i3 = i + 2;
                if (q4(i2) == 117) {
                    int i4 = i + 3;
                    if (q4(i3) == 101 && ((iQ4 = q4(i4) & 255) < 48 || iQ4 == 93 || iQ4 == 125)) {
                        this.r = i4;
                        return b3(JsonToken.VALUE_TRUE);
                    }
                }
            }
        }
        this.i0 = 17;
        return z3("true", 1, JsonToken.VALUE_TRUE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x002d  */
    protected JsonToken l4(boolean z, int i) {
        if (i != 39) {
            if (i == 73) {
                return B3(1, 1);
            }
            if (i == 78) {
                return B3(0, 1);
            }
            if (i != 93) {
                if (i != 125) {
                    if (i == 43) {
                        return B3(2, 1);
                    }
                    if (i == 44) {
                        if (!this.z.k() && (this.a & s0) != 0) {
                            this.r--;
                            return b3(JsonToken.VALUE_NULL);
                        }
                    }
                }
            } else if (this.z.i()) {
                if (!this.z.k()) {
                    this.r--;
                    return b3(JsonToken.VALUE_NULL);
                }
            }
        } else if ((this.a & t0) != 0) {
            return W3();
        }
        L1(i, "expected a valid value " + v2());
        return null;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public JsonToken n1() {
        int i = this.r;
        if (i >= this.s) {
            if (this.f326q) {
                return null;
            }
            if (this.k0) {
                return this.d == JsonToken.NOT_AVAILABLE ? N3() : M2();
            }
            return JsonToken.NOT_AVAILABLE;
        }
        if (this.d == JsonToken.NOT_AVAILABLE) {
            return M3();
        }
        this.L = 0;
        this.w = this.t + ((long) i);
        this.K = null;
        int iS4 = s4();
        switch (this.g0) {
            case 0:
                return X3(iS4);
            case 1:
                return m4(iS4);
            case 2:
                return Z3(iS4);
            case 3:
                return a4(iS4);
            case 4:
                return o4(iS4);
            case 5:
                return m4(iS4);
            case 6:
                return p4(iS4);
            default:
                lb3.c();
                return null;
        }
    }

    protected abstract byte q4(int i);

    protected abstract byte r4();

    protected abstract int s4();

    protected JsonToken t3() {
        while (this.r < this.s) {
            char cR4 = (char) r4();
            if (Character.isJavaIdentifierPart(cR4)) {
                this.G.a(cR4);
                if (this.G.F() < 256) {
                }
            }
            return T3(this.G.l());
        }
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this.d = jsonToken;
        return jsonToken;
    }

    protected JsonToken u3() {
        return T3(this.G.l());
    }

    protected final JsonToken v3() {
        int i;
        int i2;
        int iG3 = g3(this.e0, this.f0);
        if (iG3 < 0) {
            this.i0 = 8;
            return JsonToken.NOT_AVAILABLE;
        }
        int i3 = this.a0;
        int[] iArr = this.Z;
        if (i3 >= iArr.length) {
            this.Z = dz1.D2(iArr, 32);
        }
        int i4 = this.c0;
        int i5 = this.d0;
        int i6 = 1;
        if (iG3 > 127) {
            int i7 = 0;
            if (i5 >= 4) {
                int[] iArr2 = this.Z;
                int i8 = this.a0;
                this.a0 = i8 + 1;
                iArr2[i8] = i4;
                i4 = 0;
                i5 = 0;
            }
            if (iG3 < 2048) {
                i = i4 << 8;
                i2 = (iG3 >> 6) | 192;
            } else {
                int i9 = (i4 << 8) | (iG3 >> 12) | 224;
                i5++;
                if (i5 >= 4) {
                    int[] iArr3 = this.Z;
                    int i10 = this.a0;
                    this.a0 = i10 + 1;
                    iArr3[i10] = i9;
                    i5 = 0;
                } else {
                    i7 = i9;
                }
                i = i7 << 8;
                i2 = ((iG3 >> 6) & 63) | 128;
            }
            i4 = i | i2;
            i5++;
            iG3 = (iG3 & 63) | 128;
        }
        if (i5 < 4) {
            i6 = 1 + i5;
            iG3 |= i4 << 8;
        } else {
            int[] iArr4 = this.Z;
            int i11 = this.a0;
            this.a0 = i11 + 1;
            iArr4[i11] = i4;
        }
        return this.j0 == 9 ? o3(this.a0, iG3, i6) : Q3(this.a0, iG3, i6);
    }

    protected JsonToken w3(boolean z, int i) {
        if (z) {
            this.i0 = 32;
            if (i == 45 || i == 43) {
                this.G.a((char) i);
                if (this.r >= this.s) {
                    this.i0 = 32;
                    this.W = 0;
                    return JsonToken.NOT_AVAILABLE;
                }
                i = r4();
            }
        }
        char[] cArrR = this.G.r();
        int iT = this.G.t();
        int i2 = this.W;
        while (i >= 48 && i <= 57) {
            i2++;
            if (iT >= cArrR.length) {
                cArrR = this.G.o();
            }
            int i3 = iT + 1;
            cArrR[iT] = (char) i;
            if (this.r >= this.s) {
                this.G.E(i3);
                this.W = i2;
                return JsonToken.NOT_AVAILABLE;
            }
            i = r4();
            iT = i3;
        }
        int i4 = i & 255;
        if (i2 == 0) {
            M1(i4, "Exponent indicator not followed by a digit");
        }
        this.r--;
        this.G.E(iT);
        this.W = i2;
        return b3(JsonToken.VALUE_NUMBER_FLOAT);
    }

    protected JsonToken x3() {
        int i = this.V;
        char[] cArrR = this.G.r();
        int iT = this.G.t();
        byte bR4 = r4();
        boolean z = true;
        while (z) {
            if (bR4 >= 48 && bR4 <= 57) {
                i++;
                if (iT >= cArrR.length) {
                    cArrR = this.G.o();
                }
                int i2 = iT + 1;
                cArrR[iT] = (char) bR4;
                if (this.r >= this.s) {
                    this.G.E(i2);
                    this.V = i;
                    return JsonToken.NOT_AVAILABLE;
                }
                bR4 = r4();
                iT = i2;
            } else if (bR4 == 102 || bR4 == 100 || bR4 == 70 || bR4 == 68) {
                M1(bR4, "JSON does not support parsing numbers that have 'f' or 'd' suffixes");
            } else if (bR4 == 46) {
                M1(bR4, "Cannot parse number with more than one decimal point");
            } else {
                z = false;
            }
        }
        if (i == 0 && !f1(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            M1(bR4, "Decimal point not followed by a digit");
        }
        this.V = i;
        this.G.E(iT);
        if (bR4 != 101 && bR4 != 69) {
            this.r--;
            this.G.E(iT);
            this.W = 0;
            return b3(JsonToken.VALUE_NUMBER_FLOAT);
        }
        this.G.a((char) bR4);
        this.W = 0;
        if (this.r >= this.s) {
            this.i0 = 31;
            return JsonToken.NOT_AVAILABLE;
        }
        this.i0 = 32;
        return w3(true, s4());
    }

    protected JsonToken z3(String str, int i, JsonToken jsonToken) {
        int length = str.length();
        while (true) {
            int i2 = this.r;
            if (i2 >= this.s) {
                this.c0 = i;
                JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                this.d = jsonToken2;
                return jsonToken2;
            }
            char cQ4 = q4(i2);
            if (i == length) {
                if (cQ4 >= '0' && cQ4 != ']' && cQ4 != '}') {
                    break;
                }
                return b3(jsonToken);
            }
            if (cQ4 != str.charAt(i)) {
                break;
            }
            i++;
            this.r++;
        }
        this.i0 = 50;
        this.G.y(str, 0, i);
        return t3();
    }
}
