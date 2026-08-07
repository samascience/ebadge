package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes4.dex */
final class CompletedContinuation {
    public final Throwable cancelCause;
    public final CancelHandler cancelHandler;
    public final Object idempotentResume;
    public final ar0 onCancellation;
    public final Object result;

    public CompletedContinuation(Object obj, CancelHandler cancelHandler, ar0 ar0Var, Object obj2, Throwable th) {
        this.result = obj;
        this.cancelHandler = cancelHandler;
        this.onCancellation = ar0Var;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public static /* synthetic */ CompletedContinuation copy$default(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, ar0 ar0Var, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = completedContinuation.result;
        }
        if ((i & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        if ((i & 4) != 0) {
            ar0Var = completedContinuation.onCancellation;
        }
        ar0 ar0Var2 = ar0Var;
        if ((i & 8) != 0) {
            obj2 = completedContinuation.idempotentResume;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = completedContinuation.cancelCause;
        }
        return completedContinuation.copy(obj, cancelHandler2, ar0Var2, obj4, th);
    }

    public final Object component1() {
        return this.result;
    }

    public final CancelHandler component2() {
        return this.cancelHandler;
    }

    public final ar0 component3() {
        return this.onCancellation;
    }

    public final Object component4() {
        return this.idempotentResume;
    }

    public final Throwable component5() {
        return this.cancelCause;
    }

    public final CompletedContinuation copy(Object obj, CancelHandler cancelHandler, ar0 ar0Var, Object obj2, Throwable th) {
        return new CompletedContinuation(obj, cancelHandler, ar0Var, obj2, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return p31.a(this.result, completedContinuation.result) && p31.a(this.cancelHandler, completedContinuation.cancelHandler) && p31.a(this.onCancellation, completedContinuation.onCancellation) && p31.a(this.idempotentResume, completedContinuation.idempotentResume) && p31.a(this.cancelCause, completedContinuation.cancelCause);
    }

    public final boolean getCancelled() {
        return this.cancelCause != null;
    }

    public int hashCode() {
        Object obj = this.result;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.cancelHandler;
        int iHashCode2 = (iHashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        ar0 ar0Var = this.onCancellation;
        int iHashCode3 = (iHashCode2 + (ar0Var == null ? 0 : ar0Var.hashCode())) * 31;
        Object obj2 = this.idempotentResume;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.cancelCause;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final void invokeHandlers(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable th) {
        CancelHandler cancelHandler = this.cancelHandler;
        if (cancelHandler != null) {
            cancellableContinuationImpl.callCancelHandler(cancelHandler, th);
        }
        ar0 ar0Var = this.onCancellation;
        if (ar0Var != null) {
            cancellableContinuationImpl.callOnCancellation(ar0Var, th);
        }
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, ar0 ar0Var, Object obj2, Throwable th, int i, y70 y70Var) {
        this(obj, (i & 2) != 0 ? null : cancelHandler, (i & 4) != 0 ? null : ar0Var, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
