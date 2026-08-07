package kotlin;

import defpackage.ja1;
import defpackage.p31;
import defpackage.q1;
import defpackage.w73;
import defpackage.y70;
import defpackage.yq0;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes4.dex */
final class SafePublicationLazyImpl<T> implements ja1, Serializable {
    public static final a Companion = new a(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    private final Object f0final;
    private volatile yq0 initializer;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public SafePublicationLazyImpl(yq0 yq0Var) {
        p31.f(yq0Var, "initializer");
        this.initializer = yq0Var;
        w73 w73Var = w73.a;
        this._value = w73Var;
        this.f0final = w73Var;
    }

    private static /* synthetic */ void getFinal$annotations() {
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // defpackage.ja1
    public T getValue() {
        T t = (T) this._value;
        w73 w73Var = w73.a;
        if (t != w73Var) {
            return t;
        }
        yq0 yq0Var = this.initializer;
        if (yq0Var != null) {
            T t2 = (T) yq0Var.invoke();
            if (q1.a(valueUpdater, this, w73Var, t2)) {
                this.initializer = null;
                return t2;
            }
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
