package kotlin.sequences;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", l = {2311, 2315}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningFold$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ Object $initial;
    final /* synthetic */ or0 $operation;
    final /* synthetic */ rm2 $this_runningFold;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFold$1(Object obj, rm2 rm2Var, or0 or0Var, x30 x30Var) {
        super(2, x30Var);
        this.$initial = obj;
        this.$this_runningFold = rm2Var;
        this.$operation = or0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(this.$initial, this.$this_runningFold, this.$operation, x30Var);
        sequencesKt___SequencesKt$runningFold$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((SequencesKt___SequencesKt$runningFold$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:19:0x006a A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0068 -> B:7:0x001b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r6.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r6.L$1
            java.lang.Object r4 = r6.L$0
            sm2 r4 = (defpackage.sm2) r4
            kotlin.d.b(r7)
        L1b:
            r7 = r3
            goto L4c
        L1d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L25:
            java.lang.Object r1 = r6.L$0
            sm2 r1 = (defpackage.sm2) r1
            kotlin.d.b(r7)
            goto L42
        L2d:
            kotlin.d.b(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            sm2 r1 = (defpackage.sm2) r1
            java.lang.Object r7 = r6.$initial
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r1.a(r7, r6)
            if (r7 != r0) goto L42
            return r0
        L42:
            java.lang.Object r7 = r6.$initial
            rm2 r3 = r6.$this_runningFold
            java.util.Iterator r3 = r3.iterator()
            r4 = r1
            r1 = r3
        L4c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L6b
            java.lang.Object r3 = r1.next()
            or0 r5 = r6.$operation
            java.lang.Object r3 = r5.invoke(r7, r3)
            r6.L$0 = r4
            r6.L$1 = r3
            r6.L$2 = r1
            r6.label = r2
            java.lang.Object r7 = r4.a(r3, r6)
            if (r7 != r0) goto L1b
            return r0
        L6b:
            k83 r7 = defpackage.k83.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFold$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
