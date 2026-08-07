package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import defpackage.a91;
import defpackage.b91;
import defpackage.cb3;
import defpackage.kh;
import defpackage.m63;
import defpackage.q90;
import defpackage.r1;
import defpackage.s51;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    protected static final q90[] NO_DESERIALIZERS = new q90[0];

    public abstract s51 createArrayDeserializer(DeserializationContext deserializationContext, ArrayType arrayType, kh khVar);

    public abstract s51 createBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException;

    public abstract s51 createBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar, Class<?> cls) throws JsonMappingException;

    public abstract s51 createCollectionDeserializer(DeserializationContext deserializationContext, CollectionType collectionType, kh khVar);

    public abstract s51 createCollectionLikeDeserializer(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, kh khVar);

    public abstract s51 createEnumDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar);

    public abstract a91 createKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType);

    public abstract s51 createMapDeserializer(DeserializationContext deserializationContext, MapType mapType, kh khVar);

    public abstract s51 createMapLikeDeserializer(DeserializationContext deserializationContext, MapLikeType mapLikeType, kh khVar);

    public abstract s51 createReferenceDeserializer(DeserializationContext deserializationContext, ReferenceType referenceType, kh khVar);

    public abstract s51 createTreeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, kh khVar);

    public abstract m63 findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType);

    public abstract JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType);

    public abstract a withAbstractTypeResolver(r1 r1Var);

    public abstract a withAdditionalDeserializers(q90 q90Var);

    public abstract a withAdditionalKeyDeserializers(b91 b91Var);

    public abstract a withValueInstantiators(cb3 cb3Var);
}
