package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import defpackage.an2;
import defpackage.e41;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
@e41
public class SqlBlobSerializer extends StdScalarSerializer<Blob> {
    public SqlBlobSerializer() {
        super(Blob.class);
    }

    protected void _writeValue(Blob blob, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        InputStream binaryStream;
        try {
            binaryStream = blob.getBinaryStream();
        } catch (SQLException e) {
            an2Var.reportMappingProblem(e, "Failed to access `java.sql.Blob` value to write as binary value", new Object[0]);
            binaryStream = null;
        }
        jsonGenerator.K0(an2Var.getConfig().getBase64Variant(), binaryStream, -1);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.i(javaType);
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Blob blob) {
        return blob == null;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Blob blob, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        _writeValue(blob, jsonGenerator, an2Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, defpackage.f71
    public void serializeWithType(Blob blob, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(blob, JsonToken.VALUE_EMBEDDED_OBJECT));
        _writeValue(blob, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }
}
