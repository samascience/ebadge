package kotlinx.coroutines;

import defpackage.j21;
import defpackage.or0;
import defpackage.p40;
import defpackage.x30;
import defpackage.yq0;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
public final class CoroutineContextKt {
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final d foldCopies(d dVar, d dVar2, final boolean z) {
        boolean zHasCopyableElements = hasCopyableElements(dVar);
        boolean zHasCopyableElements2 = hasCopyableElements(dVar2);
        if (!zHasCopyableElements && !zHasCopyableElements2) {
            return dVar.plus(dVar2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = dVar2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        d dVar3 = (d) dVar.fold(emptyCoroutineContext, new or0() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.d] */
            @Override // defpackage.or0
            public final d invoke(d dVar4, d.b bVar) {
                if (!(bVar instanceof CopyableThreadContextElement)) {
                    return dVar4.plus(bVar);
                }
                d.b bVar2 = ref$ObjectRef.element.get(bVar.getKey());
                if (bVar2 != null) {
                    Ref$ObjectRef<d> ref$ObjectRef2 = ref$ObjectRef;
                    ref$ObjectRef2.element = ref$ObjectRef2.element.minusKey(bVar.getKey());
                    return dVar4.plus(((CopyableThreadContextElement) bVar).mergeForChild(bVar2));
                }
                CopyableThreadContextElement copyableThreadContextElementCopyForChild = (CopyableThreadContextElement) bVar;
                if (z) {
                    copyableThreadContextElementCopyForChild = copyableThreadContextElementCopyForChild.copyForChild();
                }
                return dVar4.plus(copyableThreadContextElementCopyForChild);
            }
        });
        if (zHasCopyableElements2) {
            ref$ObjectRef.element = ((d) ref$ObjectRef.element).fold(emptyCoroutineContext, new or0() { // from class: kotlinx.coroutines.CoroutineContextKt.foldCopies.1
                @Override // defpackage.or0
                public final d invoke(d dVar4, d.b bVar) {
                    return bVar instanceof CopyableThreadContextElement ? dVar4.plus(((CopyableThreadContextElement) bVar).copyForChild()) : dVar4.plus(bVar);
                }
            });
        }
        return dVar3.plus((d) ref$ObjectRef.element);
    }

    public static final String getCoroutineName(d dVar) {
        return null;
    }

    private static final boolean hasCopyableElements(d dVar) {
        return ((Boolean) dVar.fold(Boolean.FALSE, new or0() { // from class: kotlinx.coroutines.CoroutineContextKt.hasCopyableElements.1
            public final Boolean invoke(boolean z, d.b bVar) {
                return Boolean.valueOf(z || (bVar instanceof CopyableThreadContextElement));
            }

            @Override // defpackage.or0
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (d.b) obj2);
            }
        })).booleanValue();
    }

    @ExperimentalCoroutinesApi
    public static final d newCoroutineContext(CoroutineScope coroutineScope, d dVar) {
        d dVarFoldCopies = foldCopies(coroutineScope.getCoroutineContext(), dVar, true);
        return (dVarFoldCopies == Dispatchers.getDefault() || dVarFoldCopies.get(c.E) != null) ? dVarFoldCopies : dVarFoldCopies.plus(Dispatchers.getDefault());
    }

    public static final UndispatchedCoroutine<?> undispatchedCompletion(p40 p40Var) {
        while (!(p40Var instanceof DispatchedCoroutine) && (p40Var = p40Var.getCallerFrame()) != null) {
            if (p40Var instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) p40Var;
            }
        }
        return null;
    }

    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(x30 x30Var, d dVar, Object obj) {
        if (!(x30Var instanceof p40) || dVar.get(UndispatchedMarker.INSTANCE) == null) {
            return null;
        }
        UndispatchedCoroutine<?> undispatchedCoroutineUndispatchedCompletion = undispatchedCompletion((p40) x30Var);
        if (undispatchedCoroutineUndispatchedCompletion != null) {
            undispatchedCoroutineUndispatchedCompletion.saveThreadContext(dVar, obj);
        }
        return undispatchedCoroutineUndispatchedCompletion;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022 A[DONT_GENERATE] */
    public static final <T> T withContinuationContext(x30 x30Var, Object obj, yq0 yq0Var) {
        d context = x30Var.getContext();
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
        UndispatchedCoroutine<?> undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? updateUndispatchedCompletion(x30Var, context, objUpdateThreadContext) : null;
        try {
            return (T) yq0Var.invoke();
        } finally {
            j21.b(1);
            if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
            j21.a(1);
        }
    }

    public static final <T> T withCoroutineContext(d dVar, Object obj, yq0 yq0Var) {
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(dVar, obj);
        try {
            return (T) yq0Var.invoke();
        } finally {
            j21.b(1);
            ThreadContextKt.restoreThreadContext(dVar, objUpdateThreadContext);
            j21.a(1);
        }
    }

    @InternalCoroutinesApi
    public static final d newCoroutineContext(d dVar, d dVar2) {
        return !hasCopyableElements(dVar2) ? dVar.plus(dVar2) : foldCopies(dVar, dVar2, false);
    }
}
