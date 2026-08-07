package defpackage;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class tl0 implements vk1 {
    private final Predicate a;

    public tl0(Predicate predicate) {
        this.a = predicate;
    }

    public static tl0 d() {
        return new tl0(new Predicate() { // from class: rl0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                e43.a(obj);
                return tl0.h(null);
            }
        });
    }

    public static tl0 e() {
        return new tl0(new Predicate() { // from class: ql0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                e43.a(obj);
                return tl0.i(null);
            }
        });
    }

    public static tl0 f() {
        return new tl0(new Predicate() { // from class: pl0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                e43.a(obj);
                return tl0.j(null);
            }
        });
    }

    public static tl0 g() {
        return new tl0(new Predicate() { // from class: sl0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                e43.a(obj);
                throw null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean h(vl0 vl0Var) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean i(vl0 vl0Var) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean j(vl0 vl0Var) {
        throw null;
    }
}
