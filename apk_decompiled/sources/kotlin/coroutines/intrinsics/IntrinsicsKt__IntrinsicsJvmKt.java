package kotlin.coroutines.intrinsics;

import defpackage.ar0;
import defpackage.j70;
import defpackage.or0;
import defpackage.p31;
import defpackage.p63;
import defpackage.x30;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static x30 a(final ar0 ar0Var, x30 x30Var) {
        p31.f(ar0Var, "<this>");
        p31.f(x30Var, "completion");
        final x30 x30VarA = j70.a(x30Var);
        if (ar0Var instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) ar0Var).create(x30VarA);
        }
        final d context = x30VarA.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(x30VarA, ar0Var) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
            final /* synthetic */ ar0 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(x30VarA);
                this.$this_createCoroutineUnintercepted$inlined = ar0Var;
                p31.d(x30VarA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) throws Throwable {
                int i = this.label;
                if (i == 0) {
                    this.label = 1;
                    kotlin.d.b(obj);
                    p31.d(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((ar0) p63.a(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
                }
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                kotlin.d.b(obj);
                return obj;
            }
        } : new ContinuationImpl(x30VarA, context, ar0Var) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            final /* synthetic */ ar0 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(x30VarA, context);
                this.$this_createCoroutineUnintercepted$inlined = ar0Var;
                p31.d(x30VarA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) throws Throwable {
                int i = this.label;
                if (i == 0) {
                    this.label = 1;
                    kotlin.d.b(obj);
                    p31.d(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((ar0) p63.a(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
                }
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                kotlin.d.b(obj);
                return obj;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static x30 b(final or0 or0Var, final Object obj, x30 x30Var) {
        p31.f(or0Var, "<this>");
        p31.f(x30Var, "completion");
        final x30 x30VarA = j70.a(x30Var);
        if (or0Var instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) or0Var).create(obj, x30VarA);
        }
        final d context = x30VarA.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(x30VarA, or0Var, obj) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ or0 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(x30VarA);
                this.$this_createCoroutineUnintercepted$inlined = or0Var;
                this.$receiver$inlined = obj;
                p31.d(x30VarA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj2) throws Throwable {
                int i = this.label;
                if (i == 0) {
                    this.label = 1;
                    kotlin.d.b(obj2);
                    p31.d(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((or0) p63.a(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                }
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                kotlin.d.b(obj2);
                return obj2;
            }
        } : new ContinuationImpl(x30VarA, context, or0Var, obj) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ or0 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(x30VarA, context);
                this.$this_createCoroutineUnintercepted$inlined = or0Var;
                this.$receiver$inlined = obj;
                p31.d(x30VarA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj2) throws Throwable {
                int i = this.label;
                if (i == 0) {
                    this.label = 1;
                    kotlin.d.b(obj2);
                    p31.d(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((or0) p63.a(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                }
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                kotlin.d.b(obj2);
                return obj2;
            }
        };
    }

    public static x30 c(x30 x30Var) {
        x30 x30VarIntercepted;
        p31.f(x30Var, "<this>");
        ContinuationImpl continuationImpl = x30Var instanceof ContinuationImpl ? (ContinuationImpl) x30Var : null;
        return (continuationImpl == null || (x30VarIntercepted = continuationImpl.intercepted()) == null) ? x30Var : x30VarIntercepted;
    }
}
