package kotlinx.coroutines.flow.internal;

import defpackage.j70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.p40;
import defpackage.pr0;
import defpackage.x30;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.i;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T>, p40 {
    public final d collectContext;
    public final int collectContextSize;
    public final FlowCollector<T> collector;
    private x30 completion;
    private d lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(FlowCollector<? super T> flowCollector, d dVar) {
        super(NoOpContinuation.INSTANCE, EmptyCoroutineContext.INSTANCE);
        this.collector = flowCollector;
        this.collectContext = dVar;
        this.collectContextSize = ((Number) dVar.fold(0, new or0() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            public final Integer invoke(int i, d.b bVar) {
                return Integer.valueOf(i + 1);
            }

            @Override // defpackage.or0
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (d.b) obj2);
            }
        })).intValue();
    }

    private final void checkContext(d dVar, d dVar2, T t) {
        if (dVar2 instanceof DownstreamExceptionContext) {
            exceptionTransparencyViolated((DownstreamExceptionContext) dVar2, t);
        }
        SafeCollector_commonKt.checkContext(this, dVar);
    }

    private final void exceptionTransparencyViolated(DownstreamExceptionContext downstreamExceptionContext, Object obj) {
        throw new IllegalStateException(i.j("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + downstreamExceptionContext.e + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, x30 x30Var) {
        try {
            Object objEmit = emit(x30Var, t);
            if (objEmit == a.d()) {
                j70.c(x30Var);
            }
            return objEmit == a.d() ? objEmit : k83.a;
        } catch (Throwable th) {
            this.lastEmissionContext = new DownstreamExceptionContext(th, x30Var.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, defpackage.p40
    public p40 getCallerFrame() {
        x30 x30Var = this.completion;
        if (x30Var instanceof p40) {
            return (p40) x30Var;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl, defpackage.x30
    public d getContext() {
        d dVar = this.lastEmissionContext;
        return dVar == null ? EmptyCoroutineContext.INSTANCE : dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, defpackage.p40
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        Throwable thM72exceptionOrNullimpl = Result.m72exceptionOrNullimpl(obj);
        if (thM72exceptionOrNullimpl != null) {
            this.lastEmissionContext = new DownstreamExceptionContext(thM72exceptionOrNullimpl, getContext());
        }
        x30 x30Var = this.completion;
        if (x30Var != null) {
            x30Var.resumeWith(obj);
        }
        return a.d();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(x30 x30Var, T t) {
        d context = x30Var.getContext();
        JobKt.ensureActive(context);
        d dVar = this.lastEmissionContext;
        if (dVar != context) {
            checkContext(context, dVar, t);
            this.lastEmissionContext = context;
        }
        this.completion = x30Var;
        pr0 pr0Var = SafeCollectorKt.emitFun;
        FlowCollector<T> flowCollector = this.collector;
        p31.d(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        p31.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = pr0Var.invoke(flowCollector, t, this);
        if (!p31.a(objInvoke, a.d())) {
            this.completion = null;
        }
        return objInvoke;
    }
}
