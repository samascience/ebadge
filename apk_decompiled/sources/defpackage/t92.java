package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class t92 extends o1 {
    private final b h;

    private static final class b extends n1 {
        private final int e;
        private final int f;

        b(y0 y0Var, String str, String[] strArr, int i, int i2) {
            super(y0Var, str, strArr);
            this.e = i;
            this.f = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.n1
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public t92 a() {
            return new t92(this, this.b, this.a, (String[]) this.c.clone(), this.e, this.f);
        }
    }

    static t92 e(y0 y0Var, String str, Object[] objArr, int i, int i2) {
        return (t92) new b(y0Var, str, m1.c(objArr), i, i2).b();
    }

    public static t92 g(y0 y0Var, String str, Object[] objArr) {
        return e(y0Var, str, objArr, -1, -1);
    }

    public t92 f() {
        return (t92) this.h.c(this);
    }

    public List h() {
        a();
        return this.b.a(this.a.getDatabase().n(this.c, this.d));
    }

    public t92 i(int i, Object obj) {
        return (t92) super.d(i, obj);
    }

    public Object j() {
        a();
        return this.b.b(this.a.getDatabase().n(this.c, this.d));
    }

    private t92(b bVar, y0 y0Var, String str, String[] strArr, int i, int i2) {
        super(y0Var, str, strArr, i, i2);
        this.h = bVar;
    }
}
