package kotlinx.coroutines.selects;

import kotlin.coroutines.d;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public interface SelectInstance<R> {
    void disposeOnCompletion(DisposableHandle disposableHandle);

    d getContext();

    void selectInRegistrationPhase(Object obj);

    boolean trySelect(Object obj, Object obj2);
}
