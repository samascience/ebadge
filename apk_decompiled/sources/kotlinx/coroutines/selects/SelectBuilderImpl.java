package kotlinx.coroutines.selects;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.Result;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: classes4.dex */
public final class SelectBuilderImpl<R> extends SelectImplementation<R> {
    private final CancellableContinuationImpl<R> cont;

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.SelectBuilderImpl$getResult$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.selects.SelectBuilderImpl$getResult$1", f = "SelectOld.kt", l = {43}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        int label;
        final /* synthetic */ SelectBuilderImpl<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SelectBuilderImpl<R> selectBuilderImpl, x30 x30Var) {
            super(2, x30Var);
            this.this$0 = selectBuilderImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.this$0, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            try {
                if (i == 0) {
                    d.b(obj);
                    SelectBuilderImpl<R> selectBuilderImpl = this.this$0;
                    this.label = 1;
                    obj = selectBuilderImpl.doSelect(this);
                    if (obj == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj);
                }
                SelectOldKt.resumeUndispatched(((SelectBuilderImpl) this.this$0).cont, obj);
                return k83.a;
            } catch (Throwable th) {
                SelectOldKt.resumeUndispatchedWithException(((SelectBuilderImpl) this.this$0).cont, th);
                return k83.a;
            }
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    public SelectBuilderImpl(x30 x30Var) {
        super(x30Var.getContext());
        this.cont = new CancellableContinuationImpl<>(a.c(x30Var), 1);
    }

    public final Object getResult() {
        if (this.cont.isCompleted()) {
            return this.cont.getResult();
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(getContext()), null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, null), 1, null);
        return this.cont.getResult();
    }

    public final void handleBuilderException(Throwable th) {
        CancellableContinuationImpl<R> cancellableContinuationImpl = this.cont;
        Result.a aVar = Result.Companion;
        cancellableContinuationImpl.resumeWith(Result.m69constructorimpl(d.a(th)));
    }
}
