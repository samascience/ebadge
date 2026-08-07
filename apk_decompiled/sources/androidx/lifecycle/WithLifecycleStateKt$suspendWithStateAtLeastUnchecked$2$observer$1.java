package androidx.lifecycle;

import com.tencent.open.SocialConstants;
import defpackage.db1;
import defpackage.p31;
import defpackage.yq0;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements f {
    final /* synthetic */ Lifecycle.State a;
    final /* synthetic */ Lifecycle b;
    final /* synthetic */ CancellableContinuation c;
    final /* synthetic */ yq0 d;

    @Override // androidx.lifecycle.f
    public void c(db1 db1Var, Lifecycle.Event event) {
        Object objM69constructorimpl;
        p31.f(db1Var, SocialConstants.PARAM_SOURCE);
        p31.f(event, "event");
        if (event != Lifecycle.Event.Companion.d(this.a)) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.b.d(this);
                CancellableContinuation cancellableContinuation = this.c;
                Result.a aVar = Result.Companion;
                cancellableContinuation.resumeWith(Result.m69constructorimpl(kotlin.d.a(new LifecycleDestroyedException())));
                return;
            }
            return;
        }
        this.b.d(this);
        CancellableContinuation cancellableContinuation2 = this.c;
        yq0 yq0Var = this.d;
        try {
            Result.a aVar2 = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(yq0Var.invoke());
        } catch (Throwable th) {
            Result.a aVar3 = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(kotlin.d.a(th));
        }
        cancellableContinuation2.resumeWith(objM69constructorimpl);
    }
}
