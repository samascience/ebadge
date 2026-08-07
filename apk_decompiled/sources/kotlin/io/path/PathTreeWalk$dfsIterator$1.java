package kotlin.io.path;

import com.jieli.jl_rcsp.constant.Command;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.qz1;
import defpackage.sm2;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", l = {Opcodes.ATHROW, Opcodes.MULTIANEWARRAY, Command.CMD_RECEIVE_SPEECH_CANCEL, Command.CMD_SET_DEVICE_STORAGE}, m = "invokeSuspend")
final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements or0 {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ qz1 this$0;

    PathTreeWalk$dfsIterator$1(qz1 qz1Var, x30 x30Var) {
        super(2, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(null, x30Var);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((PathTreeWalk$dfsIterator$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0141  */
    /* JADX WARN: Code duplicated, block: B:45:0x0164  */
    /* JADX WARN: Code duplicated, block: B:50:0x0185  */
    /* JADX WARN: Code duplicated, block: B:52:0x018b  */
    /* JADX WARN: Code duplicated, block: B:54:0x019f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:57:0x01aa A[PHI: r1 r4 r7 r8 r14
      0x01aa: PHI (r1v9 kotlin.io.path.b) = (r1v7 kotlin.io.path.b), (r1v11 kotlin.io.path.b) binds: [B:51:0x0189, B:56:0x01a5] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r4v18 kotlin.collections.c) = (r4v16 kotlin.collections.c), (r4v20 kotlin.collections.c) binds: [B:51:0x0189, B:56:0x01a5] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r7v9 sm2) = (r7v7 sm2), (r7v11 sm2) binds: [B:51:0x0189, B:56:0x01a5] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r8v14 java.nio.file.Path) = (r8v12 java.nio.file.Path), (r8v19 java.nio.file.Path) binds: [B:51:0x0189, B:56:0x01a5] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r14v21 kotlin.io.path.c) = (r14v13 kotlin.io.path.c), (r14v22 kotlin.io.path.c) binds: [B:51:0x0189, B:56:0x01a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:59:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:60:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:73:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x01c0 -> B:39:0x013b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01c2 -> B:39:0x013b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$dfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
