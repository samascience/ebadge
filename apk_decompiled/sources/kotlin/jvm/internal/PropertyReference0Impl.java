package kotlin.jvm.internal;

import defpackage.h81;
import defpackage.i81;
import defpackage.ux;

/* JADX INFO: loaded from: classes4.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(i81 i81Var, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((ux) i81Var).c(), str, str2, !(i81Var instanceof h81) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0
    public Object get() {
        getGetter();
        throw null;
    }

    public PropertyReference0Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
