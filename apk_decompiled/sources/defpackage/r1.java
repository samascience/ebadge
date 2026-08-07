package defpackage;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;

/* JADX INFO: loaded from: classes.dex */
public abstract class r1 {
    public abstract JavaType findTypeMapping(DeserializationConfig deserializationConfig, JavaType javaType);

    public abstract JavaType resolveAbstractType(DeserializationConfig deserializationConfig, kh khVar);
}
