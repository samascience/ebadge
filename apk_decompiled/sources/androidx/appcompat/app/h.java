package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f0;
import defpackage.b52;
import defpackage.be3;
import defpackage.e43;
import defpackage.s70;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class h extends androidx.appcompat.app.a {
    final s70 a;
    final Window.Callback b;
    final AppCompatDelegateImpl.g c;
    boolean d;
    private boolean e;
    private boolean f;
    private ArrayList g = new ArrayList();
    private final Runnable h = new a();
    private final Toolbar.h i;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.y();
        }
    }

    class b implements Toolbar.h {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.h
        public boolean onMenuItemClick(MenuItem menuItem) {
            return h.this.b.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements androidx.appcompat.view.menu.j.a {
        private boolean a;

        c() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
            if (this.a) {
                return;
            }
            this.a = true;
            h.this.a.h();
            h.this.b.onPanelClosed(108, eVar);
            this.a = false;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            h.this.b.onMenuOpened(108, eVar);
            return true;
        }
    }

    private final class d implements androidx.appcompat.view.menu.e.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (h.this.a.b()) {
                h.this.b.onPanelClosed(108, eVar);
            } else if (h.this.b.onPreparePanel(0, null, eVar)) {
                h.this.b.onMenuOpened(108, eVar);
            }
        }
    }

    private class e implements AppCompatDelegateImpl.g {
        e() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public boolean a(int i) {
            if (i != 0) {
                return false;
            }
            h hVar = h.this;
            if (hVar.d) {
                return false;
            }
            hVar.a.c();
            h.this.d = true;
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(h.this.a.getContext());
            }
            return null;
        }
    }

    h(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.i = bVar;
        b52.g(toolbar);
        f0 f0Var = new f0(toolbar, false);
        this.a = f0Var;
        this.b = (Window.Callback) b52.g(callback);
        f0Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        f0Var.setWindowTitle(charSequence);
        this.c = new e();
    }

    private Menu x() {
        if (!this.e) {
            this.a.p(new c(), new d());
            this.e = true;
        }
        return this.a.l();
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.a.f();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (!this.a.j()) {
            return false;
        }
        this.a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.f) {
            return;
        }
        this.f = z;
        if (this.g.size() <= 0) {
            return;
        }
        e43.a(this.g.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.a.t();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.a.r().removeCallbacks(this.h);
        be3.h0(this.a.r(), this.h);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.a
    void n() {
        this.a.r().removeCallbacks(this.h);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent) {
        Menu menuX = x();
        if (menuX == null) {
            return false;
        }
        menuX.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuX.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.a.g();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        z(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z) {
        z(z ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    void y() {
        Menu menuX = x();
        androidx.appcompat.view.menu.e eVar = menuX instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menuX : null;
        if (eVar != null) {
            eVar.i0();
        }
        try {
            menuX.clear();
            if (!this.b.onCreatePanelMenu(0, menuX) || !this.b.onPreparePanel(0, null, menuX)) {
                menuX.clear();
            }
        } finally {
            if (eVar != null) {
                eVar.h0();
            }
        }
    }

    public void z(int i, int i2) {
        this.a.k((i & i2) | ((~i2) & this.a.t()));
    }
}
