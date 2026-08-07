package kotlinx.coroutines.channels;

import defpackage.ar0;
import defpackage.h70;
import defpackage.j70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.yq0;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class ProduceKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ProduceKt$awaitClose$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {153}, m = "awaitClose")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProduceKt.awaitClose(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitClose(ProducerScope<?> producerScope, yq0 yq0Var, x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (x30Var instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) x30Var;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(x30Var);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(x30Var);
        }
        Object obj = anonymousClass1.result;
        Object objD = a.d();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                d.b(obj);
                if (anonymousClass1.getContext().get(Job.Key) != producerScope) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
                }
                anonymousClass1.L$0 = producerScope;
                anonymousClass1.L$1 = yq0Var;
                anonymousClass1.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(a.c(anonymousClass1), 1);
                cancellableContinuationImpl.initCancellability();
                producerScope.invokeOnClose(new ar0() { // from class: kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // defpackage.ar0
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((Throwable) obj2);
                        return k83.a;
                    }

                    public final void invoke(Throwable th) {
                        CancellableContinuation<k83> cancellableContinuation = cancellableContinuationImpl;
                        Result.a aVar = Result.Companion;
                        cancellableContinuation.resumeWith(Result.m69constructorimpl(k83.a));
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == a.d()) {
                    j70.c(anonymousClass1);
                }
                if (result == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                yq0Var = (yq0) anonymousClass1.L$1;
                d.b(obj);
            }
            yq0Var.invoke();
            return k83.a;
        } catch (Throwable th) {
            yq0Var.invoke();
            throw th;
        }
    }

    public static /* synthetic */ Object awaitClose$default(ProducerScope producerScope, yq0 yq0Var, x30 x30Var, int i, Object obj) {
        if ((i & 1) != 0) {
            yq0Var = new yq0() { // from class: kotlinx.coroutines.channels.ProduceKt.awaitClose.2
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m121invoke() {
                }

                @Override // defpackage.yq0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m121invoke();
                    return k83.a;
                }
            };
        }
        return awaitClose(producerScope, yq0Var, x30Var);
    }

    @ExperimentalCoroutinesApi
    public static final <E> ReceiveChannel<E> produce(CoroutineScope coroutineScope, kotlin.coroutines.d dVar, int i, or0 or0Var) {
        return produce(coroutineScope, dVar, i, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, or0Var);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, kotlin.coroutines.d dVar, int i, or0 or0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return produce(coroutineScope, dVar, i, or0Var);
    }

    @InternalCoroutinesApi
    public static final <E> ReceiveChannel<E> produce(CoroutineScope coroutineScope, kotlin.coroutines.d dVar, int i, CoroutineStart coroutineStart, ar0 ar0Var, or0 or0Var) {
        return produce(coroutineScope, dVar, i, BufferOverflow.SUSPEND, coroutineStart, ar0Var, or0Var);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope coroutineScope, kotlin.coroutines.d dVar, int i, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, ar0 ar0Var, or0 or0Var) {
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, dVar), ChannelKt.Channel$default(i, bufferOverflow, null, 4, null));
        if (ar0Var != null) {
            producerCoroutine.invokeOnCompletion(ar0Var);
        }
        producerCoroutine.start(coroutineStart, producerCoroutine, or0Var);
        return producerCoroutine;
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, kotlin.coroutines.d dVar, int i, CoroutineStart coroutineStart, ar0 ar0Var, or0 or0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        kotlin.coroutines.d dVar2 = dVar;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            ar0Var = null;
        }
        return produce(coroutineScope, dVar2, i3, coroutineStart2, ar0Var, or0Var);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, kotlin.coroutines.d dVar, int i, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, ar0 ar0Var, or0 or0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        kotlin.coroutines.d dVar2 = dVar;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i2 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 16) != 0) {
            ar0Var = null;
        }
        return produce(coroutineScope, dVar2, i3, bufferOverflow2, coroutineStart2, ar0Var, or0Var);
    }
}
