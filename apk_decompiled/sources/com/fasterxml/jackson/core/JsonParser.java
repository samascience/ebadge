package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.core.util.RequestPayload;
import defpackage.d41;
import defpackage.h71;
import defpackage.ip0;
import defpackage.jt1;
import java.io.Closeable;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonParser implements Closeable {
    protected static final d41 c = d41.a(StreamReadCapability.values());
    protected int a;
    protected transient RequestPayload b;

    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS(false),
        ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false),
        ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        ALLOW_MISSING_VALUES(false),
        ALLOW_TRAILING_COMMA(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNDEFINED(false),
        INCLUDE_SOURCE_IN_LOCATION(true),
        USE_FAST_DOUBLE_PARSER(false);

        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        Feature(boolean z) {
            this._defaultState = z;
        }

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i) {
            return (i & this._mask) != 0;
        }

        public int getMask() {
            return this._mask;
        }
    }

    public enum NumberType {
        INT,
        LONG,
        BIG_INTEGER,
        FLOAT,
        DOUBLE,
        BIG_DECIMAL
    }

    protected JsonParser() {
        this.a = JsonFactory.DEFAULT_PARSER_FEATURE_FLAGS;
    }

    public abstract JsonToken A0();

    public String C() {
        return y0();
    }

    public abstract JsonToken D();

    public abstract BigDecimal F0();

    public abstract double G0();

    public Object H0() {
        return null;
    }

    public abstract float I0();

    public abstract int J0();

    public abstract long K0();

    public abstract NumberType L0();

    public abstract Number M0();

    public Number N0() {
        return M0();
    }

    public Object O0() {
        return null;
    }

    public abstract h71 P0();

    public abstract d41 Q0();

    public short R0() throws InputCoercionException {
        int iJ0 = J0();
        if (iJ0 < -32768 || iJ0 > 32767) {
            throw new InputCoercionException(this, String.format("Numeric value (%s) out of range of Java short", S0()), JsonToken.VALUE_NUMBER_INT, Short.TYPE);
        }
        return (short) iJ0;
    }

    public abstract String S0();

    public abstract char[] T0();

    public abstract int U0();

    public abstract int V();

    public abstract int V0();

    public abstract JsonLocation W0();

    public Object X0() {
        return null;
    }

    public abstract int Y0();

    public abstract long Z0();

    public JsonParser a0(Feature feature) {
        this.a = feature.getMask() | this.a;
        return this;
    }

    public abstract String a1();

    public abstract boolean b1();

    public abstract boolean c1();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract boolean d1(JsonToken jsonToken);

    public abstract BigInteger e0();

    public abstract boolean e1(int i);

    public boolean f1(Feature feature) {
        return feature.enabledIn(this.a);
    }

    public byte[] g0() {
        return j0(a.a());
    }

    public boolean g1(StreamReadFeature streamReadFeature) {
        return streamReadFeature.mappedFeature().enabledIn(this.a);
    }

    public abstract boolean h1();

    public abstract boolean i1();

    public abstract byte[] j0(Base64Variant base64Variant);

    public abstract boolean j1();

    public boolean k0() throws JsonParseException {
        JsonToken jsonTokenD = D();
        if (jsonTokenD == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (jsonTokenD == JsonToken.VALUE_FALSE) {
            return false;
        }
        throw new JsonParseException(this, String.format("Current token (%s) not of boolean type", jsonTokenD)).withRequestPayload(this.b);
    }

    public abstract boolean k1();

    public String l1() {
        if (n1() == JsonToken.FIELD_NAME) {
            return y0();
        }
        return null;
    }

    public byte m0() throws InputCoercionException {
        int iJ0 = J0();
        if (iJ0 < -128 || iJ0 > 255) {
            throw new InputCoercionException(this, String.format("Numeric value (%s) out of range of Java byte", S0()), JsonToken.VALUE_NUMBER_INT, Byte.TYPE);
        }
        return (byte) iJ0;
    }

    public String m1() {
        if (n1() == JsonToken.VALUE_STRING) {
            return S0();
        }
        return null;
    }

    protected JsonParseException n(String str) {
        return new JsonParseException(this, str).withRequestPayload(this.b);
    }

    public abstract JsonToken n1();

    public JsonParser o1(int i, int i2) {
        return this;
    }

    public JsonParser p1(int i, int i2) {
        return t1((i & i2) | (this.a & (~i2)));
    }

    public abstract int q1(Base64Variant base64Variant, OutputStream outputStream);

    public boolean r1() {
        return false;
    }

    public void s1(Object obj) {
        h71 h71VarP0 = P0();
        if (h71VarP0 != null) {
            h71VarP0.l(obj);
        }
    }

    public abstract jt1 t0();

    public JsonParser t1(int i) {
        this.a = i;
        return this;
    }

    public boolean u() {
        return false;
    }

    public void u1(ip0 ip0Var) {
        throw new UnsupportedOperationException("Parser of type " + getClass().getName() + " does not support schema of type '" + ip0Var.a() + "'");
    }

    public abstract JsonParser v1();

    public boolean w() {
        return false;
    }

    public abstract JsonLocation w0();

    public abstract void y();

    public abstract String y0();

    protected JsonParser(int i) {
        this.a = i;
    }
}
