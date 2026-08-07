package defpackage;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class wi0 implements f63, Cloneable {
    public static final wi0 g = new wi0();
    private boolean d;
    private double a = -1.0d;
    private int b = Opcodes.L2I;
    private boolean c = true;
    private List e = Collections.emptyList();
    private List f = Collections.emptyList();

    class a extends e63 {
        private e63 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ qv0 d;
        final /* synthetic */ TypeToken e;

        a(boolean z, boolean z2, qv0 qv0Var, TypeToken typeToken) {
            this.b = z;
            this.c = z2;
            this.d = qv0Var;
            this.e = typeToken;
        }

        private e63 f() {
            e63 e63Var = this.a;
            if (e63Var != null) {
                return e63Var;
            }
            e63 e63VarI = this.d.i(wi0.this, this.e);
            this.a = e63VarI;
            return e63VarI;
        }

        @Override // defpackage.e63
        public Object b(a71 a71Var) throws IOException {
            if (!this.b) {
                return f().b(a71Var);
            }
            a71Var.W0();
            return null;
        }

        @Override // defpackage.e63
        public void e(a81 a81Var, Object obj) throws IOException {
            if (this.c) {
                a81Var.t0();
            } else {
                f().e(a81Var, obj);
            }
        }
    }

    private boolean d(Class cls) {
        if (this.a != -1.0d && !l((dr2) cls.getAnnotation(dr2.class), (v83) cls.getAnnotation(v83.class))) {
            return true;
        }
        if (this.c || !h(cls)) {
            return g(cls);
        }
        return true;
    }

    private boolean e(Class cls, boolean z) {
        Iterator it = (z ? this.e : this.f).iterator();
        while (it.hasNext()) {
            if (((xi0) it.next()).a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean g(Class cls) {
        return (Enum.class.isAssignableFrom(cls) || i(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean h(Class cls) {
        return cls.isMemberClass() && !i(cls);
    }

    private boolean i(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean j(dr2 dr2Var) {
        if (dr2Var != null) {
            return this.a >= dr2Var.value();
        }
        return true;
    }

    private boolean k(v83 v83Var) {
        if (v83Var != null) {
            return this.a < v83Var.value();
        }
        return true;
    }

    private boolean l(dr2 dr2Var, v83 v83Var) {
        return j(dr2Var) && k(v83Var);
    }

    @Override // defpackage.f63
    public e63 a(qv0 qv0Var, TypeToken typeToken) {
        Class rawType = typeToken.getRawType();
        boolean zD = d(rawType);
        boolean z = zD || e(rawType, true);
        boolean z2 = zD || e(rawType, false);
        if (z || z2) {
            return new a(z2, z, qv0Var, typeToken);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public wi0 clone() {
        try {
            return (wi0) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean c(Class cls, boolean z) {
        return d(cls) || e(cls, z);
    }

    public boolean f(Field field, boolean z) {
        nj0 nj0Var;
        if ((this.b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.a != -1.0d && !l((dr2) field.getAnnotation(dr2.class), (v83) field.getAnnotation(v83.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.d && ((nj0Var = (nj0) field.getAnnotation(nj0.class)) == null || (!z ? nj0Var.deserialize() : nj0Var.serialize()))) {
            return true;
        }
        if ((!this.c && h(field.getType())) || g(field.getType())) {
            return true;
        }
        List list = z ? this.e : this.f;
        if (list.isEmpty()) {
            return false;
        }
        ol0 ol0Var = new ol0(field);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((xi0) it.next()).b(ol0Var)) {
                return true;
            }
        }
        return false;
    }

    public wi0 m(xi0 xi0Var, boolean z, boolean z2) {
        wi0 wi0VarClone = clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.e);
            wi0VarClone.e = arrayList;
            arrayList.add(xi0Var);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.f);
            wi0VarClone.f = arrayList2;
            arrayList2.add(xi0Var);
        }
        return wi0VarClone;
    }
}
