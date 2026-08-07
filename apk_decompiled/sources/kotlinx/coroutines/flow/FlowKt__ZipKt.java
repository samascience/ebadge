package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.pr0;
import defpackage.qr0;
import defpackage.rr0;
import defpackage.sr0;
import defpackage.tr0;
import defpackage.x30;
import defpackage.yq0;
import kotlin.collections.j;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__ZipKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f = "Zip.kt", l = {251}, m = "invokeSuspend")
    public static final class AnonymousClass6 extends SuspendLambda implements or0 {
        final /* synthetic */ Flow<T>[] $flows;
        final /* synthetic */ pr0 $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements yq0 {
            final /* synthetic */ Flow<T>[] $flows;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Flow<? extends T>[] flowArr) {
                super(0);
                this.$flows = flowArr;
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [T[], java.lang.Object[]] */
            @Override // defpackage.yq0
            public final T[] invoke() {
                int length = this.$flows.length;
                p31.k(0, "T?");
                return new Object[length];
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2, reason: invalid class name */
        @h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f = "Zip.kt", l = {251}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends SuspendLambda implements pr0 {
            final /* synthetic */ pr0 $transform;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(pr0 pr0Var, x30 x30Var) {
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
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, x30Var);
                anonymousClass2.L$0 = flowCollector;
                anonymousClass2.L$1 = tArr;
                return anonymousClass2.invokeSuspend(k83.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass6(Flow<? extends T>[] flowArr, pr0 pr0Var, x30 x30Var) {
            super(2, x30Var);
            this.$flows = flowArr;
            this.$transform = pr0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass6 anonymousClass6 = new AnonymousClass6(this.$flows, this.$transform, x30Var);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Flow<T>[] flowArr = this.$flows;
                p31.j();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flows);
                p31.j();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
                this.label = 1;
                if (CombineKt.combineInternal(flowCollector, flowArr, anonymousClass1, anonymousClass2, this) == objD) {
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
            p31.j();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flows);
            p31.j();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
            j21.c(0);
            CombineKt.combineInternal(flowCollector, flowArr, anonymousClass1, anonymousClass2, this);
            j21.c(1);
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(FlowCollector<? super R> flowCollector, x30 x30Var) {
            return ((AnonymousClass6) create(flowCollector, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", l = {308}, m = "invokeSuspend")
    public static final class AnonymousClass7 extends SuspendLambda implements or0 {
        final /* synthetic */ Flow<T>[] $flowArray;
        final /* synthetic */ pr0 $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements yq0 {
            final /* synthetic */ Flow<T>[] $flowArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Flow<T>[] flowArr) {
                super(0);
                this.$flowArray = flowArr;
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [T[], java.lang.Object[]] */
            @Override // defpackage.yq0
            public final T[] invoke() {
                int length = this.$flowArray.length;
                p31.k(0, "T?");
                return new Object[length];
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2, reason: invalid class name */
        @h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", l = {308}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends SuspendLambda implements pr0 {
            final /* synthetic */ pr0 $transform;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(pr0 pr0Var, x30 x30Var) {
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
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, x30Var);
                anonymousClass2.L$0 = flowCollector;
                anonymousClass2.L$1 = tArr;
                return anonymousClass2.invokeSuspend(k83.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(Flow<T>[] flowArr, pr0 pr0Var, x30 x30Var) {
            super(2, x30Var);
            this.$flowArray = flowArr;
            this.$transform = pr0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass7 anonymousClass7 = new AnonymousClass7(this.$flowArray, this.$transform, x30Var);
            anonymousClass7.L$0 = obj;
            return anonymousClass7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Flow<T>[] flowArr = this.$flowArray;
                p31.j();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
                p31.j();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
                this.label = 1;
                if (CombineKt.combineInternal(flowCollector, flowArr, anonymousClass1, anonymousClass2, this) == objD) {
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
            Flow<T>[] flowArr = this.$flowArray;
            p31.j();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
            p31.j();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
            j21.c(0);
            CombineKt.combineInternal(flowCollector, flowArr, anonymousClass1, anonymousClass2, this);
            j21.c(1);
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(FlowCollector<? super R> flowCollector, x30 x30Var) {
            return ((AnonymousClass7) create(flowCollector, x30Var)).invokeSuspend(k83.a);
        }
    }

    public static final <T1, T2, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, pr0 pr0Var) {
        return FlowKt.flowCombine(flow, flow2, pr0Var);
    }

    public static final <T1, T2, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, qr0 qr0Var) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2(new Flow[]{flow, flow2}, null, qr0Var));
    }

    private static final /* synthetic */ <T, R> Flow<R> combineTransformUnsafe$FlowKt__ZipKt(Flow<? extends T>[] flowArr, pr0 pr0Var) {
        p31.j();
        return FlowKt.flow(new FlowKt__ZipKt$combineTransformUnsafe$1(flowArr, pr0Var, null));
    }

    private static final /* synthetic */ <T, R> Flow<R> combineUnsafe$FlowKt__ZipKt(Flow<? extends T>[] flowArr, or0 or0Var) {
        p31.j();
        return new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(flowArr, or0Var);
    }

    public static final <T1, T2, R> Flow<R> flowCombine(final Flow<? extends T1> flow, final Flow<? extends T2> flow2, final pr0 pr0Var) {
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super R> flowCollector, x30 x30Var) {
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, new Flow[]{flow, flow2}, new yq0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // defpackage.yq0
                    public final Void invoke() {
                        return null;
                    }
                }, new FlowKt__ZipKt$combine$1$1(pr0Var, null), x30Var);
                return objCombineInternal == a.d() ? objCombineInternal : k83.a;
            }
        };
    }

    public static final <T1, T2, R> Flow<R> flowCombineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, qr0 qr0Var) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1(new Flow[]{flow, flow2}, null, qr0Var));
    }

    public static final <T1, T2, R> Flow<R> zip(Flow<? extends T1> flow, Flow<? extends T2> flow2, pr0 pr0Var) {
        return CombineKt.zipImpl(flow, flow2, pr0Var);
    }

    public static final <T1, T2, T3, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, final qr0 qr0Var) {
        final Flow[] flowArr = {flow, flow2, flow3};
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2, reason: invalid class name */
            @h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", l = {333, 262}, m = "invokeSuspend")
            public static final class AnonymousClass2 extends SuspendLambda implements pr0 {
                final /* synthetic */ qr0 $transform$inlined;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(x30 x30Var, qr0 qr0Var) {
                    super(3, x30Var);
                    this.$transform$inlined = qr0Var;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    FlowCollector flowCollector;
                    Object objD = a.d();
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            flowCollector = (FlowCollector) this.L$0;
                            d.b(obj);
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            d.b(obj);
                        }
                        return k83.a;
                    }
                    d.b(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    qr0 qr0Var = this.$transform$inlined;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    this.L$0 = flowCollector;
                    this.label = 1;
                    j21.c(6);
                    obj = qr0Var.invoke(obj2, obj3, obj4, this);
                    j21.c(7);
                    if (obj == objD) {
                        return objD;
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (flowCollector.emit(obj, this) == objD) {
                        return objD;
                    }
                    return k83.a;
                }

                @Override // defpackage.pr0
                public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objArr, x30 x30Var) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(x30Var, this.$transform$inlined);
                    anonymousClass2.L$0 = flowCollector;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(k83.a);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, x30 x30Var) {
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr, new yq0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // defpackage.yq0
                    public final Void invoke() {
                        return null;
                    }
                }, new AnonymousClass2(null, qr0Var), x30Var);
                return objCombineInternal == a.d() ? objCombineInternal : k83.a;
            }
        };
    }

    public static final <T1, T2, T3, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, rr0 rr0Var) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(new Flow[]{flow, flow2, flow3}, null, rr0Var));
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, final rr0 rr0Var) {
        final Flow[] flowArr = {flow, flow2, flow3, flow4};
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2, reason: invalid class name */
            @h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", l = {333, 262}, m = "invokeSuspend")
            public static final class AnonymousClass2 extends SuspendLambda implements pr0 {
                final /* synthetic */ rr0 $transform$inlined;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(x30 x30Var, rr0 rr0Var) {
                    super(3, x30Var);
                    this.$transform$inlined = rr0Var;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    FlowCollector flowCollector;
                    Object objD = a.d();
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            flowCollector = (FlowCollector) this.L$0;
                            d.b(obj);
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            d.b(obj);
                        }
                        return k83.a;
                    }
                    d.b(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    rr0 rr0Var = this.$transform$inlined;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    this.L$0 = flowCollector;
                    this.label = 1;
                    j21.c(6);
                    obj = rr0Var.invoke(obj2, obj3, obj4, obj5, this);
                    j21.c(7);
                    if (obj == objD) {
                        return objD;
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (flowCollector.emit(obj, this) == objD) {
                        return objD;
                    }
                    return k83.a;
                }

                @Override // defpackage.pr0
                public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objArr, x30 x30Var) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(x30Var, this.$transform$inlined);
                    anonymousClass2.L$0 = flowCollector;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(k83.a);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, x30 x30Var) {
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr, new yq0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // defpackage.yq0
                    public final Void invoke() {
                        return null;
                    }
                }, new AnonymousClass2(null, rr0Var), x30Var);
                return objCombineInternal == a.d() ? objCombineInternal : k83.a;
            }
        };
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, sr0 sr0Var) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(new Flow[]{flow, flow2, flow3, flow4}, null, sr0Var));
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, final sr0 sr0Var) {
        final Flow[] flowArr = {flow, flow2, flow3, flow4, flow5};
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2, reason: invalid class name */
            @h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", l = {333, 262}, m = "invokeSuspend")
            public static final class AnonymousClass2 extends SuspendLambda implements pr0 {
                final /* synthetic */ sr0 $transform$inlined;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(x30 x30Var, sr0 sr0Var) {
                    super(3, x30Var);
                    this.$transform$inlined = sr0Var;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    FlowCollector flowCollector;
                    Object objD = a.d();
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            flowCollector = (FlowCollector) this.L$0;
                            d.b(obj);
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            d.b(obj);
                        }
                        return k83.a;
                    }
                    d.b(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    sr0 sr0Var = this.$transform$inlined;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    Object obj6 = objArr[4];
                    this.L$0 = flowCollector;
                    this.label = 1;
                    j21.c(6);
                    obj = sr0Var.invoke(obj2, obj3, obj4, obj5, obj6, this);
                    j21.c(7);
                    if (obj == objD) {
                        return objD;
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (flowCollector.emit(obj, this) == objD) {
                        return objD;
                    }
                    return k83.a;
                }

                @Override // defpackage.pr0
                public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objArr, x30 x30Var) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(x30Var, this.$transform$inlined);
                    anonymousClass2.L$0 = flowCollector;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(k83.a);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, x30 x30Var) {
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr, new yq0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // defpackage.yq0
                    public final Void invoke() {
                        return null;
                    }
                }, new AnonymousClass2(null, sr0Var), x30Var);
                return objCombineInternal == a.d() ? objCombineInternal : k83.a;
            }
        };
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, tr0 tr0Var) {
        return FlowKt.flow(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(new Flow[]{flow, flow2, flow3, flow4, flow5}, null, tr0Var));
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Iterable<? extends Flow<? extends T>> iterable, or0 or0Var) {
        Flow[] flowArr = (Flow[]) j.X(iterable).toArray(new Flow[0]);
        p31.j();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(flowArr, or0Var);
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Flow<? extends T>[] flowArr, pr0 pr0Var) {
        p31.j();
        return FlowKt.flow(new AnonymousClass6(flowArr, pr0Var, null));
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Iterable<? extends Flow<? extends T>> iterable, pr0 pr0Var) {
        Flow[] flowArr = (Flow[]) j.X(iterable).toArray(new Flow[0]);
        p31.j();
        return FlowKt.flow(new AnonymousClass7(flowArr, pr0Var, null));
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Flow<? extends T>[] flowArr, or0 or0Var) {
        p31.j();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(flowArr, or0Var);
    }
}
