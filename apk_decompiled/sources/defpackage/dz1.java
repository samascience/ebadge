package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.core.io.ContentReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class dz1 extends ez1 {
    protected static final d41 X = JsonParser.c;
    protected JsonToken F;
    protected final w13 G;
    protected char[] H;
    protected boolean I;
    protected zo J;
    protected byte[] K;
    protected int L;
    protected int M;
    protected long N;
    protected float O;
    protected double P;
    protected BigInteger Q;
    protected BigDecimal R;
    protected String S;
    protected boolean T;
    protected int U;
    protected int V;
    protected int W;
    protected final oy0 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected boolean f326q;
    protected int r;
    protected int s;
    protected long t;
    protected int u;
    protected int v;
    protected long w;
    protected int x;
    protected int y;
    protected z61 z;

    protected dz1(oy0 oy0Var, int i) {
        super(i);
        this.u = 1;
        this.x = 1;
        this.L = 0;
        this.p = oy0Var;
        this.G = oy0Var.k();
        this.z = z61.r(JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? ae0.f(this) : null);
    }

    protected static int[] D2(int[] iArr, int i) {
        return iArr == null ? new int[i] : Arrays.copyOf(iArr, iArr.length + i);
    }

    private void o2(int i) throws JsonParseException {
        try {
            if (i == 16) {
                this.R = null;
                this.S = this.G.l();
                this.L = 16;
            } else if (i == 32) {
                this.O = this.G.i(f1(JsonParser.Feature.USE_FAST_DOUBLE_PARSER));
                this.L = 32;
            } else {
                this.P = this.G.h(f1(JsonParser.Feature.USE_FAST_DOUBLE_PARSER));
                this.L = 8;
            }
        } catch (NumberFormatException e) {
            P1("Malformed numeric value (" + C1(this.G.l()) + ")", e);
        }
    }

    private void p2(int i) throws JsonParseException, InputCoercionException {
        String strL = this.G.l();
        try {
            int i2 = this.U;
            char[] cArrU = this.G.u();
            int iV = this.G.v();
            boolean z = this.T;
            if (z) {
                iV++;
            }
            if (hs1.b(cArrU, iV, i2, z)) {
                this.N = Long.parseLong(strL);
                this.L = 2;
                return;
            }
            if (i == 1 || i == 2) {
                s2(i, strL);
            }
            if (i != 8 && i != 32) {
                this.Q = null;
                this.S = strL;
                this.L = 4;
                return;
            }
            this.P = hs1.j(strL, f1(JsonParser.Feature.USE_FAST_DOUBLE_PARSER));
            this.L = 8;
        } catch (NumberFormatException e) {
            P1("Malformed numeric value (" + C1(strL) + ")", e);
        }
    }

    protected void A2() {
        int i = this.L;
        if ((i & 2) != 0) {
            long j = this.N;
            int i2 = (int) j;
            if (i2 != j) {
                W1(S0(), D());
            }
            this.M = i2;
        } else if ((i & 4) != 0) {
            BigInteger bigIntegerI2 = i2();
            if (ez1.h.compareTo(bigIntegerI2) > 0 || ez1.i.compareTo(bigIntegerI2) < 0) {
                U1();
            }
            this.M = bigIntegerI2.intValue();
        } else if ((i & 8) != 0) {
            double d = this.P;
            if (d < -2.147483648E9d || d > 2.147483647E9d) {
                U1();
            }
            this.M = (int) this.P;
        } else if ((i & 16) != 0) {
            BigDecimal bigDecimalH2 = h2();
            if (ez1.n.compareTo(bigDecimalH2) > 0 || ez1.o.compareTo(bigDecimalH2) < 0) {
                U1();
            }
            this.M = bigDecimalH2.intValue();
        } else {
            N1();
        }
        this.L |= 1;
    }

    protected void B2() {
        int i = this.L;
        if ((i & 1) != 0) {
            this.N = this.M;
        } else if ((i & 4) != 0) {
            BigInteger bigIntegerI2 = i2();
            if (ez1.j.compareTo(bigIntegerI2) > 0 || ez1.k.compareTo(bigIntegerI2) < 0) {
                X1();
            }
            this.N = bigIntegerI2.longValue();
        } else if ((i & 8) != 0) {
            double d = this.P;
            if (d < -9.223372036854776E18d || d > 9.223372036854776E18d) {
                X1();
            }
            this.N = (long) this.P;
        } else if ((i & 16) != 0) {
            BigDecimal bigDecimalH2 = h2();
            if (ez1.l.compareTo(bigDecimalH2) > 0 || ez1.m.compareTo(bigDecimalH2) < 0) {
                X1();
            }
            this.N = bigDecimalH2.longValue();
        } else {
            N1();
        }
        this.L |= 2;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: C2, reason: merged with bridge method [inline-methods] */
    public z61 P0() {
        return this.z;
    }

    protected IllegalArgumentException E2(Base64Variant base64Variant, int i, int i2) {
        return F2(base64Variant, i, i2, null);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal F0() throws JsonParseException, InputCoercionException {
        int i = this.L;
        if ((i & 16) == 0) {
            if (i == 0) {
                n2(16);
            }
            if ((this.L & 16) == 0) {
                w2();
            }
        }
        return h2();
    }

    protected IllegalArgumentException F2(Base64Variant base64Variant, int i, int i2, String str) {
        String str2;
        if (i <= 32) {
            str2 = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", Integer.toHexString(i), Integer.valueOf(i2 + 1));
        } else if (base64Variant.usesPaddingChar(i)) {
            str2 = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i) || Character.isISOControl(i)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(i) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + ((char) i) + "' (code 0x" + Integer.toHexString(i) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double G0() throws JsonParseException, InputCoercionException {
        int i = this.L;
        if ((i & 8) == 0) {
            if (i == 0) {
                n2(8);
            }
            if ((this.L & 8) == 0) {
                y2();
            }
        }
        return this.P;
    }

    protected final JsonToken G2(String str, double d) {
        this.G.B(str);
        this.P = d;
        this.L = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    protected final JsonToken H2(boolean z, int i, int i2, int i3) {
        this.T = z;
        this.U = i;
        this.V = i2;
        this.W = i3;
        this.L = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float I0() throws JsonParseException, InputCoercionException {
        int i = this.L;
        if ((i & 32) == 0) {
            if (i == 0) {
                n2(32);
            }
            if ((this.L & 32) == 0) {
                z2();
            }
        }
        return this.O;
    }

    protected final JsonToken I2(boolean z, int i) {
        this.T = z;
        this.U = i;
        this.V = 0;
        this.W = 0;
        this.L = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int J0() {
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

    @Override // com.fasterxml.jackson.core.JsonParser
    public long K0() throws JsonParseException, InputCoercionException {
        int i = this.L;
        if ((i & 2) == 0) {
            if (i == 0) {
                n2(2);
            }
            if ((this.L & 2) == 0) {
                B2();
            }
        }
        return this.N;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType L0() throws JsonParseException, InputCoercionException {
        if (this.L == 0) {
            n2(0);
        }
        if (this.d == JsonToken.VALUE_NUMBER_INT) {
            int i = this.L;
            if ((i & 1) != 0) {
                return JsonParser.NumberType.INT;
            }
            return (i & 2) != 0 ? JsonParser.NumberType.LONG : JsonParser.NumberType.BIG_INTEGER;
        }
        int i2 = this.L;
        if ((i2 & 16) != 0) {
            return JsonParser.NumberType.BIG_DECIMAL;
        }
        return (i2 & 32) != 0 ? JsonParser.NumberType.FLOAT : JsonParser.NumberType.DOUBLE;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number M0() throws JsonParseException, InputCoercionException {
        if (this.L == 0) {
            n2(0);
        }
        if (this.d == JsonToken.VALUE_NUMBER_INT) {
            int i = this.L;
            if ((i & 1) != 0) {
                return Integer.valueOf(this.M);
            }
            if ((i & 2) != 0) {
                return Long.valueOf(this.N);
            }
            if ((i & 4) != 0) {
                return i2();
            }
            N1();
        }
        int i2 = this.L;
        if ((i2 & 16) != 0) {
            return h2();
        }
        if ((i2 & 32) != 0) {
            return Float.valueOf(this.O);
        }
        if ((i2 & 8) == 0) {
            N1();
        }
        return Double.valueOf(this.P);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number N0() throws JsonParseException, InputCoercionException {
        if (this.d == JsonToken.VALUE_NUMBER_INT) {
            if (this.L == 0) {
                n2(0);
            }
            int i = this.L;
            if ((i & 1) != 0) {
                return Integer.valueOf(this.M);
            }
            if ((i & 2) != 0) {
                return Long.valueOf(this.N);
            }
            if ((i & 4) != 0) {
                return i2();
            }
            N1();
        }
        if (this.L == 0) {
            n2(16);
        }
        int i2 = this.L;
        if ((i2 & 16) != 0) {
            return h2();
        }
        if ((i2 & 32) != 0) {
            return Float.valueOf(this.O);
        }
        if ((i2 & 8) == 0) {
            N1();
        }
        return Double.valueOf(this.P);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser a0(JsonParser.Feature feature) {
        this.a |= feature.getMask();
        if (feature == JsonParser.Feature.STRICT_DUPLICATE_DETECTION && this.z.t() == null) {
            this.z = this.z.y(ae0.f(this));
        }
        return this;
    }

    protected void a2(int i, int i2) {
        int mask = JsonParser.Feature.STRICT_DUPLICATE_DETECTION.getMask();
        if ((i2 & mask) == 0 || (i & mask) == 0) {
            return;
        }
        if (this.z.t() == null) {
            this.z = this.z.y(ae0.f(this));
        } else {
            this.z = this.z.y(null);
        }
    }

    protected abstract void b2();

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean c1() {
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return true;
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this.I;
        }
        return false;
    }

    protected ContentReference c2() {
        return JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION.enabledIn(this.a) ? this.p.l() : ContentReference.unknown();
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f326q) {
            return;
        }
        this.r = Math.max(this.r, this.s);
        this.f326q = true;
        try {
            b2();
        } finally {
            q2();
        }
    }

    protected final int d2(Base64Variant base64Variant, char c, int i) {
        if (c != '\\') {
            throw E2(base64Variant, c, i);
        }
        char cF2 = f2();
        if (cF2 <= ' ' && i == 0) {
            return -1;
        }
        int iDecodeBase64Char = base64Variant.decodeBase64Char(cF2);
        if (iDecodeBase64Char >= 0 || (iDecodeBase64Char == -2 && i >= 2)) {
            return iDecodeBase64Char;
        }
        throw E2(base64Variant, cF2, i);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger e0() throws JsonParseException, InputCoercionException {
        int i = this.L;
        if ((i & 4) == 0) {
            if (i == 0) {
                n2(4);
            }
            if ((this.L & 4) == 0) {
                x2();
            }
        }
        return i2();
    }

    protected final int e2(Base64Variant base64Variant, int i, int i2) {
        if (i != 92) {
            throw E2(base64Variant, i, i2);
        }
        char cF2 = f2();
        if (cF2 <= ' ' && i2 == 0) {
            return -1;
        }
        int iDecodeBase64Char = base64Variant.decodeBase64Char((int) cF2);
        if (iDecodeBase64Char >= 0 || iDecodeBase64Char == -2) {
            return iDecodeBase64Char;
        }
        throw E2(base64Variant, cF2, i2);
    }

    protected abstract char f2();

    protected final int g2() {
        z1();
        return -1;
    }

    protected BigDecimal h2() {
        BigDecimal bigDecimal = this.R;
        if (bigDecimal != null) {
            return bigDecimal;
        }
        String str = this.S;
        if (str == null) {
            throw new IllegalStateException("cannot get BigDecimal from current parser state");
        }
        BigDecimal bigDecimalG = hs1.g(str);
        this.R = bigDecimalG;
        this.S = null;
        return bigDecimalG;
    }

    protected BigInteger i2() {
        BigInteger bigInteger = this.Q;
        if (bigInteger != null) {
            return bigInteger;
        }
        String str = this.S;
        if (str == null) {
            throw new IllegalStateException("cannot get BigInteger from current parser state");
        }
        BigInteger bigIntegerH = hs1.h(str);
        this.Q = bigIntegerH;
        this.S = null;
        return bigIntegerH;
    }

    public zo j2() {
        zo zoVar = this.J;
        if (zoVar == null) {
            this.J = new zo();
        } else {
            zoVar.j0();
        }
        return this.J;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean k1() {
        if (this.d != JsonToken.VALUE_NUMBER_FLOAT || (this.L & 8) == 0) {
            return false;
        }
        double d = this.P;
        return Double.isNaN(d) || Double.isInfinite(d);
    }

    protected void k2(Base64Variant base64Variant) {
        D1(base64Variant.missingPaddingMessage());
    }

    protected char l2(char c) {
        if (f1(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return c;
        }
        if (c == '\'' && f1(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return c;
        }
        D1("Unrecognized character escape " + ez1.y1(c));
        return c;
    }

    protected int m2() throws JsonParseException, InputCoercionException {
        if (this.f326q) {
            D1("Internal error: _parseNumericValue called when parser instance closed");
        }
        if (this.d != JsonToken.VALUE_NUMBER_INT || this.U > 9) {
            n2(1);
            if ((this.L & 1) == 0) {
                A2();
            }
            return this.M;
        }
        int iJ = this.G.j(this.T);
        this.M = iJ;
        this.L = 1;
        return iJ;
    }

    protected void n2(int i) throws JsonParseException, InputCoercionException {
        if (this.f326q) {
            D1("Internal error: _parseNumericValue called when parser instance closed");
        }
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT) {
            if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
                o2(i);
                return;
            } else {
                E1("Current token (%s) not numeric, can not use numeric value accessors", jsonToken);
                return;
            }
        }
        int i2 = this.U;
        if (i2 <= 9) {
            this.M = this.G.j(this.T);
            this.L = 1;
            return;
        }
        if (i2 > 18) {
            p2(i);
            return;
        }
        long jK = this.G.k(this.T);
        if (i2 == 10) {
            if (this.T) {
                if (jK >= -2147483648L) {
                    this.M = (int) jK;
                    this.L = 1;
                    return;
                }
            } else if (jK <= 2147483647L) {
                this.M = (int) jK;
                this.L = 1;
                return;
            }
        }
        this.N = jK;
        this.L = 2;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser p1(int i, int i2) {
        int i3 = this.a;
        int i4 = (i & i2) | ((~i2) & i3);
        int i5 = i3 ^ i4;
        if (i5 != 0) {
            this.a = i4;
            a2(i4, i5);
        }
        return this;
    }

    protected void q2() {
        this.G.x();
        char[] cArr = this.H;
        if (cArr != null) {
            this.H = null;
            this.p.q(cArr);
        }
    }

    protected void r2(int i, char c) {
        z61 z61VarP0 = P0();
        D1(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", Character.valueOf((char) i), Character.valueOf(c), z61VarP0.m(), z61VarP0.x(c2())));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void s1(Object obj) {
        this.z.l(obj);
    }

    protected void s2(int i, String str) throws InputCoercionException {
        if (i == 1) {
            V1(str);
        } else {
            Y1(str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser t1(int i) {
        int i2 = this.a ^ i;
        if (i2 != 0) {
            this.a = i;
            a2(i, i2);
        }
        return this;
    }

    protected void t2(int i, String str) {
        if (!f1(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i > 32) {
            D1("Illegal unquoted character (" + ez1.y1((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    protected String u2() {
        return v2();
    }

    protected String v2() {
        return f1(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS) ? "(JSON String, Number (or 'NaN'/'INF'/'+INF'), Array, Object or token 'null', 'true' or 'false')" : "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
    }

    protected void w2() {
        int i = this.L;
        if ((i & 8) != 0) {
            this.R = hs1.g(S0());
        } else if ((i & 4) != 0) {
            this.R = new BigDecimal(i2());
        } else if ((i & 2) != 0) {
            this.R = BigDecimal.valueOf(this.N);
        } else if ((i & 1) != 0) {
            this.R = BigDecimal.valueOf(this.M);
        } else {
            N1();
        }
        this.L |= 16;
    }

    protected void x2() {
        int i = this.L;
        if ((i & 16) != 0) {
            this.Q = h2().toBigInteger();
        } else if ((i & 2) != 0) {
            this.Q = BigInteger.valueOf(this.N);
        } else if ((i & 1) != 0) {
            this.Q = BigInteger.valueOf(this.M);
        } else if ((i & 8) != 0) {
            this.Q = BigDecimal.valueOf(this.P).toBigInteger();
        } else {
            N1();
        }
        this.L |= 4;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public String y0() {
        z61 z61VarE;
        JsonToken jsonToken = this.d;
        return ((jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) && (z61VarE = this.z.e()) != null) ? z61VarE.b() : this.z.b();
    }

    protected void y2() {
        int i = this.L;
        if ((i & 16) != 0) {
            this.P = h2().doubleValue();
        } else if ((i & 4) != 0) {
            this.P = i2().doubleValue();
        } else if ((i & 2) != 0) {
            this.P = this.N;
        } else if ((i & 1) != 0) {
            this.P = this.M;
        } else if ((i & 32) != 0) {
            this.P = this.O;
        } else {
            N1();
        }
        this.L |= 8;
    }

    @Override // defpackage.ez1
    protected void z1() {
        if (this.z.k()) {
            return;
        }
        I1(String.format(": expected close marker for %s (start marker at %s)", this.z.i() ? "Array" : "Object", this.z.x(c2())), null);
    }

    protected void z2() {
        int i = this.L;
        if ((i & 16) != 0) {
            this.O = h2().floatValue();
        } else if ((i & 4) != 0) {
            this.O = i2().floatValue();
        } else if ((i & 2) != 0) {
            this.O = this.N;
        } else if ((i & 1) != 0) {
            this.O = this.M;
        } else if ((i & 8) != 0) {
            this.O = (float) this.P;
        } else {
            N1();
        }
        this.L |= 32;
    }
}
