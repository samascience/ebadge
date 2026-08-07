package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.e41;
import defpackage.q33;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@e41
public class TokenBufferDeserializer extends StdScalarDeserializer<q33> {
    private static final long serialVersionUID = 1;

    public TokenBufferDeserializer() {
        super((Class<?>) q33.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    @Override // defpackage.s51
    public q33 deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return deserializationContext.bufferForInputBuffering(jsonParser).S1(jsonParser, deserializationContext);
    }
}
