package defpackage;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;

/* JADX INFO: loaded from: classes.dex */
public class l42 {
    private final Context a;
    private final e b;
    private final View c;
    final i d;
    c e;

    class a implements e.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            c cVar = l42.this.e;
            if (cVar != null) {
                return cVar.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
        }
    }

    class b implements PopupWindow.OnDismissListener {
        b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l42.this.getClass();
        }
    }

    public interface c {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public l42(Context context, View view) {
        this(context, view, 0);
    }

    public Menu a() {
        return this.b;
    }

    public void b(boolean z) {
        this.d.g(z);
    }

    public void c(c cVar) {
        this.e = cVar;
    }

    public void d() {
        this.d.k();
    }

    public l42(Context context, View view, int i) {
        this(context, view, i, R$attr.popupMenuStyle, 0);
    }

    public l42(Context context, View view, int i, int i2, int i3) {
        this.a = context;
        this.c = view;
        e eVar = new e(context);
        this.b = eVar;
        eVar.W(new a());
        i iVar = new i(context, eVar, view, false, i2, i3);
        this.d = iVar;
        iVar.h(i);
        iVar.i(new b());
    }
}
