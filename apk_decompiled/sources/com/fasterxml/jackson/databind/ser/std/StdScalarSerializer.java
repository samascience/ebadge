package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdScalarSerializer<T> extends StdSerializer<T> {
    protected StdScalarSerializer(Class<T> cls) {
        super(cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        visitStringFormat(y51Var, javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) throws JsonMappingException {
        return createSchemaNode("string", true);
    }

    @Override // defpackage.f71
    public void serializeWithType(T t, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(t, JsonToken.VALUE_STRING));
        serialize(t, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }

    protected StdScalarSerializer(Class<?> cls, boolean z) {
        super(cls);
    }

    protected StdScalarSerializer(StdScalarSerializer<?> stdScalarSerializer) {
        super(stdScalarSerializer);
    }
}
