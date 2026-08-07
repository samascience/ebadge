package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class lx {
    private final Map a = new HashMap();
    private final Set b = new HashSet();
    private b c;
    private boolean d;
    private boolean e;

    class a implements ng1.a {
        a() {
        }

        @Override // ng1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ng1 ng1Var, boolean z) {
            if (!z) {
                lx lxVar = lx.this;
                if (!lxVar.r(ng1Var, lxVar.e)) {
                    return;
                }
            } else if (!lx.this.g(ng1Var)) {
                return;
            }
            lx.this.m();
        }
    }

    public interface b {
        void a(Set set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(ng1 ng1Var) {
        int id = ng1Var.getId();
        if (this.b.contains(Integer.valueOf(id))) {
            return false;
        }
        ng1 ng1Var2 = (ng1) this.a.get(Integer.valueOf(k()));
        if (ng1Var2 != null) {
            r(ng1Var2, false);
        }
        boolean zAdd = this.b.add(Integer.valueOf(id));
        if (!ng1Var.isChecked()) {
            ng1Var.setChecked(true);
        }
        return zAdd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(ng1 ng1Var, boolean z) {
        int id = ng1Var.getId();
        if (!this.b.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && this.b.size() == 1 && this.b.contains(Integer.valueOf(id))) {
            ng1Var.setChecked(true);
            return false;
        }
        boolean zRemove = this.b.remove(Integer.valueOf(id));
        if (ng1Var.isChecked()) {
            ng1Var.setChecked(false);
        }
        return zRemove;
    }

    public void e(ng1 ng1Var) {
        this.a.put(Integer.valueOf(ng1Var.getId()), ng1Var);
        if (ng1Var.isChecked()) {
            g(ng1Var);
        }
        ng1Var.setInternalOnCheckedChangeListener(new a());
    }

    public void f(int i) {
        ng1 ng1Var = (ng1) this.a.get(Integer.valueOf(i));
        if (ng1Var != null && g(ng1Var)) {
            m();
        }
    }

    public void h() {
        boolean zIsEmpty = this.b.isEmpty();
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            r((ng1) it.next(), false);
        }
        if (zIsEmpty) {
            return;
        }
        m();
    }

    public Set i() {
        return new HashSet(this.b);
    }

    public List j(ViewGroup viewGroup) {
        Set setI = i();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ng1) && setI.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (!this.d || this.b.isEmpty()) {
            return -1;
        }
        return ((Integer) this.b.iterator().next()).intValue();
    }

    public boolean l() {
        return this.d;
    }

    public void n(ng1 ng1Var) {
        ng1Var.setInternalOnCheckedChangeListener(null);
        this.a.remove(Integer.valueOf(ng1Var.getId()));
        this.b.remove(Integer.valueOf(ng1Var.getId()));
    }

    public void o(b bVar) {
        this.c = bVar;
    }

    public void p(boolean z) {
        this.e = z;
    }

    public void q(boolean z) {
        if (this.d != z) {
            this.d = z;
            h();
        }
    }
}
