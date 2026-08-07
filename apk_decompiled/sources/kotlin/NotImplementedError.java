package kotlin;

import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes4.dex */
public final class NotImplementedError extends Error {
    /* JADX WARN: Multi-variable type inference failed */
    public NotImplementedError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String str) {
        super(str);
        p31.f(str, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i, y70 y70Var) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
