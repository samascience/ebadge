package defpackage;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes.dex */
public interface l7 {
    Annotation get(Class cls);

    boolean has(Class cls);

    boolean hasOneOf(Class[] clsArr);

    int size();
}
