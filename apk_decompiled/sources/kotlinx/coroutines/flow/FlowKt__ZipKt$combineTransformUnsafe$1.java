package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.pr0;
import defpackage.x30;
import defpackage.yq0;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", f = "Zip.kt", l = {273}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combineTransformUnsafe$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Flow<T>[] $flows;
    final /* synthetic */ pr0 $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", f = "Zip.kt", l = {273}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements pr0 {
        final /* synthetic */ pr0 $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(pr0 pr0Var, x30 x30Var) {
            super(3, x30Var);
            this.$transform = pr0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                pr0 pr0Var = this.$transform;
                this.L$0 = null;
                this.label = 1;
                if (pr0Var.invoke(flowCollector, objArr, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return k83.a;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            this.$transform.invoke((FlowCollector) this.L$0, (Object[]) this.L$1, this);
            return k83.a;
        }

        @Override // defpackage.pr0
        public final Object invoke(FlowCollector<? super R> flowCollector, T[] tArr, x30 x30Var) {
            p31.j();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, x30Var);
            anonymousClass1.L$0 = flowCollector;
            anonymousClass1.L$1 = tArr;
            return anonymousClass1.invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransformUnsafe$1(Flow<? extends T>[] flowArr, pr0 pr0Var, x30 x30Var) {
        super(2, x30Var);
        this.$flows = flowArr;
        this.$transform = pr0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        FlowKt__ZipKt$combineTransformUnsafe$1 flowKt__ZipKt$combineTransformUnsafe$1 = new FlowKt__ZipKt$combineTransformUnsafe$1(this.$flows, this.$transform, x30Var);
        flowKt__ZipKt$combineTransformUnsafe$1.L$0 = obj;
        return flowKt__ZipKt$combineTransformUnsafe$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow<T>[] flowArr = this.$flows;
            yq0 yq0Var = new yq0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                @Override // defpackage.yq0
                public final Void invoke() {
                    return null;
                }
            };
            p31.j();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, null);
            this.label = 1;
            if (CombineKt.combineInternal(flowCollector, flowArr, yq0Var, anonymousClass1, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        return k83.a;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Flow<T>[] flowArr = this.$flows;
        yq0 yq0Var = new yq0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
            @Override // defpackage.yq0
            public final Void invoke() {
                return null;
            }
        };
        p31.j();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, null);
        j21.c(0);
        CombineKt.combineInternal(flowCollector, flowArr, yq0Var, anonymousClass1, this);
        j21.c(1);
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(FlowCollector<? super R> flowCollector, x30 x30Var) {
        return ((FlowKt__ZipKt$combineTransformUnsafe$1) create(flowCollector, x30Var)).invokeSuspend(k83.a);
    }
}
