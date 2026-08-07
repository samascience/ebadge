package androidx.fragment.app;

import defpackage.p31;
import defpackage.yq0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewModelLazyKt$activityViewModels$1 extends Lambda implements yq0 {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    @Override // defpackage.yq0
    public final androidx.lifecycle.r invoke() {
        FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
        p31.b(fragmentActivityRequireActivity, "requireActivity()");
        androidx.lifecycle.r viewModelStore = fragmentActivityRequireActivity.getViewModelStore();
        p31.b(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
