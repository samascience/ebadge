package kotlinx.coroutines.channels;

import defpackage.ar0;
import defpackage.j81;
import defpackage.or0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

/* JADX INFO: loaded from: classes4.dex */
public final class BufferedChannelKt {
    private static final long BUFFER_END_RENDEZVOUS = 0;
    private static final long BUFFER_END_UNLIMITED = Long.MAX_VALUE;
    private static final int CLOSE_STATUS_ACTIVE = 0;
    private static final int CLOSE_STATUS_CANCELLATION_STARTED = 1;
    private static final int CLOSE_STATUS_CANCELLED = 3;
    private static final int CLOSE_STATUS_CLOSED = 2;
    private static final long EB_COMPLETED_COUNTER_MASK = 4611686018427387903L;
    private static final long EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT = 4611686018427387904L;
    private static final int RESULT_BUFFERED = 1;
    private static final int RESULT_CLOSED = 4;
    private static final int RESULT_FAILED = 5;
    private static final int RESULT_RENDEZVOUS = 0;
    private static final int RESULT_SUSPEND = 2;
    private static final int RESULT_SUSPEND_NO_WAITER = 3;
    private static final int SENDERS_CLOSE_STATUS_SHIFT = 60;
    private static final long SENDERS_COUNTER_MASK = 1152921504606846975L;
    private static final ChannelSegment<Object> NULL_SEGMENT = new ChannelSegment<>(-1, null, null, 0);
    public static final int SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);
    private static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object) null);
    public static final Symbol BUFFERED = new Symbol("BUFFERED");
    private static final Symbol IN_BUFFER = new Symbol("SHOULD_BUFFER");
    private static final Symbol RESUMING_BY_RCV = new Symbol("S_RESUMING_BY_RCV");
    private static final Symbol RESUMING_BY_EB = new Symbol("RESUMING_BY_EB");
    private static final Symbol POISONED = new Symbol("POISONED");
    private static final Symbol DONE_RCV = new Symbol("DONE_RCV");
    private static final Symbol INTERRUPTED_SEND = new Symbol("INTERRUPTED_SEND");
    private static final Symbol INTERRUPTED_RCV = new Symbol("INTERRUPTED_RCV");
    private static final Symbol CHANNEL_CLOSED = new Symbol("CHANNEL_CLOSED");
    private static final Symbol SUSPEND = new Symbol("SUSPEND");
    private static final Symbol SUSPEND_NO_WAITER = new Symbol("SUSPEND_NO_WAITER");
    private static final Symbol FAILED = new Symbol("FAILED");
    private static final Symbol NO_RECEIVE_RESULT = new Symbol("NO_RECEIVE_RESULT");
    private static final Symbol CLOSE_HANDLER_CLOSED = new Symbol("CLOSE_HANDLER_CLOSED");
    private static final Symbol CLOSE_HANDLER_INVOKED = new Symbol("CLOSE_HANDLER_INVOKED");
    private static final Symbol NO_CLOSE_CAUSE = new Symbol("NO_CLOSE_CAUSE");

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements or0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // defpackage.or0
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).longValue(), (ChannelSegment) obj2);
        }

        public final ChannelSegment<E> invoke(long j, ChannelSegment<E> channelSegment) {
            return BufferedChannelKt.createSegment(j, channelSegment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constructEBCompletedAndPauseFlag(long j, boolean z) {
        return (z ? 4611686018427387904L : 0L) + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constructSendersAndCloseStatus(long j, int i) {
        return (((long) i) << 60) + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> ChannelSegment<E> createSegment(long j, ChannelSegment<E> channelSegment) {
        return new ChannelSegment<>(j, channelSegment, channelSegment.getChannel(), 0);
    }

    public static final <E> j81 createSegmentFunction() {
        return AnonymousClass1.INSTANCE;
    }

    public static final Symbol getCHANNEL_CLOSED() {
        return CHANNEL_CLOSED;
    }

    private static final long getEbCompletedCounter(long j) {
        return j & EB_COMPLETED_COUNTER_MASK;
    }

    private static final boolean getEbPauseExpandBuffers(long j) {
        return (j & 4611686018427387904L) != 0;
    }

    private static final int getSendersCloseStatus(long j) {
        return (int) (j >> 60);
    }

    private static final long getSendersCounter(long j) {
        return j & SENDERS_COUNTER_MASK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long initialBufferEnd(int i) {
        if (i != 0) {
            return i != Integer.MAX_VALUE ? i : BUFFER_END_UNLIMITED;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean tryResume0(CancellableContinuation<? super T> cancellableContinuation, T t, ar0 ar0Var) {
        Object objTryResume = cancellableContinuation.tryResume(t, null, ar0Var);
        if (objTryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(objTryResume);
        return true;
    }

    static /* synthetic */ boolean tryResume0$default(CancellableContinuation cancellableContinuation, Object obj, ar0 ar0Var, int i, Object obj2) {
        if ((i & 2) != 0) {
            ar0Var = null;
        }
        return tryResume0(cancellableContinuation, obj, ar0Var);
    }
}
