package defpackage;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public final class a63 extends wm2 {
    private final t51 a;
    final qv0 b;
    private final TypeToken c;
    private final f63 d;
    private final b e;
    private final boolean f;
    private volatile e63 g;

    private final class b implements q51 {
        private b() {
        }

        @Override // defpackage.q51
        public Object a(u51 u51Var, Type type) {
            return a63.this.b.fromJson(u51Var, type);
        }
    }

    private static final class c implements f63 {
        private final TypeToken a;
        private final boolean b;
        private final Class c;
        private final t51 d;

        c(Object obj, TypeToken typeToken, boolean z, Class cls) {
            t51 t51Var = obj instanceof t51 ? (t51) obj : null;
            this.d = t51Var;
            defpackage.a.a(t51Var != null);
            this.a = typeToken;
            this.b = z;
            this.c = cls;
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            boolean zIsAssignableFrom;
            TypeToken typeToken2 = this.a;
            if (typeToken2 != null) {
                zIsAssignableFrom = typeToken2.equals(typeToken) || (this.b && this.a.getType() == typeToken.getRawType());
            } else {
                zIsAssignableFrom = this.c.isAssignableFrom(typeToken.getRawType());
            }
            if (zIsAssignableFrom) {
                return new a63(null, this.d, qv0Var, typeToken, this);
            }
            return null;
        }
    }

    public a63(g71 g71Var, t51 t51Var, qv0 qv0Var, TypeToken typeToken, f63 f63Var, boolean z) {
        this.e = new b();
        this.a = t51Var;
        this.b = qv0Var;
        this.c = typeToken;
        this.d = f63Var;
        this.f = z;
    }

    private e63 g() {
        e63 e63Var = this.g;
        if (e63Var != null) {
            return e63Var;
        }
        e63 e63VarI = this.b.i(this.d, this.c);
        this.g = e63VarI;
        return e63VarI;
    }

    public static f63 h(TypeToken typeToken, Object obj) {
        return new c(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    @Override // defpackage.e63
    public Object b(a71 a71Var) {
        if (this.a == null) {
            return g().b(a71Var);
        }
        u51 u51VarA = iv2.a(a71Var);
        if (this.f && u51VarA.g()) {
            return null;
        }
        return this.a.a(u51VarA, this.c.getType(), this.e);
    }

    @Override // defpackage.e63
    public void e(a81 a81Var, Object obj) {
        g().e(a81Var, obj);
    }

    @Override // defpackage.wm2
    public e63 f() {
        return g();
    }

    public a63(g71 g71Var, t51 t51Var, qv0 qv0Var, TypeToken typeToken, f63 f63Var) {
        this(g71Var, t51Var, qv0Var, typeToken, f63Var, true);
    }
}
