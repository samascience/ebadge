package androidx.lifecycle;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.sz1;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {203}, m = "invokeSuspend")
final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements or0 {
    final /* synthetic */ or0 $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, or0 or0Var, x30 x30Var) {
        super(2, x30Var);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = or0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, x30Var);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        d dVar;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (d) this.L$0;
            try {
                kotlin.d.b(obj);
                dVar.b();
                return obj;
            } catch (Throwable th) {
                th = th;
                dVar.b();
                throw th;
            }
        }
        kotlin.d.b(obj);
        Job job = (Job) ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key);
        if (job == null) {
            throw new IllegalStateException("when[State] methods should have a parent job");
        }
        sz1 sz1Var = new sz1();
        d dVar2 = new d(this.$this_whenStateAtLeast, this.$minState, sz1Var.a, job);
        try {
            or0 or0Var = this.$block;
            this.L$0 = dVar2;
            this.label = 1;
            obj = BuildersKt.withContext(sz1Var, or0Var, this);
            if (obj == objD) {
                return objD;
            }
            dVar = dVar2;
            dVar.b();
            return obj;
        } catch (Throwable th2) {
            th = th2;
            dVar = dVar2;
            dVar.b();
            throw th;
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
