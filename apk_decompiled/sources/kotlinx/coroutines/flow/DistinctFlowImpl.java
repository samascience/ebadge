package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes4.dex */
final class DistinctFlowImpl<T> implements Flow<T> {
    public final or0 areEquivalent;
    public final ar0 keySelector;
    private final Flow<T> upstream;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2, reason: invalid class name */
    static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<T> $collector;
        final /* synthetic */ Ref$ObjectRef<Object> $previousKey;
        final /* synthetic */ DistinctFlowImpl<T> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(DistinctFlowImpl<T> distinctFlowImpl, Ref$ObjectRef<Object> ref$ObjectRef, FlowCollector<? super T> flowCollector) {
            this.this$0 = distinctFlowImpl;
            this.$previousKey = ref$ObjectRef;
            this.$collector = flowCollector;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
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
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, x30 x30Var) throws Throwable {
            DistinctFlowImpl$collect$2$emit$1 distinctFlowImpl$collect$2$emit$1;
            if (x30Var instanceof DistinctFlowImpl$collect$2$emit$1) {
                distinctFlowImpl$collect$2$emit$1 = (DistinctFlowImpl$collect$2$emit$1) x30Var;
                int i = distinctFlowImpl$collect$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    distinctFlowImpl$collect$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, x30Var);
                }
            } else {
                distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, x30Var);
            }
            Object obj = distinctFlowImpl$collect$2$emit$1.result;
            Object objD = a.d();
            int i2 = distinctFlowImpl$collect$2$emit$1.label;
            if (i2 == 0) {
                d.b(obj);
                T t2 = (T) this.this$0.keySelector.invoke(t);
                Object obj2 = this.$previousKey.element;
                if (obj2 != NullSurrogateKt.NULL && ((Boolean) this.this$0.areEquivalent.invoke(obj2, t2)).booleanValue()) {
                    return k83.a;
                }
                this.$previousKey.element = t2;
                FlowCollector<T> flowCollector = this.$collector;
                distinctFlowImpl$collect$2$emit$1.label = 1;
                if (flowCollector.emit(t, distinctFlowImpl$collect$2$emit$1) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return k83.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(Flow<? extends T> flow, ar0 ar0Var, or0 or0Var) {
        this.upstream = flow;
        this.keySelector = ar0Var;
        this.areEquivalent = or0Var;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = (T) NullSurrogateKt.NULL;
        Object objCollect = this.upstream.collect(new AnonymousClass2(this, ref$ObjectRef, flowCollector), x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }
}
