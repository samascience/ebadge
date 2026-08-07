package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.y51;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class FileSerializer extends StdScalarSerializer<File> {
    public FileSerializer() {
        super(File.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        visitStringFormat(y51Var, javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        return createSchemaNode("string", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(File file, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.w1(file.getAbsolutePath());
    }
}
