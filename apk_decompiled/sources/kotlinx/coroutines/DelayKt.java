package kotlinx.coroutines;

import defpackage.be0;
import defpackage.ga2;
import defpackage.h70;
import defpackage.j70;
import defpackage.k83;
import defpackage.x30;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
public final class DelayKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.DelayKt$awaitCancellation$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", l = {163}, m = "awaitCancellation")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DelayKt.awaitCancellation(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitCancellation(x30 x30Var) throws Throwable {
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
        Object obj = anonymousClass1.result;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            d.b(obj);
            anonymousClass1.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.a.c(anonymousClass1), 1);
            cancellableContinuationImpl.initCancellability();
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.d()) {
                j70.c(anonymousClass1);
            }
            if (result == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    public static final Object delay(long j, x30 x30Var) {
        if (j <= 0) {
            return k83.a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.a.c(x30Var), 1);
        cancellableContinuationImpl.initCancellability();
        if (j < Long.MAX_VALUE) {
            getDelay(cancellableContinuationImpl.getContext()).mo150scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        return result == kotlin.coroutines.intrinsics.a.d() ? result : k83.a;
    }

    /* JADX INFO: renamed from: delay-VtjQ1oo, reason: not valid java name */
    public static final Object m81delayVtjQ1oo(long j, x30 x30Var) {
        Object objDelay = delay(m82toDelayMillisLRDsOJo(j), x30Var);
        return objDelay == kotlin.coroutines.intrinsics.a.d() ? objDelay : k83.a;
    }

    public static final Delay getDelay(kotlin.coroutines.d dVar) {
        kotlin.coroutines.d.b bVar = dVar.get(c.E);
        Delay delay = bVar instanceof Delay ? (Delay) bVar : null;
        return delay == null ? DefaultExecutorKt.getDefaultDelay() : delay;
    }

    /* JADX INFO: renamed from: toDelayMillis-LRDsOJo, reason: not valid java name */
    public static final long m82toDelayMillisLRDsOJo(long j) {
        if (be0.d(j, be0.a.b()) > 0) {
            return ga2.c(be0.j(j), 1L);
        }
        return 0L;
    }
}
