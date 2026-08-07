package androidx.collection;

import defpackage.ar0;
import defpackage.pk2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class ScatterSet$toString$1 extends Lambda implements ar0 {
    final /* synthetic */ pk2 this$0;

    ScatterSet$toString$1(pk2 pk2Var) {
        super(1);
    }

    @Override // defpackage.ar0
    public final CharSequence invoke(Object obj) {
        return obj == null ? "(this)" : String.valueOf(obj);
    }
}
