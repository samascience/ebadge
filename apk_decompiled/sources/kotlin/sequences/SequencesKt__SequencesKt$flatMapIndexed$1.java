package kotlin.sequences;

import defpackage.ar0;
import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.x30;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", l = {350}, m = "invokeSuspend")
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ ar0 $iterator;
    final /* synthetic */ rm2 $source;
    final /* synthetic */ or0 $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$flatMapIndexed$1(rm2 rm2Var, or0 or0Var, ar0 ar0Var, x30 x30Var) {
        super(2, x30Var);
        this.$source = rm2Var;
        this.$transform = or0Var;
        this.$iterator = ar0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, x30Var);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        sm2 sm2Var;
        int i;
        Iterator it;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.d.b(obj);
            sm2Var = (sm2) this.L$0;
            i = 0;
            it = this.$source.iterator();
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = this.I$0;
            it = (Iterator) this.L$1;
            sm2Var = (sm2) this.L$0;
            kotlin.d.b(obj);
            i = i3;
        }
        while (it.hasNext()) {
            Object next = it.next();
            or0 or0Var = this.$transform;
            int i4 = i + 1;
            if (i < 0) {
                kotlin.collections.j.s();
            }
            Iterator it2 = (Iterator) this.$iterator.invoke(or0Var.invoke(jn.b(i), next));
            this.L$0 = sm2Var;
            this.L$1 = it;
            this.I$0 = i4;
            this.label = 1;
            if (sm2Var.c(it2, this) == objD) {
                return objD;
            }
            i = i4;
        }
        return k83.a;
    }
}
