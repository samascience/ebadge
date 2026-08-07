package kotlin.sequences;

import defpackage.ar0;
import defpackage.p31;
import defpackage.rm2;
import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$2 extends FunctionReferenceImpl implements ar0 {
    public static final SequencesKt___SequencesKt$flatMapIndexed$2 INSTANCE = new SequencesKt___SequencesKt$flatMapIndexed$2();

    SequencesKt___SequencesKt$flatMapIndexed$2() {
        super(1, rm2.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // defpackage.ar0
    public final Iterator<Object> invoke(rm2 rm2Var) {
        p31.f(rm2Var, "p0");
        return rm2Var.iterator();
    }
}
