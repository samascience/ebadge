package kotlinx.coroutines;

import kotlinx.coroutines.internal.Segment;

/* JADX INFO: loaded from: classes4.dex */
public interface Waiter {
    void invokeOnCancellation(Segment<?> segment, int i);
}
