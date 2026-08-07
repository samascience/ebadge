package androidx.activity.contextaware;

import defpackage.ar0;
import defpackage.k83;
import defpackage.n30;
import defpackage.p30;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$1 extends Lambda implements ar0 {
    final /* synthetic */ p30 $listener;
    final /* synthetic */ n30 $this_withContextAvailable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextAwareKt$withContextAvailable$2$1(n30 n30Var, p30 p30Var) {
        super(1);
        this.$this_withContextAvailable = n30Var;
    }

    @Override // defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    public final void invoke(Throwable th) {
        this.$this_withContextAvailable.removeOnContextAvailableListener(null);
    }
}
