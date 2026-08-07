package defpackage;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class jq0 extends a {
    private final FragmentManager c;
    private final int d;
    private m e;
    private Fragment f;
    private boolean g;

    public jq0(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String v(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.e == null) {
            this.e = this.c.p();
        }
        this.e.l(fragment);
        if (fragment.equals(this.f)) {
            this.f = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void c(ViewGroup viewGroup) {
        m mVar = this.e;
        if (mVar != null) {
            if (!this.g) {
                try {
                    this.g = true;
                    mVar.k();
                    this.g = false;
                } catch (Throwable th) {
                    this.g = false;
                    throw th;
                }
            }
            this.e = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i) {
        if (this.e == null) {
            this.e = this.c.p();
        }
        long jU = u(i);
        Fragment fragmentJ0 = this.c.j0(v(viewGroup.getId(), jU));
        if (fragmentJ0 != null) {
            this.e.g(fragmentJ0);
        } else {
            fragmentJ0 = t(i);
            this.e.b(viewGroup.getId(), fragmentJ0, v(viewGroup.getId(), jU));
        }
        if (fragmentJ0 != this.f) {
            fragmentJ0.setMenuVisibility(false);
            if (this.d == 1) {
                this.e.r(fragmentJ0, Lifecycle.State.STARTED);
            } else {
                fragmentJ0.setUserVisibleHint(false);
            }
        }
        return fragmentJ0;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void l(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable m() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public void o(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.d == 1) {
                    if (this.e == null) {
                        this.e = this.c.p();
                    }
                    this.e.r(this.f, Lifecycle.State.STARTED);
                } else {
                    this.f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.d == 1) {
                if (this.e == null) {
                    this.e = this.c.p();
                }
                this.e.r(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void r(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract Fragment t(int i);

    public long u(int i) {
        return i;
    }

    public jq0(FragmentManager fragmentManager, int i) {
        this.e = null;
        this.f = null;
        this.c = fragmentManager;
        this.d = i;
    }
}
