package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.oi0;
import defpackage.or0;
import defpackage.p31;
import defpackage.pr0;
import defpackage.qr0;
import defpackage.x30;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__ErrorsKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", l = {156}, m = "catchImpl")
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.catchImpl(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2, reason: invalid class name */
    static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<T> $collector;
        final /* synthetic */ Ref$ObjectRef<Throwable> $fromDownstream;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(FlowCollector<? super T> flowCollector, Ref$ObjectRef<Throwable> ref$ObjectRef) {
            this.$collector = flowCollector;
            this.$fromDownstream = ref$ObjectRef;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, x30 x30Var) throws Throwable {
            FlowKt__ErrorsKt$catchImpl$2$emit$1 flowKt__ErrorsKt$catchImpl$2$emit$1;
            AnonymousClass2<T> anonymousClass2;
            if (x30Var instanceof FlowKt__ErrorsKt$catchImpl$2$emit$1) {
                flowKt__ErrorsKt$catchImpl$2$emit$1 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) x30Var;
                int i = flowKt__ErrorsKt$catchImpl$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ErrorsKt$catchImpl$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ErrorsKt$catchImpl$2$emit$1 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, x30Var);
                }
            } else {
                flowKt__ErrorsKt$catchImpl$2$emit$1 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, x30Var);
            }
            Object obj = flowKt__ErrorsKt$catchImpl$2$emit$1.result;
            Object objD = a.d();
            int i2 = flowKt__ErrorsKt$catchImpl$2$emit$1.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                anonymousClass2 = (AnonymousClass2) flowKt__ErrorsKt$catchImpl$2$emit$1.L$0;
                try {
                    d.b(obj);
                    return k83.a;
                } catch (Throwable 
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                    	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:372)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:335)
                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    this = this;
                    boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
                    if (r0 == 0) goto L13
                    r0 = r6
                    kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L37
                    if (r2 != r3) goto L2f
                    java.lang.Object r5 = r0.L$0
                    kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r5 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.AnonymousClass2) r5
                    kotlin.d.b(r6)     // Catch: java.lang.Throwable -> L2d
                    goto L47
                L2d:
                    r6 = move-exception
                    goto L4c
                L2f:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L37:
                    kotlin.d.b(r6)
                    kotlinx.coroutines.flow.FlowCollector<T> r6 = r4.$collector     // Catch: java.lang.Throwable -> L4a
                    r0.L$0 = r4     // Catch: java.lang.Throwable -> L4a
                    r0.label = r3     // Catch: java.lang.Throwable -> L4a
                    java.lang.Object r5 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L4a
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    k83 r5 = defpackage.k83.a
                    return r5
                L4a:
                    r6 = move-exception
                    r5 = r4
                L4c:
                    kotlin.jvm.internal.Ref$ObjectRef<java.lang.Throwable> r5 = r5.$fromDownstream
                    r5.element = r6
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.AnonymousClass2.emit(java.lang.Object, x30):java.lang.Object");
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1, reason: invalid class name and case insensitive filesystem */
        @h70(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", f = "Errors.kt", l = {}, m = "invokeSuspend")
        static final class C02371 extends SuspendLambda implements or0 {
            int label;

            C02371(x30 x30Var) {
                super(2, x30Var);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final x30 create(Object obj, x30 x30Var) {
                return new C02371(x30Var);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                a.d();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
                return jn.a(true);
            }

            @Override // defpackage.or0
            public final Object invoke(Throwable th, x30 x30Var) {
                return ((C02371) create(th, x30Var)).invokeSuspend(k83.a);
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3, reason: invalid class name */
        @h70(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", l = {95}, m = "invokeSuspend")
        static final class AnonymousClass3 extends SuspendLambda implements qr0 {
            final /* synthetic */ or0 $predicate;
            final /* synthetic */ long $retries;
            /* synthetic */ long J$0;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(long j, or0 or0Var, x30 x30Var) {
                super(4, x30Var);
                this.$retries = j;
                this.$predicate = or0Var;
            }

            @Override // defpackage.qr0
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return invoke((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (x30) obj4);
            }

            /* JADX WARN: Code duplicated, block: B:16:0x003a  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = a.d();
                int i = this.label;
                if (i == 0) {
                    d.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    if (this.J$0 < this.$retries) {
                        or0 or0Var = this.$predicate;
                        this.label = 1;
                        obj = or0Var.invoke(th, this);
                        if (obj == objD) {
                            return objD;
                        }
                    }
                    return jn.a(z);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
                boolean z = ((Boolean) obj).booleanValue();
                return jn.a(z);
            }

            public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, long j, x30 x30Var) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$retries, this.$predicate, x30Var);
                anonymousClass3.L$0 = th;
                anonymousClass3.J$0 = j;
                return anonymousClass3.invokeSuspend(k83.a);
            }
        }

        /* JADX INFO: renamed from: catch, reason: not valid java name */
        public static final <T> Flow<T> m134catch(Flow<? extends T> flow, pr0 pr0Var) {
            return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(flow, pr0Var);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public static final <T> Object catchImpl(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, x30 x30Var) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Ref$ObjectRef ref$ObjectRef;
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
            Object obj = anonymousClass1.result;
            Object objD = a.d();
            int i2 = anonymousClass1.label;
            if (i2 == 0) {
                d.b(obj);
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                try {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, ref$ObjectRef2);
                    anonymousClass1.L$0 = ref$ObjectRef2;
                    anonymousClass1.label = 1;
                    if (flow.collect(anonymousClass2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    ref$ObjectRef = ref$ObjectRef2;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$ObjectRef = (Ref$ObjectRef) anonymousClass1.L$0;
                try {
                    d.b(obj);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Throwable th3 = (Throwable) ref$ObjectRef.element;
            if (isSameExceptionAs$FlowKt__ErrorsKt(th, th3) || isCancellationCause$FlowKt__ErrorsKt(th, anonymousClass1.getContext())) {
                throw th;
            }
            if (th3 == null) {
                return th;
            }
            if (th instanceof CancellationException) {
                oi0.a(th3, th);
                throw th3;
            }
            oi0.a(th, th3);
            throw th;
        }

        private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable th, kotlin.coroutines.d dVar) {
            Job job = (Job) dVar.get(Job.Key);
            if (job == null || !job.isCancelled()) {
                return false;
            }
            return isSameExceptionAs$FlowKt__ErrorsKt(th, job.getCancellationException());
        }

        private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable th, Throwable th2) {
            return th2 != null && p31.a(th2, th);
        }

        public static final <T> Flow<T> retry(Flow<? extends T> flow, long j, or0 or0Var) {
            if (j > 0) {
                return FlowKt.retryWhen(flow, new AnonymousClass3(j, or0Var, null));
            }
            throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j).toString());
        }

        public static /* synthetic */ Flow retry$default(Flow flow, long j, or0 or0Var, int i, Object obj) {
            if ((i & 1) != 0) {
                j = Long.MAX_VALUE;
            }
            if ((i & 2) != 0) {
                or0Var = new C02371(null);
            }
            return FlowKt.retry(flow, j, or0Var);
        }

        public static final <T> Flow<T> retryWhen(Flow<? extends T> flow, qr0 qr0Var) {
            return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(flow, qr0Var);
        }
    }
