package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.type.WritableTypeId;
import defpackage.d41;
import defpackage.h71;
import defpackage.k52;
import defpackage.lb3;
import defpackage.vm2;
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonGenerator implements Closeable, Flushable {
    protected static final d41 b;
    protected static final d41 c;
    protected static final d41 d;
    protected k52 a;

    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        ESCAPE_NON_ASCII(false),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false),
        USE_FAST_DOUBLE_WRITER(false),
        WRITE_HEX_UPPER_CASE(true);

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

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WritableTypeId.Inclusion.values().length];
            a = iArr;
            try {
                iArr[WritableTypeId.Inclusion.PARENT_PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WritableTypeId.Inclusion.PAYLOAD_PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[WritableTypeId.Inclusion.METADATA_PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[WritableTypeId.Inclusion.WRAPPER_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[WritableTypeId.Inclusion.WRAPPER_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        d41 d41VarA = d41.a(StreamWriteCapability.values());
        b = d41VarA;
        c = d41VarA.c(StreamWriteCapability.CAN_WRITE_FORMATTED_NUMBERS);
        d = d41VarA.c(StreamWriteCapability.CAN_WRITE_BINARY_NATIVELY);
    }

    protected JsonGenerator() {
    }

    public abstract JsonGenerator A0(int i);

    public WritableTypeId A1(WritableTypeId writableTypeId) throws JsonGenerationException {
        Object obj = writableTypeId.c;
        JsonToken jsonToken = writableTypeId.f;
        if (a0()) {
            writableTypeId.g = false;
            z1(obj);
        } else {
            String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
            writableTypeId.g = true;
            WritableTypeId.Inclusion inclusion = writableTypeId.e;
            if (jsonToken != JsonToken.START_OBJECT && inclusion.requiresObjectContext()) {
                inclusion = WritableTypeId.Inclusion.WRAPPER_ARRAY;
                writableTypeId.e = inclusion;
            }
            int i = a.a[inclusion.ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3) {
                    t1(writableTypeId.a);
                    y1(writableTypeId.d, strValueOf);
                    return writableTypeId;
                }
                if (i != 4) {
                    p1();
                    w1(strValueOf);
                } else {
                    s1();
                    V0(strValueOf);
                }
            }
        }
        if (jsonToken == JsonToken.START_OBJECT) {
            t1(writableTypeId.a);
        } else if (jsonToken == JsonToken.START_ARRAY) {
            p1();
        }
        return writableTypeId;
    }

    public WritableTypeId B1(WritableTypeId writableTypeId) {
        JsonToken jsonToken = writableTypeId.f;
        if (jsonToken == JsonToken.START_OBJECT) {
            S0();
        } else if (jsonToken == JsonToken.START_ARRAY) {
            R0();
        }
        if (writableTypeId.g) {
            int i = a.a[writableTypeId.e.ordinal()];
            if (i == 1) {
                Object obj = writableTypeId.c;
                y1(writableTypeId.d, obj instanceof String ? (String) obj : String.valueOf(obj));
            } else if (i != 2 && i != 3) {
                if (i != 5) {
                    S0();
                } else {
                    R0();
                }
            }
        }
        return writableTypeId;
    }

    public boolean C() {
        return true;
    }

    public boolean D() {
        return false;
    }

    public JsonGenerator F0(k52 k52Var) {
        this.a = k52Var;
        return this;
    }

    public JsonGenerator G0(vm2 vm2Var) {
        throw new UnsupportedOperationException();
    }

    public void H0(double[] dArr, int i, int i2) {
        if (dArr == null) {
            throw new IllegalArgumentException("null array");
        }
        w(dArr.length, i, i2);
        r1(dArr, i2);
        int i3 = i2 + i;
        while (i < i3) {
            X0(dArr[i]);
            i++;
        }
        R0();
    }

    public void I0(int[] iArr, int i, int i2) {
        if (iArr == null) {
            throw new IllegalArgumentException("null array");
        }
        w(iArr.length, i, i2);
        r1(iArr, i2);
        int i3 = i2 + i;
        while (i < i3) {
            Z0(iArr[i]);
            i++;
        }
        R0();
    }

    public void J0(long[] jArr, int i, int i2) {
        if (jArr == null) {
            throw new IllegalArgumentException("null array");
        }
        w(jArr.length, i, i2);
        r1(jArr, i2);
        int i3 = i2 + i;
        while (i < i3) {
            a1(jArr[i]);
            i++;
        }
        R0();
    }

    public abstract int K0(Base64Variant base64Variant, InputStream inputStream, int i);

    public int L0(InputStream inputStream, int i) {
        return K0(com.fasterxml.jackson.core.a.a(), inputStream, i);
    }

    public abstract void M0(Base64Variant base64Variant, byte[] bArr, int i, int i2);

    public void N0(byte[] bArr) {
        M0(com.fasterxml.jackson.core.a.a(), bArr, 0, bArr.length);
    }

    public void O0(byte[] bArr, int i, int i2) {
        M0(com.fasterxml.jackson.core.a.a(), bArr, i, i2);
    }

    public abstract void P0(boolean z);

    public void Q0(Object obj) throws JsonGenerationException {
        if (obj == null) {
            W0();
        } else {
            if (obj instanceof byte[]) {
                N0((byte[]) obj);
                return;
            }
            throw new JsonGenerationException("No native support for writing embedded objects of type " + obj.getClass().getName(), this);
        }
    }

    public abstract void R0();

    public abstract void S0();

    public void T0(long j) {
        V0(Long.toString(j));
    }

    public abstract void U0(vm2 vm2Var);

    public boolean V() {
        return false;
    }

    public abstract void V0(String str);

    public abstract void W0();

    public abstract void X0(double d2);

    public abstract void Y0(float f);

    public abstract void Z0(int i);

    public boolean a0() {
        return false;
    }

    public abstract void a1(long j);

    public abstract void b1(String str);

    public abstract void c1(BigDecimal bigDecimal);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract void d1(BigInteger bigInteger);

    public abstract JsonGenerator e0(Feature feature);

    public abstract void e1(short s);

    public abstract void f1(Object obj);

    @Override // java.io.Flushable
    public abstract void flush();

    public abstract h71 g0();

    public void g1(Object obj) throws JsonGenerationException {
        throw new JsonGenerationException("No native support for writing Object Ids", this);
    }

    public void h1(Object obj) throws JsonGenerationException {
        throw new JsonGenerationException("No native support for writing Object Ids", this);
    }

    public void i1(String str) {
    }

    public k52 j0() {
        return this.a;
    }

    public abstract void j1(char c2);

    public abstract boolean k0(Feature feature);

    public abstract void k1(vm2 vm2Var);

    public abstract void l1(String str);

    public JsonGenerator m0(int i, int i2) {
        return this;
    }

    public abstract void m1(char[] cArr, int i, int i2);

    protected void n(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str, this);
    }

    public void n1(vm2 vm2Var) {
        o1(vm2Var.getValue());
    }

    public abstract void o1(String str);

    public abstract void p1();

    public abstract void q1(Object obj);

    public abstract void r1(Object obj, int i);

    public abstract void s1();

    public abstract JsonGenerator t0(int i, int i2);

    public abstract void t1(Object obj);

    protected final void u() {
        lb3.c();
    }

    public abstract void u1(Object obj, int i);

    public abstract void v1(vm2 vm2Var);

    protected final void w(int i, int i2, int i3) {
        if (i2 < 0 || i2 + i3 > i) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i)));
        }
    }

    public JsonGenerator w0(CharacterEscapes characterEscapes) {
        return this;
    }

    public abstract void w1(String str);

    public abstract void x1(char[] cArr, int i, int i2);

    protected void y(Object obj) {
        if (obj == null) {
            W0();
            return;
        }
        if (obj instanceof String) {
            w1((String) obj);
            return;
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number instanceof Integer) {
                Z0(number.intValue());
                return;
            }
            if (number instanceof Long) {
                a1(number.longValue());
                return;
            }
            if (number instanceof Double) {
                X0(number.doubleValue());
                return;
            }
            if (number instanceof Float) {
                Y0(number.floatValue());
                return;
            }
            if (number instanceof Short) {
                e1(number.shortValue());
                return;
            }
            if (number instanceof Byte) {
                e1(number.byteValue());
                return;
            }
            if (number instanceof BigInteger) {
                d1((BigInteger) number);
                return;
            }
            if (number instanceof BigDecimal) {
                c1((BigDecimal) number);
                return;
            } else if (number instanceof AtomicInteger) {
                Z0(((AtomicInteger) number).get());
                return;
            } else if (number instanceof AtomicLong) {
                a1(((AtomicLong) number).get());
                return;
            }
        } else if (obj instanceof byte[]) {
            N0((byte[]) obj);
            return;
        } else if (obj instanceof Boolean) {
            P0(((Boolean) obj).booleanValue());
            return;
        } else if (obj instanceof AtomicBoolean) {
            P0(((AtomicBoolean) obj).get());
            return;
        }
        throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + obj.getClass().getName() + ")");
    }

    public void y0(Object obj) {
        h71 h71VarG0 = g0();
        if (h71VarG0 != null) {
            h71VarG0.l(obj);
        }
    }

    public void y1(String str, String str2) {
        V0(str);
        w1(str2);
    }

    public void z1(Object obj) throws JsonGenerationException {
        throw new JsonGenerationException("No native support for writing Type Ids", this);
    }
}
