package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.e41;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
@e41
public class ToEmptyObjectSerializer extends StdSerializer<Object> {
    protected ToEmptyObjectSerializer(Class<?> cls) {
        super(cls, false);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.j(javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) throws JsonMappingException {
        return null;
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Object obj) {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.u1(obj, 0);
        jsonGenerator.S0();
    }

    @Override // defpackage.f71
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        z63Var.h(jsonGenerator, z63Var.g(jsonGenerator, z63Var.d(obj, JsonToken.START_OBJECT)));
    }

    public ToEmptyObjectSerializer(JavaType javaType) {
        super(javaType);
    }
}
