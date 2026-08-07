package androidx.camera.core.impl;

import defpackage.wf2;
import defpackage.xf2;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface Config {

    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        HIGH_PRIORITY_REQUIRED,
        REQUIRED,
        OPTIONAL
    }

    public static abstract class a {
        a() {
        }

        public static a a(String str, Class cls) {
            return b(str, cls, null);
        }

        public static a b(String str, Class cls, Object obj) {
            return new c(str, cls, obj);
        }

        public abstract String c();

        public abstract Object d();

        public abstract Class e();
    }

    public interface b {
        boolean a(a aVar);
    }

    static Config I(Config config, Config config2) {
        if (config == null && config2 == null) {
            return u.Z();
        }
        t tVarD0 = config2 != null ? t.d0(config2) : t.c0();
        if (config != null) {
            Iterator it = config.e().iterator();
            while (it.hasNext()) {
                W(tVarD0, config2, config, (a) it.next());
            }
        }
        return u.a0(tVarD0);
    }

    static boolean M(OptionPriority optionPriority, OptionPriority optionPriority2) {
        OptionPriority optionPriority3 = OptionPriority.REQUIRED;
        return optionPriority == optionPriority3 && optionPriority2 == optionPriority3;
    }

    static void W(t tVar, Config config, Config config2, a aVar) {
        if (!Objects.equals(aVar, r.v)) {
            tVar.s(aVar, config2.g(aVar), config2.a(aVar));
            return;
        }
        wf2 wf2Var = (wf2) config2.f(aVar, null);
        tVar.s(aVar, config2.g(aVar), xf2.a((wf2) config.f(aVar, null), wf2Var));
    }

    Object a(a aVar);

    boolean b(a aVar);

    void c(String str, b bVar);

    Object d(a aVar, OptionPriority optionPriority);

    Set e();

    Object f(a aVar, Object obj);

    OptionPriority g(a aVar);

    Set h(a aVar);
}
