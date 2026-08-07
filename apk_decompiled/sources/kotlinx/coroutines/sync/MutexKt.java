package kotlinx.coroutines.sync;

import defpackage.h70;
import defpackage.j21;
import defpackage.x30;
import defpackage.yq0;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes4.dex */
public final class MutexKt {
    private static final int HOLDS_LOCK_ANOTHER_OWNER = 2;
    private static final int HOLDS_LOCK_UNLOCKED = 0;
    private static final int HOLDS_LOCK_YES = 1;
    private static final Symbol NO_OWNER = new Symbol("NO_OWNER");
    private static final Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER = new Symbol("ALREADY_LOCKED_BY_OWNER");
    private static final int TRY_LOCK_ALREADY_LOCKED_BY_OWNER = 2;
    private static final int TRY_LOCK_FAILED = 1;
    private static final int TRY_LOCK_SUCCESS = 0;

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.MutexKt$withLock$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", l = {125}, m = "withLock")
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MutexKt.withLock(null, null, null, this);
        }
    }

    public static final Mutex Mutex(boolean z) {
        return new MutexImpl(z);
    }

    public static /* synthetic */ Mutex Mutex$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Mutex(z);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object withLock(Mutex mutex, Object obj, yq0 yq0Var, x30 x30Var) throws Throwable {
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
            anonymousClass1.L$0 = mutex;
            anonymousClass1.L$1 = obj;
            anonymousClass1.L$2 = yq0Var;
            anonymousClass1.label = 1;
            if (mutex.lock(obj, anonymousClass1) == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            yq0Var = (yq0) anonymousClass1.L$2;
            obj = anonymousClass1.L$1;
            mutex = (Mutex) anonymousClass1.L$0;
            d.b(obj2);
        }
        try {
            return yq0Var.invoke();
        } finally {
            j21.b(1);
            mutex.unlock(obj);
            j21.a(1);
        }
    }

    private static final <T> Object withLock$$forInline(Mutex mutex, Object obj, yq0 yq0Var, x30 x30Var) {
        j21.c(0);
        mutex.lock(obj, x30Var);
        j21.c(1);
        try {
            return yq0Var.invoke();
        } finally {
            j21.b(1);
            mutex.unlock(obj);
            j21.a(1);
        }
    }

    public static /* synthetic */ Object withLock$default(Mutex mutex, Object obj, yq0 yq0Var, x30 x30Var, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        j21.c(0);
        mutex.lock(obj, x30Var);
        j21.c(1);
        try {
            return yq0Var.invoke();
        } finally {
            j21.b(1);
            mutex.unlock(obj);
            j21.a(1);
        }
    }
}
