package defpackage;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class kt2 extends u2 implements e.a {
    private Context c;
    private ActionBarContextView d;
    private u2.a e;
    private WeakReference f;
    private boolean g;
    private boolean h;
    private e i;

    public kt2(Context context, ActionBarContextView actionBarContextView, u2.a aVar, boolean z) {
        this.c = context;
        this.d = actionBarContextView;
        this.e = aVar;
        e eVarX = new e(actionBarContextView.getContext()).X(1);
        this.i = eVarX;
        eVarX.W(this);
        this.h = z;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(e eVar, MenuItem menuItem) {
        return this.e.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(e eVar) {
        k();
        this.d.l();
    }

    @Override // defpackage.u2
    public void c() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.e.b(this);
    }

    @Override // defpackage.u2
    public View d() {
        WeakReference weakReference = this.f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // defpackage.u2
    public Menu e() {
        return this.i;
    }

    @Override // defpackage.u2
    public MenuInflater f() {
        return new mw2(this.d.getContext());
    }

    @Override // defpackage.u2
    public CharSequence g() {
        return this.d.getSubtitle();
    }

    @Override // defpackage.u2
    public CharSequence i() {
        return this.d.getTitle();
    }

    @Override // defpackage.u2
    public void k() {
        this.e.d(this, this.i);
    }

    @Override // defpackage.u2
    public boolean l() {
        return this.d.j();
    }

    @Override // defpackage.u2
    public void m(View view) {
        this.d.setCustomView(view);
        this.f = view != null ? new WeakReference(view) : null;
    }

    @Override // defpackage.u2
    public void n(int i) {
        o(this.c.getString(i));
    }

    @Override // defpackage.u2
    public void o(CharSequence charSequence) {
        this.d.setSubtitle(charSequence);
    }

    @Override // defpackage.u2
    public void q(int i) {
        r(this.c.getString(i));
    }

    @Override // defpackage.u2
    public void r(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    @Override // defpackage.u2
    public void s(boolean z) {
        super.s(z);
        this.d.setTitleOptional(z);
    }
}
