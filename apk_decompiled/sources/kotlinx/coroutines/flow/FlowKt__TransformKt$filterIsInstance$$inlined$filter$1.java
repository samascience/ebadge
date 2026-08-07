package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j21;
import defpackage.k83;
import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 implements Flow<Object> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1, reason: invalid class name */
        @h70(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2", f = "Transform.kt", l = {223}, m = "emit")
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(x30 x30Var) {
                super(x30Var);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector) {
            this.$this_unsafeFlow = flowCollector;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, x30 x30Var) throws Throwable {
            AnonymousClass1 anonymousClass1;
            if (x30Var instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) x30Var;
                int i = anonymousClass1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label = i - Integer.MIN_VALUE;
                } else {
                    anonymousClass1 = new AnonymousClass1(x30Var);
                }
            } else {
                anonymousClass1 = new AnonymousClass1(x30Var);
            }
            Object obj2 = anonymousClass1.result;
            Object objD = a.d();
            int i2 = anonymousClass1.label;
            if (i2 == 0) {
                d.b(obj2);
                FlowCollector flowCollector = this.$this_unsafeFlow;
                p31.k(3, "R");
                if (obj != null) {
                    anonymousClass1.label = 1;
                    if (flowCollector.emit(obj, anonymousClass1) == objD) {
                        return objD;
                    }
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj2);
            }
            return k83.a;
        }

        public final Object emit$$forInline(Object obj, x30 x30Var) {
            j21.c(4);
            new AnonymousClass1(x30Var);
            j21.c(5);
            FlowCollector flowCollector = this.$this_unsafeFlow;
            p31.k(3, "R");
            if (obj != null) {
                j21.c(0);
                flowCollector.emit(obj, x30Var);
                j21.c(1);
            }
            return k83.a;
        }
    }

    public FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(Flow flow) {
        this.$this_unsafeTransform$inlined = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super Object> flowCollector, x30 x30Var) {
        Flow flow = this.$this_unsafeTransform$inlined;
        p31.j();
        Object objCollect = flow.collect(new AnonymousClass2(flowCollector), x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    public Object collect$$forInline(FlowCollector flowCollector, x30 x30Var) {
        j21.c(4);
        new ContinuationImpl(x30Var) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.this.collect(null, this);
            }
        };
        j21.c(5);
        Flow flow = this.$this_unsafeTransform$inlined;
        p31.j();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector);
        j21.c(0);
        flow.collect(anonymousClass2, x30Var);
        j21.c(1);
        return k83.a;
    }
}
