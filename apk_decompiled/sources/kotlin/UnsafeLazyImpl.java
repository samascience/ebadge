package kotlin;

import defpackage.ja1;
import defpackage.p31;
import defpackage.w73;
import defpackage.yq0;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final class UnsafeLazyImpl<T> implements ja1, Serializable {
    private Object _value;
    private yq0 initializer;

    public UnsafeLazyImpl(yq0 yq0Var) {
        p31.f(yq0Var, "initializer");
        this.initializer = yq0Var;
        this._value = w73.a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // defpackage.ja1
    public T getValue() {
        if (this._value == w73.a) {
            yq0 yq0Var = this.initializer;
            p31.c(yq0Var);
            this._value = yq0Var.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != w73.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
