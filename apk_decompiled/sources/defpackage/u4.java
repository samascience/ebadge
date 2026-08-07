package defpackage;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes.dex */
public class u4 implements vk1 {
    private final k10 a;
    private final BiFunction b;
    private final BiFunction c;

    public u4(k10 k10Var) {
        this(k10Var, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JsonNode c(ii1 ii1Var, uk2 uk2Var) {
        throw null;
    }

    public static u4 d() {
        return new u4(new r4(), new BiFunction() { // from class: s4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                e43.a(obj);
                e43.a(obj2);
                return u4.c(null, null);
            }
        }, new BiFunction() { // from class: t4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                e43.a(obj);
                e43.a(obj2);
                return u4.c(null, null);
            }
        });
    }

    public static u4 e() {
        return new u4(new r4());
    }

    public u4(k10 k10Var, BiFunction biFunction, BiFunction biFunction2) {
        this.a = k10Var;
        this.b = biFunction;
        this.c = biFunction2;
    }
}
