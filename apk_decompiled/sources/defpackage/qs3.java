package defpackage;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public final class qs3 {
    private final boolean a;
    private final int b;
    private final a c;
    private final a.d d;

    private qs3(a aVar, a.d dVar) {
        this.a = false;
        this.c = aVar;
        this.d = dVar;
        this.b = st1.b(aVar, dVar);
    }

    public static qs3 a(a aVar) {
        return new qs3(aVar);
    }

    public static qs3 b(a aVar, a.d dVar) {
        return new qs3(aVar, dVar);
    }

    public final String c() {
        return this.c.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof qs3)) {
            return false;
        }
        qs3 qs3Var = (qs3) obj;
        return !this.a && !qs3Var.a && st1.a(this.c, qs3Var.c) && st1.a(this.d, qs3Var.d);
    }

    public final int hashCode() {
        return this.b;
    }

    private qs3(a aVar) {
        this.a = true;
        this.c = aVar;
        this.d = null;
        this.b = System.identityHashCode(this);
    }
}
