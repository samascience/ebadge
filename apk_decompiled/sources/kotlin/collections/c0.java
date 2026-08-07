package kotlin.collections;

import defpackage.p31;
import java.util.Collections;
import java.util.Set;
import kotlin.collections.builders.SetBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c0 {
    public static Set a(Set set) {
        p31.f(set, "builder");
        return ((SetBuilder) set).build();
    }

    public static Set b(int i) {
        return new SetBuilder(i);
    }

    public static Set c(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        p31.e(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
