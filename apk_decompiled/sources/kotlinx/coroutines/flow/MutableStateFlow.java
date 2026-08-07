package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes4.dex */
public interface MutableStateFlow<T> extends StateFlow<T>, MutableSharedFlow<T> {
    boolean compareAndSet(T t, T t2);

    @Override // kotlinx.coroutines.flow.StateFlow
    T getValue();

    void setValue(T t);
}
