package androidx.activity;

import defpackage.v40;
import defpackage.yq0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityViewModelLazyKt$viewModels$4 extends Lambda implements yq0 {
    final /* synthetic */ yq0 $extrasProducer;
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$4(yq0 yq0Var, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = yq0Var;
        this.$this_viewModels = componentActivity;
    }

    @Override // defpackage.yq0
    public final v40 invoke() {
        v40 v40Var;
        yq0 yq0Var = this.$extrasProducer;
        return (yq0Var == null || (v40Var = (v40) yq0Var.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : v40Var;
    }
}
