package androidx.lifecycle;

import com.tencent.open.SocialConstants;
import defpackage.db1;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements f {
    private final String a;
    private final l b;
    private boolean c;

    public SavedStateHandleController(String str, l lVar) {
        p31.f(str, "key");
        p31.f(lVar, "handle");
        this.a = str;
        this.b = lVar;
    }

    public final void a(androidx.savedstate.a aVar, Lifecycle lifecycle) {
        p31.f(aVar, "registry");
        p31.f(lifecycle, "lifecycle");
        if (this.c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.c = true;
        lifecycle.a(this);
        aVar.h(this.a, this.b.c());
    }

    public final l b() {
        return this.b;
    }

    @Override // androidx.lifecycle.f
    public void c(db1 db1Var, Lifecycle.Event event) {
        p31.f(db1Var, SocialConstants.PARAM_SOURCE);
        p31.f(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.c = false;
            db1Var.getLifecycle().d(this);
        }
    }

    public final boolean e() {
        return this.c;
    }
}
