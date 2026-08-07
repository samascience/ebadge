package androidx.lifecycle;

import defpackage.ar0;
import defpackage.k83;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class Transformations$switchMap$2$onChanged$1 extends Lambda implements ar0 {
    final /* synthetic */ i $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Transformations$switchMap$2$onChanged$1(i iVar) {
        super(1);
        this.$result = iVar;
    }

    @Override // defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m12invoke(obj);
        return k83.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m12invoke(Object obj) {
        this.$result.o(obj);
    }
}
