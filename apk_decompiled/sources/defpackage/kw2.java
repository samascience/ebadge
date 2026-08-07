package defpackage;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class kw2 extends ActionMode {
    final Context a;
    final u2 b;

    public static class a implements u2.a {
        final ActionMode.Callback a;
        final Context b;
        final ArrayList c = new ArrayList();
        final ap2 d = new ap2();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            ti1 ti1Var = new ti1(this.b, (lw2) menu);
            this.d.put(menu, ti1Var);
            return ti1Var;
        }

        @Override // u2.a
        public boolean a(u2 u2Var, MenuItem menuItem) {
            return this.a.onActionItemClicked(e(u2Var), new ri1(this.b, (nw2) menuItem));
        }

        @Override // u2.a
        public void b(u2 u2Var) {
            this.a.onDestroyActionMode(e(u2Var));
        }

        @Override // u2.a
        public boolean c(u2 u2Var, Menu menu) {
            return this.a.onCreateActionMode(e(u2Var), f(menu));
        }

        @Override // u2.a
        public boolean d(u2 u2Var, Menu menu) {
            return this.a.onPrepareActionMode(e(u2Var), f(menu));
        }

        public ActionMode e(u2 u2Var) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                kw2 kw2Var = (kw2) this.c.get(i);
                if (kw2Var != null && kw2Var.b == u2Var) {
                    return kw2Var;
                }
            }
            kw2 kw2Var2 = new kw2(this.b, u2Var);
            this.c.add(kw2Var2);
            return kw2Var2;
        }
    }

    public kw2(Context context, u2 u2Var) {
        this.a = context;
        this.b = u2Var;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new ti1(this.a, (lw2) this.b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.b.s(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.n(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.q(i);
    }
}
