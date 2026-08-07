package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletedWithCancellation {
    public final ar0 onCancellation;
    public final Object result;

    public CompletedWithCancellation(Object obj, ar0 ar0Var) {
        this.result = obj;
        this.onCancellation = ar0Var;
    }

    public static /* synthetic */ CompletedWithCancellation copy$default(CompletedWithCancellation completedWithCancellation, Object obj, ar0 ar0Var, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = completedWithCancellation.result;
        }
        if ((i & 2) != 0) {
            ar0Var = completedWithCancellation.onCancellation;
        }
        return completedWithCancellation.copy(obj, ar0Var);
    }

    public final Object component1() {
        return this.result;
    }

    public final ar0 component2() {
        return this.onCancellation;
    }

    public final CompletedWithCancellation copy(Object obj, ar0 ar0Var) {
        return new CompletedWithCancellation(obj, ar0Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedWithCancellation)) {
            return false;
        }
        CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) obj;
        return p31.a(this.result, completedWithCancellation.result) && p31.a(this.onCancellation, completedWithCancellation.onCancellation);
    }

    public int hashCode() {
        Object obj = this.result;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.onCancellation.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.result + ", onCancellation=" + this.onCancellation + ')';
    }
}
