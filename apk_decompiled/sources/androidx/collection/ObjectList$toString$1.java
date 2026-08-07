package androidx.collection;

import defpackage.ar0;
import defpackage.ot1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class ObjectList$toString$1 extends Lambda implements ar0 {
    final /* synthetic */ ot1 this$0;

    ObjectList$toString$1(ot1 ot1Var) {
        super(1);
    }

    @Override // defpackage.ar0
    public final CharSequence invoke(Object obj) {
        return obj == null ? "(this)" : String.valueOf(obj);
    }
}
