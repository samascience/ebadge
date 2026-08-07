package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.greenrobot.greendao.DaoException;

/* JADX INFO: loaded from: classes4.dex */
class fi3 {
    private final y0 a;
    private final List b = new ArrayList();
    private final String c;

    fi3(y0 y0Var, String str) {
        this.a = y0Var;
        this.c = str;
    }

    void a(gi3 gi3Var, gi3... gi3VarArr) {
        c(gi3Var);
        this.b.add(gi3Var);
        for (gi3 gi3Var2 : gi3VarArr) {
            c(gi3Var2);
            this.b.add(gi3Var2);
        }
    }

    void b(StringBuilder sb, String str, List list) {
        ListIterator listIterator = this.b.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.hasPrevious()) {
                sb.append(" AND ");
            }
            gi3 gi3Var = (gi3) listIterator.next();
            gi3Var.b(sb, str);
            gi3Var.a(list);
        }
    }

    void c(gi3 gi3Var) {
        if (gi3Var instanceof gi3.b) {
            d(((gi3.b) gi3Var).d);
        }
    }

    void d(h82 h82Var) {
        y0 y0Var = this.a;
        if (y0Var != null) {
            for (h82 h82Var2 : y0Var.getProperties()) {
                if (h82Var == h82Var2) {
                    return;
                }
            }
            throw new DaoException("Property '" + h82Var.c + "' is not part of " + this.a);
        }
    }

    boolean e() {
        return this.b.isEmpty();
    }
}
