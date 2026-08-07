package androidx.fragment.app;

import defpackage.p31;
import defpackage.yq0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1 extends Lambda implements yq0 {
    final /* synthetic */ Fragment $this_createViewModelLazy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(Fragment fragment) {
        super(0);
        this.$this_createViewModelLazy = fragment;
    }

    @Override // defpackage.yq0
    public final androidx.lifecycle.q.b invoke() {
        androidx.lifecycle.q.b defaultViewModelProviderFactory = this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
        p31.b(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
