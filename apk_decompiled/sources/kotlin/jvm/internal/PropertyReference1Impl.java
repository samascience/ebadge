package kotlin.jvm.internal;

import defpackage.h81;
import defpackage.i81;
import defpackage.ux;

/* JADX INFO: loaded from: classes4.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(i81 i81Var, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((ux) i81Var).c(), str, str2, !(i81Var instanceof h81) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1
    public Object get(Object obj) {
        getGetter();
        throw null;
    }

    public PropertyReference1Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    public PropertyReference1Impl(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
