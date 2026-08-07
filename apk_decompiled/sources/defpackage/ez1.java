package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class ez1 extends JsonParser {
    protected static final byte[] f = new byte[0];
    protected static final int[] g = new int[0];
    protected static final BigInteger h;
    protected static final BigInteger i;
    protected static final BigInteger j;
    protected static final BigInteger k;
    protected static final BigDecimal l;
    protected static final BigDecimal m;
    protected static final BigDecimal n;
    protected static final BigDecimal o;
    protected JsonToken d;
    protected JsonToken e;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(-2147483648L);
        h = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2147483647L);
        i = bigIntegerValueOf2;
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        j = bigIntegerValueOf3;
        BigInteger bigIntegerValueOf4 = BigInteger.valueOf(Long.MAX_VALUE);
        k = bigIntegerValueOf4;
        l = new BigDecimal(bigIntegerValueOf3);
        m = new BigDecimal(bigIntegerValueOf4);
        n = new BigDecimal(bigIntegerValueOf);
        o = new BigDecimal(bigIntegerValueOf2);
    }

    protected ez1() {
    }

    protected static final String y1(int i2) {
        char c = (char) i2;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + i2 + ")";
        }
        if (i2 <= 255) {
            return "'" + c + "' (code " + i2 + ")";
        }
        return "'" + c + "' (code " + i2 + " / 0x" + Integer.toHexString(i2) + ")";
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken A0() {
        return this.d;
    }

    protected boolean A1(String str) {
        return "null".equals(str);
    }

    protected String B1(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith("-")) {
            length--;
        }
        return String.format("[Integer with %d digits]", Integer.valueOf(length));
    }

    protected String C1(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith("-")) {
            length--;
        }
        return String.format("[number with %d characters]", Integer.valueOf(length));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken D() {
        return this.d;
    }

    protected final void D1(String str) {
        throw n(str);
    }

    protected final void E1(String str, Object obj) throws JsonParseException {
        throw n(String.format(str, obj));
    }

    protected final void F1(String str, Object obj, Object obj2) {
        throw n(String.format(str, obj, obj2));
    }

    protected void G1(String str, JsonToken jsonToken, Class cls) throws InputCoercionException {
        throw new InputCoercionException(this, str, jsonToken, cls);
    }

    protected void H1() {
        I1(" in " + this.d, this.d);
    }

    protected void I1(String str, JsonToken jsonToken) {
        throw new JsonEOFException(this, jsonToken, "Unexpected end-of-input" + str);
    }

    protected void J1(JsonToken jsonToken) {
        String str;
        if (jsonToken == JsonToken.VALUE_STRING) {
            str = " in a String value";
        } else {
            str = (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? " in a Number value" : " in a value";
        }
        I1(str, jsonToken);
    }

    protected void K1(int i2) {
        L1(i2, "Expected space separating root-level values");
    }

    protected void L1(int i2, String str) {
        if (i2 < 0) {
            H1();
        }
        String str2 = String.format("Unexpected character (%s)", y1(i2));
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        D1(str2);
    }

    protected Object M1(int i2, String str) {
        String str2 = String.format("Unexpected character (%s) in numeric value", y1(i2));
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        D1(str2);
        return null;
    }

    protected final void N1() {
        lb3.c();
    }

    protected void O1(int i2) {
        D1("Illegal character (" + y1((char) i2) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    protected final void P1(String str, Throwable th) throws JsonParseException {
        throw w1(str, th);
    }

    public int Q1(int i2) {
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return J0();
        }
        if (jsonToken == null) {
            return i2;
        }
        int iId = jsonToken.id();
        if (iId == 6) {
            String strS0 = S0();
            if (A1(strS0)) {
                return 0;
            }
            return hs1.e(strS0, i2);
        }
        switch (iId) {
            case 9:
                return 1;
            case 10:
            case 11:
                return 0;
            case 12:
                Object objH0 = H0();
                return objH0 instanceof Number ? ((Number) objH0).intValue() : i2;
            default:
                return i2;
        }
    }

    public long R1(long j2) {
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return K0();
        }
        if (jsonToken == null) {
            return j2;
        }
        int iId = jsonToken.id();
        if (iId == 6) {
            String strS0 = S0();
            if (A1(strS0)) {
                return 0L;
            }
            return hs1.f(strS0, j2);
        }
        switch (iId) {
            case 9:
                return 1L;
            case 10:
            case 11:
                return 0L;
            case 12:
                Object objH0 = H0();
                return objH0 instanceof Number ? ((Number) objH0).longValue() : j2;
            default:
                return j2;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract String S0();

    public String S1(String str) {
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return S0();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return y0();
        }
        return (jsonToken == null || jsonToken == JsonToken.VALUE_NULL || !jsonToken.isScalarValue()) ? str : S0();
    }

    protected void T1(String str) {
        D1("Invalid numeric value: " + str);
    }

    protected void U1() {
        V1(S0());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int V() {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.id();
    }

    protected void V1(String str) throws InputCoercionException {
        W1(str, D());
    }

    protected void W1(String str, JsonToken jsonToken) throws InputCoercionException {
        G1(String.format("Numeric value (%s) out of range of int (%d - %s)", B1(str), Integer.MIN_VALUE, Integer.MAX_VALUE), jsonToken, Integer.TYPE);
    }

    protected void X1() {
        Y1(S0());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int Y0() {
        JsonToken jsonToken = this.d;
        return (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? J0() : Q1(0);
    }

    protected void Y1(String str) throws InputCoercionException {
        Z1(str, D());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long Z0() {
        JsonToken jsonToken = this.d;
        return (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? K0() : R1(0L);
    }

    protected void Z1(String str, JsonToken jsonToken) throws InputCoercionException {
        G1(String.format("Numeric value (%s) out of range of long (%d - %s)", B1(str), Long.MIN_VALUE, Long.MAX_VALUE), jsonToken, Long.TYPE);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String a1() {
        return S1(null);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean b1() {
        return this.d != null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean d1(JsonToken jsonToken) {
        return this.d == jsonToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean e1(int i2) {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return i2 == 0;
        }
        return jsonToken.id() == i2;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean h1() {
        return this.d == JsonToken.VALUE_NUMBER_INT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean i1() {
        return this.d == JsonToken.START_ARRAY;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean j1() {
        return this.d == JsonToken.START_OBJECT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract JsonToken n1();

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser v1() throws JsonParseException {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return this;
        }
        int i2 = 1;
        while (true) {
            JsonToken jsonTokenN1 = n1();
            if (jsonTokenN1 == null) {
                z1();
                return this;
            }
            if (jsonTokenN1.isStructStart()) {
                i2++;
            } else if (jsonTokenN1.isStructEnd()) {
                i2--;
                if (i2 == 0) {
                    return this;
                }
            } else if (jsonTokenN1 == JsonToken.NOT_AVAILABLE) {
                E1("Not enough content available for `skipChildren()`: non-blocking parser? (%s)", getClass().getName());
            }
        }
    }

    protected final JsonParseException w1(String str, Throwable th) {
        return new JsonParseException(this, str, th);
    }

    protected void x1(String str, zo zoVar, Base64Variant base64Variant) {
        try {
            base64Variant.decode(str, zoVar);
        } catch (IllegalArgumentException e) {
            D1(e.getMessage());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void y() {
        JsonToken jsonToken = this.d;
        if (jsonToken != null) {
            this.e = jsonToken;
            this.d = null;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract String y0();

    protected abstract void z1();

    protected ez1(int i2) {
        super(i2);
    }
}
