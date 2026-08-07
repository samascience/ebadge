package kotlin.jvm.internal;

import defpackage.i81;
import defpackage.sc1;
import kotlin.KotlinNothingValueException;

/* JADX INFO: loaded from: classes4.dex */
public class LocalVariableReference extends PropertyReference0 {
    @Override // kotlin.jvm.internal.PropertyReference0
    public Object get() {
        sc1.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public i81 getOwner() {
        sc1.b();
        throw new KotlinNothingValueException();
    }
}
