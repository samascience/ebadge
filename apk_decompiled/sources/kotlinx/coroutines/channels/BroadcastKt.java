package kotlinx.coroutines.channels;

import defpackage.ar0;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
public final class BroadcastKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.BroadcastKt$broadcast$2, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", l = {56, 57}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements or0 {
        final /* synthetic */ ReceiveChannel<E> $channel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(ReceiveChannel<? extends E> receiveChannel, x30 x30Var) {
            super(2, x30Var);
            this.$channel = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$channel, x30Var);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0048 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x0049  */
        /* JADX WARN: Code duplicated, block: B:18:0x0054  */
        /* JADX WARN: Code duplicated, block: B:20:0x0064 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0065  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0062 -> B:7:0x0019). Please report as a decompilation issue!!! */
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
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r6.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r6.L$0
                kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
                kotlin.d.b(r7)
            L19:
                r7 = r4
                goto L3c
            L1b:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L23:
                java.lang.Object r1 = r6.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r6.L$0
                kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
                kotlin.d.b(r7)
                goto L4c
            L2f:
                kotlin.d.b(r7)
                java.lang.Object r7 = r6.L$0
                kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
                kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r6.$channel
                kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            L3c:
                r6.L$0 = r7
                r6.L$1 = r1
                r6.label = r3
                java.lang.Object r4 = r1.hasNext(r6)
                if (r4 != r0) goto L49
                return r0
            L49:
                r5 = r4
                r4 = r7
                r7 = r5
            L4c:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L65
                java.lang.Object r7 = r1.next()
                r6.L$0 = r4
                r6.L$1 = r1
                r6.label = r2
                java.lang.Object r7 = r4.send(r7, r6)
                if (r7 != r0) goto L19
                return r0
            L65:
                k83 r7 = defpackage.k83.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // defpackage.or0
        public final Object invoke(ProducerScope<? super E> producerScope, x30 x30Var) {
            return ((AnonymousClass2) create(producerScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> broadcast(final ReceiveChannel<? extends E> receiveChannel, int i, CoroutineStart coroutineStart) {
        return broadcast$default(CoroutineScopeKt.plus(CoroutineScopeKt.plus(GlobalScope.INSTANCE, Dispatchers.getUnconfined()), new BroadcastKt$broadcast$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)), null, i, coroutineStart, new ar0() { // from class: kotlinx.coroutines.channels.BroadcastKt.broadcast.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // defpackage.ar0
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return k83.a;
            }

            public final void invoke(Throwable th) {
                ChannelsKt.cancelConsumed(receiveChannel, th);
            }
        }, new AnonymousClass2(receiveChannel, null), 1, null);
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(ReceiveChannel receiveChannel, int i, CoroutineStart coroutineStart, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return broadcast(receiveChannel, i, coroutineStart);
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(CoroutineScope coroutineScope, d dVar, int i, CoroutineStart coroutineStart, ar0 ar0Var, or0 or0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        d dVar2 = dVar;
        if ((i2 & 2) != 0) {
            i = 1;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            ar0Var = null;
        }
        return broadcast(coroutineScope, dVar2, i3, coroutineStart2, ar0Var, or0Var);
    }

    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> broadcast(CoroutineScope coroutineScope, d dVar, int i, CoroutineStart coroutineStart, ar0 ar0Var, or0 or0Var) {
        BroadcastCoroutine broadcastCoroutine;
        d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, dVar);
        BroadcastChannel BroadcastChannel = BroadcastChannelKt.BroadcastChannel(i);
        if (coroutineStart.isLazy()) {
            broadcastCoroutine = new LazyBroadcastCoroutine(dVarNewCoroutineContext, BroadcastChannel, or0Var);
        } else {
            broadcastCoroutine = new BroadcastCoroutine(dVarNewCoroutineContext, BroadcastChannel, true);
        }
        if (ar0Var != null) {
            ((JobSupport) broadcastCoroutine).invokeOnCompletion(ar0Var);
        }
        ((AbstractCoroutine) broadcastCoroutine).start(coroutineStart, broadcastCoroutine, or0Var);
        return (BroadcastChannel<E>) broadcastCoroutine;
    }
}
