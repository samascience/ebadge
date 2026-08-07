package kotlin.jvm.internal;

import defpackage.g81;
import defpackage.ke2;
import defpackage.m81;
import defpackage.p81;
import defpackage.q81;
import defpackage.t81;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements p81 {
    public MutablePropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected g81 computeReflected() {
        return ke2.f(this);
    }

    public abstract /* synthetic */ Object get(Object obj, Object obj2);

    @Override // defpackage.t81
    public Object getDelegate(Object obj, Object obj2) {
        return ((p81) getReflected()).getDelegate(obj, obj2);
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

    @Override // defpackage.or0
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public abstract /* synthetic */ void set(Object obj, Object obj2, Object obj3);

    public MutablePropertyReference2(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public t81.a getGetter() {
        ((p81) getReflected()).getGetter();
        return null;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public p81.a getSetter() {
        ((p81) getReflected()).getSetter();
        return null;
    }
}
