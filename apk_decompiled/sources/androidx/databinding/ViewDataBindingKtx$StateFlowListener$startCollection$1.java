package androidx.databinding;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import defpackage.db1;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1", f = "ViewDataBindingKtx.kt", l = {95}, m = "invokeSuspend")
final class ViewDataBindingKtx$StateFlowListener$startCollection$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Flow<Object> $flow;
    final /* synthetic */ db1 $owner;
    int label;
    final /* synthetic */ l this$0;

    /* JADX INFO: renamed from: androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1, reason: invalid class name */
    @h70(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1", f = "ViewDataBindingKtx.kt", l = {96}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ Flow<Object> $flow;
        int label;
        final /* synthetic */ l this$0;

        /* JADX INFO: renamed from: androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1$a */
        static final class a implements FlowCollector {
            a(l lVar) {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, x30 x30Var) {
                ViewDataBinding viewDataBindingA = l.b(null).a();
                if (viewDataBindingA != null) {
                    viewDataBindingA.n(l.b(null).b, l.b(null).b(), 0);
                }
                return k83.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Flow<? extends Object> flow, l lVar, x30 x30Var) {
            super(2, x30Var);
            this.$flow = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.$flow, null, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = kotlin.coroutines.intrinsics.a.d();
            int i = this.label;
            if (i == 0) {
                kotlin.d.b(obj);
                Flow<Object> flow = this.$flow;
                a aVar = new a(null);
                this.label = 1;
                if (flow.collect(aVar, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.d.b(obj);
            }
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewDataBindingKtx$StateFlowListener$startCollection$1(db1 db1Var, Flow<? extends Object> flow, l lVar, x30 x30Var) {
        super(2, x30Var);
        this.$owner = db1Var;
        this.$flow = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new ViewDataBindingKtx$StateFlowListener$startCollection$1(this.$owner, this.$flow, null, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            kotlin.d.b(obj);
            Lifecycle lifecycle = this.$owner.getLifecycle();
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flow, null, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.d.b(obj);
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((ViewDataBindingKtx$StateFlowListener$startCollection$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
