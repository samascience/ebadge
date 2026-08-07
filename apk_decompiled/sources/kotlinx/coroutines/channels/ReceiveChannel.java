package kotlinx.coroutines.channels;

import defpackage.h70;
import defpackage.p31;
import defpackage.x30;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes4.dex */
public interface ReceiveChannel<E> {

    public static final class DefaultImpls {
        public static /* synthetic */ void cancel$default(ReceiveChannel receiveChannel, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            receiveChannel.cancel(cancellationException);
        }

        public static <E> SelectClause1<E> getOnReceiveOrNull(ReceiveChannel<? extends E> receiveChannel) {
            p31.d(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
            return ((BufferedChannel) receiveChannel).getOnReceiveOrNull();
        }

        public static /* synthetic */ void getOnReceiveOrNull$annotations() {
        }

        @DelicateCoroutinesApi
        public static /* synthetic */ void isClosedForReceive$annotations() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void isEmpty$annotations() {
        }

        public static <E> E poll(ReceiveChannel<? extends E> receiveChannel) throws Throwable {
            Object objMo97tryReceivePtdJZtk = receiveChannel.mo97tryReceivePtdJZtk();
            if (ChannelResult.m112isSuccessimpl(objMo97tryReceivePtdJZtk)) {
                return (E) ChannelResult.m108getOrThrowimpl(objMo97tryReceivePtdJZtk);
            }
            Throwable thM106exceptionOrNullimpl = ChannelResult.m106exceptionOrNullimpl(objMo97tryReceivePtdJZtk);
            if (thM106exceptionOrNullimpl == null) {
                return null;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(thM106exceptionOrNullimpl);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public static <E> Object receiveOrNull(ReceiveChannel<? extends E> receiveChannel, x30 x30Var) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object objMo96receiveCatchingJP2dKIU;
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
            if (i2 == 0) {
                d.b(obj);
                anonymousClass1.label = 1;
                objMo96receiveCatchingJP2dKIU = receiveChannel.mo96receiveCatchingJP2dKIU(anonymousClass1);
                if (objMo96receiveCatchingJP2dKIU == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
                objMo96receiveCatchingJP2dKIU = ((ChannelResult) obj).m114unboximpl();
            }
            return ChannelResult.m107getOrNullimpl(objMo96receiveCatchingJP2dKIU);
        }

        public static /* synthetic */ boolean cancel$default(ReceiveChannel receiveChannel, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return receiveChannel.cancel(th);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", l = {372}, m = "receiveOrNull")
    static final class AnonymousClass1<E> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultImpls.receiveOrNull(null, this);
        }
    }

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    SelectClause1<E> getOnReceive();

    SelectClause1<ChannelResult<E>> getOnReceiveCatching();

    SelectClause1<E> getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    ChannelIterator<E> iterator();

    E poll();

    Object receive(x30 x30Var);

    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    Object mo96receiveCatchingJP2dKIU(x30 x30Var);

    Object receiveOrNull(x30 x30Var);

    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    Object mo97tryReceivePtdJZtk();
}
