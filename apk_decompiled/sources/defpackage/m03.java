package defpackage;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.w;

/* JADX INFO: loaded from: classes.dex */
public interface m03 extends w {
    public static final Config.a b = Config.a.a("camerax.core.target.name", String.class);
    public static final Config.a c = Config.a.a("camerax.core.target.class", Class.class);

    default String C(String str) {
        return (String) f(b, str);
    }

    default String K() {
        return (String) a(b);
    }
}
