package androidx.lifecycle;

import com.tencent.open.SocialConstants;
import defpackage.db1;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements f {
    private final SavedStateHandlesProvider a;

    public SavedStateHandleAttacher(SavedStateHandlesProvider savedStateHandlesProvider) {
        p31.f(savedStateHandlesProvider, "provider");
        this.a = savedStateHandlesProvider;
    }

    @Override // androidx.lifecycle.f
    public void c(db1 db1Var, Lifecycle.Event event) {
        p31.f(db1Var, SocialConstants.PARAM_SOURCE);
        p31.f(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            db1Var.getLifecycle().d(this);
            this.a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
