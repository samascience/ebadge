package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class t10 {
    private final hd2 a;

    public t10(hd2 hd2Var) {
        p31.f(hd2Var, "delegate");
        this.a = hd2Var;
    }

    public final hd2 a() {
        return this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t10(int i, long j, TimeUnit timeUnit) {
        this(new hd2(b13.i, i, j, timeUnit));
        p31.f(timeUnit, "timeUnit");
    }

    public t10() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
