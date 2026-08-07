package androidx.activity;

import defpackage.k83;
import defpackage.yq0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class OnBackPressedDispatcher$addCancellableCallback$1 extends FunctionReferenceImpl implements yq0 {
    OnBackPressedDispatcher$addCancellableCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    @Override // defpackage.yq0
    public /* bridge */ /* synthetic */ Object invoke() {
        m5invoke();
        return k83.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m5invoke() {
        ((OnBackPressedDispatcher) this.receiver).p();
    }
}
