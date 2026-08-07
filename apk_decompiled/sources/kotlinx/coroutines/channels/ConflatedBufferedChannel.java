package kotlinx.coroutines.channels;

import defpackage.ar0;
import defpackage.jn;
import defpackage.k83;
import defpackage.ke2;
import defpackage.oi0;
import defpackage.x30;
import defpackage.y70;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes4.dex */
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {
    private final int capacity;
    private final BufferOverflow onBufferOverflow;

    public /* synthetic */ ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, ar0 ar0Var, int i2, y70 y70Var) {
        this(i, bufferOverflow, (i2 & 4) != 0 ? null : ar0Var);
    }

    static /* synthetic */ <E> Object send$suspendImpl(ConflatedBufferedChannel<E> conflatedBufferedChannel, E e, x30 x30Var) throws Throwable {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        Object objM120trySendImplMj0NB7M = conflatedBufferedChannel.m120trySendImplMj0NB7M(e, true);
        if (!(objM120trySendImplMj0NB7M instanceof ChannelResult.Closed)) {
            return k83.a;
        }
        ChannelResult.m106exceptionOrNullimpl(objM120trySendImplMj0NB7M);
        ar0 ar0Var = conflatedBufferedChannel.onUndeliveredElement;
        if (ar0Var == null || (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(ar0Var, e, null, 2, null)) == null) {
            throw conflatedBufferedChannel.getSendException();
        }
        oi0.a(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, conflatedBufferedChannel.getSendException());
        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
    }

    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(ConflatedBufferedChannel<E> conflatedBufferedChannel, E e, x30 x30Var) {
        Object objM120trySendImplMj0NB7M = conflatedBufferedChannel.m120trySendImplMj0NB7M(e, true);
        if (objM120trySendImplMj0NB7M instanceof ChannelResult.Failed) {
            return jn.a(false);
        }
        return jn.a(true);
    }

    /* JADX INFO: renamed from: trySendDropLatest-Mj0NB7M, reason: not valid java name */
    private final Object m118trySendDropLatestMj0NB7M(E e, boolean z) {
        ar0 ar0Var;
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        Object objMo92trySendJP2dKIU = super.mo92trySendJP2dKIU(e);
        if (ChannelResult.m112isSuccessimpl(objMo92trySendJP2dKIU) || ChannelResult.m110isClosedimpl(objMo92trySendJP2dKIU)) {
            return objMo92trySendJP2dKIU;
        }
        if (!z || (ar0Var = this.onUndeliveredElement) == null || (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(ar0Var, e, null, 2, null)) == null) {
            return ChannelResult.Companion.m117successJP2dKIU(k83.a);
        }
        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
    }

    /* JADX INFO: renamed from: trySendDropOldest-JP2dKIU, reason: not valid java name */
    private final Object m119trySendDropOldestJP2dKIU(E e) {
        ChannelSegment channelSegment;
        Object obj = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.sendSegment$FU.get(this);
        while (true) {
            long andIncrement = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / ((long) i);
            int i2 = (int) (j % ((long) i));
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    return ChannelResult.Companion.m115closedJP2dKIU(getSendException());
                }
            } else {
                channelSegment = channelSegment2;
            }
            int iUpdateCellSend = updateCellSend(channelSegment, i2, e, j, obj, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return ChannelResult.Companion.m117successJP2dKIU(k83.a);
            }
            if (iUpdateCellSend == 1) {
                return ChannelResult.Companion.m117successJP2dKIU(k83.a);
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return ChannelResult.Companion.m115closedJP2dKIU(getSendException());
                }
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    prepareSenderForSuspension(waiter, channelSegment, i2);
                }
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * ((long) i)) + ((long) i2));
                return ChannelResult.Companion.m117successJP2dKIU(k83.a);
            }
            if (iUpdateCellSend == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return ChannelResult.Companion.m115closedJP2dKIU(getSendException());
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
            channelSegment2 = channelSegment;
        }
    }

    /* JADX INFO: renamed from: trySendImpl-Mj0NB7M, reason: not valid java name */
    private final Object m120trySendImplMj0NB7M(E e, boolean z) {
        return this.onBufferOverflow == BufferOverflow.DROP_LATEST ? m118trySendDropLatestMj0NB7M(e, z) : m119trySendDropOldestJP2dKIU(e);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean isConflatedDropOldest() {
        return this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void registerSelectForSend(SelectInstance<?> selectInstance, Object obj) {
        Object objMo92trySendJP2dKIU = mo92trySendJP2dKIU(obj);
        if (!(objMo92trySendJP2dKIU instanceof ChannelResult.Failed)) {
            selectInstance.selectInRegistrationPhase(k83.a);
        } else {
            if (!(objMo92trySendJP2dKIU instanceof ChannelResult.Closed)) {
                throw new IllegalStateException("unreachable");
            }
            ChannelResult.m106exceptionOrNullimpl(objMo92trySendJP2dKIU);
            selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object send(E e, x30 x30Var) {
        return send$suspendImpl((ConflatedBufferedChannel) this, (Object) e, x30Var);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public Object sendBroadcast$kotlinx_coroutines_core(E e, x30 x30Var) {
        return sendBroadcast$suspendImpl((ConflatedBufferedChannel) this, (Object) e, x30Var);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo92trySendJP2dKIU(E e) {
        return m120trySendImplMj0NB7M(e, false);
    }

    public ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, ar0 ar0Var) {
        super(i, ar0Var);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + ke2.b(BufferedChannel.class).a() + " instead").toString());
        }
        if (i >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
    }
}
