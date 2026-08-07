package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.m51;
import defpackage.z63;
import java.io.IOException;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@e41
public class StringCollectionSerializer extends StaticListSerializerBase<Collection<String>> {
    public static final StringCollectionSerializer instance = new StringCollectionSerializer();

    protected StringCollectionSerializer() {
        super(Collection.class);
    }

    private final void serializeContents(Collection<String> collection, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int i = 0;
        try {
            for (String str : collection) {
                if (str == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else {
                    jsonGenerator.w1(str);
                }
                i++;
            }
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, collection, i);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
        return new StringCollectionSerializer(this, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    protected void acceptContentVisitor(m51 m51Var) throws JsonMappingException {
        m51Var.h(JsonFormatTypes.STRING);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    protected JsonNode contentSchema() {
        return createSchemaNode("string", true);
    }

    protected StringCollectionSerializer(StringCollectionSerializer stringCollectionSerializer, Boolean bool) {
        super(stringCollectionSerializer, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Collection<String> collection, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(collection, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.r1(collection, size);
        serializeContents(collection, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase, defpackage.f71
    public void serializeWithType(Collection<String> collection, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(collection, JsonToken.START_ARRAY));
        jsonGenerator.y0(collection);
        serializeContents(collection, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }
}
