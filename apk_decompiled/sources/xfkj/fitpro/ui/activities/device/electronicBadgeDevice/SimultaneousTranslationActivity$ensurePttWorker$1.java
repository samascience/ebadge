package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$ensurePttWorker$1", f = "SimultaneousTranslationActivity.kt", l = {997, 1000, 1001}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$ensurePttWorker$1 extends SuspendLambda implements or0 {
    Object L$0;
    int label;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$ensurePttWorker$1(SimultaneousTranslationActivity simultaneousTranslationActivity, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslationActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslationActivity$ensurePttWorker$1(this.this$0, x30Var);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:28:0x0062 A[Catch: Exception -> 0x001a, CancellationException -> 0x001d, TryCatch #2 {CancellationException -> 0x001d, Exception -> 0x001a, blocks: (B:8:0x0015, B:26:0x005e, B:28:0x0062, B:31:0x006f, B:33:0x0073, B:36:0x008d, B:37:0x0092), top: B:43:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x006e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x006f A[Catch: Exception -> 0x001a, CancellationException -> 0x001d, TryCatch #2 {CancellationException -> 0x001d, Exception -> 0x001a, blocks: (B:8:0x0015, B:26:0x005e, B:28:0x0062, B:31:0x006f, B:33:0x0073, B:36:0x008d, B:37:0x0092), top: B:43:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0073 A[Catch: Exception -> 0x001a, CancellationException -> 0x001d, TryCatch #2 {CancellationException -> 0x001d, Exception -> 0x001a, blocks: (B:8:0x0015, B:26:0x005e, B:28:0x0062, B:31:0x006f, B:33:0x0073, B:36:0x008d, B:37:0x0092), top: B:43:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x008c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x008d A[Catch: Exception -> 0x001a, CancellationException -> 0x001d, TryCatch #2 {CancellationException -> 0x001d, Exception -> 0x001a, blocks: (B:8:0x0015, B:26:0x005e, B:28:0x0062, B:31:0x006f, B:33:0x0073, B:36:0x008d, B:37:0x0092), top: B:43:0x0015 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x006c -> B:39:0x00b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008a -> B:39:0x00b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0093 -> B:39:0x00b5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L35
            if (r1 == r4) goto L2d
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
        L15:
            kotlin.d.b(r10)     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            goto Lb5
        L1a:
            r10 = move-exception
            goto L93
        L1d:
            r10 = move-exception
            goto Lb7
        L20:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L28:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            goto L15
        L2d:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            kotlin.d.b(r10)
            goto L50
        L35:
            kotlin.d.b(r10)
            xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity r10 = r9.this$0
            kotlinx.coroutines.channels.Channel r10 = xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity.V0(r10)
            kotlinx.coroutines.channels.ChannelIterator r10 = r10.iterator()
        L42:
            r9.L$0 = r10
            r9.label = r4
            java.lang.Object r1 = r10.hasNext(r9)
            if (r1 != r0) goto L4d
            return r0
        L4d:
            r8 = r1
            r1 = r10
            r10 = r8
        L50:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lb8
            java.lang.Object r10 = r1.next()
            xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$c r10 = (xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity.c) r10
            boolean r5 = r10 instanceof xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity.c.a     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            if (r5 == 0) goto L6f
            xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity r10 = r9.this$0     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            r9.L$0 = r1     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            r9.label = r3     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            java.lang.Object r10 = xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity.b1(r10, r9)     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            if (r10 != r0) goto Lb5
            return r0
        L6f:
            boolean r5 = r10 instanceof xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity.c.b     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            if (r5 == 0) goto L8d
            xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity r5 = r9.this$0     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            r6 = r10
            xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$c$b r6 = (xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity.c.b) r6     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            boolean r6 = r6.a()     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$c$b r10 = (xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity.c.b) r10     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            yq0 r10 = r10.b()     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            r9.L$0 = r1     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            r9.label = r2     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            java.lang.Object r10 = xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity.c1(r5, r6, r10, r9)     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            if (r10 != r0) goto Lb5
            return r0
        L8d:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            r10.<init>()     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
            throw r10     // Catch: java.lang.Exception -> L1a java.util.concurrent.CancellationException -> L1d
        L93:
            xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity r5 = r9.this$0
            java.lang.String r5 = xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity.Y0(r5)
            java.lang.String r10 = r10.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "PTT worker 处理指令失败: "
            r6.append(r7)
            r6.append(r10)
            java.lang.String r10 = r6.toString()
            int r10 = android.util.Log.e(r5, r10)
            defpackage.jn.b(r10)
        Lb5:
            r10 = r1
            goto L42
        Lb7:
            throw r10
        Lb8:
            k83 r10 = defpackage.k83.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$ensurePttWorker$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$ensurePttWorker$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
