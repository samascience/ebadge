package defpackage;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class a81 implements Closeable, Flushable {
    private static final Pattern j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] k = new String[128];
    private static final String[] l;
    private final Writer a;
    private int[] b = new int[32];
    private int c = 0;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;

    static {
        for (int i = 0; i <= 31; i++) {
            k[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public a81(Writer writer) {
        A0(6);
        this.e = ":";
        this.i = true;
        Objects.requireNonNull(writer, "out == null");
        this.a = writer;
    }

    private void A0(int i) {
        int i2 = this.c;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            this.b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr2[i3] = i;
    }

    private a81 C(int i, int i2, char c) throws IOException {
        int iY0 = y0();
        if (iY0 != i2 && iY0 != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.h != null) {
            throw new IllegalStateException("Dangling name: " + this.h);
        }
        this.c--;
        if (iY0 == i2) {
            m0();
        }
        this.a.write(c);
        return this;
    }

    private void F0(int i) {
        this.b[this.c - 1] = i;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void K0(String str) throws IOException {
        String str2;
        String[] strArr = this.g ? l : k;
        this.a.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        this.a.write(str, i, i2 - i);
                    }
                    this.a.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.a.write(str, i, i2 - i);
                }
                this.a.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.a.write(str, i, length - i);
        }
        this.a.write(34);
    }

    private void R0() throws IOException {
        if (this.h != null) {
            n();
            K0(this.h);
            this.h = null;
        }
    }

    private static boolean j0(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void m0() throws IOException {
        if (this.d == null) {
            return;
        }
        this.a.write(10);
        int i = this.c;
        for (int i2 = 1; i2 < i; i2++) {
            this.a.write(this.d);
        }
    }

    private void n() throws IOException {
        int iY0 = y0();
        if (iY0 == 5) {
            this.a.write(44);
        } else if (iY0 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m0();
        F0(4);
    }

    private void u() throws IOException {
        int iY0 = y0();
        if (iY0 == 1) {
            F0(2);
            m0();
            return;
        }
        if (iY0 == 2) {
            this.a.append(',');
            m0();
        } else {
            if (iY0 == 4) {
                this.a.append((CharSequence) this.e);
                F0(5);
                return;
            }
            if (iY0 != 6) {
                if (iY0 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            F0(7);
        }
    }

    private a81 w0(int i, char c) throws IOException {
        u();
        A0(i);
        this.a.write(c);
        return this;
    }

    private int y0() {
        int i = this.c;
        if (i != 0) {
            return this.b[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public a81 D() {
        return C(1, 2, ']');
    }

    public final void G0(boolean z) {
        this.g = z;
    }

    public final void H0(String str) {
        if (str.length() == 0) {
            this.d = null;
            this.e = ":";
        } else {
            this.d = str;
            this.e = ": ";
        }
    }

    public final void I0(boolean z) {
        this.f = z;
    }

    public final void J0(boolean z) {
        this.i = z;
    }

    public a81 L0(double d) throws IOException {
        R0();
        if (this.f || !(Double.isNaN(d) || Double.isInfinite(d))) {
            u();
            this.a.append((CharSequence) Double.toString(d));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public a81 M0(long j2) throws IOException {
        R0();
        u();
        this.a.write(Long.toString(j2));
        return this;
    }

    public a81 N0(Boolean bool) throws IOException {
        if (bool == null) {
            return t0();
        }
        R0();
        u();
        this.a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a81 O0(Number number) throws IOException {
        if (number == null) {
            return t0();
        }
        R0();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!j0(cls) && !j.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        u();
        this.a.append((CharSequence) string);
        return this;
    }

    public a81 P0(String str) throws IOException {
        if (str == null) {
            return t0();
        }
        R0();
        u();
        K0(str);
        return this;
    }

    public a81 Q0(boolean z) throws IOException {
        R0();
        u();
        this.a.write(z ? "true" : "false");
        return this;
    }

    public a81 V() {
        return C(3, 5, '}');
    }

    public final boolean a0() {
        return this.i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        int i = this.c;
        if (i > 1 || (i == 1 && this.b[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.c = 0;
    }

    public final boolean e0() {
        return this.g;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.a.flush();
    }

    public boolean g0() {
        return this.f;
    }

    public a81 k0(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.h != null) {
            throw new IllegalStateException();
        }
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.h = str;
        return this;
    }

    public a81 t0() throws IOException {
        if (this.h != null) {
            if (!this.i) {
                this.h = null;
                return this;
            }
            R0();
        }
        u();
        this.a.write("null");
        return this;
    }

    public a81 w() throws IOException {
        R0();
        return w0(1, '[');
    }

    public a81 y() throws IOException {
        R0();
        return w0(3, '{');
    }
}
