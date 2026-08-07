package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yg2 {
    private final List a = new ArrayList();

    private static final class a {
        private final Class a;
        final xg2 b;

        a(Class cls, xg2 xg2Var) {
            this.a = cls;
            this.b = xg2Var;
        }

        boolean a(Class cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, xg2 xg2Var) {
        this.a.add(new a(cls, xg2Var));
    }

    public synchronized xg2 b(Class cls) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.a.get(i);
            if (aVar.a(cls)) {
                return aVar.b;
            }
        }
        return null;
    }
}
