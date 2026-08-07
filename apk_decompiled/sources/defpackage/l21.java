package defpackage;

import java.util.ArrayDeque;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class l21 implements vk1 {
    private final ThreadLocal a = ThreadLocal.withInitial(new Supplier() { // from class: k21
        @Override // java.util.function.Supplier
        public final Object get() {
            return new ArrayDeque();
        }
    });
}
