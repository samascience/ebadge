package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class r03 implements bb1 {
    private final Set a = Collections.newSetFromMap(new WeakHashMap());

    public void i() {
        this.a.clear();
    }

    public List j() {
        return na3.i(this.a);
    }

    public void k(j03 j03Var) {
        this.a.add(j03Var);
    }

    public void l(j03 j03Var) {
        this.a.remove(j03Var);
    }

    @Override // defpackage.bb1
    public void onDestroy() {
        Iterator it = na3.i(this.a).iterator();
        while (it.hasNext()) {
            ((j03) it.next()).onDestroy();
        }
    }

    @Override // defpackage.bb1
    public void onStart() {
        Iterator it = na3.i(this.a).iterator();
        while (it.hasNext()) {
            ((j03) it.next()).onStart();
        }
    }

    @Override // defpackage.bb1
    public void onStop() {
        Iterator it = na3.i(this.a).iterator();
        while (it.hasNext()) {
            ((j03) it.next()).onStop();
        }
    }
}
