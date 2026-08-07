package kotlinx.coroutines.channels;

import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
public interface ChannelIterator<E> {

    public static final class DefaultImpls {
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public static /* synthetic */ Object next(ChannelIterator channelIterator, x30 x30Var) throws Throwable {
            ChannelIterator$next0$1 channelIterator$next0$1;
            if (x30Var instanceof ChannelIterator$next0$1) {
                channelIterator$next0$1 = (ChannelIterator$next0$1) x30Var;
                int i = channelIterator$next0$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    channelIterator$next0$1.label = i - Integer.MIN_VALUE;
                } else {
                    channelIterator$next0$1 = new ChannelIterator$next0$1(x30Var);
                }
            } else {
                channelIterator$next0$1 = new ChannelIterator$next0$1(x30Var);
            }
            Object objHasNext = channelIterator$next0$1.result;
            Object objD = a.d();
            int i2 = channelIterator$next0$1.label;
            if (i2 == 0) {
                d.b(objHasNext);
                channelIterator$next0$1.L$0 = channelIterator;
                channelIterator$next0$1.label = 1;
                objHasNext = channelIterator.hasNext(channelIterator$next0$1);
                if (objHasNext == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator = (ChannelIterator) channelIterator$next0$1.L$0;
                d.b(objHasNext);
            }
            if (((Boolean) objHasNext).booleanValue()) {
                return channelIterator.next();
            }
            throw new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
    }

    Object hasNext(x30 x30Var);

    E next();

    /* synthetic */ Object next(x30 x30Var);
}
