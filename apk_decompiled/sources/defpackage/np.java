package defpackage;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.MatchStrength;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public final class np {
    private final oy0 a;
    private final InputStream b;
    private final byte[] c;
    private int d;
    private int e;
    private final boolean f;
    private boolean g;
    private int h;

    public np(oy0 oy0Var, InputStream inputStream) {
        this.g = true;
        this.a = oy0Var;
        this.b = inputStream;
        this.c = oy0Var.g();
        this.d = 0;
        this.e = 0;
        this.f = true;
    }

    private boolean a(int i) {
        if ((65280 & i) == 0) {
            this.g = true;
        } else {
            if ((i & 255) != 0) {
                return false;
            }
            this.g = false;
        }
        this.h = 2;
        return true;
    }

    private boolean b(int i) throws CharConversionException {
        if ((i >> 8) == 0) {
            this.g = true;
        } else if ((16777215 & i) == 0) {
            this.g = false;
        } else if (((-16711681) & i) == 0) {
            i("3412");
        } else {
            if ((i & (-65281)) != 0) {
                return false;
            }
            i("2143");
        }
        this.h = 4;
        return true;
    }

    private boolean g(int i) throws CharConversionException {
        if (i == -16842752) {
            i("3412");
        } else {
            if (i == -131072) {
                this.d += 4;
                this.h = 4;
                this.g = false;
                return true;
            }
            if (i == 65279) {
                this.g = true;
                this.d += 4;
                this.h = 4;
                return true;
            }
            if (i == 65534) {
                i("2143");
            }
        }
        int i2 = i >>> 16;
        if (i2 == 65279) {
            this.d += 2;
            this.h = 2;
            this.g = true;
            return true;
        }
        if (i2 == 65534) {
            this.d += 2;
            this.h = 2;
            this.g = false;
            return true;
        }
        if ((i >>> 8) != 15711167) {
            return false;
        }
        this.d += 3;
        this.h = 1;
        this.g = true;
        return true;
    }

    public static MatchStrength h(m21 m21Var) {
        if (!m21Var.b()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte bA = m21Var.a();
        if (bA == -17) {
            if (!m21Var.b()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (m21Var.a() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!m21Var.b()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (m21Var.a() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!m21Var.b()) {
                return MatchStrength.INCONCLUSIVE;
            }
            bA = m21Var.a();
        }
        int iK = k(m21Var, bA);
        if (iK < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        if (iK == 123) {
            int iJ = j(m21Var);
            if (iJ < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            return (iJ == 34 || iJ == 125) ? MatchStrength.SOLID_MATCH : MatchStrength.NO_MATCH;
        }
        if (iK == 91) {
            int iJ2 = j(m21Var);
            if (iJ2 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            return (iJ2 == 93 || iJ2 == 91) ? MatchStrength.SOLID_MATCH : MatchStrength.SOLID_MATCH;
        }
        MatchStrength matchStrength = MatchStrength.WEAK_MATCH;
        if (iK == 34) {
            return matchStrength;
        }
        if (iK <= 57 && iK >= 48) {
            return matchStrength;
        }
        if (iK == 45) {
            int iJ3 = j(m21Var);
            if (iJ3 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            return (iJ3 > 57 || iJ3 < 48) ? MatchStrength.NO_MATCH : matchStrength;
        }
        if (iK == 110) {
            return m(m21Var, "ull", matchStrength);
        }
        if (iK == 116) {
            return m(m21Var, "rue", matchStrength);
        }
        return iK == 102 ? m(m21Var, "alse", matchStrength) : MatchStrength.NO_MATCH;
    }

    private void i(String str) throws CharConversionException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    private static int j(m21 m21Var) {
        if (m21Var.b()) {
            return k(m21Var, m21Var.a());
        }
        return -1;
    }

    private static int k(m21 m21Var, byte b) {
        while (true) {
            int i = b & 255;
            if (i != 32 && i != 13 && i != 10 && i != 9) {
                return i;
            }
            if (!m21Var.b()) {
                return -1;
            }
            b = m21Var.a();
        }
    }

    public static int l(DataInput dataInput) {
        int unsignedByte = dataInput.readUnsignedByte();
        if (unsignedByte != 239) {
            return unsignedByte;
        }
        int unsignedByte2 = dataInput.readUnsignedByte();
        if (unsignedByte2 != 187) {
            throw new IOException("Unexpected byte 0x" + Integer.toHexString(unsignedByte2) + " following 0xEF; should get 0xBB as part of UTF-8 BOM");
        }
        int unsignedByte3 = dataInput.readUnsignedByte();
        if (unsignedByte3 == 191) {
            return dataInput.readUnsignedByte();
        }
        throw new IOException("Unexpected byte 0x" + Integer.toHexString(unsignedByte3) + " following 0xEF 0xBB; should get 0xBF as part of UTF-8 BOM");
    }

    private static MatchStrength m(m21 m21Var, String str, MatchStrength matchStrength) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!m21Var.b()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (m21Var.a() != str.charAt(i)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }

    public JsonParser c(int i, jt1 jt1Var, mp mpVar, fx fxVar, int i2) {
        int i3 = this.d;
        JsonEncoding jsonEncodingE = e();
        int i4 = this.d - i3;
        if (jsonEncodingE != JsonEncoding.UTF8 || !JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i2)) {
            return new dd2(this.a, i, d(), jt1Var, fxVar.n(i2));
        }
        return new g83(this.a, i, this.b, jt1Var, mpVar.A(i2), this.c, this.d, this.e, i4, this.f);
    }

    public Reader d() {
        JsonEncoding jsonEncodingM = this.a.m();
        int iBits = jsonEncodingM.bits();
        if (iBits != 8 && iBits != 16) {
            if (iBits != 32) {
                throw new RuntimeException("Internal error");
            }
            oy0 oy0Var = this.a;
            return new d83(oy0Var, this.b, this.c, this.d, this.e, oy0Var.m().isBigEndian());
        }
        InputStream wi1Var = this.b;
        if (wi1Var == null) {
            wi1Var = new ByteArrayInputStream(this.c, this.d, this.e);
        } else if (this.d < this.e) {
            wi1Var = new wi1(this.a, wi1Var, this.c, this.d, this.e);
        }
        return new InputStreamReader(wi1Var, jsonEncodingM.getJavaName());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x0069  */
    /* JADX WARN: Code duplicated, block: B:24:0x006c  */
    /* JADX WARN: Code duplicated, block: B:25:0x006f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0077  */
    /* JADX WARN: Code duplicated, block: B:29:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x007e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0081  */
    public JsonEncoding e() {
        int i;
        JsonEncoding jsonEncoding;
        if (f(4)) {
            byte[] bArr = this.c;
            int i2 = this.d;
            int i3 = (bArr[i2 + 3] & 255) | (bArr[i2] << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
            if (g(i3) || b(i3) || a(i3 >>> 16)) {
                i = this.h;
                if (i != 1) {
                    jsonEncoding = JsonEncoding.UTF8;
                } else if (i != 2) {
                    if (i == 4) {
                        throw new RuntimeException("Internal error");
                    }
                    if (this.g) {
                        jsonEncoding = JsonEncoding.UTF32_BE;
                    } else {
                        jsonEncoding = JsonEncoding.UTF32_LE;
                    }
                } else if (this.g) {
                    jsonEncoding = JsonEncoding.UTF16_BE;
                } else {
                    jsonEncoding = JsonEncoding.UTF16_LE;
                }
            } else {
                jsonEncoding = JsonEncoding.UTF8;
            }
        } else {
            if (f(2)) {
                byte[] bArr2 = this.c;
                int i4 = this.d;
                if (a((bArr2[i4 + 1] & 255) | ((bArr2[i4] & 255) << 8))) {
                    i = this.h;
                    if (i != 1) {
                        jsonEncoding = JsonEncoding.UTF8;
                    } else if (i != 2) {
                        if (i == 4) {
                            throw new RuntimeException("Internal error");
                        }
                        if (this.g) {
                            jsonEncoding = JsonEncoding.UTF32_BE;
                        } else {
                            jsonEncoding = JsonEncoding.UTF32_LE;
                        }
                    } else if (this.g) {
                        jsonEncoding = JsonEncoding.UTF16_BE;
                    } else {
                        jsonEncoding = JsonEncoding.UTF16_LE;
                    }
                }
            }
            jsonEncoding = JsonEncoding.UTF8;
        }
        this.a.u(jsonEncoding);
        return jsonEncoding;
    }

    protected boolean f(int i) throws IOException {
        int i2;
        int i3 = this.e - this.d;
        while (i3 < i) {
            InputStream inputStream = this.b;
            if (inputStream == null) {
                i2 = -1;
            } else {
                byte[] bArr = this.c;
                int i4 = this.e;
                i2 = inputStream.read(bArr, i4, bArr.length - i4);
            }
            if (i2 < 1) {
                return false;
            }
            this.e += i2;
            i3 += i2;
        }
        return true;
    }

    public np(oy0 oy0Var, byte[] bArr, int i, int i2) {
        this.g = true;
        this.a = oy0Var;
        this.b = null;
        this.c = bArr;
        this.d = i;
        this.e = i + i2;
        this.f = false;
    }
}
