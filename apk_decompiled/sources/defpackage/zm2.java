package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;

/* JADX INFO: loaded from: classes.dex */
public abstract class zm2 {
    public abstract f71 createKeySerializer(an2 an2Var, JavaType javaType, f71 f71Var);

    public abstract f71 createSerializer(an2 an2Var, JavaType javaType);

    public abstract z63 createTypeSerializer(SerializationConfig serializationConfig, JavaType javaType);

    public abstract zm2 withAdditionalKeySerializers(bn2 bn2Var);

    public abstract zm2 withAdditionalSerializers(bn2 bn2Var);
}
