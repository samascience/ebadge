package androidx.lifecycle;

import defpackage.cb1;
import defpackage.db1;
import defpackage.l9;
import defpackage.lj2;
import defpackage.p31;
import defpackage.rk0;
import defpackage.y70;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g extends Lifecycle {
    public static final a j = new a(null);
    private final boolean b;
    private rk0 c;
    private Lifecycle.State d;
    private final WeakReference e;
    private int f;
    private boolean g;
    private boolean h;
    private ArrayList i;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
            p31.f(state, "state1");
            return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
        }

        private a() {
        }
    }

    public static final class b {
        private Lifecycle.State a;
        private f b;

        public b(cb1 cb1Var, Lifecycle.State state) {
            p31.f(state, "initialState");
            p31.c(cb1Var);
            this.b = h.f(cb1Var);
            this.a = state;
        }

        public final void a(db1 db1Var, Lifecycle.Event event) {
            p31.f(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.a = g.j.a(this.a, targetState);
            f fVar = this.b;
            p31.c(db1Var);
            fVar.c(db1Var, event);
            this.a = targetState;
        }

        public final Lifecycle.State b() {
            return this.a;
        }
    }

    private g(db1 db1Var, boolean z) {
        this.b = z;
        this.c = new rk0();
        this.d = Lifecycle.State.INITIALIZED;
        this.i = new ArrayList();
        this.e = new WeakReference(db1Var);
    }

    private final void e(db1 db1Var) {
        Iterator itDescendingIterator = this.c.descendingIterator();
        p31.e(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            p31.e(entry, "next()");
            cb1 cb1Var = (cb1) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.d) > 0 && !this.h && this.c.contains(cb1Var)) {
                Lifecycle.Event eventA = Lifecycle.Event.Companion.a(bVar.b());
                if (eventA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                m(eventA.getTargetState());
                bVar.a(db1Var, eventA);
                l();
            }
        }
    }

    private final Lifecycle.State f(cb1 cb1Var) {
        b bVar;
        Map.Entry entryH = this.c.h(cb1Var);
        Lifecycle.State state = null;
        Lifecycle.State stateB = (entryH == null || (bVar = (b) entryH.getValue()) == null) ? null : bVar.b();
        if (!this.i.isEmpty()) {
            ArrayList arrayList = this.i;
            state = (Lifecycle.State) arrayList.get(arrayList.size() - 1);
        }
        a aVar = j;
        return aVar.a(aVar.a(this.d, stateB), state);
    }

    private final void g(String str) {
        if (!this.b || l9.g().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void h(db1 db1Var) {
        lj2.d dVarC = this.c.c();
        p31.e(dVarC, "observerMap.iteratorWithAdditions()");
        while (dVarC.hasNext() && !this.h) {
            Map.Entry entry = (Map.Entry) dVarC.next();
            cb1 cb1Var = (cb1) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.d) < 0 && !this.h && this.c.contains(cb1Var)) {
                m(bVar.b());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.b());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(db1Var, eventC);
                l();
            }
        }
    }

    private final boolean j() {
        if (this.c.size() == 0) {
            return true;
        }
        Map.Entry entryA = this.c.a();
        p31.c(entryA);
        Lifecycle.State stateB = ((b) entryA.getValue()).b();
        Map.Entry entryD = this.c.d();
        p31.c(entryD);
        Lifecycle.State stateB2 = ((b) entryD.getValue()).b();
        return stateB == stateB2 && this.d == stateB2;
    }

    private final void k(Lifecycle.State state) {
        Lifecycle.State state2 = this.d;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.d + " in component " + this.e.get()).toString());
        }
        this.d = state;
        if (this.g || this.f != 0) {
            this.h = true;
            return;
        }
        this.g = true;
        o();
        this.g = false;
        if (this.d == Lifecycle.State.DESTROYED) {
            this.c = new rk0();
        }
    }

    private final void l() {
        ArrayList arrayList = this.i;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void m(Lifecycle.State state) {
        this.i.add(state);
    }

    private final void o() {
        db1 db1Var = (db1) this.e.get();
        if (db1Var == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!j()) {
            this.h = false;
            Lifecycle.State state = this.d;
            Map.Entry entryA = this.c.a();
            p31.c(entryA);
            if (state.compareTo(((b) entryA.getValue()).b()) < 0) {
                e(db1Var);
            }
            Map.Entry entryD = this.c.d();
            if (!this.h && entryD != null && this.d.compareTo(((b) entryD.getValue()).b()) > 0) {
                h(db1Var);
            }
        }
        this.h = false;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(cb1 cb1Var) {
        db1 db1Var;
        p31.f(cb1Var, "observer");
        g("addObserver");
        Lifecycle.State state = this.d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(cb1Var, state2);
        if (((b) this.c.f(cb1Var, bVar)) == null && (db1Var = (db1) this.e.get()) != null) {
            boolean z = this.f != 0 || this.g;
            Lifecycle.State stateF = f(cb1Var);
            this.f++;
            while (bVar.b().compareTo(stateF) < 0 && this.c.contains(cb1Var)) {
                m(bVar.b());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.b());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(db1Var, eventC);
                l();
                stateF = f(cb1Var);
            }
            if (!z) {
                o();
            }
            this.f--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State b() {
        return this.d;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void d(cb1 cb1Var) {
        p31.f(cb1Var, "observer");
        g("removeObserver");
        this.c.g(cb1Var);
    }

    public void i(Lifecycle.Event event) {
        p31.f(event, "event");
        g("handleLifecycleEvent");
        k(event.getTargetState());
    }

    public void n(Lifecycle.State state) {
        p31.f(state, "state");
        g("setCurrentState");
        k(state);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(db1 db1Var) {
        this(db1Var, true);
        p31.f(db1Var, "provider");
    }
}
