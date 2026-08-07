package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class v2 {
    private final Context a;
    private a b;
    private b c;

    public interface a {
        void a(boolean z);
    }

    public interface b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public v2(Context context) {
        this.a = context;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract View c(MenuItem menuItem);

    public abstract boolean d();

    public abstract void e(SubMenu subMenu);

    public abstract boolean f();

    public void g() {
        this.c = null;
        this.b = null;
    }

    public void h(a aVar) {
        this.b = aVar;
    }

    public abstract void i(b bVar);

    public void j(boolean z) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(z);
        }
    }
}
