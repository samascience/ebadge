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
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@e41
public final class IndexedStringListSerializer extends StaticListSerializerBase<List<String>> {
    public static final IndexedStringListSerializer instance = new IndexedStringListSerializer();
    private static final long serialVersionUID = 1;

    protected IndexedStringListSerializer() {
        super(List.class);
    }

    private final void serializeContents(List<String> list, JsonGenerator jsonGenerator, an2 an2Var, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                String str = list.get(i2);
                if (str == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else {
                    jsonGenerator.w1(str);
                }
            } catch (Exception e) {
                wrapAndThrow(an2Var, e, list, i2);
                return;
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
        return new IndexedStringListSerializer(this, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    protected void acceptContentVisitor(m51 m51Var) throws JsonMappingException {
        m51Var.h(JsonFormatTypes.STRING);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    protected JsonNode contentSchema() {
        return createSchemaNode("string", true);
    }

    public IndexedStringListSerializer(IndexedStringListSerializer indexedStringListSerializer, Boolean bool) {
        super(indexedStringListSerializer, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(List<String> list, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(list, jsonGenerator, an2Var, 1);
            return;
        }
        jsonGenerator.r1(list, size);
        serializeContents(list, jsonGenerator, an2Var, size);
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    public void serializeWithType(List<String> list, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(list, JsonToken.START_ARRAY));
        jsonGenerator.y0(list);
        serializeContents(list, jsonGenerator, an2Var, list.size());
        z63Var.h(jsonGenerator, writableTypeIdG);
    }
}
