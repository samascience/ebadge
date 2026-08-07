package kotlin.jvm.internal;

import defpackage.g81;
import defpackage.ke2;
import defpackage.q81;
import defpackage.t81;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PropertyReference2 extends PropertyReference implements t81 {
    public PropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected g81 computeReflected() {
        return ke2.i(this);
    }

    public abstract /* synthetic */ Object get(Object obj, Object obj2);

    @Override // defpackage.t81
    public Object getDelegate(Object obj, Object obj2) {
        return ((t81) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public /* bridge */ /* synthetic */ q81.a getGetter() {
        getGetter();
        return null;
    }

    @Override // defpackage.or0
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public PropertyReference2(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public t81.a getGetter() {
        ((t81) getReflected()).getGetter();
        return null;
    }
}
