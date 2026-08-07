package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class UnsupportedTypeDeserializer extends StdDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final String _message;
    protected final JavaType _type;

    public UnsupportedTypeDeserializer(JavaType javaType, String str) {
        super(javaType);
        this._type = javaType;
        this._message = str;
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objH0;
        if (jsonParser.D() == JsonToken.VALUE_EMBEDDED_OBJECT && ((objH0 = jsonParser.H0()) == null || this._type.getRawClass().isAssignableFrom(objH0.getClass()))) {
            return objH0;
        }
        deserializationContext.reportBadDefinition(this._type, this._message);
        return null;
    }
}
