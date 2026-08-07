package kotlin;

import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static final Object a(Throwable th) {
        p31.f(th, "exception");
        return new Result.Failure(th);
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
