package androidx.lifecycle;

import defpackage.ar0;
import defpackage.k83;
import defpackage.wr0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class Transformations$map$2 extends Lambda implements ar0 {
    final /* synthetic */ wr0 $mapFunction;
    final /* synthetic */ i $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Transformations$map$2(i iVar, wr0 wr0Var) {
        super(1);
        this.$result = iVar;
        this.$mapFunction = wr0Var;
    }

    @Override // defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m10invoke(obj);
        return k83.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m10invoke(Object obj) {
        this.$result.o(this.$mapFunction.apply(obj));
    }
}
