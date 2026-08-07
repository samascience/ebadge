package kotlinx.coroutines.channels;

import defpackage.x30;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes4.dex */
@ObsoleteCoroutinesApi
public interface ActorScope<E> extends CoroutineScope, ReceiveChannel<E> {

    public static final class DefaultImpls {
        public static <E> SelectClause1<E> getOnReceiveOrNull(ActorScope<E> actorScope) {
            return ReceiveChannel.DefaultImpls.getOnReceiveOrNull(actorScope);
        }

        public static <E> E poll(ActorScope<E> actorScope) {
            return (E) ReceiveChannel.DefaultImpls.poll(actorScope);
        }

        public static <E> Object receiveOrNull(ActorScope<E> actorScope, x30 x30Var) {
            return ReceiveChannel.DefaultImpls.receiveOrNull(actorScope, x30Var);
        }
    }

    Channel<E> getChannel();
}
