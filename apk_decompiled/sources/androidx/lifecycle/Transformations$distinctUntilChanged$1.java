package androidx.lifecycle;

import defpackage.ar0;
import defpackage.k83;
import defpackage.p31;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: loaded from: classes.dex */
final class Transformations$distinctUntilChanged$1 extends Lambda implements ar0 {
    final /* synthetic */ Ref$BooleanRef $firstTime;
    final /* synthetic */ i $outputLiveData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Transformations$distinctUntilChanged$1(i iVar, Ref$BooleanRef ref$BooleanRef) {
        super(1);
        this.$outputLiveData = iVar;
        this.$firstTime = ref$BooleanRef;
    }

    @Override // defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m8invoke(obj);
        return k83.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m8invoke(Object obj) {
        Object objF = this.$outputLiveData.f();
        if (this.$firstTime.element || ((objF == null && obj != null) || !(objF == null || p31.a(objF, obj)))) {
            this.$firstTime.element = false;
            this.$outputLiveData.o(obj);
        }
    }
}
