package kotlin.jvm.internal;

import defpackage.ke2;
import defpackage.p31;
import defpackage.yr0;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Lambda<R> implements yr0, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // defpackage.yr0
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strK = ke2.k(this);
        p31.e(strK, "renderLambdaToString(...)");
        return strK;
    }
}
