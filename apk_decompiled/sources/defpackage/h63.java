package defpackage;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h63 {
    public static final e63 A;
    public static final e63 B;
    public static final f63 C;
    public static final e63 D;
    public static final f63 E;
    public static final e63 F;
    public static final f63 G;
    public static final e63 H;
    public static final f63 I;
    public static final e63 J;
    public static final f63 K;
    public static final e63 L;
    public static final f63 M;
    public static final e63 N;
    public static final f63 O;
    public static final e63 P;
    public static final f63 Q;
    public static final e63 R;
    public static final f63 S;
    public static final e63 T;
    public static final f63 U;
    public static final e63 V;
    public static final f63 W;
    public static final f63 X;
    public static final e63 a;
    public static final f63 b;
    public static final e63 c;
    public static final f63 d;
    public static final e63 e;
    public static final e63 f;
    public static final f63 g;
    public static final e63 h;
    public static final f63 i;
    public static final e63 j;
    public static final f63 k;
    public static final e63 l;
    public static final f63 m;
    public static final e63 n;
    public static final f63 o;
    public static final e63 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final f63 f343q;
    public static final e63 r;
    public static final f63 s;
    public static final e63 t;
    public static final e63 u;
    public static final e63 v;
    public static final e63 w;
    public static final f63 x;
    public static final e63 y;
    public static final e63 z;

    class a extends e63 {
        a() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(a71 a71Var) throws IOException {
            ArrayList arrayList = new ArrayList();
            a71Var.n();
            while (a71Var.j0()) {
                try {
                    arrayList.add(Integer.valueOf(a71Var.A0()));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }
            a71Var.D();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, AtomicIntegerArray atomicIntegerArray) throws IOException {
            a81Var.w();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                a81Var.M0(atomicIntegerArray.get(i));
            }
            a81Var.D();
        }
    }

    class a0 implements f63 {
        final /* synthetic */ Class a;
        final /* synthetic */ e63 b;

        class a extends e63 {
            final /* synthetic */ Class a;

            a(Class cls) {
                this.a = cls;
            }

            @Override // defpackage.e63
            public Object b(a71 a71Var) {
                Object objB = a0.this.b.b(a71Var);
                if (objB == null || this.a.isInstance(objB)) {
                    return objB;
                }
                throw new JsonSyntaxException("Expected a " + this.a.getName() + " but was " + objB.getClass().getName() + "; at path " + a71Var.g0());
            }

            @Override // defpackage.e63
            public void e(a81 a81Var, Object obj) {
                a0.this.b.e(a81Var, obj);
            }
        }

        a0(Class cls, e63 e63Var) {
            this.a = cls;
            this.b = e63Var;
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            Class<?> rawType = typeToken.getRawType();
            if (this.a.isAssignableFrom(rawType)) {
                return new a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
        }
    }

    class b extends e63 {
        b() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            try {
                return Long.valueOf(a71Var.F0());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Number number) throws IOException {
            if (number == null) {
                a81Var.t0();
            } else {
                a81Var.M0(number.longValue());
            }
        }
    }

    static /* synthetic */ class b0 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    class c extends e63 {
        c() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number b(a71 a71Var) throws IOException {
            if (a71Var.M0() != JsonToken.NULL) {
                return Float.valueOf((float) a71Var.y0());
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Number number) throws IOException {
            if (number == null) {
                a81Var.t0();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            a81Var.O0(number);
        }
    }

    class c0 extends e63 {
        c0() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean b(a71 a71Var) throws IOException {
            JsonToken jsonTokenM0 = a71Var.M0();
            if (jsonTokenM0 != JsonToken.NULL) {
                return jsonTokenM0 == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(a71Var.K0())) : Boolean.valueOf(a71Var.w0());
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Boolean bool) throws IOException {
            a81Var.N0(bool);
        }
    }

    class d extends e63 {
        d() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number b(a71 a71Var) throws IOException {
            if (a71Var.M0() != JsonToken.NULL) {
                return Double.valueOf(a71Var.y0());
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Number number) throws IOException {
            if (number == null) {
                a81Var.t0();
            } else {
                a81Var.L0(number.doubleValue());
            }
        }
    }

    class d0 extends e63 {
        d0() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean b(a71 a71Var) throws IOException {
            if (a71Var.M0() != JsonToken.NULL) {
                return Boolean.valueOf(a71Var.K0());
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Boolean bool) throws IOException {
            a81Var.P0(bool == null ? "null" : bool.toString());
        }
    }

    class e extends e63 {
        e() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Character b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            String strK0 = a71Var.K0();
            if (strK0.length() == 1) {
                return Character.valueOf(strK0.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + strK0 + "; at " + a71Var.g0());
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Character ch) throws IOException {
            a81Var.P0(ch == null ? null : String.valueOf(ch));
        }
    }

    class e0 extends e63 {
        e0() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            try {
                int iA0 = a71Var.A0();
                if (iA0 <= 255 && iA0 >= -128) {
                    return Byte.valueOf((byte) iA0);
                }
                throw new JsonSyntaxException("Lossy conversion from " + iA0 + " to byte; at path " + a71Var.g0());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Number number) throws IOException {
            if (number == null) {
                a81Var.t0();
            } else {
                a81Var.M0(number.byteValue());
            }
        }
    }

    class f extends e63 {
        f() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public String b(a71 a71Var) throws IOException {
            JsonToken jsonTokenM0 = a71Var.M0();
            if (jsonTokenM0 != JsonToken.NULL) {
                return jsonTokenM0 == JsonToken.BOOLEAN ? Boolean.toString(a71Var.w0()) : a71Var.K0();
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, String str) throws IOException {
            a81Var.P0(str);
        }
    }

    class f0 extends e63 {
        f0() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            try {
                int iA0 = a71Var.A0();
                if (iA0 <= 65535 && iA0 >= -32768) {
                    return Short.valueOf((short) iA0);
                }
                throw new JsonSyntaxException("Lossy conversion from " + iA0 + " to short; at path " + a71Var.g0());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Number number) throws IOException {
            if (number == null) {
                a81Var.t0();
            } else {
                a81Var.M0(number.shortValue());
            }
        }
    }

    class g extends e63 {
        g() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            String strK0 = a71Var.K0();
            try {
                return new BigDecimal(strK0);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException("Failed parsing '" + strK0 + "' as BigDecimal; at path " + a71Var.g0(), e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, BigDecimal bigDecimal) throws IOException {
            a81Var.O0(bigDecimal);
        }
    }

    class g0 extends e63 {
        g0() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            try {
                return Integer.valueOf(a71Var.A0());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Number number) throws IOException {
            if (number == null) {
                a81Var.t0();
            } else {
                a81Var.M0(number.intValue());
            }
        }
    }

    class h extends e63 {
        h() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BigInteger b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            String strK0 = a71Var.K0();
            try {
                return new BigInteger(strK0);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException("Failed parsing '" + strK0 + "' as BigInteger; at path " + a71Var.g0(), e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, BigInteger bigInteger) throws IOException {
            a81Var.O0(bigInteger);
        }
    }

    class h0 extends e63 {
        h0() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(a71 a71Var) {
            try {
                return new AtomicInteger(a71Var.A0());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, AtomicInteger atomicInteger) throws IOException {
            a81Var.M0(atomicInteger.get());
        }
    }

    class i extends e63 {
        i() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public LazilyParsedNumber b(a71 a71Var) throws IOException {
            if (a71Var.M0() != JsonToken.NULL) {
                return new LazilyParsedNumber(a71Var.K0());
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, LazilyParsedNumber lazilyParsedNumber) throws IOException {
            a81Var.O0(lazilyParsedNumber);
        }
    }

    class i0 extends e63 {
        i0() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(a71 a71Var) {
            return new AtomicBoolean(a71Var.w0());
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, AtomicBoolean atomicBoolean) throws IOException {
            a81Var.Q0(atomicBoolean.get());
        }
    }

    class j extends e63 {
        j() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(a71 a71Var) throws IOException {
            if (a71Var.M0() != JsonToken.NULL) {
                return new StringBuilder(a71Var.K0());
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, StringBuilder sb) throws IOException {
            a81Var.P0(sb == null ? null : sb.toString());
        }
    }

    private static final class j0 extends e63 {
        private final Map a = new HashMap();
        private final Map b = new HashMap();
        private final Map c = new HashMap();

        class a implements PrivilegedAction {
            final /* synthetic */ Class a;

            a(Class cls) {
                this.a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() {
                Field[] declaredFields = this.a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public j0(Class cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r4 = (Enum) field.get(null);
                    String strName = r4.name();
                    String string = r4.toString();
                    xm2 xm2Var = (xm2) field.getAnnotation(xm2.class);
                    if (xm2Var != null) {
                        strName = xm2Var.value();
                        for (String str : xm2Var.alternate()) {
                            this.a.put(str, r4);
                        }
                    }
                    this.a.put(strName, r4);
                    this.b.put(string, r4);
                    this.c.put(r4, strName);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Enum b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            String strK0 = a71Var.K0();
            Enum r0 = (Enum) this.a.get(strK0);
            return r0 == null ? (Enum) this.b.get(strK0) : r0;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Enum r3) throws IOException {
            a81Var.P0(r3 == null ? null : (String) this.c.get(r3));
        }
    }

    class k extends e63 {
        k() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Class b(a71 a71Var) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    class l extends e63 {
        l() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(a71 a71Var) throws IOException {
            if (a71Var.M0() != JsonToken.NULL) {
                return new StringBuffer(a71Var.K0());
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, StringBuffer stringBuffer) throws IOException {
            a81Var.P0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    class m extends e63 {
        m() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public URL b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            String strK0 = a71Var.K0();
            if ("null".equals(strK0)) {
                return null;
            }
            return new URL(strK0);
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, URL url) throws IOException {
            a81Var.P0(url == null ? null : url.toExternalForm());
        }
    }

    class n extends e63 {
        n() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public URI b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            try {
                String strK0 = a71Var.K0();
                if ("null".equals(strK0)) {
                    return null;
                }
                return new URI(strK0);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, URI uri) throws IOException {
            a81Var.P0(uri == null ? null : uri.toASCIIString());
        }
    }

    class o extends e63 {
        o() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public InetAddress b(a71 a71Var) throws IOException {
            if (a71Var.M0() != JsonToken.NULL) {
                return InetAddress.getByName(a71Var.K0());
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, InetAddress inetAddress) throws IOException {
            a81Var.P0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    class p extends e63 {
        p() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public UUID b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            String strK0 = a71Var.K0();
            try {
                return UUID.fromString(strK0);
            } catch (IllegalArgumentException e) {
                throw new JsonSyntaxException("Failed parsing '" + strK0 + "' as UUID; at path " + a71Var.g0(), e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, UUID uuid) throws IOException {
            a81Var.P0(uuid == null ? null : uuid.toString());
        }
    }

    class q extends e63 {
        q() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Currency b(a71 a71Var) throws IOException {
            String strK0 = a71Var.K0();
            try {
                return Currency.getInstance(strK0);
            } catch (IllegalArgumentException e) {
                throw new JsonSyntaxException("Failed parsing '" + strK0 + "' as Currency; at path " + a71Var.g0(), e);
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Currency currency) throws IOException {
            a81Var.P0(currency.getCurrencyCode());
        }
    }

    class r extends e63 {
        r() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Calendar b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            a71Var.u();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (a71Var.M0() != JsonToken.END_OBJECT) {
                String strG0 = a71Var.G0();
                int iA0 = a71Var.A0();
                if ("year".equals(strG0)) {
                    i = iA0;
                } else if ("month".equals(strG0)) {
                    i2 = iA0;
                } else if ("dayOfMonth".equals(strG0)) {
                    i3 = iA0;
                } else if ("hourOfDay".equals(strG0)) {
                    i4 = iA0;
                } else if ("minute".equals(strG0)) {
                    i5 = iA0;
                } else if ("second".equals(strG0)) {
                    i6 = iA0;
                }
            }
            a71Var.V();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Calendar calendar) throws IOException {
            if (calendar == null) {
                a81Var.t0();
                return;
            }
            a81Var.y();
            a81Var.k0("year");
            a81Var.M0(calendar.get(1));
            a81Var.k0("month");
            a81Var.M0(calendar.get(2));
            a81Var.k0("dayOfMonth");
            a81Var.M0(calendar.get(5));
            a81Var.k0("hourOfDay");
            a81Var.M0(calendar.get(11));
            a81Var.k0("minute");
            a81Var.M0(calendar.get(12));
            a81Var.k0("second");
            a81Var.M0(calendar.get(13));
            a81Var.V();
        }
    }

    class s extends e63 {
        s() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Locale b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(a71Var.K0(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Locale locale) throws IOException {
            a81Var.P0(locale == null ? null : locale.toString());
        }
    }

    class t extends e63 {
        t() {
        }

        private u51 g(a71 a71Var, JsonToken jsonToken) throws IOException {
            int i = b0.a[jsonToken.ordinal()];
            if (i == 1) {
                return new v61(new LazilyParsedNumber(a71Var.K0()));
            }
            if (i == 2) {
                return new v61(a71Var.K0());
            }
            if (i == 3) {
                return new v61(Boolean.valueOf(a71Var.w0()));
            }
            if (i == 6) {
                a71Var.I0();
                return l61.a;
            }
            throw new IllegalStateException("Unexpected token: " + jsonToken);
        }

        private u51 h(a71 a71Var, JsonToken jsonToken) throws IOException {
            int i = b0.a[jsonToken.ordinal()];
            if (i == 4) {
                a71Var.n();
                return new l51();
            }
            if (i != 5) {
                return null;
            }
            a71Var.u();
            return new o61();
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public u51 b(a71 a71Var) throws IOException {
            if (a71Var instanceof l71) {
                return ((l71) a71Var).Z0();
            }
            JsonToken jsonTokenM0 = a71Var.M0();
            u51 u51VarH = h(a71Var, jsonTokenM0);
            if (u51VarH == null) {
                return g(a71Var, jsonTokenM0);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (a71Var.j0()) {
                    String strG0 = u51VarH instanceof o61 ? a71Var.G0() : null;
                    JsonToken jsonTokenM1 = a71Var.M0();
                    u51 u51VarH2 = h(a71Var, jsonTokenM1);
                    boolean z = u51VarH2 != null;
                    if (u51VarH2 == null) {
                        u51VarH2 = g(a71Var, jsonTokenM1);
                    }
                    if (u51VarH instanceof l51) {
                        ((l51) u51VarH).j(u51VarH2);
                    } else {
                        ((o61) u51VarH).j(strG0, u51VarH2);
                    }
                    if (z) {
                        arrayDeque.addLast(u51VarH);
                        u51VarH = u51VarH2;
                    }
                } else {
                    if (u51VarH instanceof l51) {
                        a71Var.D();
                    } else {
                        a71Var.V();
                    }
                    if (arrayDeque.isEmpty()) {
                        return u51VarH;
                    }
                    u51VarH = (u51) arrayDeque.removeLast();
                }
            }
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, u51 u51Var) throws IOException {
            if (u51Var == null || u51Var.g()) {
                a81Var.t0();
                return;
            }
            if (u51Var.i()) {
                v61 v61VarD = u51Var.d();
                if (v61VarD.p()) {
                    a81Var.O0(v61VarD.m());
                    return;
                } else if (v61VarD.n()) {
                    a81Var.Q0(v61VarD.j());
                    return;
                } else {
                    a81Var.P0(v61VarD.e());
                    return;
                }
            }
            if (u51Var.f()) {
                a81Var.w();
                Iterator it = u51Var.b().iterator();
                while (it.hasNext()) {
                    e(a81Var, (u51) it.next());
                }
                a81Var.D();
                return;
            }
            if (!u51Var.h()) {
                throw new IllegalArgumentException("Couldn't write " + u51Var.getClass());
            }
            a81Var.y();
            for (Map.Entry entry : u51Var.c().o()) {
                a81Var.k0((String) entry.getKey());
                e(a81Var, (u51) entry.getValue());
            }
            a81Var.V();
        }
    }

    class u implements f63 {
        u() {
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new j0(rawType);
        }
    }

    class v extends e63 {
        v() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BitSet b(a71 a71Var) throws IOException {
            BitSet bitSet = new BitSet();
            a71Var.n();
            JsonToken jsonTokenM0 = a71Var.M0();
            int i = 0;
            while (jsonTokenM0 != JsonToken.END_ARRAY) {
                int i2 = b0.a[jsonTokenM0.ordinal()];
                boolean zW0 = true;
                if (i2 == 1 || i2 == 2) {
                    int iA0 = a71Var.A0();
                    if (iA0 == 0) {
                        zW0 = false;
                    } else if (iA0 != 1) {
                        throw new JsonSyntaxException("Invalid bitset value " + iA0 + ", expected 0 or 1; at path " + a71Var.g0());
                    }
                } else {
                    if (i2 != 3) {
                        throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenM0 + "; at path " + a71Var.c());
                    }
                    zW0 = a71Var.w0();
                }
                if (zW0) {
                    bitSet.set(i);
                }
                i++;
                jsonTokenM0 = a71Var.M0();
            }
            a71Var.D();
            return bitSet;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, BitSet bitSet) throws IOException {
            a81Var.w();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                a81Var.M0(bitSet.get(i) ? 1L : 0L);
            }
            a81Var.D();
        }
    }

    class w implements f63 {
        final /* synthetic */ TypeToken a;
        final /* synthetic */ e63 b;

        w(TypeToken typeToken, e63 e63Var) {
            this.a = typeToken;
            this.b = e63Var;
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            if (typeToken.equals(this.a)) {
                return this.b;
            }
            return null;
        }
    }

    class x implements f63 {
        final /* synthetic */ Class a;
        final /* synthetic */ e63 b;

        x(Class cls, e63 e63Var) {
            this.a = cls;
            this.b = e63Var;
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            if (typeToken.getRawType() == this.a) {
                return this.b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
        }
    }

    class y implements f63 {
        final /* synthetic */ Class a;
        final /* synthetic */ Class b;
        final /* synthetic */ e63 c;

        y(Class cls, Class cls2, e63 e63Var) {
            this.a = cls;
            this.b = cls2;
            this.c = e63Var;
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType == this.a || rawType == this.b) {
                return this.c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.b.getName() + Marker.ANY_NON_NULL_MARKER + this.a.getName() + ",adapter=" + this.c + "]";
        }
    }

    class z implements f63 {
        final /* synthetic */ Class a;
        final /* synthetic */ Class b;
        final /* synthetic */ e63 c;

        z(Class cls, Class cls2, e63 e63Var) {
            this.a = cls;
            this.b = cls2;
            this.c = e63Var;
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType == this.a || rawType == this.b) {
                return this.c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + Marker.ANY_NON_NULL_MARKER + this.b.getName() + ",adapter=" + this.c + "]";
        }
    }

    static {
        e63 e63VarA = new k().a();
        a = e63VarA;
        b = b(Class.class, e63VarA);
        e63 e63VarA2 = new v().a();
        c = e63VarA2;
        d = b(BitSet.class, e63VarA2);
        c0 c0Var = new c0();
        e = c0Var;
        f = new d0();
        g = c(Boolean.TYPE, Boolean.class, c0Var);
        e0 e0Var = new e0();
        h = e0Var;
        i = c(Byte.TYPE, Byte.class, e0Var);
        f0 f0Var = new f0();
        j = f0Var;
        k = c(Short.TYPE, Short.class, f0Var);
        g0 g0Var = new g0();
        l = g0Var;
        m = c(Integer.TYPE, Integer.class, g0Var);
        e63 e63VarA3 = new h0().a();
        n = e63VarA3;
        o = b(AtomicInteger.class, e63VarA3);
        e63 e63VarA4 = new i0().a();
        p = e63VarA4;
        f343q = b(AtomicBoolean.class, e63VarA4);
        e63 e63VarA5 = new a().a();
        r = e63VarA5;
        s = b(AtomicIntegerArray.class, e63VarA5);
        t = new b();
        u = new c();
        v = new d();
        e eVar = new e();
        w = eVar;
        x = c(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        y = fVar;
        z = new g();
        A = new h();
        B = new i();
        C = b(String.class, fVar);
        j jVar = new j();
        D = jVar;
        E = b(StringBuilder.class, jVar);
        l lVar = new l();
        F = lVar;
        G = b(StringBuffer.class, lVar);
        m mVar = new m();
        H = mVar;
        I = b(URL.class, mVar);
        n nVar = new n();
        J = nVar;
        K = b(URI.class, nVar);
        o oVar = new o();
        L = oVar;
        M = e(InetAddress.class, oVar);
        p pVar = new p();
        N = pVar;
        O = b(UUID.class, pVar);
        e63 e63VarA6 = new q().a();
        P = e63VarA6;
        Q = b(Currency.class, e63VarA6);
        r rVar = new r();
        R = rVar;
        S = d(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        T = sVar;
        U = b(Locale.class, sVar);
        t tVar = new t();
        V = tVar;
        W = e(u51.class, tVar);
        X = new u();
    }

    public static f63 a(TypeToken typeToken, e63 e63Var) {
        return new w(typeToken, e63Var);
    }

    public static f63 b(Class cls, e63 e63Var) {
        return new x(cls, e63Var);
    }

    public static f63 c(Class cls, Class cls2, e63 e63Var) {
        return new y(cls, cls2, e63Var);
    }

    public static f63 d(Class cls, Class cls2, e63 e63Var) {
        return new z(cls, cls2, e63Var);
    }

    public static f63 e(Class cls, e63 e63Var) {
        return new a0(cls, e63Var);
    }
}
