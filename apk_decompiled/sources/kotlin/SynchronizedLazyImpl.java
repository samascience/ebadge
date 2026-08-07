package kotlin;

import defpackage.ja1;
import defpackage.p31;
import defpackage.w73;
import defpackage.y70;
import defpackage.yq0;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
final class SynchronizedLazyImpl<T> implements ja1, Serializable {
    private volatile Object _value;
    private yq0 initializer;
    private final Object lock;

    public SynchronizedLazyImpl(yq0 yq0Var, Object obj) {
        p31.f(yq0Var, "initializer");
        this.initializer = yq0Var;
        this._value = w73.a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // defpackage.ja1
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        w73 w73Var = w73.a;
        if (t2 != w73Var) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == w73Var) {
                yq0 yq0Var = this.initializer;
                p31.c(yq0Var);
                t = (T) yq0Var.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != w73.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(yq0 yq0Var, Object obj, int i, y70 y70Var) {
        this(yq0Var, (i & 2) != 0 ? null : obj);
    }
}
