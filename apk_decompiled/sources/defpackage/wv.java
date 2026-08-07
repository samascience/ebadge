package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public interface wv extends v92 {
    static boolean e(w92 w92Var) {
        Iterator it = w92Var.c(wv.class).iterator();
        while (it.hasNext()) {
            if (((wv) it.next()).d()) {
                return true;
            }
        }
        return false;
    }

    default boolean d() {
        return true;
    }
}
