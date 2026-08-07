package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f;
import androidx.savedstate.a;
import defpackage.db1;
import defpackage.lj2;
import defpackage.p31;
import defpackage.y70;
import defpackage.zj2;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final b g = new b(null);
    private boolean b;
    private Bundle c;
    private boolean d;
    private Recreator.b e;
    private final lj2 a = new lj2();
    private boolean f = true;

    /* JADX INFO: renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0038a {
        void a(zj2 zj2Var);
    }

    private static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        private b() {
        }
    }

    public interface c {
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a aVar, db1 db1Var, Lifecycle.Event event) {
        p31.f(aVar, "this$0");
        p31.f(db1Var, "<anonymous parameter 0>");
        p31.f(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            aVar.f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            aVar.f = false;
        }
    }

    public final Bundle b(String str) {
        p31.f(str, "key");
        if (!this.d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.c = null;
        }
        return bundle2;
    }

    public final c c(String str) {
        p31.f(str, "key");
        for (Map.Entry entry : this.a) {
            p31.e(entry, "components");
            String str2 = (String) entry.getKey();
            c cVar = (c) entry.getValue();
            if (p31.a(str2, str)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        p31.f(lifecycle, "lifecycle");
        if (this.b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new f() { // from class: xj2
            @Override // androidx.lifecycle.f
            public final void c(db1 db1Var, Lifecycle.Event event) {
                a.d(this.a, db1Var, event);
            }
        });
        this.b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.d = true;
    }

    public final void g(Bundle bundle) {
        p31.f(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        lj2.d dVarC = this.a.c();
        p31.e(dVarC, "this.components.iteratorWithAdditions()");
        while (dVarC.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarC.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, c cVar) {
        p31.f(str, "key");
        p31.f(cVar, "provider");
        if (((c) this.a.f(str, cVar)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class cls) {
        p31.f(cls, "clazz");
        if (!this.f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.b bVar = this.e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.e = bVar;
        try {
            cls.getDeclaredConstructor(null);
            Recreator.b bVar2 = this.e;
            if (bVar2 != null) {
                String name = cls.getName();
                p31.e(name, "clazz.name");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
