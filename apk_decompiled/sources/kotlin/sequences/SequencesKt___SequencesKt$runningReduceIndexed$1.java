package kotlin.sequences;

import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.x30;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", l = {2397, 2401}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ pr0 $operation;
    final /* synthetic */ rm2 $this_runningReduceIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduceIndexed$1(rm2 rm2Var, pr0 pr0Var, x30 x30Var) {
        super(2, x30Var);
        this.$this_runningReduceIndexed = rm2Var;
        this.$operation = pr0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, x30Var);
        sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        sm2 sm2Var;
        Iterator it;
        Object next;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            kotlin.d.b(obj);
            sm2Var = (sm2) this.L$0;
            it = this.$this_runningReduceIndexed.iterator();
            if (it.hasNext()) {
                next = it.next();
                this.L$0 = sm2Var;
                this.L$1 = it;
                this.L$2 = next;
                this.label = 1;
                if (sm2Var.a(next, this) == objD) {
                    return objD;
                }
            }
            return k83.a;
        }
        if (i == 1) {
            next = this.L$2;
            it = (Iterator) this.L$1;
            sm2Var = (sm2) this.L$0;
            kotlin.d.b(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = this.I$0;
            Object obj2 = this.L$2;
            it = (Iterator) this.L$1;
            sm2Var = (sm2) this.L$0;
            kotlin.d.b(obj);
            i2 = i3;
            next = obj2;
        }
        while (it.hasNext()) {
            pr0 pr0Var = this.$operation;
            int i4 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.j.s();
            }
            Object objInvoke = pr0Var.invoke(jn.b(i2), next, it.next());
            this.L$0 = sm2Var;
            this.L$1 = it;
            this.L$2 = objInvoke;
            this.I$0 = i4;
            this.label = 2;
            if (sm2Var.a(objInvoke, this) == objD) {
                return objD;
            }
            next = objInvoke;
            i2 = i4;
        }
        return k83.a;
    }
}
