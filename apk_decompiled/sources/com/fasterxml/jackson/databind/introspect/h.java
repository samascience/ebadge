package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import defpackage.kh;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    public interface a {
        a copy();

        Class findMixInClassFor(Class cls);
    }

    protected h() {
    }

    public abstract h copy();

    public abstract kh forClassAnnotations(MapperConfig mapperConfig, JavaType javaType, a aVar);

    public abstract kh forCreation(DeserializationConfig deserializationConfig, JavaType javaType, a aVar);

    public abstract kh forDeserialization(DeserializationConfig deserializationConfig, JavaType javaType, a aVar);

    public abstract kh forDeserializationWithBuilder(DeserializationConfig deserializationConfig, JavaType javaType, a aVar);

    public abstract kh forDeserializationWithBuilder(DeserializationConfig deserializationConfig, JavaType javaType, a aVar, kh khVar);

    public abstract kh forDirectClassAnnotations(MapperConfig mapperConfig, JavaType javaType, a aVar);

    public abstract kh forSerialization(SerializationConfig serializationConfig, JavaType javaType, a aVar);
}
