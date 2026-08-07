package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public abstract class r22 {

    public static final class a extends r22 {
        public static final a a = new a();

        private a() {
            super(null);
        }
    }

    public static final class b extends r22 {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    public static final class c extends r22 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    public static final class d extends r22 {
        public static final d a = new d();

        private d() {
            super(null);
        }
    }

    public static final class e extends r22 {
        private final aw2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(aw2 aw2Var) {
            super(null);
            p31.f(aw2Var, "styleItem");
            this.a = aw2Var;
        }

        public final aw2 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && p31.a(this.a, ((e) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "SelectStyle(styleItem=" + this.a + ")";
        }
    }

    public static final class f extends r22 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
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
            return (obj instanceof f) && p31.a(this.a, ((f) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ShowError(message=" + this.a + ")";
        }
    }

    public static final class g extends r22 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(null);
            p31.f(str, "errorMessage");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && p31.a(this.a, ((g) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ShowUploadErrorDialog(errorMessage=" + this.a + ")";
        }
    }

    public static final class h extends r22 {
        private final String a;
        private final int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, int i) {
            super(null);
            p31.f(str, "message");
            this.a = str;
            this.b = i;
        }

        public final String a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return p31.a(this.a, hVar.a) && this.b == hVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "ShowUploadProgress(message=" + this.a + ", progress=" + this.b + ")";
        }
    }

    public static final class i extends r22 {
        public static final i a = new i();

        private i() {
            super(null);
        }
    }

    public static final class j extends r22 {
        public static final j a = new j();

        private j() {
            super(null);
        }
    }

    public static final class k extends r22 {
        private final int a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i, String str) {
            super(null);
            p31.f(str, "message");
            this.a = i;
            this.b = str;
        }

        public final String a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.a == kVar.a && p31.a(this.b, kVar.b);
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "UpdateUploadProgress(progress=" + this.a + ", message=" + this.b + ")";
        }
    }

    public static final class l extends r22 {
        public static final l a = new l();

        private l() {
            super(null);
        }
    }

    public /* synthetic */ r22(y70 y70Var) {
        this();
    }

    private r22() {
    }
}
