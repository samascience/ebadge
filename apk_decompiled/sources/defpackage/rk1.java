package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface rk1 {

    public static class a {
        public final w81 a;
        public final List b;
        public final y50 c;

        public a(w81 w81Var, y50 y50Var) {
            this(w81Var, Collections.emptyList(), y50Var);
        }

        public a(w81 w81Var, List list, y50 y50Var) {
            this.a = (w81) z42.d(w81Var);
            this.b = (List) z42.d(list);
            this.c = (y50) z42.d(y50Var);
        }
    }

    boolean a(Object obj);

    a b(Object obj, int i, int i2, rx1 rx1Var);
}
