package kotlinx.coroutines;

import defpackage.be0;
import defpackage.de0;
import defpackage.h70;
import defpackage.j70;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: loaded from: classes4.dex */
public final class TimeoutKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {104}, m = "withTimeoutOrNull")
    static final class AnonymousClass1<T> extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TimeoutKt.withTimeoutOrNull(0L, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x0018, please report this as an issue */
    public static final TimeoutCancellationException TimeoutCancellationException(long j, Delay delay, Job job) {
        String strM83timeoutMessageLRDsOJo;
        DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics = delay instanceof DelayWithTimeoutDiagnostics ? (DelayWithTimeoutDiagnostics) delay : null;
        if (delayWithTimeoutDiagnostics != null) {
            be0.a aVar = be0.a;
            strM83timeoutMessageLRDsOJo = delayWithTimeoutDiagnostics.m83timeoutMessageLRDsOJo(de0.h(j, DurationUnit.MILLISECONDS));
            if (strM83timeoutMessageLRDsOJo == null) {
                strM83timeoutMessageLRDsOJo = "Timed out waiting for " + j + " ms";
            }
        } else {
            strM83timeoutMessageLRDsOJo = "Timed out waiting for " + j + " ms";
        }
        return new TimeoutCancellationException(strM83timeoutMessageLRDsOJo, job);
    }

    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, or0 or0Var) {
        JobKt.disposeOnCompletion(timeoutCoroutine, DelayKt.getDelay(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine, timeoutCoroutine, or0Var);
    }

    public static final <T> Object withTimeout(long j, or0 or0Var, x30 x30Var) {
        if (j <= 0) {
            throw new TimeoutCancellationException("Timed out immediately");
        }
        Object obj = setupTimeout(new TimeoutCoroutine(j, x30Var), or0Var);
        if (obj == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        return obj;
    }

    /* JADX INFO: renamed from: withTimeout-KLykuaI, reason: not valid java name */
    public static final <T> Object m90withTimeoutKLykuaI(long j, or0 or0Var, x30 x30Var) {
        return withTimeout(DelayKt.m82toDelayMillisLRDsOJo(j), or0Var, x30Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.TimeoutCoroutine] */
    public static final <T> Object withTimeoutOrNull(long j, or0 or0Var, x30 x30Var) {
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
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            d.b(obj);
            if (j <= 0) {
                return null;
            }
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            try {
                anonymousClass1.L$0 = or0Var;
                anonymousClass1.L$1 = ref$ObjectRef2;
                anonymousClass1.J$0 = j;
                anonymousClass1.label = 1;
                ?? r2 = (T) new TimeoutCoroutine(j, anonymousClass1);
                ref$ObjectRef2.element = r2;
                Object obj2 = setupTimeout(r2, or0Var);
                if (obj2 == kotlin.coroutines.intrinsics.a.d()) {
                    j70.c(anonymousClass1);
                }
                return obj2 == objD ? objD : obj2;
            } catch (TimeoutCancellationException e) {
                e = e;
                ref$ObjectRef = ref$ObjectRef2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) anonymousClass1.L$1;
            try {
                d.b(obj);
                return obj;
            } catch (TimeoutCancellationException e2) {
                e = e2;
            }
        }
        if (e.coroutine == ref$ObjectRef.element) {
            return null;
        }
        throw e;
    }

    /* JADX INFO: renamed from: withTimeoutOrNull-KLykuaI, reason: not valid java name */
    public static final <T> Object m91withTimeoutOrNullKLykuaI(long j, or0 or0Var, x30 x30Var) {
        return withTimeoutOrNull(DelayKt.m82toDelayMillisLRDsOJo(j), or0Var, x30Var);
    }
}
