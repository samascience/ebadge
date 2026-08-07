package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import com.tencent.connect.common.Constants;
import defpackage.be3;
import defpackage.jv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class SpecialEffectsController {
    private final ViewGroup a;
    final ArrayList b = new ArrayList();
    final ArrayList c = new ArrayList();
    boolean d = false;
    boolean e = false;

    class a implements Runnable {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpecialEffectsController.this.b.contains(this.a)) {
                this.a.e().applyState(this.a.f().mView);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ d a;

        b(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            SpecialEffectsController.this.b.remove(this.a);
            SpecialEffectsController.this.c.remove(this.a);
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            b = iArr;
            try {
                iArr[Operation.LifecycleImpact.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Operation.LifecycleImpact.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Operation.State.values().length];
            a = iArr2;
            try {
                iArr2[Operation.State.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Operation.State.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Operation.State.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Operation.State.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class d extends Operation {
        private final k h;

        d(Operation.State state, Operation.LifecycleImpact lifecycleImpact, k kVar, jv jvVar) {
            super(state, lifecycleImpact, kVar.k(), jvVar);
            this.h = kVar;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void c() {
            super.c();
            this.h.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        void l() {
            if (g() != Operation.LifecycleImpact.ADDING) {
                if (g() == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragmentK = this.h.k();
                    View viewRequireView = fragmentK.requireView();
                    if (FragmentManager.I0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragmentK);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.h.k();
            View viewFindFocus = fragmentK2.mView.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.setFocusedView(viewFindFocus);
                if (FragmentManager.I0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK2);
                }
            }
            View viewRequireView2 = f().requireView();
            if (viewRequireView2.getParent() == null) {
                this.h.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragmentK2.getPostOnViewCreatedAlpha());
        }
    }

    SpecialEffectsController(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    private void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, k kVar) {
        synchronized (this.b) {
            try {
                jv jvVar = new jv();
                Operation operationH = h(kVar.k());
                if (operationH != null) {
                    operationH.k(state, lifecycleImpact);
                    return;
                }
                d dVar = new d(state, lifecycleImpact, kVar, jvVar);
                this.b.add(dVar);
                dVar.a(new a(dVar));
                dVar.a(new b(dVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Operation h(Fragment fragment) {
        for (Operation operation : this.b) {
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    private Operation i(Fragment fragment) {
        for (Operation operation : this.c) {
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    static SpecialEffectsController n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.A0());
    }

    static SpecialEffectsController o(ViewGroup viewGroup, s sVar) {
        int i = R$id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController specialEffectsControllerA = sVar.a(viewGroup);
        viewGroup.setTag(i, specialEffectsControllerA);
        return specialEffectsControllerA;
    }

    private void q() {
        for (Operation operation : this.b) {
            if (operation.g() == Operation.LifecycleImpact.ADDING) {
                operation.k(Operation.State.from(operation.f().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    void b(Operation.State state, k kVar) {
        if (FragmentManager.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + kVar.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, kVar);
    }

    void c(k kVar) {
        if (FragmentManager.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + kVar.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, kVar);
    }

    void d(k kVar) {
        if (FragmentManager.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + kVar.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, kVar);
    }

    void e(k kVar) {
        if (FragmentManager.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + kVar.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, kVar);
    }

    abstract void f(List list, boolean z);

    void g() {
        if (this.e) {
            return;
        }
        if (!be3.S(this.a)) {
            j();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.b.isEmpty()) {
                    ArrayList<Operation> arrayList = new ArrayList(this.c);
                    this.c.clear();
                    for (Operation operation : arrayList) {
                        if (FragmentManager.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.b();
                        if (!operation.i()) {
                            this.c.add(operation);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    if (FragmentManager.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Operation) it.next()).l();
                    }
                    f(arrayList2, this.d);
                    this.d = false;
                    if (FragmentManager.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void j() {
        if (FragmentManager.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zS = be3.S(this.a);
        synchronized (this.b) {
            try {
                q();
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    ((Operation) it.next()).l();
                }
                for (Operation operation : new ArrayList(this.c)) {
                    if (FragmentManager.I0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        sb.append(zS ? Constants.STR_EMPTY : "Container " + this.a + " is not attached to window. ");
                        sb.append("Cancelling running operation ");
                        sb.append(operation);
                        Log.v("FragmentManager", sb.toString());
                    }
                    operation.b();
                }
                for (Operation operation2 : new ArrayList(this.b)) {
                    if (FragmentManager.I0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        sb2.append(zS ? Constants.STR_EMPTY : "Container " + this.a + " is not attached to window. ");
                        sb2.append("Cancelling pending operation ");
                        sb2.append(operation2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    operation2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void k() {
        if (this.e) {
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.e = false;
            g();
        }
    }

    Operation.LifecycleImpact l(k kVar) {
        Operation operationH = h(kVar.k());
        Operation.LifecycleImpact lifecycleImpactG = operationH != null ? operationH.g() : null;
        Operation operationI = i(kVar.k());
        return (operationI == null || !(lifecycleImpactG == null || lifecycleImpactG == Operation.LifecycleImpact.NONE)) ? lifecycleImpactG : operationI.g();
    }

    public ViewGroup m() {
        return this.a;
    }

    void p() {
        synchronized (this.b) {
            try {
                q();
                this.e = false;
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    Operation operation = (Operation) this.b.get(size);
                    Operation.State stateFrom = Operation.State.from(operation.f().mView);
                    Operation.State stateE = operation.e();
                    Operation.State state = Operation.State.VISIBLE;
                    if (stateE == state && stateFrom != state) {
                        this.e = operation.f().isPostponed();
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void r(boolean z) {
        this.d = z;
    }

    static class Operation {
        private State a;
        private LifecycleImpact b;
        private final Fragment c;
        private final List d = new ArrayList();
        private final HashSet e = new HashSet();
        private boolean f = false;
        private boolean g = false;

        enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        class a implements jv.a {
            a() {
            }

            @Override // jv.a
            public void onCancel() {
                Operation.this.b();
            }
        }

        Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, jv jvVar) {
            this.a = state;
            this.b = lifecycleImpact;
            this.c = fragment;
            jvVar.b(new a());
        }

        final void a(Runnable runnable) {
            this.d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.e).iterator();
            while (it.hasNext()) {
                ((jv) it.next()).a();
            }
        }

        public void c() {
            if (this.g) {
                return;
            }
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void d(jv jvVar) {
            if (this.e.remove(jvVar) && this.e.isEmpty()) {
                c();
            }
        }

        public State e() {
            return this.a;
        }

        public final Fragment f() {
            return this.c;
        }

        LifecycleImpact g() {
            return this.b;
        }

        final boolean h() {
            return this.f;
        }

        final boolean i() {
            return this.g;
        }

        public final void j(jv jvVar) {
            l();
            this.e.add(jvVar);
        }

        final void k(State state, LifecycleImpact lifecycleImpact) {
            int i = c.b[lifecycleImpact.ordinal()];
            if (i == 1) {
                if (this.a == State.REMOVED) {
                    if (FragmentManager.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                    }
                    this.a = State.VISIBLE;
                    this.b = LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (i == 2) {
                if (FragmentManager.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
                }
                this.a = State.REMOVED;
                this.b = LifecycleImpact.REMOVING;
                return;
            }
            if (i == 3 && this.a != State.REMOVED) {
                if (FragmentManager.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> " + state + ". ");
                }
                this.a = state;
            }
        }

        abstract void l();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.a + "} {mLifecycleImpact = " + this.b + "} {mFragment = " + this.c + "}";
        }

        enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static State from(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            void applyState(View view) {
                int i = c.a[ordinal()];
                if (i == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    if (FragmentManager.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i == 3) {
                    if (FragmentManager.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i != 4) {
                    return;
                }
                if (FragmentManager.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }

            static State from(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i);
            }
        }
    }
}
