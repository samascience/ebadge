package kotlin.jvm.internal;

import defpackage.m81;
import defpackage.q81;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MutablePropertyReference extends PropertyReference implements q81 {
    public MutablePropertyReference() {
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public abstract /* synthetic */ q81.a getGetter();

    public abstract /* synthetic */ m81 getSetter();

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
