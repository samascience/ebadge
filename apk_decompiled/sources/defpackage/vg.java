package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
abstract class vg {
    final Context a;
    private ap2 b;
    private ap2 c;

    vg(Context context) {
        this.a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof nw2)) {
            return menuItem;
        }
        nw2 nw2Var = (nw2) menuItem;
        if (this.b == null) {
            this.b = new ap2();
        }
        MenuItem menuItem2 = (MenuItem) this.b.get(nw2Var);
        if (menuItem2 != null) {
            return menuItem2;
        }
        ri1 ri1Var = new ri1(this.a, nw2Var);
        this.b.put(nw2Var, ri1Var);
        return ri1Var;
    }

    final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    final void e() {
        ap2 ap2Var = this.b;
        if (ap2Var != null) {
            ap2Var.clear();
        }
        ap2 ap2Var2 = this.c;
        if (ap2Var2 != null) {
            ap2Var2.clear();
        }
    }

    final void f(int i) {
        if (this.b == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.b.size()) {
            if (((nw2) this.b.h(i2)).getGroupId() == i) {
                this.b.j(i2);
                i2--;
            }
            i2++;
        }
    }

    final void g(int i) {
        if (this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (((nw2) this.b.h(i2)).getItemId() == i) {
                this.b.j(i2);
                return;
            }
        }
    }
}
