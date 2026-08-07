package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import defpackage.e43;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class h {
    private final CopyOnWriteArrayList a = new CopyOnWriteArrayList();
    private final FragmentManager b;

    h(FragmentManager fragmentManager) {
        this.b = fragmentManager;
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().a(fragment, bundle, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void b(Fragment fragment, boolean z) {
        this.b.v0().f();
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().b(fragment, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().c(fragment, bundle, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void d(Fragment fragment, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().d(fragment, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void e(Fragment fragment, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().e(fragment, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void f(Fragment fragment, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().f(fragment, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void g(Fragment fragment, boolean z) {
        this.b.v0().f();
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().g(fragment, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().h(fragment, bundle, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void i(Fragment fragment, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().i(fragment, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().j(fragment, bundle, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void k(Fragment fragment, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().k(fragment, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void l(Fragment fragment, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().l(fragment, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().m(fragment, view, bundle, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    void n(Fragment fragment, boolean z) {
        Fragment fragmentY0 = this.b.y0();
        if (fragmentY0 != null) {
            fragmentY0.getParentFragmentManager().x0().n(fragment, true);
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            if (!z) {
                throw null;
            }
            throw null;
        }
    }
}
