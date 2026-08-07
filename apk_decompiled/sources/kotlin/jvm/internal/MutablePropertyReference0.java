package kotlin.jvm.internal;

import defpackage.g81;
import defpackage.ke2;
import defpackage.m81;
import defpackage.n81;
import defpackage.q81;
import defpackage.r81;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements n81 {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected g81 computeReflected() {
        return ke2.d(this);
    }

    public abstract /* synthetic */ Object get();

    @Override // defpackage.r81
    public Object getDelegate() {
        return ((n81) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public /* bridge */ /* synthetic */ q81.a getGetter() {
        getGetter();
        return null;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public /* bridge */ /* synthetic */ m81 getSetter() {
        getSetter();
        return null;
    }

    @Override // defpackage.yq0
    public Object invoke() {
        return get();
    }

    public abstract /* synthetic */ void set(Object obj);

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public r81.a getGetter() {
        ((n81) getReflected()).getGetter();
        return null;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public n81.a getSetter() {
        ((n81) getReflected()).getSetter();
        return null;
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
