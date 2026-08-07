package defpackage;

import com.fasterxml.classmate.b;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class mg2 extends og2 {
    protected og2 g;

    public mg2(Class cls, b bVar) {
        super(cls, bVar);
    }

    @Override // defpackage.og2
    public StringBuilder b(StringBuilder sb) {
        return a(sb);
    }

    @Override // defpackage.og2
    public StringBuilder c(StringBuilder sb) {
        return b(sb);
    }

    @Override // defpackage.og2
    public boolean d() {
        return this.g.d();
    }

    @Override // defpackage.og2
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        mg2 mg2Var = (mg2) obj;
        og2 og2Var = this.g;
        if (og2Var == null) {
            return mg2Var.g == null;
        }
        return og2Var.equals(mg2Var.g);
    }

    @Override // defpackage.og2
    public List i() {
        return Collections.emptyList();
    }

    @Override // defpackage.og2
    public og2 j() {
        return null;
    }

    @Override // defpackage.og2
    public og2 k() {
        return this.g;
    }

    public void n(og2 og2Var) {
        if (this.g == null) {
            this.g = og2Var;
            return;
        }
        throw new IllegalStateException("Trying to re-set self reference; old value = " + this.g + ", new = " + og2Var);
    }
}
