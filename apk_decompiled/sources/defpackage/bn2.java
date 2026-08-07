package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;

/* JADX INFO: loaded from: classes.dex */
public interface bn2 {

    public static class a implements bn2 {
        @Override // defpackage.bn2
        public f71 findReferenceSerializer(SerializationConfig serializationConfig, ReferenceType referenceType, kh khVar, z63 z63Var, f71 f71Var) {
            return findSerializer(serializationConfig, referenceType, khVar);
        }

        @Override // defpackage.bn2
        public abstract f71 findSerializer(SerializationConfig serializationConfig, JavaType javaType, kh khVar);
    }

    f71 findArraySerializer(SerializationConfig serializationConfig, ArrayType arrayType, kh khVar, z63 z63Var, f71 f71Var);

    f71 findCollectionLikeSerializer(SerializationConfig serializationConfig, CollectionLikeType collectionLikeType, kh khVar, z63 z63Var, f71 f71Var);

    f71 findCollectionSerializer(SerializationConfig serializationConfig, CollectionType collectionType, kh khVar, z63 z63Var, f71 f71Var);

    f71 findMapLikeSerializer(SerializationConfig serializationConfig, MapLikeType mapLikeType, kh khVar, f71 f71Var, z63 z63Var, f71 f71Var2);

    f71 findMapSerializer(SerializationConfig serializationConfig, MapType mapType, kh khVar, f71 f71Var, z63 z63Var, f71 f71Var2);

    f71 findReferenceSerializer(SerializationConfig serializationConfig, ReferenceType referenceType, kh khVar, z63 z63Var, f71 f71Var);

    f71 findSerializer(SerializationConfig serializationConfig, JavaType javaType, kh khVar);
}
