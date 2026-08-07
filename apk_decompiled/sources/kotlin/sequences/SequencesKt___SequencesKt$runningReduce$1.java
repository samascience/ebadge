package kotlin.sequences;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.x30;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", l = {2368, 2371}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ or0 $operation;
    final /* synthetic */ rm2 $this_runningReduce;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduce$1(rm2 rm2Var, or0 or0Var, x30 x30Var) {
        super(2, x30Var);
        this.$this_runningReduce = rm2Var;
        this.$operation = or0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, x30Var);
        sequencesKt___SequencesKt$runningReduce$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        sm2 sm2Var;
        Object next;
        Iterator it;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            kotlin.d.b(obj);
            sm2Var = (sm2) this.L$0;
            Iterator it2 = this.$this_runningReduce.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                this.L$0 = sm2Var;
                this.L$1 = it2;
                this.L$2 = next;
                this.label = 1;
                if (sm2Var.a(next, this) == objD) {
                    return objD;
                }
                it = it2;
            }
            return k83.a;
        }
        if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        next = this.L$2;
        it = (Iterator) this.L$1;
        sm2Var = (sm2) this.L$0;
        kotlin.d.b(obj);
        while (it.hasNext()) {
            next = this.$operation.invoke(next, it.next());
            this.L$0 = sm2Var;
            this.L$1 = it;
            this.L$2 = next;
            this.label = 2;
            if (sm2Var.a(next, this) == objD) {
                return objD;
            }
        }
        return k83.a;
    }
}
