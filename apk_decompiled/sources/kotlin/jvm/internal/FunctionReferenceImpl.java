package kotlin.jvm.internal;

import defpackage.h81;
import defpackage.i81;
import defpackage.ux;

/* JADX INFO: loaded from: classes4.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i, i81 i81Var, String str, String str2) {
        super(i, CallableReference.NO_RECEIVER, ((ux) i81Var).c(), str, str2, !(i81Var instanceof h81) ? 1 : 0);
    }

    public FunctionReferenceImpl(int i, Class cls, String str, String str2, int i2) {
        super(i, CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    public FunctionReferenceImpl(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(i, obj, cls, str, str2, i2);
    }
}
