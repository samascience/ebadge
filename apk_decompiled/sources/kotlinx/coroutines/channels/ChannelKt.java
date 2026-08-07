package kotlinx.coroutines.channels;

import defpackage.ar0;

/* JADX INFO: loaded from: classes4.dex */
public final class ChannelKt {
    public static final <E> Channel<E> Channel(int i, BufferOverflow bufferOverflow, ar0 ar0Var) {
        Channel<E> bufferedChannel;
        if (i == -2) {
            bufferedChannel = bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel<>(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), ar0Var) : new ConflatedBufferedChannel<>(1, bufferOverflow, ar0Var);
        } else {
            if (i == -1) {
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, ar0Var);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
            if (i != 0) {
                if (i != Integer.MAX_VALUE) {
                    return bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(i, ar0Var) : new ConflatedBufferedChannel(i, bufferOverflow, ar0Var);
                }
                return new BufferedChannel(Integer.MAX_VALUE, ar0Var);
            }
            bufferedChannel = bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel<>(0, ar0Var) : new ConflatedBufferedChannel<>(1, bufferOverflow, ar0Var);
        }
        return bufferedChannel;
    }

    public static /* synthetic */ Channel Channel$default(int i, BufferOverflow bufferOverflow, ar0 ar0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            ar0Var = null;
        }
        return Channel(i, bufferOverflow, ar0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOrElse-WpGqRn0, reason: not valid java name */
    public static final <T> T m98getOrElseWpGqRn0(Object obj, ar0 ar0Var) {
        return obj instanceof ChannelResult.Failed ? (T) ar0Var.invoke(ChannelResult.m106exceptionOrNullimpl(obj)) : obj;
    }

    /* JADX INFO: renamed from: onClosed-WpGqRn0, reason: not valid java name */
    public static final <T> Object m99onClosedWpGqRn0(Object obj, ar0 ar0Var) {
        if (obj instanceof ChannelResult.Closed) {
            ar0Var.invoke(ChannelResult.m106exceptionOrNullimpl(obj));
        }
        return obj;
    }

    /* JADX INFO: renamed from: onFailure-WpGqRn0, reason: not valid java name */
    public static final <T> Object m100onFailureWpGqRn0(Object obj, ar0 ar0Var) {
        if (obj instanceof ChannelResult.Failed) {
            ar0Var.invoke(ChannelResult.m106exceptionOrNullimpl(obj));
        }
        return obj;
    }

    /* JADX INFO: renamed from: onSuccess-WpGqRn0, reason: not valid java name */
    public static final <T> Object m101onSuccessWpGqRn0(Object obj, ar0 ar0Var) {
        if (!(obj instanceof ChannelResult.Failed)) {
            ar0Var.invoke(obj);
        }
        return obj;
    }

    public static /* synthetic */ Channel Channel$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return Channel(i);
    }

    public static final /* synthetic */ Channel Channel(int i) {
        return Channel$default(i, null, null, 6, null);
    }
}
