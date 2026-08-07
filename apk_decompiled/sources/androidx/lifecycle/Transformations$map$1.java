package androidx.lifecycle;

import defpackage.ar0;
import defpackage.k83;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class Transformations$map$1 extends Lambda implements ar0 {
    final /* synthetic */ i $result;
    final /* synthetic */ ar0 $transform;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Transformations$map$1(i iVar, ar0 ar0Var) {
        super(1);
        this.$result = iVar;
        this.$transform = ar0Var;
    }

    @Override // defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m9invoke(obj);
        return k83.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9invoke(Object obj) {
        this.$result.o(this.$transform.invoke(obj));
    }
}
