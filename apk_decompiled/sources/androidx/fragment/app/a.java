package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class a extends m implements FragmentManager.k {
    final FragmentManager t;
    boolean u;
    int v;
    boolean w;

    a(FragmentManager fragmentManager) {
        super(fragmentManager.t0(), fragmentManager.v0() != null ? fragmentManager.v0().f().getClassLoader() : null);
        this.v = -1;
        this.w = false;
        this.t = fragmentManager;
    }

    public String A() {
        return this.k;
    }

    public void B() {
        if (this.s != null) {
            for (int i = 0; i < this.s.size(); i++) {
                ((Runnable) this.s.get(i)).run();
            }
            this.s = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    Fragment C(ArrayList arrayList, Fragment fragment) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            m.a aVar = (m.a) this.c.get(size);
            int i = aVar.a;
            if (i == 1) {
                arrayList.remove(aVar.b);
            } else if (i != 3) {
                switch (i) {
                    case 6:
                        arrayList.add(aVar.b);
                        break;
                    case 7:
                        arrayList.remove(aVar.b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = aVar.b;
                        break;
                    case 10:
                        aVar.i = aVar.h;
                        break;
                }
            } else {
                arrayList.add(aVar.b);
            }
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentManager.k
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.I0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.i) {
            return true;
        }
        this.t.i(this);
        return true;
    }

    @Override // androidx.fragment.app.m
    public int h() {
        return u(false);
    }

    @Override // androidx.fragment.app.m
    public int i() {
        return u(true);
    }

    @Override // androidx.fragment.app.m
    public void j() {
        m();
        this.t.c0(this, false);
    }

    @Override // androidx.fragment.app.m
    public void k() {
        m();
        this.t.c0(this, true);
    }

    @Override // androidx.fragment.app.m
    public m l(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.l(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.m
    void n(int i, Fragment fragment, String str, int i2) {
        super.n(i, fragment, str, i2);
        fragment.mFragmentManager = this.t;
    }

    @Override // androidx.fragment.app.m
    public m o(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.o(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.m
    public m r(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.t);
        }
        if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state != Lifecycle.State.DESTROYED) {
            return super.r(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    void t(int i) {
        if (this.i) {
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                m.a aVar = (m.a) this.c.get(i2);
                Fragment fragment = aVar.b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (FragmentManager.I0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    int u(boolean z) {
        if (this.u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.I0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new r("FragmentManager"));
            v("  ", printWriter);
            printWriter.close();
        }
        this.u = true;
        if (this.i) {
            this.v = this.t.m();
        } else {
            this.v = -1;
        }
        this.t.Z(this, z);
        return this.v;
    }

    public void v(String str, PrintWriter printWriter) {
        w(str, printWriter, true);
    }

    public void w(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (this.h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.h));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f != 0 || this.g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.m);
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (this.c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            m.a aVar = (m.a) this.c.get(i);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.b);
            if (z) {
                if (aVar.d != 0 || aVar.e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.e));
                }
                if (aVar.f != 0 || aVar.g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.g));
                }
            }
        }
    }

    void x() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            m.a aVar = (m.a) this.c.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.mBeingSaved = this.w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.h);
                fragment.setSharedElementNames(this.p, this.f196q);
            }
            switch (aVar.a) {
                case 1:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.p1(fragment, false);
                    this.t.j(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.h1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.F0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.p1(fragment, false);
                    this.t.t1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.x(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.p1(fragment, false);
                    this.t.o(fragment);
                    break;
                case 8:
                    this.t.r1(fragment);
                    break;
                case 9:
                    this.t.r1(null);
                    break;
                case 10:
                    this.t.q1(fragment, aVar.i);
                    break;
            }
        }
    }

    void y() {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            m.a aVar = (m.a) this.c.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.mBeingSaved = this.w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.m1(this.h));
                fragment.setSharedElementNames(this.f196q, this.p);
            }
            switch (aVar.a) {
                case 1:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.p1(fragment, true);
                    this.t.h1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.t1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.p1(fragment, true);
                    this.t.F0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.o(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.p1(fragment, true);
                    this.t.x(fragment);
                    break;
                case 8:
                    this.t.r1(null);
                    break;
                case 9:
                    this.t.r1(fragment);
                    break;
                case 10:
                    this.t.q1(fragment, aVar.h);
                    break;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b6  */
    Fragment z(ArrayList arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.c.size()) {
            m.a aVar = (m.a) this.c.get(i);
            int i2 = aVar.a;
            if (i2 == 1) {
                arrayList.add(aVar.b);
            } else if (i2 == 2) {
                Fragment fragment3 = aVar.b;
                int i3 = fragment3.mContainerId;
                boolean z = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = (Fragment) arrayList.get(size);
                    if (fragment4.mContainerId == i3) {
                        if (fragment4 == fragment3) {
                            z = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.c.add(i, new m.a(9, fragment4, true));
                                i++;
                                fragment2 = null;
                            }
                            m.a aVar2 = new m.a(3, fragment4, true);
                            aVar2.d = aVar.d;
                            aVar2.f = aVar.f;
                            aVar2.e = aVar.e;
                            aVar2.g = aVar.g;
                            this.c.add(i, aVar2);
                            arrayList.remove(fragment4);
                            i++;
                        }
                    }
                }
                if (z) {
                    this.c.remove(i);
                    i--;
                } else {
                    aVar.a = 1;
                    aVar.c = true;
                    arrayList.add(fragment3);
                }
            } else if (i2 == 3 || i2 == 6) {
                arrayList.remove(aVar.b);
                Fragment fragment5 = aVar.b;
                if (fragment5 == fragment2) {
                    this.c.add(i, new m.a(9, fragment5));
                    i++;
                    fragment2 = null;
                }
            } else if (i2 == 7) {
                arrayList.add(aVar.b);
            } else if (i2 == 8) {
                this.c.add(i, new m.a(9, fragment2, true));
                aVar.c = true;
                i++;
                fragment2 = aVar.b;
            }
            i++;
        }
        return fragment2;
    }
}
