package kotlinx.coroutines.flow.internal;

import defpackage.p40;
import defpackage.x30;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
final class StackFrameContinuation<T> implements x30, p40 {
    private final d context;
    private final x30 uCont;

    public StackFrameContinuation(x30 x30Var, d dVar) {
        this.uCont = x30Var;
        this.context = dVar;
    }

    @Override // defpackage.p40
    public p40 getCallerFrame() {
        x30 x30Var = this.uCont;
        if (x30Var instanceof p40) {
            return (p40) x30Var;
        }
        return null;
    }

    @Override // defpackage.x30
    public d getContext() {
        return this.context;
    }

    @Override // defpackage.p40
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // defpackage.x30
    public void resumeWith(Object obj) {
        this.uCont.resumeWith(obj);
    }
}
