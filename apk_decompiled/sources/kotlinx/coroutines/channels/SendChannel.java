package kotlinx.coroutines.channels;

import defpackage.ar0;
import defpackage.x30;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;

/* JADX INFO: loaded from: classes4.dex */
public interface SendChannel<E> {

    public static final class DefaultImpls {
        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return sendChannel.close(th);
        }

        @DelicateCoroutinesApi
        public static /* synthetic */ void isClosedForSend$annotations() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <E> boolean offer(SendChannel<? super E> sendChannel, E e) throws Throwable {
            Object objMo92trySendJP2dKIU = sendChannel.mo92trySendJP2dKIU(e);
            if (ChannelResult.m112isSuccessimpl(objMo92trySendJP2dKIU)) {
                return true;
            }
            Throwable thM106exceptionOrNullimpl = ChannelResult.m106exceptionOrNullimpl(objMo92trySendJP2dKIU);
            if (thM106exceptionOrNullimpl == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(thM106exceptionOrNullimpl);
        }
    }

    boolean close(Throwable th);

    SelectClause2<E, SendChannel<E>> getOnSend();

    void invokeOnClose(ar0 ar0Var);

    boolean isClosedForSend();

    boolean offer(E e);

    Object send(E e, x30 x30Var);

    /* JADX INFO: renamed from: trySend-JP2dKIU */
    Object mo92trySendJP2dKIU(E e);
}
