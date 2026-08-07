package kotlin;

import defpackage.ja1;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final class InitializedLazyImpl<T> implements ja1, Serializable {
    private final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

    @Override // defpackage.ja1
    public T getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
