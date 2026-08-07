package kotlinx.coroutines.future;

import defpackage.ar0;
import defpackage.j70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.future.FutureKt;

/* JADX INFO: loaded from: classes4.dex */
public final class FutureKt {
    public static final <T> CompletableFuture<T> asCompletableFuture(final Deferred<? extends T> deferred) {
        final CompletableFuture<T> completableFuture = new CompletableFuture<>();
        setupCancellation(deferred, completableFuture);
        deferred.invokeOnCompletion(new ar0() { // from class: kotlinx.coroutines.future.FutureKt.asCompletableFuture.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // defpackage.ar0
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return k83.a;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final void invoke(Throwable th) {
                try {
                    completableFuture.complete((T) deferred.getCompleted());
                } catch (Throwable th2) {
                    completableFuture.completeExceptionally(th2);
                }
            }
        });
        return completableFuture;
    }

    public static final <T> Deferred<T> asDeferred(CompletionStage<T> completionStage) {
        Throwable cause;
        CompletableFuture<T> completableFuture = completionStage.toCompletableFuture();
        if (!completableFuture.isDone()) {
            final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            final or0 or0Var = new or0() { // from class: kotlinx.coroutines.future.FutureKt.asDeferred.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // defpackage.or0
                public final Object invoke(T t, Throwable th) {
                    boolean zCompleteExceptionally;
                    Throwable cause2;
                    try {
                        if (th == null) {
                            zCompleteExceptionally = completableDeferredCompletableDeferred$default.complete(t);
                        } else {
                            CompletableDeferred<T> completableDeferred = completableDeferredCompletableDeferred$default;
                            CompletionException completionException = th instanceof CompletionException ? (CompletionException) th : null;
                            if (completionException != null && (cause2 = completionException.getCause()) != null) {
                                th = cause2;
                            }
                            zCompleteExceptionally = completableDeferred.completeExceptionally(th);
                        }
                        return Boolean.valueOf(zCompleteExceptionally);
                    } catch (Throwable th2) {
                        CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th2);
                        return k83.a;
                    }
                }
            };
            completionStage.handle(new BiFunction() { // from class: ds0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return or0Var.invoke(obj, (Throwable) obj2);
                }
            });
            JobKt.cancelFutureOnCompletion(completableDeferredCompletableDeferred$default, completableFuture);
            return completableDeferredCompletableDeferred$default;
        }
        try {
            return CompletableDeferredKt.CompletableDeferred(completableFuture.get());
        } catch (Throwable th) {
            th = th;
            ExecutionException executionException = th instanceof ExecutionException ? (ExecutionException) th : null;
            if (executionException != null && (cause = executionException.getCause()) != null) {
                th = cause;
            }
            CompletableDeferred completableDeferredCompletableDeferred$default2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            completableDeferredCompletableDeferred$default2.completeExceptionally(th);
            return completableDeferredCompletableDeferred$default2;
        }
    }

    public static final <T> Object await(CompletionStage<T> completionStage, x30 x30Var) throws Throwable {
        final CompletableFuture<T> completableFuture = completionStage.toCompletableFuture();
        if (completableFuture.isDone()) {
            try {
                return completableFuture.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(a.c(x30Var), 1);
        cancellableContinuationImpl.initCancellability();
        final ContinuationHandler continuationHandler = new ContinuationHandler(cancellableContinuationImpl);
        completionStage.handle(continuationHandler);
        cancellableContinuationImpl.invokeOnCancellation(new ar0() { // from class: kotlinx.coroutines.future.FutureKt$await$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // defpackage.ar0
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return k83.a;
            }

            public final void invoke(Throwable th) {
                completableFuture.cancel(false);
                continuationHandler.cont = null;
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.d()) {
            j70.c(x30Var);
        }
        return result;
    }

    public static final <T> CompletableFuture<T> future(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, or0 or0Var) {
        if (coroutineStart.isLazy()) {
            throw new IllegalArgumentException((coroutineStart + " start is not supported").toString());
        }
        d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, dVar);
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        CompletableFutureCoroutine completableFutureCoroutine = new CompletableFutureCoroutine(dVarNewCoroutineContext, completableFuture);
        completableFuture.handle((BiFunction) completableFutureCoroutine);
        completableFutureCoroutine.start(coroutineStart, completableFutureCoroutine, or0Var);
        return completableFuture;
    }

    public static /* synthetic */ CompletableFuture future$default(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, or0 or0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return future(coroutineScope, dVar, coroutineStart, or0Var);
    }

    private static final void setupCancellation(final Job job, CompletableFuture<?> completableFuture) {
        completableFuture.handle(new BiFunction() { // from class: es0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return FutureKt.setupCancellation$lambda$2(job, obj, (Throwable) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 setupCancellation$lambda$2(Job job, Object obj, Throwable th) {
        CancellationException CancellationException = null;
        if (th != null) {
            CancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            if (CancellationException == null) {
                CancellationException = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", th);
            }
        }
        job.cancel(CancellationException);
        return k83.a;
    }

    public static final CompletableFuture<k83> asCompletableFuture(Job job) {
        final CompletableFuture<k83> completableFuture = new CompletableFuture<>();
        setupCancellation(job, completableFuture);
        job.invokeOnCompletion(new ar0() { // from class: kotlinx.coroutines.future.FutureKt.asCompletableFuture.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // defpackage.ar0
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return k83.a;
            }

            public final void invoke(Throwable th) {
                if (th == null) {
                    completableFuture.complete(k83.a);
                } else {
                    completableFuture.completeExceptionally(th);
                }
            }
        });
        return completableFuture;
    }
}
