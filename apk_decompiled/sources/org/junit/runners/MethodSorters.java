package org.junit.runners;

import defpackage.ck1;
import java.lang.reflect.Method;
import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public enum MethodSorters {
    NAME_ASCENDING(ck1.b),
    JVM(null),
    DEFAULT(ck1.a);

    private final Comparator<Method> comparator;

    MethodSorters(Comparator comparator) {
        this.comparator = comparator;
    }

    public Comparator<Method> getComparator() {
        return this.comparator;
    }
}
