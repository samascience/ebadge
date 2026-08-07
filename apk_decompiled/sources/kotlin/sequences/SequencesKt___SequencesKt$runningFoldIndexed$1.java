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
@h70(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", l = {2339, 2344}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ Object $initial;
    final /* synthetic */ pr0 $operation;
    final /* synthetic */ rm2 $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFoldIndexed$1(Object obj, rm2 rm2Var, pr0 pr0Var, x30 x30Var) {
        super(2, x30Var);
        this.$initial = obj;
        this.$this_runningFoldIndexed = rm2Var;
        this.$operation = pr0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, x30Var);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0055  */
    /* JADX WARN: Code duplicated, block: B:18:0x005f  */
    /* JADX WARN: Code duplicated, block: B:22:0x007b A[LOOP:0: B:14:0x004f->B:22:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x007a A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        sm2 sm2Var;
        Object obj2;
        Iterator it;
        int i;
        sm2 sm2Var2;
        int i2;
        Object objInvoke;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                sm2Var = (sm2) this.L$0;
                kotlin.d.b(obj);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = this.I$0;
                it = (Iterator) this.L$2;
                Object obj3 = this.L$1;
                sm2Var2 = (sm2) this.L$0;
                kotlin.d.b(obj);
                obj2 = obj3;
                i = i4;
            }
            while (it.hasNext()) {
                Object next = it.next();
                pr0 pr0Var = this.$operation;
                i2 = i + 1;
                if (i < 0) {
                    kotlin.collections.j.s();
                }
                objInvoke = pr0Var.invoke(jn.b(i), obj2, next);
                this.L$0 = sm2Var2;
                this.L$1 = objInvoke;
                this.L$2 = it;
                this.I$0 = i2;
                this.label = 2;
                if (sm2Var2.a(objInvoke, this) == objD) {
                    return objD;
                }
                obj2 = objInvoke;
                i = i2;
            }
            return k83.a;
        }
        kotlin.d.b(obj);
        sm2Var = (sm2) this.L$0;
        Object obj4 = this.$initial;
        this.L$0 = sm2Var;
        this.label = 1;
        if (sm2Var.a(obj4, this) == objD) {
            return objD;
        }
        obj2 = this.$initial;
        it = this.$this_runningFoldIndexed.iterator();
        i = 0;
        sm2Var2 = sm2Var;
        while (it.hasNext()) {
            Object next2 = it.next();
            pr0 pr0Var2 = this.$operation;
            i2 = i + 1;
            if (i < 0) {
                kotlin.collections.j.s();
            }
            objInvoke = pr0Var2.invoke(jn.b(i), obj2, next2);
            this.L$0 = sm2Var2;
            this.L$1 = objInvoke;
            this.L$2 = it;
            this.I$0 = i2;
            this.label = 2;
            if (sm2Var2.a(objInvoke, this) == objD) {
                return objD;
            }
            obj2 = objInvoke;
            i = i2;
        }
        return k83.a;
    }
}
