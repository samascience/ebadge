package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class l51 extends u51 implements Iterable {
    private final ArrayList a = new ArrayList();

    private u51 l() {
        int size = this.a.size();
        if (size == 1) {
            return (u51) this.a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    @Override // defpackage.u51
    public int a() {
        return l().a();
    }

    @Override // defpackage.u51
    public String e() {
        return l().e();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof l51) && ((l51) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.a.iterator();
    }

    public void j(u51 u51Var) {
        if (u51Var == null) {
            u51Var = l61.a;
        }
        this.a.add(u51Var);
    }

    public void k(l51 l51Var) {
        this.a.addAll(l51Var.a);
    }
}
