package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.e41;
import defpackage.q33;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
@e41
public class TokenBufferSerializer extends StdSerializer<q33> {
    public TokenBufferSerializer() {
        super(q33.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.e(javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        return createSchemaNode("any", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(q33 q33Var, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        q33Var.X1(jsonGenerator);
    }

    @Override // defpackage.f71
    public final void serializeWithType(q33 q33Var, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(q33Var, JsonToken.VALUE_EMBEDDED_OBJECT));
        serialize(q33Var, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }
}
