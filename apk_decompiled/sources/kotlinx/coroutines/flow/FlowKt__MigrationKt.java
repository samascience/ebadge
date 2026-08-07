package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.qr0;
import defpackage.rr0;
import defpackage.sr0;
import defpackage.x30;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__MigrationKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1", f = "Migration.kt", l = {427}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ long $timeMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, x30 x30Var) {
            super(2, x30Var);
            this.$timeMillis = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.$timeMillis, x30Var);
        }

        @Override // defpackage.or0
        public final Object invoke(T t, x30 x30Var) {
            return ((AnonymousClass1) create(t, x30Var)).invokeSuspend(k83.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                long j = this.$timeMillis;
                this.label = 1;
                if (DelayKt.delay(j, this) == objD) {
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
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", f = "Migration.kt", l = {415}, m = "invokeSuspend")
    static final class C02401 extends SuspendLambda implements or0 {
        final /* synthetic */ long $timeMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02401(long j, x30 x30Var) {
            super(2, x30Var);
            this.$timeMillis = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new C02401(this.$timeMillis, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                long j = this.$timeMillis;
                this.label = 1;
                if (DelayKt.delay(j, this) == objD) {
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

        @Override // defpackage.or0
        public final Object invoke(FlowCollector<? super T> flowCollector, x30 x30Var) {
            return ((C02401) create(flowCollector, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", l = {306}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements pr0 {
        final /* synthetic */ T $fallback;
        final /* synthetic */ ar0 $predicate;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ar0 ar0Var, T t, x30 x30Var) {
            super(3, x30Var);
            this.$predicate = ar0Var;
            this.$fallback = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                if (!((Boolean) this.$predicate.invoke(th)).booleanValue()) {
                    throw th;
                }
                T t = this.$fallback;
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(t, this) == objD) {
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

        @Override // defpackage.pr0
        public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, x30 x30Var) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$predicate, this.$fallback, x30Var);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(k83.a);
        }
    }

    public static final <T> Flow<T> cache(Flow<? extends T> flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T1, T2, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, pr0 pr0Var) {
        return FlowKt.combine(flow, flow2, pr0Var);
    }

    public static final <T, R> Flow<R> compose(Flow<? extends T> flow, ar0 ar0Var) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T, R> Flow<R> concatMap(Flow<? extends T> flow, ar0 ar0Var) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> concatWith(Flow<? extends T> flow, T t) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> delayEach(Flow<? extends T> flow, long j) {
        return FlowKt.onEach(flow, new AnonymousClass1(j, null));
    }

    public static final <T> Flow<T> delayFlow(Flow<? extends T> flow, long j) {
        return FlowKt.onStart(flow, new C02401(j, null));
    }

    public static final <T, R> Flow<R> flatMap(Flow<? extends T> flow, or0 or0Var) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> flatten(Flow<? extends Flow<? extends T>> flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> void forEach(Flow<? extends T> flow, or0 or0Var) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> merge(Flow<? extends Flow<? extends T>> flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final Void noImpl() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    public static final <T> Flow<T> observeOn(Flow<? extends T> flow, kotlin.coroutines.d dVar) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> onErrorResume(Flow<? extends T> flow, Flow<? extends T> flow2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> onErrorResumeNext(Flow<? extends T> flow, Flow<? extends T> flow2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Flow onErrorReturn$default(Flow flow, Object obj, ar0 ar0Var, int i, Object obj2) {
        if ((i & 2) != 0) {
            ar0Var = new ar0() { // from class: kotlinx.coroutines.flow.FlowKt__MigrationKt.onErrorReturn.1
                @Override // defpackage.ar0
                public final Boolean invoke(Throwable th) {
                    return Boolean.TRUE;
                }
            };
        }
        return FlowKt.onErrorReturn(flow, obj, ar0Var);
    }

    public static final <T> Flow<T> publish(Flow<? extends T> flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> publishOn(Flow<? extends T> flow, kotlin.coroutines.d dVar) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> replay(Flow<? extends T> flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T, R> Flow<R> scanFold(Flow<? extends T> flow, R r, pr0 pr0Var) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> scanReduce(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt.runningReduce(flow, pr0Var);
    }

    public static final <T> Flow<T> skip(Flow<? extends T> flow, int i) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> startWith(Flow<? extends T> flow, T t) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> void subscribe(Flow<? extends T> flow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> subscribeOn(Flow<? extends T> flow, kotlin.coroutines.d dVar) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T, R> Flow<R> switchMap(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt.transformLatest(flow, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(or0Var, null));
    }

    public static final <T1, T2, T3, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, qr0 qr0Var) {
        return FlowKt.combine(flow, flow2, flow3, qr0Var);
    }

    public static final <T> Flow<T> concatWith(Flow<? extends T> flow, Flow<? extends T> flow2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t, ar0 ar0Var) {
        return FlowKt.m123catch(flow, new AnonymousClass2(ar0Var, t, null));
    }

    public static final <T> Flow<T> publish(Flow<? extends T> flow, int i) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> replay(Flow<? extends T> flow, int i) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> startWith(Flow<? extends T> flow, Flow<? extends T> flow2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> void subscribe(Flow<? extends T> flow, or0 or0Var) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, rr0 rr0Var) {
        return FlowKt.combine(flow, flow2, flow3, flow4, rr0Var);
    }

    public static final <T> void subscribe(Flow<? extends T> flow, or0 or0Var, or0 or0Var2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, sr0 sr0Var) {
        return FlowKt.combine(flow, flow2, flow3, flow4, flow5, sr0Var);
    }
}
