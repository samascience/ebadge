package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class q33 extends JsonGenerator {
    protected static final int t = JsonGenerator.Feature.collectDefaults();
    protected jt1 e;
    protected h71 f;
    protected boolean h;
    protected boolean i;
    protected boolean j;
    protected boolean k;
    protected boolean l;
    protected c m;
    protected c n;
    protected int o;
    protected Object p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected Object f374q;
    protected boolean r = false;
    protected int g = t;
    protected z71 s = z71.t(null);

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[JsonParser.NumberType.values().length];
            b = iArr;
            try {
                iArr[JsonParser.NumberType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[JsonParser.NumberType.BIG_INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[JsonParser.NumberType.BIG_DECIMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[JsonParser.NumberType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[JsonParser.NumberType.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[JsonToken.values().length];
            a = iArr2;
            try {
                iArr2[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[JsonToken.END_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[JsonToken.START_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[JsonToken.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[JsonToken.VALUE_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[JsonToken.VALUE_TRUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[JsonToken.VALUE_FALSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[JsonToken.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 12;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    protected static final class b extends ez1 {
        protected jt1 p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        protected final boolean f375q;
        protected final boolean r;
        protected final boolean s;
        protected c t;
        protected r33 v;
        protected boolean w;
        protected transient zo x;
        protected JsonLocation y = null;
        protected int u = -1;

        public b(c cVar, jt1 jt1Var, boolean z, boolean z2, h71 h71Var) {
            this.t = cVar;
            this.p = jt1Var;
            this.v = r33.p(h71Var);
            this.f375q = z;
            this.r = z2;
            this.s = z || z2;
        }

        private final boolean e2(Number number) {
            return (number instanceof Short) || (number instanceof Byte);
        }

        private final boolean f2(Number number) {
            return (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public String C() {
            JsonToken jsonToken = this.d;
            return (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) ? this.v.e().b() : this.v.b();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public BigDecimal F0() throws JsonParseException {
            Number numberM0 = M0();
            if (numberM0 instanceof BigDecimal) {
                return (BigDecimal) numberM0;
            }
            int i = a.b[L0().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return new BigDecimal((BigInteger) numberM0);
                }
                if (i != 5) {
                    return BigDecimal.valueOf(numberM0.doubleValue());
                }
            }
            return BigDecimal.valueOf(numberM0.longValue());
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public double G0() {
            return M0().doubleValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public Object H0() {
            if (this.d == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return d2();
            }
            return null;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public float I0() {
            return M0().floatValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public int J0() {
            Number numberM0 = this.d == JsonToken.VALUE_NUMBER_INT ? (Number) d2() : M0();
            return ((numberM0 instanceof Integer) || e2(numberM0)) ? numberM0.intValue() : b2(numberM0);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public long K0() {
            Number numberM0 = this.d == JsonToken.VALUE_NUMBER_INT ? (Number) d2() : M0();
            return ((numberM0 instanceof Long) || f2(numberM0)) ? numberM0.longValue() : c2(numberM0);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public JsonParser.NumberType L0() throws JsonParseException {
            Number numberM0 = M0();
            if (numberM0 instanceof Integer) {
                return JsonParser.NumberType.INT;
            }
            if (numberM0 instanceof Long) {
                return JsonParser.NumberType.LONG;
            }
            if (numberM0 instanceof Double) {
                return JsonParser.NumberType.DOUBLE;
            }
            if (numberM0 instanceof BigDecimal) {
                return JsonParser.NumberType.BIG_DECIMAL;
            }
            if (numberM0 instanceof BigInteger) {
                return JsonParser.NumberType.BIG_INTEGER;
            }
            if (numberM0 instanceof Float) {
                return JsonParser.NumberType.FLOAT;
            }
            if (numberM0 instanceof Short) {
                return JsonParser.NumberType.INT;
            }
            return null;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final Number M0() throws JsonParseException {
            a2();
            Object objD2 = d2();
            if (objD2 instanceof Number) {
                return (Number) objD2;
            }
            if (objD2 instanceof String) {
                String str = (String) objD2;
                return str.indexOf(46) >= 0 ? Double.valueOf(hs1.j(str, g1(StreamReadFeature.USE_FAST_DOUBLE_PARSER))) : Long.valueOf(hs1.o(str));
            }
            if (objD2 == null) {
                return null;
            }
            throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + objD2.getClass().getName());
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public Object O0() {
            return this.t.h(this.u);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public h71 P0() {
            return this.v;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public d41 Q0() {
            return JsonParser.c;
        }

        @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
        public String S0() {
            JsonToken jsonToken = this.d;
            if (jsonToken == JsonToken.VALUE_STRING || jsonToken == JsonToken.FIELD_NAME) {
                Object objD2 = d2();
                return objD2 instanceof String ? (String) objD2 : ay.a0(objD2);
            }
            if (jsonToken == null) {
                return null;
            }
            int i = a.a[jsonToken.ordinal()];
            return (i == 7 || i == 8) ? ay.a0(d2()) : this.d.asString();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public char[] T0() {
            String strS0 = S0();
            if (strS0 == null) {
                return null;
            }
            return strS0.toCharArray();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public int U0() {
            String strS0 = S0();
            if (strS0 == null) {
                return 0;
            }
            return strS0.length();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public int V0() {
            return 0;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public JsonLocation W0() {
            return w0();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public Object X0() {
            return this.t.i(this.u);
        }

        protected final void a2() throws JsonParseException {
            JsonToken jsonToken = this.d;
            if (jsonToken == null || !jsonToken.isNumeric()) {
                throw n("Current token (" + this.d + ") not numeric, cannot use numeric value accessors");
            }
        }

        protected int b2(Number number) {
            if (number instanceof Long) {
                long jLongValue = number.longValue();
                int i = (int) jLongValue;
                if (i != jLongValue) {
                    U1();
                }
                return i;
            }
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) number;
                if (ez1.h.compareTo(bigInteger) > 0 || ez1.i.compareTo(bigInteger) < 0) {
                    U1();
                }
            } else {
                if ((number instanceof Double) || (number instanceof Float)) {
                    double dDoubleValue = number.doubleValue();
                    if (dDoubleValue < -2.147483648E9d || dDoubleValue > 2.147483647E9d) {
                        U1();
                    }
                    return (int) dDoubleValue;
                }
                if (number instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal) number;
                    if (ez1.n.compareTo(bigDecimal) > 0 || ez1.o.compareTo(bigDecimal) < 0) {
                        U1();
                    }
                } else {
                    N1();
                }
            }
            return number.intValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public boolean c1() {
            return false;
        }

        protected long c2(Number number) {
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) number;
                if (ez1.j.compareTo(bigInteger) > 0 || ez1.k.compareTo(bigInteger) < 0) {
                    X1();
                }
            } else {
                if ((number instanceof Double) || (number instanceof Float)) {
                    double dDoubleValue = number.doubleValue();
                    if (dDoubleValue < -9.223372036854776E18d || dDoubleValue > 9.223372036854776E18d) {
                        X1();
                    }
                    return (long) dDoubleValue;
                }
                if (number instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal) number;
                    if (ez1.l.compareTo(bigDecimal) > 0 || ez1.m.compareTo(bigDecimal) < 0) {
                        X1();
                    }
                } else {
                    N1();
                }
            }
            return number.longValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.w) {
                return;
            }
            this.w = true;
        }

        protected final Object d2() {
            return this.t.j(this.u);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public BigInteger e0() throws JsonParseException {
            Number numberM0 = M0();
            if (numberM0 instanceof BigInteger) {
                return (BigInteger) numberM0;
            }
            return L0() == JsonParser.NumberType.BIG_DECIMAL ? ((BigDecimal) numberM0).toBigInteger() : BigInteger.valueOf(numberM0.longValue());
        }

        public void g2(JsonLocation jsonLocation) {
            this.y = jsonLocation;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public byte[] j0(Base64Variant base64Variant) throws JsonParseException {
            if (this.d == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object objD2 = d2();
                if (objD2 instanceof byte[]) {
                    return (byte[]) objD2;
                }
            }
            if (this.d != JsonToken.VALUE_STRING) {
                throw n("Current token (" + this.d + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), cannot access as binary");
            }
            String strS0 = S0();
            if (strS0 == null) {
                return null;
            }
            zo zoVar = this.x;
            if (zoVar == null) {
                zoVar = new zo(100);
                this.x = zoVar;
            } else {
                zoVar.j0();
            }
            x1(strS0, zoVar, base64Variant);
            return zoVar.t0();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public boolean k1() {
            if (this.d != JsonToken.VALUE_NUMBER_FLOAT) {
                return false;
            }
            Object objD2 = d2();
            if (objD2 instanceof Double) {
                Double d = (Double) objD2;
                return d.isNaN() || d.isInfinite();
            }
            if (!(objD2 instanceof Float)) {
                return false;
            }
            Float f = (Float) objD2;
            return f.isNaN() || f.isInfinite();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public String l1() {
            c cVar;
            if (this.w || (cVar = this.t) == null) {
                return null;
            }
            int i = this.u + 1;
            if (i < 16) {
                JsonToken jsonTokenQ = cVar.q(i);
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                if (jsonTokenQ == jsonToken) {
                    this.u = i;
                    this.d = jsonToken;
                    Object objJ = this.t.j(i);
                    String string = objJ instanceof String ? (String) objJ : objJ.toString();
                    this.v.r(string);
                    return string;
                }
            }
            if (n1() == JsonToken.FIELD_NAME) {
                return C();
            }
            return null;
        }

        @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
        public JsonToken n1() {
            c cVar;
            if (this.w || (cVar = this.t) == null) {
                return null;
            }
            int i = this.u + 1;
            this.u = i;
            if (i >= 16) {
                this.u = 0;
                c cVarL = cVar.l();
                this.t = cVarL;
                if (cVarL == null) {
                    return null;
                }
            }
            JsonToken jsonTokenQ = this.t.q(this.u);
            this.d = jsonTokenQ;
            if (jsonTokenQ == JsonToken.FIELD_NAME) {
                Object objD2 = d2();
                this.v.r(objD2 instanceof String ? (String) objD2 : objD2.toString());
            } else if (jsonTokenQ == JsonToken.START_OBJECT) {
                this.v = this.v.o();
            } else if (jsonTokenQ == JsonToken.START_ARRAY) {
                this.v = this.v.n();
            } else if (jsonTokenQ == JsonToken.END_OBJECT || jsonTokenQ == JsonToken.END_ARRAY) {
                this.v = this.v.q();
            } else {
                this.v.s();
            }
            return this.d;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public int q1(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
            byte[] bArrJ0 = j0(base64Variant);
            if (bArrJ0 == null) {
                return 0;
            }
            outputStream.write(bArrJ0, 0, bArrJ0.length);
            return bArrJ0.length;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public jt1 t0() {
            return this.p;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public boolean u() {
            return this.r;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public boolean w() {
            return this.f375q;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public JsonLocation w0() {
            JsonLocation jsonLocation = this.y;
            return jsonLocation == null ? JsonLocation.NA : jsonLocation;
        }

        @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
        public String y0() {
            return C();
        }

        @Override // defpackage.ez1
        protected void z1() {
            N1();
        }
    }

    protected static final class c {
        private static final JsonToken[] e;
        protected c a;
        protected long b;
        protected final Object[] c = new Object[16];
        protected TreeMap d;

        static {
            JsonToken[] jsonTokenArr = new JsonToken[16];
            e = jsonTokenArr;
            JsonToken[] jsonTokenArrValues = JsonToken.values();
            System.arraycopy(jsonTokenArrValues, 1, jsonTokenArr, 1, Math.min(15, jsonTokenArrValues.length - 1));
        }

        private final int a(int i) {
            return i + i + 1;
        }

        private final int b(int i) {
            return i + i;
        }

        private final void g(int i, Object obj, Object obj2) {
            if (this.d == null) {
                this.d = new TreeMap();
            }
            if (obj != null) {
                this.d.put(Integer.valueOf(a(i)), obj);
            }
            if (obj2 != null) {
                this.d.put(Integer.valueOf(b(i)), obj2);
            }
        }

        private void m(int i, JsonToken jsonToken) {
            long jOrdinal = jsonToken.ordinal();
            if (i > 0) {
                jOrdinal <<= i << 2;
            }
            this.b |= jOrdinal;
        }

        private void n(int i, JsonToken jsonToken, Object obj) {
            this.c[i] = obj;
            long jOrdinal = jsonToken.ordinal();
            if (i > 0) {
                jOrdinal <<= i << 2;
            }
            this.b |= jOrdinal;
        }

        private void o(int i, JsonToken jsonToken, Object obj, Object obj2) {
            long jOrdinal = jsonToken.ordinal();
            if (i > 0) {
                jOrdinal <<= i << 2;
            }
            this.b = jOrdinal | this.b;
            g(i, obj, obj2);
        }

        private void p(int i, JsonToken jsonToken, Object obj, Object obj2, Object obj3) {
            this.c[i] = obj;
            long jOrdinal = jsonToken.ordinal();
            if (i > 0) {
                jOrdinal <<= i << 2;
            }
            this.b = jOrdinal | this.b;
            g(i, obj2, obj3);
        }

        public c c(int i, JsonToken jsonToken) {
            if (i < 16) {
                m(i, jsonToken);
                return null;
            }
            c cVar = new c();
            this.a = cVar;
            cVar.m(0, jsonToken);
            return this.a;
        }

        public c d(int i, JsonToken jsonToken, Object obj) {
            if (i < 16) {
                n(i, jsonToken, obj);
                return null;
            }
            c cVar = new c();
            this.a = cVar;
            cVar.n(0, jsonToken, obj);
            return this.a;
        }

        public c e(int i, JsonToken jsonToken, Object obj, Object obj2) {
            if (i < 16) {
                o(i, jsonToken, obj, obj2);
                return null;
            }
            c cVar = new c();
            this.a = cVar;
            cVar.o(0, jsonToken, obj, obj2);
            return this.a;
        }

        public c f(int i, JsonToken jsonToken, Object obj, Object obj2, Object obj3) {
            if (i < 16) {
                p(i, jsonToken, obj, obj2, obj3);
                return null;
            }
            c cVar = new c();
            this.a = cVar;
            cVar.p(0, jsonToken, obj, obj2, obj3);
            return this.a;
        }

        Object h(int i) {
            TreeMap treeMap = this.d;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(a(i)));
        }

        Object i(int i) {
            TreeMap treeMap = this.d;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(b(i)));
        }

        public Object j(int i) {
            return this.c[i];
        }

        public boolean k() {
            return this.d != null;
        }

        public c l() {
            return this.a;
        }

        public JsonToken q(int i) {
            long j = this.b;
            if (i > 0) {
                j >>= i << 2;
            }
            return e[((int) j) & 15];
        }
    }

    public q33(jt1 jt1Var, boolean z) {
        this.e = jt1Var;
        c cVar = new c();
        this.n = cVar;
        this.m = cVar;
        this.o = 0;
        this.i = z;
        this.j = z;
        this.k = z || z;
    }

    private final void E1(StringBuilder sb) {
        Object objH = this.n.h(this.o - 1);
        if (objH != null) {
            sb.append("[objectId=");
            sb.append(String.valueOf(objH));
            sb.append(']');
        }
        Object objI = this.n.i(this.o - 1);
        if (objI != null) {
            sb.append("[typeId=");
            sb.append(String.valueOf(objI));
            sb.append(']');
        }
    }

    private final void I1(JsonParser jsonParser) {
        Object objX0 = jsonParser.X0();
        this.p = objX0;
        if (objX0 != null) {
            this.r = true;
        }
        Object objO0 = jsonParser.O0();
        this.f374q = objO0;
        if (objO0 != null) {
            this.r = true;
        }
    }

    private void K1(JsonParser jsonParser, JsonToken jsonToken) {
        if (this.k) {
            I1(jsonParser);
        }
        switch (a.a[jsonToken.ordinal()]) {
            case 6:
                if (jsonParser.c1()) {
                    x1(jsonParser.T0(), jsonParser.V0(), jsonParser.U0());
                    return;
                } else {
                    w1(jsonParser.S0());
                    return;
                }
            case 7:
                int i = a.b[jsonParser.L0().ordinal()];
                if (i == 1) {
                    Z0(jsonParser.J0());
                    return;
                } else if (i != 2) {
                    a1(jsonParser.K0());
                    return;
                } else {
                    d1(jsonParser.e0());
                    return;
                }
            case 8:
                if (this.l) {
                    c1(jsonParser.F0());
                    return;
                } else {
                    H1(JsonToken.VALUE_NUMBER_FLOAT, jsonParser.N0());
                    return;
                }
            case 9:
                P0(true);
                return;
            case 10:
                P0(false);
                return;
            case 11:
                W0();
                return;
            case 12:
                f1(jsonParser.H0());
                return;
            default:
                throw new RuntimeException("Internal error: unexpected token: " + jsonToken);
        }
    }

    protected final void C1(JsonToken jsonToken) {
        c cVarC = this.n.c(this.o, jsonToken);
        if (cVarC == null) {
            this.o++;
        } else {
            this.n = cVarC;
            this.o = 1;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean D() {
        return true;
    }

    protected final void D1(Object obj) {
        c cVarF = this.r ? this.n.f(this.o, JsonToken.FIELD_NAME, obj, this.f374q, this.p) : this.n.d(this.o, JsonToken.FIELD_NAME, obj);
        if (cVarF == null) {
            this.o++;
        } else {
            this.n = cVarF;
            this.o = 1;
        }
    }

    protected final void F1(JsonToken jsonToken) {
        c cVarE = this.r ? this.n.e(this.o, jsonToken, this.f374q, this.p) : this.n.c(this.o, jsonToken);
        if (cVarE == null) {
            this.o++;
        } else {
            this.n = cVarE;
            this.o = 1;
        }
    }

    protected final void G1(JsonToken jsonToken) {
        this.s.A();
        c cVarE = this.r ? this.n.e(this.o, jsonToken, this.f374q, this.p) : this.n.c(this.o, jsonToken);
        if (cVarE == null) {
            this.o++;
        } else {
            this.n = cVarE;
            this.o = 1;
        }
    }

    protected final void H1(JsonToken jsonToken, Object obj) {
        this.s.A();
        c cVarF = this.r ? this.n.f(this.o, jsonToken, obj, this.f374q, this.p) : this.n.d(this.o, jsonToken, obj);
        if (cVarF == null) {
            this.o++;
        } else {
            this.n = cVarF;
            this.o = 1;
        }
    }

    protected void J1(JsonParser jsonParser) throws JsonGenerationException {
        int i = 1;
        while (true) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            if (jsonTokenN1 == null) {
                return;
            }
            int i2 = a.a[jsonTokenN1.ordinal()];
            if (i2 == 1) {
                if (this.k) {
                    I1(jsonParser);
                }
                s1();
            } else if (i2 == 2) {
                S0();
                i--;
                if (i == 0) {
                    return;
                }
            } else if (i2 == 3) {
                if (this.k) {
                    I1(jsonParser);
                }
                p1();
            } else if (i2 == 4) {
                R0();
                i--;
                if (i == 0) {
                    return;
                }
            } else if (i2 != 5) {
                K1(jsonParser, jsonTokenN1);
            } else {
                if (this.k) {
                    I1(jsonParser);
                }
                V0(jsonParser.C());
            }
            i++;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int K0(Base64Variant base64Variant, InputStream inputStream, int i) {
        throw new UnsupportedOperationException();
    }

    protected void L1() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void M0(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        f1(bArr2);
    }

    public q33 M1(q33 q33Var) {
        if (!this.i) {
            this.i = q33Var.a0();
        }
        if (!this.j) {
            this.j = q33Var.V();
        }
        this.k = this.i || this.j;
        JsonParser jsonParserN1 = q33Var.N1();
        while (jsonParserN1.n1() != null) {
            R1(jsonParserN1);
        }
        return this;
    }

    public JsonParser N1() {
        return O1(this.e);
    }

    public JsonParser O1(jt1 jt1Var) {
        return new b(this.m, jt1Var, this.i, this.j, this.f);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void P0(boolean z) {
        G1(z ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE);
    }

    public JsonParser P1(JsonParser jsonParser) {
        b bVar = new b(this.m, jsonParser.t0(), this.i, this.j, this.f);
        bVar.g2(jsonParser.W0());
        return bVar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void Q0(Object obj) {
        H1(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
    }

    public JsonParser Q1() {
        JsonParser jsonParserO1 = O1(this.e);
        jsonParserO1.n1();
        return jsonParserO1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void R0() {
        C1(JsonToken.END_ARRAY);
        z71 z71VarE = this.s.e();
        if (z71VarE != null) {
            this.s = z71VarE;
        }
    }

    public void R1(JsonParser jsonParser) {
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == JsonToken.FIELD_NAME) {
            if (this.k) {
                I1(jsonParser);
            }
            V0(jsonParser.C());
            jsonTokenD = jsonParser.n1();
        } else if (jsonTokenD == null) {
            throw new IllegalStateException("No token available from argument `JsonParser`");
        }
        int i = a.a[jsonTokenD.ordinal()];
        if (i == 1) {
            if (this.k) {
                I1(jsonParser);
            }
            s1();
            J1(jsonParser);
            return;
        }
        if (i == 2) {
            S0();
            return;
        }
        if (i != 3) {
            if (i != 4) {
                K1(jsonParser, jsonTokenD);
                return;
            } else {
                R0();
                return;
            }
        }
        if (this.k) {
            I1(jsonParser);
        }
        p1();
        J1(jsonParser);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void S0() {
        C1(JsonToken.END_OBJECT);
        z71 z71VarE = this.s.e();
        if (z71VarE != null) {
            this.s = z71VarE;
        }
    }

    public q33 S1(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
        JsonToken jsonTokenN1;
        if (!jsonParser.d1(JsonToken.FIELD_NAME)) {
            R1(jsonParser);
            return this;
        }
        s1();
        do {
            R1(jsonParser);
            jsonTokenN1 = jsonParser.n1();
        } while (jsonTokenN1 == JsonToken.FIELD_NAME);
        JsonToken jsonToken = JsonToken.END_OBJECT;
        if (jsonTokenN1 != jsonToken) {
            deserializationContext.reportWrongTokenException(q33.class, jsonToken, "Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + jsonTokenN1, new Object[0]);
        }
        S0();
        return this;
    }

    public JsonToken T1() {
        return this.m.q(0);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void U0(vm2 vm2Var) throws JsonGenerationException {
        this.s.z(vm2Var.getValue());
        D1(vm2Var);
    }

    public q33 U1(boolean z) {
        this.l = z;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean V() {
        return this.j;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void V0(String str) throws JsonGenerationException {
        this.s.z(str);
        D1(str);
    }

    public int V1() {
        return this.g;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void W0() {
        G1(JsonToken.VALUE_NULL);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public final z71 g0() {
        return this.s;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void X0(double d) {
        H1(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(d));
    }

    public void X1(JsonGenerator jsonGenerator) throws JsonGenerationException {
        c cVarL = this.m;
        boolean z = this.k;
        boolean z2 = z && cVarL.k();
        int i = -1;
        while (true) {
            i++;
            if (i >= 16) {
                cVarL = cVarL.l();
                if (cVarL == null) {
                    return;
                }
                z2 = z && cVarL.k();
                i = 0;
            }
            JsonToken jsonTokenQ = cVarL.q(i);
            if (jsonTokenQ == null) {
                return;
            }
            if (z2) {
                Object objH = cVarL.h(i);
                if (objH != null) {
                    jsonGenerator.g1(objH);
                }
                Object objI = cVarL.i(i);
                if (objI != null) {
                    jsonGenerator.z1(objI);
                }
            }
            switch (a.a[jsonTokenQ.ordinal()]) {
                case 1:
                    jsonGenerator.s1();
                    break;
                case 2:
                    jsonGenerator.S0();
                    break;
                case 3:
                    jsonGenerator.p1();
                    break;
                case 4:
                    jsonGenerator.R0();
                    break;
                case 5:
                    Object objJ = cVarL.j(i);
                    if (!(objJ instanceof vm2)) {
                        jsonGenerator.V0((String) objJ);
                    } else {
                        jsonGenerator.U0((vm2) objJ);
                    }
                    break;
                case 6:
                    Object objJ2 = cVarL.j(i);
                    if (!(objJ2 instanceof vm2)) {
                        jsonGenerator.w1((String) objJ2);
                    } else {
                        jsonGenerator.v1((vm2) objJ2);
                    }
                    break;
                case 7:
                    Object objJ3 = cVarL.j(i);
                    if (objJ3 instanceof Integer) {
                        jsonGenerator.Z0(((Integer) objJ3).intValue());
                    } else if (objJ3 instanceof BigInteger) {
                        jsonGenerator.d1((BigInteger) objJ3);
                    } else if (objJ3 instanceof Long) {
                        jsonGenerator.a1(((Long) objJ3).longValue());
                    } else if (!(objJ3 instanceof Short)) {
                        jsonGenerator.Z0(((Number) objJ3).intValue());
                    } else {
                        jsonGenerator.e1(((Short) objJ3).shortValue());
                    }
                    break;
                case 8:
                    Object objJ4 = cVarL.j(i);
                    if (objJ4 instanceof Double) {
                        jsonGenerator.X0(((Double) objJ4).doubleValue());
                    } else if (objJ4 instanceof BigDecimal) {
                        jsonGenerator.c1((BigDecimal) objJ4);
                    } else if (objJ4 instanceof Float) {
                        jsonGenerator.Y0(((Float) objJ4).floatValue());
                    } else if (objJ4 == null) {
                        jsonGenerator.W0();
                    } else if (!(objJ4 instanceof String)) {
                        n(String.format("Unrecognized value type for VALUE_NUMBER_FLOAT: %s, cannot serialize", objJ4.getClass().getName()));
                    } else {
                        jsonGenerator.b1((String) objJ4);
                    }
                    break;
                case 9:
                    jsonGenerator.P0(true);
                    break;
                case 10:
                    jsonGenerator.P0(false);
                    break;
                case 11:
                    jsonGenerator.W0();
                    break;
                case 12:
                    Object objJ5 = cVarL.j(i);
                    if (objJ5 instanceof na2) {
                        ((na2) objJ5).b(jsonGenerator);
                    } else if (!(objJ5 instanceof com.fasterxml.jackson.databind.a)) {
                        jsonGenerator.Q0(objJ5);
                    } else {
                        jsonGenerator.f1(objJ5);
                    }
                    break;
                default:
                    throw new RuntimeException("Internal error: should never end up through this code path");
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void Y0(float f) {
        H1(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(f));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void Z0(int i) {
        H1(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(i));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean a0() {
        return this.i;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a1(long j) {
        H1(JsonToken.VALUE_NUMBER_INT, Long.valueOf(j));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void b1(String str) {
        H1(JsonToken.VALUE_NUMBER_FLOAT, str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void c1(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            W0();
        } else {
            H1(JsonToken.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.h = true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void d1(BigInteger bigInteger) {
        if (bigInteger == null) {
            W0();
        } else {
            H1(JsonToken.VALUE_NUMBER_INT, bigInteger);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator e0(JsonGenerator.Feature feature) {
        this.g = (~feature.getMask()) & this.g;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void e1(short s) {
        H1(JsonToken.VALUE_NUMBER_INT, Short.valueOf(s));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void f1(Object obj) {
        if (obj == null) {
            W0();
            return;
        }
        if (obj.getClass() == byte[].class || (obj instanceof na2)) {
            H1(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
            return;
        }
        jt1 jt1Var = this.e;
        if (jt1Var == null) {
            H1(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
        } else {
            jt1Var.writeValue(this, obj);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() {
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void g1(Object obj) {
        this.f374q = obj;
        this.r = true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void j1(char c2) {
        L1();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean k0(JsonGenerator.Feature feature) {
        return (feature.getMask() & this.g) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void k1(vm2 vm2Var) {
        L1();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void l1(String str) {
        L1();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void m1(char[] cArr, int i, int i2) {
        L1();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void o1(String str) {
        H1(JsonToken.VALUE_EMBEDDED_OBJECT, new na2(str));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void p1() {
        this.s.A();
        F1(JsonToken.START_ARRAY);
        this.s = this.s.p();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void q1(Object obj) {
        this.s.A();
        F1(JsonToken.START_ARRAY);
        this.s = this.s.q(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void r1(Object obj, int i) {
        this.s.A();
        F1(JsonToken.START_ARRAY);
        this.s = this.s.q(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void s1() {
        this.s.A();
        F1(JsonToken.START_OBJECT);
        this.s = this.s.r();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator t0(int i, int i2) {
        this.g = (i & i2) | (V1() & (~i2));
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void t1(Object obj) {
        this.s.A();
        F1(JsonToken.START_OBJECT);
        this.s = this.s.s(obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TokenBuffer: ");
        JsonParser jsonParserN1 = N1();
        int i = 0;
        boolean z = this.i || this.j;
        while (true) {
            try {
                JsonToken jsonTokenN1 = jsonParserN1.n1();
                if (jsonTokenN1 == null) {
                    break;
                }
                if (z) {
                    E1(sb);
                }
                if (i < 100) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(jsonTokenN1.toString());
                    if (jsonTokenN1 == JsonToken.FIELD_NAME) {
                        sb.append('(');
                        sb.append(jsonParserN1.C());
                        sb.append(')');
                    }
                }
                i++;
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        if (i >= 100) {
            sb.append(" ... (truncated ");
            sb.append(i - 100);
            sb.append(" entries)");
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void u1(Object obj, int i) {
        this.s.A();
        F1(JsonToken.START_OBJECT);
        this.s = this.s.s(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void v1(vm2 vm2Var) {
        if (vm2Var == null) {
            W0();
        } else {
            H1(JsonToken.VALUE_STRING, vm2Var);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void w1(String str) {
        if (str == null) {
            W0();
        } else {
            H1(JsonToken.VALUE_STRING, str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void x1(char[] cArr, int i, int i2) {
        w1(new String(cArr, i, i2));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void z1(Object obj) {
        this.p = obj;
        this.r = true;
    }

    public q33(JsonParser jsonParser, DeserializationContext deserializationContext) {
        this.e = jsonParser.t0();
        this.f = jsonParser.P0();
        c cVar = new c();
        this.n = cVar;
        this.m = cVar;
        this.o = 0;
        this.i = jsonParser.w();
        boolean zU = jsonParser.u();
        this.j = zU;
        this.k = this.i || zU;
        this.l = deserializationContext != null ? deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) : false;
    }
}
