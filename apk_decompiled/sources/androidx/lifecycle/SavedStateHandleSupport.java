package androidx.lifecycle;

import android.os.Bundle;
import defpackage.ar0;
import defpackage.i21;
import defpackage.ke2;
import defpackage.ne3;
import defpackage.p31;
import defpackage.v40;
import defpackage.wj2;
import defpackage.zj2;

/* JADX INFO: loaded from: classes.dex */
public abstract class SavedStateHandleSupport {
    public static final v40.b a = new b();
    public static final v40.b b = new c();
    public static final v40.b c = new a();

    public static final class a implements v40.b {
        a() {
        }
    }

    public static final class b implements v40.b {
        b() {
        }
    }

    public static final class c implements v40.b {
        c() {
        }
    }

    public static final l a(v40 v40Var) {
        p31.f(v40Var, "<this>");
        zj2 zj2Var = (zj2) v40Var.a(a);
        if (zj2Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        ne3 ne3Var = (ne3) v40Var.a(b);
        if (ne3Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) v40Var.a(c);
        String str = (String) v40Var.a(q.c.d);
        if (str != null) {
            return b(zj2Var, ne3Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    private static final l b(zj2 zj2Var, ne3 ne3Var, String str, Bundle bundle) {
        SavedStateHandlesProvider savedStateHandlesProviderD = d(zj2Var);
        wj2 wj2VarE = e(ne3Var);
        l lVar = (l) wj2VarE.f().get(str);
        if (lVar != null) {
            return lVar;
        }
        l lVarA = l.f.a(savedStateHandlesProviderD.b(str), bundle);
        wj2VarE.f().put(str, lVarA);
        return lVarA;
    }

    public static final void c(zj2 zj2Var) {
        p31.f(zj2Var, "<this>");
        Lifecycle.State stateB = zj2Var.getLifecycle().b();
        if (stateB != Lifecycle.State.INITIALIZED && stateB != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (zj2Var.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(zj2Var.getSavedStateRegistry(), (ne3) zj2Var);
            zj2Var.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            zj2Var.getLifecycle().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(zj2 zj2Var) {
        p31.f(zj2Var, "<this>");
        androidx.savedstate.a.c cVarC = zj2Var.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = cVarC instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) cVarC : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final wj2 e(ne3 ne3Var) {
        p31.f(ne3Var, "<this>");
        i21 i21Var = new i21();
        i21Var.a(ke2.b(wj2.class), new ar0() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // defpackage.ar0
            public final wj2 invoke(v40 v40Var) {
                p31.f(v40Var, "$this$initializer");
                return new wj2();
            }
        });
        return (wj2) new q(ne3Var, i21Var.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", wj2.class);
    }
}
