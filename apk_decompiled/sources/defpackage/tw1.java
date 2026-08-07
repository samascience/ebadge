package defpackage;

/* JADX INFO: loaded from: classes.dex */
public interface tw1 {
    public static final b.c a;
    public static final b.C0172b b;

    public static abstract class b {

        public static final class a extends b {
            private final Throwable a;

            public a(Throwable th) {
                this.a = th;
            }

            public Throwable a() {
                return this.a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.a.getMessage());
            }
        }

        /* JADX INFO: renamed from: tw1$b$b, reason: collision with other inner class name */
        public static final class C0172b extends b {
            public String toString() {
                return "IN_PROGRESS";
            }

            private C0172b() {
            }
        }

        public static final class c extends b {
            public String toString() {
                return "SUCCESS";
            }

            private c() {
            }
        }

        b() {
        }
    }

    static {
        a = new b.c();
        b = new b.C0172b();
    }
}
