package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class wf2 {
    private final qa a;
    private final yf2 b;
    private final vf2 c;
    private final int d;

    wf2(qa qaVar, yf2 yf2Var, vf2 vf2Var, int i) {
        this.a = qaVar;
        this.b = yf2Var;
        this.c = vf2Var;
        this.d = i;
    }

    public int a() {
        return this.d;
    }

    public qa b() {
        return this.a;
    }

    public vf2 c() {
        return this.c;
    }

    public yf2 d() {
        return this.b;
    }

    public static final class a {
        private qa a;
        private yf2 b;
        private vf2 c;
        private int d;

        public a() {
            this.a = qa.c;
            this.b = null;
            this.c = null;
            this.d = 0;
        }

        public static a b(wf2 wf2Var) {
            return new a(wf2Var);
        }

        public wf2 a() {
            return new wf2(this.a, this.b, this.c, this.d);
        }

        public a c(int i) {
            this.d = i;
            return this;
        }

        public a d(qa qaVar) {
            this.a = qaVar;
            return this;
        }

        public a e(vf2 vf2Var) {
            this.c = vf2Var;
            return this;
        }

        public a f(yf2 yf2Var) {
            this.b = yf2Var;
            return this;
        }

        private a(wf2 wf2Var) {
            this.a = qa.c;
            this.b = null;
            this.c = null;
            this.d = 0;
            this.a = wf2Var.b();
            this.b = wf2Var.d();
            this.c = wf2Var.c();
            this.d = wf2Var.a();
        }
    }
}
