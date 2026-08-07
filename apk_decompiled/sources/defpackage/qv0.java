package defpackage;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.ToNumberPolicy;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes3.dex */
public final class qv0 {
    static final ul0 A = FieldNamingPolicy.IDENTITY;
    static final n33 B = ToNumberPolicy.DOUBLE;
    static final n33 C = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    static final String z = null;
    private final ThreadLocal a;
    private final ConcurrentMap b;
    private final p20 c;
    private final f51 d;
    final List e;
    final wi0 f;
    final ul0 g;
    final Map h;
    final boolean i;
    final boolean j;
    final boolean k;
    final boolean l;
    final boolean m;
    final boolean n;
    final boolean o;
    final boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final String f379q;
    final int r;
    final int s;
    final LongSerializationPolicy t;
    final List u;
    final List v;
    final n33 w;
    final n33 x;
    final List y;

    class a extends e63 {
        a() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Double b(a71 a71Var) throws IOException {
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
                return;
            }
            double dDoubleValue = number.doubleValue();
            qv0.d(dDoubleValue);
            a81Var.L0(dDoubleValue);
        }
    }

    class b extends e63 {
        b() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Float b(a71 a71Var) throws IOException {
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
            float fFloatValue = number.floatValue();
            qv0.d(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            a81Var.O0(number);
        }
    }

    class c extends e63 {
        c() {
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number b(a71 a71Var) throws IOException {
            if (a71Var.M0() != JsonToken.NULL) {
                return Long.valueOf(a71Var.F0());
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
                a81Var.P0(number.toString());
            }
        }
    }

    class d extends e63 {
        final /* synthetic */ e63 a;

        d(e63 e63Var) {
            this.a = e63Var;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(a71 a71Var) {
            return new AtomicLong(((Number) this.a.b(a71Var)).longValue());
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, AtomicLong atomicLong) {
            this.a.e(a81Var, Long.valueOf(atomicLong.get()));
        }
    }

    class e extends e63 {
        final /* synthetic */ e63 a;

        e(e63 e63Var) {
            this.a = e63Var;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(a71 a71Var) throws IOException {
            ArrayList arrayList = new ArrayList();
            a71Var.n();
            while (a71Var.j0()) {
                arrayList.add(Long.valueOf(((Number) this.a.b(a71Var)).longValue()));
            }
            a71Var.D();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i = 0; i < size; i++) {
                atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
            }
            return atomicLongArray;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, AtomicLongArray atomicLongArray) throws IOException {
            a81Var.w();
            int length = atomicLongArray.length();
            for (int i = 0; i < length; i++) {
                this.a.e(a81Var, Long.valueOf(atomicLongArray.get(i)));
            }
            a81Var.D();
        }
    }

    static class f extends wm2 {
        private e63 a = null;

        f() {
        }

        private e63 g() {
            e63 e63Var = this.a;
            if (e63Var != null) {
                return e63Var;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // defpackage.e63
        public Object b(a71 a71Var) {
            return g().b(a71Var);
        }

        @Override // defpackage.e63
        public void e(a81 a81Var, Object obj) {
            g().e(a81Var, obj);
        }

        @Override // defpackage.wm2
        public e63 f() {
            return g();
        }

        public void h(e63 e63Var) {
            if (this.a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.a = e63Var;
        }
    }

    public qv0() {
        this(wi0.g, A, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, z, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), B, C, Collections.emptyList());
    }

    private static void a(Object obj, a71 a71Var) {
        if (obj != null) {
            try {
                if (a71Var.M0() == JsonToken.END_DOCUMENT) {
                } else {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    private static e63 b(e63 e63Var) {
        return new d(e63Var).a();
    }

    private static e63 c(e63 e63Var) {
        return new e(e63Var).a();
    }

    static void d(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private e63 e(boolean z2) {
        return z2 ? h63.v : new a();
    }

    private e63 f(boolean z2) {
        return z2 ? h63.u : new b();
    }

    private static e63 j(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? h63.t : new c();
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) r62.b(cls).cast(fromJson(str, TypeToken.get((Class) cls)));
    }

    public e63 g(TypeToken typeToken) {
        boolean z2;
        Objects.requireNonNull(typeToken, "type must not be null");
        e63 e63Var = (e63) this.b.get(typeToken);
        if (e63Var != null) {
            return e63Var;
        }
        Map map = (Map) this.a.get();
        if (map == null) {
            map = new HashMap();
            this.a.set(map);
            z2 = true;
        } else {
            e63 e63Var2 = (e63) map.get(typeToken);
            if (e63Var2 != null) {
                return e63Var2;
            }
            z2 = false;
        }
        try {
            f fVar = new f();
            map.put(typeToken, fVar);
            Iterator it = this.e.iterator();
            e63 e63VarA = null;
            while (it.hasNext()) {
                e63VarA = ((f63) it.next()).a(this, typeToken);
                if (e63VarA != null) {
                    fVar.h(e63VarA);
                    map.put(typeToken, e63VarA);
                    break;
                }
            }
            if (z2) {
                this.a.remove();
            }
            if (e63VarA != null) {
                if (z2) {
                    this.b.putAll(map);
                }
                return e63VarA;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + typeToken);
        } catch (Throwable th) {
            if (z2) {
                this.a.remove();
            }
            throw th;
        }
    }

    public e63 h(Class cls) {
        return g(TypeToken.get(cls));
    }

    public e63 i(f63 f63Var, TypeToken typeToken) {
        if (!this.e.contains(f63Var)) {
            f63Var = this.d;
        }
        boolean z2 = false;
        for (f63 f63Var2 : this.e) {
            if (z2) {
                e63 e63VarA = f63Var2.a(this, typeToken);
                if (e63VarA != null) {
                    return e63VarA;
                }
            } else if (f63Var2 == f63Var) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public a71 k(Reader reader) {
        a71 a71Var = new a71(reader);
        a71Var.R0(this.n);
        return a71Var;
    }

    public a81 l(Writer writer) throws IOException {
        if (this.k) {
            writer.write(")]}'\n");
        }
        a81 a81Var = new a81(writer);
        if (this.m) {
            a81Var.H0("  ");
        }
        a81Var.G0(this.l);
        a81Var.I0(this.n);
        a81Var.J0(this.i);
        return a81Var;
    }

    public void m(u51 u51Var, a81 a81Var) {
        boolean zG0 = a81Var.g0();
        a81Var.I0(true);
        boolean zE0 = a81Var.e0();
        a81Var.G0(this.l);
        boolean zA0 = a81Var.a0();
        a81Var.J0(this.i);
        try {
            try {
                iv2.b(u51Var, a81Var);
                a81Var.I0(zG0);
                a81Var.G0(zE0);
                a81Var.J0(zA0);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } catch (Throwable th) {
            a81Var.I0(zG0);
            a81Var.G0(zE0);
            a81Var.J0(zA0);
            throw th;
        }
    }

    public void n(u51 u51Var, Appendable appendable) {
        try {
            m(u51Var, l(iv2.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void o(Object obj, Type type, a81 a81Var) {
        e63 e63VarG = g(TypeToken.get(type));
        boolean zG0 = a81Var.g0();
        a81Var.I0(true);
        boolean zE0 = a81Var.e0();
        a81Var.G0(this.l);
        boolean zA0 = a81Var.a0();
        a81Var.J0(this.i);
        try {
            try {
                e63VarG.e(a81Var, obj);
                a81Var.I0(zG0);
                a81Var.G0(zE0);
                a81Var.J0(zA0);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } catch (Throwable th) {
            a81Var.I0(zG0);
            a81Var.G0(zE0);
            a81Var.J0(zA0);
            throw th;
        }
    }

    public void p(Object obj, Type type, Appendable appendable) {
        try {
            o(obj, type, l(iv2.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public u51 q(Object obj) {
        return obj == null ? l61.a : r(obj, obj.getClass());
    }

    public u51 r(Object obj, Type type) {
        m71 m71Var = new m71();
        o(obj, type, m71Var);
        return m71Var.S0();
    }

    public String toJson(Object obj) {
        return obj == null ? toJson((u51) l61.a) : toJson(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.i + ",factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        return (T) fromJson(str, TypeToken.get(type));
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        p(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public <T> T fromJson(String str, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), typeToken);
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        return (T) r62.b(cls).cast(fromJson(reader, TypeToken.get((Class) cls)));
    }

    public String toJson(u51 u51Var) {
        StringWriter stringWriter = new StringWriter();
        n(u51Var, stringWriter);
        return stringWriter.toString();
    }

    qv0(wi0 wi0Var, ul0 ul0Var, Map map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, LongSerializationPolicy longSerializationPolicy, String str, int i, int i2, List list, List list2, List list3, n33 n33Var, n33 n33Var2, List list4) {
        this.a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        this.f = wi0Var;
        this.g = ul0Var;
        this.h = map;
        p20 p20Var = new p20(map, z9, list4);
        this.c = p20Var;
        this.i = z2;
        this.j = z3;
        this.k = z4;
        this.l = z5;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.p = z9;
        this.t = longSerializationPolicy;
        this.f379q = str;
        this.r = i;
        this.s = i2;
        this.u = list;
        this.v = list2;
        this.w = n33Var;
        this.x = n33Var2;
        this.y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(h63.W);
        arrayList.add(qt1.f(n33Var));
        arrayList.add(wi0Var);
        arrayList.addAll(list3);
        arrayList.add(h63.C);
        arrayList.add(h63.m);
        arrayList.add(h63.g);
        arrayList.add(h63.i);
        arrayList.add(h63.k);
        e63 e63VarJ = j(longSerializationPolicy);
        arrayList.add(h63.c(Long.TYPE, Long.class, e63VarJ));
        arrayList.add(h63.c(Double.TYPE, Double.class, e(z8)));
        arrayList.add(h63.c(Float.TYPE, Float.class, f(z8)));
        arrayList.add(js1.f(n33Var2));
        arrayList.add(h63.o);
        arrayList.add(h63.f343q);
        arrayList.add(h63.b(AtomicLong.class, b(e63VarJ)));
        arrayList.add(h63.b(AtomicLongArray.class, c(e63VarJ)));
        arrayList.add(h63.s);
        arrayList.add(h63.x);
        arrayList.add(h63.E);
        arrayList.add(h63.G);
        arrayList.add(h63.b(BigDecimal.class, h63.z));
        arrayList.add(h63.b(BigInteger.class, h63.A));
        arrayList.add(h63.b(LazilyParsedNumber.class, h63.B));
        arrayList.add(h63.I);
        arrayList.add(h63.K);
        arrayList.add(h63.O);
        arrayList.add(h63.Q);
        arrayList.add(h63.U);
        arrayList.add(h63.M);
        arrayList.add(h63.d);
        arrayList.add(x60.b);
        arrayList.add(h63.S);
        if (gt2.a) {
            arrayList.add(gt2.e);
            arrayList.add(gt2.d);
            arrayList.add(gt2.f);
        }
        arrayList.add(ba.c);
        arrayList.add(h63.b);
        arrayList.add(new dz(p20Var));
        arrayList.add(new rf1(p20Var, z3));
        f51 f51Var = new f51(p20Var);
        this.d = f51Var;
        arrayList.add(f51Var);
        arrayList.add(h63.X);
        arrayList.add(new oe2(p20Var, ul0Var, wi0Var, f51Var, list4));
        this.e = Collections.unmodifiableList(arrayList);
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonSyntaxException, JsonIOException {
        return (T) fromJson(reader, TypeToken.get(type));
    }

    public <T> T fromJson(Reader reader, TypeToken<T> typeToken) throws JsonSyntaxException, JsonIOException {
        a71 a71VarK = k(reader);
        T t = (T) fromJson(a71VarK, typeToken);
        a(t, a71VarK);
        return t;
    }

    public <T> T fromJson(a71 a71Var, Type type) throws JsonSyntaxException, JsonIOException {
        return (T) fromJson(a71Var, TypeToken.get(type));
    }

    public <T> T fromJson(a71 a71Var, TypeToken<T> typeToken) throws JsonSyntaxException, JsonIOException {
        boolean zK0 = a71Var.k0();
        boolean z2 = true;
        a71Var.R0(true);
        try {
            try {
                try {
                    a71Var.M0();
                    z2 = false;
                    T t = (T) g(typeToken).b(a71Var);
                    a71Var.R0(zK0);
                    return t;
                } catch (AssertionError e2) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (EOFException e4) {
                if (z2) {
                    a71Var.R0(zK0);
                    return null;
                }
                throw new JsonSyntaxException(e4);
            } catch (IOException e5) {
                throw new JsonSyntaxException(e5);
            }
        } catch (Throwable th) {
            a71Var.R0(zK0);
            throw th;
        }
    }

    public <T> T fromJson(u51 u51Var, Class<T> cls) throws JsonSyntaxException {
        return (T) r62.b(cls).cast(fromJson(u51Var, TypeToken.get((Class) cls)));
    }

    public <T> T fromJson(u51 u51Var, Type type) throws JsonSyntaxException {
        return (T) fromJson(u51Var, TypeToken.get(type));
    }

    public <T> T fromJson(u51 u51Var, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (u51Var == null) {
            return null;
        }
        return (T) fromJson(new l71(u51Var), typeToken);
    }
}
