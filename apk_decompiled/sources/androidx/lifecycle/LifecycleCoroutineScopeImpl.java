package androidx.lifecycle;

import com.tencent.open.SocialConstants;
import defpackage.db1;
import defpackage.p31;
import defpackage.ya1;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends ya1 implements f {
    private final Lifecycle a;
    private final kotlin.coroutines.d b;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, kotlin.coroutines.d dVar) {
        p31.f(lifecycle, "lifecycle");
        p31.f(dVar, "coroutineContext");
        this.a = lifecycle;
        this.b = dVar;
        if (a().b() == Lifecycle.State.DESTROYED) {
            JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // defpackage.ya1
    public Lifecycle a() {
        return this.a;
    }

    public final void b() {
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain().getImmediate(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }

    @Override // androidx.lifecycle.f
    public void c(db1 db1Var, Lifecycle.Event event) {
        p31.f(db1Var, SocialConstants.PARAM_SOURCE);
        p31.f(event, "event");
        if (a().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            a().d(this);
            JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public kotlin.coroutines.d getCoroutineContext() {
        return this.b;
    }
}
