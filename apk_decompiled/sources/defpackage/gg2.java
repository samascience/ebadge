package defpackage;

import com.fasterxml.classmate.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class gg2 extends og2 {
    protected final og2[] g;

    public gg2(Class cls, b bVar, og2[] og2VarArr) {
        super(cls, bVar);
        this.g = og2VarArr == null ? og2.c : og2VarArr;
    }

    @Override // defpackage.og2
    public StringBuilder b(StringBuilder sb) {
        return a(sb);
    }

    @Override // defpackage.og2
    public StringBuilder c(StringBuilder sb) {
        StringBuilder sbA = a(sb);
        int length = this.g.length;
        if (length > 0) {
            sbA.append(" extends ");
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    sbA.append(",");
                }
                sbA = this.g[i].b(sbA);
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
        og2[] og2VarArr = this.g;
        return og2VarArr.length == 0 ? Collections.emptyList() : Arrays.asList(og2VarArr);
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
