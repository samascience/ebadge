package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class v73 implements Comparable {
    public static final a b = new a(null);
    private final long a;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    private /* synthetic */ v73(long j) {
        this.a = j;
    }

    public static final /* synthetic */ v73 a(long j) {
        return new v73(j);
    }

    public static long b(long j) {
        return j;
    }

    public static boolean c(long j, Object obj) {
        return (obj instanceof v73) && j == ((v73) obj).f();
    }

    public static int d(long j) {
        return Long.hashCode(j);
    }

    public static String e(long j) {
        return u83.b(j, 10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return u83.a(f(), ((v73) obj).f());
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ long f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    public String toString() {
        return e(this.a);
    }
}
