package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
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
public class ByteArraySerializer extends StdSerializer<byte[]> {
    private static final long serialVersionUID = 1;

    public ByteArraySerializer() {
        super(byte[].class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.i(javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        return createSchemaNode("array", true).set("items", createSchemaNode("byte"));
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, byte[] bArr) {
        return bArr.length == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(byte[] bArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.M0(an2Var.getConfig().getBase64Variant(), bArr, 0, bArr.length);
    }

    @Override // defpackage.f71
    public void serializeWithType(byte[] bArr, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(bArr, JsonToken.VALUE_EMBEDDED_OBJECT));
        jsonGenerator.M0(an2Var.getConfig().getBase64Variant(), bArr, 0, bArr.length);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }
}
