package kotlinx.coroutines.flow;

import defpackage.x30;
import kotlinx.coroutines.ExperimentalCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
public interface MutableSharedFlow<T> extends SharedFlow<T>, FlowCollector<T> {
    @Override // kotlinx.coroutines.flow.FlowCollector
    Object emit(T t, x30 x30Var);

    StateFlow<Integer> getSubscriptionCount();

    @ExperimentalCoroutinesApi
    void resetReplayCache();

    boolean tryEmit(T t);
}
