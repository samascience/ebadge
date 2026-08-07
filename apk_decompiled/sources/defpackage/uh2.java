package defpackage;

import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
final class uh2 implements Comparator {
    public static final uh2 a = new uh2();

    private uh2() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        p31.f(comparable, "a");
        p31.f(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return kn1.a;
    }
}
