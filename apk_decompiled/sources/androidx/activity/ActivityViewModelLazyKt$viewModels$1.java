package androidx.activity;

import androidx.lifecycle.r;
import defpackage.yq0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityViewModelLazyKt$viewModels$1 extends Lambda implements yq0 {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    @Override // defpackage.yq0
    public final r invoke() {
        return this.$this_viewModels.getViewModelStore();
    }
}
