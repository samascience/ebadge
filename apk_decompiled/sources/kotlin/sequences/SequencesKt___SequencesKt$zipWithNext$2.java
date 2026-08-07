package kotlin.sequences;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", l = {2873}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ rm2 $this_zipWithNext;
    final /* synthetic */ or0 $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$zipWithNext$2(rm2 rm2Var, or0 or0Var, x30 x30Var) {
        super(2, x30Var);
        this.$this_zipWithNext = rm2Var;
        this.$transform = or0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, x30Var);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x005d A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005b -> B:6:0x0018). Please report as a decompilation issue!!! */
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
            r2 = 1
            if (r1 == 0) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r1 = r6.L$2
            java.lang.Object r3 = r6.L$1
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r6.L$0
            sm2 r4 = (defpackage.sm2) r4
            kotlin.d.b(r7)
        L18:
            r7 = r1
            goto L3f
        L1a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L22:
            kotlin.d.b(r7)
            java.lang.Object r7 = r6.L$0
            sm2 r7 = (defpackage.sm2) r7
            rm2 r1 = r6.$this_zipWithNext
            java.util.Iterator r1 = r1.iterator()
            boolean r3 = r1.hasNext()
            if (r3 != 0) goto L38
            k83 r7 = defpackage.k83.a
            return r7
        L38:
            java.lang.Object r3 = r1.next()
            r4 = r7
            r7 = r3
            r3 = r1
        L3f:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L5e
            java.lang.Object r1 = r3.next()
            or0 r5 = r6.$transform
            java.lang.Object r7 = r5.invoke(r7, r1)
            r6.L$0 = r4
            r6.L$1 = r3
            r6.L$2 = r1
            r6.label = r2
            java.lang.Object r7 = r4.a(r7, r6)
            if (r7 != r0) goto L18
            return r0
        L5e:
            k83 r7 = defpackage.k83.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
