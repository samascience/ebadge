package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public interface ox2 extends v92 {
    static boolean b(w92 w92Var) {
        Iterator it = w92Var.c(ox2.class).iterator();
        while (it.hasNext()) {
            if (((ox2) it.next()).a()) {
                return true;
            }
        }
        return false;
    }

    default boolean a() {
        return true;
    }
}
