package kotlin.sequences;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.x30;
import defpackage.yq0;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", l = {69, 71}, m = "invokeSuspend")
final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ yq0 $defaultValue;
    final /* synthetic */ rm2 $this_ifEmpty;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$ifEmpty$1(rm2 rm2Var, yq0 yq0Var, x30 x30Var) {
        super(2, x30Var);
        this.$this_ifEmpty = rm2Var;
        this.$defaultValue = yq0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, x30Var);
        sequencesKt__SequencesKt$ifEmpty$1.L$0 = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            kotlin.d.b(obj);
            sm2 sm2Var = (sm2) this.L$0;
            Iterator it = this.$this_ifEmpty.iterator();
            if (it.hasNext()) {
                this.label = 1;
                if (sm2Var.c(it, this) == objD) {
                    return objD;
                }
            } else {
                rm2 rm2Var = (rm2) this.$defaultValue.invoke();
                this.label = 2;
                if (sm2Var.b(rm2Var, this) == objD) {
                    return objD;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.d.b(obj);
        }
        return k83.a;
    }
}
