package defpackage;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class ak1 implements vk1 {
    private final Predicate a;

    public ak1(Predicate predicate) {
        this.a = predicate;
    }

    public static ak1 b() {
        return new ak1(new Predicate() { // from class: xj1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                e43.a(obj);
                throw null;
            }
        });
    }

    public static ak1 c() {
        return new ak1(new Predicate() { // from class: zj1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                e43.a(obj);
                return ak1.e(null);
            }
        });
    }

    public static ak1 d() {
        return new ak1(new Predicate() { // from class: yj1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                e43.a(obj);
                throw null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean e(bk1 bk1Var) {
        throw null;
    }
}
