package androidx.lifecycle;

import android.os.Bundle;
import com.tencent.open.SocialConstants;
import defpackage.db1;
import defpackage.ne3;
import defpackage.p31;
import defpackage.zj2;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class LegacySavedStateHandleController {
    public static final LegacySavedStateHandleController a = new LegacySavedStateHandleController();

    public static final class a implements androidx.savedstate.a.InterfaceC0038a {
        @Override // androidx.savedstate.a.InterfaceC0038a
        public void a(zj2 zj2Var) {
            p31.f(zj2Var, "owner");
            if (!(zj2Var instanceof ne3)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            r viewModelStore = ((ne3) zj2Var).getViewModelStore();
            androidx.savedstate.a savedStateRegistry = zj2Var.getSavedStateRegistry();
            Iterator it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                o oVarB = viewModelStore.b((String) it.next());
                p31.c(oVarB);
                LegacySavedStateHandleController.a(oVarB, savedStateRegistry, zj2Var.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    private LegacySavedStateHandleController() {
    }

    public static final void a(o oVar, androidx.savedstate.a aVar, Lifecycle lifecycle) {
        p31.f(oVar, "viewModel");
        p31.f(aVar, "registry");
        p31.f(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) oVar.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.e()) {
            return;
        }
        savedStateHandleController.a(aVar, lifecycle);
        a.c(aVar, lifecycle);
    }

    public static final SavedStateHandleController b(androidx.savedstate.a aVar, Lifecycle lifecycle, String str, Bundle bundle) {
        p31.f(aVar, "registry");
        p31.f(lifecycle, "lifecycle");
        p31.c(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, l.f.a(aVar.b(str), bundle));
        savedStateHandleController.a(aVar, lifecycle);
        a.c(aVar, lifecycle);
        return savedStateHandleController;
    }

    private final void c(final androidx.savedstate.a aVar, final Lifecycle lifecycle) {
        Lifecycle.State stateB = lifecycle.b();
        if (stateB == Lifecycle.State.INITIALIZED || stateB.isAtLeast(Lifecycle.State.STARTED)) {
            aVar.i(a.class);
        } else {
            lifecycle.a(new f() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.f
                public void c(db1 db1Var, Lifecycle.Event event) {
                    p31.f(db1Var, SocialConstants.PARAM_SOURCE);
                    p31.f(event, "event");
                    if (event == Lifecycle.Event.ON_START) {
                        lifecycle.d(this);
                        aVar.i(LegacySavedStateHandleController.a.class);
                    }
                }
            });
        }
    }
}
