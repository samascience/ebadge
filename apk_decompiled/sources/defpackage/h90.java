package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class h90 extends m1 {
    private final b f;

    private static final class b extends n1 {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.n1
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public h90 a() {
            return new h90(this, this.b, this.a, (String[]) this.c.clone());
        }

        private b(y0 y0Var, String str, String[] strArr) {
            super(y0Var, str, strArr);
        }
    }

    static h90 d(y0 y0Var, String str, Object[] objArr) {
        return (h90) new b(y0Var, str, m1.c(objArr)).b();
    }

    public void e() {
        a();
        r60 database = this.a.getDatabase();
        if (database.o()) {
            this.a.getDatabase().k(this.c, this.d);
            return;
        }
        database.d();
        try {
            this.a.getDatabase().k(this.c, this.d);
            database.j();
        } finally {
            database.l();
        }
    }

    private h90(b bVar, y0 y0Var, String str, String[] strArr) {
        super(y0Var, str, strArr);
        this.f = bVar;
    }
}
