package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import defpackage.m63;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class NullifyingDeserializer extends StdDeserializer<Object> {
    public static final NullifyingDeserializer instance = new NullifyingDeserializer();
    private static final long serialVersionUID = 1;

    public NullifyingDeserializer() {
        super((Class<?>) Object.class);
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.d1(JsonToken.FIELD_NAME)) {
            jsonParser.v1();
            return null;
        }
        while (true) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            if (jsonTokenN1 == null || jsonTokenN1 == JsonToken.END_OBJECT) {
                return null;
            }
            jsonParser.v1();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        int iV = jsonParser.V();
        if (iV == 1 || iV == 3 || iV == 5) {
            return m63Var.deserializeTypedFromAny(jsonParser, deserializationContext);
        }
        return null;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.FALSE;
    }
}
