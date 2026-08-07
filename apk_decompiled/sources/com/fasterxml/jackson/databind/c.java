package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import defpackage.b91;
import defpackage.bn2;
import defpackage.cb3;
import defpackage.q90;
import defpackage.r1;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public interface a {
        void a(b91 b91Var);

        void b(cb3 cb3Var);

        void c(NamedType... namedTypeArr);

        void d(bn2 bn2Var);

        void e(r1 r1Var);

        void f(bn2 bn2Var);

        void g(q90 q90Var);

        void h(PropertyNamingStrategy propertyNamingStrategy);

        void i(Class cls, Class cls2);
    }

    public Iterable<? extends c> getDependencies() {
        return Collections.emptyList();
    }

    public abstract String getModuleName();

    public Object getTypeId() {
        return getClass().getName();
    }

    public abstract void setupModule(a aVar);

    public abstract Version version();
}
