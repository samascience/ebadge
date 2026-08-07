package androidx.camera.core.impl;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface w extends Config {
    @Override // androidx.camera.core.impl.Config
    default Object a(Config.a aVar) {
        return n().a(aVar);
    }

    @Override // androidx.camera.core.impl.Config
    default boolean b(Config.a aVar) {
        return n().b(aVar);
    }

    @Override // androidx.camera.core.impl.Config
    default void c(String str, Config.b bVar) {
        n().c(str, bVar);
    }

    @Override // androidx.camera.core.impl.Config
    default Object d(Config.a aVar, Config.OptionPriority optionPriority) {
        return n().d(aVar, optionPriority);
    }

    @Override // androidx.camera.core.impl.Config
    default Set e() {
        return n().e();
    }

    @Override // androidx.camera.core.impl.Config
    default Object f(Config.a aVar, Object obj) {
        return n().f(aVar, obj);
    }

    @Override // androidx.camera.core.impl.Config
    default Config.OptionPriority g(Config.a aVar) {
        return n().g(aVar);
    }

    @Override // androidx.camera.core.impl.Config
    default Set h(Config.a aVar) {
        return n().h(aVar);
    }

    Config n();
}
