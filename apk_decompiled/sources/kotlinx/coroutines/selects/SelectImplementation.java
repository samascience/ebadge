package kotlinx.coroutines.selects;

import defpackage.ar0;
import defpackage.h70;
import defpackage.j70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.pr0;
import defpackage.q1;
import defpackage.x30;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.j;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Segment;

/* JADX INFO: loaded from: classes4.dex */
public class SelectImplementation<R> extends CancelHandler implements SelectBuilder<R>, SelectInstanceInternal<R> {
    private static final AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");
    private final d context;
    private Object disposableHandleOrSegment;
    private volatile Object state = SelectKt.STATE_REG;
    private List<SelectImplementation<R>.ClauseData> clauses = new ArrayList(2);
    private int indexInSegment = -1;
    private Object internalResult = SelectKt.NO_RESULT;

    public final class ClauseData {
        private final Object block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment = -1;
        public final pr0 onCancellationConstructor;
        private final Object param;
        private final pr0 processResFunc;
        private final pr0 regFunc;

        public ClauseData(Object obj, pr0 pr0Var, pr0 pr0Var2, Object obj2, Object obj3, pr0 pr0Var3) {
            this.clauseObject = obj;
            this.regFunc = pr0Var;
            this.processResFunc = pr0Var2;
            this.param = obj2;
            this.block = obj3;
            this.onCancellationConstructor = pr0Var3;
        }

        public final ar0 createOnCancellationAction(SelectInstance<?> selectInstance, Object obj) {
            pr0 pr0Var = this.onCancellationConstructor;
            if (pr0Var != null) {
                return (ar0) pr0Var.invoke(selectInstance, this.param, obj);
            }
            return null;
        }

        public final void dispose() {
            Object obj = this.disposableHandleOrSegment;
            SelectImplementation<R> selectImplementation = SelectImplementation.this;
            if (obj instanceof Segment) {
                ((Segment) obj).onCancellation(this.indexInSegment, null, selectImplementation.getContext());
                return;
            }
            DisposableHandle disposableHandle = obj instanceof DisposableHandle ? (DisposableHandle) obj : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        public final Object invokeBlock(Object obj, x30 x30Var) {
            Object obj2 = this.block;
            if (this.param == SelectKt.getPARAM_CLAUSE_0()) {
                p31.d(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((ar0) obj2).invoke(x30Var);
            }
            p31.d(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((or0) obj2).invoke(obj, x30Var);
        }

        public final Object processResult(Object obj) {
            return this.processResFunc.invoke(this.clauseObject, this.param, obj);
        }

        public final boolean tryRegisterAsWaiter(SelectImplementation<R> selectImplementation) {
            this.regFunc.invoke(this.clauseObject, selectImplementation, this.param);
            return ((SelectImplementation) selectImplementation).internalResult == SelectKt.NO_RESULT;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", l = {431, 434}, m = "doSelectSuspend")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SelectImplementation<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SelectImplementation<R> selectImplementation, x30 x30Var) {
            super(x30Var);
            this.this$0 = selectImplementation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doSelectSuspend(this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", l = {706}, m = "processResultAndInvokeBlockRecoveringException")
    static final class C02561 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SelectImplementation<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02561(SelectImplementation<R> selectImplementation, x30 x30Var) {
            super(x30Var);
            this.this$0 = selectImplementation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.processResultAndInvokeBlockRecoveringException(null, null, this);
        }
    }

    public SelectImplementation(d dVar) {
        this.context = dVar;
    }

    private final void checkClauseObject(Object obj) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        p31.c(list);
        if (list == null || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ClauseData) it.next()).clauseObject == obj) {
                    throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
                }
            }
        }
    }

    private final void cleanup(SelectImplementation<R>.ClauseData clauseData) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        for (SelectImplementation<R>.ClauseData clauseData2 : list) {
            if (clauseData2 != clauseData) {
                clauseData2.dispose();
            }
        }
        state$FU.set(this, SelectKt.STATE_COMPLETED);
        this.internalResult = SelectKt.NO_RESULT;
        this.clauses = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object complete(x30 x30Var) {
        Object obj = state$FU.get(this);
        p31.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj;
        Object obj2 = this.internalResult;
        cleanup(clauseData);
        return clauseData.invokeBlock(clauseData.processResult(obj2), x30Var);
    }

    static /* synthetic */ <R> Object doSelect$suspendImpl(SelectImplementation<R> selectImplementation, x30 x30Var) {
        return selectImplementation.isSelected() ? selectImplementation.complete(x30Var) : selectImplementation.doSelectSuspend(x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object doSelectSuspend(x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        SelectImplementation<R> selectImplementation;
        if (x30Var instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) x30Var;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, x30Var);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, x30Var);
        }
        Object objComplete = anonymousClass1.result;
        Object objD = a.d();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                selectImplementation = (SelectImplementation) anonymousClass1.L$0;
                kotlin.d.b(objComplete);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.d.b(objComplete);
            }
        }
        kotlin.d.b(objComplete);
        anonymousClass1.L$0 = this;
        anonymousClass1.label = 1;
        if (waitUntilSelected(anonymousClass1) == objD) {
            return objD;
        }
        selectImplementation = this;
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 2;
        objComplete = selectImplementation.complete(anonymousClass1);
        return objComplete == objD ? objD : objComplete;
    }

    private final SelectImplementation<R>.ClauseData findClause(Object obj) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        for (Object obj3 : list) {
            if (((ClauseData) obj3).clauseObject == obj) {
                obj2 = obj3;
                break;
            }
        }
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj2;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getInRegistrationPhase() {
        Object obj = state$FU.get(this);
        return obj == SelectKt.STATE_REG || (obj instanceof List);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCancelled() {
        return state$FU.get(this) == SelectKt.STATE_CANCELLED;
    }

    private final boolean isSelected() {
        return state$FU.get(this) instanceof ClauseData;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ar0 ar0Var, Object obj) {
        while (true) {
            ar0Var.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processResultAndInvokeBlockRecoveringException(SelectImplementation<R>.ClauseData clauseData, Object obj, x30 x30Var) throws Throwable {
        C02561 c02561;
        if (x30Var instanceof C02561) {
            c02561 = (C02561) x30Var;
            int i = c02561.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02561.label = i - Integer.MIN_VALUE;
            } else {
                c02561 = new C02561(this, x30Var);
            }
        } else {
            c02561 = new C02561(this, x30Var);
        }
        Object objInvokeBlock = c02561.result;
        Object objD = a.d();
        int i2 = c02561.label;
        if (i2 == 0) {
            kotlin.d.b(objInvokeBlock);
            Object objProcessResult = clauseData.processResult(obj);
            c02561.label = 1;
            objInvokeBlock = clauseData.invokeBlock(objProcessResult, c02561);
            if (objInvokeBlock == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.d.b(objInvokeBlock);
        }
        return objInvokeBlock;
    }

    public static /* synthetic */ void register$default(SelectImplementation selectImplementation, ClauseData clauseData, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        selectImplementation.register(clauseData, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reregisterClause(Object obj) {
        SelectImplementation<R>.ClauseData clauseDataFindClause = findClause(obj);
        p31.c(clauseDataFindClause);
        clauseDataFindClause.disposableHandleOrSegment = null;
        clauseDataFindClause.indexInSegment = -1;
        register(clauseDataFindClause, true);
    }

    private final int trySelectInternal(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof CancellableContinuation) {
                SelectImplementation<R>.ClauseData clauseDataFindClause = findClause(obj);
                if (clauseDataFindClause == null) {
                    continue;
                } else {
                    ar0 ar0VarCreateOnCancellationAction = clauseDataFindClause.createOnCancellationAction(this, obj2);
                    if (q1.a(atomicReferenceFieldUpdater, this, obj3, clauseDataFindClause)) {
                        this.internalResult = obj2;
                        if (SelectKt.tryResume((CancellableContinuation) obj3, ar0VarCreateOnCancellationAction)) {
                            return 0;
                        }
                        this.internalResult = null;
                        return 2;
                    }
                }
            } else {
                if (p31.a(obj3, SelectKt.STATE_COMPLETED) ? true : obj3 instanceof ClauseData) {
                    return 3;
                }
                if (p31.a(obj3, SelectKt.STATE_CANCELLED)) {
                    return 2;
                }
                if (p31.a(obj3, SelectKt.STATE_REG)) {
                    if (q1.a(atomicReferenceFieldUpdater, this, obj3, j.e(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (q1.a(atomicReferenceFieldUpdater, this, obj3, j.R((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }

    private final void update$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ar0 ar0Var, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!q1.a(atomicReferenceFieldUpdater, obj, obj2, ar0Var.invoke(obj2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object waitUntilSelected(x30 x30Var) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(a.c(x30Var), 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.STATE_REG) {
                if (q1.a(state$FU, this, obj, cancellableContinuationImpl)) {
                    cancellableContinuationImpl.invokeOnCancellation(this);
                    break;
                }
            } else {
                if (!(obj instanceof List)) {
                    if (obj instanceof ClauseData) {
                        cancellableContinuationImpl.resume(k83.a, ((ClauseData) obj).createOnCancellationAction(this, this.internalResult));
                        break;
                    }
                    throw new IllegalStateException(("unexpected state: " + obj).toString());
                }
                if (q1.a(state$FU, this, obj, SelectKt.STATE_REG)) {
                    Iterator it = ((Iterable) obj).iterator();
                    while (it.hasNext()) {
                        reregisterClause(it.next());
                    }
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.d()) {
            j70.c(x30Var);
        }
        return result == a.d() ? result : k83.a;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnCompletion(DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    public Object doSelect(x30 x30Var) {
        return doSelect$suspendImpl(this, x30Var);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public d getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CancelHandler, kotlinx.coroutines.CancelHandlerBase, defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> segment, int i) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = i;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    @ExperimentalCoroutinesApi
    public void onTimeout(long j, ar0 ar0Var) {
        SelectBuilder.DefaultImpls.onTimeout(this, j, ar0Var);
    }

    public final void register(SelectImplementation<R>.ClauseData clauseData, boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        if (atomicReferenceFieldUpdater.get(this) instanceof ClauseData) {
            return;
        }
        if (!z) {
            checkClauseObject(clauseData.clauseObject);
        }
        if (!clauseData.tryRegisterAsWaiter(this)) {
            atomicReferenceFieldUpdater.set(this, clauseData);
            return;
        }
        if (!z) {
            List<SelectImplementation<R>.ClauseData> list = this.clauses;
            p31.c(list);
            list.add(clauseData);
        }
        clauseData.disposableHandleOrSegment = this.disposableHandleOrSegment;
        clauseData.indexInSegment = this.indexInSegment;
        this.disposableHandleOrSegment = null;
        this.indexInSegment = -1;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(Object obj) {
        this.internalResult = obj;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(Object obj, Object obj2) {
        return trySelectInternal(obj, obj2) == 0;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object obj, Object obj2) {
        return SelectKt.TrySelectDetailedResult(trySelectInternal(obj, obj2));
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, or0 or0Var) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, or0Var);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 selectClause0, ar0 ar0Var) {
        register$default(this, new ClauseData(selectClause0.getClauseObject(), selectClause0.getRegFunc(), selectClause0.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), ar0Var, selectClause0.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, or0 or0Var) {
        register$default(this, new ClauseData(selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, or0Var, selectClause1.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, or0 or0Var) {
        register$default(this, new ClauseData(selectClause2.getClauseObject(), selectClause2.getRegFunc(), selectClause2.getProcessResFunc(), p, or0Var, selectClause2.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void invoke(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.STATE_COMPLETED) {
                return;
            }
        } while (!q1.a(atomicReferenceFieldUpdater, this, obj, SelectKt.STATE_CANCELLED));
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ClauseData) it.next()).dispose();
        }
        this.internalResult = SelectKt.NO_RESULT;
        this.clauses = null;
    }
}
