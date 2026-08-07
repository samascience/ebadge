package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer;
import defpackage.an2;
import defpackage.jn1;
import defpackage.z63;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class UnknownSerializer extends ToEmptyObjectSerializer {
    public UnknownSerializer() {
        super((Class<?>) Object.class);
    }

    protected void failForEmpty(an2 an2Var, Object obj) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        if (jn1.c(cls)) {
            an2Var.reportBadDefinition(handledType(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS). This appears to be a native image, in which case you may need to configure reflection for the class that is to be serialized", cls.getName()));
        } else {
            an2Var.reportBadDefinition(handledType(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", cls.getName()));
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (an2Var.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            failForEmpty(an2Var, obj);
        }
        super.serialize(obj, jsonGenerator, an2Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer, defpackage.f71
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        if (an2Var.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            failForEmpty(an2Var, obj);
        }
        super.serializeWithType(obj, jsonGenerator, an2Var, z63Var);
    }

    public UnknownSerializer(Class<?> cls) {
        super(cls);
    }
}
