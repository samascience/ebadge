package defpackage;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class m71 extends a81 {
    private static final Writer p = new a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final v61 f356q = new v61("closed");
    private final List m;
    private String n;
    private u51 o;

    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public m71() {
        super(p);
        this.m = new ArrayList();
        this.o = l61.a;
    }

    private u51 T0() {
        List list = this.m;
        return (u51) list.get(list.size() - 1);
    }

    private void U0(u51 u51Var) {
        if (this.n != null) {
            if (!u51Var.g() || a0()) {
                ((o61) T0()).j(this.n, u51Var);
            }
            this.n = null;
            return;
        }
        if (this.m.isEmpty()) {
            this.o = u51Var;
            return;
        }
        u51 u51VarT0 = T0();
        if (!(u51VarT0 instanceof l51)) {
            throw new IllegalStateException();
        }
        ((l51) u51VarT0).j(u51Var);
    }

    @Override // defpackage.a81
    public a81 D() {
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(T0() instanceof l51)) {
            throw new IllegalStateException();
        }
        List list = this.m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // defpackage.a81
    public a81 L0(double d) {
        if (g0() || !(Double.isNaN(d) || Double.isInfinite(d))) {
            U0(new v61(Double.valueOf(d)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    @Override // defpackage.a81
    public a81 M0(long j) {
        U0(new v61(Long.valueOf(j)));
        return this;
    }

    @Override // defpackage.a81
    public a81 N0(Boolean bool) {
        if (bool == null) {
            return t0();
        }
        U0(new v61(bool));
        return this;
    }

    @Override // defpackage.a81
    public a81 O0(Number number) {
        if (number == null) {
            return t0();
        }
        if (!g0()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        U0(new v61(number));
        return this;
    }

    @Override // defpackage.a81
    public a81 P0(String str) {
        if (str == null) {
            return t0();
        }
        U0(new v61(str));
        return this;
    }

    @Override // defpackage.a81
    public a81 Q0(boolean z) {
        U0(new v61(Boolean.valueOf(z)));
        return this;
    }

    public u51 S0() {
        if (this.m.isEmpty()) {
            return this.o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.m);
    }

    @Override // defpackage.a81
    public a81 V() {
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(T0() instanceof o61)) {
            throw new IllegalStateException();
        }
        List list = this.m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // defpackage.a81, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.m.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.m.add(f356q);
    }

    @Override // defpackage.a81, java.io.Flushable
    public void flush() {
    }

    @Override // defpackage.a81
    public a81 k0(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(T0() instanceof o61)) {
            throw new IllegalStateException();
        }
        this.n = str;
        return this;
    }

    @Override // defpackage.a81
    public a81 t0() {
        U0(l61.a);
        return this;
    }

    @Override // defpackage.a81
    public a81 w() {
        l51 l51Var = new l51();
        U0(l51Var);
        this.m.add(l51Var);
        return this;
    }

    @Override // defpackage.a81
    public a81 y() {
        o61 o61Var = new o61();
        U0(o61Var);
        this.m.add(o61Var);
        return this;
    }
}
