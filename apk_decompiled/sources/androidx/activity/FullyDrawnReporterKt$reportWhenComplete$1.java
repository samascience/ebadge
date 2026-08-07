package androidx.activity;

import defpackage.h70;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {Opcodes.INVOKEINTERFACE}, m = "reportWhenComplete")
final class FullyDrawnReporterKt$reportWhenComplete$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    FullyDrawnReporterKt$reportWhenComplete$1(x30 x30Var) {
        super(x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FullyDrawnReporterKt.a(null, null, this);
    }
}
