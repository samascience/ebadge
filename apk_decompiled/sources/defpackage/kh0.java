package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class kh0 {
    private final List a = new ArrayList();

    private static final class a {
        private final Class a;
        final fg0 b;

        a(Class cls, fg0 fg0Var) {
            this.a = cls;
            this.b = fg0Var;
        }

        boolean a(Class cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, fg0 fg0Var) {
        this.a.add(new a(cls, fg0Var));
    }

    public synchronized fg0 b(Class cls) {
        for (a aVar : this.a) {
            if (aVar.a(cls)) {
                return aVar.b;
            }
        }
        return null;
    }
}
