package defpackage;

import com.fasterxml.classmate.b;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class dg2 extends og2 {
    protected final og2 g;

    public dg2(Class cls, b bVar, og2 og2Var) {
        super(cls, bVar);
        this.g = og2Var;
    }

    @Override // defpackage.og2
    public StringBuilder b(StringBuilder sb) {
        StringBuilder sbB = this.g.b(sb);
        sbB.append("[]");
        return sbB;
    }

    @Override // defpackage.og2
    public StringBuilder c(StringBuilder sb) {
        return b(sb);
    }

    @Override // defpackage.og2
    public boolean d() {
        return false;
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
        return null;
    }
}
