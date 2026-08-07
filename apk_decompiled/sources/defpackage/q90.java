package defpackage;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;

/* JADX INFO: loaded from: classes.dex */
public interface q90 {

    public static abstract class a implements q90 {
    }

    s51 findArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var);

    s51 findBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, kh khVar);

    s51 findCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var);

    s51 findCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var);

    s51 findEnumDeserializer(Class cls, DeserializationConfig deserializationConfig, kh khVar);

    s51 findMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, kh khVar, a91 a91Var, m63 m63Var, s51 s51Var);

    s51 findMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, kh khVar, a91 a91Var, m63 m63Var, s51 s51Var);

    s51 findReferenceDeserializer(ReferenceType referenceType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var);

    s51 findTreeNodeDeserializer(Class cls, DeserializationConfig deserializationConfig, kh khVar);
}
