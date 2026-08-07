package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import defpackage.ak2;
import defpackage.c6;
import defpackage.p31;
import defpackage.v40;
import defpackage.zj2;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public final class m extends q.d implements q.b {
    private Application b;
    private final q.b c;
    private Bundle d;
    private Lifecycle e;
    private androidx.savedstate.a f;

    public m(Application application, zj2 zj2Var, Bundle bundle) {
        p31.f(zj2Var, "owner");
        this.f = zj2Var.getSavedStateRegistry();
        this.e = zj2Var.getLifecycle();
        this.d = bundle;
        this.b = application;
        this.c = application != null ? q.a.f.b(application) : new q.a();
    }

    @Override // androidx.lifecycle.q.b
    public o a(Class cls) {
        p31.f(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.q.b
    public o b(Class cls, v40 v40Var) {
        p31.f(cls, "modelClass");
        p31.f(v40Var, "extras");
        String str = (String) v40Var.a(q.c.d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (v40Var.a(SavedStateHandleSupport.a) == null || v40Var.a(SavedStateHandleSupport.b) == null) {
            if (this.e != null) {
                return d(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) v40Var.a(q.a.h);
        boolean zIsAssignableFrom = c6.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? ak2.c(cls, ak2.b) : ak2.c(cls, ak2.a);
        if (constructorC == null) {
            return this.c.b(cls, v40Var);
        }
        return (!zIsAssignableFrom || application == null) ? ak2.d(cls, constructorC, SavedStateHandleSupport.a(v40Var)) : ak2.d(cls, constructorC, application, SavedStateHandleSupport.a(v40Var));
    }

    @Override // androidx.lifecycle.q.d
    public void c(o oVar) {
        p31.f(oVar, "viewModel");
        if (this.e != null) {
            androidx.savedstate.a aVar = this.f;
            p31.c(aVar);
            Lifecycle lifecycle = this.e;
            p31.c(lifecycle);
            LegacySavedStateHandleController.a(oVar, aVar, lifecycle);
        }
    }

    public final o d(String str, Class cls) {
        o oVarD;
        Application application;
        p31.f(str, "key");
        p31.f(cls, "modelClass");
        Lifecycle lifecycle = this.e;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = c6.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || this.b == null) ? ak2.c(cls, ak2.b) : ak2.c(cls, ak2.a);
        if (constructorC == null) {
            return this.b != null ? this.c.a(cls) : q.c.b.a().a(cls);
        }
        androidx.savedstate.a aVar = this.f;
        p31.c(aVar);
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(aVar, lifecycle, str, this.d);
        if (!zIsAssignableFrom || (application = this.b) == null) {
            oVarD = ak2.d(cls, constructorC, savedStateHandleControllerB.b());
        } else {
            p31.c(application);
            oVarD = ak2.d(cls, constructorC, application, savedStateHandleControllerB.b());
        }
        oVarD.e("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return oVarD;
    }
}
