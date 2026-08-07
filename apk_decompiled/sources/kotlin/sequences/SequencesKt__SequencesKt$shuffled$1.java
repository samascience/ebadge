package kotlin.sequences;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.x30;
import java.util.List;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.random.Random;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", l = {Opcodes.I2B}, m = "invokeSuspend")
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ Random $random;
    final /* synthetic */ rm2 $this_shuffled;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$shuffled$1(rm2 rm2Var, Random random, x30 x30Var) {
        super(2, x30Var);
        this.$this_shuffled = rm2Var;
        this.$random = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, x30Var);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List listA;
        sm2 sm2Var;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            kotlin.d.b(obj);
            sm2 sm2Var2 = (sm2) this.L$0;
            listA = k.A(this.$this_shuffled);
            sm2Var = sm2Var2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            listA = (List) this.L$1;
            sm2Var = (sm2) this.L$0;
            kotlin.d.b(obj);
        }
        while (!listA.isEmpty()) {
            int iNextInt = this.$random.nextInt(listA.size());
            Object objZ = kotlin.collections.j.z(listA);
            if (iNextInt < listA.size()) {
                objZ = listA.set(iNextInt, objZ);
            }
            this.L$0 = sm2Var;
            this.L$1 = listA;
            this.label = 1;
            if (sm2Var.a(objZ, this) == objD) {
                return objD;
            }
        }
        return k83.a;
    }
}
