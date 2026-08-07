package defpackage;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class l71 extends a71 {
    private static final Reader t = new a();
    private static final Object u = new Object();
    private Object[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f351q;
    private String[] r;
    private int[] s;

    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public l71(u51 u51Var) {
        super(t);
        this.p = new Object[32];
        this.f351q = 0;
        this.r = new String[32];
        this.s = new int[32];
        e1(u51Var);
    }

    private void Y0(JsonToken jsonToken) {
        if (M0() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + M0() + t0());
    }

    private String a1(boolean z) {
        Y0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) b1()).next();
        String str = (String) entry.getKey();
        this.r[this.f351q - 1] = z ? "<skipped>" : str;
        e1(entry.getValue());
        return str;
    }

    private Object b1() {
        return this.p[this.f351q - 1];
    }

    private Object c1() {
        Object[] objArr = this.p;
        int i = this.f351q - 1;
        this.f351q = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private String e0(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (true) {
            int i2 = this.f351q;
            if (i >= i2) {
                return sb.toString();
            }
            Object[] objArr = this.p;
            Object obj = objArr[i];
            if (obj instanceof l51) {
                i++;
                if (i < i2 && (objArr[i] instanceof Iterator)) {
                    int i3 = this.s[i];
                    if (z && i3 > 0 && (i == i2 - 1 || i == i2 - 2)) {
                        i3--;
                    }
                    sb.append('[');
                    sb.append(i3);
                    sb.append(']');
                }
            } else if ((obj instanceof o61) && (i = i + 1) < i2 && (objArr[i] instanceof Iterator)) {
                sb.append('.');
                String str = this.r[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private void e1(Object obj) {
        int i = this.f351q;
        Object[] objArr = this.p;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.p = Arrays.copyOf(objArr, i2);
            this.s = Arrays.copyOf(this.s, i2);
            this.r = (String[]) Arrays.copyOf(this.r, i2);
        }
        Object[] objArr2 = this.p;
        int i3 = this.f351q;
        this.f351q = i3 + 1;
        objArr2[i3] = obj;
    }

    private String t0() {
        return " at path " + c();
    }

    @Override // defpackage.a71
    public int A0() throws MalformedJsonException {
        JsonToken jsonTokenM0 = M0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenM0 != jsonToken && jsonTokenM0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenM0 + t0());
        }
        int iA = ((v61) b1()).a();
        c1();
        int i = this.f351q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return iA;
    }

    @Override // defpackage.a71
    public void D() {
        Y0(JsonToken.END_ARRAY);
        c1();
        c1();
        int i = this.f351q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // defpackage.a71
    public long F0() throws MalformedJsonException {
        JsonToken jsonTokenM0 = M0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenM0 != jsonToken && jsonTokenM0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenM0 + t0());
        }
        long jL = ((v61) b1()).l();
        c1();
        int i = this.f351q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return jL;
    }

    @Override // defpackage.a71
    public String G0() {
        return a1(false);
    }

    @Override // defpackage.a71
    public void I0() {
        Y0(JsonToken.NULL);
        c1();
        int i = this.f351q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // defpackage.a71
    public String K0() throws MalformedJsonException {
        JsonToken jsonTokenM0 = M0();
        JsonToken jsonToken = JsonToken.STRING;
        if (jsonTokenM0 == jsonToken || jsonTokenM0 == JsonToken.NUMBER) {
            String strE = ((v61) c1()).e();
            int i = this.f351q;
            if (i > 0) {
                int[] iArr = this.s;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return strE;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenM0 + t0());
    }

    @Override // defpackage.a71
    public JsonToken M0() throws MalformedJsonException {
        if (this.f351q == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object objB1 = b1();
        if (objB1 instanceof Iterator) {
            boolean z = this.p[this.f351q - 2] instanceof o61;
            Iterator it = (Iterator) objB1;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            e1(it.next());
            return M0();
        }
        if (objB1 instanceof o61) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (objB1 instanceof l51) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (objB1 instanceof v61) {
            v61 v61Var = (v61) objB1;
            if (v61Var.q()) {
                return JsonToken.STRING;
            }
            if (v61Var.n()) {
                return JsonToken.BOOLEAN;
            }
            if (v61Var.p()) {
                return JsonToken.NUMBER;
            }
            throw new AssertionError();
        }
        if (objB1 instanceof l61) {
            return JsonToken.NULL;
        }
        if (objB1 == u) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new MalformedJsonException("Custom JsonElement subclass " + objB1.getClass().getName() + " is not supported");
    }

    @Override // defpackage.a71
    public void V() {
        Y0(JsonToken.END_OBJECT);
        this.r[this.f351q - 1] = null;
        c1();
        c1();
        int i = this.f351q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // defpackage.a71
    public void W0() throws MalformedJsonException {
        int i = b.a[M0().ordinal()];
        if (i == 1) {
            a1(true);
            return;
        }
        if (i == 2) {
            D();
            return;
        }
        if (i == 3) {
            V();
            return;
        }
        if (i != 4) {
            c1();
            int i2 = this.f351q;
            if (i2 > 0) {
                int[] iArr = this.s;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    u51 Z0() throws MalformedJsonException {
        JsonToken jsonTokenM0 = M0();
        if (jsonTokenM0 != JsonToken.NAME && jsonTokenM0 != JsonToken.END_ARRAY && jsonTokenM0 != JsonToken.END_OBJECT && jsonTokenM0 != JsonToken.END_DOCUMENT) {
            u51 u51Var = (u51) b1();
            W0();
            return u51Var;
        }
        throw new IllegalStateException("Unexpected " + jsonTokenM0 + " when reading a JsonElement.");
    }

    @Override // defpackage.a71
    public String c() {
        return e0(false);
    }

    @Override // defpackage.a71, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.p = new Object[]{u};
        this.f351q = 1;
    }

    public void d1() {
        Y0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) b1()).next();
        e1(entry.getValue());
        e1(new v61((String) entry.getKey()));
    }

    @Override // defpackage.a71
    public String g0() {
        return e0(true);
    }

    @Override // defpackage.a71
    public boolean j0() throws MalformedJsonException {
        JsonToken jsonTokenM0 = M0();
        return (jsonTokenM0 == JsonToken.END_OBJECT || jsonTokenM0 == JsonToken.END_ARRAY || jsonTokenM0 == JsonToken.END_DOCUMENT) ? false : true;
    }

    @Override // defpackage.a71
    public void n() {
        Y0(JsonToken.BEGIN_ARRAY);
        e1(((l51) b1()).iterator());
        this.s[this.f351q - 1] = 0;
    }

    @Override // defpackage.a71
    public String toString() {
        return l71.class.getSimpleName() + t0();
    }

    @Override // defpackage.a71
    public void u() {
        Y0(JsonToken.BEGIN_OBJECT);
        e1(((o61) b1()).o().iterator());
    }

    @Override // defpackage.a71
    public boolean w0() {
        Y0(JsonToken.BOOLEAN);
        boolean zJ = ((v61) c1()).j();
        int i = this.f351q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return zJ;
    }

    @Override // defpackage.a71
    public double y0() throws MalformedJsonException {
        JsonToken jsonTokenM0 = M0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenM0 != jsonToken && jsonTokenM0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenM0 + t0());
        }
        double dK = ((v61) b1()).k();
        if (!k0() && (Double.isNaN(dK) || Double.isInfinite(dK))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + dK);
        }
        c1();
        int i = this.f351q;
        if (i > 0) {
            int[] iArr = this.s;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return dK;
    }
}
