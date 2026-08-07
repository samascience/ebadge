package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: loaded from: classes4.dex */
final class StartedLazily implements SharingStarted {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedLazily$command$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", l = {155}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ StateFlow<Integer> $subscriptionCount;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StateFlow<Integer> stateFlow, x30 x30Var) {
            super(2, x30Var);
            this.$subscriptionCount = stateFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$subscriptionCount, x30Var);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                StateFlow<Integer> stateFlow = this.$subscriptionCount;
                C01361 c01361 = new C01361(ref$BooleanRef, flowCollector);
                this.label = 1;
                if (stateFlow.collect(c01361, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // defpackage.or0
        public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, x30 x30Var) {
            return ((AnonymousClass1) create(flowCollector, x30Var)).invokeSuspend(k83.a);
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01361<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<SharingCommand> $$this$flow;
            final /* synthetic */ Ref$BooleanRef $started;

            /* JADX WARN: Multi-variable type inference failed */
            C01361(Ref$BooleanRef ref$BooleanRef, FlowCollector<? super SharingCommand> flowCollector) {
                this.$started = ref$BooleanRef;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            public final Object emit(int i, x30 x30Var) throws Throwable {
                StartedLazily$command$1$1$emit$1 startedLazily$command$1$1$emit$1;
                if (x30Var instanceof StartedLazily$command$1$1$emit$1) {
                    startedLazily$command$1$1$emit$1 = (StartedLazily$command$1$1$emit$1) x30Var;
                    int i2 = startedLazily$command$1$1$emit$1.label;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        startedLazily$command$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
                    } else {
                        startedLazily$command$1$1$emit$1 = new StartedLazily$command$1$1$emit$1(this, x30Var);
                    }
                } else {
                    startedLazily$command$1$1$emit$1 = new StartedLazily$command$1$1$emit$1(this, x30Var);
                }
                Object obj = startedLazily$command$1$1$emit$1.result;
                Object objD = a.d();
                int i3 = startedLazily$command$1$1$emit$1.label;
                if (i3 == 0) {
                    d.b(obj);
                    if (i > 0) {
                        Ref$BooleanRef ref$BooleanRef = this.$started;
                        if (!ref$BooleanRef.element) {
                            ref$BooleanRef.element = true;
                            FlowCollector<SharingCommand> flowCollector = this.$$this$flow;
                            SharingCommand sharingCommand = SharingCommand.START;
                            startedLazily$command$1$1$emit$1.label = 1;
                            if (flowCollector.emit(sharingCommand, startedLazily$command$1$1$emit$1) == objD) {
                                return objD;
                            }
                        }
                    }
                    return k83.a;
                }
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
                return k83.a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, x30 x30Var) {
                return emit(((Number) obj).intValue(), x30Var);
            }
        }
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.flow(new AnonymousClass1(stateFlow, null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
