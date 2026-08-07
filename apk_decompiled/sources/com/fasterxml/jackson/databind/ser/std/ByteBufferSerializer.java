package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import defpackage.an2;
import defpackage.cp;
import defpackage.y51;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferSerializer extends StdScalarSerializer<ByteBuffer> {
    public ByteBufferSerializer() {
        super(ByteBuffer.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.i(javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(ByteBuffer byteBuffer, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (byteBuffer.hasArray()) {
            int iPosition = byteBuffer.position();
            jsonGenerator.O0(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, byteBuffer.limit() - iPosition);
            return;
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (byteBufferAsReadOnlyBuffer.position() > 0) {
            byteBufferAsReadOnlyBuffer.rewind();
        }
        cp cpVar = new cp(byteBufferAsReadOnlyBuffer);
        jsonGenerator.L0(cpVar, byteBufferAsReadOnlyBuffer.remaining());
        cpVar.close();
    }
}
