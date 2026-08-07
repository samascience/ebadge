package defpackage;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u51 {
    public int a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public l51 b() {
        if (f()) {
            return (l51) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public o61 c() {
        if (h()) {
            return (o61) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public v61 d() {
        if (i()) {
            return (v61) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean f() {
        return this instanceof l51;
    }

    public boolean g() {
        return this instanceof l61;
    }

    public boolean h() {
        return this instanceof o61;
    }

    public boolean i() {
        return this instanceof v61;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            a81 a81Var = new a81(stringWriter);
            a81Var.I0(true);
            iv2.b(this, a81Var);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
