package androidx.fragment.app;

import defpackage.ne3;
import defpackage.p31;
import defpackage.yq0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewModelLazyKt$viewModels$2 extends Lambda implements yq0 {
    final /* synthetic */ yq0 $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$2(yq0 yq0Var) {
        super(0);
        this.$ownerProducer = yq0Var;
    }

    @Override // defpackage.yq0
    public final androidx.lifecycle.r invoke() {
        androidx.lifecycle.r viewModelStore = ((ne3) this.$ownerProducer.invoke()).getViewModelStore();
        p31.b(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
