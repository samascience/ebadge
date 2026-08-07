package kotlinx.coroutines.debug.internal;

import defpackage.p40;

/* JADX INFO: loaded from: classes4.dex */
public final class StackTraceFrame implements p40 {
    private final p40 callerFrame;
    public final StackTraceElement stackTraceElement;

    public StackTraceFrame(p40 p40Var, StackTraceElement stackTraceElement) {
        this.callerFrame = p40Var;
        this.stackTraceElement = stackTraceElement;
    }

    @Override // defpackage.p40
    public p40 getCallerFrame() {
        return this.callerFrame;
    }

    @Override // defpackage.p40
    public StackTraceElement getStackTraceElement() {
        return this.stackTraceElement;
    }
}
