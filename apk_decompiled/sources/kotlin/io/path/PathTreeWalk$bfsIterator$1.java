package kotlin.io.path;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.qz1;
import defpackage.sm2;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", l = {Opcodes.ATHROW, Opcodes.MULTIANEWARRAY}, m = "invokeSuspend")
final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements or0 {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ qz1 this$0;

    PathTreeWalk$bfsIterator$1(qz1 qz1Var, x30 x30Var) {
        super(2, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1(null, x30Var);
        pathTreeWalk$bfsIterator$1.L$0 = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((PathTreeWalk$bfsIterator$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x007c  */
    /* JADX WARN: Code duplicated, block: B:15:0x008c  */
    /* JADX WARN: Code duplicated, block: B:20:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:22:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:24:0x00c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d2 A[PHI: r1 r5 r6 r7 r12
      0x00d2: PHI (r1v3 kotlin.io.path.b) = (r1v5 kotlin.io.path.b), (r1v6 kotlin.io.path.b) binds: [B:26:0x00cd, B:21:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00d2: PHI (r5v2 kotlin.collections.c) = (r5v4 kotlin.collections.c), (r5v5 kotlin.collections.c) binds: [B:26:0x00cd, B:21:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00d2: PHI (r6v3 sm2) = (r6v5 sm2), (r6v6 sm2) binds: [B:26:0x00cd, B:21:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00d2: PHI (r7v1 java.nio.file.Path) = (r7v4 java.nio.file.Path), (r7v5 java.nio.file.Path) binds: [B:26:0x00cd, B:21:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00d2: PHI (r12v3 kotlin.io.path.c) = (r12v5 kotlin.io.path.c), (r12v9 kotlin.io.path.c) binds: [B:26:0x00cd, B:21:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:30:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:32:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:39:0x010e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00e8 -> B:11:0x0076). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00ea -> B:11:0x0076). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:32:0x00fc
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$bfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
