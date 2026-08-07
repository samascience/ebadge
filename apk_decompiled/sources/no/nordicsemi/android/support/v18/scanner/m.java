package no.nordicsemi.android.support.v18.scanner;

import defpackage.ek2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
class m {
    private final Set a = new HashSet();

    m() {
    }

    private void b() {
        LinkedList linkedList = new LinkedList();
        for (b.a aVar : this.a) {
            ek2 ek2Var = aVar.h;
            if ((ek2Var instanceof o) && ((o) ek2Var).b()) {
                linkedList.add(aVar);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.a.remove((b.a) it.next());
        }
    }

    void a(b.a aVar) {
        this.a.add(aVar);
    }

    boolean c(ek2 ek2Var) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ek2 ek2Var2 = ((b.a) it.next()).h;
            if (ek2Var2 == ek2Var) {
                return true;
            }
            if ((ek2Var2 instanceof o) && ((o) ek2Var2).a() == ek2Var) {
                return true;
            }
        }
        return false;
    }

    b.a d(ek2 ek2Var) {
        for (b.a aVar : this.a) {
            ek2 ek2Var2 = aVar.h;
            if (ek2Var2 == ek2Var) {
                return aVar;
            }
            if ((ek2Var2 instanceof o) && ((o) ek2Var2).a() == ek2Var) {
                this.a.remove(aVar);
                return aVar;
            }
        }
        b();
        return null;
    }
}
