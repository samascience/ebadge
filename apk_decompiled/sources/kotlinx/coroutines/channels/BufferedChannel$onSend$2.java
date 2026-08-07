package kotlinx.coroutines.channels;

import defpackage.pr0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class BufferedChannel$onSend$2 extends FunctionReferenceImpl implements pr0 {
    public static final BufferedChannel$onSend$2 INSTANCE = new BufferedChannel$onSend$2();

    BufferedChannel$onSend$2() {
        super(3, BufferedChannel.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // defpackage.pr0
    public final Object invoke(BufferedChannel<?> bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.processResultSelectSend(obj, obj2);
    }
}
