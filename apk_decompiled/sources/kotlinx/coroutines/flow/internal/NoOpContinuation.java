package kotlinx.coroutines.flow.internal;

import defpackage.x30;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
final class NoOpContinuation implements x30 {
    public static final NoOpContinuation INSTANCE = new NoOpContinuation();
    private static final d context = EmptyCoroutineContext.INSTANCE;

    private NoOpContinuation() {
    }

    @Override // defpackage.x30
    public d getContext() {
        return context;
    }

    @Override // defpackage.x30
    public void resumeWith(Object obj) {
    }
}
