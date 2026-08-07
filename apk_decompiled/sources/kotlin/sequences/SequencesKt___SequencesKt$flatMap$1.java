package kotlin.sequences;

import defpackage.ar0;
import defpackage.p31;
import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class SequencesKt___SequencesKt$flatMap$1 extends FunctionReferenceImpl implements ar0 {
    public static final SequencesKt___SequencesKt$flatMap$1 INSTANCE = new SequencesKt___SequencesKt$flatMap$1();

    SequencesKt___SequencesKt$flatMap$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // defpackage.ar0
    public final Iterator<Object> invoke(Iterable<Object> iterable) {
        p31.f(iterable, "p0");
        return iterable.iterator();
    }
}
