package defpackage;

import com.fasterxml.classmate.b;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class og2 implements Type {
    public static final og2[] c = new og2[0];
    protected static final ja2[] d = new ja2[0];
    protected static final ka2[] e = new ka2[0];
    protected static final ma2[] f = new ma2[0];
    protected final Class a;
    protected final b b;

    protected og2(Class cls, b bVar) {
        this.a = cls;
        this.b = bVar == null ? b.b() : bVar;
    }

    protected StringBuilder a(StringBuilder sb) {
        sb.append(this.a.getName());
        int iH = this.b.h();
        if (iH > 0) {
            sb.append('<');
            for (int i = 0; i < iH; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb = this.b.d(i).b(sb);
            }
            sb.append('>');
        }
        return sb;
    }

    public abstract StringBuilder b(StringBuilder sb);

    public abstract StringBuilder c(StringBuilder sb);

    public abstract boolean d();

    public og2 e(Class cls) {
        og2 og2VarE;
        if (cls == this.a) {
            return this;
        }
        if (cls.isInterface()) {
            Iterator it = i().iterator();
            while (it.hasNext()) {
                og2 og2VarE2 = ((og2) it.next()).e(cls);
                if (og2VarE2 != null) {
                    return og2VarE2;
                }
            }
        }
        og2 og2VarJ = j();
        if (og2VarJ == null || (og2VarE = og2VarJ.e(cls)) == null) {
            return null;
        }
        return og2VarE;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        og2 og2Var = (og2) obj;
        if (og2Var.a != this.a) {
            return false;
        }
        return this.b.equals(og2Var.b);
    }

    public String f() {
        return b(new StringBuilder()).toString();
    }

    public Class g() {
        return this.a;
    }

    public String h() {
        return c(new StringBuilder()).toString();
    }

    public int hashCode() {
        return this.a.getName().hashCode() + this.b.hashCode();
    }

    public abstract List i();

    public abstract og2 j();

    public abstract og2 k();

    public b l() {
        return this.b;
    }

    public List m() {
        return this.b.e();
    }

    public String toString() {
        return f();
    }
}
