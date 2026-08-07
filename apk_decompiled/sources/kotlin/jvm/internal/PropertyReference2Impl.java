package kotlin.jvm.internal;

import defpackage.h81;
import defpackage.i81;
import defpackage.ux;

/* JADX INFO: loaded from: classes4.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(i81 i81Var, String str, String str2) {
        super(((ux) i81Var).c(), str, str2, !(i81Var instanceof h81) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference2
    public Object get(Object obj, Object obj2) {
        getGetter();
        throw null;
    }

    public PropertyReference2Impl(Class cls, String str, String str2, int i) {
        super(cls, str, str2, i);
    }
}
