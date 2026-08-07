package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public abstract class d7 {
    protected d7() {
    }

    public abstract boolean equals(Object obj);

    public abstract AnnotatedElement getAnnotated();

    public abstract Annotation getAnnotation(Class cls);

    protected abstract int getModifiers();

    public abstract String getName();

    public abstract Class<?> getRawType();

    public abstract JavaType getType();

    public abstract boolean hasAnnotation(Class cls);

    public abstract boolean hasOneOf(Class[] clsArr);

    public abstract int hashCode();

    public boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public abstract String toString();
}
