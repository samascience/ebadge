package defpackage;

import com.fasterxml.classmate.b;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u63 extends og2 {
    protected final int g;
    protected og2 h;

    public u63(int i) {
        super(Object.class, b.b());
        this.g = i;
    }

    @Override // defpackage.og2
    public StringBuilder b(StringBuilder sb) {
        sb.append('<');
        sb.append(this.g);
        sb.append('>');
        return sb;
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
    public boolean equals(Object obj) {
        return obj == this;
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

    public og2 n() {
        return this.h;
    }

    public void o(og2 og2Var) {
        this.h = og2Var;
    }
}
