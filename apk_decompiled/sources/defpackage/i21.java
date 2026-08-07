package defpackage;

import androidx.lifecycle.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i21 {
    private final List a = new ArrayList();

    public final void a(h81 h81Var, ar0 ar0Var) {
        p31.f(h81Var, "clazz");
        p31.f(ar0Var, "initializer");
        this.a.add(new le3(c81.a(h81Var), ar0Var));
    }

    public final q.b b() {
        le3[] le3VarArr = (le3[]) this.a.toArray(new le3[0]);
        return new h21((le3[]) Arrays.copyOf(le3VarArr, le3VarArr.length));
    }
}
