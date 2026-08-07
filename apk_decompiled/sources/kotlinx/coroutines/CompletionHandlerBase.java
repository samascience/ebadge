package kotlinx.coroutines;

import defpackage.ar0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CompletionHandlerBase extends LockFreeLinkedListNode implements ar0 {
    public abstract /* synthetic */ Object invoke(Object obj);

    public abstract void invoke(Throwable th);
}
