package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class oe1 {
    private final Object a;
    private final Throwable b;

    public oe1(Object obj) {
        this.a = obj;
        this.b = null;
    }

    public Throwable a() {
        return this.b;
    }

    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oe1)) {
            return false;
        }
        oe1 oe1Var = (oe1) obj;
        if (b() != null && b().equals(oe1Var.b())) {
            return true;
        }
        if (a() == null || oe1Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public oe1(Throwable th) {
        this.b = th;
        this.a = null;
    }
}
