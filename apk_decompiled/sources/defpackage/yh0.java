package defpackage;

import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public class yh0 implements vk1 {
    private final Function a;

    public yh0(Function function) {
        this.a = function;
    }

    public static yh0 a() {
        return new yh0(null);
    }

    public static yh0 b() {
        return new yh0(new Function() { // from class: xh0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Enum) obj).name();
            }
        });
    }

    public static yh0 c() {
        return new yh0(new Function() { // from class: wh0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Enum) obj).toString();
            }
        });
    }
}
