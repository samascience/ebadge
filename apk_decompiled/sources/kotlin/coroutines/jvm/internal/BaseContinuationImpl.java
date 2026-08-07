package kotlin.coroutines.jvm.internal;

import defpackage.i70;
import defpackage.j70;
import defpackage.p31;
import defpackage.p40;
import defpackage.x30;
import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseContinuationImpl implements x30, p40, Serializable {
    private final x30 completion;

    public BaseContinuationImpl(x30 x30Var) {
        this.completion = x30Var;
    }

    public x30 create(x30 x30Var) {
        p31.f(x30Var, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // defpackage.p40
    public p40 getCallerFrame() {
        x30 x30Var = this.completion;
        if (x30Var instanceof p40) {
            return (p40) x30Var;
        }
        return null;
    }

    public final x30 getCompletion() {
        return this.completion;
    }

    @Override // defpackage.x30
    public abstract /* synthetic */ d getContext();

    @Override // defpackage.p40
    public StackTraceElement getStackTraceElement() {
        return i70.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    @Override // defpackage.x30
    public final void resumeWith(Object obj) {
        x30 x30Var = this;
        while (true) {
            j70.b(x30Var);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) x30Var;
            x30 x30Var2 = baseContinuationImpl.completion;
            p31.c(x30Var2);
            try {
                Object objInvokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                if (objInvokeSuspend == a.d()) {
                    return;
                } else {
                    obj = Result.m69constructorimpl(objInvokeSuspend);
                }
            } catch (Throwable th) {
                Result.a aVar = Result.Companion;
                obj = Result.m69constructorimpl(kotlin.d.a(th));
            }
            baseContinuationImpl.releaseIntercepted();
            if (!(x30Var2 instanceof BaseContinuationImpl)) {
                x30Var2.resumeWith(obj);
                return;
            }
            x30Var = x30Var2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public x30 create(Object obj, x30 x30Var) {
        p31.f(x30Var, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
