package kotlinx.coroutines.channels;

import defpackage.ar0;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import kotlin.coroutines.d;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.cancelConsumed(receiveChannel, th);
    }

    @ObsoleteCoroutinesApi
    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, ar0 ar0Var) {
        return (R) ChannelsKt__Channels_commonKt.consume(broadcastChannel, ar0Var);
    }

    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, ar0 ar0Var, x30 x30Var) {
        return ChannelsKt__Channels_commonKt.consumeEach(broadcastChannel, ar0Var, x30Var);
    }

    public static final ar0 consumes(ReceiveChannel<?> receiveChannel) {
        return ChannelsKt__DeprecatedKt.consumes(receiveChannel);
    }

    public static final ar0 consumesAll(ReceiveChannel<?>... receiveChannelArr) {
        return ChannelsKt__DeprecatedKt.consumesAll(receiveChannelArr);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, d dVar, or0 or0Var) {
        return ChannelsKt__DeprecatedKt.distinctBy(receiveChannel, dVar, or0Var);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, d dVar, or0 or0Var) {
        return ChannelsKt__DeprecatedKt.filter(receiveChannel, dVar, or0Var);
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__DeprecatedKt.filterNotNull(receiveChannel);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, d dVar, or0 or0Var) {
        return ChannelsKt__DeprecatedKt.map(receiveChannel, dVar, or0Var);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, d dVar, pr0 pr0Var) {
        return ChannelsKt__DeprecatedKt.mapIndexed(receiveChannel, dVar, pr0Var);
    }

    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, x30 x30Var) {
        return ChannelsKt__DeprecatedKt.toChannel(receiveChannel, c, x30Var);
    }

    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, x30 x30Var) {
        return ChannelsKt__DeprecatedKt.toCollection(receiveChannel, c, x30Var);
    }

    public static final <E> Object toList(ReceiveChannel<? extends E> receiveChannel, x30 x30Var) {
        return ChannelsKt__Channels_commonKt.toList(receiveChannel, x30Var);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, x30 x30Var) {
        return ChannelsKt__DeprecatedKt.toMutableSet(receiveChannel, x30Var);
    }

    public static final <E> Object trySendBlocking(SendChannel<? super E> sendChannel, E e) {
        return ChannelsKt__ChannelsKt.trySendBlocking(sendChannel, e);
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, ar0 ar0Var) {
        return (R) ChannelsKt__Channels_commonKt.consume(receiveChannel, ar0Var);
    }

    public static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, ar0 ar0Var, x30 x30Var) {
        return ChannelsKt__Channels_commonKt.consumeEach(receiveChannel, ar0Var, x30Var);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, x30 x30Var) {
        return ChannelsKt__DeprecatedKt.toMap(receiveChannel, m, x30Var);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, d dVar, or0 or0Var) {
        return ChannelsKt__DeprecatedKt.zip(receiveChannel, receiveChannel2, dVar, or0Var);
    }
}
