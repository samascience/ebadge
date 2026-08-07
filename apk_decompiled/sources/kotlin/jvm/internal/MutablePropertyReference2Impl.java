package kotlin.jvm.internal;

import defpackage.h81;
import defpackage.i81;
import defpackage.ux;

/* JADX INFO: loaded from: classes4.dex */
public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(i81 i81Var, String str, String str2) {
        super(((ux) i81Var).c(), str, str2, !(i81Var instanceof h81) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference2
    public Object get(Object obj, Object obj2) {
        getGetter();
        throw null;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference2
    public void set(Object obj, Object obj2, Object obj3) {
        getSetter();
        throw null;
    }

    public MutablePropertyReference2Impl(Class cls, String str, String str2, int i) {
        super(cls, str, str2, i);
    }
}
