package defpackage;

import com.fasterxml.classmate.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class jg2 extends og2 {
    protected final og2 g;
    protected final og2[] h;
    protected final int i;

    public jg2(Class cls, b bVar, og2 og2Var, List list) {
        this(cls, bVar, og2Var, (list == null || list.isEmpty()) ? og2.c : (og2[]) list.toArray(new og2[0]));
    }

    public static jg2 n(Class cls, b bVar, og2 og2Var, List list) {
        return new jg2(cls, bVar, og2Var, list);
    }

    @Override // defpackage.og2
    public StringBuilder b(StringBuilder sb) {
        return a(sb);
    }

    @Override // defpackage.og2
    public StringBuilder c(StringBuilder sb) {
        StringBuilder sbA = a(sb);
        if (this.g != null) {
            sbA.append(" extends ");
            sbA = this.g.b(sbA);
        }
        int length = this.h.length;
        if (length > 0) {
            sbA.append(" implements ");
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    sbA.append(",");
                }
                sbA = this.h[i].b(sbA);
            }
        }
        return sbA;
    }

    @Override // defpackage.og2
    public boolean d() {
        return true;
    }

    @Override // defpackage.og2
    public List i() {
        og2[] og2VarArr = this.h;
        return og2VarArr.length == 0 ? Collections.emptyList() : Arrays.asList(og2VarArr);
    }

    @Override // defpackage.og2
    public og2 k() {
        return null;
    }

    @Override // defpackage.og2
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public jg2 j() {
        og2 og2Var = this.g;
        if (og2Var == null) {
            return null;
        }
        if (og2Var instanceof jg2) {
            return (jg2) og2Var;
        }
        og2 og2VarK = ((mg2) og2Var).k();
        if (og2VarK instanceof jg2) {
            return (jg2) og2VarK;
        }
        throw new IllegalStateException("Internal error: self-referential parent type (" + this.g + ") does not resolve into proper ResolvedObjectType, but instead to: " + og2VarK);
    }

    public jg2(Class cls, b bVar, og2 og2Var, og2[] og2VarArr) {
        super(cls, bVar);
        if (og2Var != null && !(og2Var instanceof jg2) && !(og2Var instanceof mg2)) {
            throw new IllegalArgumentException("Unexpected parent type for " + cls.getName() + ": " + og2Var.getClass().getName());
        }
        this.g = og2Var;
        this.h = og2VarArr == null ? og2.c : og2VarArr;
        this.i = cls.getModifiers();
    }
}
