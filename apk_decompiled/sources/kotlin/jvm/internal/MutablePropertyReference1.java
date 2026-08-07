package kotlin.jvm.internal;

import defpackage.g81;
import defpackage.ke2;
import defpackage.m81;
import defpackage.o81;
import defpackage.q81;
import defpackage.s81;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements o81 {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected g81 computeReflected() {
        return ke2.e(this);
    }

    public abstract /* synthetic */ Object get(Object obj);

    @Override // defpackage.s81
    public Object getDelegate(Object obj) {
        return ((o81) getReflected()).getDelegate(obj);
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

    @Override // defpackage.ar0
    public Object invoke(Object obj) {
        return get(obj);
    }

    public abstract /* synthetic */ void set(Object obj, Object obj2);

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public s81.a getGetter() {
        ((o81) getReflected()).getGetter();
        return null;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public o81.a getSetter() {
        ((o81) getReflected()).getSetter();
        return null;
    }

    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
