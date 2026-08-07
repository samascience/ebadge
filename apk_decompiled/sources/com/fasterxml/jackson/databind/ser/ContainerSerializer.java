package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import defpackage.an2;
import defpackage.f71;
import defpackage.z63;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContainerSerializer<T> extends StdSerializer<T> {
    protected ContainerSerializer(Class<T> cls) {
        super(cls);
    }

    protected abstract ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var);

    public abstract f71 getContentSerializer();

    public abstract JavaType getContentType();

    @Deprecated
    protected boolean hasContentTypeAnnotation(an2 an2Var, BeanProperty beanProperty) {
        return false;
    }

    public abstract boolean hasSingleElement(T t);

    /* JADX WARN: Multi-variable type inference failed */
    public ContainerSerializer<?> withValueTypeSerializer(z63 z63Var) {
        return z63Var == null ? this : _withValueTypeSerializer(z63Var);
    }

    protected ContainerSerializer(JavaType javaType) {
        super(javaType);
    }

    protected ContainerSerializer(Class<?> cls, boolean z) {
        super(cls, z);
    }

    protected ContainerSerializer(ContainerSerializer<?> containerSerializer) {
        super(containerSerializer._handledType, false);
    }
}
