package kotlin.jvm.internal;

import defpackage.g81;
import defpackage.ke2;
import defpackage.q81;
import defpackage.s81;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PropertyReference1 extends PropertyReference implements s81 {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected g81 computeReflected() {
        return ke2.h(this);
    }

    public abstract /* synthetic */ Object get(Object obj);

    @Override // defpackage.s81
    public Object getDelegate(Object obj) {
        return ((s81) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public /* bridge */ /* synthetic */ q81.a getGetter() {
        getGetter();
        return null;
    }

    @Override // defpackage.ar0
    public Object invoke(Object obj) {
        return get(obj);
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public s81.a getGetter() {
        ((s81) getReflected()).getGetter();
        return null;
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
