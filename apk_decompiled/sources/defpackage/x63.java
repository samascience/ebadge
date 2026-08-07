package defpackage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public interface x63 {
    m63 buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection collection);

    z63 buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection collection);

    x63 defaultImpl(Class cls);

    Class getDefaultImpl();

    x63 inclusion(JsonTypeInfo.As as);

    x63 init(JsonTypeInfo.Id id, n63 n63Var);

    x63 typeIdVisibility(boolean z);

    x63 typeProperty(String str);

    x63 withDefaultImpl(Class cls);
}
