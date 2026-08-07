package defpackage;

import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
final class kn1 implements Comparator {
    public static final kn1 a = new kn1();

    private kn1() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        p31.f(comparable, "a");
        p31.f(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return uh2.a;
    }
}
