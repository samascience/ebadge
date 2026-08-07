package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class j extends androidx.lifecycle.o {
    private static final androidx.lifecycle.q.b k = new a();
    private final boolean g;
    private final HashMap d = new HashMap();
    private final HashMap e = new HashMap();
    private final HashMap f = new HashMap();
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;

    class a implements androidx.lifecycle.q.b {
        a() {
        }

        @Override // androidx.lifecycle.q.b
        public androidx.lifecycle.o a(Class cls) {
            return new j(true);
        }
    }

    j(boolean z) {
        this.g = z;
    }

    private void j(String str) {
        j jVar = (j) this.e.get(str);
        if (jVar != null) {
            jVar.d();
            this.e.remove(str);
        }
        androidx.lifecycle.r rVar = (androidx.lifecycle.r) this.f.get(str);
        if (rVar != null) {
            rVar.a();
            this.f.remove(str);
        }
    }

    static j m(androidx.lifecycle.r rVar) {
        return (j) new androidx.lifecycle.q(rVar, k).a(j.class);
    }

    @Override // androidx.lifecycle.o
    protected void d() {
        if (FragmentManager.I0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.d.equals(jVar.d) && this.e.equals(jVar.e) && this.f.equals(jVar.f);
    }

    void f(Fragment fragment) {
        if (this.j) {
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.d.containsKey(fragment.mWho)) {
                return;
            }
            this.d.put(fragment.mWho, fragment);
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    void h(Fragment fragment) {
        if (FragmentManager.I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        j(fragment.mWho);
    }

    public int hashCode() {
        return (((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    void i(String str) {
        if (FragmentManager.I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        j(str);
    }

    Fragment k(String str) {
        return (Fragment) this.d.get(str);
    }

    j l(Fragment fragment) {
        j jVar = (j) this.e.get(fragment.mWho);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this.g);
        this.e.put(fragment.mWho, jVar2);
        return jVar2;
    }

    Collection n() {
        return new ArrayList(this.d.values());
    }

    androidx.lifecycle.r o(Fragment fragment) {
        androidx.lifecycle.r rVar = (androidx.lifecycle.r) this.f.get(fragment.mWho);
        if (rVar != null) {
            return rVar;
        }
        androidx.lifecycle.r rVar2 = new androidx.lifecycle.r();
        this.f.put(fragment.mWho, rVar2);
        return rVar2;
    }

    boolean p() {
        return this.h;
    }

    void q(Fragment fragment) {
        if (this.j) {
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.d.remove(fragment.mWho) == null || !FragmentManager.I0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void r(boolean z) {
        this.j = z;
    }

    boolean s(Fragment fragment) {
        if (this.d.containsKey(fragment.mWho)) {
            return this.g ? this.h : !this.i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
