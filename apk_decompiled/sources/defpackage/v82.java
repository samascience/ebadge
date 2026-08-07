package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public abstract class v82 {

    public static final class a extends v82 {
        public static final a a = new a();

        private a() {
            super(null);
        }
    }

    public static final class b extends v82 {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    public static final class c extends v82 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    public static final class d extends v82 {
        public static final d a = new d();

        private d() {
            super(null);
        }
    }

    public static final class e extends v82 {
        public static final e a = new e();

        private e() {
            super(null);
        }
    }

    public static final class f extends v82 {
        public static final f a = new f();

        private f() {
            super(null);
        }
    }

    public static final class g extends v82 {
        public static final g a = new g();

        private g() {
            super(null);
        }
    }

    public static final class h extends v82 {
        public static final h a = new h();

        private h() {
            super(null);
        }
    }

    public static final class i extends v82 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str) {
            super(null);
            p31.f(str, "message");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && p31.a(this.a, ((i) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ShowError(message=" + this.a + ")";
        }
    }

    public /* synthetic */ v82(y70 y70Var) {
        this();
    }

    private v82() {
    }
}
