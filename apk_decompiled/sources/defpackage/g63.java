package defpackage;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes3.dex */
final class g63 extends e63 {
    private final qv0 a;
    private final e63 b;
    private final Type c;

    g63(qv0 qv0Var, e63 e63Var, Type type) {
        this.a = qv0Var;
        this.b = e63Var;
        this.c = type;
    }

    private static Type f(Type type, Object obj) {
        if (obj != null) {
            return ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type;
        }
        return type;
    }

    private static boolean g(e63 e63Var) {
        e63 e63VarF;
        while ((e63Var instanceof wm2) && (e63VarF = ((wm2) e63Var).f()) != e63Var) {
            e63Var = e63VarF;
        }
        return e63Var instanceof oe2.b;
    }

    @Override // defpackage.e63
    public Object b(a71 a71Var) {
        return this.b.b(a71Var);
    }

    @Override // defpackage.e63
    public void e(a81 a81Var, Object obj) {
        e63 e63VarG = this.b;
        Type typeF = f(this.c, obj);
        if (typeF != this.c) {
            e63VarG = this.a.g(TypeToken.get(typeF));
            if ((e63VarG instanceof oe2.b) && !g(this.b)) {
                e63VarG = this.b;
            }
        }
        e63VarG.e(a81Var, obj);
    }
}
