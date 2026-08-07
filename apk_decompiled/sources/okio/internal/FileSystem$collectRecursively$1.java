package okio.internal;

import defpackage.h70;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: okio.internal.-FileSystem$collectRecursively$1, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
@h70(c = "okio.internal.-FileSystem", f = "FileSystem.kt", l = {116, Opcodes.I2D, Opcodes.I2B}, m = "collectRecursively")
final class FileSystem$collectRecursively$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;

    FileSystem$collectRecursively$1(x30 x30Var) {
        super(x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileSystem.a(null, null, null, null, false, false, this);
    }
}
