package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t03 {
    private final String a;
    private final boolean b;
    private a13 c;
    private long d;

    public t03(String str, boolean z) {
        p31.f(str, "name");
        this.a = str;
        this.b = z;
        this.d = -1L;
    }

    public final boolean a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final long c() {
        return this.d;
    }

    public final a13 d() {
        return this.c;
    }

    public final void e(a13 a13Var) {
        p31.f(a13Var, "queue");
        a13 a13Var2 = this.c;
        if (a13Var2 == a13Var) {
            return;
        }
        if (a13Var2 != null) {
            throw new IllegalStateException("task is in multiple queues");
        }
        this.c = a13Var;
    }

    public abstract long f();

    public final void g(long j) {
        this.d = j;
    }

    public String toString() {
        return this.a;
    }

    public /* synthetic */ t03(String str, boolean z, int i, y70 y70Var) {
        this(str, (i & 2) != 0 ? true : z);
    }
}
