package kotlinx.coroutines.internal;

import kotlinx.coroutines.InternalCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public interface ThreadSafeHeapNode {
    ThreadSafeHeap<?> getHeap();

    int getIndex();

    void setHeap(ThreadSafeHeap<?> threadSafeHeap);

    void setIndex(int i);
}
