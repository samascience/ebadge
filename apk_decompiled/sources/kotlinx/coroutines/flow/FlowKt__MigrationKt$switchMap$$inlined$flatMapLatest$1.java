package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", f = "Migration.kt", l = {193, 193}, m = "invokeSuspend")
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 extends SuspendLambda implements pr0 {
    final /* synthetic */ or0 $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(or0 or0Var, x30 x30Var) {
        super(3, x30Var);
        this.$transform = or0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        FlowCollector flowCollector;
        Object objD = a.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                flowCollector = (FlowCollector) this.L$0;
                d.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return k83.a;
        }
        d.b(obj);
        flowCollector = (FlowCollector) this.L$0;
        Object obj2 = this.L$1;
        or0 or0Var = this.$transform;
        this.L$0 = flowCollector;
        this.label = 1;
        obj = or0Var.invoke(obj2, this);
        if (obj == objD) {
            return objD;
        }
        this.L$0 = null;
        this.label = 2;
        if (FlowKt.emitAll(flowCollector, (Flow) obj, this) == objD) {
            return objD;
        }
        return k83.a;
    }

    @Override // defpackage.pr0
    public final Object invoke(FlowCollector<? super R> flowCollector, T t, x30 x30Var) {
        FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 = new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(this.$transform, x30Var);
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.L$0 = flowCollector;
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.L$1 = t;
        return flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.invokeSuspend(k83.a);
    }
}
