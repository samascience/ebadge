package kotlin.jvm.internal;

import defpackage.g81;
import defpackage.ke2;
import defpackage.q81;
import defpackage.r81;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PropertyReference0 extends PropertyReference implements r81 {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected g81 computeReflected() {
        return ke2.g(this);
    }

    public abstract /* synthetic */ Object get();

    @Override // defpackage.r81
    public Object getDelegate() {
        return ((r81) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public /* bridge */ /* synthetic */ q81.a getGetter() {
        getGetter();
        return null;
    }

    @Override // defpackage.yq0
    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public r81.a getGetter() {
        ((r81) getReflected()).getGetter();
        return null;
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
