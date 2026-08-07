package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ol0 {
    private final Field a;

    public ol0(Field field) {
        Objects.requireNonNull(field);
        this.a = field;
    }

    public Annotation a(Class cls) {
        return this.a.getAnnotation(cls);
    }

    public String toString() {
        return this.a.toString();
    }
}
