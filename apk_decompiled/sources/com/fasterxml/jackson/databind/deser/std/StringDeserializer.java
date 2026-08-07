package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.tencent.connect.common.Constants;
import defpackage.e41;
import defpackage.m63;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@e41
public class StringDeserializer extends StdScalarDeserializer<String> {
    public static final StringDeserializer instance = new StringDeserializer();
    private static final long serialVersionUID = 1;

    public StringDeserializer() {
        super((Class<?>) String.class);
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return Constants.STR_EMPTY;
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Textual;
    }

    @Override // defpackage.s51
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.d1(JsonToken.VALUE_STRING)) {
            return jsonParser.S0();
        }
        return jsonParser.d1(JsonToken.START_ARRAY) ? _deserializeFromArray(jsonParser, deserializationContext) : _parseString(jsonParser, deserializationContext, this);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public String deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return deserialize(jsonParser, deserializationContext);
    }
}
