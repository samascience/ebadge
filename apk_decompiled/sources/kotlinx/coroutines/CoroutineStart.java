package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.or0;
import defpackage.x30;
import defpackage.y30;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: loaded from: classes4.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            try {
                iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoroutineStart.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void isLazy$annotations() {
    }

    @InternalCoroutinesApi
    public final <T> void invoke(ar0 ar0Var, x30 x30Var) throws Throwable {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            CancellableKt.startCoroutineCancellable(ar0Var, x30Var);
            return;
        }
        if (i == 2) {
            y30.a(ar0Var, x30Var);
        } else if (i == 3) {
            UndispatchedKt.startCoroutineUndispatched(ar0Var, x30Var);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @InternalCoroutinesApi
    public final <R, T> void invoke(or0 or0Var, R r, x30 x30Var) {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            CancellableKt.startCoroutineCancellable$default(or0Var, r, x30Var, null, 4, null);
            return;
        }
        if (i == 2) {
            y30.b(or0Var, r, x30Var);
        } else if (i == 3) {
            UndispatchedKt.startCoroutineUndispatched(or0Var, r, x30Var);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
